/*
 Navicat Premium Data Transfer

 Source Server         : MySQL
 Source Server Type    : MySQL
 Source Server Version : 50540
 Source Host           : localhost:3306
 Source Schema         : sports_meeting

 Target Server Type    : MySQL
 Target Server Version : 50540
 File Encoding         : 65001

 Date: 17/03/2021 20:56:50
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin`  (
  `admin_id` int(8) NOT NULL AUTO_INCREMENT,
  `admin_name` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `admin_gender` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `admin_age` int(3) NULL DEFAULT NULL,
  `admin_phone` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `admin_password` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`admin_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10003 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES (10001, '卢琦', 'M', 22, '15536365259', '123456');
INSERT INTO `admin` VALUES (10002, '李四', 'F', 38, '13200099927', '123456');

-- ----------------------------
-- Table structure for ceremony_close
-- ----------------------------
DROP TABLE IF EXISTS `ceremony_close`;
CREATE TABLE `ceremony_close`  (
  `ceremony_id` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `ceremony_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `ceremony_start_time` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `ceremony_end_time` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `ceremony_place` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `ceremony_host` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`ceremony_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of ceremony_close
-- ----------------------------

-- ----------------------------
-- Table structure for ceremony_open
-- ----------------------------
DROP TABLE IF EXISTS `ceremony_open`;
CREATE TABLE `ceremony_open`  (
  `ceremony_id` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `ceremony_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `ceremony_start_time` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `ceremony_end_time` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `ceremony_place` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `ceremony_host` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`ceremony_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of ceremony_open
-- ----------------------------
INSERT INTO `ceremony_open` VALUES ('kms_001', '12', '2020-05-01 08:00:00', '2020-05-01 08:00:00', '1313', '1313');

-- ----------------------------
-- Table structure for entry_form
-- ----------------------------
DROP TABLE IF EXISTS `entry_form`;
CREATE TABLE `entry_form`  (
  `stu_id` int(8) NOT NULL DEFAULT 0,
  `sports_id_entry` int(8) NOT NULL DEFAULT 0,
  PRIMARY KEY (`stu_id`, `sports_id_entry`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of entry_form
-- ----------------------------
INSERT INTO `entry_form` VALUES (1001, 30003);
INSERT INTO `entry_form` VALUES (1001, 30005);
INSERT INTO `entry_form` VALUES (1002, 30002);
INSERT INTO `entry_form` VALUES (1002, 30007);
INSERT INTO `entry_form` VALUES (1003, 30001);
INSERT INTO `entry_form` VALUES (1003, 30006);
INSERT INTO `entry_form` VALUES (1004, 30008);
INSERT INTO `entry_form` VALUES (1004, 30009);
INSERT INTO `entry_form` VALUES (1005, 30002);
INSERT INTO `entry_form` VALUES (1005, 30012);
INSERT INTO `entry_form` VALUES (1006, 30006);
INSERT INTO `entry_form` VALUES (1006, 30010);
INSERT INTO `entry_form` VALUES (1007, 30011);
INSERT INTO `entry_form` VALUES (1007, 30012);
INSERT INTO `entry_form` VALUES (1008, 30002);
INSERT INTO `entry_form` VALUES (1008, 30007);
INSERT INTO `entry_form` VALUES (1009, 30001);
INSERT INTO `entry_form` VALUES (1009, 30005);
INSERT INTO `entry_form` VALUES (1010, 30003);
INSERT INTO `entry_form` VALUES (1010, 30008);
INSERT INTO `entry_form` VALUES (1011, 30002);
INSERT INTO `entry_form` VALUES (1011, 30007);
INSERT INTO `entry_form` VALUES (1012, 30005);
INSERT INTO `entry_form` VALUES (1012, 30008);
INSERT INTO `entry_form` VALUES (1013, 30004);
INSERT INTO `entry_form` VALUES (1013, 30011);
INSERT INTO `entry_form` VALUES (1014, 30001);
INSERT INTO `entry_form` VALUES (1014, 30009);
INSERT INTO `entry_form` VALUES (1015, 30004);
INSERT INTO `entry_form` VALUES (1015, 30007);
INSERT INTO `entry_form` VALUES (1016, 30002);
INSERT INTO `entry_form` VALUES (1016, 30004);
INSERT INTO `entry_form` VALUES (1020, 30001);
INSERT INTO `entry_form` VALUES (1020, 30006);
INSERT INTO `entry_form` VALUES (1021, 30002);
INSERT INTO `entry_form` VALUES (1021, 30012);
INSERT INTO `entry_form` VALUES (1023, 30003);
INSERT INTO `entry_form` VALUES (1023, 30005);
INSERT INTO `entry_form` VALUES (1024, 30011);
INSERT INTO `entry_form` VALUES (1024, 30012);
INSERT INTO `entry_form` VALUES (1026, 30003);
INSERT INTO `entry_form` VALUES (1026, 30010);
INSERT INTO `entry_form` VALUES (1027, 30005);
INSERT INTO `entry_form` VALUES (1027, 30009);
INSERT INTO `entry_form` VALUES (1028, 30002);
INSERT INTO `entry_form` VALUES (1028, 30012);
INSERT INTO `entry_form` VALUES (1029, 30003);
INSERT INTO `entry_form` VALUES (1029, 30009);
INSERT INTO `entry_form` VALUES (1030, 30004);
INSERT INTO `entry_form` VALUES (1030, 30011);
INSERT INTO `entry_form` VALUES (1031, 30001);
INSERT INTO `entry_form` VALUES (1031, 30006);
INSERT INTO `entry_form` VALUES (1032, 30011);
INSERT INTO `entry_form` VALUES (1032, 30012);
INSERT INTO `entry_form` VALUES (1033, 30001);
INSERT INTO `entry_form` VALUES (1033, 30010);
INSERT INTO `entry_form` VALUES (1036, 30004);
INSERT INTO `entry_form` VALUES (1036, 30007);
INSERT INTO `entry_form` VALUES (1037, 30005);
INSERT INTO `entry_form` VALUES (1037, 30006);
INSERT INTO `entry_form` VALUES (1038, 30002);
INSERT INTO `entry_form` VALUES (1038, 30007);
INSERT INTO `entry_form` VALUES (1039, 30001);
INSERT INTO `entry_form` VALUES (1039, 30010);
INSERT INTO `entry_form` VALUES (1040, 30003);
INSERT INTO `entry_form` VALUES (1040, 30006);
INSERT INTO `entry_form` VALUES (1041, 30006);
INSERT INTO `entry_form` VALUES (1041, 30008);
INSERT INTO `entry_form` VALUES (1042, 30002);
INSERT INTO `entry_form` VALUES (1042, 30011);
INSERT INTO `entry_form` VALUES (1043, 30004);
INSERT INTO `entry_form` VALUES (1043, 30007);
INSERT INTO `entry_form` VALUES (1044, 30003);
INSERT INTO `entry_form` VALUES (1044, 30009);
INSERT INTO `entry_form` VALUES (1045, 30004);
INSERT INTO `entry_form` VALUES (1045, 30011);
INSERT INTO `entry_form` VALUES (1046, 30001);
INSERT INTO `entry_form` VALUES (1046, 30008);
INSERT INTO `entry_form` VALUES (1047, 30007);
INSERT INTO `entry_form` VALUES (1047, 30011);
INSERT INTO `entry_form` VALUES (1048, 30006);
INSERT INTO `entry_form` VALUES (1048, 30010);
INSERT INTO `entry_form` VALUES (1049, 30004);
INSERT INTO `entry_form` VALUES (1049, 30012);
INSERT INTO `entry_form` VALUES (1050, 30003);
INSERT INTO `entry_form` VALUES (1050, 30005);
INSERT INTO `entry_form` VALUES (1051, 30004);
INSERT INTO `entry_form` VALUES (1051, 30012);
INSERT INTO `entry_form` VALUES (1052, 30006);
INSERT INTO `entry_form` VALUES (1052, 30008);
INSERT INTO `entry_form` VALUES (1053, 30009);
INSERT INTO `entry_form` VALUES (1053, 30010);
INSERT INTO `entry_form` VALUES (1054, 30007);
INSERT INTO `entry_form` VALUES (1054, 30011);
INSERT INTO `entry_form` VALUES (1055, 30002);
INSERT INTO `entry_form` VALUES (1055, 30007);
INSERT INTO `entry_form` VALUES (1056, 30005);
INSERT INTO `entry_form` VALUES (1056, 30010);
INSERT INTO `entry_form` VALUES (1057, 30011);
INSERT INTO `entry_form` VALUES (1057, 30012);
INSERT INTO `entry_form` VALUES (1058, 30001);
INSERT INTO `entry_form` VALUES (1058, 30006);
INSERT INTO `entry_form` VALUES (1059, 30001);
INSERT INTO `entry_form` VALUES (1059, 30010);
INSERT INTO `entry_form` VALUES (1060, 30004);
INSERT INTO `entry_form` VALUES (1060, 30007);
INSERT INTO `entry_form` VALUES (1061, 30001);
INSERT INTO `entry_form` VALUES (1061, 30008);
INSERT INTO `entry_form` VALUES (1062, 30004);
INSERT INTO `entry_form` VALUES (1062, 30007);
INSERT INTO `entry_form` VALUES (1063, 30002);
INSERT INTO `entry_form` VALUES (1063, 30011);
INSERT INTO `entry_form` VALUES (1064, 30003);
INSERT INTO `entry_form` VALUES (1064, 30009);
INSERT INTO `entry_form` VALUES (1065, 30006);
INSERT INTO `entry_form` VALUES (1065, 30010);
INSERT INTO `entry_form` VALUES (1066, 30001);
INSERT INTO `entry_form` VALUES (1066, 30008);
INSERT INTO `entry_form` VALUES (1067, 30002);
INSERT INTO `entry_form` VALUES (1067, 30011);
INSERT INTO `entry_form` VALUES (1068, 30006);
INSERT INTO `entry_form` VALUES (1068, 30010);
INSERT INTO `entry_form` VALUES (1069, 30004);
INSERT INTO `entry_form` VALUES (1069, 30007);
INSERT INTO `entry_form` VALUES (1070, 30006);
INSERT INTO `entry_form` VALUES (1070, 30008);
INSERT INTO `entry_form` VALUES (1071, 30001);
INSERT INTO `entry_form` VALUES (1071, 30005);
INSERT INTO `entry_form` VALUES (1072, 30002);
INSERT INTO `entry_form` VALUES (1072, 30007);
INSERT INTO `entry_form` VALUES (1073, 30006);
INSERT INTO `entry_form` VALUES (1073, 30008);
INSERT INTO `entry_form` VALUES (1074, 30008);
INSERT INTO `entry_form` VALUES (1074, 30009);
INSERT INTO `entry_form` VALUES (1075, 30004);
INSERT INTO `entry_form` VALUES (1075, 30007);
INSERT INTO `entry_form` VALUES (1076, 30005);
INSERT INTO `entry_form` VALUES (1076, 30010);
INSERT INTO `entry_form` VALUES (1077, 30011);
INSERT INTO `entry_form` VALUES (1077, 30012);
INSERT INTO `entry_form` VALUES (1078, 30004);
INSERT INTO `entry_form` VALUES (1078, 30011);
INSERT INTO `entry_form` VALUES (1079, 30005);
INSERT INTO `entry_form` VALUES (1079, 30009);
INSERT INTO `entry_form` VALUES (1080, 30004);
INSERT INTO `entry_form` VALUES (1080, 30012);
INSERT INTO `entry_form` VALUES (1081, 30005);
INSERT INTO `entry_form` VALUES (1081, 30008);
INSERT INTO `entry_form` VALUES (1082, 30002);
INSERT INTO `entry_form` VALUES (1082, 30011);
INSERT INTO `entry_form` VALUES (1083, 30009);
INSERT INTO `entry_form` VALUES (1083, 30010);
INSERT INTO `entry_form` VALUES (1084, 30002);
INSERT INTO `entry_form` VALUES (1084, 30007);
INSERT INTO `entry_form` VALUES (1085, 30003);
INSERT INTO `entry_form` VALUES (1085, 30006);
INSERT INTO `entry_form` VALUES (1086, 30004);
INSERT INTO `entry_form` VALUES (1086, 30007);
INSERT INTO `entry_form` VALUES (1087, 30002);
INSERT INTO `entry_form` VALUES (1087, 30011);
INSERT INTO `entry_form` VALUES (1088, 30001);
INSERT INTO `entry_form` VALUES (1088, 30006);
INSERT INTO `entry_form` VALUES (1089, 30004);
INSERT INTO `entry_form` VALUES (1089, 30012);
INSERT INTO `entry_form` VALUES (1090, 30003);
INSERT INTO `entry_form` VALUES (1090, 30006);
INSERT INTO `entry_form` VALUES (1091, 30007);
INSERT INTO `entry_form` VALUES (1091, 30011);
INSERT INTO `entry_form` VALUES (1092, 30002);
INSERT INTO `entry_form` VALUES (1092, 30012);
INSERT INTO `entry_form` VALUES (1093, 30006);
INSERT INTO `entry_form` VALUES (1093, 30008);
INSERT INTO `entry_form` VALUES (1094, 30001);
INSERT INTO `entry_form` VALUES (1094, 30008);
INSERT INTO `entry_form` VALUES (1095, 30002);
INSERT INTO `entry_form` VALUES (1095, 30011);
INSERT INTO `entry_form` VALUES (1096, 30005);
INSERT INTO `entry_form` VALUES (1096, 30008);
INSERT INTO `entry_form` VALUES (1097, 30002);
INSERT INTO `entry_form` VALUES (1097, 30012);
INSERT INTO `entry_form` VALUES (1098, 30003);
INSERT INTO `entry_form` VALUES (1098, 30009);
INSERT INTO `entry_form` VALUES (1099, 30003);
INSERT INTO `entry_form` VALUES (1099, 30006);
INSERT INTO `entry_form` VALUES (1100, 30004);
INSERT INTO `entry_form` VALUES (1100, 30011);
INSERT INTO `entry_form` VALUES (1101, 30001);
INSERT INTO `entry_form` VALUES (1101, 30010);
INSERT INTO `entry_form` VALUES (1102, 30002);
INSERT INTO `entry_form` VALUES (1102, 30004);
INSERT INTO `entry_form` VALUES (1103, 30005);
INSERT INTO `entry_form` VALUES (1103, 30006);
INSERT INTO `entry_form` VALUES (1104, 30002);
INSERT INTO `entry_form` VALUES (1104, 30012);
INSERT INTO `entry_form` VALUES (1105, 30007);
INSERT INTO `entry_form` VALUES (1105, 30011);
INSERT INTO `entry_form` VALUES (1106, 30005);
INSERT INTO `entry_form` VALUES (1106, 30006);
INSERT INTO `entry_form` VALUES (1107, 30004);
INSERT INTO `entry_form` VALUES (1107, 30011);
INSERT INTO `entry_form` VALUES (1108, 30009);
INSERT INTO `entry_form` VALUES (1108, 30010);
INSERT INTO `entry_form` VALUES (1109, 30002);
INSERT INTO `entry_form` VALUES (1109, 30012);
INSERT INTO `entry_form` VALUES (1110, 30003);
INSERT INTO `entry_form` VALUES (1110, 30006);

-- ----------------------------
-- Table structure for referee
-- ----------------------------
DROP TABLE IF EXISTS `referee`;
CREATE TABLE `referee`  (
  `referee_id` int(8) NOT NULL AUTO_INCREMENT,
  `referee_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `referee_age` int(4) NULL DEFAULT NULL,
  `referee_gender` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `referee_phone` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`referee_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 20005 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of referee
-- ----------------------------
INSERT INTO `referee` VALUES (20001, '刘天成', 25, 'M', '15800000000');
INSERT INTO `referee` VALUES (20002, '李成龙', 28, 'M', '15800000000');
INSERT INTO `referee` VALUES (20003, '鲁立', 27, 'M', '15800000000');
INSERT INTO `referee` VALUES (20004, '杨毅权', 26, 'M', '18900000000');

-- ----------------------------
-- Table structure for sports
-- ----------------------------
DROP TABLE IF EXISTS `sports`;
CREATE TABLE `sports`  (
  `sports_id` int(8) NOT NULL AUTO_INCREMENT,
  `sports_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `sports_type` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `sports_number` int(8) NULL DEFAULT NULL,
  `sports_time` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `sports_place` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `sports_status` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `sports_referee` varchar(8) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`sports_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 30013 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sports
-- ----------------------------
INSERT INTO `sports` VALUES (30001, '男子400米', 'M_sports', 16, '14:00', '东操场', '未开始', '刘天成');
INSERT INTO `sports` VALUES (30002, '女子400米', 'F_sports', 22, '15:00', '西操场', '未开始', '李成龙');
INSERT INTO `sports` VALUES (30003, '男子50米', 'M_sports', 14, '2020-05-01 14:00:00', '运动场', '已结束', '鲁立');
INSERT INTO `sports` VALUES (30004, '女子100米', 'F_sports', 20, '2020-05-01 10:20:00', '东操场', '未开始', '刘天成');
INSERT INTO `sports` VALUES (30005, '男子100米', 'M_sports', 15, '2020-05-01 14:00:00', '东操场', '未开始', '刘天成');
INSERT INTO `sports` VALUES (30006, '男子立定跳远', 'M_sports', 22, '2020-05-01 14:00:00', '东足球场', '未开始', '李成龙');
INSERT INTO `sports` VALUES (30007, '女子跳高', 'F_sports', 19, '2020-05-03 14:30:00', '东足球场', '未开始', '鲁立');
INSERT INTO `sports` VALUES (30008, '男子3000米', 'M_sports', 15, '2020-05-01 14:00:00', '西运动场', '未开始', '李成龙');
INSERT INTO `sports` VALUES (30009, '男子1000米', 'M_sports', 12, '2020-05-01 14:00:00', '西运动场', '已结束', '鲁立');
INSERT INTO `sports` VALUES (30010, '男子铅球', 'M_sports', 14, '2020-05-01 14:00:00', '西运动场', '未开始', '鲁立');
INSERT INTO `sports` VALUES (30011, '女子200米', 'F_sports', 21, '2020-05-01 14:00:00', '西操场', '未开始', '杨毅权');
INSERT INTO `sports` VALUES (30012, '女子跳远', 'F_sports', 16, '2020-05-01 14:00:00', '西操场', '未开始', '杨毅权');

-- ----------------------------
-- Table structure for sports_score
-- ----------------------------
DROP TABLE IF EXISTS `sports_score`;
CREATE TABLE `sports_score`  (
  `stu_id` int(8) NOT NULL,
  `sports_id_score` int(8) NOT NULL DEFAULT 0,
  `grade` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `score` int(5) NULL DEFAULT NULL,
  PRIMARY KEY (`stu_id`, `sports_id_score`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sports_score
-- ----------------------------
INSERT INTO `sports_score` VALUES (1001, 30003, '6秒89', 5);
INSERT INTO `sports_score` VALUES (1001, 30005, '13秒75', 2);
INSERT INTO `sports_score` VALUES (1003, 30001, '1分40秒', 7);
INSERT INTO `sports_score` VALUES (1003, 30006, '2.74', 5);
INSERT INTO `sports_score` VALUES (1004, 30009, '3分51', 2);
INSERT INTO `sports_score` VALUES (1005, 30012, '2.5米', 5);
INSERT INTO `sports_score` VALUES (1006, 30010, '10.07米', 1);
INSERT INTO `sports_score` VALUES (1008, 30007, '1.68', 2);
INSERT INTO `sports_score` VALUES (1012, 30008, '7分48', 3);
INSERT INTO `sports_score` VALUES (1013, 30011, '35.98秒', 2);
INSERT INTO `sports_score` VALUES (1014, 30001, '1分42秒', 5);
INSERT INTO `sports_score` VALUES (1015, 30004, '16秒17', 3);
INSERT INTO `sports_score` VALUES (1020, 30001, '1分44秒', 3);
INSERT INTO `sports_score` VALUES (1020, 30006, '2.75', 7);
INSERT INTO `sports_score` VALUES (1023, 30005, '14秒00', 1);
INSERT INTO `sports_score` VALUES (1026, 30003, '7秒12', 2);
INSERT INTO `sports_score` VALUES (1029, 30009, '3分24', 7);
INSERT INTO `sports_score` VALUES (1032, 30012, '2.45米', 2);
INSERT INTO `sports_score` VALUES (1033, 30010, '11.64米', 5);
INSERT INTO `sports_score` VALUES (1036, 30004, '15秒21', 5);
INSERT INTO `sports_score` VALUES (1038, 30002, '2分25秒', 2);
INSERT INTO `sports_score` VALUES (1040, 30003, '6秒25', 7);
INSERT INTO `sports_score` VALUES (1043, 30007, '1.70', 3);
INSERT INTO `sports_score` VALUES (1045, 30011, '34秒', 5);
INSERT INTO `sports_score` VALUES (1046, 30008, '8分12', 2);
INSERT INTO `sports_score` VALUES (1053, 30009, '3分48', 3);
INSERT INTO `sports_score` VALUES (1054, 30007, '1.75', 5);
INSERT INTO `sports_score` VALUES (1056, 30010, '11.50米', 3);
INSERT INTO `sports_score` VALUES (1059, 30001, '1分50秒', 2);
INSERT INTO `sports_score` VALUES (1064, 30003, '7秒54', 1);
INSERT INTO `sports_score` VALUES (1065, 30006, '2.71', 3);
INSERT INTO `sports_score` VALUES (1066, 30008, '8分56', 1);
INSERT INTO `sports_score` VALUES (1067, 30002, '2分20秒', 5);
INSERT INTO `sports_score` VALUES (1067, 30011, '35.57秒', 3);
INSERT INTO `sports_score` VALUES (1075, 30004, '16秒39', 2);
INSERT INTO `sports_score` VALUES (1076, 30005, '12秒14', 7);
INSERT INTO `sports_score` VALUES (1076, 30010, '12米', 7);
INSERT INTO `sports_score` VALUES (1080, 30012, '2.48米', 3);
INSERT INTO `sports_score` VALUES (1081, 30005, '12秒57', 5);
INSERT INTO `sports_score` VALUES (1081, 30008, '7分20', 7);
INSERT INTO `sports_score` VALUES (1083, 30009, '3分35', 5);
INSERT INTO `sports_score` VALUES (1083, 30010, '10.18米', 2);
INSERT INTO `sports_score` VALUES (1092, 30002, '2分24秒', 3);
INSERT INTO `sports_score` VALUES (1094, 30001, '1分51秒', 1);
INSERT INTO `sports_score` VALUES (1094, 30008, '7分25', 5);
INSERT INTO `sports_score` VALUES (1098, 30009, '3分58', 1);
INSERT INTO `sports_score` VALUES (1099, 30006, '2.68', 2);
INSERT INTO `sports_score` VALUES (1106, 30005, '13秒19', 3);
INSERT INTO `sports_score` VALUES (1110, 30003, '7秒02', 3);
INSERT INTO `sports_score` VALUES (1110, 30006, '2.64', 1);

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(12) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `gender` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `school` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `phone` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `email` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1111 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES (1001, '王小1', 'M', '软件学院', '18700000000', 'tom@qq.com', '123456');
INSERT INTO `student` VALUES (1002, '王小2', 'F', '软件学院', '18700000', 'jerry@qq.com', '123456');
INSERT INTO `student` VALUES (1003, '王小3', 'M', '软件学院', '18700000', 'cat@qq.com', '123456');
INSERT INTO `student` VALUES (1004, '王小4', 'M', '软件学院', '18700000', 'cat@qq.com', '123456');
INSERT INTO `student` VALUES (1005, '王小5', 'F', '软件学院', '18700000', 'cat@qq.com', '123456');
INSERT INTO `student` VALUES (1006, '王小6', 'M', '软件学院', '18700000', 'cat@qq.com', '123456');
INSERT INTO `student` VALUES (1007, '王小7', 'F', '软件学院', '18700000', 'cat@qq.com', '123456');
INSERT INTO `student` VALUES (1008, '王小8', 'F', '软件学院', '18700000', 'cat@qq.com', '123456');
INSERT INTO `student` VALUES (1009, '王小9', 'M', '软件学院', '18700000000', 'cat00@qq.com', '123456');
INSERT INTO `student` VALUES (1010, '王小0', 'M', '软件学院', '18700000', 'cat@qq.com', '123456');
INSERT INTO `student` VALUES (1011, '赵五1', 'F', '信计学院', '18700000', 'cat@qq.com', '123456');
INSERT INTO `student` VALUES (1012, '赵五2', 'M', '信计学院', '18700000', 'cat@qq.com', '123456');
INSERT INTO `student` VALUES (1013, '赵五3', 'F', '信计学院', '18700000', 'cat@qq.com', '123456');
INSERT INTO `student` VALUES (1014, '赵五4', 'M', '信计学院', '18700000', 'cat@qq.com', '123456');
INSERT INTO `student` VALUES (1015, '赵五5', 'F', '信计学院', '18700000', 'cat@qq.com', '123456');
INSERT INTO `student` VALUES (1016, '赵五6', 'F', '信计学院', '15800000', 'tim@qq.com', '123456');
INSERT INTO `student` VALUES (1020, '赵五7', 'M', '信计学院', '15800000', '123@qq.com', '123456');
INSERT INTO `student` VALUES (1021, '赵五8', 'F', '信计学院', '15800000', '123@qq.com', '123456');
INSERT INTO `student` VALUES (1023, '赵五9', 'M', '信计学院', '15800000', '11@qq.com', '123456');
INSERT INTO `student` VALUES (1024, '赵五0', 'F', '信计学院', '15800000', '5949@qq.com', '123456');
INSERT INTO `student` VALUES (1026, '赵五11', 'M', '信计学院', '15800000', 'qqq@qq.com', '123456');
INSERT INTO `student` VALUES (1027, '李明1', 'M', '经管学院', '13800000', '22@qq.com', '123456');
INSERT INTO `student` VALUES (1028, '李明2', 'F', '经管学院', '13800000', '11@qq.com', '123456');
INSERT INTO `student` VALUES (1029, '李明3', 'M', '经管学院', '13800000', '185@qq.com', '123456');
INSERT INTO `student` VALUES (1030, '李明4', 'F', '经管学院', '13800000', '1891@qq.com', '123456');
INSERT INTO `student` VALUES (1031, '李明5', 'M', '经管学院', '13800000', '12561@qq.com', '123456');
INSERT INTO `student` VALUES (1032, '李明6', 'F', '经管学院', '13800000', '16@qq.com', '123456');
INSERT INTO `student` VALUES (1033, '李明7', 'M', '经管学院', '13800000', '11@qq.com', '123456');
INSERT INTO `student` VALUES (1036, '李明8', 'F', '经管学院', '13800000', '18941@qq.com', '123456');
INSERT INTO `student` VALUES (1037, '李明9', 'M', '经管学院', '13800000', '1313@qq.com1', '123456');
INSERT INTO `student` VALUES (1038, '李明0', 'F', '经管学院', '13800000', '41564@qq.com', '123456');
INSERT INTO `student` VALUES (1039, '李明11', 'M', '经管学院', '13800000', '464@qq.com', '123456');
INSERT INTO `student` VALUES (1040, '钱唐江1', 'M', '外国语学院', '13200000000', 'qtj@qq.com', '123456');
INSERT INTO `student` VALUES (1041, '钱唐江2', 'M', '外国语学院', '13200000000', 'qtj@qq.com', '123456');
INSERT INTO `student` VALUES (1042, '钱唐江3', 'F', '外国语学院', '13200000000', 'qtj@qq.com', '123456');
INSERT INTO `student` VALUES (1043, '钱唐江4', 'F', '外国语学院', '13200000000', 'qtj@qq.com', '123456');
INSERT INTO `student` VALUES (1044, '钱唐江5', 'M', '外国语学院', '13200000000', 'qtj@qq.com', '123456');
INSERT INTO `student` VALUES (1045, '钱唐江6', 'F', '外国语学院', '13200000000', 'qtj@qq.com', '123456');
INSERT INTO `student` VALUES (1046, '钱唐江7', 'M', '外国语学院', '13200000000', 'qtj@qq.com', '123456');
INSERT INTO `student` VALUES (1047, '钱唐江8', 'F', '外国语学院', '13200000000', 'qtj@qq.com', '123456');
INSERT INTO `student` VALUES (1048, '钱唐江9', 'M', '外国语学院', '13200000000', 'qtj@qq.com', '123456');
INSERT INTO `student` VALUES (1049, '钱唐江0', 'F', '外国语学院', '13200000000', 'qtj@qq.com', '123456');
INSERT INTO `student` VALUES (1050, '钱唐江11', 'M', '外国语学院', '13200000000', 'qtj@qq.com', '123456');
INSERT INTO `student` VALUES (1051, '刘层1', 'F', '体育学院', '13200000000', 'lc@qq.com', '123456');
INSERT INTO `student` VALUES (1052, '刘层2', 'M', '体育学院', '13200000000', 'lc@qq.com', '123456');
INSERT INTO `student` VALUES (1053, '刘层3', 'M', '体育学院', '13200000000', 'lc@qq.com', '123456');
INSERT INTO `student` VALUES (1054, '刘层4', 'F', '体育学院', '13200000000', 'lc@qq.com', '123456');
INSERT INTO `student` VALUES (1055, '刘层5', 'F', '体育学院', '13200000000', 'lc@qq.com', '123456');
INSERT INTO `student` VALUES (1056, '刘层6', 'M', '体育学院', '13200000000', 'lc@qq.com', '123456');
INSERT INTO `student` VALUES (1057, '刘层7', 'F', '体育学院', '13200000000', 'lc@qq.com', '123456');
INSERT INTO `student` VALUES (1058, '刘层8', 'M', '体育学院', '13200000000', 'lc@qq.com', '123456');
INSERT INTO `student` VALUES (1059, '刘层9', 'M', '体育学院', '13200000000', 'lc@qq.com', '123456');
INSERT INTO `student` VALUES (1060, '刘层0', 'F', '体育学院', '13200000000', 'lc@qq.com', '123456');
INSERT INTO `student` VALUES (1061, '毛彬1', 'M', '轻纺学院', '13200000000', 'mb@qq.com', '123456');
INSERT INTO `student` VALUES (1062, '毛彬2', 'F', '轻纺学院', '13200000000', 'mb@qq.com', '123456');
INSERT INTO `student` VALUES (1063, '毛彬3', 'F', '轻纺学院', '13200000000', 'mb@qq.com', '123456');
INSERT INTO `student` VALUES (1064, '毛彬4', 'M', '轻纺学院', '13200000000', 'mb@qq.com', '123456');
INSERT INTO `student` VALUES (1065, '毛彬5', 'M', '轻纺学院', '13200000000', 'mb@qq.com', '123456');
INSERT INTO `student` VALUES (1066, '毛彬6', 'M', '轻纺学院', '13200000000', 'mb@qq.com', '123456');
INSERT INTO `student` VALUES (1067, '毛彬7', 'F', '轻纺学院', '13200000000', 'mb@qq.com', '123456');
INSERT INTO `student` VALUES (1068, '毛彬8', 'M', '轻纺学院', '13200000000', 'mb@qq.com', '123456');
INSERT INTO `student` VALUES (1069, '毛彬9', 'F', '轻纺学院', '13200000000', 'mb@qq.com', '123456');
INSERT INTO `student` VALUES (1070, '毛彬0', 'M', '轻纺学院', '13200000000', 'mb@qq.com', '123456');
INSERT INTO `student` VALUES (1071, '张小小1', 'M', '物电学院', '13200000000', 'mb@qq.com', '123456');
INSERT INTO `student` VALUES (1072, '张小小2', 'F', '物电学院', '13200000000', 'mb@qq.com', '123456');
INSERT INTO `student` VALUES (1073, '张小小3', 'M', '物电学院', '13200000000', 'mb@qq.com', '123456');
INSERT INTO `student` VALUES (1074, '张小小4', 'M', '物电学院', '13200000000', 'mb@qq.com', '123456');
INSERT INTO `student` VALUES (1075, '张小小5', 'F', '物电学院', '13200000000', 'mb@qq.com', '123456');
INSERT INTO `student` VALUES (1076, '张小小6', 'M', '物电学院', '13200000000', 'mb@qq.com', '123456');
INSERT INTO `student` VALUES (1077, '张小小7', 'F', '物电学院', '13200000000', 'mb@qq.com', '123456');
INSERT INTO `student` VALUES (1078, '张小小8', 'F', '物电学院', '13200000000', 'mb@qq.com', '123456');
INSERT INTO `student` VALUES (1079, '张小小9', 'M', '物电学院', '13200000000', 'mb@qq.com', '123456');
INSERT INTO `student` VALUES (1080, '张小小0', 'F', '物电学院', '13200000000', 'mb@qq.com', '123456');
INSERT INTO `student` VALUES (1081, '吴志1', 'M', '材料学院', '13200000000', 'wz@qq.com', '123456');
INSERT INTO `student` VALUES (1082, '吴志2', 'F', '材料学院', '13200000000', 'wz@qq.com', '123456');
INSERT INTO `student` VALUES (1083, '吴志3', 'M', '材料学院', '13200000000', 'wz@qq.com', '123456');
INSERT INTO `student` VALUES (1084, '吴志4', 'F', '材料学院', '13200000000', 'wz@qq.com', '123456');
INSERT INTO `student` VALUES (1085, '吴志5', 'M', '材料学院', '13200000000', 'wz@qq.com', '123456');
INSERT INTO `student` VALUES (1086, '吴志6', 'F', '材料学院', '13200000000', 'wz@qq.com', '123456');
INSERT INTO `student` VALUES (1087, '吴志7', 'F', '材料学院', '13200000000', 'wz@qq.com', '123456');
INSERT INTO `student` VALUES (1088, '吴志8', 'M', '材料学院', '13200000000', 'wz@qq.com', '123456');
INSERT INTO `student` VALUES (1089, '吴志9', 'F', '材料学院', '13200000000', 'wz@qq.com', '123456');
INSERT INTO `student` VALUES (1090, '吴志0', 'M', '材料学院', '13200000000', 'wz@qq.com', '123456');
INSERT INTO `student` VALUES (1091, '诸葛1', 'F', '航天学院', '18900000000', 'zj@qq.com', '123456');
INSERT INTO `student` VALUES (1092, '诸葛2', 'F', '航天学院', '18900000000', 'zj@qq.com', '123456');
INSERT INTO `student` VALUES (1093, '诸葛3', 'M', '航天学院', '18900000000', 'zj@qq.com', '123456');
INSERT INTO `student` VALUES (1094, '诸葛4', 'M', '航天学院', '18900000000', 'zj@qq.com', '123456');
INSERT INTO `student` VALUES (1095, '诸葛5', 'F', '航天学院', '18900000000', 'zj@qq.com', '123456');
INSERT INTO `student` VALUES (1096, '诸葛6', 'M', '航天学院', '18900000000', 'zj@qq.com', '123456');
INSERT INTO `student` VALUES (1097, '诸葛7', 'F', '航天学院', '18900000000', 'zj@qq.com', '123456');
INSERT INTO `student` VALUES (1098, '诸葛8', 'M', '航天学院', '18900000000', 'zj@qq.com', '123456');
INSERT INTO `student` VALUES (1099, '诸葛9', 'M', '航天学院', '18900000000', 'zj@qq.com', '123456');
INSERT INTO `student` VALUES (1100, '诸葛0', 'F', '航天学院', '18900000000', 'zj@qq.com', '123456');
INSERT INTO `student` VALUES (1101, '胡图1', 'M', '生物医药学院', '17700000000', 'ht@qq.com', '123456');
INSERT INTO `student` VALUES (1102, '胡图2', 'F', '生物医药学院', '17700000000', 'ht@qq.com', '123456');
INSERT INTO `student` VALUES (1103, '胡图3', 'M', '生物医药学院', '17700000000', 'ht@qq.com', '123456');
INSERT INTO `student` VALUES (1104, '胡图4', 'F', '生物医药学院', '17700000000', 'ht@qq.com', '123456');
INSERT INTO `student` VALUES (1105, '胡图5', 'F', '生物医药学院', '17700000000', 'ht@qq.com', '123456');
INSERT INTO `student` VALUES (1106, '胡图6', 'M', '生物医药学院', '17700000000', 'ht@qq.com', '123456');
INSERT INTO `student` VALUES (1107, '胡图7', 'F', '生物医药学院', '17700000000', 'ht@qq.com', '123456');
INSERT INTO `student` VALUES (1108, '胡图8', 'M', '生物医药学院', '17700000000', 'ht@qq.com', '123456');
INSERT INTO `student` VALUES (1109, '胡图9', 'F', '生物医药学院', '17700000000', 'ht@qq.com', '123456');
INSERT INTO `student` VALUES (1110, '胡图0', 'M', '生物医药学院', '17700000000', 'ht@qq.com', '123456');

SET FOREIGN_KEY_CHECKS = 1;
