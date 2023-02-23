
DROP TABLE IF EXISTS workers;

CREATE TABLE workers(
    id INTEGER NOT NULL AUTO_INCREMENT,
    name VARCHAR(255),
    email VARCHAR(255),
    phone_number VARCHAR(255),
    PRIMARY KEY (id)
);