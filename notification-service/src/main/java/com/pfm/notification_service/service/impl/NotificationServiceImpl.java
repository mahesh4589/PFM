package com.pfm.notification_service.service.impl;

import com.pfm.notification_service.dao.NotificationServiceDao;
import com.pfm.notification_service.model.ExpencesNotification;
import com.pfm.notification_service.model.dto.BudgetNotificationDto;
import com.pfm.notification_service.model.dto.UserDto;
import com.pfm.notification_service.model.BudgetNotification;
import com.pfm.notification_service.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class NotificationServiceImpl implements NotificationService {

    /*@Autowired
    JavaMailSender mailSender;
*/
    @Autowired
    NotificationServiceDao notificationServiceDao;

    @Autowired
    UserClient userClient;



    @Override
    public BudgetNotification budgetCreated(BudgetNotificationDto dto) {

        UserDto userRecord = userClient.getUserRecord(dto.getUserId()).block();
        String to = userRecord.getEmailId();
        String subject = "Create New Budget";
        String body = "userid:"+dto.getUserId()+" BudgetId"+dto.getBudgetId()+" Category"+dto.getCategory()+" AmountLimit"+dto.getAmountLimit();

        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject(subject);
        message.setText(body);
      //  mailSender.send(message);
        BudgetNotification b= new BudgetNotification();
        b.setBudgetId(userRecord.getId());
        b.setMessages(body);
        b.setBudgetId(dto.getBudgetId());
        b.setCategory(dto.getCategory());
        b.setAmountLimit(dto.getAmountLimit());
        System.out.println("budgetCreated service is working..");
        return notificationServiceDao.budgetCreated(b);
    }

    @Override
    public ExpencesNotification expenseCreated(ExpencesNotification dto) {

        ExpencesNotification b= new ExpencesNotification();
        UserDto userRecord = userClient.getUserRecord(dto.getUserId()).block();
        String to = userRecord.getEmailId();
        String subject = "Create New Expense";
        String body = "userid:-"+dto.getUserId()+" ExpenseId"+dto.getExpencesid()+" Category"+dto.getCategory()+" Amount"+dto.getAmount()+"desc:-"+ dto.getDescription()+" time:-"+dto.getTimestamp();
       b.setAmount(dto.getAmount());
       b.setDescription(dto.getDescription());
       b.setCategory(dto.getCategory());
       b.setExpencesid(dto.getId());
       b.setTimestamp(dto.getTimestamp());
       b.setUserId(userRecord.getId());
       System.out.println("budgetCreated service is working..");
        return notificationServiceDao.expenseCreated(b);
    }

}
