package ru.innopolis.vikkay.stc.Part_3.lesson_16.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseDrop {

    public static void databaseDrop(Connection connection) throws SQLException {

        try (Statement statement = connection.createStatement();
        ) {
            statement.execute("-- Database: bookDB\n"

                    // Удалям таблицы из базы
                    + "DROP TABLE IF EXISTS authors CASCADE;" //Удаление таблицы в том случае, если она уже существует
                    + "DROP TABLE IF EXISTS genre CASCADE ;"
                    + "DROP TABLE IF EXISTS books;"
            );
        }
    }
}
