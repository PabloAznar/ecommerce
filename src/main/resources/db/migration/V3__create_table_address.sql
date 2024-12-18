CREATE TABLE IF NOT EXISTS ADDRESS(

    id varchar(45) not null primary key,

    country varchar(20) not null,

    city varchar(20) not null,

    street varchar(80) not null,

    postal_code varchar(10) not null,

    user_id varchar(45) not null,

    constraint address_user_id foreign key (user_id) references "USER"(id)

);

CREATE INDEX IF NOT EXISTS idx_address ON address(user_id);