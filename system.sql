-- MySQL dump 10.13  Distrib 5.7.23, for linux-glibc2.12 (x86_64)
--
-- Host: localhost    Database: auth
-- ------------------------------------------------------
-- Server version	5.7.23-log

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
-- Table structure for table `t_permission`
--

DROP TABLE IF EXISTS `t_permission`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_permission` (
  `perm_id` int(11) NOT NULL AUTO_INCREMENT,
  `deleted` bit(1) DEFAULT NULL,
  `name` varchar(25) DEFAULT NULL,
  `parent_id` bigint(20) DEFAULT NULL,
  `permission` varchar(50) DEFAULT NULL,
  `resource_type` varchar(50) DEFAULT NULL,
  `url` varchar(200) DEFAULT NULL,
  `updated_date` datetime DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  PRIMARY KEY (`perm_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_permission`
--

LOCK TABLES `t_permission` WRITE;
/*!40000 ALTER TABLE `t_permission` DISABLE KEYS */;
INSERT INTO `t_permission` VALUES (1,_binary '\0','admin:delete',NULL,'admin:delete','method','/test','2018-12-04 10:12:00','2018-12-04 10:12:00'),(2,_binary '\0','guest:delete',NULL,'guest:delete','method','/test','2018-12-04 10:26:16','2018-12-04 10:26:16');
/*!40000 ALTER TABLE `t_permission` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_role`
--

