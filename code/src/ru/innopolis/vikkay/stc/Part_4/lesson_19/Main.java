package ru.innopolis.vikkay.stc.Part_4.lesson_19;


import ru.innopolis.vikkay.stc.Part_4.lesson_19.ConnectionDB.ConnectionManagerDB;
import ru.innopolis.vikkay.stc.Part_4.lesson_19.dao.BookDao;
import ru.innopolis.vikkay.stc.Part_4.lesson_19.dao.BookDaoJdbc;
import ru.innopolis.vikkay.stc.Part_4.lesson_19.pojo.Books;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static ru.innopolis.vikkay.stc.Part_4.lesson_19.dao.WorkingWithDB.AddColumns.orderData;
import static ru.innopolis.vikkay.stc.Part_4.lesson_19.dao.WorkingWithDB.Batching.addBatch;
import static ru.innopolis.vikkay.stc.Part_4.lesson_19.dao.WorkingWithDB.SavepointData.savepointData;
import static ru.innopolis.vikkay.stc.Part_4.lesson_19.dao.WorkingWithDB.SelectData.selectData;
import static ru.innopolis.vikkay.stc.Part_4.lesson_19.dao.WorkingWithDB.UpdateData.updateData;

/**
 * Задание 1. Взять за основу предметную область выбранную на занятии по UML:
 *
 * Спроектировать базу данных для выбранной предметной области (минимум три таблицы).
 * Типы и состав полей в таблицах на ваше усмотрение.
 * Связи между таблицами делать не обязательно.
 *
 * Задание 2. Через JDBC интерфейс описать CRUD операции с созданными таблицами:
 *
 * Применить параметризованный запрос.
 * Применить батчинг.
 * Использовать ручное управление транзакциями.
 * Предусмотреть использование savepoint при выполнении логики из нескольких запросов.
 * Предусмотреть rollback операций при ошибках.
 * Желательно предусмотреть метод сброса и инициализации базы данных.
 *
 * @author Viktor Kochetkov
 * @version 1.0 (20.04.2021)
 */

public class Main {
    public static void main(String[] args) throws SQLException {

        BookDao bookDao = new BookDaoJdbc();        // Подключаем управление БД

        ConnectionManagerDB.ConnectionManager connectionManager =
                ConnectionManagerDB.ConnectionManager.INSTANCE; // Подключаемся к БД

        try (Statement statement = connectionManager.ConnectionManagerDB()
                .getConnection().createStatement(); // Создание объекта для передачи запросов

             ResultSet resultSetBooks = statement.executeQuery("SELECT * FROM books")) // Выполнение запроса
         {

            // Выводим данные из таблицы books
            System.out.println("Таблица 1. Книги");
            while (resultSetBooks.next()) {
                System.out.print("id = " + resultSetBooks.getInt("id") + ";   ");

                System.out.print(resultSetBooks.getString("author") + ";  | ");
                System.out.print(resultSetBooks.getString("title") + ";  | ");
                System.out.print(resultSetBooks.getString("genre") + ";  | ");
                System.out.print(resultSetBooks.getFloat("price") + ";  | ");
                System.out.println(resultSetBooks.getInt("amount") + ";  | ");
            }
            System.out.println();

            // Выводим данные из таблицы authors
            System.out.println("Таблица 2. Авторы");

            ResultSet resultSetAuthors = statement.executeQuery("SELECT * FROM authors");
            while (resultSetAuthors.next()) {
                System.out.print("id = " + resultSetAuthors.getInt("id") + ";   ");
                System.out.println(" author = " + resultSetAuthors.getString("author") + ";   ");
            }
            System.out.println();

            // Выводим данные из таблицы genre
            System.out.println("Таблица 3. Жанр");

            ResultSet resultSetGenre = statement.executeQuery("SELECT * FROM genre");
            while (resultSetGenre.next()) {
                System.out.print("id = " + resultSetGenre.getInt("id") + ";   ");
                System.out.println(" genre = " + resultSetGenre.getString("genre") + ";   ");
            }
            resultSetAuthors.close();
            resultSetGenre.close();
            System.out.println();

            // Работа с БД

            // Создаём новую запись в БД
            String author = "Чехов А.П.";
            String title = "Палата №6";
            String genre = "Повесть";
            double price = 480.31;
            int amount = 1830;

            Books book = new Books(null, author, title, genre, price, amount);
            Long id = bookDao.addBook(book); // добавляем книгу в табл. books получаем ее id
            book = bookDao.getBookById(id);
            bookDao.addAuthor(book);        // добавляем автора в табл. authors
            bookDao.addGenre(book);        // добавляем жанр в табл. genre

            System.out.println("Добавлена запись: \n" + book);


            updateData();  // изменяем данные в столбце price

            selectData();  // выборка данных по цене

            orderData();   // добавляем столбец orders

            addBatch();    // пакетная обработка запросов

            savepointData(); // savepoint и rollback при выполнении нескольких запросов
        }

    }
}