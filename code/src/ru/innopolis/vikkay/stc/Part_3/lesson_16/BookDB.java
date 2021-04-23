package ru.innopolis.vikkay.stc.Part_3.lesson_16;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *  База данных booksDB
 *
 *  содержит таблицы: authors,
 *                      genre,
 *                      books.
 *
 *  @author Viktor Kochetkov
 *  @version 1.0 (20.04.2021)
 */
public class BookDB {

    private BookDB () {
    }


    public static void database(Connection connection) throws SQLException {

        try (Statement statement = connection.createStatement();
        ) {
            statement.execute("-- Database: booksDB\n"

                    // Создаем таблицу authors
                    + "CREATE TABLE authors (\n"
                    + "    id bigserial primary key,\n"
                    + "    author varchar(30) NOT NULL UNIQUE);"
                    + "\n"
                    + "INSERT INTO authors (author)\n"
                    + "VALUES\n"
                    + "   ('Достоевский Ф.М.'),\n"
                    + "   ('Булгаков М.А.'),\n"
                    + "   ('Пушкин А.С.'),\n"
                    + "   ('Конан Дойль А.'),\n"
                    + "   ('Лондон Д.'),\n"
                    + "   ('Кристи А.'),\n"
                    + "   ('Брэдбери Р.'),\n"
                    + "   ('Кэрролл Л.'),\n"
                    + "   ('Толстой Л.Н.');"
                    + "\n"

                    // Создаем таблицу genre
                    + "CREATE TABLE genre (\n"
                    + "    id bigserial primary key NOT NULL,\n"
                    + "    genre varchar(50) NOT NULL UNIQUE);"
                    + "\n"
                    + "INSERT INTO genre (genre)\n"
                    + "VALUES\n"
                    + "   ('Роман'),\n"
                    + "   ('Стихи'),\n"
                    + "   ('Детектив'),\n"
                    + "   ('Приключения'),\n"
                    + "   ('Фантастика'),\n"
                    + "   ('Сказки');"
                    + "\n"

                    // Создаем таблицу books
                    + "CREATE TABLE books (\n"
                    + "    id bigserial primary key,\n"
                    + "    author varchar(50) NOT NULL,\n"
                    + "    title varchar(100) NOT NULL,\n"
                    + "    genre varchar(30) NULL,\n"
                    + "    price decimal NOT NULL,\n"
                    + "    amount bigserial NOT NULL);"
                    + "\n"
                    + "INSERT INTO books (author, title, genre, price, amount)\n"
                    + "VALUES\n"
                    + "   ('Достоевский Ф.М.','Идиот', 'Роман', 360.81, 5350),\n"
                    + "   ('Булгаков М.А.','Мастер и Маргарита', 'Роман', 675.24, 4920),\n"
                    + "   ('Пушкин А.С.','Евгений Онегин', 'Роман', 700.15, 8412),\n"
                    + "   ('Пушкин А.С.','Стихи', 'Стихи', 525.55, 3400),\n"
                    + "   ('Конан Дойль А.','Собака Баскервилей', 'Детектив', 315.42, 7389),\n"
                    + "   ('Лондон Д.','Мартин Иден', 'Приключения', 517.14, 4981),\n"
                    + "   ('Кристи А.','Десять негритят', 'Детектив', 720.35, 7962),\n"
                    + "   ('Кристи А.','Рассказы', 'Детектив', 400.47, 2342),\n"
                    + "   ('Брэдбери Р.','Марсианские хроники', 'Фантастика', 645.52, 4812),\n"
                    + "   ('Кэрролл Л.','Алиса в стране чудес', 'Сказки', 521.80, 2052);"
                    + "\n"
            );
        }
    }
}
