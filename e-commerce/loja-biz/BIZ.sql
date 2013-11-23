-- phpMyAdmin SQL Dump
-- version 4.0.4.1
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tempo de Geração: 23/11/2013 às 18:43
-- Versão do servidor: 5.6.12
-- Versão do PHP: 5.5.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Banco de dados: `MinhaLoja`
--
CREATE DATABASE IF NOT EXISTS `MinhaLoja` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `MinhaLoja`;

-- --------------------------------------------------------

--
-- Estrutura para tabela `produtos`
--

CREATE TABLE IF NOT EXISTS `produtos` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `descricao` varchar(100) NOT NULL,
  `imagem` varchar(150) NOT NULL,
  `preco` double NOT NULL,
  `sexo` enum('M','F') NOT NULL DEFAULT 'M',
  `idade` enum('C','J','A') NOT NULL,
  `marca` varchar(100) NOT NULL,
  `obs` varchar(200) NOT NULL,
  `pagamento` varchar(200) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=8 ;

--
-- Fazendo dump de dados para tabela `produtos`
--

INSERT INTO `produtos` (`id`, `descricao`, `imagem`, `preco`, `sexo`, `idade`, `marca`, `obs`, `pagamento`) VALUES
(1, 'Bengala Inox', 'bengala.jpg', 50, 'M', 'A', 'Duramais', '', 'A vista'),
(2, 'Chapa', 'protese.jpg', 75, 'F', 'A', 'semDente Ltda', '32 dentes', '2x sem juros'),
(3, 'Computador do bom', 'computador.jpg', 1000, 'M', 'J', 'CCE', '- 2Gb memória, 500Gb HD, Windows 8', '10x com juros'),
(4, 'Vestido de marca', 'vestido.jpg', 500, 'F', 'J', 'de Marca', '', '4x sem juros'),
(5, 'Bolsa do Ben 10', 'bolsa.jpg', 34, 'M', 'C', 'Caruaru', '', '2x com juros'),
(6, 'Boneca cabeça de melancia', 'boneca.jpg', 20, 'F', 'C', 'Estrela', '', '6x sem juros'),
(7, 'Mola Maluca', 'Molamaluca.jpg', 15, 'F', 'C', 'Das antigas', '', 'A vista');

-- --------------------------------------------------------

--
-- Estrutura para tabela `usuarios`
--

CREATE TABLE IF NOT EXISTS `usuarios` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  `sexo` enum('M','F') NOT NULL DEFAULT 'M',
  `idade` enum('C','J','A') NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=4 ;

--
-- Fazendo dump de dados para tabela `usuarios`
--

INSERT INTO `usuarios` (`id`, `nome`, `email`, `password`, `sexo`, `idade`) VALUES
(1, 'Ely', 'elymoral@hotmail.com', '123', 'M', 'J'),
(2, 'teste', 'teste@teste.com', 'teste', 'F', 'C'),
(3, 'asd', 'asd@asd.com', 'asd', 'F', 'A');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
