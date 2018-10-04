-- phpMyAdmin SQL Dump
-- version 3.5.1
-- http://www.phpmyadmin.net
--
-- Хост: 127.0.0.1
-- Время создания: Окт 04 2018 г., 17:12
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
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=15 ;

--
-- Дамп данных таблицы `author`
--

INSERT INTO `author` (`id`, `name`, `surname`) VALUES
(1, 'Сергей', 'Лукьяненко'),
(2, 'Ник', 'Перумов'),
(6, 'Михаил', 'Королюк'),
(13, 'Артем', 'Каменистый'),
(14, 'Роберт', 'Джордан');

-- --------------------------------------------------------

--
-- Структура таблицы `book`
--

CREATE TABLE IF NOT EXISTS `book` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(70) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=28 ;

--
-- Дамп данных таблицы `book`
--

INSERT INTO `book` (`id`, `name`) VALUES
(1, 'Конкуренты'),
(2, 'Алмазный меч, Деревянный меч'),
(3, 'Лабиринт отражений'),
(4, 'Cпасти СССР'),
(11, 'Практикантка'),
(12, 'Самый странный нуб'),
(13, 'Рай беспощадный'),
(14, 'Око мира'),
(15, 'Великая охота'),
(16, 'Возражденный дракон'),
(17, 'Восходящая тень'),
(18, 'Огни небес'),
(19, 'Властелин хаоса'),
(20, 'Корона мечей'),
(21, 'Путь кинжалов'),
(22, 'Сердце зимы'),
(23, 'Перекрестки сумерек'),
(24, 'Нож сновидений'),
(25, 'Грядущая буря'),
(26, 'Башни полуночи'),
(27, 'Память света');

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
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=26 ;

--
-- Дамп данных таблицы `books_authors`
--

INSERT INTO `books_authors` (`id`, `idAuthor`, `idBook`) VALUES
(1, 1, 1),
(2, 2, 2),
(3, 1, 3),
(4, 6, 4),
(9, 13, 11),
(10, 13, 12),
(11, 13, 13),
(12, 14, 14),
(13, 14, 15),
(14, 14, 16),
(15, 14, 17),
(16, 14, 18),
(17, 14, 19),
(18, 14, 20),
(19, 14, 21),
(20, 14, 22),
(21, 14, 23),
(22, 14, 24),
(23, 14, 25),
(24, 14, 26),
(25, 14, 27);

--
-- Ограничения внешнего ключа сохраненных таблиц
--

--
-- Ограничения внешнего ключа таблицы `books_authors`
--
ALTER TABLE `books_authors`
  ADD CONSTRAINT `books_authors_ibfk_1` FOREIGN KEY (`idAuthor`) REFERENCES `author` (`id`),
  ADD CONSTRAINT `books_authors_ibfk_2` FOREIGN KEY (`idBook`) REFERENCES `book` (`id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
