package com.pfm.budgetService.dao;

import com.pfm.budgetService.model.Budget;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BudgetServiceRepo extends JpaRepository<Budget,Long> {


    List<Budget> findByUserId(long userId);

    Budget findByUserIdAndCategory(Long userId, String category);

//   @Query("from Budget as b where b.userid =: userId && b.category=:category")
//    Budget findByUserIdAndCategory(Long userId, String category);
}
