CREATE TABLE IF NOT EXISTS SHOPPING_CART(

    id varchar(45) not null primary key

);

CREATE INDEX IF NOT EXISTS idx_shopping_cart ON shopping_cart(id);