package com.pfm.notification_service.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Date;

@Table
@Entity(name="expencesNotification")
public class ExpencesNotification {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id ;
    Long UserId;

    public Long getExpencesid() {
        return expencesid;
    }

    public void setExpencesid(Long expencesid) {
        this.expencesid = expencesid;
    }

    Long expencesid;
    String category;
    String description;
    BigDecimal amount;

    public ExpencesNotification(Long id, Long userId, Long expencesid, String category, String description, BigDecimal amount, Date timestamp) {
        this.id = id;
        UserId = userId;
        this.expencesid = expencesid;
        this.category = category;
        this.description = description;
        this.amount = amount;
        this.timestamp = timestamp;
    }

   public ExpencesNotification()
    {

    }
    Date timestamp;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return UserId;
    }

    public void setUserId(Long userId) {
        UserId = userId;
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
