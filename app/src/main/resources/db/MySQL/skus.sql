-- itau.skus definition

CREATE TABLE `skus` (
  `sub_Item_Id` bigint NOT NULL AUTO_INCREMENT,
  `item_Id` bigint DEFAULT NULL,
  `sku` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `parceiro_Id` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`sub_Item_Id`),
  KEY `skus_FK` (`item_Id`),
  CONSTRAINT `skus_FK` FOREIGN KEY (`item_Id`) REFERENCES `segmento_parceiro` (`item_Id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;