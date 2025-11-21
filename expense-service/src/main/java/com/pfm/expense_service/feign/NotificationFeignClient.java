package com.pfm.expense_service.feign;


import com.pfm.expense_service.model.dto.NotificationDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name="notification-service", url="${notification.service.url:http://localhost:8084}")
public interface NotificationFeignClient {
    @PostMapping("/api/notifications/expense-created")
    NotificationDto createNotification(@RequestBody NotificationDto payload);
}
