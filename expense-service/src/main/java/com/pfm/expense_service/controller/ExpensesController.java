package com.pfm.expense_service.controller;


import com.pfm.expense_service.model.Expense;
import com.pfm.expense_service.model.dto.ExpenseDto;
import com.pfm.expense_service.service.ExpensesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/expenses")
public class ExpensesController {


    @Autowired
    ExpensesService expensesService;

    @PostMapping("/create")
    ResponseEntity<Expense> createExpenses(@RequestBody ExpenseDto expenses) {
        Expense resp = expensesService.createExpenses(expenses);
        if (resp != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(resp);
        } else {
            return (ResponseEntity<Expense>) ResponseEntity.status(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{id}")
    ResponseEntity<Expense> getExpenses(@PathVariable("id ") Long id) {
        Expense res = expensesService.getExpenses(id);
        if (res != null) {
            return ResponseEntity.status(HttpStatus.OK).body(res);
        } else {
            return (ResponseEntity<Expense>) ResponseEntity.status(HttpStatus.NOT_FOUND);
        }



    }

}
