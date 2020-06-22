# Spring_Boot_Student_Application
This is a project to demonstrate student application using spring boot. It has basic CRUD operations.                                         
mysql is used to store / update / fetch data for the application.

# Getting Started :
Below mentioned instructions will get you a copy of the project up and running on your local machine for testing purposes.

# Prerequisites :
IntelliJ Idea                                                                                                                                                                                  
Java 8                                                                                                                                                                  

Please follow the below mentioned steps to get a working repo :                                                       
Clone the repository via ssh/http using URL --                                                                                      
https://github.com/navsinghoberoi/Spring_Boot_Student_Application.git

# DB Setup :                                           
In **application.properties** file, specify correct db url value for the key **spring.datasource.url**
The name of the database mentioned in the application.properties file should be created on the local mysql database. 
(No need to create any table, that will be created automatically)

# Running application :
To start the application on the server, run the following command -                                                                                                                                     
**mvn spring-boot:run**

# CRUD api endpoints for student application :
1. http://localhost:8080/getStudents
2. http://localhost:8080/getStudentById/{id}
3. http://localhost:8080/addStudent
4. http://localhost:8080/updateStudent
5. http://localhost:8080/deleteStudent/{id}

# Built With :
1. Spring Boot
2. Java
3. Maven
4. Git
5. my-sql db

# Author :
Navpreet Singh

# Structure of the packages :
Remember below mentioned points before creating new classes --       
a) Adding controller class for an entity --                                                           
To add controller class, go to /src/main/java/com/example/demo/controller folder and create a new file with suffix as Controller

b) Adding data model class for an entity (that contains info like request body getters / setters , db table name) --                                                              
To add model class, go to /src/main/java/com/example/demo/model folder and create a new file

c) Adding service class for an entity --                                                              
To add model class, go to /src/main/java/com/example/demo/service folder and create a new file
