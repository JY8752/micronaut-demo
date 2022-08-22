-- -----------------------------------------------------
-- Table `quarkusdb`.`task`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `demo`.`task` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `details` TEXT NOT NULL,
  `created_at` DATETIME NOT NULL,
  `user_id` INT NOT NULL,
  PRIMARY KEY (`id`, `user_id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE,
  INDEX `fk_task_user_idx` (`user_id` ASC) VISIBLE,
  CONSTRAINT `fk_task_user`
    FOREIGN KEY (`user_id`)
    REFERENCES `demo`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;