-- drop database if exists projection_demo;
-- create database projection_demo;
use projection_demo;

INSERT INTO `projection_demo`.`customer` (`address`, `date_of_birth`, `email`, `gender`, `id_card`, `name`, `phone_number`) VALUES ('Đà Nẵng', '10/12/2000', 'trungnoo196@gmail.com', 'Nam', '123456789', 'Nông Quốc Trung', '0123456789');
INSERT INTO `projection_demo`.`customer` (`address`, `date_of_birth`, `email`, `gender`, `id_card`, `name`, `phone_number`) VALUES ('Đak Lak', '10/12/1999', 'trungnoo196@gmail.com', 'Nam', '123456789', 'Quốc Trung', '0123456789');
INSERT INTO `projection_demo`.`customer` (`address`, `date_of_birth`, `email`, `gender`, `id_card`, `name`, `phone_number`) VALUES ('Quảng Nam', '10/12/2000', 'trungnoo196@gmail.com', 'Nam', '123456789', 'Tấn Công', '0123456789');
INSERT INTO `projection_demo`.`customer` (`address`, `date_of_birth`, `email`, `gender`, `id_card`, `name`, `phone_number`) VALUES ('Hội An', '10/12/2000', 'trungnoo196@gmail.com', 'Nam', '123456789', 'Trần Tấn Công', '0123456789');
INSERT INTO `projection_demo`.`customer` (`address`, `date_of_birth`, `email`, `gender`, `id_card`, `name`, `phone_number`) VALUES ('Tuyên Quang', '10/12/2000', 'trungnoo196@gmail.com', 'Nam', '123456789', 'Hoài Nam', '0123456789');
INSERT INTO `projection_demo`.`customer` (`address`, `date_of_birth`, `email`, `gender`, `id_card`, `name`, `phone_number`) VALUES ('Huế', '10/12/2000', 'trungnoo196@gmail.com', 'Nam', '123456789', 'Nông Quốc Anh', '0123456789');
INSERT INTO `projection_demo`.`customer` (`address`, `date_of_birth`, `email`, `gender`, `id_card`, `name`, `phone_number`) VALUES ('Đà Nẵng', '10/12/2000', 'trungnoo196@gmail.com', 'Nam', '123456789', 'Huỳnh Hoài Nam', '0123456789');

INSERT INTO `projection_demo`.`orders` (`price`, `product_name`, `quantity`, `customer_id`) VALUES ('2000', 'Hảo hảo', '2', '1');
INSERT INTO `projection_demo`.`orders` (`price`, `product_name`, `quantity`, `customer_id`) VALUES ('3000', 'Ba miền', '3', '2');
INSERT INTO `projection_demo`.`orders` (`price`, `product_name`, `quantity`, `customer_id`) VALUES ('4000', 'Omachi', '5', '3');
INSERT INTO `projection_demo`.`orders` (`price`, `product_name`, `quantity`, `customer_id`) VALUES ('5000', 'Gấu đỏ', '7', '4');
INSERT INTO `projection_demo`.`orders` (`price`, `product_name`, `quantity`, `customer_id`) VALUES ('6000', 'phở bò', '1', '5');
INSERT INTO `projection_demo`.`orders` (`price`, `product_name`, `quantity`, `customer_id`) VALUES ('10000', 'phở gà', '4', '6');

SELECT * FROM projection_demo.customer;
