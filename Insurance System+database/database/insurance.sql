

DROP TABLE IF EXISTS `policy`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `policy` (
  `policy_id` int NOT NULL AUTO_INCREMENT,
  `title` varchar(50) NOT NULL,
  `discription` text NOT NULL,
  `policy_type` varchar(20) NOT NULL,
  `cdate` date NOT NULL,
  `ctime` time NOT NULL,
  PRIMARY KEY (`policy_id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `policy`
--

LOCK TABLES `policy` WRITE;
/*!40000 ALTER TABLE `policy` DISABLE KEYS */;
INSERT INTO `policy` VALUES (10,'Day Care Surgery expenses',' The SLI Annual Medical Plan also consists of a unique No Claim Bonus scheme, which increases the basic sum insured by 5%, up to a maximum of 50%, for every claim free year.','life','2018-06-02','18:31:29'),(13,'Free road side assistance service','This is why our policies are designed to make your life easier by offering you far more than just motor insurance','motor','2018-06-02','18:29:57'),(14,'Cover for buildings and fixtures.','This is an insurance solution designed to cater to the insurance requirements of planters and tea factory owners','property','2018-06-02','18:30:37'),(15,'Civil engineering work','This policy provides protection against risks related to manufacturing plants and associated machinery','property','2018-06-02','18:31:02'),(16,'SLI Comprehensive Plan','The SLI Comprehensive plan provides stable financial support in the event you need to reimburse your medical bills under a pre-specified maximum during a hospital stay','life','2018-06-02','19:00:07'),(18,'Dedicated and proactive customer care team.','This is why our policies are designed to make your life easier by offering you far more than just motor insurance','motor','2018-06-02','19:04:14');
/*!40000 ALTER TABLE `policy` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `user_id` varchar(15) NOT NULL,
  `password` varchar(20) NOT NULL,
  `user_type` varchar(10) NOT NULL,
  `name` varchar(100) NOT NULL,
  `email` varchar(30) NOT NULL,
  `address` varchar(100) NOT NULL,
  `tel` int NOT NULL,
  `cdate` date NOT NULL,
  `ctime` time NOT NULL,
  `lon` double NOT NULL,
  `lat` double NOT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES ('c-100200','123','Client','Sajitha Athaudha','sajitha@gmail.com','Pitipana,Homagama.',775698423,'2018-06-02','18:35:37',79.9243713867188,6.936301959406526),('c-100201','123','Client','Lasantha Wickramasinghe','lasantha@gmail.com','Kadugannawa,Kandy',725566987,'2018-06-02','18:36:25',79.90274205322271,6.94039166144653),('c-100203','123','Client','Tharindhu Lakshan','tharindhu@gmail.com','No 106, 18th Lane, isurupura, malabe',770179403,'2018-06-02','18:57:07',79.9899460327149,6.931871408787362);
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users_policy`
--

DROP TABLE IF EXISTS `users_policy`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users_policy` (
  `user_id` varchar(15) NOT NULL,
  `policy_id` int NOT NULL,
  `cdate` date NOT NULL,
  `ctime` time NOT NULL,
  PRIMARY KEY (`user_id`,`policy_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users_policy`
--

LOCK TABLES `users_policy` WRITE;
/*!40000 ALTER TABLE `users_policy` DISABLE KEYS */;
INSERT INTO `users_policy` VALUES ('c-100200',10,'2018-06-02','19:21:44'),('c-100200',13,'2018-06-02','19:21:44'),('c-100200',14,'2018-06-02','19:21:44'),('c-100200',15,'2020-03-29','12:27:07'),('c-100201',10,'2018-06-02','19:33:43'),('c-100201',13,'2018-06-02','19:33:43'),('c-100201',14,'2018-06-02','19:33:43');
/*!40000 ALTER TABLE `users_policy` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

