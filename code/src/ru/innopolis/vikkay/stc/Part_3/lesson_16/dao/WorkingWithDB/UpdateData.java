package ru.innopolis.vikkay.stc.Part_3.lesson_16.dao.WorkingWithDB;

import ru.innopolis.vikkay.stc.Part_3.lesson_16.ConnectionDB.ConnectionManagerDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Метод updateData()
 * Обновляет данные в столбце price
 *
 * @author Viktor Kochetkov
 * @version 1.0 (20.04.2021)
 */
public class UpdateData {

    private static final ConnectionManagerDB.ConnectionManager connectionManager =
            ConnectionManagerDB.ConnectionManager.INSTANCE;

    public static void updateData() {

        try (Connection connection = connectionManager.ConnectionManagerDB().getConnection();
             PreparedStatement ps = connection.prepareStatement(
                     "UPDATE books set price = 550.20 where price < 400;")) {
            ps.executeUpdate();
            ps.close();
            System.out.println();
            System.out.println("-- Operation UPDATE done successfully");
            System.out.println("---------------------------------------");
        } catch (SQLException e) {
            System.out.println("Ошибка выполнения updateData()" + e.getMessage());
        }
    }

}
