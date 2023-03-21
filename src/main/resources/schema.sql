CREATE TABLE IF NOT EXISTS history (
    id BIGINT NOT NULL AUTO_INCREMENT,
    hotel_id BIGINT NOT NULL,
    elevator_id BIGINT NOT NULL,
    floor_travelled INT NOT NULL,
    timestamp TIMESTAMP NOT NULL,
    PRIMARY KEY (id)
);
