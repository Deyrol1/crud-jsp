-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 29-10-2022 a las 05:05:21
-- Versión del servidor: 10.4.24-MariaDB
-- Versión de PHP: 7.4.29

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `jsp`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `categoriahabitacion`
--

CREATE TABLE `categoriahabitacion` (
  `id` int(11) NOT NULL,
  `categoria` varchar(50) NOT NULL,
  `valor` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `categoriahabitacion`
--

INSERT INTO `categoriahabitacion` (`id`, `categoria`, `valor`) VALUES
(1, 'Simple', 20000),
(2, 'Doble', 40000),
(3, 'Suite', 100000);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `habitacion`
--

CREATE TABLE `habitacion` (
  `id` int(11) NOT NULL,
  `tipo` varchar(50) NOT NULL,
  `nro` int(11) NOT NULL,
  `precio` int(11) NOT NULL,
  `estado` varchar(50) NOT NULL DEFAULT '"Disponible"'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `habitacion`
--

INSERT INTO `habitacion` (`id`, `tipo`, `nro`, `precio`, `estado`) VALUES
(121, 'Doble', 99, 40000, 'Ocupado'),
(1234, 'Doble', 334, 40000, 'Disponible'),
(1724, 'Doble', 127641, 40000, 'Disponible');

--
-- Disparadores `habitacion`
--
DELIMITER $$
CREATE TRIGGER `insertar` BEFORE INSERT ON `habitacion` FOR EACH ROW BEGIN
set @tipo= new.tipo;
set @resultado=(select valor from categoriahabitacion where categoria=@tipo);
set new.precio=@resultado;
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `reserva`
--

CREATE TABLE `reserva` (
  `id` int(11) NOT NULL,
  `fecha_inicio` date NOT NULL,
  `fecha_fin` date NOT NULL,
  `nombre_cliente` varchar(100) NOT NULL,
  `tipo_habitacion` varchar(100) NOT NULL,
  `num_habitacion` int(11) NOT NULL,
  `dias` int(11) NOT NULL,
  `valor_total` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `cedula` int(11) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `cargo` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`cedula`, `nombre`, `cargo`) VALUES
(3629, 'Asdg', 'Admin'),
(121687, 'Mauel', 'Admin'),
(398263962, 'Luisito', 'Admin');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `categoriahabitacion`
--
ALTER TABLE `categoriahabitacion`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `habitacion`
--
ALTER TABLE `habitacion`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `reserva`
--
ALTER TABLE `reserva`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`cedula`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
