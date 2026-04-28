# Employee Management System — BY HARSH and OM

A Spring Boot + Thymeleaf + MySQL web application for managing employee records.

## Features
- Add, Edit, Delete, and View employees
- Live search and department filter
- Dashboard with salary statistics
- Delete confirmation modal
- Form validation

## Tech Stack
- Java 17
- Spring Boot 3.2.5
- Spring Data JPA + Hibernate
- MySQL 8.x
- Thymeleaf + Bootstrap 5.3

## Local Setup

1. Create a MySQL database:
```sql
CREATE DATABASE employee_db;
```

2. Set environment variables (or update application.properties):
```
SPRING_DATASOURCE_URL=jdbc:mysql://localhost:3306/employee_db
SPRING_DATASOURCE_USERNAME=root
SPRING_DATASOURCE_PASSWORD=your_password
```

3. Run the app:
```bash
./mvnw spring-boot:run
```

4. Open: http://localhost:8080

## Cloud Deployment (Railway)

1. Push this project to a GitHub repo
2. Go to railway.app → New Project → Deploy from GitHub
3. Add a MySQL database plugin
4. Set environment variables in Railway dashboard:
   - `SPRING_DATASOURCE_URL` → from Railway MySQL plugin
   - `SPRING_DATASOURCE_USERNAME`
   - `SPRING_DATASOURCE_PASSWORD`
5. Deploy — Railway auto-detects Maven and builds the jar
