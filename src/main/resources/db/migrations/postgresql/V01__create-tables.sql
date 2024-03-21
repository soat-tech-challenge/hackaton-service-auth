CREATE TABLE IF NOT EXISTS emp_employee (
    id                      BIGSERIAL PRIMARY KEY,
    registration_number     VARCHAR(255) NOT NULL UNIQUE,
    password                VARCHAR(255) NOT NULL,
    email                   VARCHAR(255) NOT NULL UNIQUE,
    deleted                 BOOLEAN NOT NULL,
    creation_date           TIMESTAMP(6) NOT NULL,
    last_update_date        TIMESTAMP(6) NOT NULL
);

INSERT INTO emp_employee (registration_number, password, email, deleted, creation_date, last_update_date)
VALUES ('123456', '$2a$12$e4lXO2O8zVKLiQSXiemUl.2cQghCW8GivADB6Be50bRBg7xZX6vCu', 'exemplo@email.com', FALSE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
