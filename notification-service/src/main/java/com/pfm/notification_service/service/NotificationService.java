package com.pfm.notification_service.service;

import com.pfm.notification_service.model.BudgetNotification;
import com.pfm.notification_service.model.ExpencesNotification;
import com.pfm.notification_service.model.dto.BudgetNotificationDto;

public interface NotificationService {
    BudgetNotification budgetCreated(BudgetNotificationDto dto);


    ExpencesNotification expenseCreated(ExpencesNotification dto);
}
