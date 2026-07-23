# 🛒 E-Commerce Microservices Backend

A production-inspired E-Commerce Backend built using **Spring Boot Microservices**, demonstrating service-to-service communication using **OpenFeign**, relational database management with **PostgreSQL**, and a scalable microservices architecture.

> 🚀 Built as a learning project to understand real-world backend architecture, distributed systems, and enterprise Java development.

---

## 📌 Features

- ✅ Microservices Architecture
- ✅ Order Service
- ✅ Inventory Service
- ✅ RESTful APIs
- ✅ OpenFeign Inter-Service Communication
- ✅ Spring Data JPA
- ✅ PostgreSQL Integration
- ✅ DTO Mapping using ModelMapper
- ✅ Layered Architecture
- ✅ Centralized Business Logic
- ✅ Automatic Database Initialization using data.sql
- ✅ Inventory Stock Management
- ✅ Total Price Calculation
- ✅ Order Persistence
- ✅ Exception Handling
- ✅ Maven Multi-Service Setup

---

# 🏗️ Architecture

```text
                   Client
                      │
                      ▼
          POST /orders/core/create-order
                      │
                      ▼
              Order Service
                      │
         OpenFeign HTTP Client
                      │
                      ▼
            Inventory Service
                      │
         Reduce Product Stocks
         Calculate Total Price
                      │
                      ▼
              PostgreSQL Database
```

---

# 🛠️ Tech Stack

| Technology | Usage |
|------------|-------|
| Java 21 | Programming Language |
| Spring Boot 3 | Backend Framework |
| Spring Data JPA | ORM |
| Spring Cloud OpenFeign | Inter-service Communication |
| PostgreSQL | Database |
| Hibernate | ORM Implementation |
| Maven | Dependency Management |
| ModelMapper | DTO Mapping |
| Lombok | Boilerplate Reduction |
| REST APIs | Communication |

---

# 📂 Project Structure

```
ecommerce-microservices
│
├── inventory-service
│     ├── Controller
│     ├── Service
│     ├── Repository
│     ├── DTO
│     ├── Entity
│     └── Client
│
├── order-service
│     ├── Controller
│     ├── Service
│     ├── Repository
│     ├── DTO
│     ├── Entity
│     └── Client
│
└── README.md
```

---

# 🚀 Services

## 📦 Inventory Service

### Responsibilities

- Manage Products
- Manage Inventory
- Reduce Product Stocks
- Calculate Total Order Price

### Endpoints

| Method | Endpoint |
|---------|----------|
| GET | `/api/v1/products` |
| GET | `/api/v1/products/{id}` |
| PUT | `/api/v1/products/reduce-stocks` |
| GET | `/api/v1/products/fetchOrders` |

---

## 📦 Order Service

### Responsibilities

- Create Orders
- Persist Orders
- Call Inventory Service using OpenFeign
- Store Order Details

### Endpoints

| Method | Endpoint |
|---------|----------|
| GET | `/orders/core/helloOrders` |
| POST | `/orders/core/create-order` |
| GET | `/orders/core` |
| GET | `/orders/core/{id}` |

---

# 🔄 Microservice Communication

```
Client

↓

Order Service

↓

OpenFeign Client

↓

Inventory Service

↓

Reduce Stocks

↓

Calculate Price

↓

Return Total Price

↓

Save Order

↓

Response
```

---

# 📌 Sample Request

```json
{
  "items": [
    {
      "productId": 1,
      "quantity": 2
    },
    {
      "productId": 2,
      "quantity": 3
    }
  ]
}
```

---

# 📌 Sample Response

```json
{
  "id": 1,
  "items": [
    {
      "id": 1,
      "productId": 1,
      "quantity": 2
    },
    {
      "id": 2,
      "productId": 2,
      "quantity": 3
    }
  ],
  "totalPrice": 5299.95
}
```

---

# ⚙️ Getting Started

## Clone Repository

```bash
git clone https://github.com/VISHAL55UIET/ecommerce-microservices.git
```

---

## Configure PostgreSQL

Create databases

```
inventoryDB
orderDB
```

Update

```
application.properties
```

with your database credentials.

---

## Run Services

### Start Order Service

```
localhost:9020
```

### Start Inventory Service

```
localhost:9010
```

---

# 📸 Working Flow

✔ Client sends Order Request

↓

✔ Order Service receives request

↓

✔ OpenFeign calls Inventory Service

↓

✔ Inventory Service validates stock

↓

✔ Inventory Service reduces stock

↓

✔ Inventory Service calculates total price

↓

✔ Order Service stores order

↓

✔ Success Response returned

---

# 🎯 Learning Outcomes

This project helped in understanding

- Microservices Architecture
- Distributed Communication
- OpenFeign
- DTO Design
- Layered Architecture
- REST APIs
- Spring Boot
- JPA
- PostgreSQL
- Maven Dependency Management
- Inter-Service Communication

---

# 🚧 Upcoming Features

## Service Discovery

- [ ] Netflix Eureka Server
- [ ] Eureka Client Registration

## API Gateway

- [ ] Spring Cloud Gateway
- [ ] Centralized Routing

## Security

- [ ] Spring Security
- [ ] JWT Authentication
- [ ] Role Based Authorization

## Resilience

- [ ] Circuit Breaker
- [ ] Retry
- [ ] Rate Limiter
- [ ] Bulkhead

## Monitoring

- [ ] Spring Boot Actuator
- [ ] Prometheus
- [ ] Grafana

## Distributed Tracing

- [ ] Zipkin
- [ ] Micrometer Tracing

## Messaging

- [ ] Apache Kafka
- [ ] Event Driven Communication

## Containerization

- [ ] Docker
- [ ] Docker Compose

## Deployment

- [ ] Kubernetes
- [ ] AWS Deployment

---

# ⭐ Future Scope

- Payment Service
- Notification Service
- User Service
- Authentication Service
- Product Service
- Cart Service
- API Gateway
- Config Server
- Eureka Service Registry
- Kafka Event Streaming
- Docker Deployment
- Kubernetes Deployment
- CI/CD using GitHub Actions

---

# 👨‍💻 Author

**Vishal Singh**

- GitHub: https://github.com/VISHAL55UIET
- LinkedIn: https://www.linkedin.com/in/vishal-singh-5b052828a/

---

If you found this project useful, don't forget to ⭐ the repository.
