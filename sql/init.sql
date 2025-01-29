CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE IF NOT EXISTS users (
    ID UUID DEFAULT uuid_generate_v4() PRIMARY KEY,
    USERNAME VARCHAR(256) NOT NULL,
    PASSWORD VARCHAR(256) NOT NULL,
    ROLE VARCHAR(256) DEFAULT 'USER'
);

INSERT INTO users (USERNAME, PASSWORD, ROLE) VALUES
('admin', 'admin', 'ADMIN'),
('user',  'user',  'USER'),
('user',  'user',  'USER'),
('user',  'user',  'USER');