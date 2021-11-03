create database bootvue;
use bootvue;

SET FOREIGN_KEY_CHECKS=0;

-- 管理员表
DROP TABLE IF EXISTS `admins`;
CREATE TABLE `admins` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) NOT NULL,
  `password` varchar(50) NOT NULL,
  `name` varchar(20) DEFAULT NULL,
  `phone` bigint(20) DEFAULT NULL,
  `power` varchar(20) DEFAULT '2',
  -- `describes` varchar(40) DEFAULT '低',
  PRIMARY KEY (`id`)
)ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4;

INSERT INTO `admins` VALUES ('1', 'zxk', 'zxk123', '周荀凯', '138138138', '1');
INSERT INTO `admins` VALUES ('2', 'zj', 'zj123', '张杰', '138138138', '2');
INSERT INTO `admins` VALUES ('3', 'zh', 'zh123', '张欢', '138138138', '1');
INSERT INTO `admins` VALUES ('4', 'zk', 'zk123', '赵凯', '138138138', '2');
INSERT INTO `admins` VALUES ('5', 'ywj', 'ywj123', '杨雯雯', '138138138', '1');
INSERT INTO `admins` VALUES ('6', 'wh', 'wh123', '王皓', '138138138', '1');
INSERT INTO `admins` VALUES ('7', 'zw', 'zw123', '张伟', '138138138', '2');
INSERT INTO `admins` VALUES ('8', 'zj', 'zj321', '赵佳', '138138138', '2');
INSERT INTO `admins` VALUES ('9', 'wf', 'wf123', '王凡', '138138138', '1');
INSERT INTO `admins` VALUES ('10', 'zn', 'zzn123', '张娜', '138138138', '1');
INSERT INTO `admins` VALUES ('11', 'jzh', 'jzh123', '蒋子华', '138138138', '2');
INSERT INTO `admins` VALUES ('12', 'xl', 'xl123', '薛磊', '138138138', '2');
INSERT INTO `admins` VALUES ('13', 'yjz', 'yjz123', '杨建泽', '138138138', '0');

-- INSERT INTO `admins` VALUES ('1', 'zxk', 'zxk123', '周荀凯', '138138138', '1', '高');
-- INSERT INTO `admins` VALUES ('2', 'zj', 'zj123', '张杰', '138138138', '2', '低');
-- INSERT INTO `admins` VALUES ('3', 'zh', 'zh123', '张欢', '138138138', '1', '高');
-- INSERT INTO `admins` VALUES ('4', 'zk', 'zk123', '赵凯', '138138138', '2', '低');
-- INSERT INTO `admins` VALUES ('5', 'ywj', 'ywj123', '杨雯雯', '138138138', '1', '高');
-- INSERT INTO `admins` VALUES ('6', 'wh', 'wh123', '王皓', '138138138', '1', '高');
-- INSERT INTO `admins` VALUES ('7', 'zw', 'zw123', '张伟', '138138138', '2', '低');
-- INSERT INTO `admins` VALUES ('8', 'zj', 'zj321', '赵佳', '138138138', '2', '低');
-- INSERT INTO `admins` VALUES ('9', 'wf', 'wf123', '王凡', '138138138', '1', '高');
-- INSERT INTO `admins` VALUES ('10', 'zn', 'zzn123', '张娜', '138138138', '1', '高');
-- INSERT INTO `admins` VALUES ('11', 'jzh', 'jzh123', '蒋子华', '138138138', '2', '低');
-- INSERT INTO `admins` VALUES ('12', 'xl', 'xl123', '薛磊', '138138138', '2', '低');
-- INSERT INTO `admins` VALUES ('13', 'yjz', 'yjz123', '杨建泽', '138138138', '0', '顶级');

-- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- 
-- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- 分割线- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- 
-- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- --

-- 学生信息表
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `studentid` int(11) NOT NULL,
  `name` varchar(20) DEFAULT NULL,
  `sex` varchar(20) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `phone` bigint(20) DEFAULT NULL,
  `classid` int(11) NOT NULL,-- 班级编号 
  `classname` varchar(20) DEFAULT NULL,-- 班级名
  `dormitoryid` int(11) NOT NULL,-- 寝室编号 
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4;

-- select count(id) count,classid from student group by classid;
-- select count(dormitoryid) count,dormitoryid from student group by dormitoryid;
-- select count(classname) count,classname from student group by classname;

