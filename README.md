# 🛒 E-Commerce Microservices Backend

<div align="center">

![Java](https://img.shields.io/badge/Java-21-orange)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.5-brightgreen)
![Spring Cloud](https://img.shields.io/badge/Spring%20Cloud-2025-blue)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-16-blue)
![Maven](https://img.shields.io/badge/Maven-Build-red)
![License](https://img.shields.io/badge/License-MIT-success)

A production-inspired **Spring Boot Microservices** application built to understand enterprise backend architecture using **Spring Cloud**, **Netflix Eureka**, **Spring Cloud Gateway**, **OpenFeign**, **Resilience4j**, and **PostgreSQL**.

</div>

---

# 📖 Table of Contents

- Overview
- Features
- Architecture
- Tech Stack
- Project Structure
- Services
- API Gateway
- Eureka Discovery
- Order Service
- Inventory Service
- Request Flow
- API Documentation
- Gateway Filters
- JWT Infrastructure
- Resilience4j
- Database
- Running the Project
- Testing
- Screenshots
- Future Roadmap
- Docker
- Kubernetes
- AWS
- CI/CD
- Learning Outcomes

---

# 🚀 Overview

This project demonstrates how modern backend systems are designed using **Microservices Architecture**.

Instead of building a single monolithic application, the system is divided into multiple independent services communicating through REST APIs using **OpenFeign** and discovered dynamically using **Netflix Eureka**.

An **API Gateway** acts as the single entry point for all client requests, providing routing, load balancing, centralized logging, and authentication.

The project focuses on learning production-ready backend concepts such as

- Microservices
- Distributed Systems
- Service Discovery
- API Gateway
- Gateway Filters
- JWT Infrastructure
- Client-side Load Balancing
- Circuit Breaker
- Layered Architecture
- REST APIs

---

# ✨ Features

## Microservices

- ✅ Independent Services
- ✅ Service-to-Service Communication
- ✅ Independent Databases
- ✅ Layered Architecture

---

## Spring Cloud

- ✅ Netflix Eureka Discovery Server
- ✅ Eureka Client Registration
- ✅ Spring Cloud Gateway
- ✅ Spring Cloud LoadBalancer
- ✅ OpenFeign

---

## API Gateway

- ✅ Centralized Routing
- ✅ Single Entry Point
- ✅ Global Gateway Filter
- ✅ Route Specific Filter
- ✅ Authentication Gateway Filter
- ✅ JWT Infrastructure
- ✅ Logging

---

## Backend

- ✅ Spring Boot 3.5
- ✅ Java 21
- ✅ Spring Data JPA
- ✅ Hibernate
- ✅ DTO Pattern
- ✅ ModelMapper
- ✅ PostgreSQL

---

## Resilience

- ✅ Resilience4j Setup
- ✅ Circuit Breaker Ready

---

## Database

- ✅ PostgreSQL
- ✅ Automatic Initialization
- ✅ data.sql
- ✅ Hibernate ORM

---

# 🏗️ System Architecture

```text
                                Client
                                   │
                                   ▼
                      Spring Cloud API Gateway
                                   │
        ┌──────────────────────────┼──────────────────────────┐
        │                          │                          │
        ▼                          ▼                          ▼
 Global Logging            Authentication              Route Filter
      Filter                    Filter

                                   │
                                   ▼
                     Netflix Eureka Discovery Server
                                   │
              ┌────────────────────┴────────────────────┐
              ▼                                         ▼
      Order Service                           Inventory Service
              │                                         │
              │----------- OpenFeign ------------------>│
              │                                         │
              ▼                                         ▼
        Order Database                         Inventory Database
            PostgreSQL                             PostgreSQL
```

---

# ⚙️ Technology Stack

| Technology | Purpose |
|------------|---------|
| Java 21 | Programming Language |
| Spring Boot 3.5 | Backend Framework |
| Spring Cloud | Microservices |
| Spring Cloud Gateway | API Gateway |
| Netflix Eureka | Service Discovery |
| OpenFeign | Inter-Service Communication |
| Spring Cloud LoadBalancer | Load Balancing |
| Resilience4j | Circuit Breaker |
| Spring Data JPA | ORM |
| Hibernate | ORM |
| PostgreSQL | Database |
| Maven | Dependency Management |
| Lombok | Boilerplate Reduction |
| ModelMapper | DTO Mapping |
| REST APIs | Communication |

---

# 📂 Project Structure

```text
ecommerce-microservices
│
├── api-gateway
│   ├── filters
│   │     ├── GlobalLoggingFilter
│   │     ├── LoggingOrdersFilter
│   │     └── AuthenticationGatewayFilterFactory
│   │
│   ├── service
│   │     └── JwtService
│   │
│   └── application.properties
│
├── discovery-service
│
│   ├── Eureka Server
│   └── Service Registry
│
├── inventory-service
│
│   ├── Controller
│   ├── Service
│   ├── Repository
│   ├── Entity
│   ├── DTO
│   ├── OpenFeign Client
│   └── PostgreSQL
│
├── order-service
│
│   ├── Controller
│   ├── Service
│   ├── Repository
│   ├── Entity
│   ├── DTO
│   ├── OpenFeign Client
│   └── PostgreSQL
│
└── README.md
```

---

# 🎯 Objectives

This project was built to understand

- Enterprise Backend Development
- Distributed Systems
- Spring Cloud Ecosystem
- API Gateway
- Service Discovery
- Client-side Load Balancing
- OpenFeign Communication
- Circuit Breaker Pattern
- JWT Authentication
- Docker
- Kubernetes
- AWS Deployment

# 🚀 Microservices

This project follows a **Microservices Architecture**, where every service has its own responsibility and database.

The services communicate with each other through **Spring Cloud OpenFeign**, while service discovery is handled using **Netflix Eureka**.

---

# 🌐 API Gateway

The API Gateway is the **single entry point** of the entire system.

Instead of exposing individual microservices to clients, every request first reaches the API Gateway.

Responsibilities

- Centralized Routing
- Service Discovery
- Client Request Forwarding
- Load Balancing
- Global Request Logging
- Route Specific Logging
- Authentication Filter
- JWT Validation (Infrastructure)

Port

```
8080
```

---

## API Gateway Flow

```text
Client

↓

API Gateway

↓

Authentication Filter

↓

Global Logging Filter

↓

Route Filter

↓

Requested Service
```

---

# 🔍 Discovery Service

Netflix Eureka acts as the **Service Registry**.

Every microservice registers itself automatically after startup.

Instead of hardcoding URLs, services communicate using their service names.

Example

```
lb://ORDER-SERVICE

lb://INVENTORY-SERVICE
```

Responsibilities

- Service Registration
- Service Discovery
- Dynamic Instance Management
- Health Monitoring

Port

```
8761
```

Dashboard

```
http://localhost:8761
```

---

# 📦 Inventory Service

The Inventory Service manages products and stock availability.

Responsibilities

- Product Management
- Inventory Management
- Reduce Product Stock
- Calculate Order Price

Database

```
inventoryDB
```

Port

```
9010
```

---

## Inventory Endpoints

| Method | Endpoint | Description |
|----------|----------------------------|------------------------|
| GET | /api/v1/products | Fetch All Products |
| GET | /api/v1/products/{id} | Fetch Product |
| PUT | /api/v1/products/reduce-stocks | Reduce Stock |
| GET | /api/v1/products/fetchOrders | OpenFeign Demo |

---

# 📦 Order Service

Order Service handles customer orders.

Responsibilities

- Create Orders
- Store Orders
- Call Inventory Service
- Persist Order Items

Database

```
orderDB
```

Port

```
9020
```

---

## Order Endpoints

| Method | Endpoint | Description |
|----------|-----------------------------|-------------------|
| GET | /orders/core | Fetch Orders |
| GET | /orders/core/{id} | Fetch Order |
| POST | /orders/core/create-order | Create Order |
| GET | /orders/core/helloOrders | OpenFeign Demo |

---

# 🔄 Complete Request Flow

```text
Client

↓

API Gateway

↓

Authentication Filter

↓

Global Logging Filter

↓

Route Logging Filter

↓

Netflix Eureka

↓

Spring Cloud LoadBalancer

↓

Order Service

↓

OpenFeign

↓

Inventory Service

↓

PostgreSQL

↓

Inventory Response

↓

Order Service

↓

Save Order

↓

Gateway

↓

Client
```

---

# 📡 OpenFeign Communication

Order Service never communicates directly using URLs.

Instead it uses

```java
@FeignClient(name = "inventory-service")
```

Spring Cloud automatically

- discovers Inventory Service
- selects healthy instance
- performs load balancing
- sends HTTP request

Architecture

```text
Order Service

↓

OpenFeign

↓

LoadBalancer

↓

Inventory Service
```

---

# ⚖️ Spring Cloud LoadBalancer

LoadBalancer distributes requests among available service instances.

Example

```text
Inventory Instance 1

Inventory Instance 2

Inventory Instance 3

↓

LoadBalancer

↓

Automatic Routing
```

Current Project

```text
Client

↓

Gateway

↓

lb://ORDER-SERVICE

↓

lb://INVENTORY-SERVICE
```

---

# 📋 Sample Create Order Request

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

# 📋 Sample Response

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

# 📊 Sequence Diagram

```text
Client
   │
   ▼
API Gateway
   │
   ▼
Authentication Filter
   │
   ▼
Global Logging Filter
   │
   ▼
Order Service
   │
   ▼
OpenFeign Client
   │
   ▼
Inventory Service
   │
   ▼
PostgreSQL
   │
   ▼
Inventory Response
   │
   ▼
Order Service
   │
   ▼
Persist Order
   │
   ▼
Gateway
   │
   ▼
Client
```

---

# 💡 Design Principles Used

- Single Responsibility Principle
- Layered Architecture
- DTO Pattern
- Repository Pattern
- Dependency Injection
- Interface-Based Design
- Loose Coupling
- Separation of Concerns

---

# 📈 Current Architecture Level

✅ REST APIs

✅ Layered Architecture

✅ PostgreSQL

✅ DTO Mapping

✅ OpenFeign

✅ Service Discovery

✅ API Gateway

✅ Spring Cloud LoadBalancer

✅ Distributed Communication

✅ Production-style Routing

---# 🛡️ API Gateway Filters

One of the major advantages of using **Spring Cloud Gateway** is the ability to intercept every request before it reaches the microservices.

The gateway is responsible for

- Logging
- Authentication
- Authorization
- Request Validation
- Rate Limiting
- Routing
- Monitoring

This project currently implements multiple gateway filters.

---

# 🌍 Global Logging Filter

The Global Logging Filter executes for **every incoming request** passing through the API Gateway.

Responsibilities

- Log HTTP Method
- Log Request URI
- Log Response Status
- Measure Request Processing Time
- Centralized Request Monitoring

Flow

```text
Client

↓

Gateway

↓

Global Logging Filter

↓

Requested Service
```

Example Log

```text
Incoming Request

Method : POST

URI : /orders/core/create-order

Response Status : 200 OK

Execution Time : 43 ms
```

---

# 📌 Route Specific Logging Filter

Unlike Global Filters, Route Filters execute only for specific routes.

Current Implementation

```
/orders/**
```

Responsibilities

- Log Order APIs
- Capture Order Requests
- Monitor Order Traffic
- Debug Specific Services

Flow

```text
Client

↓

Gateway

↓

Order Route Filter

↓

Order Service
```

Example

```text
POST

/orders/core/create-order

↓

LoggingOrdersFilter

↓

Order Service
```

---

# 🔐 Authentication Gateway Filter

The Authentication Filter is responsible for validating every protected request before forwarding it to the backend service.

Current Responsibilities

- Check Authorization Header
- Validate Bearer Token Format
- Reject Unauthorized Requests

Future Responsibilities

- JWT Validation
- Role Validation
- Token Expiration Check
- User Authentication

Current Flow

```text
Client

↓

Authorization Header

↓

Gateway

↓

Authentication Filter

↓

Order Service
```

---

# 🔑 JWT Infrastructure

The project already contains the initial JWT infrastructure.

Current Implementation

- JWT Service
- Token Validation Logic
- Claims Extraction
- Username Extraction

Upcoming

- Token Generation
- Refresh Token
- Expiration Validation
- Role Extraction
- Spring Security Integration

JWT Flow

```text
Client

↓

Bearer Token

↓

Gateway

↓

JWT Service

↓

Extract Claims

↓

Validate Token

↓

Forward Request
```

---

# ❤️ Resilience4j

Resilience4j is added to make the microservices fault tolerant.

Current Status

- Dependency Added
- Integration Ready

Upcoming Features

- Circuit Breaker
- Retry
- Time Limiter
- Rate Limiter
- Bulkhead
- Fallback APIs

Future Flow

```text
Gateway

↓

Order Service

↓

Circuit Breaker

↓

Inventory Service

↓

Fallback
```

---

# 🧪 API Testing

The application has been tested using **Postman**.

## Fetch Products

```http
GET http://localhost:8080/api/v1/products
```

---

## Create Order

```http
POST http://localhost:8080/orders/core/create-order
```

Request Body

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

## Fetch Orders

```http
GET http://localhost:8080/orders/core
```

---

# ⚙️ Running the Project

Start services in the following order

```
1. Discovery Service

↓

2. Inventory Service

↓

3. Order Service

↓

4. API Gateway
```

---

# 🌐 Service URLs

| Service | Port |
|----------|------|
| Eureka Server | 8761 |
| API Gateway | 8080 |
| Inventory Service | 9010 |
| Order Service | 9020 |

---

# 🗄️ Database Configuration

The project uses **PostgreSQL**.

Create two databases.

```
inventoryDB

orderDB
```

Update database credentials inside

```
application.properties
```

---

# 📊 Logging

Logging is enabled throughout the application.

The gateway logs

- Request Method
- Request URI
- Response Status
- Processing Time

This helps during

- Debugging
- Monitoring
- Production Support

---

# 🧩 Configuration

Each microservice has its own

- application.properties
- Database
- Controller Layer
- Service Layer
- Repository Layer
- DTO Layer

The API Gateway manages routing and service discovery.

---

# 📈 Current Project Progress

## Backend

- ✅ Spring Boot
- ✅ Java 21
- ✅ PostgreSQL
- ✅ JPA
- ✅ Hibernate

---

## Microservices

- ✅ Order Service
- ✅ Inventory Service
- ✅ OpenFeign

---

## Spring Cloud

- ✅ Eureka
- ✅ API Gateway
- ✅ Load Balancer

---

## Gateway

- ✅ Global Logging Filter
- ✅ Route Logging Filter
- ✅ Authentication Gateway Filter
- ✅ JWT Infrastructure

---

## Reliability

- ✅ Resilience4j Setup

---

## Testing

- ✅ Postman
- ✅ End-to-End Request Flow
- ✅ Gateway Routing
- ✅ Service Discovery

---

# 🎯 What This Project Demonstrates

This project demonstrates practical knowledge of

- Enterprise Java Development
- Spring Boot
- Spring Cloud
- Distributed Systems
- RESTful APIs
- API Gateway
- Gateway Filters
- Netflix Eureka
- Service Discovery
- OpenFeign
- Load Balancing
- DTO Design
- Layered Architecture
- PostgreSQL
- JWT Basics
- Circuit Breaker Design
- Production-inspired Backend Architecture
# 🐳 Docker (Upcoming)

The project is designed to be containerized using Docker.

Planned Docker Images

- API Gateway
- Discovery Service
- Order Service
- Inventory Service
- PostgreSQL

Future Architecture

```text
Docker Network

│

├── API Gateway

├── Eureka Server

├── Inventory Service

├── Order Service

├── PostgreSQL (Inventory)

└── PostgreSQL (Order)
```

Upcoming

- Dockerfiles
- Docker Compose
- Multi Container Deployment

---

# ☸️ Kubernetes (Upcoming)

The application will be deployed using Kubernetes.

Planned Components

- Deployment
- Service
- ConfigMap
- Secret
- Ingress
- Horizontal Pod Autoscaler

Architecture

```text
Internet

↓

Ingress

↓

API Gateway

↓

Microservices

↓

PostgreSQL
```

---

# ☁️ AWS Deployment (Upcoming)

Target AWS Services

- Amazon EC2
- Amazon RDS
- Elastic Load Balancer
- Auto Scaling
- IAM
- CloudWatch

Deployment Pipeline

```text
GitHub

↓

GitHub Actions

↓

Docker Build

↓

AWS EC2

↓

Running Containers
```

---

# 📈 Monitoring (Upcoming)

Monitoring Stack

- Spring Boot Actuator
- Prometheus
- Grafana

Metrics

- CPU Usage
- Memory Usage
- API Response Time
- Request Count
- JVM Metrics
- Database Connections

---

# 🔍 Distributed Tracing (Upcoming)

Tracing Stack

- Micrometer
- Zipkin

Benefits

- Request Tracking
- Performance Monitoring
- Debugging
- Latency Analysis

Flow

```text
Gateway

↓

Order Service

↓

Inventory Service

↓

Database
```

---

# 📨 Event Driven Architecture (Upcoming)

Apache Kafka will be used for asynchronous communication.

Future Services

- Notification Service
- Payment Service
- Email Service

Example

```text
Order Created

↓

Kafka

↓

Notification Service

↓

Email Sent
```

---

# ⚡ Caching (Upcoming)

Redis will be integrated for

- Product Cache
- Frequently Accessed Data
- Session Storage
- API Response Caching

Benefits

- Faster APIs
- Reduced Database Load
- Better Scalability

---

# 🔐 Security Roadmap

Upcoming Features

- Spring Security
- JWT Authentication
- Refresh Token
- Role Based Authorization
- API Key Authentication
- Password Encryption
- CSRF Protection
- CORS Configuration

Authentication Flow

```text
Client

↓

Login

↓

Authentication Service

↓

JWT Generation

↓

Gateway Validation

↓

Microservice
```

---

# ⚙️ CI/CD Pipeline (Upcoming)

GitHub Actions will automate

- Build
- Test
- Package
- Docker Build
- Deployment

Pipeline

```text
Developer

↓

Git Push

↓

GitHub Actions

↓

Run Tests

↓

Build Jar

↓

Build Docker Image

↓

Deploy
```

---

# 📚 Learning Outcomes

This project helped in understanding

### Spring Boot

- REST APIs
- Spring Data JPA
- Hibernate
- DTO Pattern
- Dependency Injection

---

### Spring Cloud

- API Gateway
- Netflix Eureka
- OpenFeign
- Load Balancer
- Gateway Filters
- Authentication Filters

---

### Backend Engineering

- Microservices Architecture
- Distributed Systems
- Layered Architecture
- Repository Pattern
- Service Pattern
- Database Design

---

### Production Concepts

- JWT Infrastructure
- Circuit Breaker
- Centralized Routing
- Service Discovery
- Logging
- Monitoring
- Scalability

---
---

# 🔭 Observability

Modern distributed systems require more than just REST APIs and databases. To improve debugging, monitoring, and request visibility, this project incorporates production-inspired observability components.

## ✅ Implemented

- Micrometer Tracing
- Distributed Tracing with Zipkin
- ELK Stack Infrastructure
- Docker-based Observability Setup
- Structured Logging Support
- Trace ID & Span ID Propagation

---

# 🔍 Distributed Tracing with Zipkin

The project uses **Micrometer Tracing** together with **Zipkin** to trace requests across multiple microservices.

Instead of treating each service independently, every request carries a **Trace ID**, allowing the complete lifecycle of a request to be tracked from the API Gateway to downstream services.

### Request Flow

```text
Client
   │
   ▼
API Gateway
   │
   ▼
Order Service
   │
   ▼
Inventory Service
   │
   ▼
PostgreSQL
```

### Benefits

- End-to-End Request Tracking
- Cross-Service Debugging
- Performance Monitoring
- Latency Analysis
- Trace Correlation Across Services

---

# 📊 Centralized Logging (ELK Stack)

To support centralized logging in a distributed architecture, the project uses the **ELK Stack**.

### ELK Components

| Component | Responsibility |
|-----------|----------------|
| Elasticsearch | Stores and indexes application logs |
| Logstash | Collects and processes log events |
| Kibana | Visualizes and searches logs |

---

## Logging Architecture

```text
API Gateway
      │
Order Service
      │
Inventory Service
      │
      ▼
 Structured Logging
      │
      ▼
   Logstash
      │
      ▼
 Elasticsearch
      │
      ▼
    Kibana
```

### Features

- Centralized Log Aggregation
- Structured JSON Logging
- Service-wise Log Monitoring
- Faster Production Debugging
- Searchable Log History
- Trace ID Correlation

---

# 🐳 Observability Infrastructure

All observability services are containerized using **Docker**.

| Component | Port |
|-----------|------|
| Elasticsearch | 9200 |
| Kibana | 5601 |
| Logstash | 9600 |
| Zipkin | 9411 |

---

# 📈 Monitoring Architecture

```text
                    Client
                       │
                       ▼
                 API Gateway
                       │
         ┌─────────────┴─────────────┐
         ▼                           ▼
 Order Service                Inventory Service
         │                           │
         └────────── OpenFeign ──────┘
                       │
                  PostgreSQL

──────────────────────────────────────────────

           Observability Layer

Micrometer ─────────────► Zipkin

Structured Logs ────────► Logstash

Logstash ───────────────► Elasticsearch

Elasticsearch ─────────► Kibana
```

---

# 🚀 Current Observability Status

| Feature | Status |
|---------|--------|
| Micrometer Tracing | ✅ Implemented |
| Distributed Tracing (Zipkin) | ✅ Implemented |
| ELK Docker Infrastructure | ✅ Implemented |
| Elasticsearch | ✅ Running |
| Kibana | ✅ Running |
| Logstash | ✅ Running |
| Structured Logback Logging | 🚧 In Progress |
| Spring Boot → Logstash Integration | 🚧 In Progress |

---

# 🎯 Learning Outcome

Through this implementation, the project demonstrates practical understanding of:

- Distributed Tracing
- Request Correlation
- Enterprise Observability
- Dockerized Infrastructure
- Centralized Logging Architecture
- Production-Style Monitoring Foundations
- Spring Boot Logging Ecosystem
- Debugging Distributed Microservices

# 🚀 Future Scope

The project will continue evolving with

- Authentication Service
- User Service
- Product Service
- Cart Service
- Payment Service
- Notification Service
- Config Server
- Kafka
- Redis
- Docker
- Kubernetes
- AWS
- GitHub Actions
- Prometheus
- Grafana
- Zipkin
- ELK Stack
- Distributed Tracing
- OAuth2
- Spring Authorization Server

---

# 🏆 Resume Highlights

This project demonstrates practical knowledge of

- Java 21
- Spring Boot
- Spring Cloud
- API Gateway
- Netflix Eureka
- OpenFeign
- PostgreSQL
- JPA & Hibernate
- Resilience4j
- JWT Infrastructure
- Gateway Filters
- Distributed Systems
- RESTful APIs
- Layered Architecture
- Enterprise Backend Development

---

# 📸 Screenshots

You can include screenshots of

- Eureka Dashboard
- API Gateway Logs
- Order Creation
- Inventory APIs
- PostgreSQL Tables
- Postman Collection
- Gateway Routing
- Filters Execution

---

# 🤝 Contributing

Contributions are welcome.

If you'd like to improve this project

1. Fork the repository
2. Create a feature branch
3. Commit your changes
4. Push the branch
5. Open a Pull Request

---

# 📄 License

This project is created for learning purposes.

You are free to fork and use it for educational purposes.

---

# 👨‍💻 Author

## Vishal Singh

Backend Developer | Java | Spring Boot | Spring Cloud

🎓 B.Tech Computer Science & Engineering (2027)

### Connect with me

**GitHub**

https://github.com/VISHAL55UIET

**LinkedIn**

https://www.linkedin.com/in/vishal-singh-5b052828a/

---

# ⭐ Support

If you found this project helpful,

⭐ Star the repository

🍴 Fork it

📢 Share it

---

# 💡 Final Note

This repository is not intended to be just another CRUD application.

The goal of this project is to learn and implement real-world backend engineering concepts including microservices, distributed systems, API Gateway, service discovery, resilience patterns, authentication, observability, containerization, orchestration, and cloud deployment.

The project will continue evolving with production-grade features to better reflect modern enterprise backend architecture.

---

<div align="center">

## ⭐ Thanks for visiting ⭐

### Happy Coding 🚀

Made with ❤️ by Vishal Singh

</div>

---
