package com.pfm.expense_service.service.impl;

import com.pfm.expense_service.model.Expenses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class ExpensesNotication {

    @Autowired
    WebClient webClient;


    public void sendExpensesNotification(Expenses expenses) {


        webClient.post()
                .uri("http://localhost:8084/api/notifications/expense-created")
                .bodyValue(expenses)
                .retrieve()
                .bodyToMono(Void.class)
                .subscribe();
    }
}