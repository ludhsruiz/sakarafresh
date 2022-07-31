DROP SCHEMA IF EXISTS meal_pack_service;
PRIMARYcityCREATE SCHEMA IF NOT EXISTS meal_pack_service;
USE `meal_pack_service` ;

-- -----------------------------------------------------
-- Table `meal_pack_service`.`meal_pack`
-- -----------------------------------------------------

CREATE TABLE IF NOT EXISTS `meal_pack_service`.`meal_pack` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `details` VARCHAR(255) NULL DEFAULT NULL,
  `meal_name` VARCHAR(255) NULL DEFAULT NULL,
  `prize` DOUBLE NULL DEFAULT NULL,
  `description` VARCHAR(255) NULL DEFAULT NULL,
  `meal_pack_weekly_id1` BIGINT NULL DEFAULT NULL,
  `meal_pack_weekly_id2` BIGINT NULL DEFAULT NULL,
  `meal_pack_weekly_id3` BIGINT NULL DEFAULT NULL,
  `picture` VARCHAR(255) NULL DEFAULT NULL,
  `total_calories` INT NOT NULL,
  `total_days` INT NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `meal_pack_service`.`meal_pack_daily`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `meal_pack_service`.`meal_pack_daily` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `meal_pack_id` BIGINT NULL DEFAULT NULL,
  `meal_pack_product_id_breakfast` BIGINT NULL DEFAULT NULL,
  `meal_pack_product_iddjuice` BIGINT NULL DEFAULT NULL,
  `meal_pack_product_id_dessert` BIGINT NULL DEFAULT NULL,
  `meal_pack_product_id_dinner` BIGINT NULL DEFAULT NULL,
  `meal_pack_product_id_lunch` BIGINT NULL DEFAULT NULL,
  `meal_pack_product_id_snack` BIGINT NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `meal_pack_service`.`meal_pack_product`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `meal_pack_service`.`meal_pack_product` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `calories` INT NOT NULL,
  `carbs` INT NOT NULL,
  `eat_cold` BIT(1) NULL DEFAULT NULL,
  `eat_hot` BIT(1) NULL DEFAULT NULL,
  `fat` INT NOT NULL,
  `fiber` INT NOT NULL,
  `freezable` BIT(1) NULL DEFAULT NULL,
  `protein` INT NOT NULL,
  `salt` INT NOT NULL,
  `saturated_fat` INT NOT NULL,
  `self_life` INT NOT NULL,
  `sugar` INT NOT NULL,
  `img` VARCHAR(255) NULL DEFAULT NULL,
  `ingredients` VARCHAR(255) NULL DEFAULT NULL,
  `name` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `meal_pack_service`.`meal_pack_weekly`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `meal_pack_service`.`meal_pack_weekly` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `meal_pack_daily_id1` BIGINT NULL DEFAULT NULL,
  `meal_pack_daily_id2` BIGINT NULL DEFAULT NULL,
  `meal_pack_daily_id3` BIGINT NULL DEFAULT NULL,
  `meal_pack_daily_id4` BIGINT NULL DEFAULT NULL,
  `meal_pack_daily_id5` BIGINT NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;



DROP SCHEMA IF EXISTS fridge_fills_service;
CREATE SCHEMA IF NOT EXISTS fridge_fills_service;

USE `fridge_fills_service` ;

-- -----------------------------------------------------
-- Table `fridge_fills_service`.`fridge_fill`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `fridge_fills_service`.`fridge_fill` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `calories` INT NOT NULL,
  `carbs` INT NOT NULL,
  `eat_cold` BIT(1) NULL DEFAULT NULL,
  `eat_hot` BIT(1) NULL DEFAULT NULL,
  `fat` INT NOT NULL,
  `fiber` INT NOT NULL,
  `freezable` BIT(1) NULL DEFAULT NULL,
  `meal_name` VARCHAR(255) NULL DEFAULT NULL,
  `protein` INT NOT NULL,
  `salt` INT NOT NULL,
  `saturated_fat` INT NOT NULL,
  `self_life` INT NOT NULL,
  `sugar` INT NOT NULL,
  `total_calories` INT NOT NULL,
  `description` VARCHAR(255) NULL DEFAULT NULL,
  `ingredients` VARCHAR(255) NULL DEFAULT NULL,
  `picture` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;

DROP SCHEMA IF EXISTS snack_service;
CREATE SCHEMA IF NOT EXISTS snack_service;


USE `snack_service` ;

-- -----------------------------------------------------
-- Table `snack_service`.`snack`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `snack_service`.`snack` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `allergens` VARCHAR(255) NULL DEFAULT NULL,
  `benefits` VARCHAR(255) NULL DEFAULT NULL,
  `calcium` INT NOT NULL,
  `calories` INT NOT NULL,
  `carbohydrates` INT NOT NULL,
  `cholesterol` INT NOT NULL,
  `description` VARCHAR(255) NULL DEFAULT NULL,
  `disclaimers` VARCHAR(255) NULL DEFAULT NULL,
  `fat` INT NOT NULL,
  `flavor` VARCHAR(255) NULL DEFAULT NULL,
  `how_to_use` VARCHAR(255) NULL DEFAULT NULL,
  `ingredients` VARCHAR(255) NULL DEFAULT NULL,
  `iron` INT NOT NULL,
  `picture` VARCHAR(255) NULL DEFAULT NULL,
  `potassium` INT NOT NULL,
  `price` DOUBLE NULL DEFAULT NULL,
  `product_name` VARCHAR(255) NULL DEFAULT NULL,
  `protein` INT NOT NULL,
  `quantity` INT NULL DEFAULT NULL,
  `sodium` INT NOT NULL,
  `vitamind` INT NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


