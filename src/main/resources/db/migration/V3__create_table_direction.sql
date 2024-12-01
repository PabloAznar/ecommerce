CREATE TABLE IF NOT EXISTS DIRECTION(

    id varchar(45) not null primary key,

    country varchar(20) not null,

    city varchar(20) not null,

    postal varchar(10) not null

);

CREATE INDEX IF NOT EXISTS idx_direction ON direction(id);