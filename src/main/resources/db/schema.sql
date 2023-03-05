CREATE DATABASE my_database;

USE my_database;

CREATE TABLE user (
                      id INT PRIMARY KEY AUTO_INCREMENT,
                      username VARCHAR(255) NOT NULL,
                      email VARCHAR(255) NOT NULL UNIQUE,
                      password VARCHAR(255) NOT NULL
);

CREATE TABLE task (
                      id INT PRIMARY KEY AUTO_INCREMENT,
                      title VARCHAR(255) NOT NULL,
                      description TEXT,
                      status VARCHAR(255) NOT NULL,
                      user_id INT NOT NULL,
                      FOREIGN KEY (user_id) REFERENCES user(id)
);