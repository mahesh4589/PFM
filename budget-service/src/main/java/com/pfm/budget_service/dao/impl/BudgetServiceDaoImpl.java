package com.pfm.budget_service.dao.impl;

import com.pfm.budget_service.dao.BudgetServiceDao;
import com.pfm.budget_service.dao.BudgetServiceRepo;
import com.pfm.budget_service.model.Budget;
import com.pfm.budget_service.model.dto.BudgetDto;
import com.pfm.budget_service.service.BudgetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class BudgetServiceDaoImpl implements BudgetServiceDao {

    @Autowired
    BudgetServiceRepo repo;

    @Override
    public boolean createBudget(Budget b) {
        try {
            repo.save(b);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    @Override
    public Budget getBudgetById(Long id) {

        Optional<Budget> getRecord  = repo.findById(id);

        return getRecord.get();
    }

    @Override
    public List<Budget> getAllBudget() {
        List<Budget> allBudget = repo.findAll();
        return allBudget;
    }

    @Override
    public List<Budget> getUserBudgetRecord(long userId) {
        List<Budget> record = repo.findByUserId(userId);
        return record;
    }

    @Override
    public boolean updateBudgetRecord(Budget budget) {
        try {
            repo.save(budget);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Budget findByUserIdAndCategory(Long userId, String category) {
     Budget budget = repo.findByUserIdAndCategory(userId, category);
     return budget;
    }
}