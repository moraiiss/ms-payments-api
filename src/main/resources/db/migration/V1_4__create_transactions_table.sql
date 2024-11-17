CREATE TABLE transactions (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    payer_id BIGINT NOT NULL,
    payee_id BIGINT NOT NULL,
    amount DECIMAL(15, 2) NOT NULL,
    status VARCHAR(50) NOT NULL DEFAULT 'PENDING',
    transaction_date DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT fk_transaction_payer FOREIGN KEY (payer_id) REFERENCES wallets (id),
    CONSTRAINT fk_transaction_payee FOREIGN KEY (payee_id) REFERENCES wallets (id)
);

INSERT INTO transactions (payer_id, payee_id, amount, status, transaction_date)
VALUES
    -- transações entre consumidores
    (1, 2, 200.00, 'COMPLETED', '2024-11-01 10:30:00'),
    (2, 3, 150.00, 'PENDING', '2024-11-02 12:45:00'),

    -- transações de consumidores para vendedores
    (3, 4, 500.00, 'COMPLETED', '2024-11-03 14:00:00'),
    (1, 5, 300.00, 'FAILED', '2024-11-04 16:20:00'),
    (2, 6, 250.00, 'COMPLETED', '2024-11-05 18:15:00');
