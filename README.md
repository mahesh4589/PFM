Personal Finance Manager – Microservices Project

A Java Spring Boot–based microservices financial management system that allows users to manage budgets and expenses, and receive notifications when expenses exceed the allocated budget.

✔ User
Register user
LoginView profile
Update user details

✔ Budget
Create budget
Update budget
Get budget summary
Validate expense > budget (notification triggered automatically)

✔ Expense
Create expense
If expense exceeds budget → triggers notification

✔ Notification
Stores and returns notification logs
Accepts notifications from Budget and Expense services

Clone the repository
git clone https://github.com/mahesh4589/PFM.git


User Service
POST /api/users
POST /api/users/login
GET  /api/users/{id}
PUT  /api/users/{id}
GET  /api/users

Budgets Service
POST /api/budgets
GET  /api/budgets/{id}
GET  /api/budgets/user/{userId}
PUT  /api/budgets/{id}

Expense Service
POST /api/expenses
GET  /api/expenses/{id}
GET  /api/expenses/user/{userId}

Notifications Service
POST /api/notifications/budget-created
POST /api/notifications/expense-created
GET  /api/notifications/user/{userId}








/{id}
GET  /api/budgets/user/{userId}
PUT  /api/budgets/{id}
