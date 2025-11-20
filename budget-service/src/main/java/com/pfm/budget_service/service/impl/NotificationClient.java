package com.pfm.budget_service.service.impl;

import com.pfm.budget_service.model.dto.BudgetDto;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class NotificationClient {

    private final WebClient webClient;

    public NotificationClient(WebClient webClient) {
        this.webClient = webClient;
    }

    public void sendBudgetCreatedNotification(BudgetDto budget) {

        BudgetDto dto = new BudgetDto();
        dto.setId(budget.getId());
        dto.setUserId(budget.getUserId());
        dto.setCategory(budget.getCategory());
        dto.setAmountLimit(budget.getAmountLimit());

        webClient.post()
                .uri("http://localhost:8084/api/notifications/budget-created")
                .bodyValue(dto)
                .retrieve()
                .bodyToMono(Void.class)
                .subscribe();
    }
}
