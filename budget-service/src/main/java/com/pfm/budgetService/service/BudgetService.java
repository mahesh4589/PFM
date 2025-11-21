package com.pfm.budgetService.service;

import com.pfm.budgetService.model.Budget;
import com.pfm.budgetService.model.dto.BudgetDto;

import java.util.List;

public interface BudgetService {
    Budget createBudget(BudgetDto budgetDto);

    Budget getBudgetById(Long id);

    List<Budget> getAllBudget();

    List<Budget> getUserBudgetRecord(long userId);

    boolean updateBudgetRecord(Long id, BudgetDto budgetDto);


    BudgetDto summary(Long userId, String category);
}
