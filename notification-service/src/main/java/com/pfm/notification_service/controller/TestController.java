package com.pfm.notification_service.controller;

import com.pfm.notification_service.dao.AlertRepository;
import com.pfm.notification_service.model.Alert;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/v1/alerts")
@RequiredArgsConstructor
public class TestController {

    private final AlertRepository alertRepository;

    // DTO matches the AlertRequest sent by the Expense Service
    record AlertRequest(Long userId, String budgetCategory, BigDecimal budgetAmount, String expenseDescription, BigDecimal expenseAmount) {}

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createAlert(@RequestBody AlertRequest request) {

        Alert alert = new Alert(
                null,
                request.userId(),
                request.budgetCategory(),
                request.budgetAmount(),
                request.expenseDescription(),
                request.expenseAmount(),
                LocalDateTime.now(),
                true
        );

        alertRepository.save(alert);

        // Output to console to simulate the notification/alert being received
        System.out.println(">>> ALERT RECEIVED & STORED <<<");
        System.out.printf("User %d exceeded budget for %s (Limit: %.2f) with expense: %s (%.2f)%n",
                request.userId(), request.budgetCategory(), request.budgetAmount(),
                request.expenseDescription(), request.expenseAmount());
    }

    @GetMapping("/user/{userId}")
    public List<Alert> getAlertsByUserId(@PathVariable Long userId) {
        return alertRepository.findByUserIdOrderByTimestampDesc(userId);
    }
}