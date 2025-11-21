package com.pfm.budgetService.controller;


import com.pfm.budgetService.model.Budget;
import com.pfm.budgetService.model.dto.BudgetDto;
import com.pfm.budgetService.model.dto.ResponceDto;
import com.pfm.budgetService.service.BudgetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/budgets")
public class BudgetController {

    @Autowired
    BudgetService budgetService;

    @PostMapping("/create")
    ResponseEntity<ResponceDto> createBudget(@Validated @RequestBody BudgetDto budgetDto) {
        Budget budget = budgetService.createBudget(budgetDto);
        ResponceDto responceDto = new ResponceDto();
        if (budget != null) {
            responceDto.setMsg("Budget create successfully...!");
            responceDto.setRespCode(HttpStatus.CREATED.value());
            return ResponseEntity.status(HttpStatus.CREATED).body(responceDto);

        } else {
            responceDto.setMsg("Budget not create successfully...!");
            responceDto.setRespCode(HttpStatus.BAD_REQUEST.value());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responceDto);
        }

    }

    @GetMapping("/{id}")
    ResponseEntity<Budget> getBudgetById(@PathVariable(value = "id") Long id) {
        Budget getRecord = budgetService.getBudgetById(id);
        ResponceDto dto = new ResponceDto();
        if (getRecord != null) {
            return ResponseEntity.status(HttpStatus.OK).body(getRecord);
        } else {
            return (ResponseEntity<Budget>) ResponseEntity.status(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/get")
    ResponseEntity<List<Budget>> getAllBudget() {
        List<Budget> getRecord = budgetService.getAllBudget();
        ResponceDto dto = new ResponceDto();
        if (getRecord != null) {
            return ResponseEntity.status(HttpStatus.OK).body(getRecord);
        } else {
            return (ResponseEntity<List<Budget>>) ResponseEntity.status(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/user/{userid}")
    ResponseEntity<List<Budget>> getUserBudgetRecord(@PathVariable("userid") long userId) {
        List<Budget> getRecord = budgetService.getUserBudgetRecord(userId);
        ResponceDto dto = new ResponceDto();
        if (getRecord != null) {
            return ResponseEntity.status(HttpStatus.OK).body(getRecord);
        } else {
            return (ResponseEntity<List<Budget>>) ResponseEntity.status(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    ResponseEntity<ResponceDto> updateBudgetRecord(@PathVariable("id") Long id, BudgetDto budgetDto) {
        boolean resp = budgetService.updateBudgetRecord(id, budgetDto);
        ResponceDto responceDto = new ResponceDto();
        if (resp == true) {
            responceDto.setMsg("Budget update successfully...!");
            responceDto.setRespCode(HttpStatus.CREATED.value());
            return ResponseEntity.status(HttpStatus.CREATED).body(responceDto);

        } else {
            responceDto.setMsg("Budget not create successfully...!");
            responceDto.setRespCode(HttpStatus.BAD_REQUEST.value());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responceDto);
        }
    }

    @GetMapping("/user/{userId}/category/{category}/summary")
    public ResponseEntity<ResponceDto> summary(@PathVariable Long userId, @PathVariable String category) {
        BudgetDto budgetSummary = budgetService.summary(userId, category);
        ResponceDto d = new ResponceDto();
        if (budgetSummary != null) {
            d.setRespCode(HttpStatus.OK.value());
            d.setMsg("view the summary...");
            return ResponseEntity.status(HttpStatus.OK).body(d);
        } else {
            d.setRespCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
            d.setMsg("check summary request...");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(d);
        }
    }

}
