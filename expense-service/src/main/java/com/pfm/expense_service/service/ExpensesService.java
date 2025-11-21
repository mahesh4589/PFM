package com.pfm.expense_service.service;

import com.pfm.expense_service.model.Expense;
import com.pfm.expense_service.model.dto.ExpenseDto;

public interface ExpensesService {


    Expense createExpenses(ExpenseDto expenses);

    Expense getExpenses(Long id);
}
