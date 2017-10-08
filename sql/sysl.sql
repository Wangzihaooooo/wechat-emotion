/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50628
Source Host           : localhost:3306
Source Database       : dachuang

Target Server Type    : MYSQL
Target Server Version : 50628
File Encoding         : 65001

Date: 2017-10-08 16:12:23
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for recg_tag
-- ----------------------------
DROP TABLE IF EXISTS `recg_tag`;
CREATE TABLE `recg_tag` (
`TAG_ID_`  int(8) NOT NULL COMMENT '标签id' ,
`TAG_CONTEXT_`  varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '标签内容' ,
PRIMARY KEY (`TAG_ID_`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='情绪标签表'

;

-- ----------------------------
-- Records of recg_tag
-- ----------------------------
BEGIN;
INSERT INTO `recg_tag` VALUES ('1', '生气'), ('2', '开心'), ('3', '中性'), ('4', '伤心');
COMMIT;

-- ----------------------------
-- Table structure for recg_tag_relation
-- ----------------------------
DROP TABLE IF EXISTS `recg_tag_relation`;
CREATE TABLE `recg_tag_relation` (
`TAG_ID_`  int(8) NOT NULL COMMENT '用户id' ,
`SONG_ID_`  int(8) NOT NULL COMMENT '音乐id' ,
INDEX `recgtag_tagID` (`TAG_ID_`) USING BTREE ,
INDEX `recgtag_sonfID` (`SONG_ID_`) USING BTREE 
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='标签映射表'

;

-- ----------------------------
-- Records of recg_tag_relation
-- ----------------------------
BEGIN;
INSERT INTO `recg_tag_relation` VALUES ('3', '992148'), ('3', '941288'), ('3', '966961'), ('3', '9672613'), ('3', '9692032'), ('3', '9693460'), ('3', '9697048'), ('3', '7274555'), ('2', '497280'), ('1', '7321711'), ('0', '14496972'), ('3', '7281913'), ('1', '400498'), ('2', '8203492'), ('0', '809875'), ('0', '815523'), ('0', '8192292'), ('0', '8216756'), ('0', '8254176'), ('0', '8273053'), ('0', '832082'), ('0', '8369596'), ('0', '8695123'), ('0', '8698474'), ('0', '8705804'), ('0', '8710473'), ('0', '879787'), ('0', '8852517'), ('0', '9069877'), ('0', '9143474'), ('0', '923756'), ('0', '924201'), ('0', '9334697'), ('0', '992202'), ('0', '120998527'), ('0', '121001284'), ('0', '31451542'), ('0', '120906176');
COMMIT;

-- ----------------------------
-- Table structure for spider_album
-- ----------------------------
DROP TABLE IF EXISTS `spider_album`;
CREATE TABLE `spider_album` (
`ALBUM_ID_`  int(8) NOT NULL COMMENT '专辑id' ,
`ALBUM_TITLE_`  varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '专辑名' ,
PRIMARY KEY (`ALBUM_ID_`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='专辑表'

;

-- ----------------------------
-- Records of spider_album
-- ----------------------------
BEGIN;
INSERT INTO `spider_album` VALUES ('65015', '《OK》'), ('70235', '《永远的未央歌 ..》'), ('104404', '《地球其实没有..》'), ('106027', '《苏醒》'), ('125389', '《不只深情 苏有朋》'), ('130828', '《Oncoming》'), ('131986', '《不孤单》'), ('134126', '《What My Hear..》'), ('146938', '《To Find Love》'), ('174167', '《Happy Girl》'), ('179508', '《最初的梦想》'), ('195964', '《遇见》'), ('429705', '《Pop Princess》'), ('496937', '《The Singles C..》'), ('1057849', '《Chris Brown》'), ('1133237', '《Spin》'), ('5669377', '《Grown & Sexy》'), ('5731237', '《Traveling Light》'), ('7273364', '《蒙娜丽莎的眼泪》'), ('7274271', '《我的秘密情人 ..》'), ('7311631', '《C\'Est La V》'), ('7390113', '《How To Save..》'), ('8192274', '《One Man》'), ('8203316', '《Xan Valleys》'), ('8253383', '《Single White F..》'), ('8693177', '《What\'S A Man..》'), ('8756499', '《The Woodsto..》'), ('9070321', '《原色》'), ('9334582', '《4 Seasons In ..》'), ('9635222', '《Invincible》'), ('9636021', '《The Ultimate ..》'), ('31451534', '《Truth Of Touch》'), ('120905271', '《经典双电子琴-..》'), ('120998121', '《世界古典音乐4》'), ('121000251', '《双电子琴-琴之恋3》');
COMMIT;

-- ----------------------------
-- Table structure for spider_music
-- ----------------------------
DROP TABLE IF EXISTS `spider_music`;
CREATE TABLE `spider_music` (
`MUSIC_ID_`  int(8) NOT NULL AUTO_INCREMENT COMMENT '音乐ID' ,
`SONG_ID_`  int(8) NOT NULL COMMENT '歌曲在数据库的ID' ,
`SINGER_ID_`  int(8) NULL DEFAULT NULL COMMENT '歌手ID' ,
`ALBUM_ID_`  int(8) NULL DEFAULT NULL COMMENT '专辑ID' ,
PRIMARY KEY (`MUSIC_ID_`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='音乐信息表'
AUTO_INCREMENT=1044

;

-- ----------------------------
-- Records of spider_music
-- ----------------------------
BEGIN;
INSERT INTO `spider_music` VALUES ('1006', '992148', '1192', '70235'), ('1007', '941288', '1090', '131986'), ('1008', '966961', '82402', '174167'), ('1009', '9672613', '83626', '9635222'), ('1010', '9692032', '177829', '9636021'), ('1011', '9693460', '177829', '9636021'), ('1012', '9697048', '177829', '9636021'), ('1013', '7274555', '83561', '7273364'), ('1014', '497280', '11720', '496937'), ('1015', '7321711', '9867', '7311631'), ('1016', '14496972', '1142', '65015'), ('1017', '7281913', '6042', '7274271'), ('1018', '400498', '1571', '104404'), ('1019', '8203492', '871895', '8203316'), ('1020', '809875', '1160', '130828'), ('1021', '815523', '1090', '106027'), ('1022', '8192292', '675325', '8192274'), ('1023', '8216756', '1113727', '5731237'), ('1024', '8254176', '720759', '8253383'), ('1025', '8273053', '200427', '429705'), ('1026', '832082', '1182', '195964'), ('1027', '8369596', '104675', '1057849'), ('1028', '8695123', '104684', '5669377'), ('1029', '8698474', '104684', '5669377'), ('1030', '8705804', '832577', '8693177'), ('1031', '8710473', '8206', '1133237'), ('1032', '879787', '177950', '7390113'), ('1033', '8852517', '11714', '8756499'), ('1034', '9069877', '8477', '9070321'), ('1035', '9143474', '819889', '134126'), ('1036', '923756', '1119', '179508'), ('1037', '924201', '2291', '146938'), ('1038', '9334697', '9741', '9334582'), ('1039', '992202', '2510', '125389'), ('1040', '120998527', '239562591', '120998121'), ('1041', '121001284', '239562536', '121000251'), ('1042', '31451542', '4018', '31451534'), ('1043', '120906176', '239562544', '120905271');
COMMIT;

-- ----------------------------
-- Table structure for spider_music_collection
-- ----------------------------
DROP TABLE IF EXISTS `spider_music_collection`;
CREATE TABLE `spider_music_collection` (
`RECORD_ID_`  int(8) NOT NULL AUTO_INCREMENT COMMENT '记录id' ,
`USER_ID_`  int(8) NOT NULL COMMENT '用户id' ,
`MUSIC_ID_`  int(8) NOT NULL COMMENT '音乐id' ,
`DATE_`  datetime NOT NULL ,
PRIMARY KEY (`RECORD_ID_`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='歌曲收藏表'
AUTO_INCREMENT=1

;

-- ----------------------------
-- Records of spider_music_collection
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for spider_singer
-- ----------------------------
DROP TABLE IF EXISTS `spider_singer`;
CREATE TABLE `spider_singer` (
`SINGER_ID_`  int(8) NOT NULL COMMENT '歌手id' ,
`SINGER_NAME_`  varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '歌手名字' ,
PRIMARY KEY (`SINGER_ID_`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='歌手表'

;

-- ----------------------------
-- Records of spider_singer
-- ----------------------------
BEGIN;
INSERT INTO `spider_singer` VALUES ('1090', '王杰'), ('1119', '范玮琪'), ('1142', '张震岳'), ('1160', '关智斌'), ('1182', '蔡琴'), ('1192', '齐豫'), ('1571', '谢和弦'), ('2291', '梁洛施'), ('2510', '苏有朋'), ('4018', 'Yanni'), ('6042', '言承旭'), ('8206', 'Darren Hayes'), ('8477', '杨宗纬'), ('9741', '卢巧音'), ('9867', '吴建豪'), ('11714', 'Lenka'), ('11720', 'Britney Spears'), ('82402', '陈慧琳'), ('83561', '林志炫'), ('83626', 'Michael Jackson'), ('104675', 'Chris Brown'), ('104684', 'Babyface'), ('177829', 'Michael Bolton'), ('177950', 'The Fray'), ('200427', 'Busted'), ('675325', 'Tank'), ('720759', 'Chely Wright'), ('819889', 'Gareth Gates'), ('832577', 'Frankie J'), ('871895', 'Klaxons'), ('1113727', 'Courtney Jaye'), ('239562536', '余晖&林建明'), ('239562544', '于波&蕾蕾'), ('239562591', '新雅室内乐');
COMMIT;

-- ----------------------------
-- Table structure for spider_song
-- ----------------------------
DROP TABLE IF EXISTS `spider_song`;
CREATE TABLE `spider_song` (
`SONG_ID_`  int(8) NOT NULL COMMENT '歌曲在数据库的id' ,
`SONG_TITLE_`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '歌名' ,
`SONG_PIC_`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '歌曲图片链接' ,
`SONG_DIR_`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '歌曲目录位置' ,
PRIMARY KEY (`SONG_ID_`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='歌曲表'

;

-- ----------------------------
-- Records of spider_song
-- ----------------------------
BEGIN;
INSERT INTO `spider_song` VALUES ('400498', '地球其实没有那么危险', 'http://musicdata.baidu.com/data2/pic/86420577/86420577.jpg@s_0,w_300', 'http://localhost:8080/地球其实没有那么危险.mp3'), ('497280', 'Circus', 'http://musicdata.baidu.com/data2/pic/115091818/115091818.jpg@s_0,w_300', 'http://localhost:8080/Circus.mp3'), ('809875', '分手不要太悲哀', 'http://musicdata.baidu.com/data2/music/95E906390CC6ECF82664CD92AAA8F36E/252052530/252052530.jpg@s_0,w_300', 'http://localhost:8080/分手不要太悲哀.mp3'), ('815523', '无声电影', 'http://musicdata.baidu.com/data2/pic/246709740/246709740.jpg@s_0,w_300', 'http://localhost:8080/无声电影.mp3'), ('832082', '张三的歌', 'http://musicdata.baidu.com/data2/pic/246584689/246584689.jpg@s_0,w_300', 'http://localhost:8080/张三的歌.mp3'), ('879787', 'How To Save A Life', 'http://musicdata.baidu.com/data2/music/914E14E3125CAC7FCB0867CAC4A6D988/252496620/252496620.jpg@s_0,w_300', 'http://localhost:8080/How To Save A Life.mp3'), ('923756', '启程', 'http://musicdata.baidu.com/data2/pic/246707511/246707511.jpg@s_0,w_300', 'http://localhost:8080/启程.mp3'), ('924201', '有鬼', 'http://musicdata.baidu.com/data2/music/23A47F795872C039843B2392C91CF81E/252165729/252165729.jpg@s_0,w_300', 'http://localhost:8080/有鬼.mp3'), ('941288', '真空', 'http://musicdata.baidu.com/data2/pic/246709740/246709740.jpg@s_0,w_300', 'http://localhost:8080/真空.mp3'), ('966961', '面红', 'http://musicdata.baidu.com/data2/pic/246669703/246669703.jpg@s_0,w_300', 'http://localhost:8080/面红.mp3'), ('992148', '摇篮曲', 'http://musicdata.baidu.com/data2/music/94C77FAADE0A19B3487A949A281F6DEE/252052234/252052234.jpg@s_0,w_300', 'http://localhost:8080/摇篮曲.mp3'), ('992202', '我的好心情', 'http://musicdata.baidu.com/data2/music/A0E54B76B458B86B13A61FF5623C1AD4/252052090/252052090.jpg@s_0,w_300', 'http://localhost:8080/我的好心情.mp3'), ('7274555', '蒙娜丽莎的眼泪', 'http://musicdata.baidu.com/data2/pic/3ba8c8d1a2c7ef3bcfa8f747ae1a7b6c/7273364/7273364.jpg@s_1,w_300,h_300', 'http://localhost:8080/蒙娜丽莎的眼泪.mp3'), ('7281913', '地心引力', 'http://musicdata.baidu.com/data2/music/A73E1526D08BE04AE97C4CEF87D6764B/252468660/252468660.jpg@s_0,w_300', 'http://localhost:8080/地心引力.mp3'), ('7321711', 'Is This All', 'http://musicdata.baidu.com/data2/pic/815d69b83419b6cc5ae6d5e744b48abe/277292599/277292599.jpeg@s_0,w_300', 'http://localhost:8080/Is This All.mp3'), ('8192292', 'I Still Believe', 'http://musicdata.baidu.com/data2/pic/246669568/246669568.jpg@s_0,w_300', 'http://localhost:8080/I Still Believe.mp3'), ('8203492', 'Atlantis To Interzone', 'http://musicdata.baidu.com/data2/music/9A9D91ACA5AADE22A536D24B9E515E0C/252119725/252119725.jpg@s_0,w_300', 'http://localhost:8080/Atlantis To Interzone.mp3'), ('8216756', 'Traveling Light', 'http://musicdata.baidu.com/data2/music/B407ED8BE515E8C4B32CA5CF9E12028B/252646262/252646262.jpg@s_0,w_300', 'http://localhost:8080/Traveling Light.mp3'), ('8254176', 'Unknown', 'http://musicdata.baidu.com/data2/music/94267B5593400DC472D32AC60A76ED5C/252079165/252079165.jpg@s_0,w_300', 'http://localhost:8080/Unknown.mp3'), ('8273053', 'Year 3000', 'http://musicdata.baidu.com/data2/music/89FCC3D2C5CF006F48F0AA1E479D8E3B/252132627/252132627.jpg@s_0,w_300', 'http://localhost:8080/Year 3000.mp3'), ('8369596', 'Gimme That', 'http://musicdata.baidu.com/data2/pic/86399523/86399523.jpg@s_0,w_300', 'http://localhost:8080/Gimme That.mp3'), ('8695123', 'She', 'http://musicdata.baidu.com/data2/music/4251672FFB9F82F4A2758641AD581FD9/252458809/252458809.jpg@s_0,w_300', 'http://localhost:8080/She.mp3'), ('8698474', 'Tonight It\'S Goin\' Down', 'http://musicdata.baidu.com/data2/music/4251672FFB9F82F4A2758641AD581FD9/252458809/252458809.jpg@s_0,w_300', 'http://localhost:8080/Tonight It\'S Goin\' Down.mp3'), ('8705804', 'Wanna Know', 'http://musicdata.baidu.com/data2/music/7D08BA2230EE583127F523378135C295/252140510/252140510.jpg@s_0,w_300', 'http://localhost:8080/Wanna Know.mp3'), ('8710473', 'I Miss You', 'http://musicdata.baidu.com/data2/music/AEA58E2C110A756A8830D385E09FEC86/252133328/252133328.jpg@s_0,w_300', 'http://localhost:8080/I Miss You.mp3'), ('8852517', 'We Will Not Grow Old', 'http://musicdata.baidu.com/data2/pic/86424777/86424777.jpg@s_0,w_300', 'http://localhost:8080/We Will Not Grow Old.mp3'), ('9069877', '被遗忘的', 'http://musicdata.baidu.com/data2/pic/246669483/246669483.jpg@s_0,w_300', 'http://localhost:8080/被遗忘的.mp3'), ('9143474', 'Tell Me One More Time', 'http://musicdata.baidu.com/data2/music/A25FD6329C46AC9291AAF708B79AE8D2/252385470/252385470.jpg@s_0,w_300', 'http://localhost:8080/Tell Me One More Time.mp3'), ('9334697', '恋爱很远', 'http://musicdata.baidu.com/data2/pic/86380337/86380337.jpg@s_0,w_300', 'http://localhost:8080/恋爱很远.mp3'), ('9672613', 'Break Of Dawn', 'http://musicdata.baidu.com/data2/pic/246937288/246937288.jpg@s_0,w_300', 'http://localhost:8080/Break Of Dawn.mp3'), ('9692032', 'Lean On Me', 'http://musicdata.baidu.com/data2/music/56DB3D9821280C5DE792ABFF3881585A/252377643/252377643.jpg@s_0,w_300', 'http://localhost:8080/Lean On Me.mp3'), ('9693460', 'When A Man Loves A Woman', 'http://musicdata.baidu.com/data2/music/56DB3D9821280C5DE792ABFF3881585A/252377643/252377643.jpg@s_0,w_300', 'http://localhost:8080/When A Man Loves A Woman.mp3'), ('9697048', 'Said I Loved You...But I Lied', 'http://musicdata.baidu.com/data2/music/56DB3D9821280C5DE792ABFF3881585A/252377643/252377643.jpg@s_0,w_300', 'http://localhost:8080/Said I Loved You...But I Lied.mp3'), ('14496972', '小宇', 'http://musicdata.baidu.com/data2/pic/001bfa11973318d5dabe167acac00192/65015/65015.jpg@s_1,w_300,h_300', 'http://localhost:8080/小宇.mp3'), ('31451542', 'Voyage', 'http://musicdata.baidu.com/data2/pic/1c22bd6b878666680877b767c252ac9c/540804793/540804793.jpg@s_0,w_300', 'http://localhost:8080/Voyage.mp3'), ('120906176', '真的好想你', '', 'http://localhost:8080/真的好想你.mp3'), ('120998527', '月光曲-德彪西', 'http://musicdata.baidu.com/data2/pic/63cde58f65ba517dff875f6b0a3a8585/551547323/551547323.jpg@s_1,w_300,h_300', 'http://localhost:8080/月光曲-德彪西.mp3'), ('121001284', '小城故事', '', 'http://localhost:8080/小城故事.mp3');
COMMIT;

-- ----------------------------
-- Table structure for sys_speech
-- ----------------------------
DROP TABLE IF EXISTS `sys_speech`;
CREATE TABLE `sys_speech` (
`SPEECH_ID_`  int(8) NOT NULL AUTO_INCREMENT COMMENT '语音id' ,
`USER_ID_`  int(8) NOT NULL COMMENT '用户id' ,
`DATE_`  datetime NOT NULL COMMENT '录入时间' ,
`SILK_PATH_`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'silk格式的录音文件路径' ,
`WEBN_PATH_`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'webn格式的录音文件路径' ,
`WAV_PATH_`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'wav格式的录音文件路径' ,
`TAG_ID_`  int(8) NULL DEFAULT NULL ,
PRIMARY KEY (`SPEECH_ID_`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='录入语音表'
AUTO_INCREMENT=62

;

-- ----------------------------
-- Records of sys_speech
-- ----------------------------
BEGIN;
INSERT INTO `sys_speech` VALUES ('23', '1', '2017-09-24 14:17:46', '203.silk', '203.webn', '203.wav', null), ('24', '1', '2017-09-24 14:34:30', 'tmp_1857308602o6zAJszLEjD0HpHsjKlwuoflb9yYc7ba4eb214c7350645764d64e0c7837a.silk', 'tmp_1857308602o6zAJszLEjD0HpHsjKlwuoflb9yYc7ba4eb214c7350645764d64e0c7837a.webn', 'tmp_1857308602o6zAJszLEjD0HpHsjKlwuoflb9yYc7ba4eb214c7350645764d64e0c7837a.wav', null), ('25', '1', '2017-09-25 12:10:39', 'tmp_1857308602o6zAJszLEjD0HpHsjKlwuoflb9yYf9c6ef1e92484e40524ba1494e6371e9.silk', 'tmp_1857308602o6zAJszLEjD0HpHsjKlwuoflb9yYf9c6ef1e92484e40524ba1494e6371e9.webn', 'tmp_1857308602o6zAJszLEjD0HpHsjKlwuoflb9yYf9c6ef1e92484e40524ba1494e6371e9.wav', null), ('26', '1', '2017-09-25 12:54:42', 'tmp_1857308602o6zAJszLEjD0HpHsjKlwuoflb9yY7ef766c6b24ff23339cfcbfd81d24bc8.silk', 'tmp_1857308602o6zAJszLEjD0HpHsjKlwuoflb9yY7ef766c6b24ff23339cfcbfd81d24bc8.webn', 'tmp_1857308602o6zAJszLEjD0HpHsjKlwuoflb9yY7ef766c6b24ff23339cfcbfd81d24bc8.wav', null), ('27', '1', '2017-09-25 12:58:35', '203.silk', '203.webn', '203.wav', null), ('28', '1', '2017-09-25 12:59:36', 'tmp_1857308602o6zAJszLEjD0HpHsjKlwuoflb9yY4f9886881a0d6cf5dd6e692836af411f.silk', 'tmp_1857308602o6zAJszLEjD0HpHsjKlwuoflb9yY4f9886881a0d6cf5dd6e692836af411f.webn', 'tmp_1857308602o6zAJszLEjD0HpHsjKlwuoflb9yY4f9886881a0d6cf5dd6e692836af411f.wav', null), ('29', '1', '2017-09-25 13:05:04', 'tmp_1857308602o6zAJszLEjD0HpHsjKlwuoflb9yY20ea60463d6b7ffa3b2236b3732cd8f4.silk', 'tmp_1857308602o6zAJszLEjD0HpHsjKlwuoflb9yY20ea60463d6b7ffa3b2236b3732cd8f4.webn', 'tmp_1857308602o6zAJszLEjD0HpHsjKlwuoflb9yY20ea60463d6b7ffa3b2236b3732cd8f4.wav', null), ('30', '1', '2017-09-25 13:07:56', 'tmp_1857308602o6zAJszLEjD0HpHsjKlwuoflb9yYc94b0f29eb7416e669c4bc2c0bf7cc00.silk', 'tmp_1857308602o6zAJszLEjD0HpHsjKlwuoflb9yYc94b0f29eb7416e669c4bc2c0bf7cc00.webn', 'tmp_1857308602o6zAJszLEjD0HpHsjKlwuoflb9yYc94b0f29eb7416e669c4bc2c0bf7cc00.wav', null), ('31', '1', '2017-09-25 13:13:22', 'tmp_1857308602o6zAJszLEjD0HpHsjKlwuoflb9yYf1f0efcd723efe840e99707437f64b5f.silk', 'tmp_1857308602o6zAJszLEjD0HpHsjKlwuoflb9yYf1f0efcd723efe840e99707437f64b5f.webn', 'tmp_1857308602o6zAJszLEjD0HpHsjKlwuoflb9yYf1f0efcd723efe840e99707437f64b5f.wav', null), ('32', '1', '2017-09-25 13:34:25', 'tmp_1857308602o6zAJszLEjD0HpHsjKlwuoflb9yYbb6f9bcfab45718800f98dae70d86ec0.silk', 'tmp_1857308602o6zAJszLEjD0HpHsjKlwuoflb9yYbb6f9bcfab45718800f98dae70d86ec0.webn', 'tmp_1857308602o6zAJszLEjD0HpHsjKlwuoflb9yYbb6f9bcfab45718800f98dae70d86ec0.wav', null), ('33', '1', '2017-09-25 13:37:13', 'tmp_1857308602o6zAJszLEjD0HpHsjKlwuoflb9yYb22511e8f0adcdb022204721e7ac44fd.silk', 'tmp_1857308602o6zAJszLEjD0HpHsjKlwuoflb9yYb22511e8f0adcdb022204721e7ac44fd.webn', 'tmp_1857308602o6zAJszLEjD0HpHsjKlwuoflb9yYb22511e8f0adcdb022204721e7ac44fd.wav', null), ('34', '1', '2017-09-25 13:37:33', 'tmp_1857308602o6zAJszLEjD0HpHsjKlwuoflb9yYe4db3bc420ecd5f65c06d690c90f2b44.silk', 'tmp_1857308602o6zAJszLEjD0HpHsjKlwuoflb9yYe4db3bc420ecd5f65c06d690c90f2b44.webn', 'tmp_1857308602o6zAJszLEjD0HpHsjKlwuoflb9yYe4db3bc420ecd5f65c06d690c90f2b44.wav', null), ('35', '1', '2017-09-25 13:38:31', 'tmp_1857308602o6zAJszLEjD0HpHsjKlwuoflb9yYd03515fc47b48e713fad76ba4359d916.silk', 'tmp_1857308602o6zAJszLEjD0HpHsjKlwuoflb9yYd03515fc47b48e713fad76ba4359d916.webn', 'tmp_1857308602o6zAJszLEjD0HpHsjKlwuoflb9yYd03515fc47b48e713fad76ba4359d916.wav', null), ('36', '1', '2017-09-25 15:49:01', '203.silk', '203.webn', '203.wav', null), ('37', '1', '2017-09-25 15:50:52', '203.silk', '203.webn', '203.wav', null), ('38', '1', '2017-09-25 15:52:10', 'tmp_1857308602o6zAJszLEjD0HpHsjKlwuoflb9yY48c5b268d02e9af64e4fdb85b49f247f.silk', 'tmp_1857308602o6zAJszLEjD0HpHsjKlwuoflb9yY48c5b268d02e9af64e4fdb85b49f247f.webn', 'tmp_1857308602o6zAJszLEjD0HpHsjKlwuoflb9yY48c5b268d02e9af64e4fdb85b49f247f.wav', null), ('39', '1', '2017-09-25 15:53:01', '202.silk', '202.webn', '202.wav', null), ('40', '1', '2017-09-26 11:35:08', 'tmp_1857308602o6zAJszLEjD0HpHsjKlwuoflb9yYd856d0e5f3afc3c3eb14da53bbcf681a.silk', 'tmp_1857308602o6zAJszLEjD0HpHsjKlwuoflb9yYd856d0e5f3afc3c3eb14da53bbcf681a.webn', 'tmp_1857308602o6zAJszLEjD0HpHsjKlwuoflb9yYd856d0e5f3afc3c3eb14da53bbcf681a.wav', null), ('41', '1', '2017-09-26 11:36:48', 'tmp_1857308602o6zAJszLEjD0HpHsjKlwuoflb9yY092b7934dacf3b069033fa36b7e018b3.silk', 'tmp_1857308602o6zAJszLEjD0HpHsjKlwuoflb9yY092b7934dacf3b069033fa36b7e018b3.webn', 'tmp_1857308602o6zAJszLEjD0HpHsjKlwuoflb9yY092b7934dacf3b069033fa36b7e018b3.wav', null), ('42', '1', '2017-09-26 11:37:29', 'tmp_1857308602o6zAJszLEjD0HpHsjKlwuoflb9yY3be15108291613b043ae8868b67b3e14.silk', 'tmp_1857308602o6zAJszLEjD0HpHsjKlwuoflb9yY3be15108291613b043ae8868b67b3e14.webn', 'tmp_1857308602o6zAJszLEjD0HpHsjKlwuoflb9yY3be15108291613b043ae8868b67b3e14.wav', null), ('43', '1', '2017-10-06 10:18:36', '203.silk', '203.webn', '203.wav', null), ('44', '1', '2017-10-07 16:00:09', '202.silk', '202.webn', '202.wav', '1'), ('45', '1', '2017-10-07 16:03:09', '203.silk', '203.webn', '203.wav', '1'), ('46', '1', '2017-10-07 16:07:51', '202.silk', '202.webn', '202.wav', '2'), ('47', '1', '2017-10-07 16:39:17', '203.silk', '203.webn', '203.wav', '2'), ('48', '1', '2017-10-07 16:50:37', '202.silk', '202.webn', '202.wav', '2'), ('49', '1', '2017-10-08 03:38:09', '203.silk', '203.webn', '203.wav', '-1'), ('50', '1', '2017-10-08 03:40:38', '202.silk', '202.webn', '202.wav', '-1'), ('51', '1', '2017-10-08 06:19:36', '203.silk', '203.webn', '203.wav', '-1'), ('52', '1', '2017-10-08 06:24:00', '203.silk', '203.webn', '203.wav', '-1'), ('53', '1', '2017-10-08 06:26:20', '202.silk', '202.webn', '202.wav', '-1'), ('54', '1', '2017-10-08 06:28:31', '203.silk', '203.webn', '203.wav', '2'), ('55', '1', '2017-10-08 06:30:30', '202.silk', '202.webn', '202.wav', '-1'), ('56', '1', '2017-10-08 06:45:52', '203.silk', '203.webn', '203.wav', '2'), ('57', '1', '2017-10-08 06:46:26', '202.silk', '202.webn', '202.wav', '2'), ('58', '1', '2017-10-08 06:50:12', '202.silk', '202.webn', '202.wav', '2'), ('59', '1', '2017-10-08 07:18:32', '203.silk', '203.webn', '203.wav', '2'), ('60', '1', '2017-10-08 07:26:33', '203.silk', '203.webn', '203.wav', '2'), ('61', '1', '2017-10-08 07:33:17', '203.silk', '203.webn', '203.wav', '2');
COMMIT;

-- ----------------------------
-- Table structure for sys_speech_record
-- ----------------------------
DROP TABLE IF EXISTS `sys_speech_record`;
CREATE TABLE `sys_speech_record` (
`RECORD_ID_`  int(8) NOT NULL AUTO_INCREMENT COMMENT '记录id' ,
`MUSIC_ID_`  int(8) NOT NULL COMMENT '音乐id' ,
`USER_ID_`  int(8) NOT NULL COMMENT '用户id' ,
`SPEECH_ID_`  int(8) NOT NULL COMMENT '用户录入语音id' ,
`DATE_`  datetime NOT NULL COMMENT '听歌的时间' ,
PRIMARY KEY (`RECORD_ID_`),
INDEX `ser_song_id` (`MUSIC_ID_`) USING BTREE ,
INDEX `ser_speech_id` (`SPEECH_ID_`) USING BTREE ,
INDEX `ser_user_id` (`USER_ID_`) USING BTREE 
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='语音识别记录表'
AUTO_INCREMENT=144

;

-- ----------------------------
-- Records of sys_speech_record
-- ----------------------------
BEGIN;
INSERT INTO `sys_speech_record` VALUES ('37', '1014', '1', '23', '2017-09-24 14:18:02'), ('38', '1019', '1', '23', '2017-09-24 14:18:02'), ('39', '1021', '1', '24', '2017-09-24 14:34:45'), ('40', '1022', '1', '24', '2017-09-24 14:34:45'), ('41', '1024', '1', '24', '2017-09-24 14:34:45'), ('42', '1025', '1', '24', '2017-09-24 14:34:45'), ('43', '1027', '1', '24', '2017-09-24 14:34:45'), ('44', '1032', '1', '24', '2017-09-24 14:34:45'), ('45', '1034', '1', '24', '2017-09-24 14:34:45'), ('46', '1035', '1', '24', '2017-09-24 14:34:45'), ('47', '1036', '1', '24', '2017-09-24 14:34:45'), ('48', '1039', '1', '24', '2017-09-24 14:34:45'), ('49', '1014', '1', '25', '2017-09-25 12:11:03'), ('50', '1019', '1', '25', '2017-09-25 12:11:03'), ('51', '1014', '1', '27', '2017-09-25 12:58:39'), ('52', '1019', '1', '27', '2017-09-25 12:58:39'), ('53', '1025', '1', '32', '2017-09-25 13:34:34'), ('54', '1026', '1', '32', '2017-09-25 13:34:34'), ('55', '1027', '1', '32', '2017-09-25 13:34:34'), ('56', '1028', '1', '32', '2017-09-25 13:34:34'), ('57', '1029', '1', '32', '2017-09-25 13:34:34'), ('58', '1034', '1', '32', '2017-09-25 13:34:34'), ('59', '1035', '1', '32', '2017-09-25 13:34:34'), ('60', '1039', '1', '32', '2017-09-25 13:34:34'), ('61', '1040', '1', '32', '2017-09-25 13:34:34'), ('62', '1043', '1', '32', '2017-09-25 13:34:34'), ('63', '1016', '1', '33', '2017-09-25 13:37:15'), ('64', '1021', '1', '33', '2017-09-25 13:37:15'), ('65', '1022', '1', '33', '2017-09-25 13:37:15'), ('66', '1023', '1', '33', '2017-09-25 13:37:15'), ('67', '1025', '1', '33', '2017-09-25 13:37:15'), ('68', '1026', '1', '33', '2017-09-25 13:37:15'), ('69', '1028', '1', '33', '2017-09-25 13:37:15'), ('70', '1029', '1', '33', '2017-09-25 13:37:15'), ('71', '1037', '1', '33', '2017-09-25 13:37:15'), ('72', '1043', '1', '33', '2017-09-25 13:37:15'), ('73', '1016', '1', '34', '2017-09-25 13:37:36'), ('74', '1021', '1', '34', '2017-09-25 13:37:36'), ('75', '1024', '1', '34', '2017-09-25 13:37:36'), ('76', '1028', '1', '34', '2017-09-25 13:37:36'), ('77', '1029', '1', '34', '2017-09-25 13:37:36'), ('78', '1030', '1', '34', '2017-09-25 13:37:36'), ('79', '1032', '1', '34', '2017-09-25 13:37:36'), ('80', '1035', '1', '34', '2017-09-25 13:37:36'), ('81', '1039', '1', '34', '2017-09-25 13:37:36'), ('82', '1041', '1', '34', '2017-09-25 13:37:36'), ('83', '1026', '1', '35', '2017-09-25 13:38:35'), ('84', '1027', '1', '35', '2017-09-25 13:38:35'), ('85', '1028', '1', '35', '2017-09-25 13:38:35'), ('86', '1032', '1', '35', '2017-09-25 13:38:35'), ('87', '1033', '1', '35', '2017-09-25 13:38:35'), ('88', '1034', '1', '35', '2017-09-25 13:38:35'), ('89', '1037', '1', '35', '2017-09-25 13:38:35'), ('90', '1040', '1', '35', '2017-09-25 13:38:35'), ('91', '1042', '1', '35', '2017-09-25 13:38:35'), ('92', '1043', '1', '35', '2017-09-25 13:38:35'), ('93', '1014', '1', '36', '2017-09-25 15:49:10'), ('94', '1019', '1', '36', '2017-09-25 15:49:10'), ('95', '1021', '1', '38', '2017-09-25 15:52:18'), ('96', '1024', '1', '38', '2017-09-25 15:52:18'), ('97', '1029', '1', '38', '2017-09-25 15:52:18'), ('98', '1030', '1', '38', '2017-09-25 15:52:18'), ('99', '1033', '1', '38', '2017-09-25 15:52:18'), ('100', '1036', '1', '38', '2017-09-25 15:52:18'), ('101', '1040', '1', '38', '2017-09-25 15:52:18'), ('102', '1041', '1', '38', '2017-09-25 15:52:18'), ('103', '1042', '1', '38', '2017-09-25 15:52:18'), ('104', '1043', '1', '38', '2017-09-25 15:52:18'), ('105', '1015', '1', '39', '2017-09-25 15:53:03'), ('106', '1018', '1', '39', '2017-09-25 15:53:03'), ('107', '1015', '1', '40', '2017-09-26 11:35:25'), ('108', '1018', '1', '40', '2017-09-26 11:35:25'), ('109', '1006', '1', '42', '2017-09-26 11:37:39'), ('110', '1007', '1', '42', '2017-09-26 11:37:39'), ('111', '1008', '1', '42', '2017-09-26 11:37:39'), ('112', '1009', '1', '42', '2017-09-26 11:37:39'), ('113', '1010', '1', '42', '2017-09-26 11:37:39'), ('114', '1011', '1', '42', '2017-09-26 11:37:39'), ('115', '1012', '1', '42', '2017-09-26 11:37:39'), ('116', '1013', '1', '42', '2017-09-26 11:37:39'), ('117', '1017', '1', '42', '2017-09-26 11:37:39'), ('118', '1015', '1', '43', '2017-10-06 10:18:57'), ('119', '1018', '1', '43', '2017-10-06 10:18:57'), ('120', '1015', '1', '44', '2017-10-07 16:00:19'), ('121', '1018', '1', '44', '2017-10-07 16:00:19'), ('122', '1015', '1', '45', '2017-10-07 16:03:20'), ('123', '1018', '1', '45', '2017-10-07 16:03:21'), ('124', '1014', '1', '46', '2017-10-07 16:08:04'), ('125', '1019', '1', '46', '2017-10-07 16:08:04'), ('126', '1014', '1', '47', '2017-10-07 16:39:28'), ('127', '1019', '1', '47', '2017-10-07 16:39:28'), ('128', '1014', '1', '48', '2017-10-07 16:50:49'), ('129', '1019', '1', '48', '2017-10-07 16:50:49'), ('130', '1014', '1', '54', '2017-10-08 06:28:41'), ('131', '1019', '1', '54', '2017-10-08 06:28:41'), ('132', '1014', '1', '56', '2017-10-08 06:46:03'), ('133', '1019', '1', '56', '2017-10-08 06:46:03'), ('134', '1014', '1', '57', '2017-10-08 06:46:34'), ('135', '1019', '1', '57', '2017-10-08 06:46:34'), ('136', '1014', '1', '58', '2017-10-08 06:50:21');
INSERT INTO `sys_speech_record` VALUES ('137', '1019', '1', '58', '2017-10-08 06:50:21'), ('138', '1014', '1', '59', '2017-10-08 07:18:44'), ('139', '1019', '1', '59', '2017-10-08 07:18:44'), ('140', '1014', '1', '60', '2017-10-08 07:26:42'), ('141', '1019', '1', '60', '2017-10-08 07:26:42'), ('142', '1014', '1', '61', '2017-10-08 07:33:26'), ('143', '1019', '1', '61', '2017-10-08 07:33:26');
COMMIT;

-- ----------------------------
-- Table structure for sys_text_record
-- ----------------------------
DROP TABLE IF EXISTS `sys_text_record`;
CREATE TABLE `sys_text_record` (
`RECORD_ID_`  int(8) NOT NULL AUTO_INCREMENT COMMENT '记录id' ,
`USER_ID_`  int(8) NOT NULL COMMENT '用户id' ,
`MUSIC_ID_`  int(8) NOT NULL COMMENT '歌曲id' ,
`DATE_`  datetime NOT NULL COMMENT '听歌的时间' ,
PRIMARY KEY (`RECORD_ID_`),
INDEX `ser_song_id` (`MUSIC_ID_`) USING BTREE ,
INDEX `ser_user_id` (`USER_ID_`) USING BTREE 
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='文本选择记录表'
AUTO_INCREMENT=1

;

-- ----------------------------
-- Records of sys_text_record
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
`USER_ID_`  int(8) NOT NULL AUTO_INCREMENT COMMENT '唯一id' ,
`FULLNAME_`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '姓名' ,
`ACCOUNT_`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '账号' ,
`PASSWORD_`  varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码' ,
`EMAIL_`  varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮箱' ,
`MOBILE_`  varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '手机号码' ,
`WEIXIN_`  varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '微信号' ,
`CREATE_TIME_`  datetime NULL DEFAULT NULL COMMENT '创建时间' ,
`PHOTO_`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '头像' ,
`SEX_`  varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '性别：男，女，未知' ,
`AGE_`  int(3) NULL DEFAULT NULL COMMENT '年龄' ,
`LIMIT_`  int(3) NULL DEFAULT 1 COMMENT '0:下线，1在线' ,
`USER_TYPE_`  int(3) NULL DEFAULT NULL COMMENT '用户类型  0系统用户 1普通用户  ' ,
PRIMARY KEY (`USER_ID_`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='用户表'
AUTO_INCREMENT=45

;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
BEGIN;
INSERT INTO `sys_user` VALUES ('1', '王子', 'wangzi', '1', '812837369@qq.com', '13192660368', null, '2017-09-05 14:41:46', '', '男', '30', '1', '0'), ('2', 'test', 'test', '2', null, null, null, null, null, null, null, '1', null);
COMMIT;

-- ----------------------------
-- Table structure for sys_user_status
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_status`;
CREATE TABLE `sys_user_status` (
`RECORD_ID_`  int(8) NOT NULL AUTO_INCREMENT COMMENT '记录id' ,
`USER_ID_`  int(8) NOT NULL COMMENT '用户id' ,
`DATE_`  datetime NOT NULL COMMENT '录入时间' ,
`STATUS_`  int(2) NOT NULL COMMENT '0:下线 1:在线' ,
PRIMARY KEY (`RECORD_ID_`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='用户行为记录表'
AUTO_INCREMENT=1

;

-- ----------------------------
-- Records of sys_user_status
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Auto increment value for spider_music
-- ----------------------------
ALTER TABLE `spider_music` AUTO_INCREMENT=1044;

-- ----------------------------
-- Auto increment value for spider_music_collection
-- ----------------------------
ALTER TABLE `spider_music_collection` AUTO_INCREMENT=1;

-- ----------------------------
-- Auto increment value for sys_speech
-- ----------------------------
ALTER TABLE `sys_speech` AUTO_INCREMENT=62;

-- ----------------------------
-- Auto increment value for sys_speech_record
-- ----------------------------
ALTER TABLE `sys_speech_record` AUTO_INCREMENT=144;

-- ----------------------------
-- Auto increment value for sys_text_record
-- ----------------------------
ALTER TABLE `sys_text_record` AUTO_INCREMENT=1;

-- ----------------------------
-- Auto increment value for sys_user
-- ----------------------------
ALTER TABLE `sys_user` AUTO_INCREMENT=45;

-- ----------------------------
-- Auto increment value for sys_user_status
-- ----------------------------
ALTER TABLE `sys_user_status` AUTO_INCREMENT=1;
