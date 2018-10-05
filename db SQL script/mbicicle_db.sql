-- phpMyAdmin SQL Dump
-- version 3.5.1
-- http://www.phpmyadmin.net
--
-- Хост: 127.0.0.1
-- Время создания: Окт 05 2018 г., 21:40
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
  PRIMARY KEY (`id`),
  KEY `id` (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=6 ;

--
-- Дамп данных таблицы `author`
--

INSERT INTO `author` (`id`, `name`) VALUES
(2, 'Роберт Джордан'),
(3, 'Дмитрий Рус'),
(4, 'Сергей Шолохов'),
(5, 'Артем Каменистый');

-- --------------------------------------------------------

--
-- Структура таблицы `book`
--

CREATE TABLE IF NOT EXISTS `book` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(70) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id` (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=26 ;

--
-- Дамп данных таблицы `book`
--

INSERT INTO `book` (`id`, `name`) VALUES
(1, 'Око мира'),
(2, 'Великая охота'),
(3, 'Возражденный дракон'),
(4, 'Восходящая тень'),
(5, 'Огни небес'),
(6, 'Властелин хаоса'),
(7, 'Корона мечей'),
(8, 'Путь кинжалов'),
(9, 'Сердце зимы'),
(10, 'Перекрестки сумерек'),
(11, 'Нож сновидений'),
(12, 'Грядущая буря'),
(13, 'Башни полуночи'),
(14, 'Память света'),
(15, 'Долг'),
(16, 'Тихий дон'),
(17, 'Практикантка'),
(18, 'Рай беспощадный'),
(19, 'Самый странный нуб'),
(20, 'Срыв'),
(21, 'Клан'),
(22, 'Инферно'),
(23, 'Битва'),
(24, 'Война'),
(25, 'Исход');

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
(1, 2, 1),
(2, 2, 2),
(3, 2, 3),
(4, 2, 4),
(5, 2, 5),
(6, 2, 6),
(7, 2, 7),
(8, 2, 8),
(9, 2, 9),
(10, 2, 10),
(11, 2, 11),
(12, 2, 12),
(13, 2, 13),
(14, 2, 14),
(15, 3, 15),
(16, 4, 16),
(17, 5, 17),
(18, 5, 18),
(19, 5, 19),
(20, 3, 20),
(21, 3, 21),
(22, 3, 22),
(23, 3, 23),
(24, 3, 24),
(25, 3, 25);

--
-- Ограничения внешнего ключа сохраненных таблиц
--

--
-- Ограничения внешнего ключа таблицы `books_authors`
--
ALTER TABLE `books_authors`
  ADD CONSTRAINT `books_authors_ibfk_2` FOREIGN KEY (`idBook`) REFERENCES `book` (`id`),
  ADD CONSTRAINT `books_authors_ibfk_1` FOREIGN KEY (`idAuthor`) REFERENCES `author` (`id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
