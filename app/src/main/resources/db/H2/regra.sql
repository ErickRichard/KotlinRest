-- itau.regra definition
CREATE TABLE `regra` (
	`regra_id` bigint NOT NULL AUTO_INCREMENT,
	`nome` varchar(100) DEFAULT NULL,
	`criado_Por` varchar(100) DEFAULT NULL,
	`data_Criacao` datetime DEFAULT NULL,
	`cpp` float DEFAULT NULL,
	`aprovado_Por` varchar(100) DEFAULT NULL,
	`data_Inicio_Vigencia` datetime DEFAULT NULL,
	`data_Fim_Vigencia` datetime DEFAULT NULL,
	`status` char(4) DEFAULT NULL
) ENGINE = InnoDB;