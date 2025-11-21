package com.pfm.expense_service.service.impl;

import com.pfm.expense_service.dao.ExpensesServiceDao;
import com.pfm.expense_service.feign.NotificationFeignClient;
import com.pfm.expense_service.model.Expense;
import com.pfm.expense_service.model.dto.ExpenseDto;
import com.pfm.expense_service.model.dto.NotificationDto;
import com.pfm.expense_service.service.ExpensesService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ExpensesServiceImpl implements ExpensesService {

    @Autowired
    private ExpensesServiceDao expensesServiceDao;

    @Autowired
    private NotificationFeignClient notificationFeignClient;

    private static final String NOTIFY_CB = "expenseCircuitBreaker";

    @Override
    public Expense createExpenses(ExpenseDto dto) {

        // 1. Save Expense
        Expense expense = new Expense();
        expense.setUserId(dto.getUserId());
        expense.setCategory(dto.getCategory());
        expense.setAmount(dto.getAmount());
        expense.setDescription(dto.getDescription());
        expense.setCreatedAt(LocalDateTime.now());
        expensesServiceDao.createExpenses(expense);

        // 2. Notify after save
        NotificationDto notificationDto = new NotificationDto();
        notificationDto.setUserId(dto.getUserId());
        notificationDto.setCategory(dto.getCategory());
        notificationDto.setAmount(dto.getAmount());
        notificationDto.setDesc(dto.getDescription());
        notificationDto.setMsg("Expense created successfully.");

        notifyWithFallback(notificationDto);

        return expense;
    }

    @CircuitBreaker(name = NOTIFY_CB, fallbackMethod = "notifyFallback")
    private void notifyWithFallback(NotificationDto dto) {
        notificationFeignClient.createNotification(dto);
    }

    // fallback
    private void notifyFallback(NotificationDto dto, Exception ex) {
        System.out.println("Notification failed - stored for retry: " + ex.getMessage());
        // You can store this notification to DB / Kafka for retry
    }

    @Override
    public Expense getExpenses(Long id) {
        return expensesServiceDao.getExpenses(id);
    }
}
