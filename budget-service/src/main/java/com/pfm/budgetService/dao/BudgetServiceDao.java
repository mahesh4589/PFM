package com.pfm.budgetService.dao;

import com.pfm.budgetService.model.Budget;


import java.util.List;

public interface BudgetServiceDao {
    Budget createBudget(Budget b);

    Budget getBudgetById(Long id);

    List<Budget> getAllBudget();

    List<Budget> getUserBudgetRecord(long userId);

    boolean updateBudgetRecord(Budget budget);


    Budget findByUserIdAndCategory(Long userId, String category);
}
