-- phpMyAdmin SQL Dump
-- version 4.0.5
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tiempo de generación: 09-10-2013 a las 07:15:19
-- Versión del servidor: 5.1.70-cll
-- Versión de PHP: 5.3.17

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `puertosu_andPorfolio`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `userInfo`
--

CREATE TABLE IF NOT EXISTS `userInfo` (
  `name` varchar(50) NOT NULL,
  `nick_name` varchar(50) NOT NULL,
  `normal_img` varchar(200) NOT NULL,
  `fun_img` varchar(200) NOT NULL,
  `quote` varchar(200) NOT NULL,
  `bio` text NOT NULL,
  `email` varchar(100) NOT NULL,
  `twitter` varchar(50) NOT NULL,
  `github` varchar(100) NOT NULL,
  `phone` varchar(50) NOT NULL,
  `url` varchar(200) NOT NULL,
  PRIMARY KEY (`name`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `userInfo`
--

INSERT INTO `userInfo` (`name`, `nick_name`, `normal_img`, `fun_img`, `quote`, `bio`, `email`, `twitter`, `github`, `phone`, `url`) VALUES
('Martin Haiek', 'Aragorn', 'url', 'url', 'I do not fear death.', '', 'matohaiek@gmail.com', '@martohaiek', 'haiek', '+54 (911) 35658282', 'www.puertosur.com.ar');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
         