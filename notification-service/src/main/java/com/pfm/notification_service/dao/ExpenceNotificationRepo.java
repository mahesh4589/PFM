package com.pfm.notification_service.dao;

import com.pfm.notification_service.model.ExpenceNotification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpenceNotificationRepo extends JpaRepository<ExpenceNotification, Long> {
}
