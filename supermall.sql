/*
Navicat MySQL Data Transfer

Source Server         : ......
Source Server Version : 50520
Source Host           : 10.28.16.54:3306
Source Database       : supermall

Target Server Type    : MYSQL
Target Server Version : 50520
File Encoding         : 65001

Date: 2018-01-14 10:59:48
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for empinfo
-- ----------------------------
DROP TABLE IF EXISTS `empinfo`;
CREATE TABLE `empinfo` (
  `empid` int(11) NOT NULL AUTO_INCREMENT,
  `empName` varchar(60) NOT NULL,
  `empPwd` varchar(60) NOT NULL,
  `empSex` varchar(60) NOT NULL,
  `empAge` varchar(60) NOT NULL,
  `empAdd` varchar(60) NOT NULL,
  `empTel` varchar(60) NOT NULL,
  `empJob` varchar(60) NOT NULL,
  PRIMARY KEY (`empid`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of empinfo
-- ----------------------------
INSERT INTO `empinfo` VALUES ('1', '潘雨', '123', '男', '21', '山东章丘', '3641', '花瓶');
INSERT INTO `empinfo` VALUES ('2', '吴长静', '123', '女', '20', '黑龙江', '150', '售货员');
INSERT INTO `empinfo` VALUES ('3', '赵淑慧er', '123', '女', '21', '15', '155', '售货员');
INSERT INTO `empinfo` VALUES ('4', '廉明杰', '123', '男', '20', '河北秦皇岛', '0875', '管理员');
INSERT INTO `empinfo` VALUES ('5', '葛化涛', '123', '男', '20', '黑龙江', '155', '采购员');
INSERT INTO `empinfo` VALUES ('6', '吴小程', '123', '女', '20', '山东', '458', '采购员');

-- ----------------------------
-- Table structure for goodscategoryinfo
-- ----------------------------
DROP TABLE IF EXISTS `goodscategoryinfo`;
CREATE TABLE `goodscategoryinfo` (
  `goodsCategoryId` int(11) NOT NULL AUTO_INCREMENT,
  `goodsCategoryName` varchar(60) DEFAULT NULL,
  PRIMARY KEY (`goodsCategoryId`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of goodscategoryinfo
-- ----------------------------
INSERT INTO `goodscategoryinfo` VALUES ('1', '水果类');
INSERT INTO `goodscategoryinfo` VALUES ('2', '生活用品类');
INSERT INTO `goodscategoryinfo` VALUES ('3', '零食类');
INSERT INTO `goodscategoryinfo` VALUES ('4', '生鲜类');
INSERT INTO `goodscategoryinfo` VALUES ('5', '电器类');
INSERT INTO `goodscategoryinfo` VALUES ('6', '餐饮类');
INSERT INTO `goodscategoryinfo` VALUES ('7', '运动器材类');
INSERT INTO `goodscategoryinfo` VALUES ('8', '床上用品类');
INSERT INTO `goodscategoryinfo` VALUES ('9', '成人用品类');
INSERT INTO `goodscategoryinfo` VALUES ('10', '药品类');
INSERT INTO `goodscategoryinfo` VALUES ('11', '电影版权类');
INSERT INTO `goodscategoryinfo` VALUES ('12', '奢侈品类');
INSERT INTO `goodscategoryinfo` VALUES ('14', '音乐器材类');
INSERT INTO `goodscategoryinfo` VALUES ('15', '蔬菜类');
INSERT INTO `goodscategoryinfo` VALUES ('16', '服装类');

-- ----------------------------
-- Table structure for goodsinfo
-- ----------------------------
DROP TABLE IF EXISTS `goodsinfo`;
CREATE TABLE `goodsinfo` (
  `goodsId` int(11) NOT NULL AUTO_INCREMENT,
  `goodsCategoryId` int(11) DEFAULT NULL,
  `goodsName` varchar(60) DEFAULT NULL,
  `goodsCPrice` double(60,2) DEFAULT NULL,
  `goodsPrice` double(60,2) DEFAULT NULL,
  `goodsStock` int(11) DEFAULT NULL,
  `goodsPhoto` varchar(60) DEFAULT NULL,
  PRIMARY KEY (`goodsId`),
  KEY `FK_Reference_4` (`goodsCategoryId`),
  CONSTRAINT `FK_Reference_4` FOREIGN KEY (`goodsCategoryId`) REFERENCES `goodscategoryinfo` (`goodsCategoryId`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of goodsinfo
-- ----------------------------
INSERT INTO `goodsinfo` VALUES ('1', '1', '苹果', '1.50', '4.00', '80', 'images\\苹果.jpg');
INSERT INTO `goodsinfo` VALUES ('2', '1', '梨', '2.50', '6.00', '400', 'images\\梨.jpg');
INSERT INTO `goodsinfo` VALUES ('3', '2', '洗发水', '30.00', '80.00', '100', 'images\\洗发水.jpg');
INSERT INTO `goodsinfo` VALUES ('4', '2', '牙刷', '2.50', '8.00', '200', 'images\\牙刷.jpg');
INSERT INTO `goodsinfo` VALUES ('5', '3', '辣条', '1.00', '3.50', '1500', 'images\\辣条.jpg');
INSERT INTO `goodsinfo` VALUES ('6', '3', '薯片', '1.50', '4.00', '800', 'images\\薯片.jpg');
INSERT INTO `goodsinfo` VALUES ('7', '4', '小龙虾', '30.00', '88.00', '200', 'images\\龙虾.jpg');
INSERT INTO `goodsinfo` VALUES ('8', '4', '大闸蟹', '25.00', '98.00', '200', 'images\\大闸蟹.jpg');
INSERT INTO `goodsinfo` VALUES ('9', '5', '洗衣机', '2000.00', '14999.00', '10', 'images\\洗衣机.jpg');
INSERT INTO `goodsinfo` VALUES ('10', '6', '辣椒炒肉', '6.00', '15.00', '200', 'images\\辣椒炒肉.jpg');
INSERT INTO `goodsinfo` VALUES ('11', '7', '跑步机', '800.00', '2499.00', '50', 'images\\跑步机.jpg');
INSERT INTO `goodsinfo` VALUES ('12', '8', '床上三件套', '888.00', '20000.00', '20', 'images\\床上三件套.jpg');
INSERT INTO `goodsinfo` VALUES ('13', '9', '安全套', '3.50', '10.00', '600', 'images\\安全套.jpg');
INSERT INTO `goodsinfo` VALUES ('14', '10', '阿司匹林', '30.00', '88.00', '600', 'images\\阿司匹林.jpg');
INSERT INTO `goodsinfo` VALUES ('15', '11', '前任3', '0.00', '35.00', '2000', 'images\\前任三.jpg');
INSERT INTO `goodsinfo` VALUES ('16', '11', '无问西东', '0.00', '50.00', '2500', 'images\\无问西东.jpg');
INSERT INTO `goodsinfo` VALUES ('17', '12', '口红', '128.00', '299.00', '2333', 'images\\口红.jpg');
INSERT INTO `goodsinfo` VALUES ('19', '14', '吉他', '800.00', '2500.00', '150', 'images\\吉他.jpg');
INSERT INTO `goodsinfo` VALUES ('20', '15', '章丘大葱', '4.00', '10.00', '5000', 'images\\章丘大葱.jpg');
INSERT INTO `goodsinfo` VALUES ('21', '16', '保暖秋裤', '20.00', '88.00', '500', 'images\\保暖秋裤.jpg');
INSERT INTO `goodsinfo` VALUES ('22', '16', '卫衣', '49.00', '249.00', '533', 'images\\卫衣.jpg');

-- ----------------------------
-- Table structure for inproinfo
-- ----------------------------
DROP TABLE IF EXISTS `inproinfo`;
CREATE TABLE `inproinfo` (
  `proId` int(11) NOT NULL AUTO_INCREMENT,
  `Did` int(11) DEFAULT NULL,
  `empId` int(11) DEFAULT NULL,
  `prodate` date DEFAULT NULL,
  `goodsName` varchar(60) DEFAULT NULL,
  `goodsNum` int(11) DEFAULT NULL,
  `remark` varchar(60) DEFAULT NULL,
  PRIMARY KEY (`proId`),
  KEY `FK_Reference_5` (`Did`),
  KEY `FK_Reference_6` (`empId`),
  KEY `FK_Reference_7` (`goodsName`),
  CONSTRAINT `FK_Reference_5` FOREIGN KEY (`Did`) REFERENCES `supplierinfo` (`Did`),
  CONSTRAINT `FK_Reference_6` FOREIGN KEY (`empId`) REFERENCES `empinfo` (`empid`)
) ENGINE=InnoDB AUTO_INCREMENT=53 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of inproinfo
-- ----------------------------
INSERT INTO `inproinfo` VALUES ('49', '14', '5', '2018-01-14', '苹果', '200', '');
INSERT INTO `inproinfo` VALUES ('50', '16', '6', '2018-01-14', '阿司匹林', '100', '');
INSERT INTO `inproinfo` VALUES ('51', '17', '5', '2018-01-14', '无问西东', '500', '');
INSERT INTO `inproinfo` VALUES ('52', '18', '6', '2018-01-14', '卫衣', '33', '质量好一点');

-- ----------------------------
-- Table structure for saleinfo
-- ----------------------------
DROP TABLE IF EXISTS `saleinfo`;
CREATE TABLE `saleinfo` (
  `saleId` int(11) NOT NULL AUTO_INCREMENT,
  `vipId` int(11) DEFAULT '0',
  `empId` int(11) NOT NULL,
  `goodsId` int(11) NOT NULL,
  `goodsNum` int(11) NOT NULL,
  `saleDate` date NOT NULL,
  `saleProfit` double NOT NULL,
  PRIMARY KEY (`saleId`),
  KEY `FK_Reference_1` (`vipId`),
  KEY `FK_Reference_2` (`empId`),
  KEY `FK_Reference_3` (`goodsId`),
  CONSTRAINT `FK_Reference_1` FOREIGN KEY (`vipId`) REFERENCES `vipinfo` (`vipId`),
  CONSTRAINT `FK_Reference_2` FOREIGN KEY (`empId`) REFERENCES `empinfo` (`empid`),
  CONSTRAINT `FK_Reference_3` FOREIGN KEY (`goodsId`) REFERENCES `goodsinfo` (`goodsId`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of saleinfo
-- ----------------------------
INSERT INTO `saleinfo` VALUES ('1', '1', '2', '1', '20', '2018-01-14', '34');
INSERT INTO `saleinfo` VALUES ('2', '2', '2', '1', '600', '2018-01-14', '780');
INSERT INTO `saleinfo` VALUES ('3', '2', '2', '2', '100', '2018-01-14', '170');

-- ----------------------------
-- Table structure for supplierinfo
-- ----------------------------
DROP TABLE IF EXISTS `supplierinfo`;
CREATE TABLE `supplierinfo` (
  `Did` int(11) NOT NULL AUTO_INCREMENT,
  `Dname` varchar(60) DEFAULT NULL,
  `Dtel` varchar(60) DEFAULT NULL,
  `Demail` varchar(60) DEFAULT NULL,
  `Dadd` varchar(60) DEFAULT NULL,
  `goodsName` varchar(11) DEFAULT NULL,
  `goodsCategoryId` int(11) DEFAULT NULL,
  `goodspictures` varchar(60) DEFAULT NULL,
  PRIMARY KEY (`Did`),
  KEY `goodsId` (`goodsName`),
  KEY `goodsCategoryId` (`goodsCategoryId`),
  CONSTRAINT `supplierinfo_ibfk_1` FOREIGN KEY (`goodsCategoryId`) REFERENCES `goodscategoryinfo` (`goodsCategoryId`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of supplierinfo
-- ----------------------------
INSERT INTO `supplierinfo` VALUES ('14', '红富士', '13666', '136666@163.com', '长沙', '苹果', '1', 'images/苹果.jpg');
INSERT INTO `supplierinfo` VALUES ('15', '杜蕾斯', '13888', '13888', '东莞', '安全套', '9', 'images/安全套.jpg');
INSERT INTO `supplierinfo` VALUES ('16', 'aspl', '156666', '15666', '杭州', '阿司匹林', '10', 'images/阿司匹林.jpg');
INSERT INTO `supplierinfo` VALUES ('17', '影视公司', '18333', '18333', '株洲', '无问西东', '11', 'images/无问西东.jpg');
INSERT INTO `supplierinfo` VALUES ('18', 'GXG男装', '138888', '1388', '湘潭', '卫衣', '16', 'images/卫衣.jpg');
INSERT INTO `supplierinfo` VALUES ('19', '影视公司', '1366', '1366', '株洲', '前任3', '11', 'images/前任三.jpg');
INSERT INTO `supplierinfo` VALUES ('20', '美的', '1366', '1388', '杭州', '洗衣机', '5', 'images/洗衣机.jpg');
INSERT INTO `supplierinfo` VALUES ('21', '卫龙', '1366', '1388', '郑州', '辣条', '3', 'images/辣条.jpg');
INSERT INTO `supplierinfo` VALUES ('22', '香奈儿', '13999', '13666', '法国', '香水', '12', 'images/香水.jpg');
INSERT INTO `supplierinfo` VALUES ('23', '龙虾', '136', '138', '青岛', '小龙虾', '4', 'images/龙虾.jpg');
INSERT INTO `supplierinfo` VALUES ('24', '乐事', '1566', '1588', '长沙', '薯片', '3', 'images/薯片.jpg');
INSERT INTO `supplierinfo` VALUES ('25', '食品商', '1366', '1388', '广州', '辣椒炒肉', '6', 'images/辣椒炒肉.jpg');
INSERT INTO `supplierinfo` VALUES ('26', '用品公司', '1366', '1388', '乌镇', '床上三件套', '8', 'images/床上三件套.jpg');

-- ----------------------------
-- Table structure for vipinfo
-- ----------------------------
DROP TABLE IF EXISTS `vipinfo`;
CREATE TABLE `vipinfo` (
  `vipId` int(11) NOT NULL AUTO_INCREMENT,
  `vipName` varchar(60) DEFAULT NULL,
  `vipSex` varchar(60) DEFAULT NULL,
  `vipCut` varchar(60) DEFAULT NULL,
  PRIMARY KEY (`vipId`)
) ENGINE=InnoDB AUTO_INCREMENT=90 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of vipinfo
-- ----------------------------
INSERT INTO `vipinfo` VALUES ('1', '吴长静', '女', '0.8');
INSERT INTO `vipinfo` VALUES ('2', '吴小程', '女', '0.7');
INSERT INTO `vipinfo` VALUES ('3', '潘雨', '男', '0.9');
INSERT INTO `vipinfo` VALUES ('4', '廉明杰', '男', '0.6');
INSERT INTO `vipinfo` VALUES ('5', '葛化涛', '男', '0.7');
INSERT INTO `vipinfo` VALUES ('6', '赵淑慧', '女', '0.7');
INSERT INTO `vipinfo` VALUES ('7', '习近平', '男', '0.7');
INSERT INTO `vipinfo` VALUES ('8', '彭丽煖', '女', '0.8');
INSERT INTO `vipinfo` VALUES ('9', '特朗普', '男', '0.9');
INSERT INTO `vipinfo` VALUES ('10', '普京', '男', '0.9');
INSERT INTO `vipinfo` VALUES ('11', '范冰冰', '女', '0.9');
INSERT INTO `vipinfo` VALUES ('13', '鞠萍', '女', '0.9');
INSERT INTO `vipinfo` VALUES ('14', '董浩', '男', '0.8');
INSERT INTO `vipinfo` VALUES ('15', '陈道明', '男', '0.8');
INSERT INTO `vipinfo` VALUES ('16', '刘德华', '男', '0.9');
INSERT INTO `vipinfo` VALUES ('17', '成龙', '男', '0.7');
INSERT INTO `vipinfo` VALUES ('88', '普通顾客', '男', '1.0');
INSERT INTO `vipinfo` VALUES ('89', '刘强', '男', '0.8');
