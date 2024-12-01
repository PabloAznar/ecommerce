CREATE TABLE IF NOT EXISTS PRODUCT(

    id varchar(45) not null primary key,

    title varchar(50) not null,

    description text not null,

    price double not null,

    category varchar(20) not null

);