# Spring_Boot_Student_Application
This is a project to demonstrate student application using spring boot. It has basic CRUD operations.                                         
mysql is used to store / update / fetch data for the application.

# Getting Started :
Below mentioned instructions will get you a copy of the project up and running on your local machine for testing purposes.

# Prerequisites :
IntelliJ Idea                                                                                                                                                                                  
Java 8               
Docker                                                                                                                                                   
                                                       
Clone the repository via ssh/http using URL -->                                                                                      
https://github.com/navsinghoberoi/Spring_Boot_Student_Application.git

# DB Setup :                                           
In **application.properties** file, specify correct db url value for the key **spring.datasource.url**
The name of the database mentioned in the application.properties file must be created on the local mysql database. 
(No need to create any table, that will be created automatically)

# Running application :
To start the application on the server, run the following command -                                                                                                                                     
**mvn spring-boot:run**

# CRUD api endpoints for student application :
1. http://localhost:8080/student/getAll
2. http://localhost:8080/student/getById/{id}
3. http://localhost:8080/student/getByNumber/{phoneNumber}
4. http://localhost:8080/student/add
5. http://localhost:8080/student/update
6. http://localhost:8080/student/delete/{id}

# Static code and code coverage analysis  :
1. Go to src/main/resources folder.
2. Run the command **docker-compose up -d** (Make sure docker is running on machine)
3. Go to browser and open **localhost:9000**, sign in via admin account and generate a token.
4. Go to Administration > Analysis Scope > Test File Inclusions --> Enter **/*Test*/** in the pattern 
5. Go to base path of project & run the command to perform analysis **mvn clean install sonar:sonar -Dsonar.host.url=http://localhost:9000 -Dsonar.login=xyz** 

# Built With :
1. Spring Boot
2. Java
3. Maven
4. Git
5. my-sql db
6. Sonarqube
7. Docker
8. Jacoco

# Author :
Navpreet Singh

# Structure of the packages :
Remember below mentioned points before creating new classes -->       
a) Adding controller class for an entity -->                                                           
To add controller class, go to /src/main/java/com/example/demo/controller folder and create a new file with suffix as Controller

b) Adding data model class for an entity (that contains info like request body getters / setters , db table name) -->                                                              
To add model class, go to /src/main/java/com/example/demo/model folder and create a new file

c) Adding service class for an entity -->                                                              
To add model class, go to /src/main/java/com/example/demo/service folder and create a new file
