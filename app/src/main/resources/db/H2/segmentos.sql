-- itau.segmentos definition
CREATE TABLE `segmentos` (
	`segmento_Id` bigint NOT NULL AUTO_INCREMENT,
	`nome` varchar(100) DEFAULT NULL,
	`ativo` char(1) DEFAULT NULL
) ENGINE = InnoDB;
