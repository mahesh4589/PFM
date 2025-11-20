package com.pfm.expense_service.dao.impl;

import com.pfm.expense_service.dao.ExpensesRepo;
import com.pfm.expense_service.dao.ExpensesServiceDao;
import com.pfm.expense_service.model.Expenses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class ExpensesServiceImpl implements ExpensesServiceDao {

    @Autowired
    ExpensesRepo expensesRepo;

    @Override
    public Expenses createExpenses(Expenses expenses) {
        Expenses exp = expensesRepo.save(expenses);
        return exp;
    }

    @Override
    public Expenses getExpenses(Long id) {
        Optional<Expenses> getExpenses = expensesRepo.findById(id);
        return getExpenses.get();
    }
}
