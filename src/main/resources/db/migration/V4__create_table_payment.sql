CREATE TABLE IF NOT EXISTS PAYMENT(

    id varchar(45) not null primary key,

    card_number varchar(20) unique not null,

    expiration_date date not null,

    cvv varchar(3) not null,

    user_id varchar(45) not null,

    constraint payment_user_id foreign key (user_id) references "USER"(id)
);

CREATE INDEX IF NOT EXISTS idx_payment ON payment(user_id);