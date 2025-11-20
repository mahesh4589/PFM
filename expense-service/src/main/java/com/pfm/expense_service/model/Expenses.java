package com.pfm.expense_service.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "expenses")
public class Expenses {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long Id;
    Long userId;
    String category;
    String description;
    BigDecimal amount;
    Date timestamp;

    public Expenses(Long id, Long userId, String category, String description, BigDecimal amount, Date timestamp) {
        Id = id;
        this.userId = userId;
        this.category = category;
        this.description = description;
        this.amount = amount;
        this.timestamp = timestamp;
    }
    public Expenses() {

    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }
}
