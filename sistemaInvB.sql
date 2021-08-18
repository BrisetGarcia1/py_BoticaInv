-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               10.4.18-MariaDB - mariadb.org binary distribution
-- Server OS:                    Win64
-- HeidiSQL Version:             11.2.0.6213
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Dumping database structure for bd_boticainv
CREATE DATABASE IF NOT EXISTS `bd_boticainv` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci */;
USE `bd_boticainv`;

-- Dumping structure for table bd_boticainv.bitacorasesion
CREATE TABLE IF NOT EXISTS `bitacorasesion` (
  `idbitacora` int(11) NOT NULL AUTO_INCREMENT,
  `empleado` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `fechai` datetime DEFAULT NULL,
  `fechas` datetime DEFAULT NULL,
  PRIMARY KEY (`idbitacora`)
) ENGINE=InnoDB AUTO_INCREMENT=76 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- Dumping data for table bd_boticainv.bitacorasesion: ~64 rows (approximately)
/*!40000 ALTER TABLE `bitacorasesion` DISABLE KEYS */;
INSERT INTO `bitacorasesion` (`idbitacora`, `empleado`, `fechai`, `fechas`) VALUES
	(1, 'Diego', '2021-06-28 05:13:23', NULL),
	(2, 'Diego', '2021-06-28 05:13:23', '2021-06-28 05:13:30'),
	(3, 'Briset', '2021-06-28 05:14:21', NULL),
	(4, 'Briset', '2021-06-28 05:14:21', '2021-06-28 05:14:23'),
	(5, 'Diego', '2021-06-28 05:28:10', '2021-06-28 05:13:30'),
	(6, 'Diego', '2021-06-28 05:35:18', '2021-06-28 05:13:30'),
	(7, 'Diego', '2021-06-28 05:35:18', '2021-06-28 05:35:22'),
	(8, 'Briset', '2021-06-28 05:35:35', '2021-06-28 05:14:23'),
	(9, 'Briset', '2021-06-28 05:38:34', '2021-06-28 05:14:23'),
	(10, 'Briset', '2021-06-28 05:38:34', '2021-06-28 05:38:39'),
	(11, 'Diego', '2021-06-28 05:49:50', '2021-06-28 05:35:22'),
	(12, 'Diego', '2021-06-28 05:49:50', '2021-06-28 05:50:38'),
	(13, 'Diego', '2021-06-28 06:13:49', '2021-06-28 05:50:38'),
	(14, 'Luis', NULL, NULL),
	(15, 'Diego', '2021-06-28 06:13:49', '2021-06-28 06:14:43'),
	(16, 'Diego', '2021-06-28 06:14:58', '2021-06-28 06:14:43'),
	(17, 'Diego', '2021-06-28 06:19:43', '2021-06-28 06:14:43'),
	(18, 'Diego', '2021-06-28 06:25:42', '2021-06-28 06:14:43'),
	(19, 'Diego', '2021-06-28 06:43:57', '2021-06-28 06:14:43'),
	(20, 'Diego', '2021-06-28 06:44:29', '2021-06-28 06:14:43'),
	(21, 'Diego', '2021-06-28 06:44:29', '2021-06-28 06:45:45'),
	(22, 'Diego', '2021-06-28 12:37:49', '2021-06-28 06:45:45'),
	(23, 'Diego', '2021-06-28 12:47:37', '2021-06-28 06:45:45'),
	(24, 'Diego', '2021-06-28 12:48:31', '2021-06-28 06:45:45'),
	(25, 'Diego', '2021-06-28 12:52:44', '2021-06-28 06:45:45'),
	(26, 'Diego', '2021-06-28 12:53:16', '2021-06-28 06:45:45'),
	(27, 'Diego', '2021-06-28 12:53:16', '2021-06-28 12:53:27'),
	(28, 'Briset', '2021-06-28 16:25:03', '2021-06-28 05:38:39'),
	(29, 'Briset', '2021-06-28 16:25:03', '2021-06-28 16:25:09'),
	(30, 'Diego', '2021-06-28 16:25:17', '2021-06-28 12:53:27'),
	(31, 'Diego', '2021-06-28 16:25:17', '2021-06-28 16:25:19'),
	(32, 'Diego', '2021-06-28 16:56:18', '2021-06-28 16:25:19'),
	(33, 'Diego', '2021-06-28 16:56:18', '2021-06-28 16:56:32'),
	(34, 'Diego', '2021-06-28 16:57:08', '2021-06-28 16:56:32'),
	(35, 'Diego', '2021-06-28 16:57:40', '2021-06-28 16:56:32'),
	(36, 'Diego', '2021-06-28 16:58:15', '2021-06-28 16:56:32'),
	(37, 'Diego', '2021-06-28 16:58:45', '2021-06-28 16:56:32'),
	(38, 'Diego', '2021-06-28 17:18:50', '2021-06-28 16:56:32'),
	(39, 'Diego', '2021-06-28 17:18:50', '2021-06-28 17:19:42'),
	(40, 'Diego', '2021-06-29 18:33:35', '2021-06-28 17:19:42'),
	(41, 'Diego', '2021-06-29 22:19:46', '2021-06-28 17:19:42'),
	(42, 'Diego', '2021-06-29 22:19:46', '2021-06-29 22:23:39'),
	(43, 'Diego', '2021-06-29 22:25:08', '2021-06-29 22:23:39'),
	(44, 'Diego', '2021-06-29 22:25:08', '2021-06-29 22:25:28'),
	(45, 'Diego', '2021-06-29 22:26:02', '2021-06-29 22:25:28'),
	(46, 'Diego', '2021-06-29 22:26:39', '2021-06-29 22:25:28'),
	(47, 'Diego', '2021-06-29 22:26:39', '2021-06-29 22:26:50'),
	(48, 'Diego', '2021-06-29 22:26:39', '2021-06-29 22:26:53'),
	(49, 'Diego', '2021-06-29 22:27:09', '2021-06-29 22:26:53'),
	(50, 'Diego', '2021-06-29 22:27:09', '2021-06-29 22:27:32'),
	(51, 'Diego', '2021-06-30 12:27:02', '2021-06-29 22:27:32'),
	(52, 'Diego', '2021-06-30 12:27:02', '2021-06-30 12:27:23'),
	(53, 'Diego', '2021-06-30 13:04:53', '2021-06-30 12:27:23'),
	(54, 'Diego', '2021-06-30 13:04:53', '2021-06-30 13:05:29'),
	(55, 'Diego', '2021-06-30 14:17:38', '2021-06-30 13:05:29'),
	(56, 'Diego', '2021-06-30 14:18:02', '2021-06-30 13:05:29'),
	(57, 'Diego', '2021-06-30 14:18:58', '2021-06-30 13:05:29'),
	(58, 'Diego', '2021-06-30 14:18:58', '2021-06-30 14:19:18'),
	(59, 'Diego', '2021-06-30 14:22:54', '2021-06-30 14:19:18'),
	(60, 'Diego', '2021-06-30 14:22:54', '2021-06-30 14:23:10'),
	(61, 'Diego', '2021-06-30 14:24:45', '2021-06-30 14:23:10'),
	(62, 'Diego', '2021-06-30 14:24:45', '2021-06-30 14:24:58'),
	(63, 'Diego', '2021-06-30 14:38:12', '2021-06-30 14:24:58'),
	(64, 'Diego', '2021-06-30 14:38:12', '2021-06-30 14:38:42'),
	(65, 'Diego', '2021-06-30 14:42:06', '2021-06-30 14:38:42'),
	(66, 'Diegi', '2021-06-30 14:42:06', '2021-06-30 14:38:42'),
	(67, 'Diegi', '2021-06-30 14:42:06', '2021-06-30 14:42:52'),
	(68, 'Diegi', '2021-06-30 14:42:58', '2021-06-30 14:42:52'),
	(69, 'Diego', '2021-06-30 14:42:58', '2021-06-30 14:42:52'),
	(70, 'Diego', '2021-06-30 14:42:58', '2021-06-30 14:43:15'),
	(71, 'Diego', '2021-06-30 14:46:37', '2021-06-30 14:43:15'),
	(72, 'Diegi', '2021-06-30 14:46:37', '2021-06-30 14:43:15'),
	(73, 'Diego', '2021-06-30 14:46:37', '2021-06-30 14:43:15'),
	(74, 'Diego', '2021-06-30 14:46:37', '2021-06-30 14:43:15'),
	(75, 'Diego', '2021-06-30 14:46:37', '2021-06-30 14:48:10');
