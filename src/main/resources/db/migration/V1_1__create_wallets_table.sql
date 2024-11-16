CREATE TABLE IF NOT EXISTS wallets (
    id BIGINT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    type INT NOT NULL,
    document VARCHAR(16) NOT NULL UNIQUE,
    email VARCHAR(255) NOT NULL UNIQUE,
    balance DECIMAL(10, 2) NOT NULL DEFAULT 0.00,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NULL
);

INSERT INTO wallets (name, type, document, email, balance) VALUES
('John Doe', 1, '12345678901', 'john.doe@example.com', 100.00),
('Jane Smith', 2, '98765432100', 'jane.smith@example.com', 200.00);