DROP TABLE IF EXISTS `t_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_role` (
  `role_id` int(11) NOT NULL AUTO_INCREMENT,
  `deleted` bit(1) DEFAULT NULL,
  `description` varchar(100) DEFAULT NULL,
  `rolename` varchar(100) DEFAULT NULL,
  `parent_id` int(11) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `updated_date` datetime DEFAULT NULL,
  PRIMARY KEY (`role_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_role`
--

LOCK TABLES `t_role` WRITE;
/*!40000 ALTER TABLE `t_role` DISABLE KEYS */;
INSERT INTO `t_role` VALUES (1,_binary '\0','admin','admin',NULL,'2018-12-04 10:05:36','2018-12-04 10:05:36'),(2,_binary '\0','guest','guest',NULL,'2018-12-04 10:25:52','2018-12-04 10:25:52');
/*!40000 ALTER TABLE `t_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_role_perm`
--

DROP TABLE IF EXISTS `t_role_perm`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_role_perm` (
  `role_perm_id` int(11) NOT NULL AUTO_INCREMENT,
  `role_id` int(11) NOT NULL,
  `perm_id` int(11) NOT NULL,
  PRIMARY KEY (`role_perm_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_role_perm`
--

LOCK TABLES `t_role_perm` WRITE;
/*!40000 ALTER TABLE `t_role_perm` DISABLE KEYS */;
INSERT INTO `t_role_perm` VALUES (1,1,1),(2,1,2),(3,2,1);
/*!40000 ALTER TABLE `t_role_perm` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_user`
--

DROP TABLE IF EXISTS `t_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(30) DEFAULT NULL,
  `salt` varchar(72) DEFAULT NULL,
  `username` varchar(50) DEFAULT NULL,
  `department` varchar(60) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `updated_date` datetime DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_user`
--

LOCK TABLES `t_user` WRITE;
/*!40000 ALTER TABLE `t_user` DISABLE KEYS */;
INSERT INTO `t_user` VALUES (1,'260152','dafldd','awu','bdc','2018-12-04 09:57:06','2018-12-04 09:57:06'),(2,'260195','dafldd','chenchen','bdc','2018-12-04 10:25:15','2018-12-04 10:25:15');
/*!40000 ALTER TABLE `t_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_user_operation`
--

DROP TABLE IF EXISTS `t_user_operation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_user_operation` (
  `user_operation_id` int(11) NOT NULL AUTO_INCREMENT,
  `department` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `operate_date` datetime DEFAULT NULL,
  `operate_ip` varchar(255) DEFAULT NULL,
  `operate_method` varchar(255) DEFAULT NULL,
  `operate_parms` varchar(512) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`user_operation_id`)
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_user_operation`
--

LOCK TABLES `t_user_operation` WRITE;
/*!40000 ALTER TABLE `t_user_operation` DISABLE KEYS */;
INSERT INTO `t_user_operation` VALUES (1,'未知部门','系统内部调用','2018-12-04 09:44:36','172.16.227.132','execution(void com.gree.auth.controller.timer.ClearDataTimer.clearData())','','系统内部调用'),(2,'未知部门','系统内部调用','2018-12-04 09:57:50','172.16.227.132','execution(void com.gree.auth.controller.timer.ClearDataTimer.clearData())','','系统内部调用'),(3,'未知部门','系统内部调用','2018-12-04 10:04:21','172.16.227.132','execution(void com.gree.auth.controller.timer.ClearDataTimer.clearData())','','系统内部调用'),(4,'未知部门','系统内部调用','2018-12-04 10:22:28','172.16.227.132','execution(void com.gree.auth.controller.timer.ClearDataTimer.clearData())','','系统内部调用'),(5,'未知部门','系统内部调用','2018-12-04 10:23:19','172.16.227.132','execution(void com.gree.auth.controller.timer.ClearDataTimer.clearData())','','系统内部调用'),(6,'未知部门','系统内部调用','2018-12-04 10:27:27','172.16.227.132','execution(void com.gree.auth.controller.timer.ClearDataTimer.clearData())','','系统内部调用'),(7,'未知部门','系统内部调用','2018-12-04 10:30:41','172.16.227.132','execution(void com.gree.auth.controller.timer.ClearDataTimer.clearData())','','系统内部调用'),(8,'未知部门','系统内部调用','2018-12-04 10:32:43','172.16.227.132','execution(void com.gree.auth.controller.timer.ClearDataTimer.clearData())','','系统内部调用'),(9,'未知部门','系统内部调用','2018-12-04 10:33:58','172.16.227.132','execution(void com.gree.auth.controller.timer.ClearDataTimer.clearData())','','系统内部调用'),(10,'未知部门','系统内部调用','2018-12-04 10:36:44','172.16.227.132','execution(void com.gree.auth.controller.timer.ClearDataTimer.clearData())','','系统内部调用'),(11,'未知部门','系统内部调用','2018-12-04 10:37:53','172.16.227.132','execution(void com.gree.auth.controller.timer.ClearDataTimer.clearData())','','系统内部调用'),(12,'未知部门','系统内部调用','2018-12-04 10:38:17','172.16.227.132','execution(void com.gree.auth.controller.timer.ClearDataTimer.clearData())','','系统内部调用'),(13,'未知部门','系统内部调用','2018-12-04 10:38:43','172.16.227.132','execution(void com.gree.auth.controller.timer.ClearDataTimer.clearData())','','系统内部调用'),(14,'未知部门','系统内部调用','2018-12-04 10:41:06','172.16.227.132','execution(void com.gree.auth.controller.timer.ClearDataTimer.clearData())','','系统内部调用'),(15,'未知部门','系统内部调用','2018-12-04 10:42:29','172.16.227.132','execution(void com.gree.auth.controller.timer.ClearDataTimer.clearData())','','系统内部调用'),(16,'未知部门','系统内部调用','2018-12-04 10:44:23','172.16.227.132','execution(void com.gree.auth.controller.timer.ClearDataTimer.clearData())','','系统内部调用'),(17,'未知部门','系统内部调用','2018-12-04 10:50:42','172.16.227.132','execution(void com.gree.auth.controller.timer.ClearDataTimer.clearData())','','系统内部调用'),(18,'未知部门','系统内部调用','2018-12-04 10:51:57','172.16.227.132','execution(void com.gree.auth.controller.timer.ClearDataTimer.clearData())','','系统内部调用'),(19,'未知部门','系统内部调用','2018-12-04 10:54:06','172.16.227.132','execution(void com.gree.auth.controller.timer.ClearDataTimer.clearData())','','系统内部调用'),(20,'未知部门','系统内部调用','2018-12-04 10:54:48','172.16.227.132','execution(void com.gree.auth.controller.timer.ClearDataTimer.clearData())','','系统内部调用'),(21,'未知部门','系统内部调用','2018-12-04 10:55:09','172.16.227.132','execution(void com.gree.auth.controller.timer.ClearDataTimer.clearData())','','系统内部调用'),(22,'未知部门','系统内部调用','2018-12-04 10:55:28','172.16.227.132','execution(void com.gree.auth.controller.timer.ClearDataTimer.clearData())','','系统内部调用'),(23,'未知部门','系统内部调用','2018-12-04 11:07:53','172.16.227.132','execution(void com.gree.auth.controller.timer.ClearDataTimer.clearData())','','系统内部调用'),(24,'未知部门','未知邮箱','2018-12-04 11:08:06','172.16.227.132','execution(Result com.gree.auth.controller.TestAuthController.login(HttpServletResponse))','com.alibaba.druid.support.http.WebStatFilter$StatHttpServletResponseWrapper@14819c03','未知姓名'),(25,'未知部门','系统内部调用','2018-12-04 11:12:13','172.16.227.132','execution(void com.gree.auth.controller.timer.ClearDataTimer.clearData())','','系统内部调用'),(26,'未知部门','未知邮箱','2018-12-04 11:12:22','172.16.227.132','execution(Result com.gree.auth.controller.TestAuthController.login(HttpServletResponse))','com.alibaba.druid.support.http.WebStatFilter$StatHttpServletResponseWrapper@1e16bfe9','未知姓名'),(27,'未知部门','未知邮箱','2018-12-04 11:13:05','172.16.227.132','execution(Result com.gree.auth.controller.TestAuthController.testAuth())','','未知姓名'),(28,'未知部门','未知邮箱','2018-12-04 11:13:10','172.16.227.132','execution(Result com.gree.auth.controller.TestAuthController.testAuth())','','未知姓名'),(29,'未知部门','未知邮箱','2018-12-04 11:13:10','172.16.227.132','execution(Result com.gree.auth.controller.TestAuthController.testAuth())','','未知姓名'),(30,'未知部门','未知邮箱','2018-12-04 11:13:11','172.16.227.132','execution(Result com.gree.auth.controller.TestAuthController.testAuth())','','未知姓名'),(31,'未知部门','未知邮箱','2018-12-04 11:13:11','172.16.227.132','execution(Result com.gree.auth.controller.TestAuthController.testAuth())','','未知姓名'),(32,'未知部门','未知邮箱','2018-12-04 11:13:11','172.16.227.132','execution(Result com.gree.auth.controller.TestAuthController.testAuth())','','未知姓名'),(33,'未知部门','未知邮箱','2018-12-04 11:13:11','172.16.227.132','execution(Result com.gree.auth.controller.TestAuthController.testAuth())','','未知姓名'),(34,'未知部门','未知邮箱','2018-12-04 11:13:12','172.16.227.132','execution(Result com.gree.auth.controller.TestAuthController.testAuth())','','未知姓名'),(35,'未知部门','未知邮箱','2018-12-04 11:13:12','172.16.227.132','execution(Result com.gree.auth.controller.TestAuthController.testAuth())','','未知姓名'),(36,'未知部门','未知邮箱','2018-12-04 11:13:12','172.16.227.132','execution(Result com.gree.auth.controller.TestAuthController.testAuth())','','未知姓名'),(37,'未知部门','未知邮箱','2018-12-04 11:13:12','172.16.227.132','execution(Result com.gree.auth.controller.TestAuthController.testAuth())','','未知姓名'),(38,'未知部门','未知邮箱','2018-12-04 11:13:12','172.16.227.132','execution(Result com.gree.auth.controller.TestAuthController.testAuth())','','未知姓名');
/*!40000 ALTER TABLE `t_user_operation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_user_role`
--

DROP TABLE IF EXISTS `t_user_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_user_role` (
  `user_role_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL,
  PRIMARY KEY (`user_role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_user_role`
--

LOCK TABLES `t_user_role` WRITE;
/*!40000 ALTER TABLE `t_user_role` DISABLE KEYS */;
INSERT INTO `t_user_role` VALUES (1,1,1),(2,1,2),(3,2,1);
/*!40000 ALTER TABLE `t_user_role` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-12-04 11:30:15
