package com.pfm.budgetService.service.impl;


import com.pfm.budgetService.dao.BudgetServiceDao;
import com.pfm.budgetService.feign.NotificationFeignClient;
import com.pfm.budgetService.feign.UserFeignClient;

import com.pfm.budgetService.model.Budget;
import com.pfm.budgetService.model.dto.BudgetDto;
import com.pfm.budgetService.model.dto.ResponceDto;
import com.pfm.budgetService.service.BudgetService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("BudgetService")
public class BudgetServiceImpl implements BudgetService {

    @Autowired
    BudgetServiceDao budgetServiceDao;

  /*  @Autowired
    NotificationClient notificationClient;*/

    @Autowired
    UserFeignClient userFeignClient;




    @Autowired
    NotificationFeignClient notificationFeignClient;

    private static final String notify = "notificationService";

    @Override
    public Budget createBudget(BudgetDto budgetDto) {
        Map<String, Object> user;
        try {
            user = userFeignClient.getUser(budgetDto.userId);
            if (user == null || user.isEmpty()) {
                throw new RuntimeException("User not found with ID " + budgetDto.userId);
            }
        } catch (Exception ex) {
            throw new RuntimeException("User not found with ID: " + budgetDto.userId);
        }
        Budget b = new Budget();
        b.setAmount(budgetDto.getAmount());
        b.setCategory(budgetDto.getCategory());
        b.setEndDate(budgetDto.getEndDate());
        Integer id = (Integer) user.get("id");
        b.setUserId(id.longValue());
        b.setStartDate(budgetDto.getStartDate());
        Budget resp = budgetServiceDao.createBudget(b);
        notifyWithFallback(resp);
        return resp;
    }

    @CircuitBreaker(name = notify, fallbackMethod = "notifyFallback")
    private void notifyWithFallback(Budget resp) {
        notificationFeignClient.createNotification(resp);
    }


    @Override
    public Budget getBudgetById(Long id) {
        Budget b = budgetServiceDao.getBudgetById(id);
        return b;
    }

    @Override
    public List<Budget> getAllBudget() {
        List<Budget> listbudge = budgetServiceDao.getAllBudget();
        return listbudge;
    }

    @Override
    public List<Budget> getUserBudgetRecord(long userId) {
        List<Budget> record = budgetServiceDao.getUserBudgetRecord(userId);
        return record;
    }

    @Override
    public boolean updateBudgetRecord(Long id, BudgetDto budgetDto) {
        Budget budget = budgetServiceDao.getBudgetById(id);
        if (budget == null) {
            throw new RuntimeException(" budget Id record not found..");
        }
        budget.setAmount(budgetDto.getAmount());
        budget.setCategory(budgetDto.getCategory());
        budget.setEndDate(budgetDto.getEndDate());
        budget.setUserId(budgetDto.getUserId());
        budget.setStartDate(budgetDto.getStartDate());
        boolean resp = budgetServiceDao.updateBudgetRecord(budget);


        return resp;
    }

    @Override
    public BudgetDto summary(Long userId, String category) {

        Budget budgetOpt = budgetServiceDao.findByUserIdAndCategory(userId, category);
        ResponceDto d = new ResponceDto();
        //   Budget b = budgetOpt.get();
        // totalSpent calculation will be done by expense-service in real flow. For convenience, we just return budget details.
      /*  Map<String, Object> resp = new HashMap<>();
        resp.put("budget", budgetOpt);
        // totalSpent should be obtained from expense-service; for decoupling return placeholder 0.
        resp.put("totalSpent", BigDecimal.ZERO);*/
        BudgetDto b = new BudgetDto();
        b.setCategory(budgetOpt.getCategory());
        b.setAmount(budgetOpt.getAmount());
        b.setUserId(budgetOpt.getUserId());
        b.setStartDate(budgetOpt.getStartDate());
        b.setEndDate(budgetOpt.getEndDate());

        return b;
    }
}
