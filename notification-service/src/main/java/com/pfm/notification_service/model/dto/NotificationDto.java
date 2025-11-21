package com.pfm.notification_service.model.dto;

public class NotificationDto {

    Long id;
    Long userId;

    public String getCategory() {
        return Category;
    }

    public void setCategory(String category) {
        Category = category;
    }

    public NotificationDto(Long id, Long userId, String category, String desc, double amount, String msg) {
        this.id = id;
        this.userId = userId;
        Category = category;
        Desc = desc;
        Amount = amount;
        this.msg = msg;
    }

    public String getDesc() {
        return Desc;
    }

    public void setDesc(String desc) {
        Desc = desc;
    }

    String Category;

    String Desc;

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

    public double getAmount() {
        return Amount;
    }

    public void setAmount(double amount) {
        Amount = amount;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public NotificationDto(Long id, Long userId, double amount, String msg) {
        this.id = id;
        this.userId = userId;
        Amount = amount;
        this.msg = msg;
    }

    public NotificationDto()
    {

    }
    double Amount;
    String msg;
}
