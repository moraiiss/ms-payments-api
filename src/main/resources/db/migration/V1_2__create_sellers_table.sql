CREATE TABLE sellers (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL
);

INSERT INTO sellers (name, email, password)
VALUES
    ('Shop A', 'shop.a@example.com', 'password123'),
    ('Shop B', 'shop.b@example.com', 'password123'),
    ('Shop C', 'shop.c@example.com', 'password123');
