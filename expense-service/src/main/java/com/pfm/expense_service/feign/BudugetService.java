package com.pfm.expense_service.feign;

import com.pfm.expense_service.model.Expense;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;

@FeignClient(name="budget-service", url="${budget.service.url:http://localhost:8082}")
public interface BudugetService {
    @GetMapping("/api/budgets/user/{userid}")
    Map<String, Object> getUserBudget(@PathVariable("id") Long id);
}