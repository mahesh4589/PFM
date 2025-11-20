package com.pfm.budget_service.service;

import com.pfm.budget_service.model.Budget;
import com.pfm.budget_service.model.dto.BudgetDto;

import java.util.List;

public interface BudgetService {
    boolean createBudget(BudgetDto budgetDto);

    Budget getBudgetById(Long id);

    List<Budget> getAllBudget();

    List<Budget> getUserBudgetRecord(long userId);

    boolean updateBudgetRecord(Long id, BudgetDto budgetDto);


    BudgetDto summary(Long userId, String category);
}
