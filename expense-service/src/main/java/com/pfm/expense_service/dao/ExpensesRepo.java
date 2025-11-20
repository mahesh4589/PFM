package com.pfm.expense_service.dao;

import com.pfm.expense_service.model.Expenses;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpensesRepo extends JpaRepository<Expenses, Long> {
}
