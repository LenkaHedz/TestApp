-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: testdb
-- ------------------------------------------------------
-- Server version	5.7.21-log

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
-- Table structure for table `answer`
--

DROP TABLE IF EXISTS `answer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `answer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `idquestion` int(11) DEFAULT NULL,
  `name` varchar(125) DEFAULT NULL,
  `name_ru` varchar(125) DEFAULT NULL,
  `ball` int(11) DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `FK_ANSWER_IDQUESTION_idx` (`idquestion`),
  CONSTRAINT `FK_ANSWER_IDQUESTION` FOREIGN KEY (`idquestion`) REFERENCES `question` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=49 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `answer`
--

LOCK TABLES `answer` WRITE;
/*!40000 ALTER TABLE `answer` DISABLE KEYS */;
INSERT INTO `answer` VALUES (1,1,'Alive organisms','Живые организмы',10),(2,1,'Processes of mountain building','Процессы горного строительства',0),(3,1,'Substances and their transformations','Вещества и их трансформации',0),(4,2,'Plants','Растениях',0),(5,2,'Mushrooms','Грибах',10),(6,2,'Animals','Животных',0),(7,3,'Zoology','Зоология',0),(8,3,'Botany','Ботаника',10),(9,3,'Mycology','Микология',0),(10,4,'Eating and breathing','Питание и дыхание',10),(11,4,'Metabolism and irritability','Метаболизм и раздражительность',0),(12,4,'Burning and oxidation','Сжигание и окисление',0),(13,5,'Autotrophs and producers','Автотрофы и производители',10),(14,5,'Heterotrophs and consumers','Гетеротрофы и потребители',0),(15,5,'Destroyers','Разрушители',0),(16,6,'Ash','Ясень',0),(17,6,'Dogrose','Шиповник',0),(18,6,'Maple','Клен',5),(19,6,'Oak','Дуб',5),(20,7,'Lack of heat','Нехватке тепла',0),(21,7,'Lack of water','Нехватке воды',10),(22,8,'Apple trees','Яблони',0),(23,8,'Nettles','Крапивы',10),(24,8,'Clover','Клевера',0),(25,9,'Integumentary','Покровная',0),(26,9,'Conducting','Проводящая',0),(27,9,'Basic','Основная',10),(28,9,'Mechanical','Механическая',0),(29,10,'Photosynthesize','Фотосинтезируют',0),(30,10,'The cell wall consists of cellulose','Клеточная стенка состоит из целлюлозы',10),(31,10,'Do not use oxygen for breathing','Не используют кислород для дыхания',0),(32,10,'Grow up all life','Растут всю жизнь',0),(33,11,'Microorganisms that do not have a formal nucleus','Микроорганизмы, не имеющие оформленного ядра',10),(34,11,'They have a nuclear envelope','Имеют ядерную оболочку',0),(35,11,'Have a capsid','Имеют капсид',0),(36,12,'Kokki','Кокки',5),(37,12,'Sticks','Палочки',5),(38,12,'Mushrooms','Грибы',0),(39,13,'The double-stranded DNA molecule','Двунитевая молекула ДНК',10),(40,13,'Has a single-stranded DNA','Имеет однонитевую ДНК',0),(41,13,'It is divided by mitosis','Делится митозом',0),(42,13,'Fragmented RNA','Фрагментированная РНК',0),(43,14,'Participates in division','Участвует в делении',0),(44,14,'Consists of lipids','Состоит из липидов',0),(45,14,'Protects against phagocytes','Защищает от фагоцитов',10),(46,15,'Oligotrophs','Олиготрофами',0),(47,15,'Autotrophs','Аутотрофами',10),(48,15,'Phagocytes','Фагоцитами',0);
/*!40000 ALTER TABLE `answer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `category` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(125) DEFAULT NULL,
  `name_ru` varchar(125) DEFAULT NULL,
  `alias` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` VALUES (1,'Biology','Биология','BIOLOGY'),(2,'Programming','Программирование','PROGRAMMING'),(3,'Mathematics','Математика','MATHEMATICS');
/*!40000 ALTER TABLE `category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `question`
--

DROP TABLE IF EXISTS `question`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `question` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `idtest` int(11) DEFAULT NULL,
  `name` varchar(125) DEFAULT NULL,
  `name_ru` varchar(125) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_QUESTION_IDTEST_idx` (`idtest`),
  CONSTRAINT `FK_QUESTION_IDTEST` FOREIGN KEY (`idtest`) REFERENCES `test` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `question`
--

LOCK TABLES `question` WRITE;
/*!40000 ALTER TABLE `question` DISABLE KEYS */;
INSERT INTO `question` VALUES (1,1,'What does biology study?','Что изучает биология?'),(2,1,'Mycology is the science of','Микология - это наука о'),(3,1,'Plant organisms are studying','Изучает растительные организмы'),(4,1,'Signs of a living organism are not','Признаком живого организма не являются'),(5,1,'Plants in the food chain are','Растения в пищевой цепи это'),(6,2,'Choose a plant with simple leaves','Выберите растение с простыми листьями'),(7,2,'Leaf fall is the adaptation of plants to','Листопад — это приспособление растений к'),(8,2,'Same-sex flowers occur in','Однополые цветки встречаются у'),(9,2,'The storing function is performed by the tissue','Запасающую функцию выполняет ткань'),(10,2,'Only plants are characterized by a sign','Только растениям характерен признак'),(11,3,'Bacteria are','Бактерии это'),(12,3,'The main forms of bacteria are','Основными формами бактерий являются'),(13,3,'Nucleoid','Нуклеоид'),(14,3,'Bacterial Capsule','Капсула бактерий'),(15,3,'Nitrifying bacteria are','Нитрифицирующие бактерии являются');
/*!40000 ALTER TABLE `question` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `test`
--

DROP TABLE IF EXISTS `test`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `test` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `category` varchar(45) DEFAULT NULL,
  `idcategory` int(11) DEFAULT NULL,
  `name` varchar(125) DEFAULT NULL,
  `name_ru` varchar(125) DEFAULT NULL,
  `description` varchar(125) DEFAULT NULL,
  `description_ru` varchar(125) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_TEST_IDCATEGORY_idx1` (`idcategory`),
  CONSTRAINT `FK_TEST_IDCATEGORY` FOREIGN KEY (`idcategory`) REFERENCES `category` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `test`
--

LOCK TABLES `test` WRITE;
/*!40000 ALTER TABLE `test` DISABLE KEYS */;
INSERT INTO `test` VALUES (1,'BIOLOGY',1,'Science Biology','Наука Биология','Basic concepts of science','Основные понятия о науке'),(2,'BIOLOGY',1,'Botany','Ботаника','The science about plants','Наука о растениях'),(3,'BIOLOGY',1,'Microbiology','Микробиология','The science about microorganisms','Наука о микроорганизмах');
/*!40000 ALTER TABLE `test` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `login` varchar(125) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  `role` varchar(45) DEFAULT NULL,
  `name` varchar(125) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT='Користувач (Адміністратор, Студент)';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'admin@admin.com','12345','Admin','Administrator'),(2,'ivanov@test.com','23456','User','Ivanov Sergey Ivanovich'),(3,'petrov@test.com','34567','User','Petrov Igor Vasilevich'),(4,'sidorov@test.com','45678','User','Sidorov Georgiy Sergeevich'),(5,'shevchenko@test.com','56789','User','Shevchenko Irina Urievna'),(6,'ivaschenko@test.ua','56789','User','Ivaschenko Maria Pavlovna');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_answer`
--

DROP TABLE IF EXISTS `user_answer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_answer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `iduser_test` int(11) DEFAULT NULL,
  `idanswer` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_USER_ANSWER_IDANSWER_idx` (`idanswer`),
  KEY `FK_USER_ANSWER_IDUSER_TEST_idx` (`iduser_test`),
  CONSTRAINT `FK_USER_ANSWER_IDANSWER` FOREIGN KEY (`idanswer`) REFERENCES `answer` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_USER_ANSWER_IDUSER_TEST` FOREIGN KEY (`iduser_test`) REFERENCES `user_test` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_answer`
--

LOCK TABLES `user_answer` WRITE;
/*!40000 ALTER TABLE `user_answer` DISABLE KEYS */;
INSERT INTO `user_answer` VALUES (1,1,1),(2,1,4),(3,1,8),(4,1,11),(5,1,13),(6,2,18),(7,2,19),(8,2,21),(9,2,24),(10,2,26),(11,2,30),(12,3,3),(13,3,5),(14,3,8),(15,3,10),(16,3,13),(17,4,34),(18,4,37),(19,4,40),(20,4,43),(21,4,48);
/*!40000 ALTER TABLE `user_answer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_test`
--

DROP TABLE IF EXISTS `user_test`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_test` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `iduser` int(11) DEFAULT NULL,
  `idtest` int(11) DEFAULT NULL,
  `date_pass` date DEFAULT NULL,
  `ball` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_USER_TEST_IDUSER_idx` (`iduser`),
  KEY `FK_USER_TEST_IDTEST_idx` (`idtest`),
  CONSTRAINT `FK_USER_TEST_IDTEST` FOREIGN KEY (`idtest`) REFERENCES `test` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_USER_TEST_IDUSER` FOREIGN KEY (`iduser`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_test`
--

LOCK TABLES `user_test` WRITE;
/*!40000 ALTER TABLE `user_test` DISABLE KEYS */;
INSERT INTO `user_test` VALUES (1,2,1,'2018-05-20',30),(2,2,2,'2018-05-21',30),(3,3,1,'2018-05-10',40),(4,2,3,'2018-05-22',5);
/*!40000 ALTER TABLE `user_test` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-05-21 11:29:32
