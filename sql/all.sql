/*
Navicat MySQL Data Transfer
Source Server         : mysql
Source Server Version : 50628
Source Host           : localhost:3306
Source Database       : dachuang
Target Server Type    : MYSQL
Target Server Version : 50628
File Encoding         : 65001
Date: 2017-09-19 18:08:25
*/

-- ----------------------------
-- recg前缀的表示属于情绪识别的数据表

-- spider前缀的表示属于爬虫爬取音乐的数据表

-- sys前缀的表示关于微信小程序需要涉及的数据表
-- ----------------------------

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
INSERT INTO `recg_tag` VALUES ('0', '生气'), ('1', '害怕'), ('2', '开心'), ('3', '伤心');
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
AUTO_INCREMENT=964

;

-- ----------------------------
-- Records of spider_music
-- ----------------------------
BEGIN;
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
COMMIT;

-- ----------------------------
-- Table structure for sys_speech
-- ----------------------------
DROP TABLE IF EXISTS `sys_speech`;
CREATE TABLE `sys_speech` (
`SPEECH_ID_`  int(8) NOT NULL COMMENT '语音id' ,
`USER_ID_`  int(8) NOT NULL COMMENT '用户id' ,
`DATE_`  datetime NOT NULL COMMENT '录入时间' ,
`SILK_PATH_`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'silk格式的录音文件路径' ,
`WEBN_PATH_`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'webn格式的录音文件路径' ,
`WAV_PATH_`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'wav格式的录音文件路径' ,
PRIMARY KEY (`SPEECH_ID_`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='录入语音表'

;

-- ----------------------------
-- Records of sys_speech
-- ----------------------------
BEGIN;
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
AUTO_INCREMENT=1

;

-- ----------------------------
-- Records of sys_speech_record
-- ----------------------------
BEGIN;
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
`USER_ID_`  int(8) NOT NULL COMMENT '唯一id' ,
`FULLNAME_`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '姓名' ,
`ACCOUNT_`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '账号' ,
`PASSWORD_`  varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码' ,
`EMAIL_`  varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮箱' ,
`MOBILE_`  varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '手机号码' ,
`WEIXIN_`  varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '微信号' ,
`CREATE_TIME_`  datetime NULL DEFAULT NULL COMMENT '创建时间' ,
`PHOTO_`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '头像' ,
`SEX_`  varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '性别：男，女，未知' ,
`AGE_`  int(3) NULL DEFAULT NULL COMMENT '年龄' ,
`LIMIT_`  int(3) NOT NULL DEFAULT 1 COMMENT '0:下线，1在线' ,
`USER_TYPE_`  int(3) NULL DEFAULT NULL COMMENT '用户类型  0系统用户 1普通用户  ' ,
PRIMARY KEY (`USER_ID_`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='用户表'

;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
BEGIN;
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
ALTER TABLE `spider_music` AUTO_INCREMENT=1;

-- ----------------------------
-- Auto increment value for spider_music_collection
-- ----------------------------
ALTER TABLE `spider_music_collection` AUTO_INCREMENT=1;

-- ----------------------------
-- Auto increment value for sys_speech_record
-- ----------------------------
ALTER TABLE `sys_speech_record` AUTO_INCREMENT=1;

-- ----------------------------
-- Auto increment value for sys_text_record
-- ----------------------------
ALTER TABLE `sys_text_record` AUTO_INCREMENT=1;

-- ----------------------------
-- Auto increment value for sys_user_status
-- ----------------------------
ALTER TABLE `sys_user_status` AUTO_INCREMENT=1;
