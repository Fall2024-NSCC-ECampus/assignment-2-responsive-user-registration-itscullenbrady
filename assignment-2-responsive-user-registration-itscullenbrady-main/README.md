# INET 2005 - Assignment 3: Responsive Login System

## Overview
This project is a responsive login system built using the Spring framework, MySQL, and Bootstrap. It includes user registration, login, and logout functionalities. The project is designed to be responsive, ensuring it works well on different devices such as desktops, tablets, and mobile phones.

## Requirements and Implementation

### 1. Database Setup
- **Requirement:** Create a database to store user information such as usernames, email addresses, and hashed passwords.
- **Implementation:**
  - A MySQL database is set up with a table named `users`.
  - The `users` table includes columns for `id`, `username`, `email`, and `password`.
  - The database connection is configured in the `application.properties` file.
  - **Schema:**
    ```sql
    CREATE TABLE users (
        id INT AUTO_INCREMENT PRIMARY KEY,
        username VARCHAR(50) NOT NULL,
        email VARCHAR(50) NOT NULL,
        password VARCHAR(100) NOT NULL
    );
    ```
  - **Example Entry:**
    ```sql
    INSERT INTO users (username, email, password) VALUES ('john_doe', 'john@example.com', '$2a$10$...');
    ```

### 2. Login Form
- **Requirement:** Create a form using Bootstrap that collects user input for logging in.
- **Implementation:**
  - A login form is created in the `login.html` file using Bootstrap for styling.
  - The form collects `username` and `password` from the user.

### 3. Login Functionality
- **Requirement:** Process the submitted login form data, validate and sanitize input, query the database, verify the password, and create a session.
- **Implementation:**
  - The `AuthService` class handles the login logic.
  - Input data is validated and sanitized.
  - The database is queried to find the matching user.
  - The submitted password is verified against the hashed password stored in the database.
  - A session is created to maintain the user's logged-in state.
  - **Security Measures:**
    - Passwords are hashed using BCrypt.
    - Input sanitization is performed to prevent SQL injection and XSS attacks.

### 4. Logout Functionality
- **Requirement:** Implement logic to allow users to log out by destroying the session and returning them to the login page.
- **Implementation:**
  - The `AuthController` class includes a method to handle logout by invalidating the session.

### 5. Registration Form
- **Requirement:** Create a registration form for new users to sign up.
- **Implementation:**
  - A registration form is available in `register.html` with fields for `username`, `email`, and `password`.
  - The form validates input and saves new users to the database after hashing the password.

### 6. Responsive Design
- **Requirement:** Create responsive login and registration web pages for different devices.
- **Implementation:**
  - The `login.html` and `register.html` files use Bootstrap to ensure responsiveness.
  - The pages are tested on different devices to ensure they adapt well to various screen sizes.
  - **Tested Devices:**
    - Desktop (1920x1080)
    - Tablet (768x1024)
    - Mobile (375x667)

### 7. Reusable Components
- **Requirement:** Create reusable components for login and registration.
- **Implementation:**
  - The project uses Thymeleaf fragments to create reusable components for the login and registration forms.
  - Thymeleaf fragments help in reusing Bootstrap-styled components across different pages.
  - **Example:**
    ```html
    <!-- login.html -->
    <div th:replace="fragments/loginForm :: loginForm"></div>
    ```

### 8. Business Logic
- **Requirement:** Implement all given requirements and create feasible business logic.
- **Implementation:**
  - The `AuthService` class contains the business logic for user registration and login.
  - The `AuthController` class handles the HTTP requests for login and logout.

### 9. Presentation and Documentation
- **Requirement:** Prepare a GitHub README file and give a classroom presentation.
- **Implementation:**
  - This README file provides detailed documentation of the project.
  - A comprehensive presentation is prepared to explain the project.

## Project Structure
spring-user-registration-main/ ├── INET/ │ ├── src/ │ │ ├── main/ │ │ │ ├── java/ │ │ │ │ ├── com/ │ │ │ │ │ ├── example/ │ │ │ │ │ │ ├── main/ │ │ │ │ │ │ │ ├── AuthService.java │ │ │ │ │ │ │ ├── controller/ │ │ │ │ │ │ │ │ ├── AuthController.java │ │ │ │ │ │ │ ├── model/ │ │ │ │ │ │ │ │ ├── MyUserPrincipal.java │ │ │ │ │ │ │ │ ├── User.java │ │ │ │ │ │ │ ├── repository/ │ │ │ │ │ │ │ │ ├── UserRepository.java │ │ │ │ │ │ │ ├── config/ │ │ │ │ │ │ │ │ ├── SecurityConfig.java │ │ │ │ ├── resources/ │ │ │ │ │ ├── templates/ │ │ │ │ │ │ ├── login.html │ │ │ │ │ │ ├── register.html │ │ │ │ │ │ ├── welcome.html │ │ │ │ │ ├── application.properties

## How to Run the Project
1. **Clone the repository:**
   ```bash
   git clone https://github.com/yourusername/spring-user-registration-main.git
   cd spring-user-registration-main/INET

## Set up the MySQL database:  
- Create a database named user_db.
- Update the application.properties file with your MySQL credentials.

## Build and run the project:  
- mvn clean install
- mvn spring-boot:run

## Access the application:  
- Open your browser and go to http://localhost:8080/login.
