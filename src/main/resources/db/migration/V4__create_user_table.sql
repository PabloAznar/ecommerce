CREATE TABLE IF NOT EXISTS "USER"(

    id varchar(45) not null primary key,

    name varchar(50) not null,

    surname varchar(50) not null,

    phone varchar(15) not null unique,

    email varchar(50) not null unique,

    password varchar(1000) not null,

    shopping_cart_id varchar(45) not null,

    payment_id varchar(45) null,

    constraint user_fk_shopping_cart_id foreign key(shopping_cart_id) references shopping_cart(id)
);

CREATE INDEX IF NOT EXIST idx_user_login ON TABLE "USER"(email, password);
CREATE INDEX IF NOT EXIST idx_user ON TABLE "USER"(id);