-- itau.skus definition
CREATE TABLE `skus` (
	`sub_Item_Id` bigint NOT NULL AUTO_INCREMENT,
	`item_Id` bigint DEFAULT NULL,
	`sku` varchar(500) DEFAULT NULL,
	`parceiro_Id` varchar(100) DEFAULT NULL
) ENGINE = InnoDB;
