/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50556
Source Host           : localhost:3306
Source Database       : bills

Target Server Type    : MYSQL
Target Server Version : 50556
File Encoding         : 65001

Date: 2020-02-11 22:29:09
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `bills`
-- ----------------------------
DROP TABLE IF EXISTS `bills`;
CREATE TABLE `bills` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(100) DEFAULT NULL,
  `billtime` datetime DEFAULT NULL,
  `typeid` int(11) DEFAULT NULL,
  `price` double(11,2) DEFAULT NULL,
  `remark` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bills
-- ----------------------------
INSERT INTO `bills` VALUES ('1', '小明借我的钱去喝酒', '2019-08-09 11:29:29', '3', '200.00', '111');
INSERT INTO `bills` VALUES ('2', '21231', '2019-08-09 04:25:21', '4', '22.00', '22');
INSERT INTO `bills` VALUES ('3', '222', '2019-09-03 16:00:00', '1', '222.00', '222');
INSERT INTO `bills` VALUES ('4', 'fdas', '2020-02-10 03:31:28', '2', '4.00', '4');

-- ----------------------------
-- Table structure for `billtype`
-- ----------------------------
DROP TABLE IF EXISTS `billtype`;
CREATE TABLE `billtype` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of billtype
-- ----------------------------
INSERT INTO `billtype` VALUES ('1', '支出');
INSERT INTO `billtype` VALUES ('2', '收入');
INSERT INTO `billtype` VALUES ('3', '借出');
INSERT INTO `billtype` VALUES ('4', '借入');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(60) DEFAULT NULL,
  `loginname` varchar(60) DEFAULT NULL,
  `pwd` varchar(20) DEFAULT NULL,
  `sex` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '小明', 'xiaoming', '123456', '男');
INSERT INTO `user` VALUES ('2', '管理员', 'admin', '123456', '女');
