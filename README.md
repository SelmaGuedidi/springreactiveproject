# Spring Boot WebFlux Microservice with MongoDB

## Overview
This microservice is built using **Spring Boot** and **Spring WebFlux** to provide an asynchronous, non-blocking REST API. It interacts with a **MongoDB NoSQL database** to store and retrieve product information.

## Features
- Retrieve products by **EAN code**.
- Retrieve a product by **EAN code and Store ID**.
- Uses **Spring Data Reactive MongoDB** for database interactions.
- Asynchronous handling with **Spring WebFlux**.
- Includes **unit tests** with JUnit 5 and Mockito.

## Technologies Used
- Java 17
- Spring Boot 3
- Spring WebFlux
- Spring Data MongoDB (Reactive)
- MongoDB
- JUnit 5 & Mockito (for testing)
- Maven

## API Endpoints

### 1. Get all products with a specific EAN
**Request:**
```sh
GET /products/ean/{ean}
```
**Example:**
```sh
curl -X GET "http://localhost:8080/products/ean/123456789" -H "Content-Type: application/json"
```
### 2. Get a product by EAN and Store ID
**Request:**
```sh
GET /products/ean/{ean}/store/{storeId}
```
**Example:**
```sh
curl -X GET "http://localhost:8080/products/ean/123456789/store/1" -H "Content-Type: application/json"
```
## Installation & Setup
### 1. Clone the repository
```sh
git clone https://github.com/selmaguedidi/springreactiveproject.git
```
### 2. Start MongoDB
   Ensure MongoDB is running locally or update application.properties to connect to a remote MongoDB instance.

### 3. Build & Run the Application
```sh
mvn clean install
mvn spring-boot:run
```
The application will start on http://localhost:8080.

## Running Tests
```sh
mvn test
```