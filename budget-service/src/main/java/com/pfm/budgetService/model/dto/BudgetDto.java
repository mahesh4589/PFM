package com.pfm.budgetService.model.dto;

import java.time.LocalDate;
import java.util.Date;

public class BudgetDto {
    public Long id;
    public Long userId;
    public String category;
    public Double amount;

    public LocalDate startDate;

    public LocalDate endDate;


    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }


    public BudgetDto(Long id, Long userId, String category, Double amount, LocalDate startDate, LocalDate endDate) {
        this.id = id;
        this.userId = userId;
        this.category = category;
        this.amount = amount;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public BudgetDto(Long id, Long userId, String category, Double amount) {
        this.id = id;
        this.userId = userId;
        this.category = category;
        this.amount = amount;
    }

    public BudgetDto()
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

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }


}
