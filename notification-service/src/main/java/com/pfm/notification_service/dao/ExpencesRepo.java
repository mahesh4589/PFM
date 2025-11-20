package com.pfm.notification_service.dao;

import com.pfm.notification_service.model.ExpencesNotification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpencesRepo extends JpaRepository<ExpencesNotification,Long> {
}
