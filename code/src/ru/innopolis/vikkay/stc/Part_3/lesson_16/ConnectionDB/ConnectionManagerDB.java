package ru.innopolis.vikkay.stc.Part_3.lesson_16.ConnectionDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *  Установка соединения с БД
 *  через паттерн Singleton
 *
 *  @author Viktor Kochetkov
 *  @version 1.0 (20.04.2021)
 */

public class ConnectionManagerDB implements ConnectionManager {

    // Pattern Singleton (ENUM)
    // Паттерн для однократного подключения к БД

    public enum ConnectionManager {

        INSTANCE;

        public ConnectionManagerDB ConnectionManagerDB() {
            return new ConnectionManagerDB();                 // возвращаем объект подключения к базе данных
        }
    }

    // Pattern Singleton (Double Checked Locking & volatile)
    /*
    private static volatile ConnectionManager INSTANCE = null;

    private ConnectionManagerDB() {
    }

    public static ConnectionManager getInstance() {

        ConnectionManager localInstance = INSTANCE;
        if (localInstance == null) {
            synchronized (ConnectionManagerDB.class) {
                localInstance = INSTANCE;
                if (localInstance == null) {
                    INSTANCE = localInstance = new ConnectionManagerDB();
                }
            }
        }
        return localInstance;
    }
*/

    @Override
    public Connection getConnection() throws SQLException {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5442/bookDB",
                    "postgres",
                    "qwerty");
        } catch (SQLException e) {
            e.printStackTrace();
            connection.close();
        }
        return connection;
    }
}