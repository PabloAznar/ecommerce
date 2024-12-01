CREATE TABLE IF NOT EXISTS PAYMENT(

    id varchar(45) not null primary key,

    card_number varchar(16) not null,

    expiration_date date not null,

    cvv varchar(3) not null,

    user_id varchar(45) not null,

    constraint payment_fk_user_id foreign key (user_id) references "user"(id)
);

CREATE INDEX IF NOT EXISTS idx_payment ON TABLE payment(user_id);