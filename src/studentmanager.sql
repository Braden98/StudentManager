/*
Navicat MySQL Data Transfer

Source Server         : alien
Source Server Version : 80012
Source Host           : localhost:3306
Source Database       : student

Target Server Type    : MYSQL
Target Server Version : 80012
File Encoding         : 65001

Date: 2018-12-22 16:40:44
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for association
-- ----------------------------
DROP TABLE IF EXISTS `association`;
CREATE TABLE `association` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ass_ID` int(11) DEFAULT NULL,
  `ass_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `fee` float(4,2) DEFAULT '0.00',
  `number` int(11) DEFAULT NULL,
  `level` int(11) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `association_ibfk_1` FOREIGN KEY (`id`) REFERENCES `student` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of association
-- ----------------------------

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `stu_ID` int(11) NOT NULL,
  `stu_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `age` int(11) NOT NULL,
  `sex` varchar(255) NOT NULL,
  `ass_ID` int(11) NOT NULL,
  `date` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `studentID` (`stu_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student
-- ----------------------------
DROP TRIGGER IF EXISTS `t_student_insert`;
DELIMITER ;;
CREATE TRIGGER `t_student_insert` AFTER INSERT ON `student` FOR EACH ROW begin
insert into association(id,ass_ID)
values(new.id,new.ass_ID);
end
;;
DELIMITER ;
DROP TRIGGER IF EXISTS `t_student_update`;
DELIMITER ;;
CREATE TRIGGER `t_student_update` AFTER UPDATE ON `student` FOR EACH ROW begin
update association set id=new.id where id=new.id;
end
;;
DELIMITER ;
DROP TRIGGER IF EXISTS `t_student_delete`;
DELIMITER ;;
CREATE TRIGGER `t_student_delete` AFTER DELETE ON `student` FOR EACH ROW begin
update association set status=1 where id=old.id;
end
;;
DELIMITER ;
