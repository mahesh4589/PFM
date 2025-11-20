package com.pfm.budget_service.dao;

import com.pfm.budget_service.model.Budget;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BudgetServiceRepo extends JpaRepository<Budget,Long> {


    List<Budget> findByUserId(long userId);

   @Query("")
    Budget findByUserIdAndCategory(Long userId, String category);
}
