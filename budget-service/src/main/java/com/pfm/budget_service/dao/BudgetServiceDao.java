package com.pfm.budget_service.dao;

import com.pfm.budget_service.model.Budget;
import com.pfm.budget_service.model.dto.BudgetDto;

import java.util.List;

public interface BudgetServiceDao {
    boolean createBudget(Budget b);

    Budget getBudgetById(Long id);

    List<Budget> getAllBudget();

    List<Budget> getUserBudgetRecord(long userId);

    boolean updateBudgetRecord(Budget budget);


    Budget findByUserIdAndCategory(Long userId, String category);
}
