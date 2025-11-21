package com.pfm.notification_service.dao.impl;


import com.pfm.notification_service.dao.ExpenceNotificationRepo;
import com.pfm.notification_service.dao.NotificationRepository;
import com.pfm.notification_service.dao.NotificationServiceDao;
import com.pfm.notification_service.model.ExpenceNotification;
import com.pfm.notification_service.model.Notification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class NotificationServiceDaoImpl implements NotificationServiceDao {

    @Autowired
    NotificationRepository notificationRepository;

    @Autowired
    ExpenceNotificationRepo expenceNotificationRepo;





    @Override
    public Notification budgetCreated(Notification b) {
        System.out.println("notifcation dao working");
        Notification notification =notificationRepository.save(b);
        return notification;
    }

    @Override
    public ExpenceNotification expenceCreated(ExpenceNotification notificationDto) {
        ExpenceNotification expence = expenceNotificationRepo.save(notificationDto);
        return expence;
    }


}
