package com.pfm.expense_service.dao;

import com.pfm.expense_service.model.Expenses;

public interface ExpensesServiceDao {
    Expenses createExpenses(Expenses expenses);

     Expenses getExpenses(Long id);
}
