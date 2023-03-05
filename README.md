Task Manager

This is a sample Java project that demonstrates how to build a RESTful API using Spring Boot.

Prerequisites

To build and run this project, you'll need:

Java 11 or later
Maven 3.6.3 or later
MySQL 8.0 or later
Getting Started

To build and run the project locally, follow these steps:

1.Clone the repository to your local machine.
2.Configure the MySQL database connection in the application.properties file.
3.Run the following command to build the project:
mvn clean install
4.Run the following command to start the Spring Boot application:
mvn spring-boot:run
5The API should now be available at http://localhost:8080.

API Endpoints

The following endpoints are available in this API:

Endpoint	        Method	    Description
/api/users	        GET	        Get all users
/api/users/{id}	    GET	        Get a user by ID
/api/users	        POST	    Create a new user
/api/users/{id}	    PUT	        Update an existing user by ID
/api/users/{id}	    DELETE	    Delete a user by ID
/api/tasks	        GET	        Get all tasks
/api/tasks/{id}	    GET 	    Get a task by ID
/api/tasks	        POST	    Create a new task
/api/tasks/{id}	    PUT	        Update an existing task by ID
/api/tasks/{id}	    DELETE	    Delete a task by ID

Running Tests

To run the tests for this project, use the following command:
mvn test

Contributing

If you would like to contribute to this project, please follow these guidelines:

Fork the repository.
Create a new branch for your feature or bug fix.
Make your changes and commit them with descriptive messages.
Push your changes to your fork.
Submit a pull request.