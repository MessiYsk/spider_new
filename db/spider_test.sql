/*
Navicat MySQL Data Transfer

Source Server         : 本地
Source Server Version : 50723
Source Host           : localhost:3306
Source Database       : spider_test

Target Server Type    : MYSQL
Target Server Version : 50723
File Encoding         : 65001

Date: 2018-10-24 11:09:35
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for domain_img_config
-- ----------------------------
DROP TABLE IF EXISTS `domain_img_config`;
CREATE TABLE `domain_img_config` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `domain` varchar(255) DEFAULT NULL COMMENT '主域名',
  `img_attr1` varchar(255) DEFAULT NULL COMMENT '图片标签的属性值1',
  `node_name` varchar(255) DEFAULT NULL COMMENT '节点名称',
  `img_attr2` varchar(255) DEFAULT '' COMMENT '图片标签的属性值1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of domain_img_config
-- ----------------------------
INSERT INTO `domain_img_config` VALUES ('1', '588ku.com', 'data-original', 'img', '');
