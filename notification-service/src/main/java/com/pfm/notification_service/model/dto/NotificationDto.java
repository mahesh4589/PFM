package com.pfm.notification_service.model.dto;

import lombok.Data;

@Data
public class NotificationDto {
    private Long userId;
    private String category;
    private Double amount;
    private String desc;
    private String msg;
}
