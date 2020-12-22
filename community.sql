-- MySQL dump 10.13  Distrib 8.0.20, for Win64 (x86_64)
--
-- Host: localhost    Database: community
-- ------------------------------------------------------
-- Server version	8.0.20

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `community`
--

DROP TABLE IF EXISTS `community`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `community` (
  `community_id` int NOT NULL AUTO_INCREMENT,
  `community_name` varchar(25) DEFAULT NULL,
  `name` varchar(5) DEFAULT NULL,
  `area` decimal(10,0) DEFAULT NULL,
  `create_date` varchar(30) DEFAULT NULL,
  `finish_date` varchar(30) DEFAULT NULL,
  `designer` varchar(5) DEFAULT NULL,
  `type` varchar(10) DEFAULT NULL,
  `community_address` varchar(70) DEFAULT NULL,
  `note` varchar(200) DEFAULT NULL,
  `community_type` int DEFAULT NULL,
  `design_advice` varchar(200) DEFAULT NULL,
  `take_key_time` varchar(30) DEFAULT NULL,
  `renovation_recommendation` varchar(200) DEFAULT NULL,
  `feature` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  PRIMARY KEY (`community_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `community`
--

LOCK TABLES `community` WRITE;
/*!40000 ALTER TABLE `community` DISABLE KEYS */;
INSERT INTO `community` VALUES (3,'小区12','张三',100,'2020-12-13 22:09:22','2020-11-02 00:00:00','设计师','户型1','上海市浦东新区',NULL,1,NULL,NULL,NULL,NULL),(4,'小区123','张三',100,'2020-12-14 20:29:50','2020-11-02 08:00:00','设计师','户型1','上海市浦东新区',NULL,1,NULL,NULL,NULL,NULL),(5,'小区1123','张三',100,'2020-12-14 20:39:48','2020-11-02 11:00:00','设计师','户型1','上海市浦东新区',NULL,1,NULL,NULL,NULL,NULL),(6,'小区1123','张三',100,'2020-12-16 09:38:26','2020-11-02 11:00:00','设计师','户型1','上海市浦东新区',NULL,1,NULL,NULL,NULL,NULL),(7,'小区1123','张三',100,'2020-12-16 09:38:28','2020-11-02 11:00:00','设计师','户型1','上海市浦东新区',NULL,1,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `community` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-12-17  9:57:38
