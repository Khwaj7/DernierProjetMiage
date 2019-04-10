CREATE TABLE `vamacherusers`.`adresse` (
  `id` INT NOT NULL,
  `numero` INT NULL,
  `rue` VARCHAR(45) NULL,
  `ville` VARCHAR(45) NULL,
  `pays` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = MyISAM;
};

CREATE TABLE `vamacherusers`.`certificatmedical` (
  `id` INT NOT NULL,
  `dateEtablissement` DATETIME NULL,
  PRIMARY KEY (`id`));
};