/*!40000 ALTER TABLE `bitacorasesion` ENABLE KEYS */;

-- Dumping structure for procedure bd_boticainv.probar
DELIMITER //
CREATE PROCEDURE `probar`()
BEGIN
select tb_templeado.descripcion_templ,COUNT(*) from tb_empleado join tb_templeado on tb_empleado.id_templ=tb_templeado.id_templ group BY 
tb_templeado.descripcion_templ;
END//
DELIMITER ;

-- Dumping structure for table bd_boticainv.tb_documento
CREATE TABLE IF NOT EXISTS `tb_documento` (
  `id_documento` int(100) NOT NULL AUTO_INCREMENT,
  `Descripcion_doc` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id_documento`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- Dumping data for table bd_boticainv.tb_documento: ~2 rows (approximately)
/*!40000 ALTER TABLE `tb_documento` DISABLE KEYS */;
INSERT INTO `tb_documento` (`id_documento`, `Descripcion_doc`) VALUES
	(1, 'FACTURA'),
	(2, 'BOLETA');
/*!40000 ALTER TABLE `tb_documento` ENABLE KEYS */;

-- Dumping structure for table bd_boticainv.tb_empleado
CREATE TABLE IF NOT EXISTS `tb_empleado` (
  `id_empl` int(100) NOT NULL AUTO_INCREMENT,
  `dni_empl` varchar(8) COLLATE utf8mb4_unicode_ci NOT NULL,
  `nombre_empl` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `apellidos_empl` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `sexo_empl` varchar(9) COLLATE utf8mb4_unicode_ci NOT NULL,
  `fnacimiento_empl` date NOT NULL,
  `direccion_empl` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `telefono_empl` varchar(9) COLLATE utf8mb4_unicode_ci NOT NULL,
  `id_templ` int(100) NOT NULL,
  `fingreso_empl` date NOT NULL,
  `contraseña_empl` varchar(12) COLLATE utf8mb4_unicode_ci NOT NULL,
  `estado_empl` int(11) NOT NULL,
  `fechaI` datetime DEFAULT NULL,
  `fechaS` datetime DEFAULT NULL,
  PRIMARY KEY (`id_empl`),
  UNIQUE KEY `dni_empl` (`dni_empl`),
  KEY `id_tem` (`id_templ`),
  CONSTRAINT `id_templ` FOREIGN KEY (`id_templ`) REFERENCES `tb_templeado` (`id_templ`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- Dumping data for table bd_boticainv.tb_empleado: ~3 rows (approximately)
/*!40000 ALTER TABLE `tb_empleado` DISABLE KEYS */;
INSERT INTO `tb_empleado` (`id_empl`, `dni_empl`, `nombre_empl`, `apellidos_empl`, `sexo_empl`, `fnacimiento_empl`, `direccion_empl`, `telefono_empl`, `id_templ`, `fingreso_empl`, `contraseña_empl`, `estado_empl`, `fechaI`, `fechaS`) VALUES
	(1, '73989527', 'Diego', 'Gorbeño Mamani', 'Masculino', '1998-06-06', 'Tacna A', '57136615', 1, '2021-06-11', '123', 1, '2021-06-30 14:46:37', '2021-06-30 14:48:10'),
	(2, '1234567', 'Briset', 'Garcia', 'Femenino', '2017-06-16', 'tacna', '45456', 2, '2021-06-07', '123', 1, '2021-06-28 16:25:03', '2021-06-28 16:25:09'),
	(3, '98765432', 'Luis', 'Flores', 'Masculino', '2002-06-14', 'tacna av', '795463123', 1, '2021-06-28', '123', 0, NULL, NULL);
/*!40000 ALTER TABLE `tb_empleado` ENABLE KEYS */;

-- Dumping structure for table bd_boticainv.tb_kardex
CREATE TABLE IF NOT EXISTS `tb_kardex` (
  `ntransaccion_kar` int(11) NOT NULL AUTO_INCREMENT,
  `operacion_kar` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `cantidad_kar` int(11) DEFAULT NULL,
  `fecha_kar` date DEFAULT NULL,
  `id_empl` int(100) DEFAULT NULL,
  `id_documento` int(100) DEFAULT NULL,
  `id_prov` int(100) DEFAULT NULL,
  `cbarras_prod` varchar(12) COLLATE utf8mb4_unicode_ci NOT NULL,
  `stock` int(11) DEFAULT NULL,
  PRIMARY KEY (`ntransaccion_kar`) USING BTREE,
  KEY `id_empl` (`id_empl`),
  KEY `id_documento` (`id_documento`),
  KEY `cbarras_prod` (`cbarras_prod`),
  KEY `id_prov` (`id_prov`),
  CONSTRAINT `cbarras_prod` FOREIGN KEY (`cbarras_prod`) REFERENCES `tb_producto` (`cbarras_prod`),
  CONSTRAINT `id_documento` FOREIGN KEY (`id_documento`) REFERENCES `tb_documento` (`id_documento`),
  CONSTRAINT `id_empl` FOREIGN KEY (`id_empl`) REFERENCES `tb_empleado` (`id_empl`),
  CONSTRAINT `id_prov` FOREIGN KEY (`id_prov`) REFERENCES `tb_proveedor` (`id_prov`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- Dumping data for table bd_boticainv.tb_kardex: ~10 rows (approximately)
/*!40000 ALTER TABLE `tb_kardex` DISABLE KEYS */;
INSERT INTO `tb_kardex` (`ntransaccion_kar`, `operacion_kar`, `cantidad_kar`, `fecha_kar`, `id_empl`, `id_documento`, `id_prov`, `cbarras_prod`, `stock`) VALUES
	(16, 'Entrada', 50, '2021-06-28', 1, 1, 2, '123456', 150),
	(17, 'Salida', 30, '2021-06-28', 1, 1, 2, '123456', 120),
	(18, 'Salida', 20, '2021-06-29', 1, 1, 2, '123456', 130),
	(19, 'Salida', 50, '2021-06-29', 1, 1, 2, '123456', 80),
	(20, 'Entrada', 10, '2021-06-28', 1, 1, 1, '1233', 100),
	(21, 'Salida', 30, '2021-06-28', 1, 1, 1, '1233', 70),
	(22, 'Entrada', 0, '2021-06-28', 1, 1, 1, '123456789', 200),
	(23, 'Salida', 40, '2021-06-28', 1, 1, 1, '123456789', 160),
	(24, 'Salida', 40, '2021-06-28', 1, 1, 1, '123456789', 160),
	(25, 'Entrada', 10, '2021-06-28', 1, 1, 1, '1233', 80);
/*!40000 ALTER TABLE `tb_kardex` ENABLE KEYS */;

-- Dumping structure for table bd_boticainv.tb_producto
CREATE TABLE IF NOT EXISTS `tb_producto` (
  `cbarras_prod` varchar(12) COLLATE utf8mb4_unicode_ci NOT NULL,
  `nombre_prod` varchar(25) COLLATE utf8mb4_unicode_ci NOT NULL,
  `ucajas_prod` int(11) NOT NULL DEFAULT 0,
  `id_unid` int(100) NOT NULL,
  `sminimo_prod` int(11) DEFAULT 0,
  `smaximo_prod` int(11) DEFAULT 0,
  `Stock` int(11) DEFAULT NULL,
  `estado_prod` int(11) NOT NULL DEFAULT 0,
  PRIMARY KEY (`cbarras_prod`),
  UNIQUE KEY `cbarras_prod` (`cbarras_prod`),
  KEY `id_uni` (`id_unid`),
  CONSTRAINT `id_unid` FOREIGN KEY (`id_unid`) REFERENCES `tb_unidad` (`id_unid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- Dumping data for table bd_boticainv.tb_producto: ~3 rows (approximately)
/*!40000 ALTER TABLE `tb_producto` DISABLE KEYS */;
INSERT INTO `tb_producto` (`cbarras_prod`, `nombre_prod`, `ucajas_prod`, `id_unid`, `sminimo_prod`, `smaximo_prod`, `Stock`, `estado_prod`) VALUES
	('1233', 'AMOXI C', 30, 1, 10, 150, 80, 1),
	('123456', 'ASPIRINA 100', 100, 1, 10, 150, 80, 1),
	('123456789', 'PARACETAMOL 500MG', 100, 2, 10, 200, 160, 1);
/*!40000 ALTER TABLE `tb_producto` ENABLE KEYS */;

-- Dumping structure for table bd_boticainv.tb_proveedor
CREATE TABLE IF NOT EXISTS `tb_proveedor` (
  `id_prov` int(100) NOT NULL AUTO_INCREMENT,
  `nombre_prov` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `ruc_prov` varchar(11) COLLATE utf8mb4_unicode_ci NOT NULL,
  `dni_prov` varchar(8) COLLATE utf8mb4_unicode_ci NOT NULL,
  `direccion_prov` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `celular_prov` varchar(9) COLLATE utf8mb4_unicode_ci NOT NULL,
  `email_prov` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `ncuenta_prov` varchar(16) COLLATE utf8mb4_unicode_ci NOT NULL,
  `estado_prov` int(11) NOT NULL DEFAULT 0,
  PRIMARY KEY (`id_prov`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- Dumping data for table bd_boticainv.tb_proveedor: ~1 rows (approximately)
/*!40000 ALTER TABLE `tb_proveedor` DISABLE KEYS */;
INSERT INTO `tb_proveedor` (`id_prov`, `nombre_prov`, `ruc_prov`, `dni_prov`, `direccion_prov`, `celular_prov`, `email_prov`, `ncuenta_prov`, `estado_prov`) VALUES
	(1, 'DIMEXA', '20602603356', '73899562', 'tacna', '922656568', 'dimexa@gmail.com', '123456789', 1),
	(2, 'ALFARO', '20612303344', '12345678', 'Lima d', '922956563', 'alfaro@hotmail.com', '123654987', 1);
/*!40000 ALTER TABLE `tb_proveedor` ENABLE KEYS */;

-- Dumping structure for table bd_boticainv.tb_templeado
CREATE TABLE IF NOT EXISTS `tb_templeado` (
  `id_templ` int(100) NOT NULL AUTO_INCREMENT,
  `descripcion_templ` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`id_templ`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- Dumping data for table bd_boticainv.tb_templeado: ~2 rows (approximately)
/*!40000 ALTER TABLE `tb_templeado` DISABLE KEYS */;
INSERT INTO `tb_templeado` (`id_templ`, `descripcion_templ`) VALUES
	(1, 'ADMINISTRADOR'),
	(2, 'TEC FARMACIA');
/*!40000 ALTER TABLE `tb_templeado` ENABLE KEYS */;

-- Dumping structure for table bd_boticainv.tb_unidad
CREATE TABLE IF NOT EXISTS `tb_unidad` (
  `id_unid` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion_unid` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`id_unid`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- Dumping data for table bd_boticainv.tb_unidad: ~3 rows (approximately)
/*!40000 ALTER TABLE `tb_unidad` DISABLE KEYS */;
INSERT INTO `tb_unidad` (`id_unid`, `descripcion_unid`) VALUES
	(1, 'CÁPSULA'),
	(2, 'TABLETA'),
	(3, 'FRASCO'),
	(4, 'AMPOLLA');
/*!40000 ALTER TABLE `tb_unidad` ENABLE KEYS */;

-- Dumping structure for procedure bd_boticainv.USP_B_BuscarEmpleado
DELIMITER //
CREATE PROCEDURE `USP_B_BuscarEmpleado`(
	IN `pdnie` VARCHAR(50)
)
BEGIN
SELECT * FROM tb_empleado WHERE tb_empleado.dni_empl=pdnie;
END//
DELIMITER ;

-- Dumping structure for procedure bd_boticainv.USP_B_BuscarProductoPorBarras
DELIMITER //
CREATE PROCEDURE `USP_B_BuscarProductoPorBarras`(
	IN `cbarras` VARCHAR(50)
)
BEGIN
SELECT tb_producto.cbarras_prod,tb_producto.nombre_prod,tb_producto.ucajas_prod,
tb_unidad.descripcion_unid,tb_producto.sminimo_prod,tb_producto.smaximo_prod,
tb_producto.Stock,tb_producto.estado_prod FROM tb_producto JOIN tb_unidad ON tb_producto.id_unid=tb_unidad.id_unid
WHERE cbarras_prod=cbarras AND estado_prod=1;
END//
DELIMITER ;

-- Dumping structure for procedure bd_boticainv.USP_I_AgregarEmpleado
DELIMITER //
CREATE PROCEDURE `USP_I_AgregarEmpleado`(
	IN `Pdniemp` VARCHAR(8),
	IN `Pnomepm` VARCHAR(50),
	IN `Papeemp` VARCHAR(50),
	IN `Psexemp` VARCHAR(9),
	IN `Pfnacemp` DATE,
	IN `Pdiremp` VARCHAR(50),
	IN `Ptelemp` VARCHAR(9),
	IN `Pidtemp` INT,
	IN `Pfingemp` DATE,
	IN `Pconemp` VARCHAR(50),
	IN `Pestemp` INT
)
BEGIN
INSERT INTO tb_empleado (dni_empl,nombre_empl,apellidos_empl,sexo_empl,fnacimiento_empl,direccion_empl,telefono_empl,id_templ,fingreso_empl,contraseña_empl,estado_empl)
VALUES (Pdniemp,Pnomepm,Papeemp,Psexemp,Pfnacemp,Pdiremp,Ptelemp,Pidtemp,Pfingemp,Pconemp,Pestemp);
END//
DELIMITER ;

-- Dumping structure for procedure bd_boticainv.USP_I_AgregarKardex
DELIMITER //
CREATE PROCEDURE `USP_I_AgregarKardex`(
	IN `poperacion` VARCHAR(50),
	IN `pcantidad` INT,
	IN `pfecha` DATE,
	IN `pempleado` INT,
	IN `pdocumento` INT,
	IN `pproveedor` INT,
	IN `pcbarras` VARCHAR(50),
	IN `pstock` INT
)
BEGIN
INSERT INTO tb_kardex (operacion_kar,cantidad_kar,fecha_kar,id_empl,id_documento,id_prov,cbarras_prod,stock) 
VALUES (poperacion,pcantidad,pfecha,pempleado,pdocumento,pproveedor,pcbarras,pstock);
END//
DELIMITER ;

-- Dumping structure for procedure bd_boticainv.USP_I_AgregarProducto
DELIMITER //
CREATE PROCEDURE `USP_I_AgregarProducto`(
	IN `Pcbarprod` VARCHAR(50),
	IN `Pnomprod` VARCHAR(50),
	IN `Pucajprod` INT,
	IN `Piduni` INT,
	IN `Psstock` INT,
	IN `Pestprod` INT
)
BEGIN
INSERT INTO tb_producto (cbarras_prod,nombre_prod,ucajas_prod,id_unid,Stock,estado_prod) VALUES (Pcbarprod,Pnomprod,Pucajprod,Piduni,Psstock,Pestprod);
END//
DELIMITER ;

-- Dumping structure for procedure bd_boticainv.USP_I_AgregarProveedor
DELIMITER //
CREATE PROCEDURE `USP_I_AgregarProveedor`(
	IN `Pnomprov` VARCHAR(100),
	IN `Prucprov` VARCHAR(11),
	IN `Pdniprov` VARCHAR(8),
	IN `Pdirprov` VARCHAR(50),
	IN `Pcelprov` VARCHAR(9),
	IN `Pemaprov` VARCHAR(50),
	IN `Pncueprov` VARCHAR(12),
	IN `Pestprov` VARCHAR(9)

)
BEGIN
INSERT INTO tb_proveedor (nombre_prov,ruc_prov,dni_prov,direccion_prov,celular_prov,email_prov,ncuenta_prov,estado_prov)
VALUES (Pnomprov,Prucprov,Pdniprov,Pdirprov,Pcelprov,Pemaprov,Pncueprov,Pestprov);
END//
DELIMITER ;

-- Dumping structure for procedure bd_boticainv.USP_I_AgregarUnidad
DELIMITER //
CREATE PROCEDURE `USP_I_AgregarUnidad`(
	IN `Pdescuni` VARCHAR(50)
)
BEGIN
INSERT INTO tb_unidad (descripcion_unid) VALUES (Pdescuni);
END//
DELIMITER ;

-- Dumping structure for procedure bd_boticainv.USP_RegistrarHoraIngreso
DELIMITER //
CREATE PROCEDURE `USP_RegistrarHoraIngreso`(
	IN `dn` VARCHAR(50),
	IN `fechin` DATETIME
)
BEGIN
UPDATE tb_empleado
SET
   tb_empleado.fechaI=fechin
   WHERE (tb_empleado.dni_empl=dn);
END//
DELIMITER ;

-- Dumping structure for procedure bd_boticainv.USP_RegistrarHoraSalida
DELIMITER //
CREATE PROCEDURE `USP_RegistrarHoraSalida`(
	IN `fechis` DATETIME,
	IN `dnii` VARCHAR(50)
)
BEGIN
UPDATE tb_empleado
SET
   tb_empleado.fechaS=fechis
   WHERE (tb_empleado.dni_empl=dnii);
END//
DELIMITER ;

-- Dumping structure for procedure bd_boticainv.USP_S_ListarEmpleados
DELIMITER //
CREATE PROCEDURE `USP_S_ListarEmpleados`()
BEGIN
SELECT * FROM tb_empleado;
END//
DELIMITER ;

-- Dumping structure for procedure bd_boticainv.USP_S_ListarKardex
DELIMITER //
CREATE PROCEDURE `USP_S_ListarKardex`()
BEGIN
SELECT * FROM tb_kardex;
END//
DELIMITER ;

-- Dumping structure for procedure bd_boticainv.USP_S_ListarKardexPorCodigo
DELIMITER //
CREATE PROCEDURE `USP_S_ListarKardexPorCodigo`(
	IN `Pbarra` VARCHAR(50)
)
BEGIN
SELECT k.ntransaccion_kar,k.operacion_kar,k.cantidad_kar,k.fecha_kar,k.id_empl,
tb_proveedor.nombre_prov,tb_documento.Descripcion_doc,k.stock FROM tb_kardex AS k JOIN tb_proveedor ON k.id_prov=tb_proveedor.id_prov 
JOIN tb_documento ON tb_documento.id_documento=k.id_documento 
WHERE cbarras_prod=Pbarra;
END//
DELIMITER ;

-- Dumping structure for procedure bd_boticainv.USP_S_ListarProducto
DELIMITER //
CREATE PROCEDURE `USP_S_ListarProducto`()
BEGIN
SELECT * FROM tb_producto;
END//
DELIMITER ;

-- Dumping structure for procedure bd_boticainv.USP_S_ListarProveedores
DELIMITER //
CREATE PROCEDURE `USP_S_ListarProveedores`()
BEGIN
SELECT * FROM tb_proveedor;
END//
DELIMITER ;

-- Dumping structure for procedure bd_boticainv.USP_S_ListarUnidad
DELIMITER //
CREATE PROCEDURE `USP_S_ListarUnidad`()
BEGIN
SELECT * FROM tb_unidad;
END//
DELIMITER ;

-- Dumping structure for procedure bd_boticainv.USP_S_Loguear
DELIMITER //
CREATE PROCEDURE `USP_S_Loguear`(
	IN `Dni` VARCHAR(50)
)
BEGIN
SELECT a.dni_empl,a.nombre_empl,a.apellidos_empl,a.estado_empl,a.contraseña_empl,a.estado_empl,t.descripcion_templ ,a.id_empl
FROM tb_empleado AS a INNER JOIN tb_templeado AS t ON a.id_templ=t.id_templ WHERE a.dni_empl=Dni;
END//
DELIMITER ;

-- Dumping structure for procedure bd_boticainv.USP_U_ActualizarEmpleado
DELIMITER //
CREATE PROCEDURE `USP_U_ActualizarEmpleado`(
	IN `Pdniemp` VARCHAR(8),
	IN `Pidemp` INT,
	IN `Pnomemp` VARCHAR(50),
	IN `Papelemp` VARCHAR(50),
	IN `Psexemp` VARCHAR(9),
	IN `Pfnacemp` VARCHAR(50),
	IN `Pdiremp` VARCHAR(50),
	IN `Ptelemp` VARCHAR(9),
	IN `Pidtemp` INT,
	IN `Pfingemp` DATE,
	IN `Pconemp` VARCHAR(12),
	IN `Pestemp` VARCHAR(9)
)
BEGIN
UPDATE tb_empleado
SET
	dni_empl=Pdniemp,
	nombre_empl=Pnomemp,
	apellidos_empl=Papelemp,
	sexo_empl=Psexemp,
	fnacimiento_empl=	Pfnacemp,
	direccion_empl=Pdiremp,
	telefono_empl=Ptelemp,
	id_templ=Pidtemp,
	fingreso_empl=Pfingemp,
	contraseña_empl=Pconemp,
	estado_empl=Pestemp
	WHERE (id_empl=Pidemp);
END//
DELIMITER ;

-- Dumping structure for procedure bd_boticainv.USP_U_ActualizarEmpleado2
DELIMITER //
CREATE PROCEDURE `USP_U_ActualizarEmpleado2`(
	IN `Pdniemp` VARCHAR(50),
	IN `Pnomemp` VARCHAR(50),
	IN `Papelemp` VARCHAR(50),
	IN `Psexemp` VARCHAR(50),
	IN `Pfnacemp` DATE,
	IN `Pdiremp` VARCHAR(50),
	IN `Ptelemp` VARCHAR(50),
	IN `Pconemp` VARCHAR(50)
)
BEGIN
UPDATE tb_empleado
SET
	nombre_empl=Pnomemp,
	apellidos_empl=Papelemp,
	sexo_empl=Psexemp,
	fnacimiento_empl=	Pfnacemp,
	direccion_empl=Pdiremp,
	telefono_empl=Ptelemp,
	contraseña_empl=Pconemp
	WHERE (dni_empl=Pdniemp);
END//
DELIMITER ;

-- Dumping structure for procedure bd_boticainv.USP_U_ActualizarKardex
DELIMITER //
CREATE PROCEDURE `USP_U_ActualizarKardex`(
	IN `Ptran` INT,
	IN `Pfecha` VARCHAR(50),
	IN `Pdoc` INT,
	IN `Pprov` INT
)
BEGIN
UPDATE tb_kardex
SET
	fecha_kar=Pfecha,
	id_documento=Pdoc,
	id_prov=Pprov
	WHERE ntransaccion_kar=Ptran;
END//
DELIMITER ;

-- Dumping structure for procedure bd_boticainv.USP_U_ActualizarProducto
DELIMITER //
CREATE PROCEDURE `USP_U_ActualizarProducto`(
	IN `Pcbarprod` VARCHAR(50),
	IN `Pnomprod` VARCHAR(50),
	IN `Pucajprod` INT,
	IN `Pidunid` INT,
	IN `Pstock` INT,
	IN `PestProd` INT
)
BEGIN
UPDATE tb_producto
SET
	nombre_prod=Pnomprod,
	ucajas_prod=Pucajprod,
	id_unid=Pidunid,
	Stock=Pstock,
	estado_prod=Pestprod
	WHERE cbarras_prod=Pcbarprod;

END//
DELIMITER ;

-- Dumping structure for procedure bd_boticainv.USP_U_ActualizarProveedor
DELIMITER //
CREATE PROCEDURE `USP_U_ActualizarProveedor`(
	IN `Pnomprov` VARCHAR(100),
	IN `Pidprov` INT,
	IN `Prucprov` VARCHAR(11),
	IN `Pdniprov` VARCHAR(8),
	IN `Pdirprov` VARCHAR(50),
	IN `Pcelprov` VARCHAR(9),
	IN `Pemaprov` VARCHAR(50),
	IN `Pncueprov` VARCHAR(12),
	IN `Pestprov` VARCHAR(9)
)
BEGIN
UPDATE tb_proveedor 
SET
	nombre_prov=Pnomprov,
	ruc_prov=Prucprov,
	dni_prov=Pdniprov,
	direccion_prov=Pdirprov,
	celular_prov=Pcelprov,
	email_prov=Pemaprov,
	ncuenta_prov=Pncueprov,
	estado_prov=Pestprov
	WHERE (id_prov=Pidprov);
END//
DELIMITER ;

-- Dumping structure for procedure bd_boticainv.USP_U_ActualizarStockMinMax
DELIMITER //
CREATE PROCEDURE `USP_U_ActualizarStockMinMax`(
	IN `Pmin` INT,
	IN `Pmax` INT,
	IN `Pcbarprod` VARCHAR(50),
	IN `pstock` INT
)
BEGIN
UPDATE tb_producto
SET
	sminimo_prod=Pmin,
	smaximo_prod=Pmax,
	Stock=pstock
	WHERE cbarras_prod=Pcbarprod;
END//
DELIMITER ;

-- Dumping structure for procedure bd_boticainv.USP_U_ActualizarUnidad
DELIMITER //
CREATE PROCEDURE `USP_U_ActualizarUnidad`(
	IN `Piduni` INT,
	IN `Pdescuni` VARCHAR(50)
)
BEGIN
UPDATE tb_unidad
SET
	descripcion_unid=Pdescuni
	WHERE (id_unid=Piduni);
END//
DELIMITER ;

-- Dumping structure for trigger bd_boticainv.Fechas
SET @OLDTMP_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_ZERO_IN_DATE,NO_ZERO_DATE,NO_ENGINE_SUBSTITUTION';
DELIMITER //
CREATE TRIGGER `Fechas` AFTER UPDATE ON `tb_empleado` FOR EACH ROW BEGIN
INSERT INTO bitacorasesion
(bitacorasesion.empleado,bitacorasesion.fechai,bitacorasesion.fechas)
VALUES(NEW.nombre_empl,
NEW.fechaI,
NEW.fechaS);
END//
DELIMITER ;
SET SQL_MODE=@OLDTMP_SQL_MODE;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
