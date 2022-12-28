/*
 Navicat Premium Data Transfer

 Source Server         : blog-db
 Source Server Type    : MySQL
 Source Server Version : 50736
 Source Host           : 192.168.216.111:3306
 Source Schema         : hotel2

 Target Server Type    : MySQL
 Target Server Version : 50736
 File Encoding         : 65001

 Date: 14/07/2022 08:59:34
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for guest
-- ----------------------------
DROP TABLE IF EXISTS `guest`;
CREATE TABLE `guest`  (
                          `guest_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '顾客ID',
                          `guest_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '顾客姓名',
                          `guest_gander` char(2) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '顾客性别',
                          `guest_idcard` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '顾客身份证号码',
                          `guest_phone_number` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '顾客手机号码',
                          `guest_del` int(1) NULL DEFAULT 0 COMMENT '逻辑删除',
                          PRIMARY KEY (`guest_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 26 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of guest
-- ----------------------------
INSERT INTO `guest` VALUES (1, '周迹', '女', '100000000000000001', '12345678910', 0);
INSERT INTO `guest` VALUES (2, '闫凯飞', '女', '100000000000000002', '12345678910', 0);
INSERT INTO `guest` VALUES (3, '章舟', '女', '100000000000000004', '12345678910', 1);
INSERT INTO `guest` VALUES (4, '赵敏杰', '男', '100000000000000005', '12345678910', 1);
INSERT INTO `guest` VALUES (5, '刘一❀', '女', '100000000000000006', '12345678910', 0);
INSERT INTO `guest` VALUES (6, '张顺', '男', '100000000000000007', '12345678910', 0);
INSERT INTO `guest` VALUES (7, '小闫', '男', '100000000000000008', '12345678910', 1);
INSERT INTO `guest` VALUES (8, '张三', '女', '100000000000000011', '12345678910', 0);
INSERT INTO `guest` VALUES (12, '王五', '男', '100000000000000012', '12345678910', 0);
INSERT INTO `guest` VALUES (13, '赵六', '女', '100000000000000013', '12345678910', 0);
INSERT INTO `guest` VALUES (14, '大迹', '女', '100000000000000014', '12345678910', 0);
INSERT INTO `guest` VALUES (15, '小敏杰', '男', '100000000000000015', '12345678910', 0);
INSERT INTO `guest` VALUES (16, '大闫', '女', '100000000000000016', '12345678910', 0);
INSERT INTO `guest` VALUES (17, '大闫', '男', '1000000000000000015', '12345678910', 0);
INSERT INTO `guest` VALUES (18, '赵敏杰', '男', '1000000000000000016', '12345678910', 0);
INSERT INTO `guest` VALUES (19, '周迹', '女', '1000000000000000017', '12345678910', 0);
INSERT INTO `guest` VALUES (22, '罗达', '男', '100000000000000018', '12345678910', 0);
INSERT INTO `guest` VALUES (23, '寻悟空', '女', '100000000000000019', '12345678910', 0);
INSERT INTO `guest` VALUES (25, '猪八戒', '男', '100000000000000020', '12345678910', 0);

-- ----------------------------
-- Table structure for record
-- ----------------------------
DROP TABLE IF EXISTS `record`;
CREATE TABLE `record`  (
                           `record_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '入住记录ID',
                           `room_id` int(11) NULL DEFAULT NULL COMMENT '房间ID',
                           `enter_time` datetime(6) NULL DEFAULT NULL COMMENT '入住时间',
                           `exit_time` datetime(6) NULL DEFAULT NULL COMMENT '离开时间',
                           `booking_time` datetime(6) NULL DEFAULT NULL COMMENT '预定时间',
                           `booking_duration` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '预计居住时长',
                           `cost` double(10, 2) NULL DEFAULT NULL COMMENT '消费金额',
                           `record_del` int(11) UNSIGNED NULL DEFAULT 0 COMMENT '逻辑删除',
                           PRIMARY KEY (`record_id`) USING BTREE,
                           INDEX `room_id`(`room_id`) USING BTREE,
                           CONSTRAINT `record_ibfk_1` FOREIGN KEY (`room_id`) REFERENCES `room` (`room_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '入住记录表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of record
-- ----------------------------
INSERT INTO `record` VALUES (1, 3, '2022-07-08 13:36:28.000000', '2022-07-11 13:36:45.000000', '2022-07-05 13:37:02.000000', '7天', 1114.00, 1);
INSERT INTO `record` VALUES (2, 5, '2022-07-07 13:37:31.000000', '2022-07-11 13:37:36.000000', '2022-07-06 13:37:41.000000', '6天，4小时', 558.00, 0);
INSERT INTO `record` VALUES (5, 3, '2022-07-08 13:36:28.000000', '2022-07-11 13:36:45.000000', '2022-07-05 13:37:02.000000', '5天, 8小时', 1114.00, 0);

-- ----------------------------
-- Table structure for record_guest
-- ----------------------------
DROP TABLE IF EXISTS `record_guest`;
CREATE TABLE `record_guest`  (
                                 `record_guest_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
                                 `record_id` int(11) NULL DEFAULT NULL COMMENT '入住记录ID',
                                 `guest_id` int(11) NULL DEFAULT NULL COMMENT '顾客ID',
                                 PRIMARY KEY (`record_guest_id`) USING BTREE,
                                 INDEX `record_id`(`record_id`) USING BTREE,
                                 INDEX `guest_id`(`guest_id`) USING BTREE,
                                 CONSTRAINT `record_guest_ibfk_1` FOREIGN KEY (`record_id`) REFERENCES `record` (`record_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
                                 CONSTRAINT `record_guest_ibfk_2` FOREIGN KEY (`guest_id`) REFERENCES `guest` (`guest_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '入住记录-顾客' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of record_guest
-- ----------------------------
INSERT INTO `record_guest` VALUES (1, 1, 5);
INSERT INTO `record_guest` VALUES (2, 1, 6);
INSERT INTO `record_guest` VALUES (3, 2, 13);
INSERT INTO `record_guest` VALUES (6, 5, 6);
INSERT INTO `record_guest` VALUES (7, 5, 25);

-- ----------------------------
-- Table structure for room
-- ----------------------------
DROP TABLE IF EXISTS `room`;
CREATE TABLE `room`  (
                         `room_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '房间ID',
                         `room_no` varchar(4) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '房间号',
                         `room_type_id` int(11) NULL DEFAULT NULL COMMENT '房间类型ID',
                         `room_picture` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '房间图片URL',
                         `room_status` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '空房' COMMENT '房间状态，默认为“空房”',
                         `room_del` int(255) NULL DEFAULT 0 COMMENT '是否已删除，默认为0，0为没删除',
                         PRIMARY KEY (`room_id`) USING BTREE,
                         INDEX `room_type_id`(`room_type_id`) USING BTREE,
                         CONSTRAINT `room_ibfk_1` FOREIGN KEY (`room_type_id`) REFERENCES `room_type` (`room_type_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 19 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of room
-- ----------------------------
INSERT INTO `room` VALUES (1, '201', 2, NULL, '已入住', 1);
INSERT INTO `room` VALUES (2, '202', 4, NULL, '空房', 1);
INSERT INTO `room` VALUES (3, '203', 4, NULL, '未打扫', 0);
INSERT INTO `room` VALUES (4, '204', 3, NULL, '未打扫', 0);
INSERT INTO `room` VALUES (5, '205', 2, NULL, '已入住', 0);
INSERT INTO `room` VALUES (6, '206', 7, NULL, '空房', 0);
INSERT INTO `room` VALUES (7, '207', 2, NULL, '已入住', 0);
INSERT INTO `room` VALUES (8, '208', 3, NULL, '已入住', 0);
INSERT INTO `room` VALUES (9, '209', 2, NULL, '空房', 0);
INSERT INTO `room` VALUES (10, '210', 3, NULL, '空房', 0);
INSERT INTO `room` VALUES (11, '301', 4, NULL, '已入住', 0);
INSERT INTO `room` VALUES (12, '302', 6, NULL, '空房', 0);
INSERT INTO `room` VALUES (13, '303', 6, NULL, '空房', 0);
INSERT INTO `room` VALUES (14, '304', 6, NULL, '空房', 0);
INSERT INTO `room` VALUES (15, '305', 8, NULL, '空房', 0);
INSERT INTO `room` VALUES (16, '306', 5, NULL, '空房', 0);
INSERT INTO `room` VALUES (17, '307', 5, NULL, '空房', 0);
INSERT INTO `room` VALUES (18, '308', 5, NULL, '空房', 1);

-- ----------------------------
-- Table structure for room_type
-- ----------------------------
DROP TABLE IF EXISTS `room_type`;
CREATE TABLE `room_type`  (
                              `room_type_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '房间类型ID',
                              `room_type_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '房间类型名字',
                              `room_type_description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '房间类型描述',
                              `day_price` double(10, 2) NULL DEFAULT NULL COMMENT '一天的价格',
                              `hour_price` double(10, 2) NULL DEFAULT NULL COMMENT '钟点房的价格',
                              `room_type_del` int(255) NULL DEFAULT 0 COMMENT '是否删除，默认为0，0为没有删除',
                              PRIMARY KEY (`room_type_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 15 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of room_type
-- ----------------------------
INSERT INTO `room_type` VALUES (1, '待定', NULL, 0.00, 0.00, 1);
INSERT INTO `room_type` VALUES (2, '普通单人间', 'wwasa', 95.00, 65.00, 0);
INSERT INTO `room_type` VALUES (3, '豪华大床房', NULL, 110.00, 75.00, 1);
INSERT INTO `room_type` VALUES (4, '普通双人间', NULL, 200.00, 140.00, 1);
INSERT INTO `room_type` VALUES (5, '豪华套间', '豪华，高级', 499.00, 399.00, 1);
INSERT INTO `room_type` VALUES (6, '商务间', '开会', 340.00, 200.00, 0);
INSERT INTO `room_type` VALUES (7, '行政间', NULL, 499.00, 399.00, 0);
INSERT INTO `room_type` VALUES (8, '豪华婚房', '舒适，温馨，大气，浪漫', 699.00, 699.00, 0);
INSERT INTO `room_type` VALUES (9, '高配双人房', '', 289.00, 189.00, 0);
INSERT INTO `room_type` VALUES (10, '浪漫情侣房', 'romantic spouse home', 1314.00, 520.00, 0);
INSERT INTO `room_type` VALUES (12, '总统套房', '高级，舒适', 1299.00, 799.00, 1);
INSERT INTO `room_type` VALUES (13, '长春大学房', '长春大学专利', 499.00, 399.00, 1);
INSERT INTO `room_type` VALUES (14, '子洲', '啦啦啦啦', 299.00, 48.00, 0);

-- ----------------------------
-- Table structure for system_info
-- ----------------------------
DROP TABLE IF EXISTS `system_info`;
CREATE TABLE `system_info`  (
                                `id` int(1) NOT NULL,
                                `hotel_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '酒店名称',
                                `system_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '系统名称',
                                `welcome_words` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '系统欢迎词',
                                PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of system_info
-- ----------------------------
INSERT INTO `system_info` VALUES (1, '温情小筑', 'HRMS 酒店管理系统', '梦见四季，四季有家，欢迎入住，温情小筑');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
                         `user_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户ID，可以自增长',
                         `username` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名',
                         `password` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码',
                         `user_status` int(1) NULL DEFAULT 0 COMMENT '状态，默认为0，0为正常',
                         `user_del` int(1) NULL DEFAULT 0 COMMENT '是否删除，默认为0，0为没有删除',
                         PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'admin', '123123', 0, 0);
INSERT INTO `user` VALUES (2, 'zhao', '123123', 1, 0);

-- ----------------------------
-- Table structure for vip
-- ----------------------------
DROP TABLE IF EXISTS `vip`;
CREATE TABLE `vip`  (
                        `vip_id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'vipID',
                        `guest_id` int(11) NULL DEFAULT NULL COMMENT '顾客ID',
                        `vip_card` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'vip卡号',
                        `vip_integral` int(255) UNSIGNED NULL DEFAULT 0 COMMENT '积分',
                        `vip_del` int(1) NULL DEFAULT NULL COMMENT '逻辑删除',
                        PRIMARY KEY (`vip_id`) USING BTREE,
                        INDEX `guest_id`(`guest_id`) USING BTREE,
                        CONSTRAINT `vip_ibfk_1` FOREIGN KEY (`guest_id`) REFERENCES `guest` (`guest_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of vip
-- ----------------------------
INSERT INTO `vip` VALUES (1, 1, '164032105701', 20, 1);
INSERT INTO `vip` VALUES (2, 2, '164032162602', 200, 1);
INSERT INTO `vip` VALUES (3, 8, '164032171508', 0, 1);
INSERT INTO `vip` VALUES (5, 12, '164033842312', 0, 0);
INSERT INTO `vip` VALUES (6, 7, '164033988307', 0, 0);
INSERT INTO `vip` VALUES (7, 1, '165652297701', 0, 0);
INSERT INTO `vip` VALUES (8, 8, '12345678910', 20, 1);
INSERT INTO `vip` VALUES (9, 2, '12345678910', 0, 0);
INSERT INTO `vip` VALUES (10, 23, '12345678910', 0, 0);

SET FOREIGN_KEY_CHECKS = 1;
