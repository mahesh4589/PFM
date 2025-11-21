package com.pfm.expense_service.dao.impl;


import com.pfm.expense_service.dao.ExpenseRepository;
import com.pfm.expense_service.dao.ExpensesServiceDao;
import com.pfm.expense_service.model.Expense;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class ExpensesServiceDaoImpl implements ExpensesServiceDao {

    @Autowired
    ExpenseRepository expensesRepo;

    @Override
    public Expense createExpenses(Expense expenses) {
        Expense expense = expensesRepo.save(expenses);
        return expense;
    }

    @Override
    public Expense getExpenses(Long id) {
        Optional<Expense> getExpenses = expensesRepo.findById(id);
        return getExpenses.get();
    }
}
