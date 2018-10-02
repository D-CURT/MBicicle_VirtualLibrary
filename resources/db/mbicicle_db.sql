-- phpMyAdmin SQL Dump
-- version 3.5.1
-- http://www.phpmyadmin.net
--
-- Хост: 127.0.0.1
-- Время создания: Окт 02 2018 г., 14:20
-- Версия сервера: 5.5.25
-- Версия PHP: 5.3.13

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- База данных: `mbicicle_db`
--

-- --------------------------------------------------------

--
-- Структура таблицы `author`
--

CREATE TABLE IF NOT EXISTS `author` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `surname` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=3 ;

--
-- Дамп данных таблицы `author`
--

INSERT INTO `author` (`id`, `name`, `surname`) VALUES
(1, 'Сергей', 'Лукьяненко'),
(2, 'Ник', 'Перумов');

-- --------------------------------------------------------

--
-- Структура таблицы `book`
--

CREATE TABLE IF NOT EXISTS `book` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(70) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=3 ;

--
-- Дамп данных таблицы `book`
--

INSERT INTO `book` (`id`, `name`) VALUES
(1, 'Конкуренты'),
(2, 'Алмазный меч, Деревянный меч');

-- --------------------------------------------------------

--
-- Структура таблицы `books_authors`
--

CREATE TABLE IF NOT EXISTS `books_authors` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `idAuthor` int(11) NOT NULL,
  `idBook` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `idAuthor` (`idAuthor`),
  KEY `idBook` (`idBook`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=3 ;

--
-- Дамп данных таблицы `books_authors`
--

INSERT INTO `books_authors` (`id`, `idAuthor`, `idBook`) VALUES
(1, 1, 1),
(2, 2, 2);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
