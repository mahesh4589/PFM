package com.pfm.notification_service.controller;

import com.pfm.notification_service.model.BudgetNotification;
import com.pfm.notification_service.model.ExpencesNotification;
import com.pfm.notification_service.model.dto.BudgetNotificationDto;
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

    @PostMapping("/budget-created")
    public ResponseEntity<BudgetNotification> budgetCreated(@RequestBody BudgetNotificationDto dto) {
        BudgetNotification responceDto =notificationService.budgetCreated(dto);
        System.out.println(" controller is working");
        if(responceDto !=null)
        {
            return ResponseEntity.status(HttpStatus.OK).body(responceDto);
        }else {
            return (ResponseEntity<BudgetNotification>) ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR);
        }


    }

    @PostMapping("/expense-created")
    public ResponseEntity<ExpencesNotification> expenseCreated(@RequestBody ExpencesNotification dto) {
        ExpencesNotification responceDto =notificationService.expenseCreated(dto);
        System.out.println(" controller is working");
        if(responceDto !=null)
        {
            return ResponseEntity.status(HttpStatus.OK).body(responceDto);
        }else {
            return (ResponseEntity<ExpencesNotification>) ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR);
        }


    }
}
