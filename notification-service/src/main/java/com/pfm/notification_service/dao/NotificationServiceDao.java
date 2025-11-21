package com.pfm.notification_service.dao;

import com.pfm.notification_service.model.ExpenceNotification;
import com.pfm.notification_service.model.Notification;

public interface NotificationServiceDao {
    Notification  budgetCreated(Notification b);


    ExpenceNotification expenceCreated(ExpenceNotification notificationDto);
}