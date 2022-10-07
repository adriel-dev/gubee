CREATE TABLE IF NOT EXISTS myapp_user(
    id bigserial PRIMARY KEY,
    username varchar(255) NOT NULL,
    password varchar(255) NOT NULL
);