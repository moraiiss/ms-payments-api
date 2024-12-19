CREATE TABLE wallets (
    id VARCHAR(36) PRIMARY KEY,
    balance DECIMAL(15, 2) NOT NULL,
    seller_id VARCHAR(36) UNIQUE,
    consumer_id VARCHAR(36) UNIQUE,

    FOREIGN KEY (seller_id) REFERENCES sellers (id),
    FOREIGN KEY (consumer_id) REFERENCES consumers (id)
);

-- Inserir dados fictícios na tabela wallets
INSERT INTO wallets (id, balance, seller_id, consumer_id) VALUES
    ('5e6d7c8b-9a0f-1e2d-3c4b-5a6b7c8d9e0f', 1000.00, '1e2d3c4b-5a6f-7e8d-9c0b-1a2b3c4d5e6f', NULL),
    ('6e7d8c9b-0a1f-2e3d-4c5b-6a7b8c9d0e1f', 500.00, NULL, '3e4d5c6b-7a8f-9e0d-1c2b-3a4b5c6d7e8f');