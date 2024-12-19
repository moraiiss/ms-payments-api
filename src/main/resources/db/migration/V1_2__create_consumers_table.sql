CREATE TABLE consumers (
    id VARCHAR(36) PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    document VARCHAR(11) NOT NULL UNIQUE,
    created_at DATETIME NOT NULL
);

-- Inserir dados fictícios na tabela consumers
INSERT INTO consumers (id, name, email, document, created_at) VALUES
    ('3e4d5c6b-7a8f-9e0d-1c2b-3a4b5c6d7e8f', 'Consumer One', 'consumer1@example.com', '12345678901', '2023-01-03 12:00:00'),
    ('4e5d6c7b-8a9f-0e1d-2c3b-4a5b6c7d8e9f', 'Consumer Two', 'consumer2@example.com', '23456789012', '2023-01-04 13:00:00');