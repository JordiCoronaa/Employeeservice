# Employee Service API

REST API developed with Spring Boot for employee management.

## Technologies

- Java 17
- Spring Boot 2.7.x
- Spring Data JPA
- H2 Database
- Maven
- Swagger / OpenAPI
- JUnit 5
- Mockito
- Docker
- Spring Boot Actuator

---

# Features

- Create employee
- Create multiple employees
- Get all employees
- Get employee by id
- Search employees by name
- Update employee
- Delete employee
- Global exception handling
- Input validations
- API documentation
- Health check endpoints

---

# Project Structure

```txt
src/main/java/com/example/employeeservice

├── controller
├── service
│   └── impl
├── repository
├── entity
├── dto
├── mapper
├── exception
├── config
```

---

# Run Project

## Clone repository

```bash
git clone <repository-url>
```

---

## Build project

```bash
mvn clean install
```

---

## Run application

```bash
mvn spring-boot:run
```

Application runs on:

```txt
http://localhost:8080
```

---

# Swagger Documentation

```txt
http://localhost:8080/swagger-ui/index.html
```

---

# Actuator Endpoints

## Health

```txt
http://localhost:8080/actuator/health
```

## Metrics

```txt
http://localhost:8080/actuator/metrics
```

---

# Docker

## Build Docker image

```bash
docker build -t employee-service .
```

## Run container

```bash
docker run -p 8080:8080 employee-service
```

---

# Testing

Run unit tests:

```bash
mvn test
```

---

# API Endpoints

| Method | Endpoint | Description |
|---|---|---|
| GET | /employees | Get all employees |
| GET | /employees/{id} | Get employee by id |
| POST | /employees | Create employee |
| POST | /employees/batch | Create multiple employees |
| PUT | /employees/{id} | Update employee |
| DELETE | /employees/{id} | Delete employee |
| GET | /employees/search?name=value | Search employees |

---

# Author

Jordi Corona
