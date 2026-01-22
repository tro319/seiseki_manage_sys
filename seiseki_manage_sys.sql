-- MySQL dump 10.13  Distrib 8.0.40, for Win64 (x86_64)
--
-- Host: localhost    Database: seiseki_manage_sys
-- ------------------------------------------------------
-- Server version	8.0.40

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
-- Table structure for table `class_subjects`
--

DROP TABLE IF EXISTS `class_subjects`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `class_subjects` (
  `id` int NOT NULL AUTO_INCREMENT,
  `class_id` int NOT NULL,
  `subject_id` int NOT NULL,
  `manager_id` int NOT NULL,
  `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `manager_id` (`manager_id`),
  KEY `class_id` (`class_id`),
  KEY `subject_id` (`subject_id`),
  CONSTRAINT `class_subjects_ibfk_1` FOREIGN KEY (`manager_id`) REFERENCES `managers` (`id`),
  CONSTRAINT `class_subjects_ibfk_2` FOREIGN KEY (`class_id`) REFERENCES `classes` (`id`),
  CONSTRAINT `class_subjects_ibfk_3` FOREIGN KEY (`subject_id`) REFERENCES `subjects` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=63 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `class_subjects`
--

LOCK TABLES `class_subjects` WRITE;
/*!40000 ALTER TABLE `class_subjects` DISABLE KEYS */;
INSERT INTO `class_subjects` VALUES (1,4,2,1,'2026-01-16 21:53:07','2026-01-16 21:53:07'),(2,4,3,1,'2026-01-16 21:53:07','2026-01-16 21:53:07'),(3,4,6,1,'2026-01-16 21:53:07','2026-01-16 21:53:07'),(4,4,8,1,'2026-01-16 21:53:07','2026-01-16 21:53:07'),(18,9,6,1,'2026-01-16 22:01:06','2026-01-16 22:01:06'),(19,9,10,1,'2026-01-16 22:01:06','2026-01-16 22:01:06'),(20,9,9,1,'2026-01-16 22:01:06','2026-01-16 22:01:06'),(21,10,12,1,'2026-01-16 22:02:01','2026-01-16 22:02:01'),(22,10,14,1,'2026-01-16 22:02:01','2026-01-16 22:02:01'),(23,10,16,1,'2026-01-16 22:02:01','2026-01-16 22:02:01'),(27,12,18,1,'2026-01-22 00:29:08','2026-01-22 00:29:08'),(28,12,19,1,'2026-01-22 00:29:08','2026-01-22 00:29:08'),(29,12,20,1,'2026-01-22 00:29:08','2026-01-22 00:29:08'),(30,12,21,1,'2026-01-22 00:29:08','2026-01-22 00:29:08'),(31,12,22,1,'2026-01-22 00:29:08','2026-01-22 00:29:08'),(32,13,24,1,'2026-01-22 00:34:22','2026-01-22 00:34:22'),(33,13,23,1,'2026-01-22 00:34:22','2026-01-22 00:34:22'),(34,13,20,1,'2026-01-22 00:34:22','2026-01-22 00:34:22'),(35,13,21,1,'2026-01-22 00:34:22','2026-01-22 00:34:22'),(36,13,22,1,'2026-01-22 00:34:22','2026-01-22 00:34:22'),(41,7,7,1,'2026-01-22 19:15:55','2026-01-22 19:15:55'),(42,7,14,1,'2026-01-22 19:15:55','2026-01-22 19:15:55'),(43,7,8,1,'2026-01-22 19:15:55','2026-01-22 19:15:55'),(44,11,17,1,'2026-01-22 19:16:12','2026-01-22 19:16:12'),(45,11,11,1,'2026-01-22 19:16:12','2026-01-22 19:16:12'),(46,11,23,1,'2026-01-22 19:16:12','2026-01-22 19:16:12'),(52,14,10,1,'2026-01-22 20:38:28','2026-01-22 20:38:28'),(53,14,12,1,'2026-01-22 20:38:28','2026-01-22 20:38:28'),(54,14,11,1,'2026-01-22 20:38:28','2026-01-22 20:38:28'),(55,14,6,1,'2026-01-22 20:38:28','2026-01-22 20:38:28'),(56,14,9,1,'2026-01-22 20:38:28','2026-01-22 20:38:28'),(57,14,17,1,'2026-01-22 20:38:28','2026-01-22 20:38:28'),(58,6,4,1,'2026-01-22 20:55:25','2026-01-22 20:55:25'),(59,6,7,1,'2026-01-22 20:55:25','2026-01-22 20:55:25'),(60,6,8,1,'2026-01-22 20:55:25','2026-01-22 20:55:25'),(61,6,14,1,'2026-01-22 20:55:25','2026-01-22 20:55:25'),(62,6,13,1,'2026-01-22 20:55:25','2026-01-22 20:55:25');
/*!40000 ALTER TABLE `class_subjects` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `classes`
--

DROP TABLE IF EXISTS `classes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `classes` (
  `id` int NOT NULL AUTO_INCREMENT,
  `start_year` int NOT NULL,
  `major_id` int NOT NULL,
  `manager_id` int NOT NULL,
  `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `manager_id` (`manager_id`),
  KEY `major_id` (`major_id`),
  CONSTRAINT `classes_ibfk_1` FOREIGN KEY (`manager_id`) REFERENCES `managers` (`id`),
  CONSTRAINT `classes_ibfk_2` FOREIGN KEY (`major_id`) REFERENCES `majors` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `classes`
--

LOCK TABLES `classes` WRITE;
/*!40000 ALTER TABLE `classes` DISABLE KEYS */;
INSERT INTO `classes` VALUES (4,2025,1,1,'2026-01-16 21:53:07','2026-01-16 21:53:37'),(6,2023,1,1,'2026-01-16 21:55:18','2026-01-16 21:55:18'),(7,2024,1,1,'2026-01-16 21:58:01','2026-01-16 21:58:01'),(9,2025,6,1,'2026-01-16 22:01:06','2026-01-16 22:01:06'),(10,2024,6,1,'2026-01-16 22:02:01','2026-01-16 22:02:01'),(11,2023,6,1,'2026-01-16 22:03:46','2026-01-16 22:03:46'),(12,2026,1,1,'2026-01-22 00:29:08','2026-01-22 00:29:08'),(13,2026,6,1,'2026-01-22 00:34:22','2026-01-22 00:34:22'),(14,2029,6,1,'2026-01-22 20:37:48','2026-01-22 20:37:48');
/*!40000 ALTER TABLE `classes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `majors`
--

DROP TABLE IF EXISTS `majors`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `majors` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(30) NOT NULL,
  `kana` varchar(50) NOT NULL,
  `manager_id` int NOT NULL,
  `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`),
  KEY `manager_id` (`manager_id`),
  CONSTRAINT `majors_ibfk_1` FOREIGN KEY (`manager_id`) REFERENCES `managers` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `majors`
--

LOCK TABLES `majors` WRITE;
/*!40000 ALTER TABLE `majors` DISABLE KEYS */;
INSERT INTO `majors` VALUES (1,'ITプログラマー専攻','ITプログラマーせんこう',1,'2025-12-19 15:27:59','2025-12-19 15:27:59'),(6,'UI  / UX','UI  / UX',1,'2026-01-16 21:58:53','2026-01-16 21:58:53');
/*!40000 ALTER TABLE `majors` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `managers`
--

DROP TABLE IF EXISTS `managers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `managers` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(30) NOT NULL,
  `kana` varchar(50) NOT NULL,
  `email` varchar(255) NOT NULL,
  `pass` varchar(70) NOT NULL,
  `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`),
  UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `managers`
--

LOCK TABLES `managers` WRITE;
/*!40000 ALTER TABLE `managers` DISABLE KEYS */;
INSERT INTO `managers` VALUES (1,'ティーチャー1','ティーチャー1','ktc23a32f0005@edu.kyoto-tech.ac.jp','$2a$10$FUYmgQvmtPqFwTuumIT62u40c4XfaBRHwz.xafvlwQ9tcv3wF2iKu','2025-12-12 15:23:44','2025-12-12 15:23:44');
/*!40000 ALTER TABLE `managers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `periods`
--

DROP TABLE IF EXISTS `periods`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `periods` (
  `id` int NOT NULL AUTO_INCREMENT,
  `year` int NOT NULL,
  `name` varchar(10) NOT NULL,
  `manager_id` int NOT NULL,
  `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `manager_id` (`manager_id`),
  CONSTRAINT `periods_ibfk_1` FOREIGN KEY (`manager_id`) REFERENCES `managers` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `periods`
--

LOCK TABLES `periods` WRITE;
/*!40000 ALTER TABLE `periods` DISABLE KEYS */;
/*!40000 ALTER TABLE `periods` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `scores`
--

DROP TABLE IF EXISTS `scores`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `scores` (
  `id` int NOT NULL AUTO_INCREMENT,
  `class_id` int NOT NULL,
  `subject_id` int NOT NULL,
  `period_id` int NOT NULL,
  `teacher_id` int NOT NULL,
  `student_id` int NOT NULL,
  `score` int NOT NULL,
  `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `class_id` (`class_id`),
  KEY `subject_id` (`subject_id`),
  KEY `period_id` (`period_id`),
  KEY `teacher_id` (`teacher_id`),
  KEY `student_id` (`student_id`),
  CONSTRAINT `scores_ibfk_1` FOREIGN KEY (`class_id`) REFERENCES `classes` (`id`),
  CONSTRAINT `scores_ibfk_2` FOREIGN KEY (`subject_id`) REFERENCES `subjects` (`id`),
  CONSTRAINT `scores_ibfk_3` FOREIGN KEY (`period_id`) REFERENCES `periods` (`id`),
  CONSTRAINT `scores_ibfk_4` FOREIGN KEY (`teacher_id`) REFERENCES `teachers` (`id`),
  CONSTRAINT `scores_ibfk_5` FOREIGN KEY (`student_id`) REFERENCES `students` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `scores`
--

LOCK TABLES `scores` WRITE;
/*!40000 ALTER TABLE `scores` DISABLE KEYS */;
/*!40000 ALTER TABLE `scores` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `students`
--

DROP TABLE IF EXISTS `students`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `students` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(30) NOT NULL,
  `kana` varchar(50) NOT NULL,
  `gender` varchar(10) NOT NULL,
  `email` varchar(255) NOT NULL,
  `pass` varchar(70) NOT NULL,
  `class_id` int NOT NULL,
  `manager_id` int NOT NULL,
  `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`),
  UNIQUE KEY `email` (`email`),
  KEY `manager_id` (`manager_id`),
  KEY `class_id` (`class_id`),
  CONSTRAINT `students_ibfk_1` FOREIGN KEY (`manager_id`) REFERENCES `managers` (`id`),
  CONSTRAINT `students_ibfk_2` FOREIGN KEY (`class_id`) REFERENCES `classes` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `students`
--

LOCK TABLES `students` WRITE;
/*!40000 ALTER TABLE `students` DISABLE KEYS */;
/*!40000 ALTER TABLE `students` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `subjects`
--

DROP TABLE IF EXISTS `subjects`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `subjects` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(30) NOT NULL,
  `kana` varchar(50) NOT NULL,
  `manager_id` int NOT NULL,
  `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`),
  KEY `manager_id` (`manager_id`),
  CONSTRAINT `subjects_ibfk_1` FOREIGN KEY (`manager_id`) REFERENCES `managers` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `subjects`
--

LOCK TABLES `subjects` WRITE;
/*!40000 ALTER TABLE `subjects` DISABLE KEYS */;
INSERT INTO `subjects` VALUES (2,'Java','Java',1,'2025-12-21 17:36:23','2026-01-16 21:47:34'),(3,'PHP','PHP',1,'2026-01-16 21:47:53','2026-01-16 21:47:53'),(4,'PHP Laravel','PHP Laravel',1,'2026-01-16 21:48:09','2026-01-16 21:48:09'),(5,'Java Spring','Java Spring',1,'2026-01-16 21:48:28','2026-01-16 21:48:28'),(6,'Webフロントフレームワーク','Webふろんとふれーむわーく',1,'2026-01-16 21:48:49','2026-01-22 00:29:43'),(7,'Python','Python',1,'2026-01-16 21:49:02','2026-01-16 21:49:02'),(8,'C','C',1,'2026-01-16 21:49:09','2026-01-16 21:49:09'),(9,'デッサン','でっさん',1,'2026-01-16 21:49:32','2026-01-16 21:49:40'),(10,'Adobe Photoshop / Illustrator',' Adobe Photoshop / Illustrator',1,'2026-01-16 21:50:16','2026-01-16 21:50:16'),(11,'Adobe AfterEffects','Adobe AfterEffects',1,'2026-01-16 21:50:51','2026-01-16 21:50:51'),(12,'映像撮影 / 動画編集','えいぞうさつえい / どうがへんしゅう  ',1,'2026-01-16 21:51:48','2026-01-16 21:52:10'),(13,'Python Django','Python Django',1,'2026-01-16 21:54:48','2026-01-16 21:54:48'),(14,'Unity','Unity',1,'2026-01-16 21:56:32','2026-01-16 21:56:32'),(16,'UI / UX 基礎','UI / UX きそ',1,'2026-01-16 22:00:22','2026-01-16 22:00:22'),(17,'ADデザイン','ADでざいん',1,'2026-01-16 22:03:22','2026-01-16 22:03:22'),(18,'セキュリティ','セキュリティ',1,'2026-01-22 00:27:04','2026-01-22 00:27:04'),(19,'基本情報対策','きほんじょうほうたいさく',1,'2026-01-22 00:27:50','2026-01-22 00:27:50'),(20,'HTML','HTML',1,'2026-01-22 00:28:21','2026-01-22 00:28:21'),(21,'CSS','CSS',1,'2026-01-22 00:28:29','2026-01-22 00:28:29'),(22,'JavaScript','JavaScript',1,'2026-01-22 00:28:41','2026-01-22 00:28:41'),(23,'Canva','Canva',1,'2026-01-22 00:33:28','2026-01-22 00:33:28'),(24,'Figma','Figma',1,'2026-01-22 00:33:40','2026-01-22 00:33:40'),(25,'Adobe PremierePro','Adobe PremierePro ',1,'2026-01-22 20:39:20','2026-01-22 20:39:32'),(26,'データサイエンス基礎','でーたさいえんすきそ',1,'2026-01-22 20:39:47','2026-01-22 20:39:47');
/*!40000 ALTER TABLE `subjects` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `teacher_subjects`
--

DROP TABLE IF EXISTS `teacher_subjects`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `teacher_subjects` (
  `id` int NOT NULL AUTO_INCREMENT,
  `class_id` int NOT NULL,
  `subject_id` int NOT NULL,
  `manager_id` int NOT NULL,
  `period_id` int NOT NULL,
  `teacher_id` int NOT NULL,
  `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `manager_id` (`manager_id`),
  KEY `class_id` (`class_id`),
  KEY `subject_id` (`subject_id`),
  KEY `period_id` (`period_id`),
  KEY `teacher_id` (`teacher_id`),
  CONSTRAINT `teacher_subjects_ibfk_1` FOREIGN KEY (`manager_id`) REFERENCES `managers` (`id`),
  CONSTRAINT `teacher_subjects_ibfk_2` FOREIGN KEY (`class_id`) REFERENCES `classes` (`id`),
  CONSTRAINT `teacher_subjects_ibfk_3` FOREIGN KEY (`subject_id`) REFERENCES `subjects` (`id`),
  CONSTRAINT `teacher_subjects_ibfk_4` FOREIGN KEY (`period_id`) REFERENCES `periods` (`id`),
  CONSTRAINT `teacher_subjects_ibfk_5` FOREIGN KEY (`teacher_id`) REFERENCES `teachers` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teacher_subjects`
--

LOCK TABLES `teacher_subjects` WRITE;
/*!40000 ALTER TABLE `teacher_subjects` DISABLE KEYS */;
/*!40000 ALTER TABLE `teacher_subjects` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `teachers`
--

DROP TABLE IF EXISTS `teachers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `teachers` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(30) NOT NULL,
  `kana` varchar(50) NOT NULL,
  `email` varchar(255) NOT NULL,
  `pass` varchar(70) NOT NULL,
  `manager_id` int NOT NULL,
  `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `gender` varchar(10) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`),
  UNIQUE KEY `email` (`email`),
  KEY `manager_id` (`manager_id`),
  CONSTRAINT `teachers_ibfk_1` FOREIGN KEY (`manager_id`) REFERENCES `managers` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teachers`
--

LOCK TABLES `teachers` WRITE;
/*!40000 ALTER TABLE `teachers` DISABLE KEYS */;
/*!40000 ALTER TABLE `teachers` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2026-01-23  1:16:21
