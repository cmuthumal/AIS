-- MySQL dump 10.13  Distrib 5.1.47, for Win32 (ia32)
--
-- Host: localhost    Database: ais
-- ------------------------------------------------------
-- Server version	5.1.47-community

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `customer` (
  `id` varchar(9) NOT NULL,
  `name` varchar(100) DEFAULT NULL,
  `address` varchar(300) DEFAULT NULL,
  `mobile` decimal(10,0) DEFAULT NULL,
  `phone` decimal(10,0) DEFAULT NULL,
  `regDate` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` VALUES ('CUS000001','Danapala','Panadura','717600072','912222222','2014-06-22'),('CUS000002','Gunapala','Matara','717600072','912222222','2014-06-22'),('CUS000003','Somapala','Galle','717600072','912222222','2014-06-22'),('CUS000004','Siripala','Galle','717600072','912222222','2014-06-22'),('CUS000005','Jinadasa','Panadura','717600072','912222222','2014-06-22');
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `employee` (
  `id` varchar(9) NOT NULL,
  `name` varchar(100) DEFAULT NULL,
  `address` varchar(300) DEFAULT NULL,
  `mobile` decimal(10,0) DEFAULT NULL,
  `phone` decimal(10,0) DEFAULT NULL,
  `nic` decimal(9,0) DEFAULT NULL,
  `regDate` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee`
--

LOCK TABLES `employee` WRITE;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` VALUES ('EMP000001','Hawk','Galle','778978456','915789456','922901120','2014-06-22'),('EMP000002','Flash','Matara','778978456','915789456','922901120','2014-06-22'),('EMP000003','Hulk','Panadura','778978456','915789456','922901120','2014-06-22'),('EMP000004','Hansel','Nawala','778978456','915789456','922901120','2014-06-22'),('EMP000005','Dent','Colombo','778978456','915789456','922901120','2014-06-22');
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `item`
--

DROP TABLE IF EXISTS `item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `item` (
  `code` varchar(9) NOT NULL,
  `batchNo` varchar(9) NOT NULL,
  `description` varchar(100) DEFAULT NULL,
  `buyingPrice` decimal(7,2) DEFAULT NULL,
  `sellingPrice` decimal(7,2) DEFAULT NULL,
  `discount` decimal(4,2) DEFAULT NULL,
  `qtyOnHand` decimal(4,0) DEFAULT NULL,
  `supplier` varchar(9) DEFAULT NULL,
  `regDate` date DEFAULT NULL,
  `expDate` date DEFAULT NULL,
  PRIMARY KEY (`code`,`batchNo`),
  KEY `supplier` (`supplier`),
  CONSTRAINT `item_ibfk_1` FOREIGN KEY (`supplier`) REFERENCES `supplier` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `item`
--

LOCK TABLES `item` WRITE;
/*!40000 ALTER TABLE `item` DISABLE KEYS */;
INSERT INTO `item` VALUES ('ITM000001','BCH000001','Karawila','20.00','22.00','5.00','50','SUP000001','2014-06-17','2014-06-24'),('ITM000002','BCH000002','Pathola','30.00','32.00','5.00','50','SUP000001','2014-06-22','2014-06-25'),('ITM000003','BCH000003','Carrot','70.00','72.00','5.00','50','SUP000002','2014-06-22','2014-06-11'),('ITM000004','BCH000004','Gowa','50.00','53.00','5.00','50','SUP000002','2014-06-22','2014-06-30'),('ITM000005','BCH000005','Potato','100.00','105.00','5.00','50','SUP000003','2014-06-22','2014-07-02');
/*!40000 ALTER TABLE `item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `loan`
--

DROP TABLE IF EXISTS `loan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `loan` (
  `id` varchar(9) NOT NULL,
  `employeeID` varchar(9) NOT NULL,
  `amount` decimal(10,0) DEFAULT NULL,
  `interest` decimal(4,2) DEFAULT NULL,
  `period` decimal(3,0) DEFAULT NULL,
  `date` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `employeeID` (`employeeID`),
  CONSTRAINT `loan_ibfk_1` FOREIGN KEY (`employeeID`) REFERENCES `employee` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `loan`
--

LOCK TABLES `loan` WRITE;
/*!40000 ALTER TABLE `loan` DISABLE KEYS */;
INSERT INTO `loan` VALUES ('LON000001','EMP000001','100000','10.00','12','2014-06-22'),('LON000002','EMP000001','100000','10.00','12','2014-06-22'),('LON000003','EMP000001','100000','10.00','12','2014-06-22'),('LON000004','EMP000002','100000','10.00','12','2014-06-22'),('LON000005','EMP000002','100000','10.00','12','2014-06-22');
/*!40000 ALTER TABLE `loan` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `log`
--

DROP TABLE IF EXISTS `log`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `log` (
  `id` varchar(9) NOT NULL,
  `date` date DEFAULT NULL,
  `time` varchar(8) DEFAULT NULL,
  `activity` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `log`
--

LOCK TABLES `log` WRITE;
/*!40000 ALTER TABLE `log` DISABLE KEYS */;
INSERT INTO `log` VALUES ('REC000001','2014-06-22','20:24:50','workshift EMP000001 updated'),('REC000002','2014-06-22','20:25:34','workshift EMP000001 updated'),('REC000003','2014-06-22','20:57:33','workshift EMP000001 updated'),('REC000004','2014-06-22','20:59:31','workshift WRK000001 updated'),('REC000005','2014-06-22','21:00:26','workshift WRK000001 updated'),('REC000006','2014-06-22','21:02:50','workshift WRK000001 updated'),('REC000007','2014-06-22','21:04:30','workshift WRK000001 updated'),('REC000008','2014-06-22','21:10:57','workshift WRK000001 updated'),('REC000009','2014-06-22','21:33:15','workshift WRK000005 updated'),('REC000010','2014-06-22','22:40:40','workshift WRK000001 updated'),('REC000011','2014-06-22','23:00:27','workshift WRK000003 updated'),('REC000012','2014-06-22','23:04:15','workshift WRK000005 updated'),('REC000013','2014-06-22','23:04:37','workshift WRK000005 updated'),('REC000014','2014-06-23','15:58:50','workshift WRK000002 updated'),('REC000015','2014-06-23','16:00:12','workshift WRK000004 updated'),('REC000016','2014-06-23','16:00:44','workshift WRK000004 updated'),('REC000017','2014-06-23','16:02:47','workshift WRK000005 updated'),('REC000018','2014-06-23','16:24:39','workshift WRK000004 updated'),('REC000019','2014-06-23','16:25:01','workshift WRK000005 updated'),('REC000020','2014-06-23','16:57:15','workshift WRK000004 updated'),('REC000021','2014-06-23','16:58:31','workshift WRK000002 updated'),('REC000022','2014-06-23','16:58:39','workshift WRK000001 updated'),('REC000023','2014-06-23','16:58:52','workshift WRK000001 updated'),('REC000024','2014-06-23','16:58:58','workshift WRK000001 updated'),('REC000025','2014-06-23','16:59:21','workshift WRK000001 updated'),('REC000026','2014-06-23','16:59:26','workshift WRK000002 updated'),('REC000027','2014-06-23','17:02:01','workshift WRK000002 updated'),('REC000028','2014-06-23','17:02:47','workshift WRK000005 updated'),('REC000029','2014-06-23','17:11:26','workshift WRK000006 added'),('REC000030','2014-06-23','17:14:27','workshift WRK000006 added'),('REC000031','2014-06-23','17:30:02','workshift WRK000006 deleted'),('REC000032','2014-06-23','17:30:12','workshift WRK000006 updated'),('REC000033','2014-06-23','17:31:11','workshift WRK000006 added'),('REC000034','2014-06-23','17:31:15','workshift WRK000006 deleted'),('REC000035','2014-06-23','17:39:47','root logged in'),('REC000036','2014-06-23','17:45:47','root logged in'),('REC000037','2014-06-23','18:40:22','model.User@18b017 logged out'),('REC000038','2014-06-23','18:40:35','model.User@508b97 logged out'),('REC000039','2014-06-23','18:45:26','root logged out'),('REC000040','2014-06-23','18:45:37','root logged out'),('REC000041','2014-06-23','18:45:38','root logged in'),('REC000042','2014-06-23','18:46:04','root logged out'),('REC000043','2014-06-23','18:46:27','root logged out'),('REC000044','2014-06-23','18:46:43','root logged out'),('REC000045','2014-06-23','18:59:09','root logged out'),('REC000046','2014-06-23','18:59:12','root logged in'),('REC000047','2014-06-23','18:59:38','root logged out'),('REC000048','2014-06-23','19:01:45','root logged out'),('REC000049','2014-06-23','19:08:13','root logged out'),('REC000050','2014-06-23','19:20:22','root logged out'),('REC000051','2014-06-23','21:47:33','workshift WRK000003 updated'),('REC000052','2014-06-23','22:48:31','workshift WRK000005 updated'),('REC000053','2014-06-23','22:48:43','workshift WRK000005 updated'),('REC000054','2014-06-23','23:00:13','workshift WRK000006 added'),('REC000055','2014-06-23','23:00:35','workshift WRK000002 updated'),('REC000056','2014-06-23','23:00:38','workshift WRK000003 updated'),('REC000057','2014-06-23','23:00:42','workshift WRK000004 updated'),('REC000058','2014-06-24','10:40:32','workshift WRK000006 updated'),('REC000059','2014-06-24','12:15:46','workshift WRK000006 updated'),('REC000060','2014-06-24','12:23:26','workshift WRK000004 updated'),('REC000061','2014-06-24','13:39:59','root logged out'),('REC000062','2014-06-24','13:40:56','root logged out'),('REC000063','2014-06-24','15:36:20','root logged out'),('REC000064','2014-06-24','15:39:00','root logged out'),('REC000065','2014-06-24','15:41:06','root logged out'),('REC000066','2014-06-24','15:42:33','root logged out'),('REC000067','2014-06-24','15:42:58','failed login attempt : root | massac'),('REC000068','2014-06-24','15:43:02','root logged in'),('REC000069','2014-06-24','15:43:54','root logged out'),('REC000070','2014-06-24','16:28:37','root logged out'),('REC000071','2014-06-24','16:29:35','root logged out'),('REC000072','2014-06-24','16:30:40','root logged out'),('REC000073','2014-06-24','16:31:38','root logged out'),('REC000074','2014-06-24','16:32:21','root logged out'),('REC000075','2014-06-24','16:32:47','root logged out'),('REC000076','2014-06-24','16:33:11','root logged out'),('REC000077','2014-06-24','16:33:38','root logged out'),('REC000078','2014-06-24','16:34:12','root logged out'),('REC000079','2014-06-24','16:35:10','item ITM000001 updated'),('REC000080','2014-06-24','16:35:23','item ITM000002 updated'),('REC000081','2014-06-24','16:35:39','item ITM000004 updated'),('REC000082','2014-06-24','16:35:47','item ITM000005 updated'),('REC000083','2014-06-24','16:36:03','root logged out'),('REC000084','2014-06-24','16:36:45','root logged out'),('REC000085','2014-06-24','16:37:16','root logged out'),('REC000086','2014-06-24','16:47:19','item ITM000005 updated'),('REC000087','2014-06-24','16:47:31','root logged out'),('REC000088','2014-06-24','16:53:02','root logged out'),('REC000089','2014-06-24','17:15:03','root logged out'),('REC000090','2014-06-24','17:16:59','root logged out'),('REC000091','2014-06-24','17:21:38','root logged out'),('REC000092','2014-06-24','17:22:06','root logged out'),('REC000093','2014-06-24','17:22:24','root logged out'),('REC000094','2014-06-24','17:23:01','root logged out'),('REC000095','2014-06-24','17:25:44','root logged out'),('REC000096','2014-06-24','17:27:33','root logged in'),('REC000097','2014-06-24','17:27:37','root logged out'),('REC000098','2014-06-24','17:28:41','failed login attempt : root | d'),('REC000099','2014-06-24','17:28:45','root logged in'),('REC000100','2014-06-24','17:28:55','root logged out'),('REC000101','2014-06-24','17:31:48','root logged in'),('REC000102','2014-06-24','17:33:00','root logged out'),('REC000103','2014-06-24','17:35:09','user logged in'),('REC000104','2014-06-24','17:35:19','user logged out'),('REC000105','2014-06-25','06:31:03','user logged in'),('REC000106','2014-06-25','06:31:43','user logged out'),('REC000107','2014-06-25','06:33:22','user logged in'),('REC000108','2014-06-25','06:33:55','user logged out'),('REC000109','2014-06-25','11:23:10','root logged in'),('REC000110','2014-06-25','11:23:42','item ITM000002 updated'),('REC000111','2014-06-25','11:24:07','root logged out'),('REC000112','2014-06-25','11:56:55','root logged in'),('REC000113','2014-06-25','11:57:30','root logged out'),('REC000114','2014-06-25','11:57:36','user logged in'),('REC000115','2014-06-25','11:57:54','user logged out'),('REC000116','2014-06-25','13:08:08','root logged in'),('REC000117','2014-06-25','13:08:37','root logged out'),('REC000118','2014-06-25','13:09:36','root logged in'),('REC000119','2014-06-25','13:11:11','root logged out'),('REC000120','2014-06-25','13:12:00','root logged in'),('REC000121','2014-06-25','13:12:09','root logged out');
/*!40000 ALTER TABLE `log` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `salary`
--

DROP TABLE IF EXISTS `salary`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `salary` (
  `id` varchar(9) NOT NULL,
  `employeeID` varchar(9) NOT NULL,
  `date` date DEFAULT NULL,
  `month` decimal(3,0) DEFAULT NULL,
  `basic` decimal(10,0) DEFAULT NULL,
  `ot` decimal(10,0) DEFAULT NULL,
  `allowance` decimal(10,0) DEFAULT NULL,
  `incentive` decimal(10,0) DEFAULT NULL,
  `epf` decimal(10,0) DEFAULT NULL,
  `etf` decimal(10,0) DEFAULT NULL,
  `loans` decimal(10,0) DEFAULT NULL,
  `otherDeductions` decimal(10,0) DEFAULT NULL,
  `total` decimal(10,0) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `employeeID` (`employeeID`),
  CONSTRAINT `salary_ibfk_1` FOREIGN KEY (`employeeID`) REFERENCES `employee` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `salary`
--

LOCK TABLES `salary` WRITE;
/*!40000 ALTER TABLE `salary` DISABLE KEYS */;
INSERT INTO `salary` VALUES ('SLR000001','EMP000001','2014-06-22','1','20000','2000','2000','2000','2000','2000','2000','2000','18000'),('SLR000002','EMP000002','2014-06-22','1','20000','2000','2000','2000','2000','2000','2000','2000','18000'),('SLR000003','EMP000003','2014-06-22','1','20000','2000','2000','2000','2000','2000','2000','2000','18000'),('SLR000004','EMP000004','2014-06-22','1','20000','2000','2000','2000','2000','2000','2000','2000','18000'),('SLR000005','EMP000005','2014-06-22','1','20000','2000','2000','2000','2000','2000','2000','2000','18000');
/*!40000 ALTER TABLE `salary` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `supplier`
--

DROP TABLE IF EXISTS `supplier`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `supplier` (
  `id` varchar(9) NOT NULL,
  `name` varchar(100) DEFAULT NULL,
  `address` varchar(300) DEFAULT NULL,
  `mobile` decimal(10,0) DEFAULT NULL,
  `phone` decimal(10,0) DEFAULT NULL,
  `regDate` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `supplier`
--

LOCK TABLES `supplier` WRITE;
/*!40000 ALTER TABLE `supplier` DISABLE KEYS */;
INSERT INTO `supplier` VALUES ('SUP000001','Teddy','Galle','778978456','915789456','2014-06-22'),('SUP000002','Tommy','Matara','778978456','915789456','2014-06-22'),('SUP000003','Tarzan','Panadura','778978456','915789456','2014-06-22'),('SUP000004','Usher','Matara','778978456','915789456','2014-06-22'),('SUP000005','Wayne','Colombo','778978456','915789456','2014-06-22');
/*!40000 ALTER TABLE `supplier` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id` varchar(9) NOT NULL,
  `userName` varchar(50) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  `userLevel` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES ('USR000001','root',(SELECT PASSWORD('asdf')),'admin');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `workshift`
--

DROP TABLE IF EXISTS `workshift`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `workshift` (
  `id` varchar(9) NOT NULL,
  `employeeID` varchar(9) NOT NULL,
  `date` date DEFAULT NULL,
  `start` int(4) DEFAULT NULL,
  `end` int(4) DEFAULT NULL,
  `present` varchar(2) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `employeeID` (`employeeID`),
  CONSTRAINT `workshift_ibfk_1` FOREIGN KEY (`employeeID`) REFERENCES `employee` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `workshift`
--

LOCK TABLES `workshift` WRITE;
/*!40000 ALTER TABLE `workshift` DISABLE KEYS */;
INSERT INTO `workshift` VALUES ('WRK000001','EMP000001','2014-06-25',900,1600,'pr'),('WRK000002','EMP000002','2014-06-25',1600,2030,'pr'),('WRK000003','EMP000003','2014-06-25',900,1600,'pr'),('WRK000004','EMP000004','2014-06-25',1200,2000,'pr'),('WRK000005','EMP000005','2014-06-25',900,1600,'ab'),('WRK000006','EMP000001','2014-06-25',1600,2200,'pr');
/*!40000 ALTER TABLE `workshift` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2014-06-25 13:18:18
