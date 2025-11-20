package com.pfm.notification_service.dao;

import com.pfm.notification_service.model.BudgetNotification;
import com.pfm.notification_service.model.ExpencesNotification;
import com.pfm.notification_service.model.dto.BudgetNotificationDto;

public interface NotificationServiceDao {
    BudgetNotification  budgetCreated(BudgetNotification b);

    ExpencesNotification expenseCreated(ExpencesNotification b);
}