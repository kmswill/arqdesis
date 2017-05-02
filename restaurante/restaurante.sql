CREATE SCHEMA IF NOT EXISTS `restaurante` DEFAULT CHARACTER SET utf8 ;
USE `restaurante` ;

-- -----------------------------------------------------
-- Table `cardapio`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cardapio` (
  `id` INT(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(100) NOT NULL,
  `descr` VARCHAR(15) NULL DEFAULT NULL,
  `valor` VARCHAR(60) NOT NULL UNIQUE,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;