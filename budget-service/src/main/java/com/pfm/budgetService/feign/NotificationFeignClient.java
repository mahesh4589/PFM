package com.pfm.budgetService.feign;

import com.pfm.budgetService.model.Budget;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name="notification-service", url="${notification.service.url:http://localhost:8084}")
public interface NotificationFeignClient {
    @PostMapping("/api/notifications/budget-created")
    void createNotification(@RequestBody Budget payload);
}
