-- phpMyAdmin SQL Dump
-- version 3.5.1
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tiempo de generación: 25-05-2020 a las 22:34:11
-- Versión del servidor: 5.5.24-log
-- Versión de PHP: 5.4.3

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `tarjetas`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cuentas`
--

CREATE TABLE IF NOT EXISTS `cuentas` (
  `número` int(10) NOT NULL,
  `titular1` varchar(9) NOT NULL,
  `titular2` varchar(9) NOT NULL,
  `titular3` varchar(9) NOT NULL,
  `saldo` double NOT NULL,
  `fecha` date NOT NULL,
  PRIMARY KEY (`número`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `cuentas`
--

INSERT INTO `cuentas` (`número`, `titular1`, `titular2`, `titular3`, `saldo`, `fecha`) VALUES
(1111111111, '97191542M', '0', '0', -900, '2018-05-14'),
(1111111112, '39086600D', '0', '0', 3400, '2018-05-02'),
(1111111113, '46149981K', '99344584V', '48719554B', 870, '2018-04-26'),
(1212121212, '99227030Q', '97191542M', '0', 580, '2018-05-02');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `movimientos`
--

CREATE TABLE IF NOT EXISTS `movimientos` (
  `numero` int(11) NOT NULL AUTO_INCREMENT,
  `tarjeta` int(4) NOT NULL,
  `cargado` tinyint(1) NOT NULL DEFAULT '0',
  `importe` double NOT NULL,
  `fecha` date NOT NULL,
  PRIMARY KEY (`numero`),
  KEY `tarjeta` (`tarjeta`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=6 ;

--
-- Volcado de datos para la tabla `movimientos`
--

INSERT INTO `movimientos` (`numero`, `tarjeta`, `cargado`, `importe`, `fecha`) VALUES
(1, 1111, 0, 100, '2020-05-24'),
(2, 1111, 1, 200, '2020-05-05'),
(3, 1234, 0, 300, '2020-05-12'),
(4, 1111, 0, 100, '2020-05-11'),
(5, 1234, 1, 20, '2020-05-11');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tarjetas`
--

CREATE TABLE IF NOT EXISTS `tarjetas` (
  `numero` int(4) NOT NULL,
  `cuenta` int(10) NOT NULL,
  `titular` varchar(20) NOT NULL,
  `limite` double NOT NULL DEFAULT '0',
  `tipo` varchar(1) NOT NULL,
  `caducidad` date NOT NULL,
  `clave` varchar(4) NOT NULL,
  `bloqueada` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`numero`),
  KEY `cuenta` (`cuenta`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `tarjetas`
--

INSERT INTO `tarjetas` (`numero`, `cuenta`, `titular`, `limite`, `tipo`, `caducidad`, `clave`, `bloqueada`) VALUES
(1111, 1111111111, 'Belen Gómez', 600, 'C', '2020-06-21', '9999', 0),
(1234, 1212121212, 'Juan Sanz', 0, 'D', '2020-09-18', '8888', 0),
(2222, 1111111113, 'Pedro Bello', 1000, 'C', '2020-06-18', '7777', 0),
(3333, 1111111111, 'Antonio Galán', 300, 'C', '2020-05-19', '6666', 0),
(3425, 1111111113, 'Penélope Glamour', 300, 'C', '2020-05-25', '2222', 0);

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `movimientos`
--
ALTER TABLE `movimientos`
  ADD CONSTRAINT `movimientos_ibfk_2` FOREIGN KEY (`tarjeta`) REFERENCES `tarjetas` (`numero`);

--
-- Filtros para la tabla `tarjetas`
--
ALTER TABLE `tarjetas`
  ADD CONSTRAINT `tarjetas_ibfk_1` FOREIGN KEY (`cuenta`) REFERENCES `cuentas` (`número`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
