-- phpMyAdmin SQL Dump
-- version 4.2.11
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Mar 26, 2016 at 11:36 AM
-- Server version: 5.6.21
-- PHP Version: 5.6.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `onlinequiz`
--

-- --------------------------------------------------------

--
-- Table structure for table `question`
--

CREATE TABLE IF NOT EXISTS `question` (
`questionID` int(10) NOT NULL,
  `quizID` int(5) NOT NULL,
  `question` text NOT NULL,
  `correctAns` char(1) NOT NULL,
  `optionA` varchar(50) NOT NULL,
  `optionB` varchar(50) NOT NULL,
  `optionC` varchar(50) NOT NULL,
  `optionD` varchar(50) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `question`
--

INSERT INTO `question` (`questionID`, `quizID`, `question`, `correctAns`, `optionA`, `optionB`, `optionC`, `optionD`) VALUES
(1, 1, 'asdasd', 'A', 'cvbc', 'dfs', 'efsef', 'sfsf'),
(2, 1, 'adasd', 'C', 'asg', 'dgd', 'bcv', 'gf'),
(3, 2, 'asdacbcb', 'C', 'fgdrg', 'gdfg', 'dfgdg', 'cbvcb'),
(4, 2, 'xcfvbcb', 'A', 'xfdxfdv', 'cgvbc', 'dfsf', 'fcxbvcb'),
(5, 1, 'qwerty', 'D', 'cdsfsdfv', 'xfgddfb', 'xcbvdrgbn', 'xvxbdb'),
(6, 1, 'zsdzsdegvdb', 'C', 'sadfsgv', 'vhnmhy', 'dfhth', 'cbnfyn'),
(7, 1, 'asdfg', 'D', 'cdsfsdfv', 'xfgddfb', 'xcbvdrgbn', 'xvxbdb'),
(8, 1, 'zxccxvbgc', 'A', 'sadfsgv', 'vhnmhy', 'dfhth', 'cbnfyn'),
(9, 1, 'zxcvb', 'B', 'cdsfsdfv', 'xfgddfb', 'xcbvdrgbn', 'xvxbdb'),
(10, 1, 'mnbvcx', 'C', 'sadfsgv', 'vhnmhy', 'dfhth', 'cbnfyn'),
(11, 1, 'mjghgbcfb', 'B', 'cdsfsdfv', 'xfgddfb', 'xcbvdrgbn', 'xvxbdb'),
(12, 1, 'qwdassdgdt', 'C', 'sadfsgv', 'vhnmhy', 'dfhth', 'cbnfyn'),
(13, 1, 'vcbcfgd', 'A', 'cdsfsdfv', 'xfgddfb', 'xcbvdrgbn', 'xvxbdb'),
(14, 1, 'regedgdg', 'D', 'sadfsgv', 'vhnmhy', 'dfhth', 'cbnfyn'),
(15, 1, 'qwexczczf', 'A', 'cdsfsdfv', 'xfgddfb', 'xcbvdrgbn', 'xvxbdb'),
(16, 1, 'qwdassdgdt', 'C', 'sadfsgv', 'vhnmhy', 'dfhth', 'cbnfyn'),
(17, 1, 'cvxvf', 'B', 'cdsfsdfv', 'xfgddfb', 'xcbvdrgbn', 'xvxbdb'),
(18, 1, 'cvfvdv', 'C', 'sadfsgv', 'vhnmhy', 'dfhth', 'cbnfyn'),
(19, 1, 'vvnny', 'D', 'cdsfsdfv', 'xfgddfb', 'xcbvdrgbn', 'xvxbdb'),
(20, 1, 'cvbncvg', 'A', 'sadfsgv', 'vhnmhy', 'dfhth', 'cbnfyn'),
(21, 1, 'vbnfnfnhyfn', 'B', 'cdsfsdfv', 'xfgddfb', 'xcbvdrgbn', 'xvxbdb'),
(22, 1, 'nvnhvngyhn', 'C', 'sadfsgv', 'vhnmhy', 'dfhth', 'cbnfyn'),
(23, 1, 'vbnvgnfn', 'A', 'cdsfsdfv', 'xfgddfb', 'xcbvdrgbn', 'xvxbdb'),
(24, 1, 'sefsse', 'D', 'sadfsgv', 'vhnmhy', 'dfhth', 'cbnfyn'),
(25, 1, 'vbnvhnfthf', 'A', 'cdsfsdfv', 'xfgddfb', 'xcbvdrgbn', 'xvxbdb'),
(26, 1, 'ghjghfh', 'C', 'sadfsgv', 'vhnmhy', 'dfhth', 'cbnfyn'),
(27, 1, 'dgsderaf', 'B', 'cdsfsdfv', 'xfgddfb', 'xcbvdrgbn', 'xvxbdb'),
(28, 1, 'mgnmgngfyn', 'C', 'sadfsgv', 'vhnmhy', 'dfhth', 'cbnfyn'),
(29, 1, 'awsdawsdsfdve', 'D', 'cdsfsdfv', 'xfgddfb', 'xcbvdrgbn', 'xvxbdb'),
(30, 1, 'xcvdsefasf', 'A', 'sadfsgv', 'vhnmhy', 'dfhth', 'cbnfyn'),
(31, 2, 'vbnfnfnhyfn', 'B', 'cdsfsdfv', 'xfgddfb', 'xcbvdrgbn', 'xvxbdb'),
(32, 2, 'nvnhvngyhn', 'C', 'sadfsgv', 'vhnmhy', 'dfhth', 'cbnfyn'),
(33, 1, 'asdsfgdgb', 'A', 'nfhgfn', 'hjkg', 'tdrfgg', 'ghjgyj'),
(34, 1, 'zsfawfsef', 'C', 'bnmghm', 'bmg', 'fcgfg', 'bmbm'),
(36, 2, 'afbcxbcbcbvcbcb', 'c', 'cb', 'vb ', 'ew', 'wefr'),
(37, 3, 'Which built-in method returns the index within the calling String object of the first occurrence of the specified value?', 'C', 'getindex()', 'location()', 'indexof()', 'None ofhe above t'),
(38, 3, 'Which built-in method returns the index within the calling String object of the first occurrence of the specified value?', 'C', 'getindex()', 'location()', 'indexof()', 'None ofhe above t'),
(39, 3, 'Which built-in method returns the string representation of the number''s value?', 'C', 'toValue()', 'toNumber()', 'toString()', 'None of the above'),
(40, 3, 'Which built-in method reverses the order of the elements of an array?', 'B', 'changeOrder(Order)', 'reverse()', 'sort()', 'None of the above');

-- --------------------------------------------------------

--
-- Table structure for table `quiz`
--

CREATE TABLE IF NOT EXISTS `quiz` (
`quizID` int(5) NOT NULL,
  `quizName` varchar(15) NOT NULL,
  `noOfQue` int(5) NOT NULL,
  `isTimed` tinyint(2) NOT NULL,
  `quizTime` int(5) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `quiz`
--

INSERT INTO `quiz` (`quizID`, `quizName`, `noOfQue`, `isTimed`, `quizTime`) VALUES
(1, 'Java', 30, 1, 30),
(2, 'SQL', 20, 1, 30),
(3, 'JQuery', 20, 1, 25);

-- --------------------------------------------------------

--
-- Table structure for table `quizattempt`
--

CREATE TABLE IF NOT EXISTS `quizattempt` (
  `quizID` int(5) NOT NULL,
  `questionID` int(5) NOT NULL,
  `userID` int(5) NOT NULL,
  `correctAns` tinyint(4) NOT NULL,
  `userAns` tinyint(4) NOT NULL,
  `result` tinyint(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `recoveryquestion`
--

CREATE TABLE IF NOT EXISTS `recoveryquestion` (
`recoveryQuestionID` int(5) NOT NULL,
  `question` varchar(100) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `recoveryquestion`
--

INSERT INTO `recoveryquestion` (`recoveryQuestionID`, `question`) VALUES
(3, 'What is Your Favorite Colour?'),
(1, 'What is Your Favorite Game?'),
(2, 'What is Your First Mobile No?');

-- --------------------------------------------------------

--
-- Table structure for table `report`
--

CREATE TABLE IF NOT EXISTS `report` (
`reportID` int(5) NOT NULL,
  `userID` int(5) NOT NULL,
  `quizID` int(5) NOT NULL,
  `score` int(3) NOT NULL,
  `date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE IF NOT EXISTS `user` (
`userID` int(10) NOT NULL,
  `userName` varchar(20) NOT NULL,
  `firstName` varchar(20) NOT NULL,
  `lastName` varchar(20) NOT NULL,
  `emailID` varchar(30) NOT NULL,
  `password` varchar(20) NOT NULL,
  `recoveryQuestionID` int(5) NOT NULL,
  `recoveryAnswer` varchar(20) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`userID`, `userName`, `firstName`, `lastName`, `emailID`, `password`, `recoveryQuestionID`, `recoveryAnswer`) VALUES
(1, 'ozaparth', 'Parth', 'Oza', 'ozaparth@gail.com', '123456', 1, 'Cricket'),
(6, 'bhavinoza', 'Bhavin', 'Oza', 'ozabhavin@gmail.com', '1234', 3, 'Blue'),
(7, 'sagar', 'sagar', 'mistry', 'msagar879@gmail.com', 'Sagar879swenggIT', 1, 'cricket');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `question`
--
ALTER TABLE `question`
 ADD PRIMARY KEY (`questionID`), ADD KEY `quizID` (`quizID`);

--
-- Indexes for table `quiz`
--
ALTER TABLE `quiz`
 ADD PRIMARY KEY (`quizID`);

--
-- Indexes for table `quizattempt`
--
ALTER TABLE `quizattempt`
 ADD KEY `questionID` (`questionID`), ADD KEY `quizId` (`quizID`), ADD KEY `userID` (`userID`);

--
-- Indexes for table `recoveryquestion`
--
ALTER TABLE `recoveryquestion`
 ADD PRIMARY KEY (`recoveryQuestionID`), ADD UNIQUE KEY `question` (`question`);

--
-- Indexes for table `report`
--
ALTER TABLE `report`
 ADD PRIMARY KEY (`reportID`), ADD KEY `userID` (`userID`), ADD KEY `quizID` (`quizID`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
 ADD PRIMARY KEY (`userID`), ADD UNIQUE KEY `userName` (`userName`), ADD KEY `recoveryQuestionID` (`recoveryQuestionID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `question`
--
ALTER TABLE `question`
MODIFY `questionID` int(10) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=41;
--
-- AUTO_INCREMENT for table `quiz`
--
ALTER TABLE `quiz`
MODIFY `quizID` int(5) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `recoveryquestion`
--
ALTER TABLE `recoveryquestion`
MODIFY `recoveryQuestionID` int(5) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `report`
--
ALTER TABLE `report`
MODIFY `reportID` int(5) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
MODIFY `userID` int(10) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=8;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `question`
--
ALTER TABLE `question`
ADD CONSTRAINT `question_ibfk_1` FOREIGN KEY (`quizID`) REFERENCES `quiz` (`quizID`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `quizattempt`
--
ALTER TABLE `quizattempt`
ADD CONSTRAINT `quizattempt_ibfk_1` FOREIGN KEY (`quizID`) REFERENCES `quiz` (`quizID`),
ADD CONSTRAINT `quizattempt_ibfk_2` FOREIGN KEY (`questionID`) REFERENCES `question` (`questionID`),
ADD CONSTRAINT `quizattempt_ibfk_3` FOREIGN KEY (`userID`) REFERENCES `user` (`userID`);

--
-- Constraints for table `report`
--
ALTER TABLE `report`
ADD CONSTRAINT `report_ibfk_1` FOREIGN KEY (`userID`) REFERENCES `user` (`userID`),
ADD CONSTRAINT `report_ibfk_2` FOREIGN KEY (`quizID`) REFERENCES `quiz` (`quizID`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
