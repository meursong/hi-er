CREATE DATABASE if not exists `hire` /*!40100 DEFAULT CHARACTER SET utf8 */ /*!80016 DEFAULT ENCRYPTION='N' */;
DROP table if exists `image`;
DROP table if exists `portfolio_src`;
DROP table if exists `review`;
DROP table if exists `f_info`;
DROP table if exists `message`;
DROP table if exists `order1`;
DROP table if exists `report`;
DROP table if exists `likepost`;
DROP table if exists `product`;
DROP table if exists `review`;
DROP table if exists `user`;

CREATE TABLE `user`(
  `user_id` int NOT NULL AUTO_INCREMENT,
  `email` varchar(50) NOT NULL,
  `password` varchar(100) NOT NULL,
  `job` varchar(50) DEFAULT NULL,
  `name` varchar(30) NOT NULL,
  `profile_image` varchar(200) NOT NULL DEFAULT 'default.jpg',
  `type` int NOT NULL DEFAULT '0',
  `createdAt` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updatedAt` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `interest` varchar(50) DEFAULT NULL,
  `nickname` varchar(100) NOT NULL DEFAULT '0',
  PRIMARY KEY (`user_id`)
);

CREATE TABLE `product` (
  `product_id` int NOT NULL AUTO_INCREMENT,
  `seller_id` int NOT NULL,
  `work_available` int NOT NULL,
  `title` varchar(200) NOT NULL,
  `category` varchar(20) NOT NULL,
  `content` varchar(1000) DEFAULT NULL,
  `commission` int NOT NULL,
  `refund_policy` varchar(500) NOT NULL,
  `createdAt` datetime NOT NULL,
  `updatedAt` datetime NOT NULL,
  PRIMARY KEY (`product_id`),
  KEY `seller_id` (`seller_id`),
  CONSTRAINT `product_ibfk_1` FOREIGN KEY (`seller_id`) REFERENCES `user` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE `review` (
  `review_id` int NOT NULL,
  `review_wid` int NOT NULL,
  `product_id` int NOT NULL,
  `seller_id` int NOT NULL,
  `content` varchar(100) NOT NULL,
  `star_point` int NOT NULL,
  `createdAt` datetime,
  PRIMARY KEY (`review_id`),
  KEY `product_id` (`product_id`),
  KEY `seller_id` (`seller_id`),
  KEY `review_wid` (`review_wid`),
  CONSTRAINT `review_ibfk_1` FOREIGN KEY (`product_id`) REFERENCES `product` (`product_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `review_ibfk_2` FOREIGN KEY (`seller_id`) REFERENCES `product` (`seller_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `review_ibfk_3` FOREIGN KEY (`review_wid`) REFERENCES `user` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE
);

create table f_info(
	f_id int not null,
    address varchar(100),
    address2 varchar(100),
    introduction varchar(1000),
    switchAt datetime,
    foreign key(f_id) references user(user_id)
    ON UPDATE cascade ON DELETE cascade
);


INSERT INTO `user` (`user_id`,`email`,`password`,`job`,`nickname`,`profile_image`,`type`,`createdAt`,`updatedAt`,`name`) VALUES (1,'admin1@naver.com','aa123','웹개발자','멀캠','default.jpg',1,'2022-03-31 00:38:29','2022-04-04 16:00:15','c');
INSERT INTO `user` (`user_id`,`email`,`password`,`job`,`nickname`,`profile_image`,`type`,`createdAt`,`updatedAt`,`name`) VALUES (2,'admin2@naver.com','aa123','대학생','하이어','default.jpg',2,'2022-03-31 00:38:34','2022-04-07 22:09:31','d');
INSERT INTO `user` (`user_id`,`email`,`password`,`job`,`nickname`,`profile_image`,`type`,`createdAt`,`updatedAt`,`name`) VALUES (3,'admin3@naver.com','aa123','앱개발자','짱짱','default.jpg',1,'2022-03-31 13:39:28','2022-03-31 13:39:28','a');
INSERT INTO `user` (`user_id`,`email`,`password`,`job`,`nickname`,`profile_image`,`type`,`createdAt`,`updatedAt`,`name`) VALUES (4,'admin4@naver.com','aa123','개발자','아아','default.jpg',2,'2022-04-01 17:48:14','2022-04-01 17:48:14','b');
INSERT INTO `user` (`email`,`password`,`job`,`name`,`profile_image`,`type`,`createdAt`,`updatedAt`,`interest`,`nickname`) VALUES ('yyc5343@naver.com','1234','직장인','예찬','default.jpg',0,'2022-04-08 09:28:24','2022-04-08 09:28:24',NULL,'0');



INSERT INTO `product` (`product_id`,`seller_id`,`work_available`,`title`,`category`,`content`,`commission`,`refund_policy`,`createdAt`,`updatedAt`) VALUES (1,1,5,'홈페이지 제작','웹 프로그래밍','홈페이지를만들어드립니다',200,'5일이내 환불','2022-03-30 23:59:59','2022-04-05 23:58:58');
INSERT INTO `product` (`product_id`,`seller_id`,`work_available`,`title`,`category`,`content`,`commission`,`refund_policy`,`createdAt`,`updatedAt`) VALUES (2,1,3,'로고 제작','디자인','로고 제작 해드립니다',1200,'5일이내 환불','2022-03-30 23:59:59','2022-04-05 23:58:58');
INSERT INTO `product` (`product_id`,`seller_id`,`work_available`,`title`,`category`,`content`,`commission`,`refund_policy`,`createdAt`,`updatedAt`) VALUES (3,1,2,'영상 제작','영상','영상 제작 해드립니다',300,'5일이내 환불','2022-03-30 23:59:59','2022-04-05 23:58:58');
INSERT INTO `product` (`product_id`,`seller_id`,`work_available`,`title`,`category`,`content`,`commission`,`refund_policy`,`createdAt`,`updatedAt`) VALUES (4,1,4,'영상 편집','영상','영상 편집 해드립니다',400,'5일이내 환불','2022-03-30 23:59:59','2022-04-05 23:58:58');
INSERT INTO `product` (`product_id`,`seller_id`,`work_available`,`title`,`category`,`content`,`commission`,`refund_policy`,`createdAt`,`updatedAt`) VALUES (5,1,1,'보안 프로그래밍','프로그래밍','보안 프로그래밍 제작해드립니다',1400,'5일이내 환불','2022-03-30 23:59:59','2022-04-05 23:58:58');
INSERT INTO `product` (`product_id`,`seller_id`,`work_available`,`title`,`category`,`content`,`commission`,`refund_policy`,`createdAt`,`updatedAt`) VALUES (6,1,4,'브랜드 제작','디자인','브랜드 제작 해드립니다',2200,'5일이내 환불','2022-03-30 23:59:59','2022-04-05 23:58:58');
INSERT INTO `product` (`product_id`,`seller_id`,`work_available`,`title`,`category`,`content`,`commission`,`refund_policy`,`createdAt`,`updatedAt`) VALUES (7,4,1,'상품 등록 테스트으으으','디자인','상품 등록 테스트으으',30,'약관 테스트으으','2022-04-04 16:46:46','2022-04-04 16:46:46');
INSERT INTO `product` (`product_id`,`seller_id`,`work_available`,`title`,`category`,`content`,`commission`,`refund_policy`,`createdAt`,`updatedAt`) VALUES (8,4,1,'상품 등록 테스트으으으','디자인','상품 등록 테스트으으',30,'약관 테스트으으','2022-04-04 16:46:46','2022-04-04 16:46:46');
INSERT INTO `product` (`product_id`,`seller_id`,`work_available`,`title`,`category`,`content`,`commission`,`refund_policy`,`createdAt`,`updatedAt`) VALUES (9,4,1,'상품 등록 테스트으으으','디자인','상품 등록 테스트으으',30,'약관 테스트으으','2022-04-04 16:46:46','2022-04-04 16:46:46');
INSERT INTO `product` (`product_id`,`seller_id`,`work_available`,`title`,`category`,`content`,`commission`,`refund_policy`,`createdAt`,`updatedAt`) VALUES (10,4,1,'상품 등록 테스트으으으','디자인','상품 등록 테스트으으',30,'약관 테스트으으','2022-04-04 16:46:46','2022-04-04 16:46:46');
INSERT INTO `product` (`product_id`,`seller_id`,`work_available`,`title`,`category`,`content`,`commission`,`refund_policy`,`createdAt`,`updatedAt`) VALUES (11,4,1,'상품 등록 테스트으으으','디자인','상품 등록 테스트으으',30,'약관 테스트으으','2022-04-04 16:46:47','2022-04-04 16:46:47');
INSERT INTO `product` (`product_id`,`seller_id`,`work_available`,`title`,`category`,`content`,`commission`,`refund_policy`,`createdAt`,`updatedAt`) VALUES (12,4,1,'상품 등록 테스트으으으','디자인','상품 등록 테스트으으',30,'약관 테스트으으','2022-04-04 16:46:47','2022-04-04 16:46:47');
INSERT INTO `product` (`product_id`,`seller_id`,`work_available`,`title`,`category`,`content`,`commission`,`refund_policy`,`createdAt`,`updatedAt`) VALUES (13,4,1,'상품 등록 테스트으으으','디자인','상품 등록 테스트으으',30,'약관 테스트으으','2022-04-04 16:46:47','2022-04-04 16:46:47');
INSERT INTO `product` (`product_id`,`seller_id`,`work_available`,`title`,`category`,`content`,`commission`,`refund_policy`,`createdAt`,`updatedAt`) VALUES (14,4,1,'상품 등록 테스트으으으','디자인','상품 등록 테스트으으',30,'약관 테스트으으','2022-04-04 16:46:47','2022-04-04 16:46:47');
INSERT INTO `product` (`product_id`,`seller_id`,`work_available`,`title`,`category`,`content`,`commission`,`refund_policy`,`createdAt`,`updatedAt`) VALUES (15,4,1,'상품 등록 테스트으으으','디자인','상품 등록 테스트으으',30,'약관 테스트으으','2022-04-04 16:46:47','2022-04-04 16:46:47');
INSERT INTO `product` (`product_id`,`seller_id`,`work_available`,`title`,`category`,`content`,`commission`,`refund_policy`,`createdAt`,`updatedAt`) VALUES (16,4,1,'상품 등록 테스트으으으','디자인','상품 등록 테스트으으',30,'약관 테스트으으','2022-04-04 16:46:47','2022-04-04 16:46:47');
INSERT INTO `product` (`product_id`,`seller_id`,`work_available`,`title`,`category`,`content`,`commission`,`refund_policy`,`createdAt`,`updatedAt`) VALUES (17,4,1,'상품 등록 테스트으으으','디자인','상품 등록 테스트으으',30,'약관 테스트으으','2022-04-04 16:46:47','2022-04-04 16:46:47');
INSERT INTO `product` (`product_id`,`seller_id`,`work_available`,`title`,`category`,`content`,`commission`,`refund_policy`,`createdAt`,`updatedAt`) VALUES (18,4,1,'상품 등록 테스트으으으','디자인','상품 등록 테스트으으',30,'약관 테스트으으','2022-04-04 16:46:48','2022-04-04 16:46:48');
INSERT INTO `product` (`product_id`,`seller_id`,`work_available`,`title`,`category`,`content`,`commission`,`refund_policy`,`createdAt`,`updatedAt`) VALUES (19,4,1,'상품 등록 테스트으으으','디자인','상품 등록 테스트으으',30,'약관 테스트으으','2022-04-04 16:46:48','2022-04-04 16:46:48');
INSERT INTO `product` (`product_id`,`seller_id`,`work_available`,`title`,`category`,`content`,`commission`,`refund_policy`,`createdAt`,`updatedAt`) VALUES (20,4,1,'상품 등록 테스트으으으','디자인','상품 등록 테스트으으',30,'약관 테스트으으','2022-04-04 16:46:48','2022-04-04 16:46:48');
INSERT INTO `product` (`product_id`,`seller_id`,`work_available`,`title`,`category`,`content`,`commission`,`refund_policy`,`createdAt`,`updatedAt`) VALUES (21,4,1,'상품 등록 테스트으으으','디자인','상품 등록 테스트으으',30,'약관 테스트으으','2022-04-04 16:46:48','2022-04-04 16:46:48');
INSERT INTO `product` (`product_id`,`seller_id`,`work_available`,`title`,`category`,`content`,`commission`,`refund_policy`,`createdAt`,`updatedAt`) VALUES (22,4,1,'상품 등록 테스트으으으','디자인','상품 등록 테스트으으',30,'약관 테스트으으','2022-04-04 16:46:48','2022-04-04 16:46:48');
INSERT INTO `product` (`product_id`,`seller_id`,`work_available`,`title`,`category`,`content`,`commission`,`refund_policy`,`createdAt`,`updatedAt`) VALUES (23,4,1,'상품 등록 테스트으으으','디자인','상품 등록 테스트으으',30,'약관 테스트으으','2022-04-04 16:46:48','2022-04-04 16:46:48');
INSERT INTO `product` (`product_id`,`seller_id`,`work_available`,`title`,`category`,`content`,`commission`,`refund_policy`,`createdAt`,`updatedAt`) VALUES (24,4,1,'상품 등록 테스트으으으','디자인','상품 등록 테스트으으',30,'약관 테스트으으','2022-04-04 16:46:49','2022-04-04 16:46:49');
INSERT INTO `product` (`product_id`,`seller_id`,`work_available`,`title`,`category`,`content`,`commission`,`refund_policy`,`createdAt`,`updatedAt`) VALUES (25,4,1,'상품 등록 테스트으으으','디자인','상품 등록 테스트으으',30,'약관 테스트으으','2022-04-04 16:46:49','2022-04-04 16:46:49');
INSERT INTO `product` (`product_id`,`seller_id`,`work_available`,`title`,`category`,`content`,`commission`,`refund_policy`,`createdAt`,`updatedAt`) VALUES (26,4,1,'상품 등록 테스트으으으','디자인','상품 등록 테스트으으',30,'약관 테스트으으','2022-04-04 16:46:51','2022-04-04 16:46:51');
INSERT INTO `product` (`product_id`,`seller_id`,`work_available`,`title`,`category`,`content`,`commission`,`refund_policy`,`createdAt`,`updatedAt`) VALUES (27,4,1,'상품 등록 테스트으으으','디자인','상품 등록 테스트으으',30,'약관 테스트으으','2022-04-04 16:46:51','2022-04-04 16:46:51');
INSERT INTO `product` (`product_id`,`seller_id`,`work_available`,`title`,`category`,`content`,`commission`,`refund_policy`,`createdAt`,`updatedAt`) VALUES (28,4,1,'상품 등록 테스트으으으','디자인','상품 등록 테스트으으',30,'약관 테스트으으','2022-04-04 16:46:51','2022-04-04 16:46:51');
INSERT INTO `product` (`product_id`,`seller_id`,`work_available`,`title`,`category`,`content`,`commission`,`refund_policy`,`createdAt`,`updatedAt`) VALUES (29,4,1,'상품 등록 테스트으으으','디자인','상품 등록 테스트으으',30,'약관 테스트으으','2022-04-04 16:46:51','2022-04-04 16:46:51');
INSERT INTO `product` (`product_id`,`seller_id`,`work_available`,`title`,`category`,`content`,`commission`,`refund_policy`,`createdAt`,`updatedAt`) VALUES (30,4,1,'상품 등록 테스트으으으','영상','상품 등록 테스트으으',30,'약관 테스트으으','2022-04-04 21:15:37','2022-04-04 21:15:37');
INSERT INTO `product` (`product_id`,`seller_id`,`work_available`,`title`,`category`,`content`,`commission`,`refund_policy`,`createdAt`,`updatedAt`) VALUES (31,4,1,'첫번째다아아','영상','상품 등록 테스트으으',30,'약관 테스트으으','2022-04-05 20:10:11','2022-04-05 20:10:11');
INSERT INTO `product` (`product_id`,`seller_id`,`work_available`,`title`,`category`,`content`,`commission`,`refund_policy`,`createdAt`,`updatedAt`) VALUES (32,4,1,'첫번째다아아','영상','상품 등록 테스트으으',30,'약관 테스트으으','2022-04-05 20:28:50','2022-04-05 20:28:50');
INSERT INTO `product` (`product_id`,`seller_id`,`work_available`,`title`,`category`,`content`,`commission`,`refund_policy`,`createdAt`,`updatedAt`) VALUES (33,4,1,'첫번째다아아','영상','상품 등록 테스트으으',30,'약관 테스트으으','2022-04-05 20:28:50','2022-04-05 20:28:50');
INSERT INTO `product` (`product_id`,`seller_id`,`work_available`,`title`,`category`,`content`,`commission`,`refund_policy`,`createdAt`,`updatedAt`) VALUES (34,4,1,'첫번째다아아','영상','상품 등록 테스트으으',30,'약관 테스트으으','2022-04-05 20:28:54','2022-04-05 20:28:54');
INSERT INTO `product` (`product_id`,`seller_id`,`work_available`,`title`,`category`,`content`,`commission`,`refund_policy`,`createdAt`,`updatedAt`) VALUES (35,4,1,'첫번째다아아','영상','상품 등록 테스트으으',30,'약관 테스트으으','2022-04-05 20:28:55','2022-04-05 20:28:55');
INSERT INTO `product` (`product_id`,`seller_id`,`work_available`,`title`,`category`,`content`,`commission`,`refund_policy`,`createdAt`,`updatedAt`) VALUES (36,4,1,'첫번째다아아','영상','상품 등록 테스트으으',30,'약관 테스트으으','2022-04-05 20:28:55','2022-04-05 20:28:55');
INSERT INTO `product` (`product_id`,`seller_id`,`work_available`,`title`,`category`,`content`,`commission`,`refund_policy`,`createdAt`,`updatedAt`) VALUES (37,4,1,'첫번째다아아','영상','상품 등록 테스트으으',30,'약관 테스트으으','2022-04-05 20:28:55','2022-04-05 20:28:55');
INSERT INTO `product` (`product_id`,`seller_id`,`work_available`,`title`,`category`,`content`,`commission`,`refund_policy`,`createdAt`,`updatedAt`) VALUES (38,4,1,'첫번째다아아','영상','상품 등록 테스트으으',30,'약관 테스트으으','2022-04-05 20:28:56','2022-04-05 20:28:56');
INSERT INTO `product` (`product_id`,`seller_id`,`work_available`,`title`,`category`,`content`,`commission`,`refund_policy`,`createdAt`,`updatedAt`) VALUES (39,4,1,'첫번째다아아','영상','상품 등록 테스트으으',30,'약관 테스트으으','2022-04-05 20:28:56','2022-04-05 20:28:56');
INSERT INTO `product` (`product_id`,`seller_id`,`work_available`,`title`,`category`,`content`,`commission`,`refund_policy`,`createdAt`,`updatedAt`) VALUES (40,4,1,'첫번째다아아','영상','상품 등록 테스트으으',30,'약관 테스트으으','2022-04-05 20:28:56','2022-04-05 20:28:56');
INSERT INTO `product` (`product_id`,`seller_id`,`work_available`,`title`,`category`,`content`,`commission`,`refund_policy`,`createdAt`,`updatedAt`) VALUES (41,4,1,'첫번째다아아','영상','상품 등록 테스트으으',30,'약관 테스트으으','2022-04-05 20:28:56','2022-04-05 20:28:56');
INSERT INTO `product` (`product_id`,`seller_id`,`work_available`,`title`,`category`,`content`,`commission`,`refund_policy`,`createdAt`,`updatedAt`) VALUES (42,4,1,'첫번째다아아','영상','상품 등록 테스트으으',30,'약관 테스트으으','2022-04-05 20:28:57','2022-04-05 20:28:57');
INSERT INTO `product` (`product_id`,`seller_id`,`work_available`,`title`,`category`,`content`,`commission`,`refund_policy`,`createdAt`,`updatedAt`) VALUES (43,4,1,'첫번째다아아','영상','상품 등록 테스트으으',30,'약관 테스트으으','2022-04-05 20:28:57','2022-04-05 20:28:57');
INSERT INTO `product` (`product_id`,`seller_id`,`work_available`,`title`,`category`,`content`,`commission`,`refund_policy`,`createdAt`,`updatedAt`) VALUES (44,4,1,'첫번째다아아','영상','상품 등록 테스트으으',30,'약관 테스트으으','2022-04-05 20:28:57','2022-04-05 20:28:57');
INSERT INTO `product` (`product_id`,`seller_id`,`work_available`,`title`,`category`,`content`,`commission`,`refund_policy`,`createdAt`,`updatedAt`) VALUES (45,4,1,'첫번째다아아','영상','상품 등록 테스트으으',30,'약관 테스트으으','2022-04-05 20:28:57','2022-04-05 20:28:57');
INSERT INTO `product` (`product_id`,`seller_id`,`work_available`,`title`,`category`,`content`,`commission`,`refund_policy`,`createdAt`,`updatedAt`) VALUES (46,4,1,'첫번째다아아','영상','상품 등록 테스트으으',30,'약관 테스트으으','2022-04-05 20:28:57','2022-04-05 20:28:57');
INSERT INTO `product` (`product_id`,`seller_id`,`work_available`,`title`,`category`,`content`,`commission`,`refund_policy`,`createdAt`,`updatedAt`) VALUES (47,4,1,'첫번째다아아','영상','상품 등록 테스트으으',30,'약관 테스트으으','2022-04-05 20:28:58','2022-04-05 20:28:58');
INSERT INTO `product` (`product_id`,`seller_id`,`work_available`,`title`,`category`,`content`,`commission`,`refund_policy`,`createdAt`,`updatedAt`) VALUES (48,4,1,'첫번째다아아','영상','상품 등록 테스트으으',30,'약관 테스트으으','2022-04-05 20:28:58','2022-04-05 20:28:58');
INSERT INTO `product` (`product_id`,`seller_id`,`work_available`,`title`,`category`,`content`,`commission`,`refund_policy`,`createdAt`,`updatedAt`) VALUES (49,4,1,'첫번째다아아','영상','상품 등록 테스트으으',30,'약관 테스트으으','2022-04-05 20:28:58','2022-04-05 20:28:58');
INSERT INTO `product` (`product_id`,`seller_id`,`work_available`,`title`,`category`,`content`,`commission`,`refund_policy`,`createdAt`,`updatedAt`) VALUES (50,4,1,'첫번째다아아','영상','상품 등록 테스트으으',30,'약관 테스트으으','2022-04-05 20:28:58','2022-04-05 20:28:58');
INSERT INTO `product` (`product_id`,`seller_id`,`work_available`,`title`,`category`,`content`,`commission`,`refund_policy`,`createdAt`,`updatedAt`) VALUES (51,4,1,'첫번째다아아','영상','상품 등록 테스트으으',30,'약관 테스트으으','2022-04-05 20:28:58','2022-04-05 20:28:58');
INSERT INTO `product` (`product_id`,`seller_id`,`work_available`,`title`,`category`,`content`,`commission`,`refund_policy`,`createdAt`,`updatedAt`) VALUES (52,4,1,'첫번째다아아','영상','상품 등록 테스트으으',30,'약관 테스트으으','2022-04-05 20:28:59','2022-04-05 20:28:59');
INSERT INTO `product` (`product_id`,`seller_id`,`work_available`,`title`,`category`,`content`,`commission`,`refund_policy`,`createdAt`,`updatedAt`) VALUES (53,4,1,'첫번째다아아','영상','상품 등록 테스트으으',30,'약관 테스트으으','2022-04-05 20:28:59','2022-04-05 20:28:59');
INSERT INTO `product` (`product_id`,`seller_id`,`work_available`,`title`,`category`,`content`,`commission`,`refund_policy`,`createdAt`,`updatedAt`) VALUES (54,4,1,'첫번째다아아','영상','상품 등록 테스트으으',30,'약관 테스트으으','2022-04-05 20:28:59','2022-04-05 20:28:59');
INSERT INTO `product` (`product_id`,`seller_id`,`work_available`,`title`,`category`,`content`,`commission`,`refund_policy`,`createdAt`,`updatedAt`) VALUES (55,4,1,'첫번째다아아','영상','상품 등록 테스트으으',30,'약관 테스트으으','2022-04-05 20:28:59','2022-04-05 20:28:59');
INSERT INTO `product` (`product_id`,`seller_id`,`work_available`,`title`,`category`,`content`,`commission`,`refund_policy`,`createdAt`,`updatedAt`) VALUES (56,4,1,'첫번째다아아','영상','상품 등록 테스트으으',30,'약관 테스트으으','2022-04-05 20:28:59','2022-04-05 20:28:59');
INSERT INTO `product` (`product_id`,`seller_id`,`work_available`,`title`,`category`,`content`,`commission`,`refund_policy`,`createdAt`,`updatedAt`) VALUES (57,4,1,'첫번째다아아','영상','상품 등록 테스트으으',30,'약관 테스트으으','2022-04-05 20:29:00','2022-04-05 20:29:00');
INSERT INTO `product` (`product_id`,`seller_id`,`work_available`,`title`,`category`,`content`,`commission`,`refund_policy`,`createdAt`,`updatedAt`) VALUES (58,4,1,'첫번째다아아','영상','상품 등록 테스트으으',30,'약관 테스트으으','2022-04-05 20:29:00','2022-04-05 20:29:00');
INSERT INTO `product` (`product_id`,`seller_id`,`work_available`,`title`,`category`,`content`,`commission`,`refund_policy`,`createdAt`,`updatedAt`) VALUES (59,4,1,'첫번째다아아','영상','상품 등록 테스트으으',30,'약관 테스트으으','2022-04-05 20:29:00','2022-04-05 20:29:00');
INSERT INTO `product` (`product_id`,`seller_id`,`work_available`,`title`,`category`,`content`,`commission`,`refund_policy`,`createdAt`,`updatedAt`) VALUES (60,4,1,'첫번째다아아','영상','상품 등록 테스트으으',30,'약관 테스트으으','2022-04-05 20:29:00','2022-04-05 20:29:00');
INSERT INTO `product` (`product_id`,`seller_id`,`work_available`,`title`,`category`,`content`,`commission`,`refund_policy`,`createdAt`,`updatedAt`) VALUES (61,4,1,'첫번째다아아','영상','상품 등록 테스트으으',30,'약관 테스트으으','2022-04-05 20:29:00','2022-04-05 20:29:00');
INSERT INTO `product` (`product_id`,`seller_id`,`work_available`,`title`,`category`,`content`,`commission`,`refund_policy`,`createdAt`,`updatedAt`) VALUES (62,4,1,'첫번째다아아','영상','상품 등록 테스트으으',30,'약관 테스트으으','2022-04-05 20:29:01','2022-04-05 20:29:01');
INSERT INTO `product` (`product_id`,`seller_id`,`work_available`,`title`,`category`,`content`,`commission`,`refund_policy`,`createdAt`,`updatedAt`) VALUES (63,4,1,'첫번째다아아','영상','상품 등록 테스트으으',30,'약관 테스트으으','2022-04-05 20:29:01','2022-04-05 20:29:01');
INSERT INTO `product` (`product_id`,`seller_id`,`work_available`,`title`,`category`,`content`,`commission`,`refund_policy`,`createdAt`,`updatedAt`) VALUES (64,4,1,'첫번째다아아','영상','상품 등록 테스트으으',30,'약관 테스트으으','2022-04-05 20:29:01','2022-04-05 20:29:01');
INSERT INTO `product` (`product_id`,`seller_id`,`work_available`,`title`,`category`,`content`,`commission`,`refund_policy`,`createdAt`,`updatedAt`) VALUES (65,4,1,'첫번째다아아','영상','상품 등록 테스트으으',30,'약관 테스트으으','2022-04-05 20:29:01','2022-04-05 20:29:01');
INSERT INTO `product` (`product_id`,`seller_id`,`work_available`,`title`,`category`,`content`,`commission`,`refund_policy`,`createdAt`,`updatedAt`) VALUES (66,4,1,'첫번째다아아','영상','상품 등록 테스트으으',30,'약관 테스트으으','2022-04-05 20:29:01','2022-04-05 20:29:01');
INSERT INTO `product` (`product_id`,`seller_id`,`work_available`,`title`,`category`,`content`,`commission`,`refund_policy`,`createdAt`,`updatedAt`) VALUES (67,4,1,'첫번째다아아','영상','상품 등록 테스트으으',30,'약관 테스트으으','2022-04-05 20:29:02','2022-04-05 20:29:02');
INSERT INTO `product` (`product_id`,`seller_id`,`work_available`,`title`,`category`,`content`,`commission`,`refund_policy`,`createdAt`,`updatedAt`) VALUES (68,4,1,'첫번째다아아','영상','상품 등록 테스트으으',30,'약관 테스트으으','2022-04-05 20:29:02','2022-04-05 20:29:02');
INSERT INTO `product` (`product_id`,`seller_id`,`work_available`,`title`,`category`,`content`,`commission`,`refund_policy`,`createdAt`,`updatedAt`) VALUES (69,4,1,'첫번째다아아','영상','상품 등록 테스트으으',30,'약관 테스트으으','2022-04-05 20:29:02','2022-04-05 20:29:02');
INSERT INTO `product` (`product_id`,`seller_id`,`work_available`,`title`,`category`,`content`,`commission`,`refund_policy`,`createdAt`,`updatedAt`) VALUES (70,4,1,'첫번째다아아','영상','상품 등록 테스트으으',30,'약관 테스트으으','2022-04-05 20:29:02','2022-04-05 20:29:02');
INSERT INTO `product` (`product_id`,`seller_id`,`work_available`,`title`,`category`,`content`,`commission`,`refund_policy`,`createdAt`,`updatedAt`) VALUES (71,4,1,'첫번째다아아','영상','상품 등록 테스트으으',30,'약관 테스트으으','2022-04-05 20:29:02','2022-04-05 20:29:02');
INSERT INTO `product` (`product_id`,`seller_id`,`work_available`,`title`,`category`,`content`,`commission`,`refund_policy`,`createdAt`,`updatedAt`) VALUES (72,4,1,'첫번째다아아','영상','상품 등록 테스트으으',30,'약관 테스트으으','2022-04-05 20:29:03','2022-04-05 20:29:03');
INSERT INTO `product` (`product_id`,`seller_id`,`work_available`,`title`,`category`,`content`,`commission`,`refund_policy`,`createdAt`,`updatedAt`) VALUES (73,4,1,'첫번째다아아','영상','상품 등록 테스트으으',30,'약관 테스트으으','2022-04-05 20:29:03','2022-04-05 20:29:03');
INSERT INTO `product` (`product_id`,`seller_id`,`work_available`,`title`,`category`,`content`,`commission`,`refund_policy`,`createdAt`,`updatedAt`) VALUES (74,4,1,'첫번째다아아','영상','상품 등록 테스트으으',30,'약관 테스트으으','2022-04-05 20:29:03','2022-04-05 20:29:03');
INSERT INTO `product` (`product_id`,`seller_id`,`work_available`,`title`,`category`,`content`,`commission`,`refund_policy`,`createdAt`,`updatedAt`) VALUES (75,4,1,'첫번째다아아','영상','상품 등록 테스트으으',30,'약관 테스트으으','2022-04-05 20:29:03','2022-04-05 20:29:03');
INSERT INTO `product` (`product_id`,`seller_id`,`work_available`,`title`,`category`,`content`,`commission`,`refund_policy`,`createdAt`,`updatedAt`) VALUES (76,4,1,'첫번째다아아','영상','상품 등록 테스트으으',30,'약관 테스트으으','2022-04-05 20:29:03','2022-04-05 20:29:03');
INSERT INTO `product` (`product_id`,`seller_id`,`work_available`,`title`,`category`,`content`,`commission`,`refund_policy`,`createdAt`,`updatedAt`) VALUES (77,4,1,'첫번째다아아','영상','상품 등록 테스트으으',30,'약관 테스트으으','2022-04-05 20:29:04','2022-04-05 20:29:04');
INSERT INTO `product` (`product_id`,`seller_id`,`work_available`,`title`,`category`,`content`,`commission`,`refund_policy`,`createdAt`,`updatedAt`) VALUES (78,4,1,'첫번째다아아','영상','상품 등록 테스트으으',30,'약관 테스트으으','2022-04-05 20:29:04','2022-04-05 20:29:04');
INSERT INTO `product` (`product_id`,`seller_id`,`work_available`,`title`,`category`,`content`,`commission`,`refund_policy`,`createdAt`,`updatedAt`) VALUES (79,4,1,'첫번째다아아','영상','상품 등록 테스트으으',30,'약관 테스트으으','2022-04-05 20:29:04','2022-04-05 20:29:04');
INSERT INTO `product` (`product_id`,`seller_id`,`work_available`,`title`,`category`,`content`,`commission`,`refund_policy`,`createdAt`,`updatedAt`) VALUES (80,4,1,'첫번째다아아','영상','상품 등록 테스트으으',30,'약관 테스트으으','2022-04-05 20:29:04','2022-04-05 20:29:04');
INSERT INTO `product` (`product_id`,`seller_id`,`work_available`,`title`,`category`,`content`,`commission`,`refund_policy`,`createdAt`,`updatedAt`) VALUES (81,4,1,'첫번째다아아','영상','상품 등록 테스트으으',30,'약관 테스트으으','2022-04-05 20:29:04','2022-04-05 20:29:04');
INSERT INTO `product` (`product_id`,`seller_id`,`work_available`,`title`,`category`,`content`,`commission`,`refund_policy`,`createdAt`,`updatedAt`) VALUES (82,4,1,'첫번째다아아','영상','상품 등록 테스트으으',30,'약관 테스트으으','2022-04-05 20:29:05','2022-04-05 20:29:05');
INSERT INTO `product` (`product_id`,`seller_id`,`work_available`,`title`,`category`,`content`,`commission`,`refund_policy`,`createdAt`,`updatedAt`) VALUES (83,4,1,'첫번째다아아','영상','상품 등록 테스트으으',30,'약관 테스트으으','2022-04-05 20:29:05','2022-04-05 20:29:05');
INSERT INTO `product` (`product_id`,`seller_id`,`work_available`,`title`,`category`,`content`,`commission`,`refund_policy`,`createdAt`,`updatedAt`) VALUES (84,4,1,'첫번째다아아','영상','상품 등록 테스트으으',30,'약관 테스트으으','2022-04-05 20:29:05','2022-04-05 20:29:05');
INSERT INTO `product` (`product_id`,`seller_id`,`work_available`,`title`,`category`,`content`,`commission`,`refund_policy`,`createdAt`,`updatedAt`) VALUES (85,4,1,'첫번째다아아','영상','상품 등록 테스트으으',30,'약관 테스트으으','2022-04-05 20:29:05','2022-04-05 20:29:05');
INSERT INTO `product` (`product_id`,`seller_id`,`work_available`,`title`,`category`,`content`,`commission`,`refund_policy`,`createdAt`,`updatedAt`) VALUES (86,4,1,'첫번째다아아','영상','상품 등록 테스트으으',30,'약관 테스트으으','2022-04-05 20:29:05','2022-04-05 20:29:05');
INSERT INTO `product` (`product_id`,`seller_id`,`work_available`,`title`,`category`,`content`,`commission`,`refund_policy`,`createdAt`,`updatedAt`) VALUES (87,4,1,'첫번째다아아','영상','상품 등록 테스트으으',30,'약관 테스트으으','2022-04-05 20:29:05','2022-04-05 20:29:05');
INSERT INTO `product` (`product_id`,`seller_id`,`work_available`,`title`,`category`,`content`,`commission`,`refund_policy`,`createdAt`,`updatedAt`) VALUES (88,4,1,'첫번째다아아','영상','상품 등록 테스트으으',30,'약관 테스트으으','2022-04-05 20:29:06','2022-04-05 20:29:06');
INSERT INTO `product` (`product_id`,`seller_id`,`work_available`,`title`,`category`,`content`,`commission`,`refund_policy`,`createdAt`,`updatedAt`) VALUES (89,4,1,'첫번째다아아','영상','상품 등록 테스트으으',30,'약관 테스트으으','2022-04-05 20:29:06','2022-04-05 20:29:06');
INSERT INTO `product` (`product_id`,`seller_id`,`work_available`,`title`,`category`,`content`,`commission`,`refund_policy`,`createdAt`,`updatedAt`) VALUES (90,4,1,'첫번째다아아','영상','상품 등록 테스트으으',30,'약관 테스트으으','2022-04-05 20:29:06','2022-04-05 20:29:06');
INSERT INTO `product` (`product_id`,`seller_id`,`work_available`,`title`,`category`,`content`,`commission`,`refund_policy`,`createdAt`,`updatedAt`) VALUES (91,4,1,'첫번째다아아','영상','상품 등록 테스트으으',30,'약관 테스트으으','2022-04-05 20:29:06','2022-04-05 20:29:06');
INSERT INTO `product` (`product_id`,`seller_id`,`work_available`,`title`,`category`,`content`,`commission`,`refund_policy`,`createdAt`,`updatedAt`) VALUES (92,4,1,'첫번째다아아','영상','상품 등록 테스트으으',30,'약관 테스트으으','2022-04-05 20:29:06','2022-04-05 20:29:06');
INSERT INTO `product` (`product_id`,`seller_id`,`work_available`,`title`,`category`,`content`,`commission`,`refund_policy`,`createdAt`,`updatedAt`) VALUES (93,4,1,'첫번째다아아','영상','상품 등록 테스트으으',30,'약관 테스트으으','2022-04-05 20:29:07','2022-04-05 20:29:07');
INSERT INTO `product` (`product_id`,`seller_id`,`work_available`,`title`,`category`,`content`,`commission`,`refund_policy`,`createdAt`,`updatedAt`) VALUES (94,4,1,'첫번째다아아','영상','상품 등록 테스트으으',30,'약관 테스트으으','2022-04-05 20:29:07','2022-04-05 20:29:07');
INSERT INTO `product` (`product_id`,`seller_id`,`work_available`,`title`,`category`,`content`,`commission`,`refund_policy`,`createdAt`,`updatedAt`) VALUES (95,4,1,'첫번째다아아','영상','상품 등록 테스트으으',30,'약관 테스트으으','2022-04-05 20:29:07','2022-04-05 20:29:07');
INSERT INTO `product` (`product_id`,`seller_id`,`work_available`,`title`,`category`,`content`,`commission`,`refund_policy`,`createdAt`,`updatedAt`) VALUES (96,4,1,'첫번째다아아','영상','상품 등록 테스트으으',30,'약관 테스트으으','2022-04-05 20:29:07','2022-04-05 20:29:07');
INSERT INTO `product` (`product_id`,`seller_id`,`work_available`,`title`,`category`,`content`,`commission`,`refund_policy`,`createdAt`,`updatedAt`) VALUES (97,4,1,'첫번째다아아','영상','상품 등록 테스트으으',30,'약관 테스트으으','2022-04-05 20:29:07','2022-04-05 20:29:07');
INSERT INTO `product` (`product_id`,`seller_id`,`work_available`,`title`,`category`,`content`,`commission`,`refund_policy`,`createdAt`,`updatedAt`) VALUES (98,4,1,'첫번째다아아','영상','상품 등록 테스트으으',30,'약관 테스트으으','2022-04-05 20:29:07','2022-04-05 20:29:07');
INSERT INTO `product` (`product_id`,`seller_id`,`work_available`,`title`,`category`,`content`,`commission`,`refund_policy`,`createdAt`,`updatedAt`) VALUES (99,4,1,'첫번째다아아','영상','상품 등록 테스트으으',30,'약관 테스트으으','2022-04-05 20:29:08','2022-04-05 20:29:08');
INSERT INTO `product` (`product_id`,`seller_id`,`work_available`,`title`,`category`,`content`,`commission`,`refund_policy`,`createdAt`,`updatedAt`) VALUES (100,4,1,'첫번째다아아','영상','상품 등록 테스트으으',30,'약관 테스트으으','2022-04-05 20:29:08','2022-04-05 20:29:08');
INSERT INTO `product` (`product_id`,`seller_id`,`work_available`,`title`,`category`,`content`,`commission`,`refund_policy`,`createdAt`,`updatedAt`) VALUES (101,4,1,'첫번째다아아','영상','상품 등록 테스트으으',30,'약관 테스트으으','2022-04-05 20:29:08','2022-04-05 20:29:08');
INSERT INTO `product` (`product_id`,`seller_id`,`work_available`,`title`,`category`,`content`,`commission`,`refund_policy`,`createdAt`,`updatedAt`) VALUES (102,4,1,'첫번째다아아','영상','상품 등록 테스트으으',30,'약관 테스트으으','2022-04-05 20:29:08','2022-04-05 20:29:08');
INSERT INTO `product` (`product_id`,`seller_id`,`work_available`,`title`,`category`,`content`,`commission`,`refund_policy`,`createdAt`,`updatedAt`) VALUES (103,4,1,'첫번째다아아','영상','상품 등록 테스트으으',30,'약관 테스트으으','2022-04-05 20:29:09','2022-04-05 20:29:09');
INSERT INTO `product` (`product_id`,`seller_id`,`work_available`,`title`,`category`,`content`,`commission`,`refund_policy`,`createdAt`,`updatedAt`) VALUES (104,4,1,'첫번째다아아','영상','상품 등록 테스트으으',30,'약관 테스트으으','2022-04-05 20:29:09','2022-04-05 20:29:09');
INSERT INTO `product` (`product_id`,`seller_id`,`work_available`,`title`,`category`,`content`,`commission`,`refund_policy`,`createdAt`,`updatedAt`) VALUES (105,4,1,'첫번째다아아','영상','상품 등록 테스트으으',30,'약관 테스트으으','2022-04-05 20:29:09','2022-04-05 20:29:09');
INSERT INTO `product` (`product_id`,`seller_id`,`work_available`,`title`,`category`,`content`,`commission`,`refund_policy`,`createdAt`,`updatedAt`) VALUES (106,4,1,'첫번째다아아','영상','상품 등록 테스트으으',30,'약관 테스트으으','2022-04-05 20:29:09','2022-04-05 20:29:09');
INSERT INTO `product` (`product_id`,`seller_id`,`work_available`,`title`,`category`,`content`,`commission`,`refund_policy`,`createdAt`,`updatedAt`) VALUES (107,4,1,'첫번째다아아','영상','상품 등록 테스트으으',30,'약관 테스트으으','2022-04-05 20:29:09','2022-04-05 20:29:09');
INSERT INTO `product` (`product_id`,`seller_id`,`work_available`,`title`,`category`,`content`,`commission`,`refund_policy`,`createdAt`,`updatedAt`) VALUES (108,4,1,'첫번째다아아','영상','상품 등록 테스트으으',30,'약관 테스트으으','2022-04-05 20:29:09','2022-04-05 20:29:09');
INSERT INTO `product` (`product_id`,`seller_id`,`work_available`,`title`,`category`,`content`,`commission`,`refund_policy`,`createdAt`,`updatedAt`) VALUES (109,4,1,'첫번째다아아','영상','상품 등록 테스트으으',30,'약관 테스트으으','2022-04-05 20:29:10','2022-04-05 20:29:10');
INSERT INTO `product` (`product_id`,`seller_id`,`work_available`,`title`,`category`,`content`,`commission`,`refund_policy`,`createdAt`,`updatedAt`) VALUES (110,4,1,'첫번째다아아','영상','상품 등록 테스트으으',30,'약관 테스트으으','2022-04-05 20:29:10','2022-04-05 20:29:10');
INSERT INTO `product` (`product_id`,`seller_id`,`work_available`,`title`,`category`,`content`,`commission`,`refund_policy`,`createdAt`,`updatedAt`) VALUES (111,4,1,'첫번째다아아','영상','상품 등록 테스트으으',30,'약관 테스트으으','2022-04-05 20:29:10','2022-04-05 20:29:10');
INSERT INTO `product` (`product_id`,`seller_id`,`work_available`,`title`,`category`,`content`,`commission`,`refund_policy`,`createdAt`,`updatedAt`) VALUES (112,4,1,'첫번째다아아','영상','상품 등록 테스트으으',30,'약관 테스트으으','2022-04-05 20:29:10','2022-04-05 20:29:10');
INSERT INTO `product` (`product_id`,`seller_id`,`work_available`,`title`,`category`,`content`,`commission`,`refund_policy`,`createdAt`,`updatedAt`) VALUES (113,4,1,'두번째다아아','영상','상품 등록 테스트으으',30,'약관 테스트으으','2022-04-05 22:28:08','2022-04-05 22:28:08');
INSERT INTO `product` (`product_id`,`seller_id`,`work_available`,`title`,`category`,`content`,`commission`,`refund_policy`,`createdAt`,`updatedAt`) VALUES (114,4,1,'두번째다아아','영상','상품 등록 테스트으으',30,'약관 테스트으으','2022-04-05 22:28:09','2022-04-05 22:28:09');
INSERT INTO `product` (`product_id`,`seller_id`,`work_available`,`title`,`category`,`content`,`commission`,`refund_policy`,`createdAt`,`updatedAt`) VALUES (115,4,1,'두번째다아아','영상','상품 등록 테스트으으',30,'약관 테스트으으','2022-04-05 22:28:09','2022-04-05 22:28:09');
INSERT INTO `product` (`product_id`,`seller_id`,`work_available`,`title`,`category`,`content`,`commission`,`refund_policy`,`createdAt`,`updatedAt`) VALUES (116,4,1,'두번째다아아','영상','상품 등록 테스트으으',30,'약관 테스트으으','2022-04-05 22:28:10','2022-04-05 22:28:10');
INSERT INTO `product` (`product_id`,`seller_id`,`work_available`,`title`,`category`,`content`,`commission`,`refund_policy`,`createdAt`,`updatedAt`) VALUES (117,4,1,'두번째다아아','영상','상품 등록 테스트으으',30,'약관 테스트으으','2022-04-05 22:28:10','2022-04-05 22:28:10');
INSERT INTO `product` (`product_id`,`seller_id`,`work_available`,`title`,`category`,`content`,`commission`,`refund_policy`,`createdAt`,`updatedAt`) VALUES (118,4,1,'두번째다아아','영상','상품 등록 테스트으으',30,'약관 테스트으으','2022-04-05 22:28:11','2022-04-05 22:28:11');
INSERT INTO `product` (`product_id`,`seller_id`,`work_available`,`title`,`category`,`content`,`commission`,`refund_policy`,`createdAt`,`updatedAt`) VALUES (119,4,1,'두번째다아아','영상','상품 등록 테스트으으',30,'약관 테스트으으','2022-04-05 22:28:16','2022-04-05 22:28:16');
INSERT INTO `product` (`product_id`,`seller_id`,`work_available`,`title`,`category`,`content`,`commission`,`refund_policy`,`createdAt`,`updatedAt`) VALUES (120,4,1,'두번째다아아','영상','상품 등록 테스트으으',30,'약관 테스트으으','2022-04-05 22:28:16','2022-04-05 22:28:16');
INSERT INTO `product` (`product_id`,`seller_id`,`work_available`,`title`,`category`,`content`,`commission`,`refund_policy`,`createdAt`,`updatedAt`) VALUES (121,4,1,'두번째다아아','영상','상품 등록 테스트으으',30,'약관 테스트으으','2022-04-05 22:28:16','2022-04-05 22:28:16');
INSERT INTO `product` (`product_id`,`seller_id`,`work_available`,`title`,`category`,`content`,`commission`,`refund_policy`,`createdAt`,`updatedAt`) VALUES (122,4,1,'두번째다아아','영상','상품 등록 테스트으으',30,'약관 테스트으으','2022-04-05 22:28:17','2022-04-05 22:28:17');
INSERT INTO `product` (`product_id`,`seller_id`,`work_available`,`title`,`category`,`content`,`commission`,`refund_policy`,`createdAt`,`updatedAt`) VALUES (123,4,1,'두번째다아아','영상','상품 등록 테스트으으',30,'약관 테스트으으','2022-04-05 22:28:17','2022-04-05 22:28:17');
INSERT INTO `product` (`product_id`,`seller_id`,`work_available`,`title`,`category`,`content`,`commission`,`refund_policy`,`createdAt`,`updatedAt`) VALUES (124,4,1,'두번째다아아','영상','상품 등록 테스트으으',30,'약관 테스트으으','2022-04-05 22:28:18','2022-04-05 22:28:18');
INSERT INTO `product` (`product_id`,`seller_id`,`work_available`,`title`,`category`,`content`,`commission`,`refund_policy`,`createdAt`,`updatedAt`) VALUES (125,4,1,'두번째다아아','영상','상품 등록 테스트으으',30,'약관 테스트으으','2022-04-05 22:28:18','2022-04-05 22:28:18');
INSERT INTO `product` (`product_id`,`seller_id`,`work_available`,`title`,`category`,`content`,`commission`,`refund_policy`,`createdAt`,`updatedAt`) VALUES (126,4,1,'두번째다아아','영상','상품 등록 테스트으으',30,'약관 테스트으으','2022-04-05 22:28:18','2022-04-05 22:28:18');
INSERT INTO `product` (`product_id`,`seller_id`,`work_available`,`title`,`category`,`content`,`commission`,`refund_policy`,`createdAt`,`updatedAt`) VALUES (127,4,1,'두번째다아아','영상','상품 등록 테스트으으',30,'약관 테스트으으','2022-04-05 22:28:18','2022-04-05 22:28:18');
INSERT INTO `product` (`product_id`,`seller_id`,`work_available`,`title`,`category`,`content`,`commission`,`refund_policy`,`createdAt`,`updatedAt`) VALUES (128,4,1,'두번째다아아','영상','상품 등록 테스트으으',30,'약관 테스트으으','2022-04-05 22:28:19','2022-04-05 22:28:19');
INSERT INTO `product` (`product_id`,`seller_id`,`work_available`,`title`,`category`,`content`,`commission`,`refund_policy`,`createdAt`,`updatedAt`) VALUES (129,4,1,'두번째다아아','영상','상품 등록 테스트으으',30,'약관 테스트으으','2022-04-05 22:28:19','2022-04-05 22:28:19');
INSERT INTO `product` (`product_id`,`seller_id`,`work_available`,`title`,`category`,`content`,`commission`,`refund_policy`,`createdAt`,`updatedAt`) VALUES (130,4,1,'두번째다아아','영상','상품 등록 테스트으으',30,'약관 테스트으으','2022-04-05 22:28:19','2022-04-05 22:28:19');
INSERT INTO `product` (`product_id`,`seller_id`,`work_available`,`title`,`category`,`content`,`commission`,`refund_policy`,`createdAt`,`updatedAt`) VALUES (131,4,1,'두번째다아아','영상','상품 등록 테스트으으',30,'약관 테스트으으','2022-04-05 22:28:19','2022-04-05 22:28:19');
INSERT INTO `product` (`product_id`,`seller_id`,`work_available`,`title`,`category`,`content`,`commission`,`refund_policy`,`createdAt`,`updatedAt`) VALUES (132,4,1,'두번째다아아','영상','상품 등록 테스트으으',30,'약관 테스트으으','2022-04-05 22:28:19','2022-04-05 22:28:19');
INSERT INTO `product` (`product_id`,`seller_id`,`work_available`,`title`,`category`,`content`,`commission`,`refund_policy`,`createdAt`,`updatedAt`) VALUES (133,4,1,'두번째다아아','영상','상품 등록 테스트으으',30,'약관 테스트으으','2022-04-05 22:28:20','2022-04-05 22:28:20');
INSERT INTO `product` (`product_id`,`seller_id`,`work_available`,`title`,`category`,`content`,`commission`,`refund_policy`,`createdAt`,`updatedAt`) VALUES (134,4,1,'두번째다아아','영상','상품 등록 테스트으으',30,'약관 테스트으으','2022-04-05 22:28:20','2022-04-05 22:28:20');
INSERT INTO `product` (`product_id`,`seller_id`,`work_available`,`title`,`category`,`content`,`commission`,`refund_policy`,`createdAt`,`updatedAt`) VALUES (135,4,1,'두번째다아아','영상','상품 등록 테스트으으',30,'약관 테스트으으','2022-04-05 22:28:20','2022-04-05 22:28:20');
INSERT INTO `product` (`product_id`,`seller_id`,`work_available`,`title`,`category`,`content`,`commission`,`refund_policy`,`createdAt`,`updatedAt`) VALUES (136,4,1,'두번째다아아','영상','상품 등록 테스트으으',30,'약관 테스트으으','2022-04-05 22:28:21','2022-04-05 22:28:21');
INSERT INTO `product` (`product_id`,`seller_id`,`work_available`,`title`,`category`,`content`,`commission`,`refund_policy`,`createdAt`,`updatedAt`) VALUES (137,4,1,'두번째다아아','영상','상품 등록 테스트으으',30,'약관 테스트으으','2022-04-05 22:28:21','2022-04-05 22:28:21');
INSERT INTO `product` (`product_id`,`seller_id`,`work_available`,`title`,`category`,`content`,`commission`,`refund_policy`,`createdAt`,`updatedAt`) VALUES (138,4,1,'두번째다아아','영상','상품 등록 테스트으으',30,'약관 테스트으으','2022-04-06 11:07:34','2022-04-06 11:07:34');
INSERT INTO `product` (`product_id`,`seller_id`,`work_available`,`title`,`category`,`content`,`commission`,`refund_policy`,`createdAt`,`updatedAt`) VALUES (139,4,1,'카카','영상','카카',30,'약관 테스트으으','2022-04-08 10:39:32','2022-04-08 10:39:32');
INSERT INTO `product` (`product_id`,`seller_id`,`work_available`,`title`,`category`,`content`,`commission`,`refund_policy`,`createdAt`,`updatedAt`) VALUES (140,5,1,'카카','영상','상품 등록 테스트',30,'약관 테스트으으','2022-04-08 10:40:29','2022-04-08 10:40:29');

INSERT INTO `f_info` (`f_id`,`address`,`address2`,`introduction`,`switchAt`) VALUES (1,'서울 마포구 가양대로 1','111호','학력: 동동\r\n\r\n경력:동동\r\n\r\n자격증: 동동\r\n\r\n사회활동: 동동\r\n \r\n													\r\n','2022-04-04 16:42:16');
INSERT INTO `f_info` (`f_id`,`address`,`address2`,`introduction`,`switchAt`) VALUES (2,'서울 마포구 가양대로 1','11','학력: \r\n\r\n경력:\r\n\r\n자격증:\r\n\r\n사회활동:\r\n\r\n \r\n													\r\n','2022-04-07 22:09:31');

/*
-- Query: SELECT * FROM hier.review
-- Date: 2022-04-08 16:48
*/
INSERT INTO `review` (`review_id`,`review_wid`,`product_id`,`seller_id`,`content`,`star_point`,`createdAt`) VALUES (1,1,1,4,'긴글테스트으~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~',3,'2022-03-31 14:38:44');
INSERT INTO `review` (`review_id`,`review_wid`,`product_id`,`seller_id`,`content`,`star_point`,`createdAt`) VALUES (2,3,3,4,'리뷰 테스트3',4,'2022-03-31 14:38:44');
INSERT INTO `review` (`review_id`,`review_wid`,`product_id`,`seller_id`,`content`,`star_point`,`createdAt`) VALUES (3,3,2,4,'리뷰 테스트2',2,'2022-03-31 14:38:44');
INSERT INTO `review` (`review_id`,`review_wid`,`product_id`,`seller_id`,`content`,`star_point`,`createdAt`) VALUES (4,3,2,4,'리뷰 테스트으으',2,'2022-03-31 17:36:31');
INSERT INTO `review` (`review_id`,`review_wid`,`product_id`,`seller_id`,`content`,`star_point`,`createdAt`) VALUES (5,3,2,4,'리뷰 별점 테스트으으',1,'2022-04-01 09:15:53');
INSERT INTO `review` (`review_id`,`review_wid`,`product_id`,`seller_id`,`content`,`star_point`,`createdAt`) VALUES (6,1,2,4,'리뷰 별점 테스트으으으으',5,'2022-04-01 09:16:10');
INSERT INTO `review` (`review_id`,`review_wid`,`product_id`,`seller_id`,`content`,`star_point`,`createdAt`) VALUES (9,1,2,4,'리뷰 별점 테스트으으으으',5,'2022-04-04 09:32:29');
INSERT INTO `review` (`review_id`,`review_wid`,`product_id`,`seller_id`,`content`,`star_point`,`createdAt`) VALUES (10,1,2,4,'리뷰 별점 테스트으으으으',5,'2022-04-04 09:32:31');
INSERT INTO `review` (`review_id`,`review_wid`,`product_id`,`seller_id`,`content`,`star_point`,`createdAt`) VALUES (11,1,2,4,'리뷰 별점 테스트으으으으',5,'2022-04-04 09:32:31');
INSERT INTO `review` (`review_id`,`review_wid`,`product_id`,`seller_id`,`content`,`star_point`,`createdAt`) VALUES (12,1,2,4,'리뷰 별점 테스트으으으으',5,'2022-04-04 09:32:31');
INSERT INTO `review` (`review_id`,`review_wid`,`product_id`,`seller_id`,`content`,`star_point`,`createdAt`) VALUES (13,1,2,4,'리뷰 별점 테스트으으으으',5,'2022-04-04 09:32:31');
INSERT INTO `review` (`review_id`,`review_wid`,`product_id`,`seller_id`,`content`,`star_point`,`createdAt`) VALUES (14,1,2,4,'리뷰 별점 테스트으으으으',5,'2022-04-04 09:32:31');
INSERT INTO `review` (`review_id`,`review_wid`,`product_id`,`seller_id`,`content`,`star_point`,`createdAt`) VALUES (15,1,2,4,'리뷰 별점 테스트으으으으',5,'2022-04-04 14:46:16');
INSERT INTO `review` (`review_id`,`review_wid`,`product_id`,`seller_id`,`content`,`star_point`,`createdAt`) VALUES (16,1,2,4,'리뷰 별점 테스트으으으으',5,'2022-04-04 14:46:44');
INSERT INTO `review` (`review_id`,`review_wid`,`product_id`,`seller_id`,`content`,`star_point`,`createdAt`) VALUES (17,1,3,4,'리뷰 별점 테스트으으으으',5,'2022-04-04 17:50:34');
INSERT INTO `review` (`review_id`,`review_wid`,`product_id`,`seller_id`,`content`,`star_point`,`createdAt`) VALUES (18,1,30,4,'리뷰 별점 테스트으으으윽',5,'2022-04-05 10:25:30');
INSERT INTO `review` (`review_id`,`review_wid`,`product_id`,`seller_id`,`content`,`star_point`,`createdAt`) VALUES (19,1,29,4,'리뷰 별점 테스트으으으이윽',5,'2022-04-05 10:26:00');
INSERT INTO `review` (`review_id`,`review_wid`,`product_id`,`seller_id`,`content`,`star_point`,`createdAt`) VALUES (20,1,29,4,'리뷰 별점 테스트으으으이ㅇ;ㅇ;ㅇ;윽',5,'2022-04-05 10:26:03');
INSERT INTO `review` (`review_id`,`review_wid`,`product_id`,`seller_id`,`content`,`star_point`,`createdAt`) VALUES (21,1,29,4,'리뷰 별점 테스트으으으이ㅇ;ㅇ;ㅇ;윽',5,'2022-04-06 14:27:22');
INSERT INTO `review` (`review_id`,`review_wid`,`product_id`,`seller_id`,`content`,`star_point`,`createdAt`) VALUES (22,1,29,4,'리뷰 별점 테스트으으으이ㅇ;ㅇ;ㅇ;윽',5,'2022-04-06 14:27:23');
INSERT INTO `review` (`review_id`,`review_wid`,`product_id`,`seller_id`,`content`,`star_point`,`createdAt`) VALUES (23,1,29,4,'리뷰 별점 테스트으으으이ㅇ;ㅇ;ㅇ;윽',5,'2022-04-06 14:27:23');
INSERT INTO `review` (`review_id`,`review_wid`,`product_id`,`seller_id`,`content`,`star_point`,`createdAt`) VALUES (24,1,29,4,'리뷰 별점 테스트으으으이ㅇ;ㅇ;ㅇ;윽',5,'2022-04-06 14:27:23');
INSERT INTO `review` (`review_id`,`review_wid`,`product_id`,`seller_id`,`content`,`star_point`,`createdAt`) VALUES (25,1,29,4,'리뷰 별점 테스트으으으이ㅇ;ㅇ;ㅇ;윽',5,'2022-04-06 14:27:25');
INSERT INTO `review` (`review_id`,`review_wid`,`product_id`,`seller_id`,`content`,`star_point`,`createdAt`) VALUES (26,1,29,4,'리뷰 별점 테스트으으으이ㅇ;ㅇ;ㅇ;윽',5,'2022-04-06 14:27:25');
INSERT INTO `review` (`review_id`,`review_wid`,`product_id`,`seller_id`,`content`,`star_point`,`createdAt`) VALUES (27,1,29,4,'리뷰 별점 테스트으으으이ㅇ;ㅇ;ㅇ;윽',5,'2022-04-06 14:27:26');
INSERT INTO `review` (`review_id`,`review_wid`,`product_id`,`seller_id`,`content`,`star_point`,`createdAt`) VALUES (28,1,29,4,'리뷰 별점 테스트으으으이ㅇ;ㅇ;ㅇ;윽',5,'2022-04-06 14:27:26');
INSERT INTO `review` (`review_id`,`review_wid`,`product_id`,`seller_id`,`content`,`star_point`,`createdAt`) VALUES (29,1,29,4,'리뷰 별점 테스트으으으이ㅇ;ㅇ;ㅇ;윽',5,'2022-04-06 14:27:26');
INSERT INTO `review` (`review_id`,`review_wid`,`product_id`,`seller_id`,`content`,`star_point`,`createdAt`) VALUES (30,1,29,4,'리뷰 별점 테스트으으으이ㅇ;ㅇ;ㅇ;윽',5,'2022-04-06 14:27:27');
INSERT INTO `review` (`review_id`,`review_wid`,`product_id`,`seller_id`,`content`,`star_point`,`createdAt`) VALUES (31,1,29,4,'리뷰 별점 테스트으으으이ㅇ;ㅇ;ㅇ;윽',5,'2022-04-06 14:27:27');
INSERT INTO `review` (`review_id`,`review_wid`,`product_id`,`seller_id`,`content`,`star_point`,`createdAt`) VALUES (32,1,29,4,'리뷰 별점 테스트으으으이ㅇ;ㅇ;ㅇ;윽',5,'2022-04-06 14:27:27');
INSERT INTO `review` (`review_id`,`review_wid`,`product_id`,`seller_id`,`content`,`star_point`,`createdAt`) VALUES (33,1,29,4,'리뷰 별점 테스트으으으이ㅇ;ㅇ;ㅇ;윽',5,'2022-04-06 14:27:27');
INSERT INTO `review` (`review_id`,`review_wid`,`product_id`,`seller_id`,`content`,`star_point`,`createdAt`) VALUES (34,1,29,4,'리뷰 별점 테스트으으으이ㅇ;ㅇ;ㅇ;윽',5,'2022-04-06 14:27:28');
INSERT INTO `review` (`review_id`,`review_wid`,`product_id`,`seller_id`,`content`,`star_point`,`createdAt`) VALUES (35,1,29,4,'리뷰 별점 테스트으으으이ㅇ;ㅇ;ㅇ;윽',5,'2022-04-06 14:27:28');
INSERT INTO `review` (`review_id`,`review_wid`,`product_id`,`seller_id`,`content`,`star_point`,`createdAt`) VALUES (36,1,29,4,'리뷰 별점 테스트으으으이ㅇ;ㅇ;ㅇ;윽',5,'2022-04-06 14:27:28');
INSERT INTO `review` (`review_id`,`review_wid`,`product_id`,`seller_id`,`content`,`star_point`,`createdAt`) VALUES (37,1,29,4,'리뷰 별점 테스트으으으이ㅇ;ㅇ;ㅇ;윽',5,'2022-04-06 14:27:28');
INSERT INTO `review` (`review_id`,`review_wid`,`product_id`,`seller_id`,`content`,`star_point`,`createdAt`) VALUES (38,1,29,4,'리뷰 별점 테스트으으으이ㅇ;ㅇ;ㅇ;윽',5,'2022-04-06 14:27:29');
INSERT INTO `review` (`review_id`,`review_wid`,`product_id`,`seller_id`,`content`,`star_point`,`createdAt`) VALUES (39,1,29,4,'리뷰 별점 테스트으으으이ㅇ;ㅇ;ㅇ;윽',5,'2022-04-06 14:27:29');
INSERT INTO `review` (`review_id`,`review_wid`,`product_id`,`seller_id`,`content`,`star_point`,`createdAt`) VALUES (40,1,29,4,'리뷰 별점 테스트으으으이ㅇ;ㅇ;ㅇ;윽',5,'2022-04-06 14:27:29');
INSERT INTO `review` (`review_id`,`review_wid`,`product_id`,`seller_id`,`content`,`star_point`,`createdAt`) VALUES (41,1,29,4,'리뷰 별점 테스트으으으이ㅇ;ㅇ;ㅇ;윽',5,'2022-04-06 14:27:29');
INSERT INTO `review` (`review_id`,`review_wid`,`product_id`,`seller_id`,`content`,`star_point`,`createdAt`) VALUES (42,1,29,4,'리뷰 별점 테스트으으으이ㅇ;ㅇ;ㅇ;윽',5,'2022-04-06 14:27:30');
INSERT INTO `review` (`review_id`,`review_wid`,`product_id`,`seller_id`,`content`,`star_point`,`createdAt`) VALUES (43,1,29,4,'리뷰 별점 테스트으으으이ㅇ;ㅇ;ㅇ;윽',5,'2022-04-06 14:27:30');
INSERT INTO `review` (`review_id`,`review_wid`,`product_id`,`seller_id`,`content`,`star_point`,`createdAt`) VALUES (44,1,29,4,'리뷰 별점 테스트으으으이ㅇ;ㅇ;ㅇ;윽',5,'2022-04-06 14:27:30');
INSERT INTO `review` (`review_id`,`review_wid`,`product_id`,`seller_id`,`content`,`star_point`,`createdAt`) VALUES (45,1,29,4,'리뷰 별점 테스트으으으이ㅇ;ㅇ;ㅇ;윽',5,'2022-04-06 14:27:30');
INSERT INTO `review` (`review_id`,`review_wid`,`product_id`,`seller_id`,`content`,`star_point`,`createdAt`) VALUES (46,1,29,4,'리뷰 별점 테스트으으으이ㅇ;ㅇ;ㅇ;윽',5,'2022-04-06 14:27:31');
INSERT INTO `review` (`review_id`,`review_wid`,`product_id`,`seller_id`,`content`,`star_point`,`createdAt`) VALUES (47,1,29,4,'리뷰 별점 테스트으으으이ㅇ;ㅇ;ㅇ;윽',5,'2022-04-06 14:27:32');
INSERT INTO `review` (`review_id`,`review_wid`,`product_id`,`seller_id`,`content`,`star_point`,`createdAt`) VALUES (48,1,29,4,'리뷰 별점 테스트으으으이ㅇ;ㅇ;ㅇ;윽',5,'2022-04-06 14:27:32');
INSERT INTO `review` (`review_id`,`review_wid`,`product_id`,`seller_id`,`content`,`star_point`,`createdAt`) VALUES (49,1,29,4,'리뷰 별점 테스트으으으이ㅇ;ㅇ;ㅇ;윽',5,'2022-04-06 14:27:32');
INSERT INTO `review` (`review_id`,`review_wid`,`product_id`,`seller_id`,`content`,`star_point`,`createdAt`) VALUES (50,1,29,4,'리뷰 별점 테스트으으으이ㅇ;ㅇ;ㅇ;윽',5,'2022-04-06 14:27:33');
INSERT INTO `review` (`review_id`,`review_wid`,`product_id`,`seller_id`,`content`,`star_point`,`createdAt`) VALUES (51,1,29,4,'리뷰 별점 테스트으으으이ㅇ;ㅇ;ㅇ;윽',5,'2022-04-06 14:27:33');
INSERT INTO `review` (`review_id`,`review_wid`,`product_id`,`seller_id`,`content`,`star_point`,`createdAt`) VALUES (52,1,29,4,'리뷰 별점 테스트으으으이ㅇ;ㅇ;ㅇ;윽',5,'2022-04-06 14:27:33');
INSERT INTO `review` (`review_id`,`review_wid`,`product_id`,`seller_id`,`content`,`star_point`,`createdAt`) VALUES (53,1,29,4,'리뷰 별점 테스트으으으이ㅇ;ㅇ;ㅇ;윽',5,'2022-04-06 14:27:34');
INSERT INTO `review` (`review_id`,`review_wid`,`product_id`,`seller_id`,`content`,`star_point`,`createdAt`) VALUES (54,1,29,4,'리뷰 별점 테스트으으으이ㅇ;ㅇ;ㅇ;윽',5,'2022-04-06 14:27:34');
INSERT INTO `review` (`review_id`,`review_wid`,`product_id`,`seller_id`,`content`,`star_point`,`createdAt`) VALUES (55,1,29,4,'리뷰 별점 테스트으으으이ㅇ;ㅇ;ㅇ;윽',5,'2022-04-06 14:27:35');
INSERT INTO `review` (`review_id`,`review_wid`,`product_id`,`seller_id`,`content`,`star_point`,`createdAt`) VALUES (56,1,29,4,'리뷰 별점 테스트으으으이ㅇ;ㅇ;ㅇ;윽',5,'2022-04-06 14:27:35');
INSERT INTO `review` (`review_id`,`review_wid`,`product_id`,`seller_id`,`content`,`star_point`,`createdAt`) VALUES (57,1,29,4,'리뷰 별점 테스트으으으이ㅇ;ㅇ;ㅇ;윽',5,'2022-04-06 14:27:36');
INSERT INTO `review` (`review_id`,`review_wid`,`product_id`,`seller_id`,`content`,`star_point`,`createdAt`) VALUES (58,1,29,4,'리뷰 별점 테스트으으으이ㅇ;ㅇ;ㅇ;윽',5,'2022-04-06 14:27:36');
INSERT INTO `review` (`review_id`,`review_wid`,`product_id`,`seller_id`,`content`,`star_point`,`createdAt`) VALUES (59,1,29,4,'리뷰 별점 테스트으으으이ㅇ;ㅇ;ㅇ;윽',5,'2022-04-06 14:27:37');
INSERT INTO `review` (`review_id`,`review_wid`,`product_id`,`seller_id`,`content`,`star_point`,`createdAt`) VALUES (60,1,29,4,'리뷰 별점 테스트으으으이ㅇ;ㅇ;ㅇ;윽',5,'2022-04-06 14:27:37');
INSERT INTO `review` (`review_id`,`review_wid`,`product_id`,`seller_id`,`content`,`star_point`,`createdAt`) VALUES (61,1,29,4,'리뷰 별점 테스트으으으이ㅇ;ㅇ;ㅇ;윽',5,'2022-04-06 14:27:37');
INSERT INTO `review` (`review_id`,`review_wid`,`product_id`,`seller_id`,`content`,`star_point`,`createdAt`) VALUES (62,1,29,4,'리뷰 별점 테스트으으으이ㅇ;ㅇ;ㅇ;윽',5,'2022-04-06 14:27:38');
INSERT INTO `review` (`review_id`,`review_wid`,`product_id`,`seller_id`,`content`,`star_point`,`createdAt`) VALUES (63,1,29,4,'리뷰 별점 테스트으으으이ㅇ;ㅇ;ㅇ;윽',5,'2022-04-06 14:27:38');
INSERT INTO `review` (`review_id`,`review_wid`,`product_id`,`seller_id`,`content`,`star_point`,`createdAt`) VALUES (64,1,29,4,'리뷰 별점 테스트으으으이ㅇ;ㅇ;ㅇ;윽',5,'2022-04-06 14:27:39');
INSERT INTO `review` (`review_id`,`review_wid`,`product_id`,`seller_id`,`content`,`star_point`,`createdAt`) VALUES (65,1,29,4,'리뷰 별점 테스트으으으이ㅇ;ㅇ;ㅇ;윽',5,'2022-04-06 14:27:39');
INSERT INTO `review` (`review_id`,`review_wid`,`product_id`,`seller_id`,`content`,`star_point`,`createdAt`) VALUES (66,1,29,4,'리뷰 별점 테스트으으으이ㅇ;ㅇ;ㅇ;윽',5,'2022-04-06 14:27:39');
INSERT INTO `review` (`review_id`,`review_wid`,`product_id`,`seller_id`,`content`,`star_point`,`createdAt`) VALUES (67,1,29,4,'리뷰 별점 테스트으으으이ㅇ;ㅇ;ㅇ;윽',5,'2022-04-06 14:27:40');
INSERT INTO `review` (`review_id`,`review_wid`,`product_id`,`seller_id`,`content`,`star_point`,`createdAt`) VALUES (68,1,29,4,'리뷰 별점 테스트으으으이ㅇ;ㅇ;ㅇ;윽',5,'2022-04-06 14:27:40');
INSERT INTO `review` (`review_id`,`review_wid`,`product_id`,`seller_id`,`content`,`star_point`,`createdAt`) VALUES (69,1,29,4,'리뷰 별점 테스트으으으이ㅇ;ㅇ;ㅇ;윽',5,'2022-04-06 14:27:41');
INSERT INTO `review` (`review_id`,`review_wid`,`product_id`,`seller_id`,`content`,`star_point`,`createdAt`) VALUES (70,1,29,4,'리뷰 별점 테스트으으으이ㅇ;ㅇ;ㅇ;윽',5,'2022-04-06 14:27:41');
INSERT INTO `review` (`review_id`,`review_wid`,`product_id`,`seller_id`,`content`,`star_point`,`createdAt`) VALUES (71,1,29,4,'리뷰 별점 테스트으으으이ㅇ;ㅇ;ㅇ;윽',5,'2022-04-06 14:27:41');
INSERT INTO `review` (`review_id`,`review_wid`,`product_id`,`seller_id`,`content`,`star_point`,`createdAt`) VALUES (72,1,29,4,'리뷰 별점 테스트으으으이ㅇ;ㅇ;ㅇ;윽',5,'2022-04-06 14:27:42');
INSERT INTO `review` (`review_id`,`review_wid`,`product_id`,`seller_id`,`content`,`star_point`,`createdAt`) VALUES (73,1,29,4,'리뷰 별점 테스트으으으이ㅇ;ㅇ;ㅇ;윽',5,'2022-04-06 14:27:42');
INSERT INTO `review` (`review_id`,`review_wid`,`product_id`,`seller_id`,`content`,`star_point`,`createdAt`) VALUES (74,1,29,4,'리뷰 별점 테스트으으으이ㅇ;ㅇ;ㅇ;윽',5,'2022-04-06 14:27:43');
INSERT INTO `review` (`review_id`,`review_wid`,`product_id`,`seller_id`,`content`,`star_point`,`createdAt`) VALUES (75,1,29,4,'리뷰 별점 테스트으으으이ㅇ;ㅇ;ㅇ;윽',5,'2022-04-06 14:27:43');
INSERT INTO `review` (`review_id`,`review_wid`,`product_id`,`seller_id`,`content`,`star_point`,`createdAt`) VALUES (76,1,29,4,'리뷰 별점 테스트으으으이ㅇ;ㅇ;ㅇ;윽',5,'2022-04-06 14:27:43');
INSERT INTO `review` (`review_id`,`review_wid`,`product_id`,`seller_id`,`content`,`star_point`,`createdAt`) VALUES (77,1,29,4,'리뷰 별점 테스트으으으이ㅇ;ㅇ;ㅇ;윽',5,'2022-04-06 14:27:44');
INSERT INTO `review` (`review_id`,`review_wid`,`product_id`,`seller_id`,`content`,`star_point`,`createdAt`) VALUES (79,1,29,4,'리뷰 별점 테스트으으으이ㅇ;ㅇ;ㅇ;윽',5,'2022-04-07 14:55:10');
INSERT INTO `review` (`review_id`,`review_wid`,`product_id`,`seller_id`,`content`,`star_point`,`createdAt`) VALUES (80,1,29,4,'리뷰 별점 테스트으으으이ㅇ;ㅇ;ㅇ;윽',5,'2022-04-07 14:55:10');


