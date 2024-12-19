CREATE TABLE sellers (
    id VARCHAR(36) PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    document VARCHAR(14) NOT NULL UNIQUE,
    created_at DATETIME NOT NULL
);

-- Inserir dados fictícios na tabela sellers
INSERT INTO sellers (id, name, email, document, created_at) VALUES
    ('1e2d3c4b-5a6f-7e8d-9c0b-1a2b3c4d5e6f', 'Seller One', 'seller1@example.com', '12345678901234', '2023-01-01 10:00:00'),
    ('2e3d4c5b-6a7f-8e9d-0c1b-2a3b4c5d6e7f', 'Seller Two', 'seller2@example.com', '23456789012345', '2023-01-02 11:00:00');
