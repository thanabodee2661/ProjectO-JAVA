-- phpMyAdmin SQL Dump
-- version 4.8.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Mar 18, 2019 at 02:02 PM
-- Server version: 10.1.31-MariaDB
-- PHP Version: 7.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `project_fiction`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `id_admin` int(100) NOT NULL,
  `username` varchar(200) NOT NULL,
  `password` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`id_admin`, `username`, `password`) VALUES
(1, 'admin', '1234');

-- --------------------------------------------------------

--
-- Table structure for table `adminwebboard`
--

CREATE TABLE `adminwebboard` (
  `id_admin_webboard` int(11) NOT NULL,
  `headder_webboard` varchar(100) NOT NULL,
  `day_create` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `id_admin` int(11) NOT NULL,
  `collect_webboard` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `adminwebboard`
--

INSERT INTO `adminwebboard` (`id_admin_webboard`, `headder_webboard`, `day_create`, `id_admin`, `collect_webboard`) VALUES
(1, 'กติกา การใช้เว็บนี้', '2019-03-02 13:22:46', 1, '1.พูดคุยกันด้วยภาษาสุภาพ'),
(2, 'test1', '2019-03-02 17:08:15', 1, 'ssdfsfsf'),
(3, 'test2 ', '2019-03-02 17:08:41', 1, 'test2'),
(4, 'เทส3', '2019-03-02 17:09:00', 1, 'test333'),
(5, 'หกฟก', '2019-03-02 17:13:04', 1, 'ddddd'),
(6, 'เทสภาษาไทย', '2019-03-02 17:28:45', 1, 'หหหหหหหหหหห'),
(7, 'testlong', '2019-03-02 20:53:55', 1, 'cs'),
(8, 'test6', '2019-03-04 00:15:54', 1, 'ggggllll');

-- --------------------------------------------------------

--
-- Table structure for table `book`
--

CREATE TABLE `book` (
  `id_book` int(100) NOT NULL,
  `name_fiction` varchar(100) NOT NULL,
  `create_day` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `preview` varchar(200) NOT NULL,
  `id_user` int(100) NOT NULL,
  `status` int(3) NOT NULL,
  `img_book` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `comment`
--

CREATE TABLE `comment` (
  `id_comment` int(100) NOT NULL,
  `collect_comment` varchar(200) NOT NULL,
  `comment_day` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `comment`
--

INSERT INTO `comment` (`id_comment`, `collect_comment`, `comment_day`) VALUES
(1, 'ชอบมากครับ', '2019-02-16 19:35:42'),
(2, 'wewerfsfsdfsfs', '2019-02-16 20:12:57'),
(3, 'eiei', '2019-02-17 15:52:13'),
(4, 'test5555', '2019-02-25 17:01:13'),
(5, 'funnykk', '2019-03-06 22:53:46');

-- --------------------------------------------------------

--
-- Table structure for table `episode`
--

CREATE TABLE `episode` (
  `id_episode` int(100) NOT NULL,
  `name_episode` varchar(100) NOT NULL,
  `view` int(100) NOT NULL,
  `Content` varchar(1000) NOT NULL,
  `id_book` int(100) NOT NULL,
  `day_create_episode` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `favor`
--

CREATE TABLE `favor` (
  `id_typebook` int(100) NOT NULL,
  `id_book` int(100) NOT NULL,
  `id_user` int(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `likely`
--

CREATE TABLE `likely` (
  `id_likely` int(11) NOT NULL,
  `id_user` int(100) NOT NULL,
  `id_book` int(100) NOT NULL,
  `day_like` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `type`
--

CREATE TABLE `type` (
  `id_type` int(200) NOT NULL,
  `name_type` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `type`
--

INSERT INTO `type` (`id_type`, `name_type`) VALUES
(1, 'ghost');

-- --------------------------------------------------------

--
-- Table structure for table `type_book`
--

CREATE TABLE `type_book` (
  `id_type_book` int(100) NOT NULL,
  `id_book` int(100) NOT NULL,
  `id_type` int(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `type_webboard`
--

CREATE TABLE `type_webboard` (
  `id_typewebboard` int(11) NOT NULL,
  `name_webboard` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `type_webboard`
--

INSERT INTO `type_webboard` (`id_typewebboard`, `name_webboard`) VALUES
(1, 'ห้องแชร์เทคนิค'),
(2, 'ห้องนิยายการ์ตูน'),
(3, 'เรื่องรัก');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `id_user` int(100) NOT NULL,
  `name` varchar(100) NOT NULL,
  `lastname` varchar(100) NOT NULL,
  `application_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `birthday` date NOT NULL,
  `penname` varchar(100) NOT NULL,
  `avatar` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  `status` int(2) NOT NULL,
  `ban_day` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id_user`, `name`, `lastname`, `application_date`, `birthday`, `penname`, `avatar`, `email`, `password`, `status`, `ban_day`) VALUES
(1, 'God', 'dragon', '2019-02-16 19:27:08', '1993-10-15', 'GOD_DRAGON', 'login-image.jpg', 'user', '123', 0, NULL),
(2, 'ksa', 'asdad', '2019-02-16 20:12:35', '2019-02-01', 'asdasd', 'login-image.jpg', 'user2', '1234', 0, NULL),
(3, 'dfgd', 'asdad', '2019-02-16 22:30:09', '2019-02-05', 'dwww', 'asdad', 'sadw', '1234', 0, NULL),
(4, 'fdsdf', 'asdad', '2019-02-16 22:30:09', '2019-02-02', 'dasdasda', 'asdadad', 'dasdsad', '1234', 0, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `user_comment`
--

CREATE TABLE `user_comment` (
  `id_user_comment` int(100) NOT NULL,
  `id_user` int(100) NOT NULL,
  `id_comment` int(100) NOT NULL,
  `id_book` int(100) NOT NULL,
  `status` int(11) NOT NULL DEFAULT '0',
  `id_episode` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `user_webboard`
--

CREATE TABLE `user_webboard` (
  `id_user_webboard` int(11) NOT NULL,
  `id_user` int(11) NOT NULL,
  `id_webboard` int(11) NOT NULL,
  `status` int(11) NOT NULL DEFAULT '0',
  `collect_user_webboard` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `user_webboard`
--

INSERT INTO `user_webboard` (`id_user_webboard`, `id_user`, `id_webboard`, `status`, `collect_user_webboard`) VALUES
(1, 1, 1, 0, 'hhh'),
(2, 1, 4, 0, 'aaaa'),
(7, 2, 2, 0, 'kkkk'),
(8, 3, 3, 0, 'gggg'),
(9, 4, 1, 0, 'ก็ตั้งใจเขียนดิ'),
(10, 1, 9, 0, 'lll'),
(11, 1, 9, 1, 'lll'),
(12, 1, 6, 0, 'บ่นไรพ่อหนุ่ม'),
(13, 1, 9, 0, 'เทสtest'),
(14, 2, 9, 0, 'jkเทสอีกครั้ง23'),
(15, 2, 9, 0, 'testการส่ง2'),
(16, 2, 9, 0, 'jjj'),
(17, 2, 9, 2, 'cd');

-- --------------------------------------------------------

--
-- Table structure for table `webboard`
--

CREATE TABLE `webboard` (
  `id_webboard` int(11) NOT NULL,
  `collect_webboard` text NOT NULL,
  `headder_webboard` varchar(100) NOT NULL,
  `id_typewebboard` int(11) NOT NULL,
  `day_create` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `id_user` int(11) NOT NULL,
  `status` int(11) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `webboard`
--

INSERT INTO `webboard` (`id_webboard`, `collect_webboard`, `headder_webboard`, `id_typewebboard`, `day_create`, `id_user`, `status`) VALUES
(1, 'เขียนยังไงให้ดี', 'อยากจะรู้', 1, '2019-02-27 23:20:46', 1, 0),
(2, 'อยากเขียนเก่งๆ', 'สอนหน่อย', 1, '2019-02-27 23:21:16', 2, 0),
(3, 'มีคนแปลนิยาย เรื่องนี้แล้วหรือยัง', 'อยากทราบว่า', 2, '2019-02-27 23:21:49', 3, 0),
(4, 'ชอบนิยาย', 'ปลื้มสุดๆ', 3, '2019-02-27 23:22:31', 4, 0),
(6, 'หกกกกก', 'กหดหกดหดหดห', 3, '2019-03-02 17:58:21', 1, 0),
(8, 'หหหห', 'ลองเทส5', 1, '2019-03-02 18:03:37', 2, 0),
(9, 'แก้ไข111', 'เทสการใช้งาน2', 1, '2019-03-02 18:03:53', 2, 0),
(10, 'vbvb', 'ลองalert', 3, '2019-03-02 20:52:57', 2, 1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`id_admin`);

--
-- Indexes for table `adminwebboard`
--
ALTER TABLE `adminwebboard`
  ADD PRIMARY KEY (`id_admin_webboard`),
  ADD KEY `adminwebboard_ibfk_1` (`id_admin`);

--
-- Indexes for table `book`
--
ALTER TABLE `book`
  ADD PRIMARY KEY (`id_book`),
  ADD KEY `id_user` (`id_user`);

--
-- Indexes for table `comment`
--
ALTER TABLE `comment`
  ADD PRIMARY KEY (`id_comment`);

--
-- Indexes for table `episode`
--
ALTER TABLE `episode`
  ADD PRIMARY KEY (`id_episode`),
  ADD KEY `id_book` (`id_book`);

--
-- Indexes for table `favor`
--
ALTER TABLE `favor`
  ADD PRIMARY KEY (`id_typebook`),
  ADD KEY `id_user` (`id_user`),
  ADD KEY `id_book` (`id_book`);

--
-- Indexes for table `likely`
--
ALTER TABLE `likely`
  ADD PRIMARY KEY (`id_likely`),
  ADD KEY `likely_ibfk_1` (`id_book`),
  ADD KEY `id_user` (`id_user`);

--
-- Indexes for table `type`
--
ALTER TABLE `type`
  ADD PRIMARY KEY (`id_type`);

--
-- Indexes for table `type_book`
--
ALTER TABLE `type_book`
  ADD PRIMARY KEY (`id_type_book`),
  ADD KEY `id_book` (`id_book`),
  ADD KEY `id_type` (`id_type`);

--
-- Indexes for table `type_webboard`
--
ALTER TABLE `type_webboard`
  ADD PRIMARY KEY (`id_typewebboard`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id_user`);

--
-- Indexes for table `user_comment`
--
ALTER TABLE `user_comment`
  ADD PRIMARY KEY (`id_user_comment`),
  ADD KEY `user_comment_ibfk_5` (`id_comment`),
  ADD KEY `id_book` (`id_book`),
  ADD KEY `id_user` (`id_user`),
  ADD KEY `id_episode` (`id_episode`);

--
-- Indexes for table `user_webboard`
--
ALTER TABLE `user_webboard`
  ADD PRIMARY KEY (`id_user_webboard`),
  ADD KEY `user_webboard_ibfk_2` (`id_webboard`),
  ADD KEY `user_webboard_ibfk_3` (`id_user`);

--
-- Indexes for table `webboard`
--
ALTER TABLE `webboard`
  ADD PRIMARY KEY (`id_webboard`),
  ADD KEY `webboard_ibfk_1` (`id_typewebboard`),
  ADD KEY `id_user` (`id_user`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `adminwebboard`
--
ALTER TABLE `adminwebboard`
  MODIFY `id_admin_webboard` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `book`
--
ALTER TABLE `book`
  MODIFY `id_book` int(100) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `comment`
--
ALTER TABLE `comment`
  MODIFY `id_comment` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `episode`
--
ALTER TABLE `episode`
  MODIFY `id_episode` int(100) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `favor`
--
ALTER TABLE `favor`
  MODIFY `id_typebook` int(100) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `likely`
--
ALTER TABLE `likely`
  MODIFY `id_likely` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `type`
--
ALTER TABLE `type`
  MODIFY `id_type` int(200) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `type_book`
--
ALTER TABLE `type_book`
  MODIFY `id_type_book` int(100) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `type_webboard`
--
ALTER TABLE `type_webboard`
  MODIFY `id_typewebboard` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `id_user` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `user_comment`
--
ALTER TABLE `user_comment`
  MODIFY `id_user_comment` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `user_webboard`
--
ALTER TABLE `user_webboard`
  MODIFY `id_user_webboard` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;

--
-- AUTO_INCREMENT for table `webboard`
--
ALTER TABLE `webboard`
  MODIFY `id_webboard` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `adminwebboard`
--
ALTER TABLE `adminwebboard`
  ADD CONSTRAINT `adminwebboard_ibfk_1` FOREIGN KEY (`id_admin`) REFERENCES `admin` (`Id_admin`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `book`
--
ALTER TABLE `book`
  ADD CONSTRAINT `book_ibfk_1` FOREIGN KEY (`id_user`) REFERENCES `user` (`id_user`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `episode`
--
ALTER TABLE `episode`
  ADD CONSTRAINT `episode_ibfk_1` FOREIGN KEY (`id_book`) REFERENCES `book` (`id_book`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `favor`
--
ALTER TABLE `favor`
  ADD CONSTRAINT `favor_ibfk_1` FOREIGN KEY (`id_user`) REFERENCES `user` (`id_user`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `favor_ibfk_2` FOREIGN KEY (`id_book`) REFERENCES `book` (`id_book`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `likely`
--
ALTER TABLE `likely`
  ADD CONSTRAINT `likely_ibfk_1` FOREIGN KEY (`id_book`) REFERENCES `type_book` (`id_book`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `likely_ibfk_2` FOREIGN KEY (`id_user`) REFERENCES `user` (`id_user`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `type_book`
--
ALTER TABLE `type_book`
  ADD CONSTRAINT `type_book_ibfk_1` FOREIGN KEY (`id_book`) REFERENCES `book` (`id_book`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `type_book_ibfk_2` FOREIGN KEY (`id_type`) REFERENCES `type` (`id_type`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `user_comment`
--
ALTER TABLE `user_comment`
  ADD CONSTRAINT `user_comment_ibfk_5` FOREIGN KEY (`id_comment`) REFERENCES `comment` (`id_comment`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `user_comment_ibfk_6` FOREIGN KEY (`id_book`) REFERENCES `book` (`id_book`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `user_comment_ibfk_7` FOREIGN KEY (`id_user`) REFERENCES `user` (`id_user`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `user_comment_ibfk_8` FOREIGN KEY (`id_episode`) REFERENCES `episode` (`id_episode`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `user_webboard`
--
ALTER TABLE `user_webboard`
  ADD CONSTRAINT `user_webboard_ibfk_2` FOREIGN KEY (`id_webboard`) REFERENCES `webboard` (`id_webboard`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `user_webboard_ibfk_3` FOREIGN KEY (`id_user`) REFERENCES `user` (`id_user`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `webboard`
--
ALTER TABLE `webboard`
  ADD CONSTRAINT `webboard_ibfk_1` FOREIGN KEY (`id_typewebboard`) REFERENCES `type_webboard` (`id_typewebboard`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `webboard_ibfk_2` FOREIGN KEY (`id_user`) REFERENCES `user` (`id_user`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