DROP SCHEMA IF EXISTS order_service;
CREATE SCHEMA IF NOT EXISTS order_service;
USE order_service;


CREATE TABLE IF NOT EXISTS `order_service`.`shipping_address`(
`id` bigint not null auto_increment,
`city` varchar(255), 
`name` varchar(255), 
`phone` integer not null, 
`state` varchar(255), 
`street` varchar(255), 
`street_details` varchar(255), 
`user_id` bigint, 
`zip_code` integer not null, 
primary key (id))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;

INSERT INTO `order_service`.`shipping_address` (city, name, phone, state, street, street_details, user_id, zip_code)  VALUES
	('AdminTest', 'Elio','2021094523','ADMIN','somewhereanywhere','p.b2a',1,23456),
	('London', 'Ammia','2021094523','ADMIN','somewhereanywhere','p.b2a',1,23456);


CREATE TABLE IF NOT EXISTS `order_service`.`snack_order`(
id bigint not null auto_increment, 
date_created date, 
is_subscription bit, 
order_status varchar(255), 
products_id tinyblob, 
shipping_address bigint, 
total_price double precision, 
user_id bigint,
primary key (id))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


DROP SCHEMA IF EXISTS edge_service;
CREATE SCHEMA IF NOT EXISTS edge_service;
USE edge_service;


CREATE TABLE IF NOT EXISTS `edge_service`.`role`(
`id` bigint not null auto_increment,
`name` varchar(255), 
`user_id` bigint,
primary key (id));

INSERT INTO `edge_service`.`role` ( name, user_id)  VALUES
	('ADMIN', 1);


CREATE TABLE IF NOT EXISTS `edge_service`.`user`(
`id` bigint not null auto_increment, 
`shipping_address_id` bigint, 
`email` varchar(255), 
`password` varchar(255), 
`username` varchar(255), 
primary key (id));



INSERT INTO `edge_service`.`user` (shipping_address_id, email, password, username)  VALUES
	(1, 'adminmail@mail.com','$2a$10$prKuAhwDEa/sCFCV5mH3ku0f4m4O0Nm1DEHxODzo/L4omfHC1xXpK','admin');
    
    
 SELECT * FROM USER;
 
INSERT INTO `fridge_fills_service`.`fridge_fill` (  
  calories,
  carbs,
  eat_cold,
  eat_hot,
  fat,
  fiber,
  freezable,
  meal_name,
  protein,
  salt,
  saturated_fat,
  self_life,
  sugar,
  total_calories,
  description,
  ingredients,
  picture) VALUES

(496,
36,
false, 
true,
21,
4,
false,
'GIZZIS BEETROOT LAAB', 
17,
5,
16,
8, 
1.7,
496,
'A classic Thai salad with a twist: black lentils and beetroot with crispy onions and a zingy lime sauce',
'Mixed beetroot, coconut rice , beluga lentils, tamarind tofu, , tamarind dressing , crispy onions, coriander, basil, mint, blitzed rice ',
' detoxkitchen.co.uk/images/meals/_dishCardMedium/Website-image-Beetroot-laab.jpg'),

(496,
36,
false, 
true,
21,
4,
false,
'GIZZIS BEETROOT LAAB', 
17,
5,
16,
8, 
1.7,
496,
'A classic Thai salad with a twist: black lentils and beetroot with crispy onions and a zingy lime sauce',
'Mixed beetroot, coconut rice , beluga lentils, tamarind tofu, , tamarind dressing , crispy onions, coriander, basil, mint, blitzed rice ',
' detoxkitchen.co.uk/images/meals/_dishCardMedium/Website-image-Beetroot-laab.jpg'),
(496,
36,
false, 
true,
21,
4,
false,
'GIZZIS BEETROOT LAAB', 
17,
5,
16,
8, 
1.7,
496,
'A classic Thai salad with a twist: black lentils and beetroot with crispy onions and a zingy lime sauce',
'Mixed beetroot, coconut rice , beluga lentils, tamarind tofu, , tamarind dressing , crispy onions, coriander, basil, mint, blitzed rice ',
' detoxkitchen.co.uk/images/meals/_dishCardMedium/Website-image-Beetroot-laab.jpg'),
(496,
36,
false, 
true,
21,
4,
false,
'GIZZIS BEETROOT LAAB', 
17,
5,
16,
8, 
1.7,
496,
'A classic Thai salad with a twist: black lentils and beetroot with crispy onions and a zingy lime sauce',
'Mixed beetroot, coconut rice , beluga lentils, tamarind tofu, , tamarind dressing , crispy onions, coriander, basil, mint, blitzed rice ',
' detoxkitchen.co.uk/images/meals/_dishCardMedium/Website-image-Beetroot-laab.jpg');

