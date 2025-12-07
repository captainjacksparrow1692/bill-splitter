-- Таблица чеков
CREATE TABLE bill (
                      id BIGSERIAL PRIMARY KEY,
                      created_at TIMESTAMP NOT NULL DEFAULT NOW(),
                      commission DOUBLE PRECISION NOT NULL,
                      total_amount DOUBLE PRECISION
);

-- Участники счёта
CREATE TABLE person (
                        id BIGSERIAL PRIMARY KEY,
                        bill_id BIGINT NOT NULL REFERENCES bill(id) ON DELETE CASCADE,
                        name VARCHAR(255) NOT NULL,
                        amount_to_pay DOUBLE PRECISION
);

-- Блюда
CREATE TABLE item (
                      id BIGSERIAL PRIMARY KEY,
                      bill_id BIGINT NOT NULL REFERENCES bill(id) ON DELETE CASCADE,
                      name VARCHAR(255) NOT NULL,
                      price DOUBLE PRECISION NOT NULL
);

-- Связь "кто ел какое блюдо"
CREATE TABLE item_consumers (
                                item_id BIGINT NOT NULL REFERENCES item(id) ON DELETE CASCADE,
                                person_id BIGINT NOT NULL REFERENCES person(id) ON DELETE CASCADE,
                                PRIMARY KEY(item_id, person_id)
);
