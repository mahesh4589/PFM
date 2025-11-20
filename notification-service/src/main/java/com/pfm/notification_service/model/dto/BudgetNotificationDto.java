package com.pfm.notification_service.model.dto;

import java.math.BigDecimal;

public class BudgetNotificationDto {


    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getBudgetId() {
        return budgetId;
    }

    public void setBudgetId(Long budgetId) {
        this.budgetId = budgetId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public BudgetNotificationDto(Long userId, Long budgetId, String message) {
        this.userId = userId;
        this.budgetId = budgetId;
        this.message = message;
    }

    private Long userId;

    public Long getUserId() {
        return userId;
    }

    private Long budgetId;
    private String message;

    private String Category;

    public BudgetNotificationDto(Long userId, Long budgetId, String message, String category, BigDecimal amountLimit) {
        this.userId = userId;
        this.budgetId = budgetId;
        this.message = message;
        Category = category;
        AmountLimit = amountLimit;
    }

   public  BudgetNotificationDto()
    {

    }
    public String getCategory() {
        return Category;
    }

    public void setCategory(String category) {
        Category = category;
    }

    public BigDecimal getAmountLimit() {
        return AmountLimit;
    }

    public void setAmountLimit(BigDecimal amountLimit) {
        AmountLimit = amountLimit;
    }

    private BigDecimal AmountLimit;

}
