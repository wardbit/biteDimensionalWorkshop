/*
 Navicat Premium Data Transfer

 Source Server         : ward
 Source Server Type    : MySQL
 Source Server Version : 80039
 Source Host           : localhost:3306
 Source Schema         : warddb

 Target Server Type    : MySQL
 Target Server Version : 80039
 File Encoding         : 65001

 Date: 21/10/2024 23:20:37
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for blacklist
-- ----------------------------
DROP TABLE IF EXISTS `blacklist`;
CREATE TABLE `blacklist`  (
  `blacklist_id` int(0) NOT NULL AUTO_INCREMENT,
  `user_id` int(0) NOT NULL,
  `blocked_user_id` int(0) NOT NULL,
  `created_at` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`blacklist_id`) USING BTREE,
  UNIQUE INDEX `user_id`(`user_id`, `blocked_user_id`) USING BTREE,
  INDEX `blocked_user_id`(`blocked_user_id`) USING BTREE,
  CONSTRAINT `blacklist_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `blacklist_ibfk_2` FOREIGN KEY (`blocked_user_id`) REFERENCES `users` (`user_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for categories
-- ----------------------------
DROP TABLE IF EXISTS `categories`;
CREATE TABLE `categories`  (
  `category_id` int(0) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `description` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL,
  `created_at` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`category_id`) USING BTREE,
  UNIQUE INDEX `name`(`name`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 48 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of categories
-- ----------------------------
INSERT INTO `categories` VALUES (1, '手游', NULL, '2024-09-23 10:09:29');
INSERT INTO `categories` VALUES (2, '番', NULL, '2024-09-23 10:08:01');
INSERT INTO `categories` VALUES (3, '漫画', NULL, '2024-09-23 10:09:10');
INSERT INTO `categories` VALUES (4, '小说', NULL, '2024-09-23 10:09:56');
INSERT INTO `categories` VALUES (5, 'HTML', NULL, '2024-09-23 10:09:33');
INSERT INTO `categories` VALUES (6, 'CSS', NULL, '2024-09-23 10:09:12');
INSERT INTO `categories` VALUES (7, 'C++', NULL, '2024-09-23 10:09:04');
INSERT INTO `categories` VALUES (8, 'JS', NULL, '2024-09-23 10:09:53');
INSERT INTO `categories` VALUES (9, '数据库', NULL, '2024-09-23 10:09:15');
INSERT INTO `categories` VALUES (10, 'java', NULL, '2024-09-23 10:09:50');
INSERT INTO `categories` VALUES (11, '网络服务', NULL, '2024-09-23 10:10:14');
INSERT INTO `categories` VALUES (12, '服务端', NULL, '2024-09-23 10:10:05');
INSERT INTO `categories` VALUES (13, '软件开发', NULL, '2024-09-23 10:10:07');
INSERT INTO `categories` VALUES (14, '技术', NULL, '2024-09-23 10:10:10');
INSERT INTO `categories` VALUES (15, 'QT', NULL, '2024-09-23 10:10:02');
INSERT INTO `categories` VALUES (16, 'python', NULL, '2024-09-23 10:09:58');
INSERT INTO `categories` VALUES (17, 'goland', NULL, '2024-09-23 10:09:31');
INSERT INTO `categories` VALUES (18, 'dotnet', NULL, '2024-09-23 10:07:53');
INSERT INTO `categories` VALUES (19, 'Csharp', NULL, '2024-09-23 10:09:01');
INSERT INTO `categories` VALUES (20, '猫', NULL, '2024-09-23 10:09:07');
INSERT INTO `categories` VALUES (21, '狗', NULL, '2024-09-23 10:09:24');
INSERT INTO `categories` VALUES (22, '大数据', NULL, '2024-09-23 10:08:03');
INSERT INTO `categories` VALUES (23, 'AI', NULL, '2024-09-23 10:07:58');
INSERT INTO `categories` VALUES (24, '食物', NULL, '2024-09-23 10:09:26');
INSERT INTO `categories` VALUES (25, 'xml', NULL, '2024-09-23 10:10:16');
INSERT INTO `categories` VALUES (26, 'rust', NULL, '2024-09-30 09:41:47');
INSERT INTO `categories` VALUES (27, 'galgame', NULL, '2024-09-30 09:38:27');
INSERT INTO `categories` VALUES (28, '东方', NULL, '2024-09-30 09:38:41');
INSERT INTO `categories` VALUES (29, '3A', NULL, '2024-09-30 09:42:18');
INSERT INTO `categories` VALUES (30, '独立游戏', NULL, '2024-09-30 09:42:27');
INSERT INTO `categories` VALUES (31, 'FPS', NULL, '2024-09-30 09:42:38');
INSERT INTO `categories` VALUES (32, '键政', NULL, '2024-09-30 09:43:12');
INSERT INTO `categories` VALUES (33, '动漫', NULL, '2024-09-30 09:43:19');
INSERT INTO `categories` VALUES (34, '电影', NULL, '2024-09-30 09:43:34');
INSERT INTO `categories` VALUES (35, 'Linux', NULL, '2024-09-30 09:44:12');
INSERT INTO `categories` VALUES (36, 'git', NULL, '2024-09-30 09:44:34');
INSERT INTO `categories` VALUES (37, 'docker', NULL, '2024-09-30 09:44:56');
INSERT INTO `categories` VALUES (38, '网络安全', NULL, '2024-09-30 09:48:50');
INSERT INTO `categories` VALUES (39, '嵌入式', NULL, '2024-09-30 09:49:03');
INSERT INTO `categories` VALUES (40, '音视频编码', NULL, '2024-09-30 09:49:39');
INSERT INTO `categories` VALUES (41, '软件分享', NULL, '2024-09-30 09:49:59');
INSERT INTO `categories` VALUES (42, '计算机网络', NULL, '2024-09-30 09:51:12');
INSERT INTO `categories` VALUES (43, '图形学', NULL, '2024-09-30 09:51:23');
INSERT INTO `categories` VALUES (44, '原神', NULL, '2024-10-07 19:24:41');
INSERT INTO `categories` VALUES (45, '王者荣耀', NULL, '2024-10-07 19:24:58');
INSERT INTO `categories` VALUES (46, '崩坏·星穹铁道', NULL, '2024-10-07 19:25:27');
INSERT INTO `categories` VALUES (47, '明日方舟', NULL, '2024-10-07 19:25:57');

-- ----------------------------
-- Table structure for comments
-- ----------------------------
DROP TABLE IF EXISTS `comments`;
CREATE TABLE `comments`  (
  `comment_id` int(0) NOT NULL AUTO_INCREMENT,
  `post_id` int(0) NOT NULL,
  `user_id` int(0) NOT NULL,
  `content` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `created_at` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`comment_id`) USING BTREE,
  INDEX `post_id`(`post_id`) USING BTREE,
  INDEX `user_id`(`user_id`) USING BTREE,
  CONSTRAINT `comments_ibfk_1` FOREIGN KEY (`post_id`) REFERENCES `posts` (`post_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `comments_ibfk_2` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of comments
-- ----------------------------
INSERT INTO `comments` VALUES (2, 1, 0, 'test', '2024-10-21 08:29:35');

-- ----------------------------
-- Table structure for favorites
-- ----------------------------
DROP TABLE IF EXISTS `favorites`;
CREATE TABLE `favorites`  (
  `favorite_id` int(0) NOT NULL AUTO_INCREMENT,
  `user_id` int(0) NOT NULL,
  `post_id` int(0) NOT NULL,
  `created_at` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`favorite_id`) USING BTREE,
  INDEX `user_id`(`user_id`) USING BTREE,
  INDEX `post_id`(`post_id`) USING BTREE,
  CONSTRAINT `favorites_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `favorites_ibfk_2` FOREIGN KEY (`post_id`) REFERENCES `posts` (`post_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for follows
-- ----------------------------
DROP TABLE IF EXISTS `follows`;
CREATE TABLE `follows`  (
  `follow_id` int(0) NOT NULL AUTO_INCREMENT,
  `follower_id` int(0) NOT NULL,
  `following_id` int(0) NOT NULL,
  `created_at` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`follow_id`) USING BTREE,
  UNIQUE INDEX `follower_id`(`follower_id`, `following_id`) USING BTREE,
  INDEX `following_id`(`following_id`) USING BTREE,
  CONSTRAINT `follows_ibfk_1` FOREIGN KEY (`follower_id`) REFERENCES `users` (`user_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `follows_ibfk_2` FOREIGN KEY (`following_id`) REFERENCES `users` (`user_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of follows
-- ----------------------------
INSERT INTO `follows` VALUES (1, 0, 3, '2024-10-20 19:59:20');
INSERT INTO `follows` VALUES (2, 0, 5, '2024-10-20 21:13:09');

-- ----------------------------
-- Table structure for friends
-- ----------------------------
DROP TABLE IF EXISTS `friends`;
CREATE TABLE `friends`  (
  `friend_id` int(0) NOT NULL AUTO_INCREMENT,
  `user1_id` int(0) NOT NULL,
  `user2_id` int(0) NOT NULL,
  `created_at` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`friend_id`) USING BTREE,
  UNIQUE INDEX `user1_id`(`user1_id`, `user2_id`) USING BTREE,
  INDEX `user2_id`(`user2_id`) USING BTREE,
  CONSTRAINT `friends_ibfk_1` FOREIGN KEY (`user1_id`) REFERENCES `users` (`user_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `friends_ibfk_2` FOREIGN KEY (`user2_id`) REFERENCES `users` (`user_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for images
-- ----------------------------
DROP TABLE IF EXISTS `images`;
CREATE TABLE `images`  (
  `image_id` int(0) NOT NULL AUTO_INCREMENT,
  `post_id` int(0) NULL DEFAULT NULL,
  `comment_id` int(0) NULL DEFAULT NULL,
  `image_url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `uploaded_at` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`image_id`) USING BTREE,
  INDEX `post_id`(`post_id`) USING BTREE,
  INDEX `comment_id`(`comment_id`) USING BTREE,
  CONSTRAINT `images_ibfk_1` FOREIGN KEY (`post_id`) REFERENCES `posts` (`post_id`) ON DELETE CASCADE ON UPDATE RESTRICT,
  CONSTRAINT `images_ibfk_2` FOREIGN KEY (`comment_id`) REFERENCES `comments` (`comment_id`) ON DELETE CASCADE ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for likes
-- ----------------------------
DROP TABLE IF EXISTS `likes`;
CREATE TABLE `likes`  (
  `like_id` int(0) NOT NULL AUTO_INCREMENT,
  `user_id` int(0) NOT NULL,
  `post_id` int(0) NULL DEFAULT NULL,
  `comment_id` int(0) NULL DEFAULT NULL,
  `created_at` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`like_id`) USING BTREE,
  INDEX `user_id`(`user_id`) USING BTREE,
  INDEX `post_id`(`post_id`) USING BTREE,
  INDEX `comment_id`(`comment_id`) USING BTREE,
  CONSTRAINT `likes_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `likes_ibfk_2` FOREIGN KEY (`post_id`) REFERENCES `posts` (`post_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `likes_ibfk_3` FOREIGN KEY (`comment_id`) REFERENCES `comments` (`comment_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for messages
-- ----------------------------
DROP TABLE IF EXISTS `messages`;
CREATE TABLE `messages`  (
  `message_id` int(0) NOT NULL AUTO_INCREMENT,
  `sender_id` int(0) NOT NULL,
  `receiver_id` int(0) NOT NULL,
  `content` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `sent_at` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP,
  `image` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`message_id`) USING BTREE,
  INDEX `sender_id`(`sender_id`) USING BTREE,
  INDEX `receiver_id`(`receiver_id`) USING BTREE,
  CONSTRAINT `messages_ibfk_1` FOREIGN KEY (`sender_id`) REFERENCES `users` (`user_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `messages_ibfk_2` FOREIGN KEY (`receiver_id`) REFERENCES `users` (`user_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for permissions
-- ----------------------------
DROP TABLE IF EXISTS `permissions`;
CREATE TABLE `permissions`  (
  `permission_id` int(0) NOT NULL AUTO_INCREMENT,
  `role` enum('admin','moderator','user') CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `permission_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `description` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL,
  PRIMARY KEY (`permission_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for points
-- ----------------------------
DROP TABLE IF EXISTS `points`;
CREATE TABLE `points`  (
  `point_id` int(0) NOT NULL AUTO_INCREMENT,
  `user_id` int(0) NOT NULL,
  `points` int(0) NOT NULL,
  `action_type` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `created_at` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`point_id`) USING BTREE,
  INDEX `user_id`(`user_id`) USING BTREE,
  CONSTRAINT `points_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for post_tags
-- ----------------------------
DROP TABLE IF EXISTS `post_tags`;
CREATE TABLE `post_tags`  (
  `post_id` int(0) NOT NULL,
  `tag_id` int(0) NOT NULL,
  PRIMARY KEY (`post_id`, `tag_id`) USING BTREE,
  INDEX `tag_id`(`tag_id`) USING BTREE,
  CONSTRAINT `post_tags_ibfk_1` FOREIGN KEY (`post_id`) REFERENCES `posts` (`post_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `post_tags_ibfk_2` FOREIGN KEY (`tag_id`) REFERENCES `tags` (`tag_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for posts
-- ----------------------------
DROP TABLE IF EXISTS `posts`;
CREATE TABLE `posts`  (
  `post_id` int(0) NOT NULL AUTO_INCREMENT,
  `user_id` int(0) NOT NULL,
  `category_id` int(0) NULL DEFAULT NULL,
  `title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `content` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `created_at` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0),
  `views` int(0) NULL DEFAULT 0,
  `thumbnail_image` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`post_id`) USING BTREE,
  INDEX `user_id`(`user_id`) USING BTREE,
  INDEX `category_id`(`category_id`) USING BTREE,
  CONSTRAINT `posts_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `posts_ibfk_2` FOREIGN KEY (`category_id`) REFERENCES `categories` (`category_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of posts
-- ----------------------------
INSERT INTO `posts` VALUES (1, 0, 1, 'test', 'test', '2024-10-20 19:58:25', '2024-10-20 19:58:27', 0, NULL);

-- ----------------------------
-- Table structure for tags
-- ----------------------------
DROP TABLE IF EXISTS `tags`;
CREATE TABLE `tags`  (
  `tag_id` int(0) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`tag_id`) USING BTREE,
  UNIQUE INDEX `name`(`name`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 27 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tags
-- ----------------------------
INSERT INTO `tags` VALUES (3, '心得分享');
INSERT INTO `tags` VALUES (4, '技术文章');
INSERT INTO `tags` VALUES (1, '求助');
INSERT INTO `tags` VALUES (2, '资源分享');

-- ----------------------------
-- Table structure for user_drive
-- ----------------------------
DROP TABLE IF EXISTS `user_drive`;
CREATE TABLE `user_drive`  (
  `file_id` int(0) NOT NULL AUTO_INCREMENT,
  `user_id` int(0) NOT NULL,
  `folder_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `file_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `file_path` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `file_size` bigint(0) NULL DEFAULT NULL,
  `uploaded_at` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`file_id`) USING BTREE,
  INDEX `user_id`(`user_id`) USING BTREE,
  CONSTRAINT `user_drive_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users`  (
  `user_id` int(0) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `email` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `password_hash` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `bio` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `avatar_url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `role` enum('admin','moderator','user') CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT 'user',
  `created_at` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP,
  `last_login` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0),
  `total_points` int(0) NULL DEFAULT 0,
  `phone` int(0) NULL DEFAULT NULL,
  `nickname` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`user_id`) USING BTREE,
  UNIQUE INDEX `username`(`username`) USING BTREE,
  UNIQUE INDEX `email`(`email`) USING BTREE,
  UNIQUE INDEX `phone`(`phone`) USING BTREE,
  UNIQUE INDEX `nickname`(`nickname`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES (0, 'admin', NULL, '123456', NULL, 'C:\\Users\\ward\\AppData\\Local\\Temp\\tomcat-docbase.8080.3510817839579433821\\upload\\Snipaste_2024-06-22_23-15-48.png', 'admin', '2024-09-22 15:49:06', '2024-10-20 20:12:14', 0, NULL, '管理员');
INSERT INTO `users` VALUES (3, 'wardd', NULL, 'Hg&wu668', NULL, NULL, 'user', '2024-10-12 10:10:55', '2024-10-12 10:10:55', 0, NULL, NULL);
INSERT INTO `users` VALUES (5, 'warddd', NULL, 'Hg.wu899', NULL, NULL, 'user', '2024-10-14 09:27:32', '2024-10-14 09:27:32', 0, NULL, NULL);

SET FOREIGN_KEY_CHECKS = 1;
