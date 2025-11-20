package com.pfm.expense_service.model;

import java.math.BigDecimal;
import java.time.LocalDate;

// Note: This is now a standalone public record
public record BudgetDto(
    Long id, 
    Long userId, 
    String category, 
    BigDecimal budgetAmount, 
    LocalDate startDate, 
    LocalDate endDate) {
}