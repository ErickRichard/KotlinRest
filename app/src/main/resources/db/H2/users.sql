-- itau.users definition
CREATE TABLE `users` (
	`id` bigint NOT NULL AUTO_INCREMENT,
	`user_name` varchar(255) DEFAULT NULL,
	`full_name` varchar(255) DEFAULT NULL,
	`password` varchar(255) DEFAULT NULL,
	`account_non_expired` bit(1) DEFAULT NULL,
	`account_non_locked` bit(1) DEFAULT NULL,
	`credentials_non_expired` bit(1) DEFAULT NULL,
	`enabled` bit(1) DEFAULT NULL
) ENGINE = InnoDB;