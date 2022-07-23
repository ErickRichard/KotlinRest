-- itau.segmento_parceiro definition

CREATE TABLE `segmento_parceiro` (
  `item_Id` bigint NOT NULL AUTO_INCREMENT,
  `segmento_Id` bigint NOT NULL,
  `regra_Id` bigint NOT NULL,
  PRIMARY KEY (`item_Id`),
  KEY `segmento_parceiro_FK` (`regra_Id`),
  KEY `segmento_parceiro_FK_1` (`segmento_Id`),
  CONSTRAINT `segmento_parceiro_FK` FOREIGN KEY (`regra_Id`) REFERENCES `regra` (`regra_id`),
  CONSTRAINT `segmento_parceiro_FK_1` FOREIGN KEY (`segmento_Id`) REFERENCES `segmentos` (`segmento_Id`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;