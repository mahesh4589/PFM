package com.pfm.expense_service.dao;


import com.pfm.expense_service.model.Expense;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {
}
