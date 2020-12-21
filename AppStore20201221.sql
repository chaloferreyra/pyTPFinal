CREATE DATABASE  IF NOT EXISTS `appstore` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `appstore`;
-- MySQL dump 10.13  Distrib 8.0.22, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: appstore
-- ------------------------------------------------------
-- Server version	8.0.16

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
-- Table structure for table `aplicacion`
--

DROP TABLE IF EXISTS `aplicacion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `aplicacion` (
  `aplicacion_id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `detalle` varchar(255) NOT NULL,
  `precio` decimal(8,2) NOT NULL,
  `fechaAlta` datetime NOT NULL,
  `idCategoria` int(11) DEFAULT NULL,
  `idUsuario` int(11) NOT NULL,
  `idCalificacion` int(11) DEFAULT NULL,
  `nomImg` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`aplicacion_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `aplicacion`
--

LOCK TABLES `aplicacion` WRITE;
/*!40000 ALTER TABLE `aplicacion` DISABLE KEYS */;
INSERT INTO `aplicacion` VALUES (1,'ChessMaster','El ajedrez o chess es un excelente entrenamiento mental para niños y adultos. Juega ajedrez con amigos, que desarrolla el pensamiento lógico\r.',100.00,'2020-12-17 00:00:00',1,1,NULL,NULL),(2,'SoundCloud Música','Encuentra música nueva. Colecciona canciones y listas de reproducción. Sigue a amigos y artistas. Descubre podcasts, humor y noticias.',50.00,'2020-12-17 00:00:00',3,4,NULL,'soundCloud.png'),(3,'Spotify','Escuchar música, podcasts y canciones nuevas basadas en tus gustos, sin quebrarte la cabeza y de forma gratuita es posible con Spotify',100.00,'2020-12-17 00:00:00',3,4,NULL,'Spotifi.png'),(4,'Firefox','Disfruta de una Web rápida, inteligente y personal.',50.00,'2020-12-17 00:00:00',1,6,NULL,'firefox.png'),(5,'Clima a 14 Días','Información meteorológica para Latinoamérica, Estados Unidos y el resto mundo.',1.00,'2020-12-17 00:00:00',1,3,NULL,'elClima.png'),(6,'TikTok','TikTok is THE destination for mobile videos. On TikTok, short-form videos are exciting, spontaneous, and genuine.',20.00,'2020-12-17 00:00:00',2,3,NULL,'ticToc.png'),(7,'Shazam','Shazam identifica cualquier canción en segundos. Descubre artistas, letras, videos y playlists, todo gratis.',35.00,'2020-12-17 00:00:00',2,4,NULL,'shazam.png'),(8,'Booking','Descárgate la app de viajes mejor valorada con la que miles de personas encuentran ofertas para hoteles, hostales y apartamentos.',100.00,'2020-12-17 00:00:00',1,4,NULL,'booking.png'),(9,'Runtastic - Correr y Fitness','Con adidas Running podrás registrar todas tus actividades deportivas y analizar tus estadísticas.',25.00,'2020-12-17 00:00:00',2,3,NULL,'adidas.png');
/*!40000 ALTER TABLE `aplicacion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `appuser`
--

