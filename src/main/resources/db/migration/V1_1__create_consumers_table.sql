CREATE TABLE consumers (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL
);

INSERT INTO consumers (name, email, password)
VALUES
    ('Alice Johnson', 'alice.johnson@example.com', 'password123'),
    ('Bob Smith', 'bob.smith@example.com', 'password123'),
    ('Charlie Davis', 'charlie.davis@example.com', 'password123');
