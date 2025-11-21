package com.pfm.expense_service.service.impl;

import com.pfm.expense_service.dao.ExpensesServiceDao;
import com.pfm.expense_service.feign.BudugetService;
import com.pfm.expense_service.feign.NotificationFeignClient;
import com.pfm.expense_service.feign.UserFeignClient;
import com.pfm.expense_service.model.Expense;
import com.pfm.expense_service.model.dto.ExpenseDto;
import com.pfm.expense_service.model.dto.NotificationDto;
import com.pfm.expense_service.service.ExpensesService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class ExpensesServiceImpl implements ExpensesService {

    @Autowired
    ExpensesServiceDao expensesServiceDao;

    @Autowired
    UserFeignClient userFeignClient;

    @Autowired
    NotificationFeignClient notificationFeignClient;

    @Autowired
    BudugetService budugetService;


    private static final String notify = "exemplification";


    @Override
    public Expense createExpenses(ExpenseDto expenses) {
        Map<String, Object> user;
        Integer userid;
        Map<String, Object> userbuduget;
        NotificationDto notificationDto = new NotificationDto();
        try {
            user = userFeignClient.getUser(expenses.getUserId());
            userid = (Integer) user.get("id");
            if (user.isEmpty()) {
                throw new RuntimeException("User not found with ID " + expenses.getUserId());
            }
        } catch (Exception ex) {
            throw new RuntimeException("User not found with ID: " + expenses.getUserId());
        }

        try {
            userbuduget = budugetService.getUserBudget(userid.longValue());
            if (user == null || user.isEmpty()) {
                throw new RuntimeException("User not found with ID " + expenses.getUserId());
            }
        } catch (Exception ex) {
            throw new RuntimeException("User not found with ID: " + expenses.getUserId());
        }

        Expense expense = new Expense();
        expense.setCreatedAt(expense.getCreatedAt());

        Integer getAmount = (Integer) userbuduget.get("amount");
        if (expense.getAmount() > getAmount) {

            notificationDto.setUserId(userid.longValue());
            notificationDto.setAmount(expense.getAmount());
            notificationDto.setMsg("expense is greater than budget increase your budget");
            notifyWithFallback(notificationDto);

        }

        expense.setAmount(expense.getAmount());
        expense.setCategory(expense.getCategory());
        expense.setUserId(userid.longValue());
        expense.setDescription(expense.getDescription());
        expensesServiceDao.createExpenses(expense);
        notificationDto.setUserId(userid.longValue());
        notificationDto.setAmount(expense.getAmount());
        notificationDto.setCategory(expense.getCategory());
        notificationDto.setDesc(expense.getDescription());
        notificationDto.setMsg("expense create successfully ..");

        notifyWithFallback(notificationDto);
        return expense;
    }

    @CircuitBreaker(name = notify, fallbackMethod = "notifyFallback")
    private void notifyWithFallback(NotificationDto resp) {
        notificationFeignClient.createNotification(resp);
    }


    @Override
    public Expense getExpenses(Long id) {

        return expensesServiceDao.getExpenses(id);
    }
}
