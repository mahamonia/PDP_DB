-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema e-shop
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema e-shop
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `e-shop` DEFAULT CHARACTER SET utf8 ;
USE `e-shop` ;

-- -----------------------------------------------------
-- Table `e-shop`.`customer`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `e-shop`.`customer` ;

CREATE TABLE IF NOT EXISTS `e-shop`.`customer` (
  `id` INT NOT NULL,
  `e-mail` VARCHAR(45) NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `phone` VARCHAR(45) NOT NULL,
  `authentication_id` INT NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `e-shop`.`vendor`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `e-shop`.`vendor` ;

CREATE TABLE IF NOT EXISTS `e-shop`.`vendor` (
  `id` INT NOT NULL,
  `status` TINYINT(1) NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `phone` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `e-shop`.`brand`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `e-shop`.`brand` ;

CREATE TABLE IF NOT EXISTS `e-shop`.`brand` (
  `id` INT NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `e-shop`.`section`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `e-shop`.`section` ;

CREATE TABLE IF NOT EXISTS `e-shop`.`section` (
  `id` INT NOT NULL,
  `title` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `e-shop`.`product`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `e-shop`.`product` ;

CREATE TABLE IF NOT EXISTS `e-shop`.`product` (
  `id` INT NOT NULL,
  `title` VARCHAR(45) NOT NULL,
  `price` VARCHAR(45) NOT NULL,
  `description` VARCHAR(45) NULL,
  `expiry_date` VARCHAR(45) NULL,
  `brand_id` INT NOT NULL,
  `section_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_product_brand1_idx` (`brand_id` ASC),
  INDEX `fk_product_section1_idx` (`section_id` ASC),
  CONSTRAINT `fk_product_brand1`
    FOREIGN KEY (`brand_id`)
    REFERENCES `e-shop`.`brand` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_product_section1`
    FOREIGN KEY (`section_id`)
    REFERENCES `e-shop`.`section` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `e-shop`.`adress`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `e-shop`.`adress` ;

CREATE TABLE IF NOT EXISTS `e-shop`.`adress` (
  `id` INT NOT NULL,
  `city` VARCHAR(45) NOT NULL,
  `street` VARCHAR(45) NOT NULL,
  `house` VARCHAR(45) NOT NULL,
  `apartment` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `e-shop`.`custom`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `e-shop`.`custom` ;

CREATE TABLE IF NOT EXISTS `e-shop`.`custom` (
  `id` INT NOT NULL,
  `number` VARCHAR(45) NOT NULL,
  `is_paid` TINYINT(2) NOT NULL,
  `date_statrt` DATETIME NOT NULL,
  `date_finish` DATETIME NOT NULL,
  `customer_id` INT NOT NULL,
  `vendor_id` INT NOT NULL,
  `adress_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_order_customer1_idx` (`customer_id` ASC),
  INDEX `fk_order_vendor1_idx` (`vendor_id` ASC),
  INDEX `fk_order_adress1_idx` (`adress_id` ASC),
  UNIQUE INDEX `number_UNIQUE` (`number` ASC),
  CONSTRAINT `fk_order_customer1`
    FOREIGN KEY (`customer_id`)
    REFERENCES `e-shop`.`customer` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_order_vendor1`
    FOREIGN KEY (`vendor_id`)
    REFERENCES `e-shop`.`vendor` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_order_adress1`
    FOREIGN KEY (`adress_id`)
    REFERENCES `e-shop`.`adress` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `e-shop`.`product_has_custom`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `e-shop`.`product_has_custom` ;

CREATE TABLE IF NOT EXISTS `e-shop`.`product_has_custom` (
  `product_id` INT NOT NULL,
  `custom_id` INT NOT NULL,
  PRIMARY KEY (`product_id`, `custom_id`),
  INDEX `fk_product_has_custom_custom1_idx` (`custom_id` ASC),
  INDEX `fk_product_has_custom_product1_idx` (`product_id` ASC),
  CONSTRAINT `fk_product_has_custom_product1`
    FOREIGN KEY (`product_id`)
    REFERENCES `e-shop`.`product` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_product_has_custom_custom1`
    FOREIGN KEY (`custom_id`)
    REFERENCES `e-shop`.`custom` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
