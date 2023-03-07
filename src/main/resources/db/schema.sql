DROP DATABASE task_manager;

CREATE DATABASE task_manager;

USE task_manager;

CREATE TABLE users (
                      id BIGINT NOT NULL AUTO_INCREMENT,
                      username VARCHAR(50) NOT NULL,
                      email VARCHAR(100) NOT NULL,
                      password VARCHAR(100) NOT NULL,
                      created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
                      updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
                      token VARCHAR(255) NULL,
                      PRIMARY KEY (id),
                      UNIQUE KEY (username),
                      UNIQUE KEY (email)
);

CREATE TABLE tasks (
                      id BIGINT NOT NULL AUTO_INCREMENT,
                      title VARCHAR(100) NOT NULL,
                      description VARCHAR(255) NULL,
                      status VARCHAR(20) NOT NULL,
                      user_id BIGINT NOT NULL,
                      created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
                      updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
                      PRIMARY KEY (id),
                      FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE
);