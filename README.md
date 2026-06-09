# Smart Campus Management System

## Project Overview
Smart Campus Management System is a Java-based console application developed to manage various campus activities such as student management, faculty management, attendance tracking, complaint management, and event management. The project uses Java, JDBC, and MySQL for database connectivity and data storage.

## Features

### Student Management
- Add Student
- View Students
- Delete Student

### Faculty Management
- Add Faculty
- View Faculty
- Delete Faculty

### Attendance Management
- Mark Attendance
- View Attendance Records

### Complaint Management
- Register Complaints
- View Complaints

### Event Management
- Add Events
- View Events

## Technologies Used

- Java
- JDBC
- MySQL
- VS Code
- Git & GitHub

## Database Connectivity

This project uses MySQL Database with JDBC Driver for storing and retrieving data.

Database Name:
```
smart_campus
```

## Project Structure

```
SmartCampusManagementSystem
│
├── src
│   ├── MainMenu.java
│   ├── DBConnection.java
│   ├── StudentManagement.java
│   ├── FacultyManagement.java
│   ├── AttendanceManagement.java
│   ├── ComplaintManagement.java
│   ├── EventManagement.java
│
├── lib
│   └── mysql-connector-j-9.7.0.jar
│
└── README.md
```

## How to Run

1. Install Java JDK 17 or above.
2. Install MySQL Server.
3. Create database:

```sql
CREATE DATABASE smart_campus;
```

4. Configure database credentials in `DBConnection.java`.
5. Add MySQL JDBC Connector to project libraries.
6. Run:

```bash
MainMenu.java
```

## Sample Menu

```
===== SMART CAMPUS MANAGEMENT SYSTEM =====

1. Student Management
2. Faculty Management
3. Attendance Management
4. Complaint Management
5. Event Management
6. Exit
```

## Future Enhancements

- GUI Application using Java Swing
- Web Application using Spring Boot
- Login Authentication
- Admin Dashboard
- Report Generation
- Cloud Database Integration

## Author

Akhil Devalla

B.Tech Electronics and Communication Engineering (ECE)

Narasaraopeta Engineering College

## GitHub Repository

Smart Campus Management System Project developed using Java, JDBC, and MySQL for academic and placement purposes.