INSERT INTO `student` VALUES ('1', '1413032001', '张杰', '男', '22', '138138138', '141', '生物', '301');
INSERT INTO `student` VALUES ('2', '1413032002', '赵凯', '男', '22', '138138138', '141', '生物', '301');
INSERT INTO `student` VALUES ('3', '1413032003', '许文文', '男', '21', '138138138', '141', '生物', '301');
INSERT INTO `student` VALUES ('4', '1413032004', '王浩', '男', '22', '138138138', '141', '生物', '301');
INSERT INTO `student` VALUES ('5', '1413032005', '张伟', '男', '22', '138138138', '1910', '软件', '301');
INSERT INTO `student` VALUES ('6', '1413032006', '郭顶', '男', '21', '138138138', '141', '土木', '301');
INSERT INTO `student` VALUES ('7', '1513112411', '曹原', '男', '20', '138138138', '151', '应化', '112');
INSERT INTO `student` VALUES ('8', '1513112412', '赵跃', '男', '21', '138138138', '151', '纺织', '112');
INSERT INTO `student` VALUES ('9', '1513112413', '孙畅', '男', '21', '138138138', '151', '纺织', '112');
INSERT INTO `student` VALUES ('10', '1513122417', '周帆', '男', '21', '138138138', '161', '物流', '213');
INSERT INTO `student` VALUES ('11', '1513122418', '田野', '男', '21', '138138138', '153', '数师', '213');
INSERT INTO `student` VALUES ('12', '1513122419', '张嘉佳', '男', '20', '138138138', '153', '金融', '213');
INSERT INTO `student` VALUES ('13', '1513122420', '陈昊', '男', '21', '138138138', '153', '金融', '213');
INSERT INTO `student` VALUES (null, '1513122419', '张嘉', '男', '20', '138138138', '178', '食品', '501');
INSERT INTO `student` VALUES (null, '1513122420', '陈姜', '男', '21', '138138138', '178', '食品', '501');
INSERT INTO `student` VALUES (null, '1513122419', '王鹏', '男', '20', '138138138', '161', '食品', '501');
INSERT INTO `student` VALUES (null, '1513122420', '李号', '男', '21', '138138138', '1910', '软件', '602');
INSERT INTO `student` VALUES (null, '1513122420', '找可', '女', '21', '138138138', '1910', '软件', '601');
-- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- 
-- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- 分割线- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- 
-- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- --

-- 班级管理 
DROP TABLE IF EXISTS `class`;
CREATE TABLE `class` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `classid` int(11) NOT NULL,
  `classname` varchar(30) DEFAULT NULL,
  `counsellor` varchar(30) DEFAULT NULL,-- 辅导员 
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4;

INSERT INTO `class` VALUES ('1', '141', '生物', '徐超');
INSERT INTO `class` VALUES ('2', '151', '应化', '刘晨');
INSERT INTO `class` VALUES ('3', '142', '土木', '孙玲');
INSERT INTO `class` VALUES ('4', '161', '物流', '刘阳');
INSERT INTO `class` VALUES ('5', '153', '数师', '张宇');
INSERT INTO `class` VALUES ('6', '162', '物流', '刘阳');
INSERT INTO `class` VALUES ('7', '171', '自动化', '周涵涵');
INSERT INTO `class` VALUES ('8', '154', '土木', '孙玲');
INSERT INTO `class` VALUES ('9', '151', '纺织', '赵凯');
INSERT INTO `class` VALUES ('10', '153', '金融', '刘培');

-- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- 
-- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- 分割线- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- 
-- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- --

