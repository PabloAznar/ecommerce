CREATE TABLE IF NOT EXISTS ORDERS(

    order_id varchar(45) not null primary key,

    creation_date timestamp not null,

    estimated_arrival_date date null,

    status varchar(15) not null,

    user_id varchar(45) not null,

    constraint order_fk_user_id foreign key (user_id) references USERS(user_id)
);

CREATE INDEX IF NOT EXISTS idx_order ON ORDERS(user_id);