-- MySQL dump 10.13  Distrib 5.7.20, for Linux (x86_64)
--
-- Host: localhost    Database: sigecu
-- ------------------------------------------------------
-- Server version	5.7.20-0ubuntu0.16.04.1

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
-- Table structure for table `alumno`
--

DROP TABLE IF EXISTS `alumno`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `alumno` (
  `id_alumno` int(11) NOT NULL AUTO_INCREMENT,
  `a_carrera` varchar(255) DEFAULT NULL,
  `a_email` varchar(255) DEFAULT NULL,
  `a_materno` varchar(255) DEFAULT NULL,
  `a_nombre` varchar(255) DEFAULT NULL,
  `a_notebook` varchar(255) DEFAULT NULL,
  `a_paterno` varchar(255) DEFAULT NULL,
  `a_status` varchar(255) DEFAULT NULL,
  `a_telefono` varchar(255) DEFAULT NULL,
  `user_id_user` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_alumno`),
  KEY `FKdbslvcvpb7juth93p3regdp66` (`user_id_user`),
  CONSTRAINT `FKdbslvcvpb7juth93p3regdp66` FOREIGN KEY (`user_id_user`) REFERENCES `users` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `alumno`
--

LOCK TABLES `alumno` WRITE;
/*!40000 ALTER TABLE `alumno` DISABLE KEYS */;
INSERT INTO `alumno` VALUES (2,'ISC','castillor493@gmail.com','Martinez','Rolando','1','Castillo','1','2345643453','rcastillo'),(5,'ISC','jose-ramirez03@live.com.mx','Matias','Salomon','1','Ramirez','1','+54 (545) 548-48-84','Salomon'),(6,'ISC','jorge@glsf.com','Diaz','Jorge','1','Luna','1','+44 (233) 423-43-44','Jorge'),(7,'TI','galma@gmail.com','Nose','Alma','1','Granados','1','+34 (345) 565-46-75','Alma'),(8,'TI','castillomartinez@acm.org','Cruz','Guillermo','1','González','0','+55 (245) 855-66-66','Guillermo');
/*!40000 ALTER TABLE `alumno` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `alumno_has_eventos`
--

DROP TABLE IF EXISTS `alumno_has_eventos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `alumno_has_eventos` (
  `activo` int(11) NOT NULL,
  `confirmado` varchar(255) DEFAULT NULL,
  `id_evento` int(11) NOT NULL,
  `id_alumno` int(11) NOT NULL,
  `id_asigna_examen` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_alumno`,`id_evento`),
  KEY `FKhsaay5b56j3hruthfwn0ccv2k` (`id_evento`),
  KEY `FKnjufl9jt69f7a2puqjj4cdidn` (`id_asigna_examen`),
  CONSTRAINT `FKhsaay5b56j3hruthfwn0ccv2k` FOREIGN KEY (`id_evento`) REFERENCES `eventos` (`id_evento`),
  CONSTRAINT `FKia8csaxisd8ikg32gxwr27ifa` FOREIGN KEY (`id_alumno`) REFERENCES `alumno` (`id_alumno`),
  CONSTRAINT `FKnjufl9jt69f7a2puqjj4cdidn` FOREIGN KEY (`id_asigna_examen`) REFERENCES `asigna_examen` (`idasigna_examen`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `alumno_has_eventos`
--

LOCK TABLES `alumno_has_eventos` WRITE;
/*!40000 ALTER TABLE `alumno_has_eventos` DISABLE KEYS */;
INSERT INTO `alumno_has_eventos` VALUES (1,'1',1,2,23),(1,'1',3,2,17),(1,'1',1,5,20),(1,'1',2,5,22),(1,'1',3,6,19),(1,'1',1,7,21),(1,'1',2,7,18),(1,'1',3,8,24);
/*!40000 ALTER TABLE `alumno_has_eventos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `asigna_examen`
--

DROP TABLE IF EXISTS `asigna_examen`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `asigna_examen` (
  `idasigna_examen` int(11) NOT NULL AUTO_INCREMENT,
  `asignado` varchar(255) DEFAULT NULL,
  `fecha_fin` varchar(255) DEFAULT NULL,
  `fecha_inicio` varchar(255) DEFAULT NULL,
  `hora_inicio` varchar(255) DEFAULT NULL,
  `horafin` varchar(255) DEFAULT NULL,
  `realizado` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`idasigna_examen`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `asigna_examen`
--

LOCK TABLES `asigna_examen` WRITE;
/*!40000 ALTER TABLE `asigna_examen` DISABLE KEYS */;
INSERT INTO `asigna_examen` VALUES (17,'0','2018-01-20','2018-01-19',NULL,NULL,'1','0'),(18,'0',NULL,NULL,NULL,NULL,'0','0'),(19,'0',NULL,NULL,NULL,NULL,'0','0'),(20,'0','2018-01-19','2018-01-19',NULL,NULL,'1','1'),(21,'0','2018-01-20','2018-01-19',NULL,NULL,'1','1'),(22,'0',NULL,NULL,NULL,NULL,'0','0'),(23,'0','2018-01-20','2018-01-19',NULL,NULL,'1','1'),(24,'0','2018-01-19','2018-01-19',NULL,NULL,'1','1');
/*!40000 ALTER TABLE `asigna_examen` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `certificado`
--

DROP TABLE IF EXISTS `certificado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `certificado` (
  `id_certificado` int(11) NOT NULL AUTO_INCREMENT,
  `alumno` varchar(255) DEFAULT NULL,
  `calificacion` float DEFAULT NULL,
  `curso` varchar(255) DEFAULT NULL,
  `fecha` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_certificado`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `certificado`
--

LOCK TABLES `certificado` WRITE;
/*!40000 ALTER TABLE `certificado` DISABLE KEYS */;
INSERT INTO `certificado` VALUES (1,'Rolando Castillo Martinez',9,'CNA Security v2.0 Chapter 2','2018/12/12');
/*!40000 ALTER TABLE `certificado` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cursos`
--

DROP TABLE IF EXISTS `cursos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cursos` (
  `id_curso` int(11) NOT NULL AUTO_INCREMENT,
  `c_descripcion` varchar(255) DEFAULT NULL,
  `c_nombre` varchar(45) NOT NULL,
  PRIMARY KEY (`id_curso`),
  UNIQUE KEY `UK_dw3ogciba4x9i4xdvrxaac4v` (`c_nombre`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cursos`
--

LOCK TABLES `cursos` WRITE;
/*!40000 ALTER TABLE `cursos` DISABLE KEYS */;
INSERT INTO `cursos` VALUES (1,'descripcion','programacion distribuidad'),(2,'Examen de Cisco CCNA Security','CCNA Security'),(3,'Java Fundamentals para principiantes en programación','Java Fundamentals');
/*!40000 ALTER TABLE `cursos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `evaluaciones`
--

DROP TABLE IF EXISTS `evaluaciones`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `evaluaciones` (
  `id_evaluacion` int(11) NOT NULL AUTO_INCREMENT,
  `e_nombre` varchar(255) DEFAULT NULL,
  `e_porsentaje` varchar(255) DEFAULT NULL,
  `e_tiempo` varchar(255) DEFAULT NULL,
  `cursos_id_curso` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_evaluacion`),
  KEY `FKrgjjq8i1gxsy3o26fc0mw7maf` (`cursos_id_curso`),
  CONSTRAINT `FKrgjjq8i1gxsy3o26fc0mw7maf` FOREIGN KEY (`cursos_id_curso`) REFERENCES `cursos` (`id_curso`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `evaluaciones`
--

LOCK TABLES `evaluaciones` WRITE;
/*!40000 ALTER TABLE `evaluaciones` DISABLE KEYS */;
INSERT INTO `evaluaciones` VALUES (2,'CCNA Security v2.0 Chapter 2','80','01:00:00',2),(4,'Programación distribuida','70','01:00:00',1),(5,'Java y POO','80','01:00:00',3);
/*!40000 ALTER TABLE `evaluaciones` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `eventos`
--

DROP TABLE IF EXISTS `eventos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `eventos` (
  `id_evento` int(11) NOT NULL AUTO_INCREMENT,
  `e_capacidad` varchar(255) DEFAULT NULL,
  `e_descripcion` varchar(255) DEFAULT NULL,
  `e_estatus` varchar(255) DEFAULT NULL,
  `e_fecha_inicio` varchar(255) DEFAULT NULL,
  `e_fecha_termino` varchar(255) DEFAULT NULL,
  `e_horario` varchar(255) DEFAULT NULL,
  `e_programa` varchar(255) DEFAULT NULL,
  `e_tipo` varchar(255) DEFAULT NULL,
  `id_curso` int(11) DEFAULT NULL,
  `id_instructor` int(11) DEFAULT NULL,
  `e_status` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_evento`),
  KEY `FK5wet7eu6o958qcnxaa70bf81p` (`id_curso`),
  KEY `FKi3jocuj9v11rldew4d5ijv5ev` (`id_instructor`),
  CONSTRAINT `FK5wet7eu6o958qcnxaa70bf81p` FOREIGN KEY (`id_curso`) REFERENCES `cursos` (`id_curso`),
  CONSTRAINT `FKi3jocuj9v11rldew4d5ijv5ev` FOREIGN KEY (`id_instructor`) REFERENCES `instructor` (`id_instructor`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `eventos`
--

LOCK TABLES `eventos` WRITE;
/*!40000 ALTER TABLE `eventos` DISABLE KEYS */;
INSERT INTO `eventos` VALUES (1,'5','s/n','1','2018-01-02','2018-04-13','08:00','programa','t',1,3,'1'),(2,'5','s/n','1','2018-01-10','2018-03-08','08:00-10:00','s/n','4',2,3,'1'),(3,'10','s/n','1','2018-01-09','2018-04-28','13:00-14:00','s/n','2',3,4,'1');
/*!40000 ALTER TABLE `eventos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `instructor`
--

DROP TABLE IF EXISTS `instructor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `instructor` (
  `id_instructor` int(11) NOT NULL AUTO_INCREMENT,
  `carrera` varchar(255) DEFAULT NULL,
  `i_direccion` varchar(255) DEFAULT NULL,
  `i_email` varchar(255) DEFAULT NULL,
  `i_materno` varchar(255) DEFAULT NULL,
  `i_nombre` varchar(255) DEFAULT NULL,
  `i_paterno` varchar(255) DEFAULT NULL,
  `i_telefono` varchar(255) DEFAULT NULL,
  `user_id_user` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_instructor`),
  KEY `FKpiwd72o0sqyor8edt83e9jik6` (`user_id_user`),
  CONSTRAINT `FKpiwd72o0sqyor8edt83e9jik6` FOREIGN KEY (`user_id_user`) REFERENCES `users` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `instructor`
--

LOCK TABLES `instructor` WRITE;
/*!40000 ALTER TABLE `instructor` DISABLE KEYS */;
INSERT INTO `instructor` VALUES (1,'isc','s/n','instructor@mail.com','marquez','David','Diaz','442154225545','user2'),(3,'isc','s/n','ejemplo@gmail.com','mar','Leo','Trejo','4423534532','user'),(4,'ISC','Queretaro','juan@icc.com','Valdez','Juan','Diaz','+32 (435) 435-46-45','Juan');
/*!40000 ALTER TABLE `instructor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `preguntas`
--

DROP TABLE IF EXISTS `preguntas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `preguntas` (
  `id_pregunta` int(11) NOT NULL AUTO_INCREMENT,
  `p_descripcion` varchar(255) DEFAULT NULL,
  `p_pregunta` varchar(255) DEFAULT NULL,
  `p_puntaje` varchar(255) DEFAULT NULL,
  `evaluaciones_id_evaluacion` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_pregunta`),
  KEY `FK87no34wiq8cimm78xkiaveucs` (`evaluaciones_id_evaluacion`),
  CONSTRAINT `FK87no34wiq8cimm78xkiaveucs` FOREIGN KEY (`evaluaciones_id_evaluacion`) REFERENCES `evaluaciones` (`id_evaluacion`)
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `preguntas`
--

LOCK TABLES `preguntas` WRITE;
/*!40000 ALTER TABLE `preguntas` DISABLE KEYS */;
INSERT INTO `preguntas` VALUES (3,NULL,'An administrator defined a local user account with a secret password on router R1 for use with SSH. Which three additional steps are required to configure R1 to accept only encrypted SSH connections?','1',2),(16,'Because of implemented security controls, a user can only access a server with FTP. ','Because of implemented security controls, a user can only access a server with FTP. Which AAA component accomplishes this?','1',2),(17,'It provides a fallback authentication method if the administrator forgets the username or password.','Why is authentication with AAA preferred over a local database method?','1',2),(18,' local AAA','Which authentication method stores usernames and passwords in ther router and is ideal for small networks.','1',2),(19,' the state of packets related to the attack','What information must an IPS track in order to detect attacks matching a composite signature?','1',2),(33,'Solución: Una estructura de datos en la que las inserciones se realizan por un extremo y las extracciones por el otro extremo','Una cola es','1',4),(34,'Solución: 10','¿Cuál es el código ASCII decimal de \"nueva línea\" (line feed)?','1',4),(35,'Solución: Fortran','Se considera que el primer lenguaje de alto nivel fue','1',4),(36,'Solución: Tipos de datos','int, char, float, string y boolean son','1',4),(37,'Es un modelo o plantilla a partir de la cual creamos objetos','¿Cuál es la descripción que crees que define mejor el concepto \'clase\' en la programación orientada a objetos?','1',5),(38,'Sus atributos y sus métodos',' ¿Qué elementos crees que definen a un objeto?','1',5),(39,'public class Componente extends Producto','¿Qué código de los siguientes tiene que ver con la herencia?','1',5),(40,'Crear un objeto a partir de la clase',' ¿Qué significa instanciar una clase?','1',5);
/*!40000 ALTER TABLE `preguntas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `respuestaalm`
--

DROP TABLE IF EXISTS `respuestaalm`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `respuestaalm` (
  `id_pregunta` int(11) NOT NULL,
  `id_respuesta` int(11) NOT NULL,
  `seleccionada` varchar(255) DEFAULT NULL,
  `a_id_asigna_examen` int(11) DEFAULT NULL,
  `id_respuestaalm` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id_respuestaalm`),
  KEY `FKpwhmkrwimy7auyf4jittouvtd` (`a_id_asigna_examen`),
  CONSTRAINT `FKpwhmkrwimy7auyf4jittouvtd` FOREIGN KEY (`a_id_asigna_examen`) REFERENCES `asigna_examen` (`idasigna_examen`)
) ENGINE=InnoDB AUTO_INCREMENT=197 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `respuestaalm`
--

LOCK TABLES `respuestaalm` WRITE;
/*!40000 ALTER TABLE `respuestaalm` DISABLE KEYS */;
INSERT INTO `respuestaalm` VALUES (33,55,'1',23,177),(34,47,'1',23,178),(35,53,'1',23,179),(36,60,'1',23,180),(37,65,'1',17,181),(38,68,'1',17,182),(39,71,'1',17,183),(40,73,'1',17,184),(33,55,'1',21,185),(34,47,'1',21,186),(35,53,'1',21,187),(36,62,'1',21,188),(33,55,'1',20,189),(34,47,'2',20,190),(35,53,'2',20,191),(36,60,'2',20,192),(37,65,'2',24,193),(38,67,'2',24,194),(39,69,'1',24,195),(40,74,'2',24,196);
/*!40000 ALTER TABLE `respuestaalm` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `respuestas`
--

DROP TABLE IF EXISTS `respuestas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `respuestas` (
  `id_respuesta` int(11) NOT NULL AUTO_INCREMENT,
  `r_respuesta` varchar(255) DEFAULT NULL,
  `r_solucion` varchar(255) DEFAULT NULL,
  `preguntas_id_pregunta` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_respuesta`),
  KEY `FKlnq8ajrrdgo2ah7fhxod5dcf3` (`preguntas_id_pregunta`),
  CONSTRAINT `FKlnq8ajrrdgo2ah7fhxod5dcf3` FOREIGN KEY (`preguntas_id_pregunta`) REFERENCES `preguntas` (`id_pregunta`)
) ENGINE=InnoDB AUTO_INCREMENT=76 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `respuestas`
--

LOCK TABLES `respuestas` WRITE;
/*!40000 ALTER TABLE `respuestas` DISABLE KEYS */;
INSERT INTO `respuestas` VALUES (2,' Enable inbound vty SSH sessions.','1',3),(3,'Generate two-way pre-shared keys.','0',3),(4,' Configure DNS on the router.','0',3),(5,'Enable inbound vty Telnet sessions.','0',3),(6,'accounting','0',16),(7,'accessibility','0',16),(8,'auditing','0',16),(9,'authorization','1',16),(10,'authentication','0',16),(11,'It provides a fallback authentication method if the administrator forgets the username or password.','1',17),(12,'It uses less network bandwidth.','0',17),(13,'It specifies a different password for each line or port.','0',17),(14,'It requires a login and password combination on the console, vty lines, and aux ports.','0',17),(15,'local AAA over TACACS+','0',18),(16,' server-based AAA over TACACS+','0',18),(17,'local AAA','1',18),(18,'local AAA over RADIUS','0',18),(19,' server-based AAA over RADIUS','0',18),(20,' the state of packets related to the attack','0',19),(21,'the attacking period used by the attacker','0',19),(22,'the network bandwidth consumed by all packets','0',19),(23,'the state of packets related to the attack','1',19),(47,'10','1',34),(48,'13','0',34),(49,'32','0',34),(50,'Las anteriores respuestas no son correctas ','0',34),(51,'Ada','0',35),(52,'C','0',35),(53,'Fortran','1',35),(54,'Java','0',35),(55,'Una estructura de datos en la que las inserciones se realizan por un extremo y las extracciones por el otro extremo ','1',33),(56,'Una estructura de datos en la que las inserciones y extracciones se realizan por el mismo extremo ','0',33),(57,'Una estructura de datos en la que sólo se pueden realizar inserciones, pero nunca extracciones ','0',33),(58,'Las anteriores respuestas no son correctas','0',33),(59,'Funciones de acceso a datos ','0',36),(60,'Instrucciones de acceso a datos ','0',36),(61,'Sentencias de control ','0',36),(62,'Tipos de datos ','1',36),(63,'Es un concepto similar al de \'array\'','0',37),(64,'Es un tipo particular de variable','0',37),(65,'Es un modelo o plantilla a partir de la cual creamos objetos','1',37),(66,'Sus cardinalidad y su tipo','0',38),(67,'Sus atributos y sus métodos','1',38),(68,'La forma en que establece comunicación e intercambia mensajes','0',38),(69,'public class Componente extends Producto','1',39),(70,'public class Componente inherit Producto','0',39),(71,'public class Componente implements Producto','0',39),(72,'Duplicar una clase','0',40),(73,'Eliminar una clase','0',40),(74,'Crear un objeto a partir de la clase','1',40),(75,'Conectar dos clases entre sí','0',40);
/*!40000 ALTER TABLE `respuestas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_roles`
--

DROP TABLE IF EXISTS `user_roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_roles` (
  `user_role_id` int(11) NOT NULL AUTO_INCREMENT,
  `role` varchar(45) NOT NULL,
  `username` varchar(45) NOT NULL,
  `descripcion` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`user_role_id`),
  UNIQUE KEY `UKstlxfukw77ov5w1wo1tm3omca` (`role`,`username`),
  KEY `FKcdp2dxqcsdh6rnh6o64rgtcir` (`username`),
  CONSTRAINT `FKcdp2dxqcsdh6rnh6o64rgtcir` FOREIGN KEY (`username`) REFERENCES `users` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_roles`
--

LOCK TABLES `user_roles` WRITE;
/*!40000 ALTER TABLE `user_roles` DISABLE KEYS */;
INSERT INTO `user_roles` VALUES (2,'ROLE_INSTRUCTOR','user','ret'),(5,'ROLE_ADMIN','admin','gfg'),(7,'ROLE_ALUMNO','rcastillo','gfg'),(13,'ROLE_ALUMNO','Salomon','Usuario deSalomon'),(14,'ROLE_ALUMNO','Jorge','Usuario deJorge'),(17,'ROLE_INSTRUCTOR','Juan','Uuario de Juan'),(18,'ROLE_ALUMNO','Alma','Usuario deAlma'),(19,'ROLE_ALUMNO','Guillermo','Usuario deGuillermo');
/*!40000 ALTER TABLE `user_roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `username` varchar(45) NOT NULL,
  `password` varchar(60) NOT NULL,
  `imagen` varchar(255) DEFAULT NULL,
  `enable` bit(1) NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES ('admin','$2a$10$2agsutl/.szoei7Mv00sW.1Fzzc7sIB4ZEia4efFRloeQPxq/JDWW',NULL,''),('Alma','$2a$10$RH9SSTqzQR6jBByGHQQBjO4ZZJAPRgfaWRo5zD7LEwI69zFc2dxAG','',''),('Guillermo','$2a$10$CrWAq294PRltxjaYnLfjOO1eLTncBPDmc6B.RmEPxFJ7zBEsWB8Ba','',''),('Jorge','$2a$10$5vUtdhUEO1EsgKrw4cfGluoP21DTHj6HrV/A7Irk1hT8XvFJLa4fi','',''),('Juan','$2a$10$jZsNus5P/4vqN9JhrVB7je0hUXyGEPa7X.Pyzp457aXkXhQUH2ake','',''),('rcastillo','$2a$10$QUKURMQIqvmLl46pB9XetepJAk5zuM6q0pbe17zuEAHR919yMSrtC',NULL,''),('Salomon','$2a$10$.aCN5l87reCmoXUUsp9qVe.m.oSpxBG07XKn8y9WOiZoO720wUT9m','',''),('user','$2a$10$QUKURMQIqvmLl46pB9XetepJAk5zuM6q0pbe17zuEAHR919yMSrtC',NULL,''),('user2','$2a$10$QUKURMQIqvmLl46pB9XetepJAk5zuM6q0pbe17zuEAHR919yMSrtC',NULL,'');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users_user_role`
--

DROP TABLE IF EXISTS `users_user_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users_user_role` (
  `users_username` varchar(45) NOT NULL,
  `user_role_user_role_id` int(11) NOT NULL,
  PRIMARY KEY (`users_username`,`user_role_user_role_id`),
  UNIQUE KEY `UK_26l3q80lgc119dd7wy1lxpw0l` (`user_role_user_role_id`),
  CONSTRAINT `FK26xay5fkdjvcbtx6d0ok8t74b` FOREIGN KEY (`user_role_user_role_id`) REFERENCES `user_roles` (`user_role_id`),
  CONSTRAINT `FKmxgalyjysos352b5ipfgbhbvd` FOREIGN KEY (`users_username`) REFERENCES `users` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users_user_role`
--

LOCK TABLES `users_user_role` WRITE;
/*!40000 ALTER TABLE `users_user_role` DISABLE KEYS */;
/*!40000 ALTER TABLE `users_user_role` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-01-19 10:19:57