-- 宿舍列表 
DROP TABLE IF EXISTS `dormitoryinfo`;
CREATE TABLE `dormitoryinfo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `dormitoryid` int(11) NOT NULL,
  `dormbuilding` varchar(20) DEFAULT NULL,
  `bedtotal` varchar(20) DEFAULT NULL,
  `bed` varchar(20) DEFAULT NULL,
  `name` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4;

INSERT INTO `dormitoryinfo` VALUES ('1', '311', '24号楼', '4', '3', '周荀凯');
INSERT INTO `dormitoryinfo` VALUES ('2', '322', '24号楼', '4', '4', '周荀凯');
INSERT INTO `dormitoryinfo` VALUES ('3', '601', '23号楼', '6', '6', '张杰');
INSERT INTO `dormitoryinfo` VALUES ('4', '602', '23号楼', '6', '5', '张杰');
INSERT INTO `dormitoryinfo` VALUES ('5', '111', '22号楼', '4', '4', '杨雯雯');
INSERT INTO `dormitoryinfo` VALUES ('6', '112', '22号楼', '4', '3', '杨雯雯');
INSERT INTO `dormitoryinfo` VALUES ('7', '222', '27号楼', '6', '6', '张伟');
INSERT INTO `dormitoryinfo` VALUES ('8', '213', '27号楼', '4', '4', '张伟');
INSERT INTO `dormitoryinfo` VALUES ('9', '312', '26号楼', '6', '6', '薛磊');
INSERT INTO `dormitoryinfo` VALUES ('10', '313', '22号楼', '4', '4', '张磊');
INSERT INTO `dormitoryinfo` VALUES ('11', '323', '22号楼', '6', '5', '张磊');
INSERT INTO `dormitoryinfo` VALUES ('12', '301', '24号楼', '6', '6', '周荀凯');
INSERT INTO `dormitoryinfo` VALUES ('13', '302', '24号楼', '6', '6', '周荀凯');
INSERT INTO `dormitoryinfo` VALUES ('14', '423', '29号楼', '4', '3', '郭浩然');

-- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- 
-- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- 分割线- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- 
-- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- --

-- 宿舍维修人员表 
DROP TABLE IF EXISTS `dormrepair`;
CREATE TABLE `dormrepair` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `dormitoryid` int(11) NOT NULL,
  `dormbuilding` varchar(20) NOT NULL,
  `name` varchar(20) DEFAULT NULL,
  `reason` varchar(50) DEFAULT NULL,
  `createtime` date DEFAULT NULL,
  `updatetime` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4;

INSERT INTO `dormrepair` VALUES ('1', '301', '24号楼', '王涛', '水池', '2019-05-13', '2019-05-13');
INSERT INTO `dormrepair` VALUES ('2', '322', '24号楼', '王涛', '灯管', '2019-05-11', '2019-05-14');
INSERT INTO `dormrepair` VALUES ('3', '601', '23号楼', '冯军', '水龙头', '2019-05-15', '2019-05-14');
INSERT INTO `dormrepair` VALUES ('4', '601', '23号楼', '冯军', '插孔', '2019-05-15', '2019-05-15');
INSERT INTO `dormrepair` VALUES ('5', '213', '27号楼', '冯军', '排风扇', '2019-05-18', '2019-05-14');
INSERT INTO `dormrepair` VALUES ('6', '312', '26号楼', '彭建国', '空调', '2019-05-20', '2019-05-20');

-- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- 
-- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- 分割线- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- 
-- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- --

-- 宿舍楼卫生表 
DROP TABLE IF EXISTS `dormgrade`;
CREATE TABLE `dormgrade` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `dormitoryid` int(11) NOT NULL,
  `dormbuilding` varchar(20) DEFAULT NULL,
  `grade` int(11) DEFAULT NULL,
  `createtime` date DEFAULT NULL,
  `updatetime` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4;

INSERT INTO `dormgrade` VALUES ('1', '301', '24号楼', '6', '2019-04-25', '2019-05-12');
INSERT INTO `dormgrade` VALUES ('2', '302', '24号楼', '7', '2019-05-01', '2019-05-01');
INSERT INTO `dormgrade` VALUES ('3', '322', '24号楼', '8', '2019-05-04', '2019-05-04');
INSERT INTO `dormgrade` VALUES ('4', '602', '23号楼', '7', '2019-05-08', '2019-05-08');
INSERT INTO `dormgrade` VALUES ('5', '112', '22号楼', '7', '2019-05-12', '2019-05-12');
INSERT INTO `dormgrade` VALUES ('6', '222', '27号楼', '9', '2019-05-09', '2019-05-09');
INSERT INTO `dormgrade` VALUES ('7', '213', '27号楼', '8', '2019-05-10', '2019-05-10');

-- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- 
-- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- 分割线- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- 
-- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- --

-- 宿舍学生卫生表 
DROP TABLE IF EXISTS `stgrade`;
CREATE TABLE `stgrade` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `studentid` int(11) NOT NULL,
  `name` varchar(20) DEFAULT NULL,
  `grade` int(11) DEFAULT NULL,
  `classid` int(11) DEFAULT NULL,
  `dormitoryid` int(11) DEFAULT NULL,
  `createtime` date DEFAULT NULL,
  `updatetime` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4;

INSERT INTO `stgrade` VALUES ('1', '1413032001', '张杰', '6', '141', '301', '2019-04-26', '2019-04-26');
INSERT INTO `stgrade` VALUES ('2', '1413032002', '赵凯', '7', '141', '301', '2019-05-01', '2019-05-01');
INSERT INTO `stgrade` VALUES ('3', '1413032003', '许文文', '6', '141', '301', '2019-05-06', '2019-05-06');
INSERT INTO `stgrade` VALUES ('4', '1413032003', '许文文', '7', '141', '301', '2019-05-16', '2019-05-16');
INSERT INTO `stgrade` VALUES ('5', '1413032004', '王浩', '7', '141', '301', '2019-05-10', '2019-05-10');
INSERT INTO `stgrade` VALUES ('6', '1413032005', '张伟', '8', '141', '301', '2019-05-14', '2019-05-14');
INSERT INTO `stgrade` VALUES ('7', '1513112412', '赵跃', '9', '151', '112', '2019-05-08', '2019-05-08');
INSERT INTO `stgrade` VALUES ('8', '1513112412', '赵跃', '9', '151', '112', '2019-05-17', '2019-05-17');
INSERT INTO `stgrade` VALUES ('9', '1513122418', '田野', '8', '151', '213', '2019-05-15', '2019-05-15');
INSERT INTO `stgrade` VALUES ('10', '1513122419', '张嘉佳', '8', '151', '213', '2019-05-15', '2019-05-15');

-- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- 
-- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- 分割线- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- 
-- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- --

-- 宿舍访问表
DROP TABLE IF EXISTS `visitor`;
CREATE TABLE `visitor` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  `phone` bigint(20) DEFAULT NULL,
  `dormitoryid` int(11) DEFAULT NULL,
  `dormbuilding` varchar(20) DEFAULT NULL,
  `createtime` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4;

INSERT INTO `visitor` VALUES ('1', '郑杰', '138138138', '301', '24号楼', '2019-05-14');
INSERT INTO `visitor` VALUES ('2', '李博', '138138138', '322', '24号楼', '2019-05-12');
INSERT INTO `visitor` VALUES ('3', '张盈盈', '138138138', '601', '23号楼', '2019-05-13');
INSERT INTO `visitor` VALUES ('4', '王涛', '138138138', '111', '22号楼', '2019-05-15');
INSERT INTO `visitor` VALUES ('5', '胡浩', '138138138', '222', '27号楼', '2019-05-16');
INSERT INTO `visitor` VALUES ('6', '陈昊', '138138138', '213', '27号楼', '2019-05-18');
INSERT INTO `visitor` VALUES ('7', '刘军', '138138138', '213', '27号楼', '2019-05-20');
INSERT INTO `visitor` VALUES ('8', '黄智', '138138138', '312', '26号楼', '2019-05-22');
INSERT INTO `visitor` VALUES ('9', '郑杰', '123123123', '311', '24号楼', '2019-05-16');

-- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- 
-- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- 分割线- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- 
-- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- --

-- 博客/留言板
DROP TABLE IF EXISTS `blogs`;
CREATE TABLE `blogs` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) DEFAULT NULL,
  `content` text DEFAULT NULL,
  `author` varchar(20) DEFAULT NULL,
  `createtime` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4;

-- alter  table  blogs
--     add  `path`  varchar(255) DEFAULT Null

-- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- 
-- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- 分割线- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- 
-- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- --
-- select b.*,c.id id_comment,c.name,c.txt,c.createtime createtime_comment,c.bid from 
-- blogs b left join comment c on b.id=c.bid;
-- 评论表
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  `txt` varchar(255) DEFAULT NULL,
  `createtime` date DEFAULT NULL,
  `bid` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4;

INSERT INTO `comment` VALUES ('1', '郑杰', '膜拜大佬！！！', '2021-10-13','10');

-- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- 
-- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- 分割线- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- 
-- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- --

-- 版本更新
-- DROP TABLE IF EXISTS `versions`;
-- CREATE TABLE `versions` (
--   `id` int NOT NULL AUTO_INCREMENT,
--   `time` datetime DEFAULT NULL,
--   `version` varchar(20) DEFAULT NULL,
--   `remark` text DEFAULT NULL,
--   PRIMARY KEY (`id`)
-- ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- insert into versions values(null,'2021-10-05','1.0','项目着手开发');
-- insert into versions values(null,'2021-10-06','1.2','学习springboot+vue的前后分离开发模式');
-- insert into versions values(null,'2021-10-07','1.4','完成基础的CRUD');
-- insert into versions values(null,'2021-10-08','1.6','搭建页面布局');
-- insert into versions values(null,'2021-10-09','1.8','完善功能');
-- insert into versions values(null,'2021-10-10','1.9','集成天气，翻页');
-- insert into versions values(null,'2021-10-11','2.0','开发登录及注册');
-- insert into versions values(null,'2021-10-12','2.2','完善扩展数据库');
-- insert into versions values(null,'2021-10-13','2.2','开发个人信息主页');
-- insert into versions values(null,'2021-10-14','2.4','开发博客/留言本，集成富文本');
-- insert into versions values(null,'2021-10-15','2.6','增加验证码，集成图表');
