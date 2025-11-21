package com.pfm.expense_service.model.dto;

import java.time.LocalDate;

public class ExpenseDto {

    Long id;

    String description;
    Long userId;
    String     category;
    double    amount;
    LocalDate createdAt;

    public ExpenseDto(Long id, Long userId, String category, double amount, LocalDate createdAt, String description) {
        this.id = id;
        this.userId = userId;
        this.category = category;
        this.amount = amount;
        this.createdAt = createdAt;
        this.description = description;
    }

  public ExpenseDto()
    {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }



}
