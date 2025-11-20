package com.pfm.notification_service.dao.impl;

import com.pfm.notification_service.dao.ExpencesRepo;
import com.pfm.notification_service.dao.NotificationRepository;
import com.pfm.notification_service.dao.NotificationServiceDao;
import com.pfm.notification_service.model.BudgetNotification;
import com.pfm.notification_service.model.ExpencesNotification;
import com.pfm.notification_service.model.dto.BudgetNotificationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class NotificationServiceDaoImpl implements NotificationServiceDao {

    @Autowired
    NotificationRepository notificationRepository;

    @Autowired
    ExpencesRepo repo;



    @Override
    public BudgetNotification budgetCreated(BudgetNotification b) {
        System.out.println("notifcation dao working");
        BudgetNotification notification =notificationRepository.save(b);
        return notification;
    }

    @Override
    public ExpencesNotification expenseCreated(ExpencesNotification b) {
        ExpencesNotification notification = repo.save(b);
        return notification;
    }


}
