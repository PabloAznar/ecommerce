CREATE TABLE IF NOT EXISTS shopping_cart_product (
    shopping_cart_id varchar(45) NOT NULL,
    product_id varchar(45) NOT NULL,
    PRIMARY KEY (shopping_cart_id, product_id),
    CONSTRAINT fk_shopping_cart FOREIGN KEY (shopping_cart_id) REFERENCES SHOPPING_CART(shopping_cart_id),
    CONSTRAINT fk_product FOREIGN KEY (product_id) REFERENCES PRODUCT(product_id)
);

CREATE INDEX IF NOT EXISTS idx_shopping_cart_product ON shopping_cart_product(shopping_cart_id);