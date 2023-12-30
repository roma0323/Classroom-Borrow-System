# Classroom Borrow System

Welcome to the Classroom Borrow System! This project manages classroom equipment borrowing using Spring Boot and MySQL.

## Overview

- **IDE**: IntelliJ IDEA
- **Framework**: Spring Boot 3.2.0
- **Database**: MySQL
- **JDK Version**: 17

## Getting Started

### Prerequisites

- **IDE**: [IntelliJ IDEA](https://www.jetbrains.com/idea/)
- **Framework**: Spring Boot 3.2.0 **(included in IntelliJ IDEA)**
- **Database**: [MySQL](https://dev.mysql.com/downloads/mysql/)
- **JDK Version**: [17](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)

### Run the project

1. Open this project by **IntelliJ IDEA**
2. Enter your MySQL username and password in the `application.properties` file located at `SA_project/src/main/resources/application.properties`.
    ```properties
    spring.datasource.url=jdbc:mysql://localhost:3306/your_database_name
    spring.datasource.username=your_username
    spring.datasource.password=your_password
    ```
3. Run `ServingWebContentApplication`
4. View result at http://localhost:8080/

## File Structure

### Spring Boot File Path

The Spring Boot project follows this structure:

- **Java Files**:
- com/example/servingwebcontent/Daniel/DanielGreetingController.java
  - `SA_project/src/main/java/com/example/servingwebcontent/{develop_user}/controller/`: Handles HTTP requests.
  - `SA_project/src/main/java/com/example/servingwebcontent/{develop_user}/model/`: Contains entity or model classes.
  - `SA_project/src/main/java/com/example/servingwebcontent/{develop_user}/repository/`: Manages repository interfaces for database operations.
  - `SA_project/src/main/java/com/example/servingwebcontent/{develop_user}/service/`: Holds service classes for business logic.
  - `SA_project/src/main/java/com/example/servingwebcontent/`: Includes the main application class and necessary configurations.

- **Resources**:
  - `SA_project/src/main/resources/`: Contains application properties, templates, static files, etc.
  - `SA_project/src/main/resources/application.properties`: File to set MySQL username and password for database connection.
