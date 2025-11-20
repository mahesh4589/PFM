package com.pfm.notification_service.model;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Alert {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private Long userId;
    
    // Notification details required by the assessment
    private String budgetCategory; 
    private BigDecimal budgetAmount; 
    private String expenseDescription; 
    private BigDecimal expenseAmount;
    
    private LocalDateTime timestamp = LocalDateTime.now();
    private boolean isSent = true; 
}