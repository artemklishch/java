--liquibase formatted sql
--changeset bchupika:create-product-table splitStatements:true andDelimiter:;
CREATE TABLE products (id BIGINT NOT NULL AUTO_INCREMENT, name VARCHAR(255), PRIMARY KEY (id)) ENGINE=InnoDB;
INSERT INTO `products` VALUES (1, 'iPhoneX');

--rollback DROP TABLE products;