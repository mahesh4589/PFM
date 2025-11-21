package com.pfm.expense_service.dao;

import com.pfm.expense_service.model.Expense;

public interface ExpensesServiceDao {
    Expense createExpenses(Expense expenses);

     Expense getExpenses(Long id);
}
