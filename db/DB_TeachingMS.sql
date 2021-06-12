/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 80023
 Source Host           : localhost:3306
 Source Schema         : DB_TeachingMS

 Target Server Type    : MySQL
 Target Server Version : 80023
 File Encoding         : 65001

 Date: 10/06/2021 11:26:11
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for TB_Admin
-- ----------------------------
DROP TABLE IF EXISTS `TB_Admin`;
CREATE TABLE `TB_Admin` (
  `AdminID` char(6) NOT NULL,
  `APassword` varchar(32) NOT NULL,
  PRIMARY KEY (`AdminID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of TB_Admin
-- ----------------------------
BEGIN;
INSERT INTO `TB_Admin` VALUES ('admin', 'admin');
COMMIT;

-- ----------------------------
-- Table structure for TB_Class
-- ----------------------------
DROP TABLE IF EXISTS `TB_Class`;
CREATE TABLE `TB_Class` (
  `ClassID` char(6) NOT NULL,
  `ClassName` char(20) NOT NULL,
  `DeptID` char(2) NOT NULL,
  `TeacherID` char(6) NOT NULL,
  PRIMARY KEY (`ClassID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of TB_Class
-- ----------------------------
BEGIN;
INSERT INTO `TB_Class` VALUES ('040201', '04机电(1)班', '02', 'T02001');
INSERT INTO `TB_Class` VALUES ('040801', '04网络(1)班', '08', 'T08001');
INSERT INTO `TB_Class` VALUES ('040802', '04网络(2)班', '08', 'T08002');
INSERT INTO `TB_Class` VALUES ('050302', '05电子(2)班', '03', 'T10005');
INSERT INTO `TB_Class` VALUES ('050801', '05软件(1)班', '08', 'T08003');
COMMIT;

-- ----------------------------
-- Table structure for TB_Course
-- ----------------------------
DROP TABLE IF EXISTS `TB_Course`;
CREATE TABLE `TB_Course` (
  `CourseID` char(6) NOT NULL,
  `CourseName` varchar(32) NOT NULL,
  `DeptID` char(2) NOT NULL,
  `CourseGrade` double NOT NULL DEFAULT (0),
  `LessonTime` smallint NOT NULL DEFAULT (0),
  `CourseOutline` text,
  PRIMARY KEY (`CourseID`),
  UNIQUE KEY `CourseName` (`CourseName`),
  CONSTRAINT `tb_course_chk_2` CHECK ((`CourseGrade` >= 0)),
  CONSTRAINT `tb_course_chk_3` CHECK ((`LessonTime` >= 0))
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of TB_Course
-- ----------------------------
BEGIN;
INSERT INTO `TB_Course` VALUES ('C07001', '中国剪纸艺术', '07', 2, 36, '传统艺术');
INSERT INTO `TB_Course` VALUES ('C08002', 'C语言程序设计', '08', 3, 54, NULL);
INSERT INTO `TB_Course` VALUES ('C08003', 'Flash动画制作', '08', 3, 54, '简单动画设计与制作');
INSERT INTO `TB_Course` VALUES ('C08004', '动态网页设计', '08', 2, 32, '构架一个自己的网站');
INSERT INTO `TB_Course` VALUES ('C10001', '曹雪芹与红楼梦', '10', 2, 36, NULL);
INSERT INTO `TB_Course` VALUES ('C10002', '歌唱艺术与欣赏', '10', 2, 32, NULL);
INSERT INTO `TB_Course` VALUES ('C10004', '吉他弹唱', '10', 2, 32, NULL);
INSERT INTO `TB_Course` VALUES ('C10005', '数学思想与方法', '10', 2, 36, NULL);
COMMIT;

-- ----------------------------
-- Table structure for TB_CourseClass
-- ----------------------------
DROP TABLE IF EXISTS `TB_CourseClass`;
CREATE TABLE `TB_CourseClass` (
  `CourseClassID` char(10) NOT NULL,
  `CourseID` char(6) NOT NULL,
  `TeacherID` char(6) NOT NULL,
  `TeachingYearID` char(4) NOT NULL,
  `TermID` char(2) NOT NULL,
  `TeachingPlace` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `TeachingTime` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `CommonPart` tinyint NOT NULL DEFAULT (10),
  `MiddlePart` tinyint NOT NULL DEFAULT (20),
  `LastPart` tinyint NOT NULL DEFAULT (70),
  `MaxNumber` smallint NOT NULL DEFAULT (60),
  `SelectedNumber` smallint NOT NULL DEFAULT (0),
  `FullFlag` char(1) NOT NULL DEFAULT (_utf8mb4'U'),
  PRIMARY KEY (`CourseClassID`),
  CONSTRAINT `CK_SumOfParts` CHECK ((((`CommonPart` + `MiddlePart`) + `LastPart`) = 100)),
  CONSTRAINT `tb_courseclass_chk_2` CHECK ((`CommonPart` >= 0)),
  CONSTRAINT `tb_courseclass_chk_3` CHECK ((`MiddlePart` >= 0)),
  CONSTRAINT `tb_courseclass_chk_4` CHECK ((`LastPart` >= 0)),
  CONSTRAINT `tb_courseclass_chk_5` CHECK ((`MaxNumber` >= 0)),
  CONSTRAINT `tb_courseclass_chk_6` CHECK ((`FullFlag` in (_utf8mb4'F',_utf8mb4'U')))
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of TB_CourseClass
-- ----------------------------
BEGIN;
INSERT INTO `TB_CourseClass` VALUES ('T070020401', 'C07001', 'T07002', '2004', 'T1', '4#102', '3:3-4,5:3-4', 40, 0, 60, 10, 10, 'F');
INSERT INTO `TB_CourseClass` VALUES ('T080010401', 'C08002', 'T08001', '2004', 'T1', '4#多媒体208', '1:3-4,3:1-2', 10, 20, 70, 10, 10, 'F');
INSERT INTO `TB_CourseClass` VALUES ('T080010402', 'C08002', 'T08001', '2004', 'T1', '4#普通教室208', '2:3-4,4:5-6', 10, 20, 70, 10, 10, 'F');
INSERT INTO `TB_CourseClass` VALUES ('T080030401', 'C08004', 'T08003', '2004', 'T2', '4#录播室304', '1:1-2,3:3-4', 60, 0, 40, 10, 10, 'F');
INSERT INTO `TB_CourseClass` VALUES ('T080040401', 'C08003', 'T08004', '2004', 'T2', '8#309', '2:3-4,4:5-6', 60, 0, 40, 8, 6, 'U');
INSERT INTO `TB_CourseClass` VALUES ('T100020401', 'C10004', 'T10002', '2004', 'T1', '10#208', '1:3-4,3:1-2', 50, 0, 50, 5, 2, 'U');
INSERT INTO `TB_CourseClass` VALUES ('T100020402', 'C10004', 'T10002', '2004', 'T1', '4#多媒体304', '2:7-8,4:7-8', 50, 0, 50, 10, 1, 'U');
INSERT INTO `TB_CourseClass` VALUES ('T100050401', 'C10001', 'T10005', '2004', 'T1', '10#202', '1:3-4,3:1-2', 100, 0, 0, 5, 3, 'U');
COMMIT;

-- ----------------------------
-- Table structure for TB_Dept
-- ----------------------------
DROP TABLE IF EXISTS `TB_Dept`;
CREATE TABLE `TB_Dept` (
  `DeptID` char(2) NOT NULL,
  `DeptName` char(20) NOT NULL,
  `DeptSetDate` char(5) DEFAULT NULL,
  `DeptScript` text NOT NULL,
  PRIMARY KEY (`DeptID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of TB_Dept
-- ----------------------------
BEGIN;
INSERT INTO `TB_Dept` VALUES ('02', '机电工程系', '1978', '略');
INSERT INTO `TB_Dept` VALUES ('03', '电子工程系', '1978', '略');
INSERT INTO `TB_Dept` VALUES ('05', '化纺工程系', '1978', '略');
INSERT INTO `TB_Dept` VALUES ('06', '外语系', '1998', '略');
INSERT INTO `TB_Dept` VALUES ('07', '艺术设计系', '1984', '略');
INSERT INTO `TB_Dept` VALUES ('08', '计算机系', '2002', '略');
INSERT INTO `TB_Dept` VALUES ('09', '管理系', '1978', '略');
INSERT INTO `TB_Dept` VALUES ('10', '基础部', '1978', '略');
INSERT INTO `TB_Dept` VALUES ('11', '体育部', '1996', '略');
COMMIT;

-- ----------------------------
-- Table structure for TB_Grade
-- ----------------------------
DROP TABLE IF EXISTS `TB_Grade`;
CREATE TABLE `TB_Grade` (
  `GradeSeedID` int NOT NULL AUTO_INCREMENT,
  `StuID` char(8) NOT NULL,
  `ClassID` char(6) NOT NULL,
  `CourseClassID` char(10) NOT NULL,
  `CourseID` char(6) NOT NULL,
  `CommonScore` double NOT NULL DEFAULT (0),
  `MiddleScore` double NOT NULL DEFAULT (0),
  `LastScore` double NOT NULL DEFAULT (0),
  `TotalScore` double NOT NULL DEFAULT (0),
  `RetestScore` double DEFAULT (0),
  `LockFlag` char(1) NOT NULL DEFAULT (_utf8mb4'U'),
  PRIMARY KEY (`GradeSeedID`),
  CONSTRAINT `tb_grade_chk_1` CHECK (((`CommonScore` >= 0) and (`CommonScore` <= 100))),
  CONSTRAINT `tb_grade_chk_2` CHECK (((`MiddleScore` >= 0) and (`MiddleScore` <= 100))),
  CONSTRAINT `tb_grade_chk_3` CHECK (((`LastScore` >= 0) and (`LastScore` <= 100))),
  CONSTRAINT `tb_grade_chk_4` CHECK (((`TotalScore` >= 0) and (`TotalScore` <= 100))),
  CONSTRAINT `tb_grade_chk_5` CHECK (((`RetestScore` >= 0) and (`RetestScore` <= 100))),
  CONSTRAINT `tb_grade_chk_6` CHECK ((`LockFlag` in (_utf8mb4'U',_utf8mb4'L')))
) ENGINE=InnoDB AUTO_INCREMENT=52 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of TB_Grade
-- ----------------------------
BEGIN;
INSERT INTO `TB_Grade` VALUES (1, '04080101', '040801', 'T080010401', 'C08002', 80, 60, 90, 83, 0, 'U');
INSERT INTO `TB_Grade` VALUES (2, '04080102', '040801', 'T080010401', 'C08002', 70, 70, 90, 84, 0, 'U');
INSERT INTO `TB_Grade` VALUES (3, '04080103', '040801', 'T080010401', 'C08002', 60, 60, 70, 67, 0, 'U');
INSERT INTO `TB_Grade` VALUES (4, '04080104', '040801', 'T080010401', 'C08002', 73, 81, 53, 49.462, 0, 'U');
INSERT INTO `TB_Grade` VALUES (5, '04080105', '040801', 'T080010401', 'C08002', 45, 66, 80, 70.1, 0, 'U');
INSERT INTO `TB_Grade` VALUES (6, '04080106', '040801', 'T080010401', 'C08002', 78, 72, 79, 77.5, 0, 'U');
INSERT INTO `TB_Grade` VALUES (7, '04080107', '040801', 'T080010401', 'C08002', 33, 86, 90, 83.5, 0, 'U');
INSERT INTO `TB_Grade` VALUES (8, '04080108', '040801', 'T080010401', 'C08002', 90, 98, 87, 89.5, 0, 'U');
INSERT INTO `TB_Grade` VALUES (9, '04080109', '040801', 'T080010401', 'C08002', 88, 69, 96, 89.8, 0, 'U');
INSERT INTO `TB_Grade` VALUES (10, '04080110', '040801', 'T080010401', 'C08002', 87, 90, 97, 94.6, 0, 'U');
INSERT INTO `TB_Grade` VALUES (11, '04080201', '040802', 'T080010402', 'C08002', 70, 83, 92, 88, 0, 'L');
INSERT INTO `TB_Grade` VALUES (12, '04080202', '040802', 'T080010402', 'C08002', 75, 63, 74, 71.9, 0, 'L');
INSERT INTO `TB_Grade` VALUES (13, '04080203', '040802', 'T080010402', 'C08002', 66, 84, 70, 72.4, 0, 'L');
INSERT INTO `TB_Grade` VALUES (14, '04080204', '040802', 'T080010402', 'C08002', 63, 77, 62, 65.1, 0, 'L');
INSERT INTO `TB_Grade` VALUES (15, '04080205', '040802', 'T080010402', 'C08002', 45, 66, 56, 56.9, 0, 'L');
INSERT INTO `TB_Grade` VALUES (16, '04080206', '040802', 'T080010402', 'C08002', 80, 72, 79, 77.7, 0, 'L');
INSERT INTO `TB_Grade` VALUES (17, '04080207', '040802', 'T080010402', 'C08002', 61, 66, 90, 82.3, 0, 'L');
INSERT INTO `TB_Grade` VALUES (18, '04080208', '040802', 'T080010402', 'C08002', 67, 78, 87, 83.2, 0, 'L');
INSERT INTO `TB_Grade` VALUES (19, '04080209', '040802', 'T080010402', 'C08002', 88, 69, 76, 75.8, 0, 'L');
INSERT INTO `TB_Grade` VALUES (20, '04080210', '040802', 'T080010402', 'C08002', 57, 72, 45, 51.6, 0, 'L');
INSERT INTO `TB_Grade` VALUES (21, '04080101', '040801', 'T070020401', 'C07001', 75, 0, 92, 85.2, 0, 'L');
INSERT INTO `TB_Grade` VALUES (22, '04080102', '040801', 'T070020401', 'C07001', 65, 0, 74, 70.4, 0, 'L');
INSERT INTO `TB_Grade` VALUES (23, '04080103', '040801', 'T070020401', 'C07001', 68, 0, 70, 69.2, 0, 'L');
INSERT INTO `TB_Grade` VALUES (24, '04080104', '040801', 'T070020401', 'C07001', 88, 0, 62, 71.4, 0, 'L');
INSERT INTO `TB_Grade` VALUES (25, '04080105', '040801', 'T070020401', 'C07001', 79, 0, 56, 65.2, 0, 'L');
INSERT INTO `TB_Grade` VALUES (26, '04080106', '040801', 'T070020401', 'C07001', 80, 0, 79, 79.4, 0, 'L');
INSERT INTO `TB_Grade` VALUES (27, '04080107', '040801', 'T070020401', 'C07001', 42, 0, 38, 38.2, 0, 'L');
INSERT INTO `TB_Grade` VALUES (28, '04080108', '040801', 'T070020401', 'C07001', 97, 0, 89, 92.2, 0, 'L');
INSERT INTO `TB_Grade` VALUES (29, '04080109', '040801', 'T070020401', 'C07001', 68, 0, 76, 73.4, 0, 'L');
INSERT INTO `TB_Grade` VALUES (30, '04080110', '040801', 'T070020401', 'C07001', 56, 0, 86, 74, 0, 'L');
INSERT INTO `TB_Grade` VALUES (31, '04080101', '040801', 'T080030401', 'C08004', 32, 0, 72, 48, 0, 'U');
INSERT INTO `TB_Grade` VALUES (32, '04080102', '040801', 'T080030401', 'C08004', 60, 0, 74, 73.6, 0, 'U');
INSERT INTO `TB_Grade` VALUES (33, '04080103', '040801', 'T080030401', 'C08004', 72, 0, 70, 71.2, 0, 'U');
INSERT INTO `TB_Grade` VALUES (34, '04080104', '040801', 'T080030401', 'C08004', 88, 0, 86, 87.2, 0, 'U');
INSERT INTO `TB_Grade` VALUES (35, '04080105', '040801', 'T080030401', 'C08004', 76, 0, 50, 65.6, 0, 'U');
INSERT INTO `TB_Grade` VALUES (36, '04080106', '040801', 'T080030401', 'C08004', 80, 0, 79, 79.6, 0, 'U');
INSERT INTO `TB_Grade` VALUES (37, '04080107', '040801', 'T080030401', 'C08004', 90, 0, 38, 67.2, 0, 'U');
INSERT INTO `TB_Grade` VALUES (38, '04080108', '040801', 'T080030401', 'C08004', 87, 0, 84, 85.8, 0, 'U');
INSERT INTO `TB_Grade` VALUES (39, '04080109', '040801', 'T080030401', 'C08004', 78, 0, 76, 77.2, 0, 'U');
INSERT INTO `TB_Grade` VALUES (40, '04080110', '040801', 'T080030401', 'C08004', 56, 0, 80, 65.6, 0, 'U');
INSERT INTO `TB_Grade` VALUES (41, '04080101', '040801', 'T080040401', 'C08003', 85, 0, 75, 81, 0, 'L');
INSERT INTO `TB_Grade` VALUES (42, '04020101', '040201', 'T080040401', 'C08003', 90, 0, 84, 87.6, 0, 'L');
INSERT INTO `TB_Grade` VALUES (43, '04020104', '040201', 'T080040401', 'C08003', 82, 0, 90, 85.2, 0, 'L');
INSERT INTO `TB_Grade` VALUES (44, '04080103', '040801', 'T080040401', 'C08003', 78, 0, 76, 77.2, 0, 'L');
INSERT INTO `TB_Grade` VALUES (45, '04080203', '040802', 'T080040401', 'C08003', 77, 0, 58, 69.4, 0, 'L');
INSERT INTO `TB_Grade` VALUES (46, '04080106', '040801', 'T080040401', 'C08003', 86, 0, 89, 87.2, 0, 'L');
INSERT INTO `TB_Grade` VALUES (47, '04080201', '040802', 'T100050401', 'C10001', 80, 0, 90, 84, 0, 'L');
INSERT INTO `TB_Grade` VALUES (48, '04080202', '040802', 'T100050401', 'C10001', 75, 0, 74, 74.6, 0, 'L');
INSERT INTO `TB_Grade` VALUES (49, '04020104', '040201', 'T100050401', 'C10001', 69, 0, 90, 77.4, 0, 'L');
INSERT INTO `TB_Grade` VALUES (50, '04080201', '040802', 'T100020401', 'C10004', 65, 0, 95, 83, 0, 'U');
INSERT INTO `TB_Grade` VALUES (51, '04080205', '040802', 'T100020401', 'C10004', 77, 0, 84, 81.2, 0, 'U');
COMMIT;

-- ----------------------------
-- Table structure for TB_SelectCourse
-- ----------------------------
DROP TABLE IF EXISTS `TB_SelectCourse`;
CREATE TABLE `TB_SelectCourse` (
  `StuID` char(8) NOT NULL,
  `CourseClassID` char(10) NOT NULL,
  `SelectDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`StuID`,`CourseClassID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of TB_SelectCourse
-- ----------------------------
BEGIN;
INSERT INTO `TB_SelectCourse` VALUES ('04020101', 'T080040401', '2021-03-23 09:13:24');
INSERT INTO `TB_SelectCourse` VALUES ('04020104', 'T080040401', '2021-03-23 09:13:24');
INSERT INTO `TB_SelectCourse` VALUES ('04020104', 'T100050401', '2021-03-23 09:13:38');
INSERT INTO `TB_SelectCourse` VALUES ('04020109', 'T100020402', '2021-03-23 09:13:49');
INSERT INTO `TB_SelectCourse` VALUES ('04080101', 'T070020401', '2021-03-23 09:12:49');
INSERT INTO `TB_SelectCourse` VALUES ('04080101', 'T080010401', '2021-03-23 09:11:43');
INSERT INTO `TB_SelectCourse` VALUES ('04080101', 'T080030401', '2021-03-23 09:13:03');
INSERT INTO `TB_SelectCourse` VALUES ('04080101', 'T080040401', '2021-03-23 09:13:24');
INSERT INTO `TB_SelectCourse` VALUES ('04080102', 'T070020401', '2021-03-23 09:12:49');
INSERT INTO `TB_SelectCourse` VALUES ('04080102', 'T080010401', '2021-03-23 09:11:58');
INSERT INTO `TB_SelectCourse` VALUES ('04080102', 'T080030401', '2021-03-23 09:13:03');
INSERT INTO `TB_SelectCourse` VALUES ('04080103', 'T070020401', '2021-03-23 09:12:49');
INSERT INTO `TB_SelectCourse` VALUES ('04080103', 'T080010401', '2021-03-23 09:11:58');
INSERT INTO `TB_SelectCourse` VALUES ('04080103', 'T080030401', '2021-03-23 09:13:03');
INSERT INTO `TB_SelectCourse` VALUES ('04080103', 'T080040401', '2021-03-23 09:13:24');
INSERT INTO `TB_SelectCourse` VALUES ('04080104', 'T070020401', '2021-03-23 09:12:49');
INSERT INTO `TB_SelectCourse` VALUES ('04080104', 'T080010401', '2021-03-23 09:11:58');
INSERT INTO `TB_SelectCourse` VALUES ('04080104', 'T080030401', '2021-03-23 09:13:03');
INSERT INTO `TB_SelectCourse` VALUES ('04080105', 'T070020401', '2021-03-23 09:12:49');
INSERT INTO `TB_SelectCourse` VALUES ('04080105', 'T080010401', '2021-03-23 09:11:58');
INSERT INTO `TB_SelectCourse` VALUES ('04080105', 'T080030401', '2021-03-23 09:13:03');
INSERT INTO `TB_SelectCourse` VALUES ('04080106', 'T070020401', '2021-03-23 09:12:49');
INSERT INTO `TB_SelectCourse` VALUES ('04080106', 'T080010401', '2021-03-23 09:11:58');
INSERT INTO `TB_SelectCourse` VALUES ('04080106', 'T080030401', '2021-03-23 09:13:03');
INSERT INTO `TB_SelectCourse` VALUES ('04080106', 'T080040401', '2021-03-23 09:13:24');
INSERT INTO `TB_SelectCourse` VALUES ('04080107', 'T070020401', '2021-03-23 09:12:49');
INSERT INTO `TB_SelectCourse` VALUES ('04080107', 'T080010401', '2021-03-23 09:11:58');
INSERT INTO `TB_SelectCourse` VALUES ('04080107', 'T080030401', '2021-03-23 09:13:03');
INSERT INTO `TB_SelectCourse` VALUES ('04080108', 'T070020401', '2021-03-23 09:12:49');
INSERT INTO `TB_SelectCourse` VALUES ('04080108', 'T080010401', '2021-03-23 09:11:58');
INSERT INTO `TB_SelectCourse` VALUES ('04080108', 'T080030401', '2021-03-23 09:13:03');
INSERT INTO `TB_SelectCourse` VALUES ('04080109', 'T070020401', '2021-03-23 09:12:49');
INSERT INTO `TB_SelectCourse` VALUES ('04080109', 'T080010401', '2021-03-23 09:11:58');
INSERT INTO `TB_SelectCourse` VALUES ('04080109', 'T080030401', '2021-03-23 09:13:03');
INSERT INTO `TB_SelectCourse` VALUES ('04080110', 'T070020401', '2021-03-23 09:12:49');
INSERT INTO `TB_SelectCourse` VALUES ('04080110', 'T080010401', '2021-03-23 09:11:59');
INSERT INTO `TB_SelectCourse` VALUES ('04080110', 'T080030401', '2021-03-23 09:13:04');
INSERT INTO `TB_SelectCourse` VALUES ('04080201', 'T080010402', '2021-03-23 09:12:23');
INSERT INTO `TB_SelectCourse` VALUES ('04080201', 'T100020401', '2021-03-23 09:13:38');
INSERT INTO `TB_SelectCourse` VALUES ('04080201', 'T100050401', '2021-03-23 09:13:38');
INSERT INTO `TB_SelectCourse` VALUES ('04080202', 'T080010402', '2021-03-23 09:12:23');
INSERT INTO `TB_SelectCourse` VALUES ('04080202', 'T100050401', '2021-03-23 09:13:38');
INSERT INTO `TB_SelectCourse` VALUES ('04080203', 'T080010402', '2021-03-23 09:12:23');
INSERT INTO `TB_SelectCourse` VALUES ('04080203', 'T080040401', '2021-03-23 09:13:24');
INSERT INTO `TB_SelectCourse` VALUES ('04080204', 'T080010402', '2021-03-23 09:12:23');
INSERT INTO `TB_SelectCourse` VALUES ('04080205', 'T080010402', '2021-03-23 09:12:23');
INSERT INTO `TB_SelectCourse` VALUES ('04080205', 'T100020401', '2021-03-23 09:13:38');
INSERT INTO `TB_SelectCourse` VALUES ('04080206', 'T080010402', '2021-03-23 09:12:23');
INSERT INTO `TB_SelectCourse` VALUES ('04080207', 'T080010402', '2021-03-23 09:12:23');
INSERT INTO `TB_SelectCourse` VALUES ('04080208', 'T080010402', '2021-03-23 09:12:23');
INSERT INTO `TB_SelectCourse` VALUES ('04080209', 'T080010402', '2021-03-23 09:12:23');
INSERT INTO `TB_SelectCourse` VALUES ('04080210', 'T080010402', '2021-03-23 09:12:25');
COMMIT;

-- ----------------------------
-- Table structure for TB_Spec
-- ----------------------------
DROP TABLE IF EXISTS `TB_Spec`;
CREATE TABLE `TB_Spec` (
  `SpecID` char(4) NOT NULL,
  `SpecName` char(20) NOT NULL,
  `DeptID` char(2) NOT NULL,
  `SpecScript` text NOT NULL,
  PRIMARY KEY (`SpecID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of TB_Spec
-- ----------------------------
BEGIN;
INSERT INTO `TB_Spec` VALUES ('0201', '机电一体化', '02', '略');
INSERT INTO `TB_Spec` VALUES ('0301', '应用电子技术', '03', '略');
INSERT INTO `TB_Spec` VALUES ('0801', '计算机网络技术', '08', '略');
INSERT INTO `TB_Spec` VALUES ('0802', '动漫设计', '08', '略');
INSERT INTO `TB_Spec` VALUES ('0803', '软件技术', '08', '略');
COMMIT;

-- ----------------------------
-- Table structure for TB_Student
-- ----------------------------
DROP TABLE IF EXISTS `TB_Student`;
CREATE TABLE `TB_Student` (
  `StuID` char(8) NOT NULL,
  `StuName` char(8) NOT NULL,
  `EnrollYear` char(4) NOT NULL,
  `GradYear` char(4) NOT NULL,
  `DeptID` char(2) NOT NULL,
  `ClassID` char(6) NOT NULL,
  `Sex` char(1) NOT NULL DEFAULT (_utf8mb4'M'),
  `Birthday` timestamp NOT NULL,
  `SPassword` varchar(32) NOT NULL DEFAULT (_utf8mb4'123456'),
  `StuAddress` varchar(64) NOT NULL,
  `ZipCode` char(6) NOT NULL,
  PRIMARY KEY (`StuID`),
  CONSTRAINT `tb_student_chk_4` CHECK ((`Sex` in (_utf8mb4'M',_utf8mb4'F')))
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of TB_Student
-- ----------------------------
BEGIN;
INSERT INTO `TB_Student` VALUES ('04020101', '周灵灵', '2004', '2007', '02', '040201', 'F', '1984-12-12 00:00:00', '123456', '略', '214400');
INSERT INTO `TB_Student` VALUES ('04020102', '余红燕', '2004', '2007', '02', '040201', 'F', '1985-12-06 00:00:00', '123456', '略', '214400');
INSERT INTO `TB_Student` VALUES ('04020103', '左秋霞', '2004', '2007', '02', '040201', 'F', '1985-05-01 00:00:00', '123456', '略', '214400');
INSERT INTO `TB_Student` VALUES ('04020104', '汪德荣', '2004', '2007', '02', '040201', 'M', '1984-12-13 00:00:00', '123456', '略', '214400');
INSERT INTO `TB_Student` VALUES ('04020105', '刘成波', '2004', '2007', '02', '040201', 'M', '1984-07-04 00:00:00', '123456', '略', '214400');
INSERT INTO `TB_Student` VALUES ('04020106', '郭昌盛', '2004', '2007', '02', '040201', 'M', '1984-04-16 00:00:00', '123456', '略', '214400');
INSERT INTO `TB_Student` VALUES ('04020107', '陈玲玲', '2004', '2007', '02', '040201', 'F', '1984-10-18 00:00:00', '123456', '略', '214400');
INSERT INTO `TB_Student` VALUES ('04020108', '周炳才', '2004', '2007', '02', '040201', 'M', '1986-01-22 00:00:00', '123456', '略', '214400');
INSERT INTO `TB_Student` VALUES ('04020109', '李克寅', '2004', '2007', '02', '040201', 'F', '1985-02-19 00:00:00', '123456', '略', '214400');
INSERT INTO `TB_Student` VALUES ('04020110', '刘争艳', '2004', '2007', '02', '040201', 'M', '1984-08-18 00:00:00', '123456', '略', '214400');
INSERT INTO `TB_Student` VALUES ('04080101', '任正非', '2004', '2007', '08', '040801', 'M', '1984-01-10 00:00:00', '123456', '略', '214400');
INSERT INTO `TB_Student` VALUES ('04080102', '王倩', '2004', '2007', '08', '040801', 'F', '1985-05-16 00:00:00', '123456', '略', '214400');
INSERT INTO `TB_Student` VALUES ('04080103', '戴丽', '2004', '2007', '08', '040801', 'F', '1984-12-01 00:00:00', '123456', '略', '214400');
INSERT INTO `TB_Student` VALUES ('04080104', '孙军团', '2004', '2007', '08', '040801', 'M', '1983-02-03 00:00:00', '123456', '略', '214400');
INSERT INTO `TB_Student` VALUES ('04080105', '郑志', '2004', '2007', '08', '040801', 'M', '1986-11-04 00:00:00', '123456', '略', '214400');
INSERT INTO `TB_Student` VALUES ('04080106', '龚玲玲', '2004', '2007', '08', '040801', 'F', '1984-11-10 00:00:00', '123456', '略', '214400');
INSERT INTO `TB_Student` VALUES ('04080107', '李铁', '2004', '2007', '08', '040801', 'M', '1985-01-08 00:00:00', '123456', '略', '214400');
INSERT INTO `TB_Student` VALUES ('04080108', '戴安娜', '2004', '2007', '08', '040801', 'F', '1984-12-22 00:00:00', '123456', '略', '214400');
INSERT INTO `TB_Student` VALUES ('04080109', '陈淋淋', '2004', '2007', '08', '040801', 'F', '1985-03-19 00:00:00', '123456', '略', '214400');
INSERT INTO `TB_Student` VALUES ('04080110', '司马光', '2004', '2007', '08', '040801', 'M', '1984-08-03 00:00:00', '123456', '略', '214400');
INSERT INTO `TB_Student` VALUES ('04080201', '张金玲', '2004', '2007', '08', '040802', 'F', '1984-03-26 00:00:00', '123456', '略', '214400');
INSERT INTO `TB_Student` VALUES ('04080202', '王婷婷', '2004', '2007', '08', '040802', 'F', '1985-04-12 00:00:00', '123456', '略', '211900');
INSERT INTO `TB_Student` VALUES ('04080203', '石江安', '2004', '2007', '08', '040802', 'M', '1984-11-01 00:00:00', '123456', '江苏省宝应市虹彩小区2幢101', '225800');
INSERT INTO `TB_Student` VALUES ('04080204', '陈建伟', '2004', '2007', '08', '040802', 'M', '1984-12-13 00:00:00', '123456', '江苏省大丰市黄林乡五村56号', '224200');
INSERT INTO `TB_Student` VALUES ('04080205', '袁中标', '2004', '2007', '08', '040802', 'M', '1985-10-04 00:00:00', '123456', '安徽省芜湖市笆斗街60号', '241000');
INSERT INTO `TB_Student` VALUES ('04080206', '崔莎莎', '2004', '2007', '08', '040802', 'F', '1984-04-10 00:00:00', '123456', '略', '244100');
INSERT INTO `TB_Student` VALUES ('04080207', '丁承华', '2004', '2007', '08', '040802', 'M', '1985-11-18 00:00:00', '123456', '略', '311200');
INSERT INTO `TB_Student` VALUES ('04080208', '刘颖', '2004', '2007', '08', '040802', 'F', '1986-02-22 00:00:00', '123456', '江苏省江阴市虹桥一村7幢201', '214400');
INSERT INTO `TB_Student` VALUES ('04080209', '刘玉芹', '2004', '2007', '08', '040802', 'F', '1985-08-09 00:00:00', '123456', '略', '214400');
INSERT INTO `TB_Student` VALUES ('04080210', '韦涛', '2004', '2007', '08', '040802', 'M', '1985-03-06 00:00:00', '123456', '安徽省界首市河北乡新黄村31号', '236500');
INSERT INTO `TB_Student` VALUES ('05030201', '刘惠凤', '2005', '2008', '03', '050302', 'F', '1986-08-12 00:00:00', '123456', '略', '214400');
INSERT INTO `TB_Student` VALUES ('05030202', '孙嘉珍', '2005', '2008', '03', '050302', 'F', '1987-12-06 00:00:00', '123456', '略', '214400');
INSERT INTO `TB_Student` VALUES ('05030203', '单瑞中', '2005', '2008', '03', '050302', 'M', '1985-12-11 00:00:00', '123456', '略', '214400');
INSERT INTO `TB_Student` VALUES ('05030204', '陈颂', '2005', '2008', '03', '050302', 'M', '1986-12-03 00:00:00', '123456', '略', '214400');
INSERT INTO `TB_Student` VALUES ('05030205', '包学诚', '2005', '2008', '03', '050302', 'M', '1985-07-04 00:00:00', '123456', '略', '214400');
INSERT INTO `TB_Student` VALUES ('05030206', '胡春霞', '2005', '2008', '03', '050302', 'F', '1985-05-19 00:00:00', '123456', '略', '214400');
INSERT INTO `TB_Student` VALUES ('05030207', '贾彩丽', '2005', '2008', '03', '050302', 'F', '1985-09-08 00:00:00', '123456', '略', '214400');
INSERT INTO `TB_Student` VALUES ('05030208', '高文欢', '2005', '2008', '03', '050302', 'M', '1987-12-02 00:00:00', '123456', '略', '214400');
INSERT INTO `TB_Student` VALUES ('05030209', '沈伟', '2005', '2008', '03', '050302', 'F', '1986-02-09 00:00:00', '123456', '略', '214400');
INSERT INTO `TB_Student` VALUES ('05030210', '马霞', '2005', '2008', '03', '050302', 'M', '1986-08-18 00:00:00', '123456', '略', '214400');
INSERT INTO `TB_Student` VALUES ('05080101', '李娟娟', '2005', '2008', '08', '050801', 'F', '1985-07-08 00:00:00', '123456', '略', '214400');
INSERT INTO `TB_Student` VALUES ('05080102', '刘晓燕', '2005', '2008', '08', '050801', 'F', '1986-06-06 00:00:00', '123456', '略', '214400');
INSERT INTO `TB_Student` VALUES ('05080103', '高原', '2005', '2008', '08', '050801', 'M', '1985-01-11 00:00:00', '123456', '略', '214400');
INSERT INTO `TB_Student` VALUES ('05080104', '毛振兴', '2005', '2008', '08', '050801', 'M', '1985-02-13 00:00:00', '123456', '略', '214400');
INSERT INTO `TB_Student` VALUES ('05080105', '陈立', '2005', '2008', '08', '050801', 'M', '1985-06-24 00:00:00', '123456', '略', '214400');
INSERT INTO `TB_Student` VALUES ('05080106', '朱凤', '2005', '2008', '08', '050801', 'F', '1985-04-10 00:00:00', '123456', '略', '214400');
INSERT INTO `TB_Student` VALUES ('05080107', '王小丽', '2005', '2008', '08', '050801', 'F', '1985-10-08 00:00:00', '123456', '略', '214400');
INSERT INTO `TB_Student` VALUES ('05080108', '曹勇', '2005', '2008', '08', '050801', 'M', '1986-12-22 00:00:00', '123456', '略', '214400');
INSERT INTO `TB_Student` VALUES ('05080109', '赵启悦', '2005', '2008', '08', '050801', 'F', '1985-12-09 00:00:00', '123456', '略', '214400');
INSERT INTO `TB_Student` VALUES ('05080110', '石慧', '2005', '2008', '08', '050801', 'M', '1986-08-08 00:00:00', '123456', '略', '214400');
COMMIT;

-- ----------------------------
-- Table structure for TB_Teacher
-- ----------------------------
DROP TABLE IF EXISTS `TB_Teacher`;
CREATE TABLE `TB_Teacher` (
  `TeacherID` char(6) NOT NULL,
  `TeacherName` char(8) NOT NULL,
  `DeptID` char(2) NOT NULL,
  `Sex` char(1) NOT NULL DEFAULT (_utf8mb4'M'),
  `Birthday` char(13) DEFAULT NULL,
  `TPassword` varchar(32) NOT NULL DEFAULT (_utf8mb4'123456'),
  `TitleID` char(2) NOT NULL,
  PRIMARY KEY (`TeacherID`),
  CONSTRAINT `tb_teacher_chk_2` CHECK ((`Sex` in (_utf8mb4'M',_utf8mb4'F')))
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of TB_Teacher
-- ----------------------------
BEGIN;
INSERT INTO `TB_Teacher` VALUES ('T02001', '程靖', '02', 'F', '1974-8-27', '123456', 'T2');
INSERT INTO `TB_Teacher` VALUES ('T07002', '沈丽', '07', 'M', '1976-6-6', '123456', 'T1');
INSERT INTO `TB_Teacher` VALUES ('T08001', '陈玲', '08', 'F', '1968-12-2', '123456', 'T3');
INSERT INTO `TB_Teacher` VALUES ('T08002', '李琳分', '08', 'M', '1972-10-10', '123456', 'T3');
INSERT INTO `TB_Teacher` VALUES ('T08003', '龙永图', '08', 'M', '1976-6-23', '123456', 'T2');
INSERT INTO `TB_Teacher` VALUES ('T08004', '黄三清', '08', 'F', '1983-7-13', '123456', 'T1');
INSERT INTO `TB_Teacher` VALUES ('T08005', '韩汉', '08', 'M', '1956-3-18', '123456', 'T4');
INSERT INTO `TB_Teacher` VALUES ('T10002', '沈天一', '10', 'F', '1970-11-16', '123456', 'T3');
INSERT INTO `TB_Teacher` VALUES ('T10005', '曾远', '10', 'M', '1986-6-3', '123456', 'T1');
COMMIT;

-- ----------------------------
-- Table structure for TB_TeachingYear
-- ----------------------------
DROP TABLE IF EXISTS `TB_TeachingYear`;
CREATE TABLE `TB_TeachingYear` (
  `TeachingYearID` char(4) NOT NULL,
  `TeachingYearName` char(11) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`TeachingYearID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of TB_TeachingYear
-- ----------------------------
BEGIN;
INSERT INTO `TB_TeachingYear` VALUES ('2004', '2004-2005学年');
INSERT INTO `TB_TeachingYear` VALUES ('2005', '2005-2006学年');
INSERT INTO `TB_TeachingYear` VALUES ('2006', '2006-2007学年');
INSERT INTO `TB_TeachingYear` VALUES ('2007', '2007-2008学年');
INSERT INTO `TB_TeachingYear` VALUES ('2008', '2008-2009学年');
COMMIT;

-- ----------------------------
-- Table structure for TB_Term
-- ----------------------------
DROP TABLE IF EXISTS `TB_Term`;
CREATE TABLE `TB_Term` (
  `TermID` char(2) NOT NULL,
  `TermName` char(8) NOT NULL,
  PRIMARY KEY (`TermID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of TB_Term
-- ----------------------------
BEGIN;
INSERT INTO `TB_Term` VALUES ('T1', '第一学期');
INSERT INTO `TB_Term` VALUES ('T2', '第二学期');
INSERT INTO `TB_Term` VALUES ('T3', '第三学期');
INSERT INTO `TB_Term` VALUES ('T4', '第四学期');
INSERT INTO `TB_Term` VALUES ('T5', '第五学期');
INSERT INTO `TB_Term` VALUES ('T6', '第六学期');
COMMIT;

-- ----------------------------
-- Table structure for TB_Title
-- ----------------------------
DROP TABLE IF EXISTS `TB_Title`;
CREATE TABLE `TB_Title` (
  `TitleID` char(2) NOT NULL,
  `TitleName` char(8) NOT NULL,
  PRIMARY KEY (`TitleID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of TB_Title
-- ----------------------------
BEGIN;
INSERT INTO `TB_Title` VALUES ('T1', '助教');
INSERT INTO `TB_Title` VALUES ('T2', '讲师');
INSERT INTO `TB_Title` VALUES ('T3', '副教授');
INSERT INTO `TB_Title` VALUES ('T4', '教授');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
