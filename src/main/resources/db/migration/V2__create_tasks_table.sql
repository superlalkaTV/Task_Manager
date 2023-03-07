CREATE TABLE tasks (
                      id BIGINT NOT NULL AUTO_INCREMENT,
                      title VARCHAR(100) NOT NULL,
                      description VARCHAR(255) NULL,
                      status VARCHAR(20) NOT NULL,
                      user_id BIGINT NOT NULL,
--                       created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
--                       updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
                      PRIMARY KEY (id),
                      FOREIGN KEY (user_id) REFERENCES user (id) ON DELETE CASCADE
);