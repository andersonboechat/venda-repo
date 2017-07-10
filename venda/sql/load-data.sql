-- MySQL dump 10.13  Distrib 5.6.23, for Win64 (x86_64)
--
-- Host: localhost    Database: test
-- ------------------------------------------------------
-- Server version	5.6.19-log

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
-- Dumping data for table `tb_item_venda`
--

LOCK TABLES `tb_item_venda` WRITE;
/*!40000 ALTER TABLE `tb_item_venda` DISABLE KEYS */;
INSERT INTO `tb_item_venda` VALUES (1,'1','0987654329',1.99,0.00),(1,'2','2123456789',3.99,0.99),(2,'1','0987654329',1.99,0.00),(2,'2','2123456789',3.99,0.99),(3,'1','0987654329',1.99,0.00),(3,'2','2123456789',3.99,0.99),(4,'1','0987654329',1.99,0.00),(4,'2','2123456789',3.99,0.99),(5,'1','0987654329',1.99,0.00),(5,'2','2123456789',3.99,0.99),(6,'1','0987654329',1.99,0.00),(6,'2','2123456789',3.99,0.99),(7,'1','0987654329',1.99,0.00),(7,'2','2123456789',3.99,0.99),(8,'1','0987654329',1.99,0.00),(8,'2','2123456789',3.99,0.99),(9,'1','0987654329',1.99,0.00),(9,'2','2123456789',3.99,0.99),(10,'1','0987654329',1.99,0.00),(10,'2','2123456789',3.99,0.99),(11,'1','0987654329',1.99,0.00),(11,'2','2123456789',3.99,0.99),(12,'1','0987654329',1.99,0.00),(12,'2','2123456789',3.99,0.99),(13,'1','0987654329',1.99,0.00),(13,'2','2123456789',3.99,0.99),(14,'1','0987654329',1.99,0.00),(14,'2','2123456789',3.99,0.99),(15,'1','0987654329',1.99,0.00),(15,'2','2123456789',3.99,0.99),(16,'1','0987654329',1.99,0.00),(16,'2','2123456789',3.99,0.99),(17,'1','0987654329',1.99,0.00),(17,'2','2123456789',3.99,0.99),(18,'1','1234567890',2.99,1.00),(18,'2','2123456789',3.99,0.99),(19,'1','1234567890',2.99,1.00),(19,'2','2123456789',3.99,0.99),(20,'1','1234567890',2.99,1.00),(20,'2','2123456789',3.99,0.99),(21,'1','1234567890',2.99,1.00),(21,'2','2123456789',3.99,0.99),(22,'1','1234567890',2.99,1.00),(22,'2','2123456789',3.99,0.99),(23,'1','1234567890',2.99,1.00),(23,'2','2123456789',3.99,0.99),(24,'1','1234567890',2.99,1.00),(24,'2','2123456789',3.99,0.99);
/*!40000 ALTER TABLE `tb_item_venda` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `tb_processamento`
--

LOCK TABLES `tb_processamento` WRITE;
/*!40000 ALTER TABLE `tb_processamento` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_processamento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `tb_venda`
--

LOCK TABLES `tb_venda` WRITE;
/*!40000 ALTER TABLE `tb_venda` DISABLE KEYS */;
INSERT INTO `tb_venda` VALUES (1,'2017-06-26',1,1,'NÃO PROCESSADO'),(2,'2017-06-27',2,1,'NÃO PROCESSADO'),(3,'2017-06-28',3,1,'NÃO PROCESSADO'),(4,'2017-06-29',1,2,'NÃO PROCESSADO'),(5,'2017-06-30',2,2,'NÃO PROCESSADO'),(6,'2017-07-01',3,2,'NÃO PROCESSADO'),(7,'2017-07-02',1,3,'NÃO PROCESSADO'),(8,'2017-07-03',2,3,'NÃO PROCESSADO'),(9,'2017-07-04',3,3,'NÃO PROCESSADO'),(10,'2017-07-05',1,4,'NÃO PROCESSADO'),(11,'2017-07-06',2,4,'NÃO PROCESSADO'),(12,'2017-07-07',3,4,'NÃO PROCESSADO'),(13,'2017-07-08',1,5,'NÃO PROCESSADO'),(14,'2017-07-09',2,5,'NÃO PROCESSADO'),(15,'2017-07-10',3,5,'NÃO PROCESSADO'),(16,'2017-07-11',1,6,'NÃO PROCESSADO'),(17,'2017-07-12',2,6,'NÃO PROCESSADO'),(18,'2017-07-13',3,6,'NÃO PROCESSADO'),(19,'2017-07-14',1,7,'NÃO PROCESSADO'),(20,'2017-07-15',2,7,'NÃO PROCESSADO'),(21,'2017-07-16',3,7,'NÃO PROCESSADO'),(22,'2017-07-17',1,8,'NÃO PROCESSADO'),(23,'2017-07-17',2,8,'NÃO PROCESSADO'),(24,'2017-07-17',3,8,'NÃO PROCESSADO');
/*!40000 ALTER TABLE `tb_venda` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-07-09 12:21:36