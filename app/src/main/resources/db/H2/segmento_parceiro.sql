-- itau.segmento_parceiro definition
CREATE TABLE `segmento_parceiro` (
	`item_Id` bigint NOT NULL AUTO_INCREMENT,
	`segmento_Id` bigint NOT NULL,
	`regra_Id` bigint NOT NULL
) ENGINE = InnoDB;