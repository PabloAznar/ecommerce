CREATE TABLE IF NOT EXISTS SHOPPING_CART(

    shopping_cart_id varchar(45) not null primary key,
    user_id varchar(45),
    constraint shopping_cart_fk_user_id foreign key (user_id) references USERS(user_id)
);

CREATE INDEX IF NOT EXISTS idx_shopping_cart ON shopping_cart(shopping_cart_id);
CREATE INDEX IF NOT EXISTS idx_user_shopping_cart ON shopping_cart(user_id);