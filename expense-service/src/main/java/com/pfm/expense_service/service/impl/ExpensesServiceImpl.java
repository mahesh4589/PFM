package com.pfm.expense_service.service.impl;

import ch.qos.logback.core.CoreConstants;
import com.pfm.expense_service.dao.ExpensesServiceDao;
import com.pfm.expense_service.model.Expenses;
import com.pfm.expense_service.service.ExpensesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class ExpensesServiceImpl implements ExpensesService {

    @Autowired
    ExpensesServiceDao expensesServiceDao;

    @Autowired
    ExpensesNotication expensesNotication;



    @Override
    public Expenses createExpenses(Expenses expenses) {
        Expenses res = expensesServiceDao.createExpenses(expenses);


        if (res != null) {
            expensesNotication.sendExpensesNotification(res);
            return res;
        } else {
            return res;
        }

    }

    @Override
    public Expenses getExpenses(Long id) {

        return expensesServiceDao.getExpenses(id);
    }
}
