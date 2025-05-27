CREATE DATABASE  IF NOT EXISTS `dates` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `dates`;
-- MySQL dump 10.13  Distrib 8.0.36, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: dates
-- ------------------------------------------------------
-- Server version	8.0.36

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `date_2025_03_22`
--

DROP TABLE IF EXISTS `date_2025_03_22`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `date_2025_03_22` (
  `SNUM` int NOT NULL,
  `Fullname` varchar(50) DEFAULT NULL,
  `Section` varchar(50) DEFAULT NULL,
  `Age` int DEFAULT NULL,
  `DateAndTime` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `date_2025_03_22`
--

LOCK TABLES `date_2025_03_22` WRITE;
/*!40000 ALTER TABLE `date_2025_03_22` DISABLE KEYS */;
INSERT INTO `date_2025_03_22` VALUES (202410897,'Prince Benitez','BSIT 1D',20,'2025-04-15 20:58:28'),(202411223,'Jediel Marturillas','BSIT 1E',19,'2025-04-15 20:58:36'),(202410897,'Prince Benitez','BSIT 1D',20,'2025-05-25 21:11:39'),(202410897,'Jediel Benitez','BSIT 1E',19,'2025-05-26 14:53:02'),(123,'Jeds','1D',20,'2025-05-26 22:33:35'),(202410897,'Jediel Benitez','BSIT 1E',19,'2025-05-26 22:43:40'),(202410897,'Jediel Benitez','BSIT 1E',19,'2025-05-26 22:45:58'),(202410897,'Jediel Benitez','BSIT 1E',19,'2025-05-26 22:47:58'),(202410897,'Jediel Benitez','BSIT 1E',19,'2025-05-26 22:49:38'),(202410897,'Jediel Benitez','BSIT 1E',19,'2025-05-26 22:53:03'),(202410897,'Jediel Benitez','BSIT 1E',19,'2025-05-26 22:54:21'),(202410897,'Jediel Benitez','BSIT 1E',19,'2025-05-26 22:56:29');
/*!40000 ALTER TABLE `date_2025_03_22` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `date_2025_04_16`
--

DROP TABLE IF EXISTS `date_2025_04_16`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `date_2025_04_16` (
  `SNUM` int NOT NULL,
  `Fullname` varchar(50) DEFAULT NULL,
  `Section` varchar(50) DEFAULT NULL,
  `Age` int DEFAULT NULL,
  `DateAndTime` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `date_2025_04_16`
--

LOCK TABLES `date_2025_04_16` WRITE;
/*!40000 ALTER TABLE `date_2025_04_16` DISABLE KEYS */;
INSERT INTO `date_2025_04_16` VALUES (202410897,'Prince Benitez','BSIT 1D',20,'2025-04-16 20:20:15'),(123,'Jeds','1D',20,'2025-04-16 20:40:40'),(1234,'Miles','Faculty',60,'2025-04-16 20:44:23');
/*!40000 ALTER TABLE `date_2025_04_16` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `date_2025_04_22`
--

DROP TABLE IF EXISTS `date_2025_04_22`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `date_2025_04_22` (
  `SNUM` int NOT NULL,
  `Fullname` varchar(50) DEFAULT NULL,
  `Section` varchar(50) DEFAULT NULL,
  `Age` int DEFAULT NULL,
  `DateAndTime` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `date_2025_04_22`
--

LOCK TABLES `date_2025_04_22` WRITE;
/*!40000 ALTER TABLE `date_2025_04_22` DISABLE KEYS */;
INSERT INTO `date_2025_04_22` VALUES (202410897,'Prince Benitez','BSIT 1D',20,'2025-04-22 21:58:02'),(202411231,'Mikka Reyes','BSIT 1C',25,'2025-04-22 21:58:20'),(202411230,'Renz Borromeo','BSIT 1E',19,'2025-04-22 21:58:29'),(202411231,'Mikka Reyes','BSIT 1C',25,'2025-04-22 22:00:58'),(202411231,'Mikka Reyes','BSIT 1C',25,'2025-05-27 14:37:24');
/*!40000 ALTER TABLE `date_2025_04_22` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `date_2025_04_23`
--

DROP TABLE IF EXISTS `date_2025_04_23`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `date_2025_04_23` (
  `SNUM` int NOT NULL,
  `Fullname` varchar(50) DEFAULT NULL,
  `Section` varchar(50) DEFAULT NULL,
  `Age` int DEFAULT NULL,
  `DateAndTime` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `date_2025_04_23`
--

LOCK TABLES `date_2025_04_23` WRITE;
/*!40000 ALTER TABLE `date_2025_04_23` DISABLE KEYS */;
INSERT INTO `date_2025_04_23` VALUES (202410897,'Prince Benitez','BSIT 1D',20,'2025-04-23 16:14:02');
/*!40000 ALTER TABLE `date_2025_04_23` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `date_2025_05_18`
--

DROP TABLE IF EXISTS `date_2025_05_18`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `date_2025_05_18` (
  `SNUM` int NOT NULL,
  `Fullname` varchar(50) DEFAULT NULL,
  `Section` varchar(50) DEFAULT NULL,
  `Age` int DEFAULT NULL,
  `DateAndTime` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `date_2025_05_18`
--

LOCK TABLES `date_2025_05_18` WRITE;
/*!40000 ALTER TABLE `date_2025_05_18` DISABLE KEYS */;
INSERT INTO `date_2025_05_18` VALUES (202410897,'Prince Benitez','BSIT 1D',20,'2025-05-18 11:00:44');
/*!40000 ALTER TABLE `date_2025_05_18` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `date_2025_05_24`
--

DROP TABLE IF EXISTS `date_2025_05_24`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `date_2025_05_24` (
  `SNUM` int NOT NULL,
  `Fullname` varchar(50) DEFAULT NULL,
  `Section` varchar(50) DEFAULT NULL,
  `Age` int DEFAULT NULL,
  `DateAndTime` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `date_2025_05_24`
--

LOCK TABLES `date_2025_05_24` WRITE;
/*!40000 ALTER TABLE `date_2025_05_24` DISABLE KEYS */;
INSERT INTO `date_2025_05_24` VALUES (202410897,'Prince Benitez','BSIT 1D',20,'2025-05-24 13:16:35'),(202410897,'Prince Benitez','BSIT 1D',20,'2025-05-24 13:26:43');
/*!40000 ALTER TABLE `date_2025_05_24` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `date_2025_05_25`
--

DROP TABLE IF EXISTS `date_2025_05_25`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `date_2025_05_25` (
  `SNUM` int NOT NULL,
  `Fullname` varchar(50) DEFAULT NULL,
  `Section` varchar(50) DEFAULT NULL,
  `Age` int DEFAULT NULL,
  `DateAndTime` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `date_2025_05_25`
--

LOCK TABLES `date_2025_05_25` WRITE;
/*!40000 ALTER TABLE `date_2025_05_25` DISABLE KEYS */;
INSERT INTO `date_2025_05_25` VALUES (202410897,'Prince Benitez','BSIT 1D',20,'2025-05-25 21:11:58'),(202410897,'Jediel Benitez','BSIT 1E',19,'2025-05-25 22:29:26'),(202411223,'Jediel Marturillas','BSIT 1E',19,'2025-05-25 22:39:11'),(20242024,'Jjeffrey Pantaleon','BSIT 1D',19,'2025-05-25 22:40:53');
/*!40000 ALTER TABLE `date_2025_05_25` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `date_2025_05_26`
--

DROP TABLE IF EXISTS `date_2025_05_26`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `date_2025_05_26` (
  `SNUM` int NOT NULL,
  `Fullname` varchar(50) DEFAULT NULL,
  `Section` varchar(50) DEFAULT NULL,
  `Age` int DEFAULT NULL,
  `DateAndTime` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `date_2025_05_26`
--

LOCK TABLES `date_2025_05_26` WRITE;
/*!40000 ALTER TABLE `date_2025_05_26` DISABLE KEYS */;
/*!40000 ALTER TABLE `date_2025_05_26` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `date_2025_05_27`
--

DROP TABLE IF EXISTS `date_2025_05_27`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `date_2025_05_27` (
  `SNUM` int NOT NULL,
  `Fullname` varchar(50) DEFAULT NULL,
  `Section` varchar(50) DEFAULT NULL,
  `Age` int DEFAULT NULL,
  `DateAndTime` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `date_2025_05_27`
--

LOCK TABLES `date_2025_05_27` WRITE;
/*!40000 ALTER TABLE `date_2025_05_27` DISABLE KEYS */;
INSERT INTO `date_2025_05_27` VALUES (202410897,'Prince Benitez','BSIT 1D',20,'2025-05-27 15:53:21'),(202410897,'Prince Benitez','BSIT 1D',20,'2025-05-27 15:53:27');
/*!40000 ALTER TABLE `date_2025_05_27` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-05-27 16:24:46
