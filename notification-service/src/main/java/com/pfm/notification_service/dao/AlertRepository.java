package com.pfm.notification_service.dao;

import com.pfm.notification_service.model.Alert;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface AlertRepository extends JpaRepository<Alert, Long> {
    List<Alert> findByUserIdOrderByTimestampDesc(Long userId);
}