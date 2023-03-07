CREATE TABLE users (
                      id BIGINT NOT NULL AUTO_INCREMENT,
                      username VARCHAR(50) NOT NULL,
                      email VARCHAR(100) NOT NULL,
                      password VARCHAR(100) NOT NULL,
--                       created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
--                       updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
                      token VARCHAR(255) NULL,
                      PRIMARY KEY (id),
                      UNIQUE KEY (username),
                      UNIQUE KEY (email)
);