DROP TABLE IF EXISTS `appuser`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `appuser` (
  `appuser_id` int(11) NOT NULL AUTO_INCREMENT,
  `idUsuario` int(11) DEFAULT NULL,
  `idApp` int(11) DEFAULT NULL,
  `propia` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`appuser_id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `appuser`
--

LOCK TABLES `appuser` WRITE;
/*!40000 ALTER TABLE `appuser` DISABLE KEYS */;
INSERT INTO `appuser` VALUES (1,1,1,1),(2,4,2,1),(3,4,3,1),(4,4,2,0),(5,4,2,0),(6,6,4,1),(7,3,5,1),(8,3,6,1),(9,4,7,1),(10,4,3,0),(11,4,8,1),(12,3,9,1);
/*!40000 ALTER TABLE `appuser` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `calificacion`
--

DROP TABLE IF EXISTS `calificacion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `calificacion` (
  `calificacion_id` int(11) NOT NULL AUTO_INCREMENT,
  `puntaje` int(11) DEFAULT NULL,
  `opinion` varchar(255) DEFAULT NULL,
  `idAplicacion` int(11) DEFAULT NULL,
  `idUsuario` int(11) DEFAULT NULL,
  `calificacioncol` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`calificacion_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `calificacion`
--

LOCK TABLES `calificacion` WRITE;
/*!40000 ALTER TABLE `calificacion` DISABLE KEYS */;
/*!40000 ALTER TABLE `calificacion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `categoria`
--

DROP TABLE IF EXISTS `categoria`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `categoria` (
  `categoria_id` int(11) NOT NULL AUTO_INCREMENT,
  `n_categoria` varchar(45) DEFAULT NULL,
  `descripcion` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`categoria_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categoria`
--

LOCK TABLES `categoria` WRITE;
/*!40000 ALTER TABLE `categoria` DISABLE KEYS */;
INSERT INTO `categoria` VALUES (1,'Todos','Todas las apps'),(2,'Adolescentes','Apps para pasar el rato'),(3,'Musica','Las mejores app para escuchar musica');
/*!40000 ALTER TABLE `categoria` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipousuario`
--

DROP TABLE IF EXISTS `tipousuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tipousuario` (
  `tipoUsuario_id` int(11) NOT NULL AUTO_INCREMENT,
  `n_tipoUsuario` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`tipoUsuario_id`),
  UNIQUE KEY `tipoUsuario_id_UNIQUE` (`tipoUsuario_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipousuario`
--

LOCK TABLES `tipousuario` WRITE;
/*!40000 ALTER TABLE `tipousuario` DISABLE KEYS */;
INSERT INTO `tipousuario` VALUES (1,'Consumidor'),(2,'Desarrollador');
/*!40000 ALTER TABLE `tipousuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuarios` (
  `usuario_id` int(11) NOT NULL AUTO_INCREMENT,
  `nick_usuario` varchar(45) NOT NULL,
  `pass_usuario` varchar(45) NOT NULL,
  `n_usuario` varchar(100) DEFAULT NULL,
  `a_usuario` varchar(100) DEFAULT NULL,
  `dni_usuario` int(11) DEFAULT NULL,
  `correo_usuario` varchar(255) NOT NULL,
  `img_usuario` varchar(45) DEFAULT NULL,
  `id_tipo` int(11) NOT NULL,
  PRIMARY KEY (`usuario_id`),
  UNIQUE KEY `usuario_id_UNIQUE` (`usuario_id`),
  UNIQUE KEY `nick_usuario_UNIQUE` (`nick_usuario`),
  UNIQUE KEY `correo_usuario_UNIQUE` (`correo_usuario`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios`
--

LOCK TABLES `usuarios` WRITE;
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
INSERT INTO `usuarios` VALUES (1,'chalo','1','Gonzalo','Ferreyra',25918293,'chalo@user.com','user5.png',2),(2,'cacho','1','Carlos','Fernandez',11000666,'chancho@va.com','user1.png',1),(3,'ciro','1234','Ciro','Martinez',20111222,'ciro@martinez.com','ciro.png',2),(4,'charly','1','Carlos Alberto','Garcia',10222111,'charly@garcia.com','charly.png',2),(5,'fabi','1','Fabiana','Cantilo',18000111,'fabi@cantilo.com','Fabi.jpg',1),(6,'flaco','1234','Luis Alberto','Spinetta',15333222,'flaco@spinetta.com','spinetta.png',2),(7,'hilda','1','Hilda','Lizarazu',20111444,'hilda@lizarazu.com','HILDA.png',1);
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-12-21 10:20:51
