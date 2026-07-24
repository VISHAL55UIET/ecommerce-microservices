# 🛒 E-Commerce Microservices Backend

A production-inspired **Spring Boot Microservices** application demonstrating enterprise backend architecture using **Spring Cloud**, **Netflix Eureka**, **Spring Cloud Gateway**, **OpenFeign**, **Resilience4j**, and **PostgreSQL**.

The project simulates an E-Commerce platform where multiple independent microservices communicate with each other through service discovery and API Gateway.

> 🚀 Built to learn real-world distributed systems, scalable backend architecture, and production-ready Spring Boot development.

---

# ✨ Features

- ✅ Microservices Architecture
- ✅ Spring Cloud Gateway
- ✅ Netflix Eureka Service Discovery
- ✅ Spring Cloud LoadBalancer
- ✅ OpenFeign Inter-Service Communication
- ✅ Resilience4j Circuit Breaker
- ✅ Order Service
- ✅ Inventory Service
- ✅ REST APIs
- ✅ Spring Data JPA
- ✅ Hibernate ORM
- ✅ PostgreSQL
- ✅ DTO Mapping
- ✅ ModelMapper
- ✅ Layered Architecture
- ✅ Automatic Database Initialization
- ✅ Inventory Stock Management
- ✅ Total Price Calculation
- ✅ Maven Multi-Service Setup

---

# 🏗️ Architecture

```text
                           Client
                              │
                              ▼
                   Spring Cloud Gateway
                              │
                              ▼
                    Eureka Discovery Server
                              │
                ┌─────────────┴─────────────┐
                ▼                           ▼
         Order Service               Inventory Service
                │                           │
                │      OpenFeign            │
                └────────────►──────────────┘
                              │
                    Spring Cloud LoadBalancer
                              │
                    PostgreSQL Databases
```

---

# 🛠️ Tech Stack

| Technology | Purpose |
|------------|---------|
| Java 21 | Programming Language |
| Spring Boot 3.5 | Backend Framework |
| Spring Cloud | Microservices |
| Spring Cloud Gateway | API Gateway |
| Netflix Eureka | Service Discovery |
| OpenFeign | Inter-Service Communication |
| Spring Cloud LoadBalancer | Client-side Load Balancing |
| Resilience4j | Circuit Breaker |
| Spring Data JPA | ORM |
| Hibernate | ORM Implementation |
| PostgreSQL | Database |
| Maven | Dependency Management |
| ModelMapper | DTO Mapping |
| Lombok | Boilerplate Reduction |
| REST APIs | Communication |

---

# 📂 Project Structure

```text
ecommerce-microservices
│
├── api-gateway
│
├── discovery-service
│
├── inventory-service
│
├── order-service
│
└── README.md
```

---

# 🚀 Microservices

## 🌐 API Gateway

### Responsibilities

- Centralized Routing
- Single Entry Point
- Load Balancing
- Service Discovery Integration

Port

```
8080
```

---

## 🔍 Discovery Service

### Responsibilities

- Service Registry
- Service Discovery
- Dynamic Instance Registration

Port

```
8761
```

Dashboard

```
http://localhost:8761
```

---

## 📦 Inventory Service

### Responsibilities

- Product Management
- Inventory Management
- Reduce Product Stocks
- Calculate Total Price

Port

```
9010
```

Endpoints

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
- Call Inventory Service
- Store Order Details

Port

```
9020
```

Endpoints

| Method | Endpoint |
|---------|----------|
| GET | `/orders/core/helloOrders` |
| POST | `/orders/core/create-order` |
| GET | `/orders/core` |
| GET | `/orders/core/{id}` |

---

# 🔄 Request Flow

```text
Client

↓

Spring Cloud Gateway

↓

Eureka Discovery Server

↓

Order Service

↓

OpenFeign Client

↓

LoadBalancer

↓

Inventory Service

↓

Reduce Stocks

↓

Calculate Total Price

↓

Return Total Price

↓

Persist Order

↓

Gateway

↓

Client
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

Update the database credentials inside

```
application.properties
```

---

# ▶️ Run Services

Start the services in the following order:

1. Discovery Service
2. Inventory Service
3. Order Service
4. API Gateway

---

# 🌐 Service URLs

| Service | URL |
|----------|-----|
| Eureka Dashboard | http://localhost:8761 |
| API Gateway | http://localhost:8080 |
| Inventory Service | http://localhost:9010 |
| Order Service | http://localhost:9020 |

---

# 📸 Testing

## Fetch Products

```
GET http://localhost:8080/api/v1/products
```

---

## Create Order

```
POST http://localhost:8080/orders/core/create-order
```

---

## Fetch Orders

```
GET http://localhost:8080/orders/core
```

---

# ✅ Completed

- ✔ Spring Boot Microservices
- ✔ PostgreSQL Integration
- ✔ REST APIs
- ✔ Spring Data JPA
- ✔ OpenFeign
- ✔ Netflix Eureka
- ✔ Spring Cloud Gateway
- ✔ Spring Cloud LoadBalancer
- ✔ Resilience4j Circuit Breaker
- ✔ DTO Mapping
- ✔ Automatic Database Initialization
- ✔ End-to-End Request Routing

---

# 🚧 Upcoming Features

## Authentication

- [ ] Spring Security
- [ ] JWT Authentication
- [ ] Refresh Tokens
- [ ] Role Based Authorization

---

## Configuration

- [ ] Spring Cloud Config Server
- [ ] Centralized Configuration

---

## Monitoring

- [ ] Spring Boot Actuator
- [ ] Prometheus
- [ ] Grafana

---

## Distributed Tracing

- [ ] Micrometer Tracing
- [ ] Zipkin

---

## Messaging

- [ ] Apache Kafka
- [ ] Event-Driven Communication

---

## Caching

- [ ] Redis

---

## Containerization

- [ ] Docker
- [ ] Docker Compose

---

## Deployment

- [ ] Kubernetes
- [ ] AWS EC2
- [ ] AWS RDS
- [ ] Nginx Reverse Proxy

---

## DevOps

- [ ] GitHub Actions CI/CD

---

# 🎯 Learning Outcomes

- Spring Boot Microservices
- REST APIs
- Spring Cloud
- API Gateway
- Netflix Eureka
- Service Discovery
- OpenFeign
- Client-side Load Balancing
- Circuit Breaker Pattern
- DTO Design
- Layered Architecture
- PostgreSQL
- JPA & Hibernate
- Distributed System Basics

---

# 👨‍💻 Author

**Vishal Singh**

🎓 B.Tech CSE (2027)

🔗 GitHub: https://github.com/VISHAL55UIET

🔗 LinkedIn: https://www.linkedin.com/in/vishal-singh-5b052828a/

---

⭐ If you found this project useful, please consider giving it a Star.
