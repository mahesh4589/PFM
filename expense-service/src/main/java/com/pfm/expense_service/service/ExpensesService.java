package com.pfm.expense_service.service;

import com.pfm.expense_service.model.Expenses;

public interface ExpensesService {
   

    Expenses createExpenses(Expenses expenses);

    Expenses getExpenses(Long id);
}
