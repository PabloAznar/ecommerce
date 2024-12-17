CREATE TABLE IF NOT EXISTS "USER"(

    id varchar(45) not null primary key,

    name varchar(50) not null,

    surname varchar(50) not null,

    phone varchar(15) not null unique,

    email varchar(50) not null unique,

    password varchar(1000) not null

);

CREATE INDEX IF NOT EXISTS idx_user_login ON "USER"(email, password);
CREATE INDEX IF NOT EXISTS idx_user ON "USER"(id);