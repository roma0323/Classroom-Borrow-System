# Classroom Borrow System

Welcome to the Classroom Borrow System! This project manages classroom equipment borrowing using Spring Boot and MySQL.

## Overview

- **IDE**: JetBrains
- **Framework**: Spring Boot
- **Backend**: MySQL
- **JDK Version**: 17

## File Structure

### Spring Boot File Path

The Spring Boot project follows this structure:

- **Java Files**:
  - `SA_project/src/main/java/com/example/classroomborrowsystem/controller/`: Handles HTTP requests.
  - `SA_project/src/main/java/com/example/classroomborrowsystem/model/`: Contains entity or model classes.
  - `SA_project/src/main/java/com/example/classroomborrowsystem/repository/`: Manages repository interfaces for database operations.
  - `SA_project/src/main/java/com/example/classroomborrowsystem/service/`: Holds service classes for business logic.
  - `SA_project/src/main/java/com/example/classroomborrowsystem/`: Includes the main application class and necessary configurations.

- **Resources**:
  - `SA_project/src/main/resources/`: Contains application properties, templates, static files, etc.
  - `SA_project/src/main/resources/application.properties`: File to set MySQL username and password for database connection.

## MySQL Connection

To connect to MySQL:

1. Set your MySQL username and password in the `application.properties` file located at `SA_project/src/main/resources/application.properties`.

Example:
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/your_database_name
spring.datasource.username=your_username
spring.datasource.password=your_password
