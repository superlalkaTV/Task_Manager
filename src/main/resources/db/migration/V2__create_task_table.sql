CREATE TABLE IF NOT EXISTS task (
                                    id INT AUTO_INCREMENT PRIMARY KEY,
                                    description TEXT NOT NULL,
                                    created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                                    deadline TIMESTAMP NOT NULL,
                                    status VARCHAR(20) NOT NULL,
    user_id INT NOT NULL,
    FOREIGN KEY (user_id) REFERENCES user(id)
    );