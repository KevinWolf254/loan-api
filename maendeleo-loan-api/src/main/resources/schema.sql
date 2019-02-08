-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema maendeleo_db
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema maendeleo_db
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `maendeleo_db` ;
USE `maendeleo_db` ;

-- -----------------------------------------------------
-- Table `maendeleo_db`.`residence`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `maendeleo_db`.`residence` ;

CREATE TABLE IF NOT EXISTS `maendeleo_db`.`residence` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `physical_address` VARCHAR(45) NULL,
  `owned` TINYINT NULL,
  `occupancy_duration` VARCHAR(25) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `maendeleo_db`.`postal_address`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `maendeleo_db`.`postal_address` ;

CREATE TABLE IF NOT EXISTS `maendeleo_db`.`postal_address` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `number` VARCHAR(8) NOT NULL,
  `code` VARCHAR(5) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `maendeleo_db`.`member`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `maendeleo_db`.`member` ;

CREATE TABLE IF NOT EXISTS `maendeleo_db`.`member` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `identity_type` TINYINT NOT NULL,
  `identity_no` INT NOT NULL,
  `pin_no` VARCHAR(45) NOT NULL,
  `first_name` VARCHAR(10) NULL,
  `middle_name` VARCHAR(10) NULL,
  `last_name` VARCHAR(10) NULL,
  `dob` VARCHAR(12) NULL,
  `mobile_no` VARCHAR(10) NULL,
  `email` VARCHAR(45) NULL,
  `marital_status` TINYINT NULL,
  `dependents` INT NULL,
  `residence_id` INT NOT NULL,
  `postal_address_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `identityNo_UNIQUE` (`identity_no` ASC) VISIBLE,
  UNIQUE INDEX `mobile_no_UNIQUE` (`mobile_no` ASC) VISIBLE,
  UNIQUE INDEX `pin_no_UNIQUE` (`pin_no` ASC) VISIBLE,
  UNIQUE INDEX `email_UNIQUE` (`email` ASC) VISIBLE,
  INDEX `fk_member_residence1_idx` (`residence_id` ASC) VISIBLE,
  INDEX `fk_member_postal_address1_idx` (`postal_address_id` ASC) VISIBLE,
  CONSTRAINT `fk_member_residence1`
    FOREIGN KEY (`residence_id`)
    REFERENCES `maendeleo_db`.`residence` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_member_postal_address1`
    FOREIGN KEY (`postal_address_id`)
    REFERENCES `maendeleo_db`.`postal_address` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `maendeleo_db`.`institution`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `maendeleo_db`.`institution` ;

CREATE TABLE IF NOT EXISTS `maendeleo_db`.`institution` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(25) NULL,
  `phone_no` VARCHAR(45) NULL,
  `industry` VARCHAR(45) NULL,
  `years_operational` INT NULL,
  `postal_address_id` INT NOT NULL,
  `residence_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `phone_no_UNIQUE` (`phone_no` ASC) VISIBLE,
  INDEX `fk_institution_postal_address1_idx` (`postal_address_id` ASC) VISIBLE,
  INDEX `fk_institution_residence1_idx` (`residence_id` ASC) VISIBLE,
  CONSTRAINT `fk_institution_postal_address1`
    FOREIGN KEY (`postal_address_id`)
    REFERENCES `maendeleo_db`.`postal_address` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_institution_residence1`
    FOREIGN KEY (`residence_id`)
    REFERENCES `maendeleo_db`.`residence` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `maendeleo_db`.`bank`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `maendeleo_db`.`bank` ;

