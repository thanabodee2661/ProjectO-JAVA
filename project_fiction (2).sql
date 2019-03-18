-- phpMyAdmin SQL Dump
-- version 4.8.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Mar 18, 2019 at 11:54 AM
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

--
-- Dumping data for table `book`
--

INSERT INTO `book` (`id_book`, `name_fiction`, `create_day`, `preview`, `id_user`, `status`, `img_book`) VALUES
(1, 'เจ้าพ่อ', '2019-02-16 19:31:33', 'เจ้าพ่อออกมา', 1, 0, ''),
(2, 'test', '2019-02-16 21:41:22', 'asdasdasdas', 2, 0, '');

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

--
-- Dumping data for table `episode`
--

INSERT INTO `episode` (`id_episode`, `name_episode`, `view`, `Content`, `id_book`, `day_create_episode`) VALUES
(1, 'บุกเจ้าพ่อ', 107, 'ซูลูกุย', 1, '2019-02-17 12:49:30'),
(2, 'ตอนที่1 hgjjvhfgh', 20, 'ghjjhjkujj', 2, '2019-02-17 12:49:30'),
(3, 'test 2', 50, 'asdsadadawdasdw', 1, '2019-02-25 18:37:55');

-- --------------------------------------------------------

--
-- Table structure for table `favor`
--

CREATE TABLE `favor` (
  `id_typebook` int(100) NOT NULL,
  `id_book` int(100) NOT NULL,
  `id_user` int(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `favor`
--

INSERT INTO `favor` (`id_typebook`, `id_book`, `id_user`) VALUES
(1, 1, 1);

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

--
-- Dumping data for table `likely`
--

INSERT INTO `likely` (`id_likely`, `id_user`, `id_book`, `day_like`) VALUES
(1, 1, 1, '2019-02-07 00:00:00'),
(2, 1, 2, '2019-02-07 00:00:00'),
(3, 2, 1, '2019-02-17 09:34:35'),
(4, 2, 2, '2018-01-02 12:02:02'),
(5, 3, 1, '2018-12-07 00:00:00'),
(6, 3, 2, '2019-01-02 00:00:00'),
(7, 4, 1, '2018-12-25 00:00:00'),
(8, 4, 2, '2018-11-07 00:00:00');

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

--
-- Dumping data for table `user_comment`
--

INSERT INTO `user_comment` (`id_user_comment`, `id_user`, `id_comment`, `id_book`, `status`, `id_episode`) VALUES
(1, 1, 1, 1, 0, 1),
(2, 2, 2, 1, 0, 1),
(3, 3, 3, 2, 0, 2),
(4, 1, 4, 1, 1, 3),
(5, 1, 5, 1, 0, 1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`id_admin`);

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
  ADD KEY `id_book` (`id_book`),
  ADD KEY `id_user` (`id_user`);

--
-- Indexes for table `type`
--
ALTER TABLE `type`
  ADD PRIMARY KEY (`id_type`);

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
  ADD KEY `id_user` (`id_user`),
  ADD KEY `id_book` (`id_book`),
  ADD KEY `id_episode` (`id_episode`),
  ADD KEY `id_comment` (`id_comment`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `comment`
--
ALTER TABLE `comment`
  MODIFY `id_comment` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `likely`
--
ALTER TABLE `likely`
  MODIFY `id_likely` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `user_comment`
--
ALTER TABLE `user_comment`
  MODIFY `id_user_comment` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `book`
--
ALTER TABLE `book`
  ADD CONSTRAINT `book_ibfk_1` FOREIGN KEY (`id_user`) REFERENCES `user` (`id_user`);

--
-- Constraints for table `episode`
--
ALTER TABLE `episode`
  ADD CONSTRAINT `episode_ibfk_1` FOREIGN KEY (`id_book`) REFERENCES `book` (`id_book`);

--
-- Constraints for table `favor`
--
ALTER TABLE `favor`
  ADD CONSTRAINT `favor_ibfk_1` FOREIGN KEY (`id_user`) REFERENCES `user` (`id_user`),
  ADD CONSTRAINT `favor_ibfk_2` FOREIGN KEY (`id_book`) REFERENCES `book` (`id_book`);

--
-- Constraints for table `likely`
--
ALTER TABLE `likely`
  ADD CONSTRAINT `likely_ibfk_1` FOREIGN KEY (`id_book`) REFERENCES `type_book` (`id_book`),
  ADD CONSTRAINT `likely_ibfk_2` FOREIGN KEY (`id_user`) REFERENCES `user` (`id_user`);

--
-- Constraints for table `user_comment`
--
ALTER TABLE `user_comment`
  ADD CONSTRAINT `user_comment_ibfk_1` FOREIGN KEY (`id_user`) REFERENCES `user` (`id_user`),
  ADD CONSTRAINT `user_comment_ibfk_3` FOREIGN KEY (`id_book`) REFERENCES `book` (`id_book`),
  ADD CONSTRAINT `user_comment_ibfk_4` FOREIGN KEY (`id_episode`) REFERENCES `episode` (`id_episode`),
  ADD CONSTRAINT `user_comment_ibfk_5` FOREIGN KEY (`id_comment`) REFERENCES `comment` (`id_comment`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
