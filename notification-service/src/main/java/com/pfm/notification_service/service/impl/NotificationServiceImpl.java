package com.pfm.notification_service.service.impl;

import com.pfm.notification_service.dao.NotificationServiceDao;
import com.pfm.notification_service.feign.UserFeignClient;
import com.pfm.notification_service.model.ExpenceNotification;
import com.pfm.notification_service.model.Notification;
import com.pfm.notification_service.model.dto.BudgetDto;
import com.pfm.notification_service.model.dto.NotificationDto;
import com.pfm.notification_service.model.dto.UserDto;
import com.pfm.notification_service.service.NotificationService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;


@Service
public class NotificationServiceImpl<dto> implements NotificationService {


    @Autowired
    NotificationServiceDao notificationServiceDao;

    @Autowired
    UserFeignClient userFeignClient;

    private static final String notify = "userservice";


    @Override
    public Notification budgetCreated(BudgetDto dto) {

        UserDto userRecord = userFeignClient.getUser(dto.getUserId());
        userSeviceFallback(dto.getUserId(), "user service fallback messages");
        String msg = "Amount :" + dto.getAmount() + "Buduget is created..";
        Notification budgetNotification = new Notification();
        budgetNotification.setCreatedAt(LocalDate.now().atStartOfDay());
        budgetNotification.setType(dto.getCategory());
        budgetNotification.setUserId(userRecord.getId());
        budgetNotification.setMessage(msg);
        notificationServiceDao.budgetCreated(budgetNotification);

        return budgetNotification;
    }

    @Override
    public ExpenceNotification expenseCreated(NotificationDto dto) {
        ExpenceNotification e = new ExpenceNotification();
        UserDto userRecord = userFeignClient.getUser(dto.getUserId());
        userSeviceFallback(dto.getUserId(), "user service fallback messages");
        ExpenceNotification notificationDto = new ExpenceNotification();
        notificationDto.setUserId(userRecord.getId());
        notificationDto.setAmount(dto.getAmount());
        notificationDto.setDesc(dto.getDesc());
        notificationDto.setCategory(dto.getCategory());
        notificationDto.setMsg(dto.getMsg());
        notificationServiceDao.expenceCreated(notificationDto);

        return null;
    }

    @CircuitBreaker(name = notify, fallbackMethod = "userSeviceFallback")
    private void userSeviceFallback(Long userId, String messages) {
        userFeignClient.getUser(userId);
    }


}
