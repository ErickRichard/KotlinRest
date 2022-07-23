-- itau.user_permission definition
CREATE TABLE `user_permission` (
	`id_user` bigint NOT NULL,
	`id_permission` bigint NOT NULL
) ENGINE = InnoDB;
