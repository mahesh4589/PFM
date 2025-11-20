package com.pfm.notification_service.dao;

import com.pfm.notification_service.model.BudgetNotification;
import com.pfm.notification_service.model.dto.BudgetNotificationDto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationRepository extends JpaRepository<BudgetNotification, Long> {
}
