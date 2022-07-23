-- itau.user_permission definition

CREATE TABLE `user_permission` (
  `id_user` bigint NOT NULL,
  `id_permission` bigint NOT NULL,
  PRIMARY KEY (`id_user`,`id_permission`),
  KEY `fk_user_permission_permission` (`id_permission`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;