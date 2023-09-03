INSERT INTO service (id, name, value, deleted)
VALUES (1, 'lavagem simples', 50.00, false);
INSERT INTO service (id, name, value, deleted)
VALUES (2, 'lavagem completa', 90.00, false);

INSERT INTO customer (id, address, comments, email, name, phone)
VALUES (1, 'r dr danilo bonilha 99, piazza di roma', null, null, 'Levi', '15991760509');

INSERT INTO car (id, comments, name, plate, customer_id)
VALUES (1, '', 'Corsa 2002', 'DQK2088', 1);

ALTER SEQUENCE service_seq RESTART WITH 3;
ALTER SEQUENCE customer_seq RESTART WITH 2;
ALTER SEQUENCE car_seq RESTART WITH 2;
