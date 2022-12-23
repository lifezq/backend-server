-- --------------------------------------------------------
-- 主机:                           127.0.0.1
-- 服务器版本:                        8.0.29 - MySQL Community Server - GPL
-- 服务器操作系统:                      Win64
-- HeidiSQL 版本:                  12.0.0.6468
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT = @@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE = @@TIME_ZONE */;
/*!40103 SET TIME_ZONE = '+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS = @@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS = 0 */;
/*!40101 SET @OLD_SQL_MODE = @@SQL_MODE, SQL_MODE = 'NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES = @@SQL_NOTES, SQL_NOTES = 0 */;


-- 导出 backend-server 的数据库结构
CREATE DATABASE IF NOT EXISTS `backend-server` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `backend-server`;

-- 导出  表 backend-server.pt_role 结构
CREATE TABLE IF NOT EXISTS `pt_role`
(
    `id`           bigint                                                       NOT NULL AUTO_INCREMENT COMMENT 'id',
    `tenant_id`    int                                                          NOT NULL DEFAULT '0' COMMENT '租户号',
    `name`         varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '角色名称',
    `state`        tinyint(1)                                                   NOT NULL DEFAULT '1' COMMENT '状态;是否可用；1可用;0禁用',
    `is_delete`    tinyint(1)                                                   NOT NULL DEFAULT '0' COMMENT '是否删除;是否删除；1已删除;0未删除',
    `created_by`   varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '创建人',
    `created_time` datetime                                                     NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updated_by`   varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '更新人',
    `updated_time` datetime                                                     NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`id`),
    UNIQUE KEY `name_idx` (`tenant_id`, `name`) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_general_ci COMMENT ='角色表';

-- 数据导出被取消选择。

-- 导出  表 backend-server.pt_tenant 结构
CREATE TABLE IF NOT EXISTS `pt_tenant`
(
    `id`           bigint                                                       NOT NULL AUTO_INCREMENT COMMENT 'id',
    `name`         varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '租户名称',
    `state`        tinyint(1)                                                   NOT NULL DEFAULT '1' COMMENT '状态;是否可用；1可用;0禁用',
    `is_delete`    tinyint(1)                                                   NOT NULL DEFAULT '0' COMMENT '是否删除;是否删除；1已删除;0未删除',
    `created_by`   varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '创建人',
    `created_time` datetime                                                     NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updated_by`   varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '更新人',
    `updated_time` datetime                                                     NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`id`),
    UNIQUE KEY `name_idx` (`name`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_general_ci COMMENT ='租户表';

-- 数据导出被取消选择。

-- 导出  表 backend-server.pt_user 结构
CREATE TABLE IF NOT EXISTS `pt_user`
(
    `id`                  bigint                                                        NOT NULL DEFAULT '0',
    `tenant_id`           int                                                           NOT NULL DEFAULT '0' COMMENT '租户id',
    `username`            varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci  NOT NULL DEFAULT '0' COMMENT '账号',
    `password`            varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '0' COMMENT '密码',
    `nickname`            varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci  NOT NULL DEFAULT '0' COMMENT '昵称',
    `authentication_type` tinyint(1)                                                    NOT NULL DEFAULT '0' COMMENT '认证类型: 0未认证/1平台管理/2个人/3企业/4政府',
    `phone_number`        varchar(20) COLLATE utf8mb4_general_ci                        NOT NULL DEFAULT '0' COMMENT '手机号',
    `email`               varchar(100) COLLATE utf8mb4_general_ci                       NOT NULL DEFAULT '0' COMMENT '邮箱',
    `age`                 tinyint                                                       NOT NULL DEFAULT '0' COMMENT '年龄',
    `state`               tinyint(1)                                                    NOT NULL DEFAULT '1' COMMENT '是否可用；1可用, 0禁用',
    `is_delete`           tinyint(1)                                                    NOT NULL DEFAULT '0' COMMENT '是否删除;是否删除；1已删除;0未删除',
    `updated_by`          varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci  NOT NULL DEFAULT '0' COMMENT '更新人',
    `updated_time`        datetime                                                      NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
    `created_by`          varchar(50) COLLATE utf8mb4_general_ci                        NOT NULL DEFAULT '0' COMMENT '创建人',
    `created_time`        datetime                                                      NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    PRIMARY KEY (`id`),
    UNIQUE KEY `uname_idx` (`username`),
    UNIQUE KEY `email_idx` (`email`),
    UNIQUE KEY `phone_idx` (`phone_number`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_general_ci;

-- 数据导出被取消选择。

-- 导出  表 backend-server.pt_user_role 结构
CREATE TABLE IF NOT EXISTS `pt_user_role`
(
    `id`           bigint                                                       NOT NULL AUTO_INCREMENT COMMENT 'id',
    `tenant_id`    int                                                          NOT NULL DEFAULT '0' COMMENT '租户号',
    `uid`          bigint                                                       NOT NULL DEFAULT '0' COMMENT '用户id',
    `rid`          int                                                          NOT NULL DEFAULT '0' COMMENT '角色id',
    `state`        tinyint(1)                                                   NOT NULL DEFAULT '1' COMMENT '状态;是否可用；1可用;0禁用',
    `is_delete`    tinyint(1)                                                   NOT NULL DEFAULT '0' COMMENT '是否删除;是否删除；1已删除;0未删除',
    `created_by`   varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '创建人',
    `created_time` datetime                                                     NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updated_by`   varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '更新人',
    `updated_time` datetime                                                     NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`id`) USING BTREE,
    UNIQUE KEY `code_idx` (`tenant_id`, `rid`) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_general_ci
  ROW_FORMAT = DYNAMIC COMMENT ='角色表';

-- 数据导出被取消选择。

/*!40103 SET TIME_ZONE = IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE = IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS = IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT = @OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES = IFNULL(@OLD_SQL_NOTES, 1) */;
