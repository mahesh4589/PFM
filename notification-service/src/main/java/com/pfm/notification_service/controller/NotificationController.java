package com.pfm.notification_service.controller;

import com.pfm.notification_service.feign.UserFeignClient;
import com.pfm.notification_service.model.ExpenceNotification;

import com.pfm.notification_service.model.Notification;
import com.pfm.notification_service.model.dto.BudgetDto;

import com.pfm.notification_service.model.dto.NotificationDto;
import com.pfm.notification_service.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/notifications")
public class NotificationController {

    @Autowired
    NotificationService notificationService;

    @Autowired
    UserFeignClient userFeignClient;

    @PostMapping("/budget-created")
    public ResponseEntity<Notification> budgetCreated(@RequestBody BudgetDto dto) {
        Notification responceDto = notificationService.budgetCreated(dto);
        System.out.println(" controller is working");
        if(responceDto !=null)
        {
            return ResponseEntity.status(HttpStatus.OK).body(responceDto);
        }else {
            return (ResponseEntity<Notification>) ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR);
        }


    }

    @PostMapping("/expense-created")
    public ResponseEntity<ExpenceNotification> expenseCreated(@RequestBody NotificationDto dto) {
        ExpenceNotification responceDto =notificationService.expenseCreated(dto);
        System.out.println(" controller is working");
        if(responceDto !=null)
        {
            return ResponseEntity.status(HttpStatus.OK).body(responceDto);
        }else {
            return (ResponseEntity<ExpenceNotification>) ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR);
        }


    }
}
