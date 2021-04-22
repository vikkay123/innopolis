package ru.innopolis.vikkay.stc.Part_4.lesson_19.dao.WorkingWithDB;

import ru.innopolis.vikkay.stc.Part_4.lesson_19.ConnectionDB.ConnectionManagerDB;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Метод selectData для работы с БД
 *
 * метод selectData работает с таблицей books
 * осуществляет выборку данных из нее по цене
 * и выводит полученный результат в отсортированном по
 * убыванию цены виде
 *
 *   @author Viktor Kochetkov
 *   @version 1.0 (20.04.2021)
 *
 */


public class SelectData {

    private static final ConnectionManagerDB.ConnectionManager connectionManager =
            ConnectionManagerDB.ConnectionManager.INSTANCE;  // Сохраняем в переменную ссылку на интерфейс подключения

    public static void selectData() {
        try (Connection connection = connectionManager.ConnectionManagerDB().getConnection();
             Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery("SELECT * FROM books " +
                     "WHERE price < 700 AND price > 500" +
                     "ORDER BY price DESC;")) {
            while (rs.next()) {
                int id = rs.getInt("id");
                String author = rs.getString("author");
                String title = rs.getString("title");
                float price = rs.getFloat("price");
                System.out.println(String.format("id=%s %s | %s | %s руб.", id, author, title, price));
            }
            rs.close();
            statement.close();
            System.out.println();
            System.out.println("-- Operation SELECT done successfully");
            System.out.println("---------------------------------------");
        } catch (SQLException e) {
            System.out.println("Ошибка выполнения selectData()" + e.getMessage());
        }
    }
}
