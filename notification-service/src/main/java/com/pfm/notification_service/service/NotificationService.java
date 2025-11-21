package com.pfm.notification_service.service;

import com.pfm.notification_service.model.ExpenceNotification;
import com.pfm.notification_service.model.Notification;
import com.pfm.notification_service.model.dto.BudgetDto;
import com.pfm.notification_service.model.dto.NotificationDto;

public interface NotificationService {
    Notification budgetCreated(BudgetDto dto);

    ExpenceNotification expenseCreated(NotificationDto dto);
}
