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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='功能模块';

-- 正在导出表  backend-server.pt_function_model 的数据：~0 rows (大约)

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
