-- --------------------------------------------------------
-- 主机:                           127.0.0.1
-- 服务器版本:                        8.0.29 - MySQL Community Server - GPL
-- 服务器操作系统:                      Win64
-- HeidiSQL 版本:                  12.0.0.6468
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- 导出 backend-server 的数据库结构
CREATE DATABASE IF NOT EXISTS `backend-server` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `backend-server`;

-- 导出  表 backend-server.pt_function_model 结构
CREATE TABLE IF NOT EXISTS `pt_function_model` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'id',
  `pid` int DEFAULT NULL COMMENT '父级id',
  `name` varchar(32) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '功能模块名称',
  `rtype` tinyint(1) DEFAULT NULL COMMENT '类型;0虚体, 1实体',
  `hasSubdirectory` tinyint(1) DEFAULT NULL COMMENT '是否含有子目录;0否, 1是',
  `order` int DEFAULT NULL COMMENT '排序;排序从小到大',
  `url_path` varchar(100) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '访问路径',
  `remark` varchar(100) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '备注',
  `tenant_id` int DEFAULT NULL COMMENT '租户号',
  `state` tinyint(1) DEFAULT '1' COMMENT '可用状态;是否可用；1可用,0禁用',
  `is_delete` tinyint(1) DEFAULT '0' COMMENT '是否删除;是否删除；1已删除, 0未删除',
  `revision` varchar(32) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '乐观锁',
  `created_by` varchar(32) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '创建人',
  `created_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated_by` varchar(32) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '更新人',
  `updated_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='功能模块表';

-- 正在导出表  backend-server.pt_function_model 的数据：~0 rows (大约)

-- 导出  表 backend-server.pt_message_template 结构
CREATE TABLE IF NOT EXISTS `pt_message_template` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'id',
  `tenant_id` int NOT NULL DEFAULT '0' COMMENT '租户号',
  `name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '消息模板名称',
  `description` varchar(150) COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '描述信息',
  `subject` varchar(50) COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '消息主题',
  `content` text COLLATE utf8mb4_general_ci NOT NULL COMMENT '消息正文',
  `state` tinyint(1) NOT NULL DEFAULT '1' COMMENT '状态;是否可用；1可用;0禁用',
  `is_delete` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否删除;是否删除；1已删除;0未删除',
  `created_by` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '创建人',
  `created_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated_by` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '更新人',
  `updated_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='平台消息模板表';

-- 正在导出表  backend-server.pt_message_template 的数据：~0 rows (大约)

-- 导出  表 backend-server.pt_notice 结构
CREATE TABLE IF NOT EXISTS `pt_notice` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'id',
  `tenant_id` int NOT NULL DEFAULT '0' COMMENT '租户号',
  `title` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '公告标题',
  `content` text COLLATE utf8mb4_general_ci NOT NULL COMMENT '公告内容',
  `attachment_path` varchar(150) COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '附件路径',
  `send_type` tinyint(1) NOT NULL DEFAULT '0' COMMENT '推送对象 0未知,1平台角色,2指定用户,3全局',
  `send_type_value` varchar(150) COLLATE utf8mb4_general_ci NOT NULL DEFAULT '0' COMMENT '推送对象批量值',
  `send_channel` tinyint(1) NOT NULL DEFAULT '1' COMMENT '推送渠道 0未知, 1站内信,2短信,3邮件',
  `send_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '推送时间',
  `state` tinyint(1) NOT NULL DEFAULT '1' COMMENT '状态;是否可用；1可用;0禁用',
  `is_delete` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否删除;是否删除；1已删除;0未删除',
  `created_by` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '创建人',
  `created_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated_by` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '更新人',
  `updated_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='公告信息表';

-- 正在导出表  backend-server.pt_notice 的数据：~0 rows (大约)

-- 导出  表 backend-server.pt_push_message_configuration 结构
CREATE TABLE IF NOT EXISTS `pt_push_message_configuration` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'id',
  `tenant_id` int NOT NULL DEFAULT '0' COMMENT '租户号',
  `name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '消息任务名称',
  `event_code` varchar(32) COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '消息事件编码',
  `message_type` int NOT NULL DEFAULT '0' COMMENT '消息类型编码id',
  `is_subscribe` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否可订阅, 0否,1是',
  `message_templates` varchar(150) COLLATE utf8mb4_general_ci NOT NULL DEFAULT '0' COMMENT '消息模板id列表',
  `state` tinyint(1) NOT NULL DEFAULT '1' COMMENT '状态;是否可用；1可用;0禁用',
  `is_delete` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否删除;是否删除；1已删除;0未删除',
  `created_by` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '创建人',
  `created_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated_by` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '更新人',
  `updated_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='平台消息推送任务配置表';

-- 正在导出表  backend-server.pt_push_message_configuration 的数据：~0 rows (大约)

-- 导出  表 backend-server.pt_push_message_template_configuration 结构
CREATE TABLE IF NOT EXISTS `pt_push_message_template_configuration` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'id',
  `tenant_id` int NOT NULL DEFAULT '0' COMMENT '租户号',
  `push_message_id` int NOT NULL DEFAULT '0' COMMENT '推送消息配置id',
  `message_template_id` int NOT NULL DEFAULT '0' COMMENT '消息模板id',
  `send_channel` tinyint(1) NOT NULL DEFAULT '0' COMMENT '推送渠道 0未知, 1站内信,2短信,3邮件',
  `retry_times` tinyint NOT NULL DEFAULT '0' COMMENT '重试次数',
  `state` tinyint(1) NOT NULL DEFAULT '1' COMMENT '状态;是否可用；1可用;0禁用',
  `is_delete` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否删除;是否删除；1已删除;0未删除',
  `created_by` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '创建人',
  `created_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated_by` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '更新人',
  `updated_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='平台消息推送模板配置表';

-- 正在导出表  backend-server.pt_push_message_template_configuration 的数据：~0 rows (大约)

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
