package ru.innopolis.vikkay.stc.Part_4.lesson_19.dao;

import ru.innopolis.vikkay.stc.Part_4.lesson_19.BookDB;
import ru.innopolis.vikkay.stc.Part_4.lesson_19.ConnectionDB.ConnectionManagerDB;
import ru.innopolis.vikkay.stc.Part_4.lesson_19.pojo.Books;

import java.sql.*;

/**
 *  Класс BookDaoJdbc
 *
 *  Содержит методы для работы с БД
 *  addAuthor() - добавляет автора в табл. authors
 *  addGenre() - добавляет жанр в табл. genre
 *  addBook() - добавляет книгу в табл. books
 *
 *  @author Viktor Kochetkov
 *  @version 1.0 (20.04.2021)
 */

public class BookDaoJdbc implements BookDao {

    private static final ConnectionManagerDB.ConnectionManager connectionManager =
            ConnectionManagerDB.ConnectionManager.INSTANCE;  // Создаем переменную для подключения к БД

    static {

        try {
            Connection connectDB = connectionManager.ConnectionManagerDB().getConnection();
            DatabaseDrop.databaseDrop(connectDB);  // Сброс БД
            BookDB.database(connectDB);            // Подключаемся к БД

        } catch (SQLException throwables) {
            System.err.println("Ошибка подключения к БД");
        }
    }
    @Override
    public void addAuthor(Books name) {  // добавляет автора в табл. authors

        try (Connection connection = connectionManager.ConnectionManagerDB().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "INSERT INTO authors values (DEFAULT, ?) ON CONFLICT DO NOTHING ")) {
            try {
                preparedStatement.setString(1, name.getAuthor());
                preparedStatement.executeUpdate();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    @Override
    public void addGenre(Books genre) {  // добавляет жанр в табл. genre
        try (Connection connection = connectionManager.ConnectionManagerDB().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "INSERT INTO genre values (DEFAULT, ?) ON CONFLICT DO NOTHING ")) {
            try {
                preparedStatement.setString(1, genre.getGenre());
                preparedStatement.executeUpdate();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public Long addBook(Books book) {  // добавляет книгу в табл. books
        try (Connection connection = connectionManager.ConnectionManagerDB().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "INSERT INTO books values (DEFAULT, ?, ?, ?, ?, ?) ON CONFLICT DO NOTHING ", Statement.RETURN_GENERATED_KEYS)) {

            preparedStatement.setString(1, book.getAuthor());
            preparedStatement.setString(2, book.getTitle());
            preparedStatement.setString(3, book.getGenre());
            preparedStatement.setDouble(4, book.getPrice());
            preparedStatement.setInt(5, book.getAmount());
            preparedStatement.executeUpdate();

            try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    return generatedKeys.getLong(1);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0L;
    }

    @Override
    public Books getBookById(Long id) {  // Создаем новую книгу по id
        try (Connection connection = connectionManager.ConnectionManagerDB().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "SELECT * FROM books WHERE id = ?")) {
            preparedStatement.setLong(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return new Books(
                            resultSet.getInt(1),
                            resultSet.getString(2),
                            resultSet.getString(3),
                            resultSet.getString(4),
                            resultSet.getDouble(5),
                            resultSet.getInt(6)
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
