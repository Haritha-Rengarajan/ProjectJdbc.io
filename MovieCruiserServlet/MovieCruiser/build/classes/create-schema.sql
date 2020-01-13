
SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema MovieCruiser
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema MovieCruiser
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `MovieCruiser` DEFAULT CHARACTER SET utf8 ;
USE `MovieCruiser` ;

-- -----------------------------------------------------
-- Table `MovieCruiser`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `MovieCruiser`.`user` (
  `us_id` INT NOT NULL AUTO_INCREMENT,
  `us_name` VARCHAR(45) NULL,
  PRIMARY KEY (`us_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `MovieCruiser`.`movie_list`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `MovieCruiser`.`movie_list` (
  `mov_id` INT NOT NULL AUTO_INCREMENT,
  `mov_title` VARCHAR(100) NULL,
  `mov_gross` BIGINT(10) NULL,
  `mov_active` VARCHAR(3) NULL,
  `mov_date_of_launch` DATE NULL,
  `mov_genre` VARCHAR(45) NULL,
  `mov_has_teaser` VARCHAR(3) NULL,
  PRIMARY KEY (`mov_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `MovieCruiser`.`favorites`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `MovieCruiser`.`favorites` (
  `fav_id` INT NOT NULL AUTO_INCREMENT,
  `fav_us_id` INT NULL,
  `fav_mov_id` INT NULL,
  PRIMARY KEY (`fav_id`),
  INDEX `fav_us_id_idx` (`fav_us_id` ASC),
  INDEX `fav_mov_id_idx` (`fav_mov_id` ASC),
  CONSTRAINT `fav_us_id`
    FOREIGN KEY (`fav_us_id`)
    REFERENCES `MovieCruiser`.`user` (`us_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fav_mov_id`
    FOREIGN KEY (`fav_mov_id`)
    REFERENCES `MovieCruiser`.`movie_list` (`mov_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
