# Todo Application

A simple full-stack Todo App built using **Spring Boot**, **Thymeleaf**, and **MySQL**.  
Add, toggle, and delete tasks with a clean and responsive interface.

---

## Features

> Add tasks with title, due date, and priority  
> Toggle tasks as completed or active  
> Delete tasks  
> Filter: All, Active, Completed  
> Mobile-responsive design using Bootstrap  
> MySQL-based data persistence

---

## Tech Stack

- Java 17  
- Spring Boot  
- Thymeleaf  
- MySQL  
- Bootstrap 5

---

## Getting Started

### Prerequisites

- Java 17+  
- Maven  
- MySQL with a database named `todoappdb`

### Configuration

Update `application.properties` with your DB credentials:

spring.datasource.url=jdbc:mysql://localhost:3306/todoappdb
spring.datasource.username=root
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update


### Run the Application

mvn spring-boot:run



Visit: [http://localhost:8080](http://localhost:8080)

---

## Folder Structure

├── controller/
├── models/
├── repository/
├── services/
├── templates/
└── application.properties



---

## Future Improvements

> Add login/authentication  
> REST API version  
> Drag-and-drop task ordering  
> Dark mode toggle

---

## Author

**Parvez Akhtar**  
Designed & developed with Java and love.

---

## License

Open-source under the [MIT License](LICENSE).
