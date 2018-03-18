-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

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
  `email` VARCHAR(45) NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `phone` VARCHAR(45) NOT NULL,
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
  `brand_fk` INT NOT NULL,
  `section_fk` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_product_brand1_idx` (`brand_fk` ASC),
  INDEX `fk_product_section1_idx` (`section_fk` ASC),
  CONSTRAINT `fk_product_brand1`
    FOREIGN KEY (`brand_fk`)
    REFERENCES `e-shop`.`brand` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_product_section1`
    FOREIGN KEY (`section_fk`)
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
-- Table `e-shop`.`chek`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `e-shop`.`chek` ;

CREATE TABLE IF NOT EXISTS `e-shop`.`chek` (
  `id` INT NOT NULL,
  `number` VARCHAR(45) NOT NULL,
  `is_paid` TINYINT(2) NOT NULL,
  `date_statrt` DATETIME NOT NULL,
  `date_finish` DATETIME NOT NULL,
  `customer_fk` INT NOT NULL,
  `vendor_fk` INT NOT NULL,
  `adress_fk` INT NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `number_UNIQUE` (`number` ASC),
  INDEX `fk_chek_customer1_idx` (`customer_fk` ASC),
  INDEX `fk_chek_vendor1_idx` (`vendor_fk` ASC),
  INDEX `fk_chek_adress1_idx` (`adress_fk` ASC),
  CONSTRAINT `fk_chek_customer1`
    FOREIGN KEY (`customer_fk`)
    REFERENCES `e-shop`.`customer` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_chek_vendor1`
    FOREIGN KEY (`vendor_fk`)
    REFERENCES `e-shop`.`vendor` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_chek_adress1`
    FOREIGN KEY (`adress_fk`)
    REFERENCES `e-shop`.`adress` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `e-shop`.`chek_has_product`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `e-shop`.`chek_has_product` ;

CREATE TABLE IF NOT EXISTS `e-shop`.`chek_has_product` (
  `chek_fk` INT NOT NULL,
  `product_fk` INT NOT NULL,
  PRIMARY KEY (`chek_fk`, `product_fk`),
  INDEX `fk_chek_has_product_product1_idx` (`product_fk` ASC),
  INDEX `fk_chek_has_product_chek1_idx` (`chek_fk` ASC),
  CONSTRAINT `fk_chek_has_product_chek1`
    FOREIGN KEY (`chek_fk`)
    REFERENCES `e-shop`.`chek` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_chek_has_product_product1`
    FOREIGN KEY (`product_fk`)
    REFERENCES `e-shop`.`product` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;