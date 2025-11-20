package com.pfm.notification_service.model;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "notification")
public class BudgetNotification {

    @Id
            @GeneratedValue(strategy = GenerationType.AUTO)
            Long Id;
            Long BudgetId;
            String Category;
            String messages;

        BigDecimal AmountLimit;

        public String getMessages() {
                return messages;
        }

        public void setMessages(String messages) {
                this.messages = messages;
        }

        public Long getId() {
                return Id;
        }

        public void setId(Long id) {
                Id = id;
        }

        public Long getBudgetId() {
                return BudgetId;
        }

        public void setBudgetId(Long budgetId) {
                BudgetId = budgetId;
        }

        public String getCategory() {
                return Category;
        }

        public void setCategory(String category) {
                Category = category;
        }

        public BigDecimal getAmountLimit() {
                return AmountLimit;
        }

        public void setAmountLimit(BigDecimal amountLimit) {
                AmountLimit = amountLimit;
        }

       public BudgetNotification()
        {

        }

        public BudgetNotification(Long id, Long budgetId, String category, BigDecimal amountLimit, String message) {
                Id = id;
                BudgetId = budgetId;
                Category = category;
                AmountLimit = amountLimit;

        }


}
