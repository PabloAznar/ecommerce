CREATE TABLE IF NOT EXISTS DIRECTION(

    id varchar(45) not null primary key,

    country varchar(20) not null primary key,

    city varchar(20) not null primary key,

    postal varchar(10) not null primary key,

    user_id varchar(45) not null,

    constraint direction_fk_user_id foreign key (user_id) references "user"(id)
);

CREATE INDEX IF NOT EXISTS idx_direction ON TABLE direction(user_id);