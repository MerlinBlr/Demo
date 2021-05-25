DROP TABLE IF EXISTS retailer;
DROP TABLE IF EXISTS product;
DROP TABLE IF EXISTS RetailerProductRelation;

CREATE TABLE retailer (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  name VARCHAR(250) NOT NULL,
  description VARCHAR(250)
);

CREATE TABLE product (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  name VARCHAR(250) NOT NULL,
  description VARCHAR(250),
  stock_level INT default 0
);

CREATE TABLE retailer_product_relation(
  retailer_id INT NOT NULL,
  product_id INT NOT NULL,
  FOREIGN KEY (retailer_id) REFERENCES retailer(id),
  FOREIGN KEY (product_id) REFERENCES product(id),
  UNIQUE (retailer_id, product_id)
);

CREATE SEQUENCE seq_product START WITH 1;
CREATE SEQUENCE seq_retailer START WITH 1;
