-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Aug 07, 2017 at 11:59 PM
-- Server version: 10.1.13-MariaDB
-- PHP Version: 5.6.20

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `userdetail`
--

-- --------------------------------------------------------

--
-- Table structure for table `chatapp`
--

CREATE TABLE `chatapp` (
  `id` int(15) NOT NULL,
  `Sender` varchar(50) NOT NULL,
  `Receiver` varchar(50) NOT NULL,
  `Message` varchar(300) NOT NULL,
  `Time` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `userinfo`
--

CREATE TABLE `userinfo` (
  `Name` varchar(50) NOT NULL,
  `Dob` date NOT NULL,
  `Gender` varchar(50) NOT NULL,
  `Username` varchar(50) NOT NULL,
  `Password` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `userinfo`
--

INSERT INTO `userinfo` (`Name`, `Dob`, `Gender`, `Username`, `Password`) VALUES
('abhishek', '2000-01-01', 'Male', 'abhi', 'abhishek'),
('ryan', '2011-11-11', 'Male', 'asd', 'asd'),
('ravita', '1990-02-07', 'Female', 'ravita', '12345');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `chatapp`
--
ALTER TABLE `chatapp`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `userinfo`
--
ALTER TABLE `userinfo`
  ADD PRIMARY KEY (`Username`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `chatapp`
--
ALTER TABLE `chatapp`
  MODIFY `id` int(15) NOT NULL AUTO_INCREMENT;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
