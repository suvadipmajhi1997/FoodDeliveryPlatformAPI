<h1 align = "center">Food Delivery Platform API</h1>

<p align="center">
<a href="Java url">
    <img alt="Java" src="https://img.shields.io/badge/Java->=8-darkblue.svg" />
</a>
<a href="Maven url" >
    <img alt="Maven" src="https://img.shields.io/badge/maven-3.0.5-brightgreen.svg" />
</a>
<a href="Spring Boot url" >
    <img alt="Spring Boot" src="https://img.shields.io/badge/Spring Boot-3.0.6-brightgreen.svg" />
</a>



---

## Framework Used
* Spring Boot

---

## Language Used
* Java

---
## Dependencies
The following dependencies are required to run the project:

* Spring Boot Dev Tools
* Spring Web
* Spring Data JPA
* MySQL Driver
* Lombok

<br>

## Database Configuration
---
To connect to a MySQL database, update the application.properties file with the appropriate database URL, username, and password. The following properties need to be updated:
```
spring.datasource.driverClassName=com.mysql.cj.jdbc.Driver
spring.datasource.url = jdbc:mysql://localhost:3306/<DatabaseName>
spring.datasource.username = <userName>
spring.datasource.password = <password>
spring.jpa.show-sql = true
spring.jpa.hibernate.ddl-auto = update

spring.jpa.properties.hibernate.show_sql=true
spring.jpa.properties.hibernate.use_sql_comments=true
spring.jpa.properties.hibernate.format_sql=true

```
<br>


## Data Flow

---

</br>


* Controller
```
The user sends a request to the application through the API endpoints.The API receives the request and sends it to the appropriate controller method. The controller method makes a call to the method in service class. The controller method returns a response to the API. The API sends the response back to the user.
```

* Service
```
The primary purpose of a service in Spring Boot is to provide a layer of abstraction between the controllers (or endpoints) and the data access layer (typically represented by repositories or DAOs). Services coordinate the interaction between different components, apply business rules and validations, and perform the necessary operations to fulfill the requested functionality.
```

* DTO
```
 Data Transfer Object. It is a design pattern used to transfer data between different layers or components of an application. DTOs are commonly used in web applications to encapsulate data and transfer it between the client and the server.
```

* Models
```
models refer to the classes or objects that represent the data and domain entities of your application. These models are often used to define the structure and behavior of the data that your application works with. Models in Spring Boot are typically used in conjunction with Object-Relational Mapping (ORM) frameworks like Hibernate or JPA (Java Persistence API) to interact with a relational database.
```

* Repository
```
 repository is a component that provides an abstraction layer for interacting with a database or any other persistence mechanism. Repositories are typically used to perform CRUD (Create, Read, Update, Delete) operations on data entities and provide a higher-level, more convenient API for working with the underlying data storage.
```

---

## Data structure Used
* ArrayList
```
We have used ArrayList data structure as a database to implement CRUD Operations 
```
---

## Project Summary
This Spring Boot Application is a simple task management system that allows users to SignUp, SignIn, SignOut, Create order, view order and Admin Can Add foodItems, delete foodItems, fetch order All order details. It utilizes the Spring Boot framework, with an ArrayList serving as the underlying data structure to store the tasks.

---
## Author

👤 **Suvadip Majhi**

* GitHub: [Suvadipmajhi1997](https://github.com/suvadipmajhi1997)

* LinkedIn: [Suvadip Majhi](https://www.linkedin.com/in/ajinkya-padule-04b8541a6/)
    
---

## 🤝 Contributing

Contributions, issues and feature requests are welcome!<br />Feel free to check [issues page]("url").
    
---
    
## Show your support

Give a ⭐️ if this project helped you!
    
---
    
## 📝 License

Copyright © 2023 [Suvadip Majhi](https://github.com/suvadipmajhi1997).<br />


    
---
