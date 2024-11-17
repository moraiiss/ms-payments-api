CREATE TABLE wallets (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    consumer_id BIGINT UNIQUE,
    seller_id BIGINT UNIQUE,
    balance DECIMAL(15, 2) NOT NULL DEFAULT 0.00,
    CONSTRAINT fk_wallet_consumer FOREIGN KEY (consumer_id) REFERENCES consumers (id) ON DELETE CASCADE,
    CONSTRAINT fk_wallet_seller FOREIGN KEY (seller_id) REFERENCES sellers (id) ON DELETE CASCADE
);

-- associando carteiras a consumidores
INSERT INTO wallets (consumer_id, balance)
VALUES
    (1, 1000.00),
    (2, 1500.00),
    (3, 500.00);

-- associando carteiras a vendedores
INSERT INTO wallets (seller_id, balance)
VALUES
    (1, 2000.00),
    (2, 3000.00),
    (3, 4000.00);
