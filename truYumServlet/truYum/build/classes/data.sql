-- -----------------------------------------------------
-- View Menu List Admin
-- -----------------------------------------------------

SELECT * FROM truyum.menu_item;

INSERT INTO `truyum`.`menu_item` (`me_id`, `me_name`, `me_price`, `me_active`, `me_date_of_launch`, `me_category`, `me_free_delivery`) VALUES ('1', 'Sandwich', '99.00', 'Yes', '2017-03-15', 'Main Course', 'Yes');
INSERT INTO `truyum`.`menu_item` (`me_id`, `me_name`, `me_price`, `me_active`, `me_date_of_launch`, `me_category`, `me_free_delivery`) VALUES ('2', 'Burger', '129.00', 'Yes', '2017-12-23', 'Main Course', 'No');
INSERT INTO `truyum`.`menu_item` (`me_id`, `me_name`, `me_price`, `me_active`, `me_date_of_launch`, `me_category`, `me_free_delivery`) VALUES ('3', 'Pizza', '149.00', 'Yes', '2017-08-21', 'Main Course', 'No');
INSERT INTO `truyum`.`menu_item` (`me_id`, `me_name`, `me_price`, `me_active`, `me_date_of_launch`, `me_category`, `me_free_delivery`) VALUES ('4', 'French Fries', '57.00', 'No', '2017-07-02', 'Starters', 'Yes');
INSERT INTO `truyum`.`menu_item` (`me_id`, `me_name`, `me_price`, `me_active`, `me_date_of_launch`, `me_category`, `me_free_delivery`) VALUES ('5', 'Chocolate Brownie', '32.00', 'Yes', '2022-11-02', 'Dessert', 'Yes');

-- -----------------------------------------------------
-- User Table
-- -----------------------------------------------------

SELECT * FROM truyum.user;

INSERT INTO `truyum`.`user` (us_id, us_name) values (1, 'Vijay');
INSERT INTO `truyum`.`user` (us_name) values ('Ajith');

-- -----------------------------------------------------
-- View Menu List Customer
-- -----------------------------------------------------

SELECT * FROM truyum.menu_item 
WHERE me_date_of_launch > CURDATE() AND me_active = 'Yes';

-- -----------------------------------------------------
-- Edit Menu Item
-- -----------------------------------------------------

SELECT * FROM `truyum`.`menu_item` 	WHERE me_id = 1;

UPDATE `truyum`.`menu_item`
SET
me_name='Falooda',me_price='120.00', me_active= 'No', me_date_of_launch= '2022-07-24', me_category= 'Dessert', me_free_delivery= 'No'
where me_id= 4;

-- -----------------------------------------------------
-- Add Cart
-- -----------------------------------------------------

SELECT * FROM truyum.cart;

INSERT INTO truyum.cart (ct_id, ct_us_id, ct_me_id) values (101,1,1);
INSERT INTO truyum.cart (ct_us_id, ct_me_id) values (1,2);
INSERT INTO truyum.cart (ct_us_id, ct_me_id) values (1,3);
INSERT INTO truyum.cart (ct_us_id, ct_me_id) values (2,3);
INSERT INTO truyum.cart (ct_us_id, ct_me_id) values (2,4);
INSERT INTO truyum.cart (ct_us_id, ct_me_id) values (2,5);

-- -----------------------------------------------------
-- View Cart
-- -----------------------------------------------------

USE truyum;

SELECT * FROM truyum.cart;

SELECT menu_item.me_name, menu_item.me_free_delivery, menu_item.me_price FROM cart
INNER JOIN menu_item on menu_item.me_id = cart.ct_me_id
INNER JOIN user on user.us_id = cart.ct_us_id
WHERE user.us_id=2;

SELECT menu_item.me_name, menu_item.me_category, menu_item.me_date_of_launch, menu_item.me_free_delivery, menu_item.me_price FROM cart
INNER JOIN menu_item on menu_item.me_id = cart.ct_me_id
WHERE cart.ct_us_id=2;

SELECT user.us_id, sum(menu_item.me_price) as me_total FROM cart
INNER JOIN menu_item on menu_item.me_id = cart.ct_me_id
INNER JOIN user on user.us_id = cart.ct_us_id
WHERE user.us_id=2;

-- -----------------------------------------------------
-- Remove Item From Cart
-- -----------------------------------------------------

USE truyum;

DELETE cart FROM cart
WHERE ct_us_id=2 AND ct_me_id = 3;

SELECT menu_item.me_name, menu_item.me_free_delivery, menu_item.me_price FROM cart
INNER JOIN menu_item on menu_item.me_id = cart.ct_me_id
WHERE cart.ct_us_id=2;

-- ------------------------------------------------------
-- ------------------------------------------------------