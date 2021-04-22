package ru.innopolis.vikkay.stc.Part_4.lesson_19.dao.WorkingWithDB;

import ru.innopolis.vikkay.stc.Part_4.lesson_19.ConnectionDB.ConnectionManagerDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Метод addBatch для рабооты с БД
 *
 * метод пакетной обработки запросов
 * помечает все строки с количеством книг для заказа
 * менее 1000 определенным маркером
 *
 * @author Viktor Kochetkov
 * @version 1.0 (20.04.2021)
 */

public class Batching {

    private static final ConnectionManagerDB.ConnectionManager connectionManager =
            ConnectionManagerDB.ConnectionManager.INSTANCE;  // Сохраняем в переменную ссылку на интерфейс подключения

    public static void addBatch() throws SQLException {

        Connection connection = connectionManager.ConnectionManagerDB().getConnection();
        Statement statement = connection.createStatement();

        String sql_order = "ALTER TABLE books ADD mark varchar(1);";
        statement.executeUpdate(sql_order);

        try (PreparedStatement stmt = connection.prepareStatement(
                "update books set mark='x' where orders < 1000 AND id = ?")) {

            for (int i = 1; i <= 10; i++) {
                stmt.setInt(1, i);
                stmt.addBatch();
            }
            stmt.executeBatch();
            stmt.close();
            System.out.println();
            System.out.println("-- Operation BATCH done successfully");
            System.out.println("---------------------------------------");
        }
        catch (Exception e){
            System.err.println("Ошибка выполнения addBatch()" + e.getMessage());
        }
    }
}
