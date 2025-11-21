package com.pfm.notification_service.service.impl;

import com.pfm.notification_service.dao.NotificationServiceDao;
import com.pfm.notification_service.feign.UserFeignClient;
import com.pfm.notification_service.model.ExpenceNotification;
import com.pfm.notification_service.model.Notification;
import com.pfm.notification_service.model.dto.BudgetDto;
import com.pfm.notification_service.model.dto.NotificationDto;
import com.pfm.notification_service.model.dto.UserDto;
import com.pfm.notification_service.service.NotificationService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class NotificationServiceImpl implements NotificationService {

    @Autowired
    private NotificationServiceDao notificationServiceDao;

    @Autowired
    private UserFeignClient userFeignClient;

    private static final String NOTIFY_CB = "UserCircuitCB";

    /** -------------------- BUDGET NOTIFICATION -------------------- **/
    @Override
    public Notification budgetCreated(BudgetDto dto) {

        // Validate User
        UserDto user = getUserSafely(dto.getUserId());

        // Build Notification
        Notification n = new Notification();
        n.setUserId(user.getId());
        n.setType("BUDGET_CREATED");
        n.setMessage("Budget created for category: " + dto.getCategory() + " Amount: " + dto.getAmount());
        n.setCreatedAt(LocalDateTime.now());

        return notificationServiceDao.budgetCreated(n);
    }

    /** -------------------- EXPENSE NOTIFICATION -------------------- **/
    @Override
    public ExpenceNotification expenseCreated(NotificationDto dto) {

        // Validate User
        UserDto user = getUserSafely(dto.getUserId());

        // Build Expense Notification
        ExpenceNotification e = new ExpenceNotification();
        e.setUserId(user.getId());
        e.setCategory(dto.getCategory());
        e.setAmount(dto.getAmount());
        e.setDesc(dto.getDesc());
        e.setMsg(dto.getMsg());
        e.setCreatedAt(LocalDateTime.now());

        return notificationServiceDao.expenceCreated(e);
    }

    /** -------------------- Feign + Circuit Breaker -------------------- **/
    @CircuitBreaker(name = NOTIFY_CB, fallbackMethod = "userFallback")
    private UserDto getUserSafely(Long userId) {
        return userFeignClient.getUser(userId);
    }

    /** Fallback method called only when User Service is unavailable **/
    private UserDto userFallback(Long userId, Throwable ex) {
        UserDto u = new UserDto();
        u.setId(userId);
        u.setFirstName("Unknown User (Fallback)");
        u.setEmailId("N/A");
        System.out.println("User service unavailable. Fallback executed.");
        return u;
    }
}