CREATE TABLE IF NOT EXISTS `maendeleo_db`.`bank` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(25) NOT NULL,
  `code` VARCHAR(25) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `name_UNIQUE` (`name` ASC) VISIBLE,
  UNIQUE INDEX `code_UNIQUE` (`code` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `maendeleo_db`.`branch`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `maendeleo_db`.`branch` ;

CREATE TABLE IF NOT EXISTS `maendeleo_db`.`branch` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `code` VARCHAR(25) NOT NULL,
  `name` VARCHAR(25) NOT NULL,
  `bank_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_branch_bank1_idx` (`bank_id` ASC) VISIBLE,
  CONSTRAINT `fk_branch_bank1`
    FOREIGN KEY (`bank_id`)
    REFERENCES `maendeleo_db`.`bank` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `maendeleo_db`.`account`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `maendeleo_db`.`account` ;

CREATE TABLE IF NOT EXISTS `maendeleo_db`.`account` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `number` VARCHAR(45) NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `branch_id` INT NOT NULL,
  `member_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `number_UNIQUE` (`number` ASC) VISIBLE,
  UNIQUE INDEX `name_UNIQUE` (`name` ASC) VISIBLE,
  INDEX `fk_account_branch1_idx` (`branch_id` ASC) VISIBLE,
  INDEX `fk_account_member1_idx` (`member_id` ASC) VISIBLE,
  CONSTRAINT `fk_account_branch1`
    FOREIGN KEY (`branch_id`)
    REFERENCES `maendeleo_db`.`branch` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_account_member1`
    FOREIGN KEY (`member_id`)
    REFERENCES `maendeleo_db`.`member` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `maendeleo_db`.`loan_amount`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `maendeleo_db`.`loan_amount` ;

CREATE TABLE IF NOT EXISTS `maendeleo_db`.`loan_amount` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `currency` TINYINT NOT NULL,
  `amount` INT NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `maendeleo_db`.`loan_application`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `maendeleo_db`.`loan_application` ;

CREATE TABLE IF NOT EXISTS `maendeleo_db`.`loan_application` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `type` TINYINT NOT NULL,
  `purpose` VARCHAR(45) NOT NULL,
  `status` TINYINT NOT NULL,
  `account_id` INT NOT NULL,
  `amount_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_loan_account1_idx` (`account_id` ASC) VISIBLE,
  INDEX `fk_loan_application_loan_amount1_idx` (`amount_id` ASC) VISIBLE,
  CONSTRAINT `fk_loan_account1`
    FOREIGN KEY (`account_id`)
    REFERENCES `maendeleo_db`.`account` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_loan_application_loan_amount1`
    FOREIGN KEY (`amount_id`)
    REFERENCES `maendeleo_db`.`loan_amount` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `maendeleo_db`.`other_bank_loan_amount`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `maendeleo_db`.`other_bank_loan_amount` ;

CREATE TABLE IF NOT EXISTS `maendeleo_db`.`other_bank_loan_amount` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `currency` TINYINT NOT NULL,
  `amount` INT NOT NULL,
  `outstanding_balance` INT NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `maendeleo_db`.`other_bank_loan`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `maendeleo_db`.`other_bank_loan` ;

CREATE TABLE IF NOT EXISTS `maendeleo_db`.`other_bank_loan` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `date_granted` VARCHAR(45) NOT NULL,
  `repayment_period` VARCHAR(45) NOT NULL,
  `bank_id` INT NOT NULL,
  `account_id` INT NOT NULL,
  `amount_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_extra_loan_bank1_idx` (`bank_id` ASC) VISIBLE,
  INDEX `fk_extra_loan_account1_idx` (`account_id` ASC) VISIBLE,
  INDEX `fk_other_bank_loan_other_bank_loan_amount1_idx` (`amount_id` ASC) VISIBLE,
  CONSTRAINT `fk_extra_loan_bank1`
    FOREIGN KEY (`bank_id`)
    REFERENCES `maendeleo_db`.`bank` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_extra_loan_account1`
    FOREIGN KEY (`account_id`)
    REFERENCES `maendeleo_db`.`account` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_other_bank_loan_other_bank_loan_amount1`
    FOREIGN KEY (`amount_id`)
    REFERENCES `maendeleo_db`.`other_bank_loan_amount` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `maendeleo_db`.`employment_details`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `maendeleo_db`.`employment_details` ;

CREATE TABLE IF NOT EXISTS `maendeleo_db`.`employment_details` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `staff_no` VARCHAR(45) NOT NULL,
  `designation` VARCHAR(45) NOT NULL,
  `terms` TINYINT NOT NULL,
  `info` VARCHAR(45) NULL,
  `member_id` INT NOT NULL,
  `institution_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_employment_details_member1_idx` (`member_id` ASC) VISIBLE,
  INDEX `fk_employment_details_institution1_idx` (`institution_id` ASC) VISIBLE,
  CONSTRAINT `fk_employment_details_member1`
    FOREIGN KEY (`member_id`)
    REFERENCES `maendeleo_db`.`member` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_employment_details_institution1`
    FOREIGN KEY (`institution_id`)
    REFERENCES `maendeleo_db`.`institution` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `maendeleo_db`.`income_amount`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `maendeleo_db`.`income_amount` ;

CREATE TABLE IF NOT EXISTS `maendeleo_db`.`income_amount` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `currency` TINYINT NOT NULL,
  `amount` INT NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `maendeleo_db`.`income`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `maendeleo_db`.`income` ;

CREATE TABLE IF NOT EXISTS `maendeleo_db`.`income` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `type` TINYINT NOT NULL,
  `details` VARCHAR(45) NULL,
  `institution_id` INT NOT NULL,
  `income_amount_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_income_institution1_idx` (`institution_id` ASC) VISIBLE,
  INDEX `fk_income_income_amount1_idx` (`income_amount_id` ASC) VISIBLE,
  CONSTRAINT `fk_income_institution1`
    FOREIGN KEY (`institution_id`)
    REFERENCES `maendeleo_db`.`institution` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_income_income_amount1`
    FOREIGN KEY (`income_amount_id`)
    REFERENCES `maendeleo_db`.`income_amount` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

