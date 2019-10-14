/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50615
Source Host           : localhost:3306
Source Database       : ski_db

Target Server Type    : MYSQL
Target Server Version : 50615
File Encoding         : 65001

Date: 2019-10-11 11:17:01
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for account
-- ----------------------------
DROP TABLE IF EXISTS `account`;
CREATE TABLE `account` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `money` double(20,0) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of account
-- ----------------------------
INSERT INTO `account` VALUES ('1', '小明', '40');
INSERT INTO `account` VALUES ('2', '小红', '0');
INSERT INTO `account` VALUES ('3', '小海', '100');
INSERT INTO `account` VALUES ('4', '小莉', '200');

-- ----------------------------
-- Table structure for book
-- ----------------------------
DROP TABLE IF EXISTS `book`;
CREATE TABLE `book` (
  `id` int(6) NOT NULL AUTO_INCREMENT,
  `bookName` varchar(255) DEFAULT NULL,
  `isbn` varchar(255) DEFAULT NULL,
  `price` double(6,0) DEFAULT NULL,
  `stock` int(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of book
-- ----------------------------
INSERT INTO `book` VALUES ('1', 'Java', '001', '100', '7');
INSERT INTO `book` VALUES ('2', 'Html', '002', '50', '9');

-- ----------------------------
-- Table structure for product
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
  `id` int(6) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `listimg` varchar(255) DEFAULT NULL,
  `price` int(255) DEFAULT NULL,
  `discountprice` int(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of product
-- ----------------------------
INSERT INTO `product` VALUES ('1', '鸡蛋灌饼', '特色', 'jdgb.jpg', '20', '10');
INSERT INTO `product` VALUES ('2', '桂林米粉', '真实惠', 'glmf.jpg', '80', '0');
INSERT INTO `product` VALUES ('3', '老友粉', '难以用语言表达', 'lyf.jpg', '60', '20');
INSERT INTO `product` VALUES ('4', '螺蛳粉', '好好吃', 'lsf.jpg', '122', '90');
INSERT INTO `product` VALUES ('5', '烧饼', '香', 'sbb.jpg', '80', '60');
INSERT INTO `product` VALUES ('6', '包子', '能吃饱', 'bz.jpg', '100', '80');
INSERT INTO `product` VALUES ('7', '罗汉果', '有味道', 'lhg.png', '200', '70');
INSERT INTO `product` VALUES ('8', '木瓜', '解渴', 'mg.jpg', '160', '80');
INSERT INTO `product` VALUES ('9', '沙田柚', '对胃好', 'sty.png', '100', '60');
INSERT INTO `product` VALUES ('10', '百香果', '治病', 'bxg.jpg', '120', '80');
INSERT INTO `product` VALUES ('11', '桂圆', '能吃饱', 'gy.jpg', '90', '80');
INSERT INTO `product` VALUES ('12', '草莓', '不错', 'cm.jpg', '200', '80');
INSERT INTO `product` VALUES ('13', '哈密瓜', '吃一个', 'hmg.jpg', '150', '70');
INSERT INTO `product` VALUES ('15', '菠萝', '必备', 'bl.jpg', '100', '80');
INSERT INTO `product` VALUES ('16', '哈密瓜', '个大', 'hmg.jpg', '100', '70');
INSERT INTO `product` VALUES ('17', '猕猴桃', '能吃爽', 'mht.png', '90', '80');
INSERT INTO `product` VALUES ('18', '包子', '能吃饱', 'bz.jpg', '99', '80');

-- ----------------------------
-- Table structure for producttype
-- ----------------------------
DROP TABLE IF EXISTS `producttype`;
CREATE TABLE `producttype` (
  `id` int(6) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of producttype
-- ----------------------------

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `id` int(6) NOT NULL AUTO_INCREMENT,
  `stuNum` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `validate_code` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('15', '2016011222', 'qq', 'ab1cccd5a7b870a09bb530b4427b8983', '562611873@qq.com', '7533a2cc998299632b081f429b2d9b59');

-- ----------------------------
-- Table structure for students
-- ----------------------------
DROP TABLE IF EXISTS `students`;
CREATE TABLE `students` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `stuNo` varchar(50) DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  `sex` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of students
-- ----------------------------
INSERT INTO `students` VALUES ('1', '0001', '小璐', '女');
INSERT INTO `students` VALUES ('2', '0002', '小露', '女');
INSERT INTO `students` VALUES ('6', '0003', '小鹿', '女');
INSERT INTO `students` VALUES ('7', '0003', '小鹿', '女');
INSERT INTO `students` VALUES ('8', '0004', '小霞', '女');
INSERT INTO `students` VALUES ('9', '0005', '小雨', '女');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(6) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `authority` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'wpf', '123', '管理员');
INSERT INTO `user` VALUES ('2', 'www', '123', '用户');

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `id` int(6) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `hobby` varchar(255) DEFAULT NULL,
  `photo` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES ('3', '大米', '123', '997806981@qq.com', '桂林', '爬山', 'd25ab83ddfa34fa98725406626f873a4.jpg');
INSERT INTO `users` VALUES ('4', '小米', '123', '5626', '邯郸', '看电影', 'fea9f02edc8f4cfda1e63b7e3f8e3e4b.jpg');
INSERT INTO `users` VALUES ('5', '黑豆', '123', '1111111', '南宁', '音乐', 'eac720e253d34e748128c5cf5c04f93b.jpg');
INSERT INTO `users` VALUES ('6', '小婷', '123', '9999', '惠州', '睡觉', '4cd812fafeda44ec85d4a4ca69d07355.jpg');
