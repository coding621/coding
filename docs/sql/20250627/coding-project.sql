/*
 Navicat Premium Data Transfer

 Source Server         : coding-local
 Source Server Type    : MySQL
 Source Server Version : 50742 (5.7.42)
 Source Host           : localhost:3306
 Source Schema         : coding-project

 Target Server Type    : MySQL
 Target Server Version : 50742 (5.7.42)
 File Encoding         : 65001

 Date: 27/06/2025 16:36:49
*/
CREATE DATABASE  `coding-project` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;


SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

USE `coding-project`;



-- ----------------------------
-- Table structure for coding_project
-- ----------------------------
DROP TABLE IF EXISTS `coding_project`;
CREATE TABLE `coding_project` (
  `id` varchar(64) NOT NULL COMMENT '主键id',
  `project_code` varchar(32) NOT NULL COMMENT '项目编码',
  `project_name` varchar(200) NOT NULL COMMENT '项目名称',
  `description` varchar(500) DEFAULT NULL COMMENT '描述',
  `close_begin_time` datetime DEFAULT NULL COMMENT '项目开始时间',
  `close_end_time` datetime DEFAULT NULL COMMENT '项目结束时间',
  `cover` varchar(255) DEFAULT NULL COMMENT '封面',
  `stage_code` int(11) NOT NULL DEFAULT '0' COMMENT '项目阶段 默认是0',
  `type` tinyint(1) NOT NULL DEFAULT '0' COMMENT '项目类型 是否私有 0-公开 1-私有',
  `prefix` varchar(20) DEFAULT NULL COMMENT '项目编号前缀',
  `deleted` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否删除 0-否 1-删除',
  `deleted_time` datetime DEFAULT NULL COMMENT '删除时间',
  `archived` tinyint(1) DEFAULT NULL COMMENT '是否归档 0-否 1-归档',
  `archived_time` datetime DEFAULT NULL COMMENT '归档时间',
  `published` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否发布 0-否 1-发布',
  `project_process` decimal(5,2) NOT NULL DEFAULT '0.00' COMMENT '项目进度',
  `created_by` varchar(100) DEFAULT NULL COMMENT '创建人',
  `created_time` datetime DEFAULT NULL COMMENT '创建时间',
  `updated_by` varchar(100) DEFAULT NULL COMMENT '更新人',
  `updated_time` datetime DEFAULT NULL COMMENT '更新时间',
  `user_id` bigint(20) DEFAULT NULL COMMENT '项目负责人',
  `status` tinyint(1) NOT NULL DEFAULT '0' COMMENT '项目状态 默认0-未开始',
  `auto_update_process` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否自动更新进度 0-否 1-是',
  `open_begin_time` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否开启任务开始时间',
  `open_task_private` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否开启新任务默认开启隐私模式',
  `msg_notify` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否开启消息提醒',
  `notify_day` int(11) NOT NULL DEFAULT '2' COMMENT '提醒的天数',
  `open_prefix` tinyint(1) DEFAULT '0' COMMENT '是否开启项目前缀',
  `project_stage_id` varchar(64) DEFAULT NULL COMMENT '阶段id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='项目表';


-- ----------------------------
-- Table structure for coding_project_collection
-- ----------------------------
DROP TABLE IF EXISTS `coding_project_collection`;
CREATE TABLE `coding_project_collection` (
  `id` varchar(64) NOT NULL COMMENT '主键id',
  `created_by` varchar(64) DEFAULT NULL COMMENT '创建人',
  `created_time` datetime DEFAULT NULL COMMENT '创建时间',
  `updated_by` varchar(64) DEFAULT NULL COMMENT '更新人',
  `updated_time` datetime DEFAULT NULL COMMENT '更新时间',
  `project_id` varchar(64) DEFAULT NULL COMMENT '项目id',
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='项目-收藏表';

-- ----------------------------
-- Records of coding_project_collection
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for coding_project_file
-- ----------------------------
DROP TABLE IF EXISTS `coding_project_file`;
CREATE TABLE `coding_project_file` (
  `id` varchar(64) NOT NULL COMMENT '主键id',
  `type` varchar(20) DEFAULT NULL COMMENT '文件归属类型 task 或者 project',
  `pt_id` varchar(64) NOT NULL COMMENT 'type是task 对应就是task的id type是project 对应就是project的id',
  `file_name` varchar(100) NOT NULL COMMENT '文件名称',
  `file_size` decimal(11,2) DEFAULT NULL COMMENT '文件大小',
  `extension` varchar(32) NOT NULL COMMENT '扩展名',
  `file_url` varchar(200) NOT NULL COMMENT '文件完整地址',
  `deleted` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否删除 0-否 1-删除',
  `deleted_time` datetime DEFAULT NULL COMMENT '删除时间',
  `created_by` varchar(64) DEFAULT NULL COMMENT '创建人',
  `created_time` datetime DEFAULT NULL COMMENT '创建时间',
  `updated_by` varchar(64) DEFAULT NULL COMMENT '更新人',
  `updated_time` datetime DEFAULT NULL COMMENT '更新时间',
  `user_id` bigint(20) DEFAULT NULL COMMENT '上传人id',
  `project_id` varchar(64) NOT NULL COMMENT '项目id',
  `path_name` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='项目或任务附件表';

-- ----------------------------
-- Records of coding_project_file
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for coding_project_log
-- ----------------------------
DROP TABLE IF EXISTS `coding_project_log`;
CREATE TABLE `coding_project_log` (
  `id` varchar(64) NOT NULL COMMENT '主键id',
  `user_id` bigint(20) NOT NULL COMMENT '操作人id',
  `type` varchar(16) NOT NULL COMMENT '类型 project 或者 task',
  `operate_type` varchar(32) NOT NULL COMMENT '操作类型',
  `content` text COMMENT '操作内容',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  `pt_id` varchar(64) NOT NULL COMMENT '项目或者任务id',
  `to_user_id` bigint(20) DEFAULT NULL,
  `created_by` varchar(64) DEFAULT NULL,
  `created_time` datetime DEFAULT NULL,
  `updated_by` varchar(64) DEFAULT NULL,
  `updated_time` datetime DEFAULT NULL,
  `log_type` tinyint(1) NOT NULL DEFAULT '1' COMMENT '1-动态 2-交付物 3-评论',
  `file_url` varchar(500) DEFAULT NULL COMMENT '文件地址',
  `icon` varchar(20) DEFAULT NULL,
  `project_id` varchar(64) NOT NULL COMMENT '项目id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='项目-任务日志';



-- ----------------------------
-- Table structure for coding_project_member
-- ----------------------------
DROP TABLE IF EXISTS `coding_project_member`;
CREATE TABLE `coding_project_member` (
  `id` varchar(64) NOT NULL COMMENT '主键id',
  `pt_id` varchar(64) NOT NULL COMMENT '项目或者任务id',
  `user_id` bigint(20) NOT NULL COMMENT '用户id',
  `joined_time` datetime DEFAULT NULL COMMENT '加入时间',
  `created_by` varchar(100) DEFAULT NULL COMMENT '创建人',
  `created_time` datetime DEFAULT NULL COMMENT '创建时间',
  `updated_by` varchar(100) DEFAULT NULL COMMENT '更新人',
  `updated_time` datetime DEFAULT NULL COMMENT '更新时间',
  `type` varchar(32) NOT NULL COMMENT '类型是项目还是任务 task project',
  `creator` tinyint(1) DEFAULT '0' COMMENT '是否创建者',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='项目-任务成员';

-- ----------------------------
-- Records of coding_project_member
-- ----------------------------


-- ----------------------------
-- Table structure for coding_project_stage
-- ----------------------------
DROP TABLE IF EXISTS `coding_project_stage`;
CREATE TABLE `coding_project_stage` (
  `id` varchar(64) NOT NULL COMMENT '主键id',
  `stage_code` int(11) NOT NULL COMMENT '阶段编码',
  `stage_name` varchar(100) NOT NULL COMMENT '阶段名称',
  `description` varchar(255) DEFAULT NULL COMMENT '阶段描述',
  `project_id` varchar(64) NOT NULL COMMENT '项目id',
  `deleted` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否删除 0-否 1-删除',
  `created_by` varchar(64) DEFAULT NULL COMMENT '创建人',
  `created_time` datetime DEFAULT NULL COMMENT '创建时间',
  `updated_by` varchar(64) DEFAULT NULL COMMENT '更新人',
  `updated_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='项目阶段';

-- ----------------------------
-- Records of coding_project_stage
-- ----------------------------
BEGIN;
INSERT INTO `coding_project_stage` (`id`, `stage_code`, `stage_name`, `description`, `project_id`, `deleted`, `created_by`, `created_time`, `updated_by`, `updated_time`) VALUES ('0daaf2b9de2b3c9bcb9d7c89eeff9c03', 3, '交付验收阶段', NULL, 'c3e462c400f66fe0b68d9d2c1bef9ffc', 0, 'admin', '2024-04-01 16:01:10', 'admin', '2024-04-01 16:01:10');
INSERT INTO `coding_project_stage` (`id`, `stage_code`, `stage_name`, `description`, `project_id`, `deleted`, `created_by`, `created_time`, `updated_by`, `updated_time`) VALUES ('4325973a30ce9b9d7d5f1e4fa074891f', 2, '研发实施阶段', NULL, 'c3e462c400f66fe0b68d9d2c1bef9ffc', 0, 'admin', '2024-04-01 16:01:10', 'admin', '2024-04-01 16:01:10');
INSERT INTO `coding_project_stage` (`id`, `stage_code`, `stage_name`, `description`, `project_id`, `deleted`, `created_by`, `created_time`, `updated_by`, `updated_time`) VALUES ('5a3eda6d32b85df82964021a7a042159', 0, '项目立项阶段', NULL, 'c3e462c400f66fe0b68d9d2c1bef9ffc', 0, 'admin', '2024-04-01 16:01:10', 'admin', '2024-04-01 16:01:10');
INSERT INTO `coding_project_stage` (`id`, `stage_code`, `stage_name`, `description`, `project_id`, `deleted`, `created_by`, `created_time`, `updated_by`, `updated_time`) VALUES ('5c40e5da93bd6fc343a0909a9f01c73c', 3, '交付验收阶段', NULL, 'aa3a0a9c72c6322d893768c3b05615fa', 0, 'admin', '2024-04-01 14:58:43', 'admin', '2024-04-01 14:58:43');
INSERT INTO `coding_project_stage` (`id`, `stage_code`, `stage_name`, `description`, `project_id`, `deleted`, `created_by`, `created_time`, `updated_by`, `updated_time`) VALUES ('6359652deefcbc760893e79f55b23a20', 4, '新产品导出阶段', NULL, 'aa3a0a9c72c6322d893768c3b05615fa', 0, 'admin', '2024-04-01 14:58:43', 'admin', '2024-04-01 14:58:43');
INSERT INTO `coding_project_stage` (`id`, `stage_code`, `stage_name`, `description`, `project_id`, `deleted`, `created_by`, `created_time`, `updated_by`, `updated_time`) VALUES ('64a586191a41de633fba33976af476ca', 1, '研发设计输入阶段', NULL, 'aa3a0a9c72c6322d893768c3b05615fa', 0, 'admin', '2024-04-01 14:58:43', 'admin', '2024-04-01 14:58:43');
INSERT INTO `coding_project_stage` (`id`, `stage_code`, `stage_name`, `description`, `project_id`, `deleted`, `created_by`, `created_time`, `updated_by`, `updated_time`) VALUES ('83641c127c6514ff68222eb666f3cadf', 1, '研发设计输入阶段', NULL, 'c3e462c400f66fe0b68d9d2c1bef9ffc', 0, 'admin', '2024-04-01 16:01:10', 'admin', '2024-04-01 16:01:10');
INSERT INTO `coding_project_stage` (`id`, `stage_code`, `stage_name`, `description`, `project_id`, `deleted`, `created_by`, `created_time`, `updated_by`, `updated_time`) VALUES ('8c7441c41bcc7e824a7a4b3c1cd72d24', 2, '研发实施阶段', NULL, 'aa3a0a9c72c6322d893768c3b05615fa', 0, 'admin', '2024-04-01 14:58:43', 'admin', '2024-04-01 14:58:43');
INSERT INTO `coding_project_stage` (`id`, `stage_code`, `stage_name`, `description`, `project_id`, `deleted`, `created_by`, `created_time`, `updated_by`, `updated_time`) VALUES ('936cf8a130ce76e39b73e6e0ebe36800', 0, '项目立项阶段', NULL, 'aa3a0a9c72c6322d893768c3b05615fa', 0, 'admin', '2024-04-01 14:58:43', 'admin', '2024-04-01 14:58:43');
INSERT INTO `coding_project_stage` (`id`, `stage_code`, `stage_name`, `description`, `project_id`, `deleted`, `created_by`, `created_time`, `updated_by`, `updated_time`) VALUES ('c459c5b373983888cf0a98055a95451f', 4, '新产品导出阶段', NULL, 'c3e462c400f66fe0b68d9d2c1bef9ffc', 0, 'admin', '2024-04-01 16:01:10', 'admin', '2024-04-01 16:01:10');
COMMIT;

-- ----------------------------
-- Table structure for coding_project_task
-- ----------------------------
DROP TABLE IF EXISTS `coding_project_task`;
CREATE TABLE `coding_project_task` (
  `id` varchar(64) NOT NULL COMMENT '主键id',
  `created_by` varchar(64) DEFAULT NULL COMMENT '创建人',
  `created_time` datetime DEFAULT NULL COMMENT '创建时间',
  `updated_by` varchar(64) DEFAULT NULL COMMENT '更新人',
  `updated_time` datetime DEFAULT NULL COMMENT '更新时间',
  `task_name` varchar(100) DEFAULT NULL COMMENT '任务名称',
  `project_id` varchar(64) DEFAULT NULL COMMENT '项目id',
  `task_priority` tinyint(1) NOT NULL DEFAULT '0' COMMENT '任务优先级',
  `user_id` bigint(20) NOT NULL COMMENT '用户id',
  `project_stage_id` varchar(64) NOT NULL COMMENT '项目阶段id',
  `description` varchar(500) DEFAULT NULL COMMENT '任务描述',
  `begin_time` datetime DEFAULT NULL COMMENT '预计开始时间',
  `end_time` datetime DEFAULT NULL COMMENT '预计结束时间',
  `close_time` datetime DEFAULT NULL COMMENT '截止时间',
  `task_pid` varchar(64) DEFAULT NULL COMMENT '任务父节点',
  `assign_to` varchar(64) DEFAULT NULL COMMENT '指派给谁',
  `status` tinyint(1) NOT NULL DEFAULT '0' COMMENT '任务状态',
  `execute_status` tinyint(1) NOT NULL DEFAULT '0' COMMENT '执行状态',
  `task_process` decimal(5,2) NOT NULL DEFAULT '0.00' COMMENT '任务进度',
  `deleted` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否删除',
  `deleted_time` datetime DEFAULT NULL,
  `task_flow` varchar(200) DEFAULT NULL COMMENT '所属流程',
  `task_type_id` varchar(64) DEFAULT NULL COMMENT '任务类型id',
  PRIMARY KEY (`id`) USING BTREE,
  KEY `idx` (`id`,`project_id`,`user_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='项目-任务表';

-- ----------------------------
-- Records of coding_project_task
-- ----------------------------

-- ----------------------------
-- Table structure for coding_project_task_notify
-- ----------------------------
DROP TABLE IF EXISTS `coding_project_task_notify`;
CREATE TABLE `coding_project_task_notify` (
  `id` varchar(64) NOT NULL,
  `task_id` varchar(64) DEFAULT NULL COMMENT '任务id',
  `user_id` int(11) DEFAULT NULL COMMENT '用户id',
  `user_wx_name` varchar(64) DEFAULT NULL COMMENT '企业微信id',
  `project_id` varchar(64) DEFAULT NULL COMMENT '项目id',
  `overdue` tinyint(1) DEFAULT NULL COMMENT '是否逾期 0-否 1-是',
  `close_time` datetime DEFAULT NULL,
  `task_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='任务提醒表';

-- ----------------------------
-- Records of coding_project_task_notify
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for coding_project_task_process
-- ----------------------------
DROP TABLE IF EXISTS `coding_project_task_process`;
CREATE TABLE `coding_project_task_process` (
  `id` varchar(64) NOT NULL,
  `extra_id` varchar(64) DEFAULT NULL COMMENT '项目任务id',
  `approved` varchar(10) DEFAULT NULL COMMENT '是否需要审批',
  `instance_id` varchar(64) DEFAULT NULL COMMENT '流程实例id',
  `deployment_id` varchar(64) DEFAULT NULL COMMENT '部署id',
  `definition_id` varchar(64) DEFAULT NULL COMMENT '流程定义id',
  `created_by` varchar(64) DEFAULT NULL,
  `created_time` datetime DEFAULT NULL,
  `updated_by` varchar(64) DEFAULT NULL,
  `updated_time` datetime DEFAULT NULL,
  `type` varchar(64) DEFAULT NULL COMMENT '类型task/project等',
  `task_id` varchar(64) DEFAULT NULL COMMENT '流程任务id',
  `url` varchar(1000) DEFAULT NULL COMMENT '详情地址',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of coding_project_task_process
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for coding_project_task_work_time
-- ----------------------------
DROP TABLE IF EXISTS `coding_project_task_work_time`;
CREATE TABLE `coding_project_task_work_time` (
  `id` varchar(64) NOT NULL COMMENT '主键id',
  `project_task_id` varchar(64) NOT NULL COMMENT '任务id',
  `user_id` varchar(64) NOT NULL COMMENT '用户id',
  `work_time` decimal(5,2) DEFAULT NULL COMMENT '工时',
  `project_id` varchar(64) NOT NULL COMMENT '项目id',
  `created_by` varchar(64) DEFAULT NULL,
  `created_time` datetime DEFAULT NULL,
  `updated_by` varchar(64) DEFAULT NULL,
  `updated_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='任务工时表';

-- ----------------------------
-- Records of coding_project_task_work_time
-- ----------------------------
BEGIN;
COMMIT;

-- for AT mode you must to init this sql for you business database. the seata server not need it.
CREATE TABLE IF NOT EXISTS `undo_log`
(
    `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
    `branch_id`     BIGINT       NOT NULL COMMENT 'branch transaction id',
    `xid`           VARCHAR(128) NOT NULL COMMENT 'global transaction id',
    `context`       VARCHAR(128) NOT NULL COMMENT 'undo_log context,such as serialization',
    `rollback_info` LONGBLOB     NOT NULL COMMENT 'rollback info',
    `log_status`    INT(11)      NOT NULL COMMENT '0:normal status,1:defense status',
    `log_created`   DATETIME(6)  NOT NULL COMMENT 'create datetime',
    `log_modified`  DATETIME(6)  NOT NULL COMMENT 'modify datetime',
    PRIMARY KEY (`id`),
    UNIQUE KEY `ux_undo_log` (`xid`, `branch_id`)
    ) ENGINE = InnoDB AUTO_INCREMENT = 1 DEFAULT CHARSET = utf8mb4 COMMENT ='AT transaction mode undo table';
ALTER TABLE `undo_log` ADD INDEX `ix_log_created` (`log_created`);

-- ----------------------------
-- Records of undo_log
-- ----------------------------
BEGIN;
COMMIT;


SET FOREIGN_KEY_CHECKS = 1;
