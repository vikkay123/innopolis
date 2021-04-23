package ru.innopolis.vikkay.stc.Part_3.lesson_16.dao;

import ru.innopolis.vikkay.stc.Part_3.lesson_16.pojo.Books;

/**
 * Интерфейс BookDao
 * Описывает методы для работы с БД
 *
 * @author Viktor Kochetkov
 * @version 1.0 (20.04.2021)
 */

public interface BookDao {

    Long addBook(Books book);

    Books getBookById(Long id);

    void addAuthor(Books book);

    void addGenre(Books book);

}
