# 🛒 SmartBill - Retail POS & Inventory Management System (Backend)

A production-inspired Retail Point of Sale (POS) and Inventory Management backend built using **Spring Boot**. The application provides secure JWT-based authentication, role-based access control, inventory management, billing, customer management, payment processing, and analytics APIs.

> Designed to simulate a real-world retail billing system used by supermarkets, grocery stores, and retail businesses.

---

## 🚀 Features

### 🔐 Authentication & Authorization
- JWT-based Authentication
- Role-Based Access Control (Admin & Cashier)
- Secure Password Encryption using BCrypt
- Protected REST APIs using Spring Security

### 📦 Inventory Management
- Add, Update, Delete Products
- Category Management
- Automatic Stock Updates
- Low Stock Tracking

### 🛍️ Billing System
- Cart-Based Billing
- Multiple Payment Methods
- Automatic Bill Generation
- Order History

### 👥 Customer Management
- Add & Manage Customers
- Customer Purchase History

### 📊 Dashboard & Analytics
- Daily & Monthly Sales
- Revenue Analytics
- Top Selling Products
- Order Statistics

---

# 🏗️ Tech Stack

| Technology | Purpose |
|------------|---------|
| Spring Boot | Backend Framework |
| Spring Security | Authentication & Authorization |
| JWT | Stateless Authentication |
| Spring Data JPA (Hibernate) | ORM |
| MySQL | Database |
| Maven | Dependency Management |
| Lombok | Boilerplate Reduction |
| React.js | Frontend (Separate Repository) |

---

# 📁 Project Structure

```
src
 ├── controller
 ├── service
 ├── repository
 ├── model
 ├── dto
 ├── security
 ├── config
 ├── util
 └── exception
```

The project follows a layered architecture for better maintainability and scalability.

---

# 🔄 Request Flow

```
Client

   │

   ▼

Spring Security Filter Chain

   │

JWT Validation

   │

Authentication

   │

Authorization

   │

Controller

   │

Service Layer

   │

Repository

   │

MySQL Database
```

---

# 🔑 User Roles

## 👨‍💼 Admin

- Manage Products
- Manage Categories
- Manage Customers
- Manage Users
- View Dashboard Analytics
- View Sales Reports
- Manage Inventory

## 👨‍💻 Cashier

- Create Bills
- Search Products
- Search Customers
- Process Payments
- View Order History

---

# 🔐 Security Features

- JWT Authentication
- Role-Based Authorization
- BCrypt Password Encoding
- Spring Security Filter Chain
- Stateless Authentication
- Protected REST Endpoints
- Secure Password Storage

---

# ⚙️ Getting Started

## Clone Repository

```bash
git clone https://github.com/Adarsh80416/Billing-Software-Backend.git
```

## Navigate

```bash
cd Billing-Software-Backend
```

## Configure Database

Update the following properties:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/billing_app

spring.datasource.username=root

spring.datasource.password=your_password
```

---

## Run

```bash
mvn spring-boot:run
```

Application starts on

```
http://localhost:8080
```

---

# 📌 Main Modules

- Authentication
- Users
- Products
- Categories
- Customers
- Orders
- Payments
- Dashboard
- Reports

---

# 💡 Design Highlights

- Layered Architecture
- RESTful API Design
- DTO-based Request/Response
- Exception Handling
- Dependency Injection
- Stateless Authentication
- Clean Separation of Concerns

---

# 🎯 Future Improvements

- Docker Support
- Redis Caching
- Email Invoice Generation
- PDF Bill Download
- Barcode Scanner Integration
- Swagger Documentation
- Unit & Integration Tests
- Microservices Architecture
- Cloud Deployment (AWS)

---

# 📈 Why This Project?

Unlike a basic CRUD application, this project demonstrates concepts commonly used in enterprise backend development:

- Secure Authentication using Spring Security & JWT
- Role-Based Authorization
- Inventory Management Logic
- Sales Analytics
- Database Relationships with JPA/Hibernate
- Clean Layered Architecture
- REST API Development
- Production-Oriented Backend Design

---

# 👨‍💻 Author

**Adarsh Kumar**

- GitHub: https://github.com/Adarsh80416
- LinkedIn: https://www.linkedin.com/in/adarsh-kumar
