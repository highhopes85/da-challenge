CREATE TABLE fruit (
    id   INTEGER NOT NULL AUTO_INCREMENT,
    name VARCHAR NOT NULL UNIQUE,
    nutritions_id INTEGER NOT NULL,
    family VARCHAR NOT NULL,
    genus VARCHAR NOT NULL,
    order_class VARCHAR NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE fruit_nutritions (
    id   INTEGER NOT NULL AUTO_INCREMENT,
    carbohydrates NUMERIC(5,2) NOT NULL,
    protein NUMERIC(5,2) NOT NULL,
    fat NUMERIC(5,2) NOT NULL,
    calories INTEGER NOT NULL,
    sugar NUMERIC(5,2) NOT NULL,
    PRIMARY KEY (id)
);