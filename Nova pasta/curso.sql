
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema cursojava
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema cursojava
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `cursojava` DEFAULT CHARACTER SET utf8 ;
USE `cursojava` ;

-- -----------------------------------------------------
-- Table `cursojava`.`cursojava`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cursojava`.`cursojava` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NOT NULL,
  `descricao` VARCHAR(300) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `cursojava`.`Pessoa`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cursojava`.`Pessoa` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(100) NOT NULL,
  `endereco` VARCHAR(400) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `cursojava`.`Aluno`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cursojava`.`Aluno` (
  `id` INT NOT NULL,
  `matricula` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `cursojava`.`Funcionario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cursojava`.`Funcionario` (
  `id` INT NOT NULL,
  `matricula` VARCHAR(45) NOT NULL,
  `data_contratacao` DATETIME NOT NULL,
  `data_demissao` DATETIME NULL,
  `salario` double NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `cursojava`.`Turma`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cursojava`.`Turma` (
  `idTurma` INT NOT NULL AUTO_INCREMENT,
  `data_inicio` DATETIME NOT NULL,
  `data_termino` DATETIME NOT NULL,
  `cursojava_id` INT NOT NULL,
  `Funcionario_id` INT NOT NULL,
  PRIMARY KEY (`idTurma`),
  INDEX `fk_Turma_cursojava_idx` (`cursojava_id` ASC),
  INDEX `fk_Turma_Funcionario1_idx` (`Funcionario_id` ASC),
  CONSTRAINT `fk_Turma_cursojava`
    FOREIGN KEY (`cursojava_id`)
    REFERENCES `cursojava`.`cursojava` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Turma_Funcionario1`
    FOREIGN KEY (`Funcionario_id`)
    REFERENCES `cursojava`.`Funcionario` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `cursojava`.`Turma_has_Aluno`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cursojava`.`Turma_has_Aluno` (
  `Turma_idTurma` INT NOT NULL,
  `Aluno_id` INT NOT NULL,
  PRIMARY KEY (`Turma_idTurma`, `Aluno_id`),
  INDEX `fk_Turma_has_Aluno_Aluno1_idx` (`Aluno_id` ASC),
  INDEX `fk_Turma_has_Aluno_Turma1_idx` (`Turma_idTurma` ASC),
  CONSTRAINT `fk_Turma_has_Aluno_Turma1`
    FOREIGN KEY (`Turma_idTurma`)
    REFERENCES `cursojava`.`Turma` (`idTurma`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Turma_has_Aluno_Aluno1`
    FOREIGN KEY (`Aluno_id`)
    REFERENCES `cursojava`.`Aluno` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
