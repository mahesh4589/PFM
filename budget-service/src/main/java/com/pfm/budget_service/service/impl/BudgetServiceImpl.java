package com.pfm.budget_service.service.impl;

import com.pfm.budget_service.dao.BudgetServiceDao;
import com.pfm.budget_service.model.Budget;
import com.pfm.budget_service.model.dto.BudgetDto;
import com.pfm.budget_service.model.dto.ResponceDto;
import com.pfm.budget_service.service.BudgetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BudgetServiceImpl implements BudgetService {

    @Autowired
    BudgetServiceDao budgetServiceDao;

    @Autowired
    NotificationClient notificationClient;

    @Override
    public boolean createBudget(BudgetDto budgetDto) {
        Budget b = new Budget();
        b.setAmountLimit(budgetDto.getAmountLimit());
        b.setCategory(budgetDto.getCategory());
        b.setEndDate(budgetDto.getEndDate());
        b.setUserId(budgetDto.getUserId());
        b.setStartDate(budgetDto.getStartDate());
        boolean resp = budgetServiceDao.createBudget(b);
        if (resp == true) {
            notificationClient.sendBudgetCreatedNotification(budgetDto);
            return true;
        } else {
            System.out.println("notification service not call..");
            return false;
        }

    }

    @Override
    public Budget getBudgetById(Long id) {
        Budget b = budgetServiceDao.getBudgetById(id);
        return b;
    }

    @Override
    public List<Budget> getAllBudget() {
        List<Budget> listbudge = budgetServiceDao.getAllBudget();
        return listbudge;
    }

    @Override
    public List<Budget> getUserBudgetRecord(long userId) {
        List<Budget> record = budgetServiceDao.getUserBudgetRecord(userId);
        return record;
    }

    @Override
    public boolean updateBudgetRecord(Long id, BudgetDto budgetDto) {
        Budget budget = budgetServiceDao.getBudgetById(id);
        if (budget == null) {
            throw new RuntimeException(" budget Id record not found..");
        }
        budget.setAmountLimit(budgetDto.getAmountLimit());
        budget.setCategory(budgetDto.getCategory());
        budget.setEndDate(budgetDto.getEndDate());
        budget.setUserId(budgetDto.getUserId());
        budget.setStartDate(budgetDto.getStartDate());
        boolean resp = budgetServiceDao.updateBudgetRecord(budget);
        if (resp == true) {
            notificationClient.sendBudgetCreatedNotification(budgetDto);
            return true;
        } else {
            System.out.println("notification service not call..");
            return false;
        }

    }

    @Override
    public BudgetDto summary(Long userId, String category) {

        Budget budgetOpt = budgetServiceDao.findByUserIdAndCategory(userId, category);
        ResponceDto d = new ResponceDto();
        //   Budget b = budgetOpt.get();
        // totalSpent calculation will be done by expense-service in real flow. For convenience, we just return budget details.
      /*  Map<String, Object> resp = new HashMap<>();
        resp.put("budget", budgetOpt);
        // totalSpent should be obtained from expense-service; for decoupling return placeholder 0.
        resp.put("totalSpent", BigDecimal.ZERO);*/
        BudgetDto b = new BudgetDto();
        b.setCategory(budgetOpt.getCategory());
        b.setAmountLimit(budgetOpt.getAmountLimit());
        b.setUserId(budgetOpt.getUserId());
        b.setStartDate(budgetOpt.getStartDate());
        b.setEndDate(budgetOpt.getEndDate());

        return b;
    }
}
