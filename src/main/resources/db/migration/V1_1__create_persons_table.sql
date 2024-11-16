CREATE TABLE persons (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    personType VARCHAR(255) NOT NULL,
    documentType VARCHAR(255) NOT NULL,
    document VARCHAR(16) NOT NULL UNIQUE,
    email VARCHAR(255) NOT NULL UNIQUE,
    balance DECIMAL(10, 2) NOT NULL DEFAULT 0.00,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP
);

INSERT INTO persons (name, personType, documentType, document, email, balance) VALUES
('John Doe', 'SELLER', 'CPF', '12345678901', 'john.doe@example.com', 100.00),
('Jane Smith', 'CONSUMER', 'CNPJ', '98765432100', 'jane.smith@example.com', 200.00);
