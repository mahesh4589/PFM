package com.pfm.expense_service.model;

import java.math.BigDecimal;

// Note: This is now a standalone public record
public record AlertRequest(
    Long userId, 
    String budgetCategory, 
    BigDecimal budgetAmount, 
    String expenseDescription, 
    BigDecimal expenseAmount) {
}