/*
 Navicat Premium Data Transfer

 Source Server         : QPF
 Source Server Type    : MySQL
 Source Server Version : 50527
 Source Host           : localhost:3306
 Source Schema         : timeloan

 Target Server Type    : MySQL
 Target Server Version : 50527
 File Encoding         : 65001

 Date: 21/03/2019 09:14:22
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_loan
-- ----------------------------
DROP TABLE IF EXISTS `t_loan`;
CREATE TABLE `t_loan`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `loanSum` double(11, 2) NULL DEFAULT NULL,
  `loanRate` double(4, 4) NULL DEFAULT NULL COMMENT '利率',
  `loanDate` date NULL DEFAULT NULL COMMENT '发起贷款日期',
  `loanStartDate` date NULL DEFAULT NULL COMMENT '贷款开始日期',
  `loanEndDate` date NULL DEFAULT NULL COMMENT '还款日期',
  `loanDay` int(255) NULL DEFAULT NULL COMMENT '贷款多长时间',
  `uid` int(11) NULL DEFAULT NULL,
  `loanstate` int(1) NULL DEFAULT 0 COMMENT '贷款状态 0未审批 1审批中 2 审批完成',
  `loantype` int(1) NULL DEFAULT NULL,
  `loanCode` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '贷款流水号',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 38 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_loan
-- ----------------------------
INSERT INTO `t_loan` VALUES (2, 233.00, 0.0011, '2019-02-04', '2019-02-20', '2019-02-21', 22, 2, 2, 2, '22222222');
INSERT INTO `t_loan` VALUES (14, 50000.00, 0.0011, '2019-02-19', '2019-02-21', '2019-02-21', 90, 1, 2, 2, '1550560431785');
INSERT INTO `t_loan` VALUES (16, 50000.00, 0.0011, '2019-02-20', '2019-02-21', '2019-03-23', 30, 17, 2, 1, '1550623285108');
INSERT INTO `t_loan` VALUES (17, 2500.00, 0.0011, '2019-02-20', '2019-02-21', '2019-03-23', 30, 6, 2, 4, '1550623669669');
INSERT INTO `t_loan` VALUES (19, 30000.00, 0.0011, '2019-02-21', '2019-02-21', '2019-03-23', 30, 13, 2, 4, '1550710259780');
INSERT INTO `t_loan` VALUES (20, 2500.00, 0.0011, '2019-02-21', NULL, NULL, 44, 14, 2, 1, '1550712628717');
INSERT INTO `t_loan` VALUES (21, 22222.00, 0.0011, '2019-02-21', NULL, NULL, 234, 15, 2, 1, '1550712790213');
INSERT INTO `t_loan` VALUES (22, 50000.00, 0.0011, '2019-02-21', '2019-02-21', '2019-03-23', 30, 7, 2, 4, '1550713052423');
INSERT INTO `t_loan` VALUES (23, 221.00, 0.0011, '2019-02-21', '2019-02-22', '2019-02-24', 3, 16, 2, 2, '1550713164011');
INSERT INTO `t_loan` VALUES (24, 3500.00, 0.0011, '2019-02-22', NULL, NULL, 60, 20, 2, 2, '1550800668410');
INSERT INTO `t_loan` VALUES (29, 10000.00, 0.0011, '2019-02-22', '2019-02-25', '2019-02-24', 30, 21, 2, 2, '1550812837218');
INSERT INTO `t_loan` VALUES (30, 10000.00, 0.0011, '2019-02-22', NULL, NULL, 30, 22, 0, 2, '1550813015265');
INSERT INTO `t_loan` VALUES (32, 4000.00, 0.0011, '2019-02-25', '2019-02-25', '2019-02-28', 30, 23, 2, 2, '1551066446886');
INSERT INTO `t_loan` VALUES (33, 50000.00, 0.0011, '2019-02-26', NULL, NULL, 90, 1, 0, 2, '1551162337241');
INSERT INTO `t_loan` VALUES (34, 100.00, 0.0011, '2019-03-14', '2019-03-14', '2019-04-13', 30, 32, 2, 1, '1552563688290');
INSERT INTO `t_loan` VALUES (35, 50000.00, 0.0011, '2019-03-14', '2019-03-14', '2019-06-22', 100, 32, 2, 1, '1552564257442');
INSERT INTO `t_loan` VALUES (36, 5000.00, 0.0011, '2019-03-14', '2019-03-14', '2019-04-13', 30, 36, 2, 1, '1552566802428');
INSERT INTO `t_loan` VALUES (37, 10000.00, 0.0011, '2019-03-15', '2019-03-15', '2019-04-14', 30, 37, 2, 1, '1552613882994');

-- ----------------------------
-- Table structure for t_loantype
-- ----------------------------
DROP TABLE IF EXISTS `t_loantype`;
CREATE TABLE `t_loantype`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `node` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_loantype
-- ----------------------------
INSERT INTO `t_loantype` VALUES (1, '医疗', '2,3,4');
INSERT INTO `t_loantype` VALUES (2, '日常消费', '1,2,3,4,5');
INSERT INTO `t_loantype` VALUES (3, '房贷', '2,3,4,5');
INSERT INTO `t_loantype` VALUES (4, '其他', '3,4,5');

-- ----------------------------
-- Table structure for t_repayment
-- ----------------------------
DROP TABLE IF EXISTS `t_repayment`;
CREATE TABLE `t_repayment`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `lid` int(11) NULL DEFAULT NULL COMMENT '贷款表id',
  `repaymoney` double(11, 2) NULL DEFAULT NULL COMMENT '还款金额',
  `allsum` double(11, 2) NULL DEFAULT NULL COMMENT '需还金额',
  `repaystate` int(1) NULL DEFAULT NULL COMMENT '0表示未还 1表示未还清  2表示已还清 3表示逾期',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 21 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_repayment
-- ----------------------------
INSERT INTO `t_repayment` VALUES (1, 2, 238.70, 238.70, 2);
INSERT INTO `t_repayment` VALUES (2, 14, 1033.53, 1033.53, 2);
INSERT INTO `t_repayment` VALUES (3, 16, 51676.59, 51676.59, 2);
INSERT INTO `t_repayment` VALUES (4, 17, 2583.83, 2583.83, 2);
INSERT INTO `t_repayment` VALUES (5, 19, 31005.95, 31005.95, 2);
INSERT INTO `t_repayment` VALUES (6, 22, 51676.59, 51676.59, 2);
INSERT INTO `t_repayment` VALUES (12, 23, 221.73, 221.73, 2);
INSERT INTO `t_repayment` VALUES (13, 29, 10335.32, 10335.32, 2);
INSERT INTO `t_repayment` VALUES (14, 32, 4134.13, 4134.13, 2);
INSERT INTO `t_repayment` VALUES (15, 34, 103.35, 103.35, 2);
INSERT INTO `t_repayment` VALUES (18, 35, 0.00, 55810.53, 0);
INSERT INTO `t_repayment` VALUES (19, 36, 5167.66, 5167.66, 2);
INSERT INTO `t_repayment` VALUES (20, 37, 10335.32, 10335.32, 2);

-- ----------------------------
-- Table structure for t_role
-- ----------------------------
DROP TABLE IF EXISTS `t_role`;
CREATE TABLE `t_role`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `level` int(1) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_role
-- ----------------------------
INSERT INTO `t_role` VALUES (1, '业务组长', 1);
INSERT INTO `t_role` VALUES (2, '审批组长', 2);
INSERT INTO `t_role` VALUES (3, '一级部门经理', 3);
INSERT INTO `t_role` VALUES (4, '一级部门总监', 4);
INSERT INTO `t_role` VALUES (5, '董事长', 5);
INSERT INTO `t_role` VALUES (6, '普通员工', 6);

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `state` int(2) NULL DEFAULT 0,
  `realname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `idcard` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `isemp` int(11) NULL DEFAULT NULL COMMENT '是否为公司员工',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 38 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES (1, 'tom', '123', 1, '汤姆', '230225199111302610', '15711358121', NULL);
INSERT INTO `t_user` VALUES (2, 'jerry', '123', 1, '杰瑞', '230225199111302611', '15711358122', NULL);
INSERT INTO `t_user` VALUES (3, 'marry', '123', 0, '玛丽', '230225199111302612', '15711358123', 1);
INSERT INTO `t_user` VALUES (4, 'tony', '123', 0, '托尼', '230225199111302613', '15711358124', 1);
INSERT INTO `t_user` VALUES (6, 'tom11', '123', 1, 'asda', '230225199111302619', '15600609590', NULL);
INSERT INTO `t_user` VALUES (7, 'qqq', '123', 1, 'qpf', '370786199411281576', '17560668680', NULL);
INSERT INTO `t_user` VALUES (8, 'q12', '123', 0, 'dsz', '370786199511281576', '17560668888', 1);
INSERT INTO `t_user` VALUES (9, 'zhu', '122', 0, ' 朱伟光', '412723200006193438', '15896791662', 1);
INSERT INTO `t_user` VALUES (10, 'zgy', '123', 0, ' zhu', '370786199411221576', '17560668687', 1);
INSERT INTO `t_user` VALUES (11, 'ld', '123', 0, 'lido', '370786199511251576', '18532204884', 1);
INSERT INTO `t_user` VALUES (12, 'li', '123', 0, '老李', '230225199111302609', '15711358120', 1);
INSERT INTO `t_user` VALUES (13, 'gao', '123', 1, '高瑜', '370786119911251576', '18532204882', NULL);
INSERT INTO `t_user` VALUES (14, 'sun', '123', 1, 'sun', '360686199404181576', '15600609522', NULL);
INSERT INTO `t_user` VALUES (15, 'yu', '123', 1, 'yu', '377786199444551576', '15600608590', NULL);
INSERT INTO `t_user` VALUES (16, 'yue', '123', 1, 'yue', '370786199411281676', '15200609590', NULL);
INSERT INTO `t_user` VALUES (17, 'wu', '123', 1, 'wu', '220786199444124579', '13600609590', NULL);
INSERT INTO `t_user` VALUES (18, 'zz', '123', 0, 'zz', '370756199544587516', '18332204884', 1);
INSERT INTO `t_user` VALUES (20, 'hhhh', '123', 1, 'hhhhh', '230225199111302589', '15600609511', NULL);
INSERT INTO `t_user` VALUES (21, '111', '123', 1, 'zhu1', '412723200006194561', '13245678901', NULL);
INSERT INTO `t_user` VALUES (22, 'zhu1', '123', 1, '朱伟光', '412723200006193430', '15896791660', NULL);
INSERT INTO `t_user` VALUES (23, '1234', '123', 1, 'zqw1', '412723200006194456', '13459600495', NULL);
INSERT INTO `t_user` VALUES (24, 'v', '123', 1, 'zq', '324324324234323434', '15343554534', NULL);
INSERT INTO `t_user` VALUES (25, 't', '123', 1, 'r', '234234232342232322', '13445435435', NULL);
INSERT INTO `t_user` VALUES (26, '10086', '123', 0, 'yy', '424343242424332434', '13434343242', NULL);
INSERT INTO `t_user` VALUES (27, ' q', ' 123', 0, ' 12345', '232342342342323424', '13434343355', NULL);
INSERT INTO `t_user` VALUES (28, ' w', ' 123', 0, ' 1111', '433334343343344334', '13434443456', NULL);
INSERT INTO `t_user` VALUES (29, '1', '123', 0, '1111111', '453454353435453534', '13434434343', NULL);
INSERT INTO `t_user` VALUES (30, 'zhen', '123', 0, 'zhen', '310568944455553168', '15665487982', NULL);
INSERT INTO `t_user` VALUES (31, '4', '123', 0, '22', '424342434234234243', '13434343443', 1);
INSERT INTO `t_user` VALUES (32, 'ss', '123', 1, '旺旺', '142402200009034535', '13097531080', NULL);
INSERT INTO `t_user` VALUES (33, 'zy', '123', 0, '上上', '142402200009034536', '18234445999', 1);
INSERT INTO `t_user` VALUES (34, 'ln', '123', 0, '李宁', '142402200009034537', '15935442233', 1);
INSERT INTO `t_user` VALUES (35, 'ew', '123', 0, ' 李栋', '142402200009034539', '15849578462', 1);
INSERT INTO `t_user` VALUES (36, 'jiawei', '123', 1, '价位', '142402200009034534', '18234449999', NULL);
INSERT INTO `t_user` VALUES (37, 'xt', '123', 1, '小天', '142402200009034529', '18532204887', NULL);

-- ----------------------------
-- Table structure for t_user_rate
-- ----------------------------
DROP TABLE IF EXISTS `t_user_rate`;
CREATE TABLE `t_user_rate`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uid` int(11) NULL DEFAULT NULL,
  `loanRate` double(11, 6) NULL DEFAULT NULL,
  `integral` int(255) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 24 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_user_rate
-- ----------------------------
INSERT INTO `t_user_rate` VALUES (1, 1, 0.001100, 80);
INSERT INTO `t_user_rate` VALUES (2, 2, 0.001100, 80);
INSERT INTO `t_user_rate` VALUES (3, 6, 0.000900, 100);
INSERT INTO `t_user_rate` VALUES (4, 7, 0.001100, 80);
INSERT INTO `t_user_rate` VALUES (5, 13, 0.001300, 55);
INSERT INTO `t_user_rate` VALUES (6, 14, 0.001100, 80);
INSERT INTO `t_user_rate` VALUES (7, 15, 0.001100, 80);
INSERT INTO `t_user_rate` VALUES (8, 16, 0.001100, 80);
INSERT INTO `t_user_rate` VALUES (9, 17, 0.001100, 80);
INSERT INTO `t_user_rate` VALUES (10, 20, 0.001100, 80);
INSERT INTO `t_user_rate` VALUES (11, 21, 0.001100, 80);
INSERT INTO `t_user_rate` VALUES (12, 22, 0.001100, 80);
INSERT INTO `t_user_rate` VALUES (13, 23, 0.001100, 85);
INSERT INTO `t_user_rate` VALUES (14, 24, 0.001100, 80);
INSERT INTO `t_user_rate` VALUES (15, 25, 0.001100, 80);
INSERT INTO `t_user_rate` VALUES (16, 26, 0.001100, 80);
INSERT INTO `t_user_rate` VALUES (17, 27, 0.001100, 80);
INSERT INTO `t_user_rate` VALUES (18, 28, 0.001100, 80);
INSERT INTO `t_user_rate` VALUES (19, 29, 0.001100, 80);
INSERT INTO `t_user_rate` VALUES (20, 30, 0.001100, 80);
INSERT INTO `t_user_rate` VALUES (21, 32, 0.001300, 65);
INSERT INTO `t_user_rate` VALUES (22, 36, 0.001100, 85);
INSERT INTO `t_user_rate` VALUES (23, 37, 0.001100, 85);

-- ----------------------------
-- Table structure for t_user_role
-- ----------------------------
DROP TABLE IF EXISTS `t_user_role`;
CREATE TABLE `t_user_role`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uid` int(11) NULL DEFAULT NULL,
  `rid` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 14 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_user_role
-- ----------------------------
INSERT INTO `t_user_role` VALUES (2, 3, 2);
INSERT INTO `t_user_role` VALUES (3, 4, 4);
INSERT INTO `t_user_role` VALUES (4, 8, 5);
INSERT INTO `t_user_role` VALUES (5, 9, 4);
INSERT INTO `t_user_role` VALUES (6, 10, 2);
INSERT INTO `t_user_role` VALUES (7, 11, 1);
INSERT INTO `t_user_role` VALUES (8, 12, 5);
INSERT INTO `t_user_role` VALUES (9, 18, 3);
INSERT INTO `t_user_role` VALUES (10, 31, 6);
INSERT INTO `t_user_role` VALUES (11, 33, 2);
INSERT INTO `t_user_role` VALUES (12, 34, 3);
INSERT INTO `t_user_role` VALUES (13, 35, 4);

-- ----------------------------
-- Table structure for t_workflow
-- ----------------------------
DROP TABLE IF EXISTS `t_workflow`;
CREATE TABLE `t_workflow`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `lid` int(11) NULL DEFAULT NULL,
  `state` int(1) NULL DEFAULT 0 COMMENT '0:未审批  1：审批中，2:审批通过，3：审批未通过',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 38 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_workflow
-- ----------------------------
INSERT INTO `t_workflow` VALUES (1, 2, 2);
INSERT INTO `t_workflow` VALUES (14, 14, 2);
INSERT INTO `t_workflow` VALUES (16, 16, 2);
INSERT INTO `t_workflow` VALUES (17, 17, 2);
INSERT INTO `t_workflow` VALUES (18, 19, 2);
INSERT INTO `t_workflow` VALUES (19, 20, 3);
INSERT INTO `t_workflow` VALUES (21, 21, 3);
INSERT INTO `t_workflow` VALUES (22, 22, 2);
INSERT INTO `t_workflow` VALUES (23, 23, 2);
INSERT INTO `t_workflow` VALUES (24, 24, 3);
INSERT INTO `t_workflow` VALUES (29, 29, 2);
INSERT INTO `t_workflow` VALUES (30, 30, 0);
INSERT INTO `t_workflow` VALUES (32, 32, 2);
INSERT INTO `t_workflow` VALUES (33, 33, 0);
INSERT INTO `t_workflow` VALUES (34, 34, 2);
INSERT INTO `t_workflow` VALUES (35, 35, 2);
INSERT INTO `t_workflow` VALUES (36, 36, 2);
INSERT INTO `t_workflow` VALUES (37, 37, 2);

-- ----------------------------
-- Table structure for t_workflow_log
-- ----------------------------
DROP TABLE IF EXISTS `t_workflow_log`;
CREATE TABLE `t_workflow_log`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `workdate` datetime NULL DEFAULT NULL,
  `optiontext` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '审批意见',
  `wid` int(11) NULL DEFAULT NULL,
  `spman` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '审批人',
  `sprole` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '审批人角色',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 81 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_workflow_log
-- ----------------------------
INSERT INTO `t_workflow_log` VALUES (10, '2019-02-20 15:06:58', '同意', 1, 'lido', '业务组长');
INSERT INTO `t_workflow_log` VALUES (13, '2019-02-20 15:46:01', '同意', 14, '玛丽', '审批组长');
INSERT INTO `t_workflow_log` VALUES (18, '2019-02-20 16:12:13', '同意', 1, ' zhu', '审批组长');
INSERT INTO `t_workflow_log` VALUES (21, '2019-02-20 16:15:23', '同意', 1, 'zz', '一级部门经理');
INSERT INTO `t_workflow_log` VALUES (22, '2019-02-20 16:18:52', 'ty', 1, '托尼', '一部门总监');
INSERT INTO `t_workflow_log` VALUES (23, '2019-02-20 16:19:29', 'ty', 1, 'dsz', '董事长');
INSERT INTO `t_workflow_log` VALUES (24, '2019-02-20 16:20:59', 'ty', 1, 'dsz', '董事长');
INSERT INTO `t_workflow_log` VALUES (25, '2019-02-20 16:24:25', 'ty', 1, 'dsz', '董事长');
INSERT INTO `t_workflow_log` VALUES (26, '2019-02-20 16:27:33', 'ty', 1, 'dsz', '董事长');
INSERT INTO `t_workflow_log` VALUES (27, '2019-02-20 16:29:18', 'ty', 1, 'dsz', '董事长');
INSERT INTO `t_workflow_log` VALUES (28, '2019-02-20 16:33:25', 'ty', 1, 'dsz', '董事长');
INSERT INTO `t_workflow_log` VALUES (29, '2019-02-20 16:37:49', 'TY', 1, 'dsz', '董事长');
INSERT INTO `t_workflow_log` VALUES (30, '2019-02-20 16:56:54', 'ty', 1, 'dsz', '董事长');
INSERT INTO `t_workflow_log` VALUES (31, '2019-02-20 16:58:36', 'ty', 1, 'dsz', '董事长');
INSERT INTO `t_workflow_log` VALUES (32, '2019-02-20 17:00:19', 'ty', 1, 'dsz', '董事长');
INSERT INTO `t_workflow_log` VALUES (33, '2019-02-21 08:48:13', 'Ty', 14, 'zz', '一级部门经理');
INSERT INTO `t_workflow_log` VALUES (34, '2019-02-21 08:49:09', 'Ty', 17, 'zz', '一级部门经理');
INSERT INTO `t_workflow_log` VALUES (35, '2019-02-21 08:54:53', 'ty', 16, '玛丽', '审批组长');
INSERT INTO `t_workflow_log` VALUES (36, '2019-02-21 08:54:53', 'ty', 16, '玛丽', '审批组长');
INSERT INTO `t_workflow_log` VALUES (37, '2019-02-21 09:06:27', 'ty', 16, '玛丽', '审批组长');
INSERT INTO `t_workflow_log` VALUES (38, '2019-02-21 09:08:24', 'ty', 16, '玛丽', '审批组长');
INSERT INTO `t_workflow_log` VALUES (39, '2019-02-21 09:27:20', 'ty', 18, 'zz', '一级部门经理');
INSERT INTO `t_workflow_log` VALUES (40, '2019-02-21 09:28:35', 'ty', 18, 'dsz', '董事长');
INSERT INTO `t_workflow_log` VALUES (41, '2019-02-21 09:34:05', 'ty', 19, '玛丽', '审批组长');
INSERT INTO `t_workflow_log` VALUES (42, '2019-02-21 09:35:28', 'ty', 21, '玛丽', '审批组长');
INSERT INTO `t_workflow_log` VALUES (43, '2019-02-21 09:38:10', 'ty', 22, 'zz', '一级部门经理');
INSERT INTO `t_workflow_log` VALUES (44, '2019-02-21 09:39:57', 'ty', 23, 'lido', '业务组长');
INSERT INTO `t_workflow_log` VALUES (45, '2019-02-21 09:41:21', 'ty', 23, '玛丽', '审批组长');
INSERT INTO `t_workflow_log` VALUES (46, '2019-02-21 09:46:09', 'ty', 23, 'zz', '一级部门经理');
INSERT INTO `t_workflow_log` VALUES (47, '2019-02-21 14:51:19', '不同意', 19, '托尼', '一部门总监');
INSERT INTO `t_workflow_log` VALUES (48, '2019-02-21 14:54:19', '不同意', 21, '托尼', '一部门总监');
INSERT INTO `t_workflow_log` VALUES (49, '2019-02-21 15:37:56', '同意', 23, '托尼', '一部门总监');
INSERT INTO `t_workflow_log` VALUES (50, '2019-02-21 15:47:56', 'ty', 22, 'dsz', '董事长');
INSERT INTO `t_workflow_log` VALUES (51, '2019-02-22 10:49:27', '5551', 24, 'lido', '业务组长');
INSERT INTO `t_workflow_log` VALUES (52, '2019-02-22 14:03:25', '1', 23, 'dsz', '董事长');
INSERT INTO `t_workflow_log` VALUES (53, '2019-02-22 14:04:59', '1', 23, 'dsz', '董事长');
INSERT INTO `t_workflow_log` VALUES (54, '2019-02-22 14:13:44', '1', 23, 'dsz', '董事长');
INSERT INTO `t_workflow_log` VALUES (55, '2019-02-25 08:51:27', '同意', 24, '玛丽', '审批组长');
INSERT INTO `t_workflow_log` VALUES (56, '2019-02-25 08:54:23', '不同意', 24, 'zz', '一级部门经理');
INSERT INTO `t_workflow_log` VALUES (57, '2019-02-25 09:44:41', '同意', 29, 'lido', '业务组长');
INSERT INTO `t_workflow_log` VALUES (58, '2019-02-25 09:45:25', '同意', 29, ' zhu', '审批组长');
INSERT INTO `t_workflow_log` VALUES (59, '2019-02-25 09:45:54', 'tomgy', 29, 'zz', '一级部门经理');
INSERT INTO `t_workflow_log` VALUES (60, '2019-02-25 09:46:23', '1', 29, ' 朱伟光', '一部门总监');
INSERT INTO `t_workflow_log` VALUES (61, '2019-02-25 09:47:00', '1', 29, '老李', '董事长');
INSERT INTO `t_workflow_log` VALUES (62, '2019-02-25 11:56:51', '1', 32, 'lido', '业务组长');
INSERT INTO `t_workflow_log` VALUES (63, '2019-02-25 11:58:00', '1', 32, ' zhu', '审批组长');
INSERT INTO `t_workflow_log` VALUES (64, '2019-02-25 12:01:37', '1', 32, 'zz', '一级部门经理');
INSERT INTO `t_workflow_log` VALUES (65, '2019-02-25 12:02:05', '1', 32, ' 朱伟光', '一级部门总监');
INSERT INTO `t_workflow_log` VALUES (66, '2019-02-25 12:02:29', '1', 32, '老李', '董事长');
INSERT INTO `t_workflow_log` VALUES (67, '2019-03-14 19:42:19', 'tt', 34, '玛丽', '审批组长');
INSERT INTO `t_workflow_log` VALUES (68, '2019-03-14 19:47:48', 'ty', 34, '李宁', '一级部门经理');
INSERT INTO `t_workflow_log` VALUES (69, '2019-03-14 19:48:46', 'ty', 34, ' 李栋', '一级部门总监');
INSERT INTO `t_workflow_log` VALUES (70, '2019-03-14 19:51:17', 'ty', 35, '上上', '审批组长');
INSERT INTO `t_workflow_log` VALUES (71, '2019-03-14 19:51:38', '', 35, '李宁', '一级部门经理');
INSERT INTO `t_workflow_log` VALUES (72, '2019-03-14 19:51:57', '', 35, ' 李栋', '一级部门总监');
INSERT INTO `t_workflow_log` VALUES (73, '2019-03-14 20:02:45', 'ty', 35, ' 李栋', '一级部门总监');
INSERT INTO `t_workflow_log` VALUES (74, '2019-03-14 20:14:53', '11', 35, ' 李栋', '一级部门总监');
INSERT INTO `t_workflow_log` VALUES (75, '2019-03-14 20:33:37', 'ty', 36, '上上', '审批组长');
INSERT INTO `t_workflow_log` VALUES (76, '2019-03-14 20:33:51', '图', 36, '李宁', '一级部门经理');
INSERT INTO `t_workflow_log` VALUES (77, '2019-03-14 20:34:04', 'yy', 36, ' 李栋', '一级部门总监');
INSERT INTO `t_workflow_log` VALUES (78, '2019-03-15 09:39:11', 'ty', 37, '上上', '审批组长');
INSERT INTO `t_workflow_log` VALUES (79, '2019-03-15 09:39:41', 'ty', 37, '李宁', '一级部门经理');
INSERT INTO `t_workflow_log` VALUES (80, '2019-03-15 09:40:10', 'ty', 37, ' 李栋', '一级部门总监');

-- ----------------------------
-- Table structure for t_workflow_node
-- ----------------------------
DROP TABLE IF EXISTS `t_workflow_node`;
CREATE TABLE `t_workflow_node`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `node` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `wid` int(11) NULL DEFAULT NULL,
  `nownode` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 22 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_workflow_node
-- ----------------------------
INSERT INTO `t_workflow_node` VALUES (1, '1,2,3,4,5', 1, '');
INSERT INTO `t_workflow_node` VALUES (2, '2,3,4', 14, '');
INSERT INTO `t_workflow_node` VALUES (4, '2,3,4', 16, '');
INSERT INTO `t_workflow_node` VALUES (5, '3,4,5', 17, '');
INSERT INTO `t_workflow_node` VALUES (6, '3,4,5', 18, '');
INSERT INTO `t_workflow_node` VALUES (7, '2,3,4', 19, '');
INSERT INTO `t_workflow_node` VALUES (8, '2,3,4', 21, '');
INSERT INTO `t_workflow_node` VALUES (9, '3,4,5', 22, '');
INSERT INTO `t_workflow_node` VALUES (10, '1,2,3,4,5', 23, '');
INSERT INTO `t_workflow_node` VALUES (11, '1,2,3,4,5', 24, '');
INSERT INTO `t_workflow_node` VALUES (13, '1,2,3,4,5', 29, '');
INSERT INTO `t_workflow_node` VALUES (14, '1,2,3,4,5', 30, '1');
INSERT INTO `t_workflow_node` VALUES (16, '1,2,3,4,5', 32, '');
INSERT INTO `t_workflow_node` VALUES (17, '1,2,3,4,5', 33, '1');
INSERT INTO `t_workflow_node` VALUES (18, '2,3,4', 34, '');
INSERT INTO `t_workflow_node` VALUES (19, '2,3,4', 35, '');
INSERT INTO `t_workflow_node` VALUES (20, '2,3,4', 36, '');
INSERT INTO `t_workflow_node` VALUES (21, '2,3,4', 37, '');

SET FOREIGN_KEY_CHECKS = 1;
