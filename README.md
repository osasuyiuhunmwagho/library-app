# Library Management System

A backend **Library Management System** built with **Java**, using **PostgreSQL** for persistence.  
API endpoints are tested with **Postman**, and the database is managed using **pgAdmin4**.

> ⚠️ Replace any placeholder values enclosed in `< >` before running the application.

---

## Table of Contents

- [Project Overview](#project-overview)
- [Features](#features)
- [Tech Stack](#tech-stack)
- [Prerequisites](#prerequisites)
- [Configuration](#configuration)
- [Database Setup](#database-setup)
- [Build & Run](#build--run)
- [API Endpoints (Examples)](#api-endpoints-examples)
- [Testing with Postman](#testing-with-postman)
- [Running Automated Tests](#running-automated-tests)
- [Troubleshooting](#troubleshooting)
- [Contributing](#contributing)
- [License](#license)
- [Contact](#contact)

---

## Project Overview

This project is a **Java-based backend system** for managing a library’s core operations, including **books**, **users (members)**, and **loans**.  
It supports adding and updating books, registering users, and issuing or returning loans. The API is tested using Postman, with PostgreSQL as the database backend.

---

## Features

- CRUD operations for **Books**
- CRUD operations for **Users (Library Members)**
- Issue and return **Book Loans**
- Basic validation and error handling
- Example Postman collection for API exploration

---

## Tech Stack

- **Java** (backend)
- **PostgreSQL** (database)
- **pgAdmin4** (database administration)
- **Postman** (manual API testing)
- **Build Tool**: Maven or Gradle (depending on project configuration)

---

## Prerequisites

- Java JDK **11+**
- Maven or Gradle
- PostgreSQL server
- pgAdmin4 (optional)
- Postman

---

## Configuration

Create a configuration file or environment variables depending on how the application reads configuration.

### Example (Spring Boot – `application.properties`)

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/<DB_NAME>
spring.datasource.username=<DB_USER>
spring.datasource.password=<DB_PASSWORD>
spring.jpa.hibernate.ddl-auto=update
server.port=8080
