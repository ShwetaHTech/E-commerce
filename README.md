## What I Did in This Project

- Developed a Spring Boot–based E-Commerce web application following MVC architecture to understand real-world backend workflows.
- Implemented cart management features including add to cart, remove item, and clear cart functionality.
- Designed and mapped JPA entities for cart and order modules with MySQL database using Hibernate.
- Built Controller and Repository layers using Spring MVC and Spring Data JPA to handle business logic and persistence.
- Integrated Razorpay payment gateway (Test Mode) for online payment processing and order success handling.
- Used Thymeleaf templates to render dynamic content on the frontend.
- Configured database and third-party integrations using application.properties.
- Debugged and resolved common Spring Boot issues such as dependency conflicts, entity mapping errors, and request mapping issues.
- Gained hands-on experience with end-to-end request flow: UI → Controller → Repository → Database → View.


##  How to Run the Project
1. Clone the repository
   git clone https://github.com/your-username/your-repo-name.git


2. Open the project in **IntelliJ IDEA / Eclipse**

3. Configure database in `application.properties`
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/ecommerce
spring.datasource.username=root
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
Add Razorpay test credentials

razorpay.key.id=your_key_id
razorpay.key.secret=your_key_secret
Run the application as Spring Boot App

Access the application in browser

http://localhost:8080
