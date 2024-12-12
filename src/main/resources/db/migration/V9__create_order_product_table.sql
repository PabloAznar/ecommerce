CREATE TABLE IF NOT EXISTS ORDER_PRODUCT (
    order_id varchar(45) NOT NULL,
    product_id varchar(45) NOT NULL,
    PRIMARY KEY (order_id, product_id),
    CONSTRAINT fk_order FOREIGN KEY (order_id) REFERENCES "ORDER"(id),
    CONSTRAINT fk_product FOREIGN KEY (product_id) REFERENCES PRODUCT(id)
);

CREATE INDEX IF NOT EXISTS idx_order_product ON order_product(order_id);