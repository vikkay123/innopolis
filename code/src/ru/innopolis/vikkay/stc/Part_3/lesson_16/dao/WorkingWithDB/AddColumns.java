package ru.innopolis.vikkay.stc.Part_3.lesson_16.dao.WorkingWithDB;

import ru.innopolis.vikkay.stc.Part_3.lesson_16.ConnectionDB.ConnectionManagerDB;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *  Метод orderData для работы с БД
 *
 *  метод добавляет столбец orders
 *  куда заносится количество книг необходимое
 *  для заказа.
 *
 *   @author Viktor Kochetkov
 *   @version 1.0 (20.04.2021)
 */

public class AddColumns {

    private static final ConnectionManagerDB.ConnectionManager connectionManager =
            ConnectionManagerDB.ConnectionManager.INSTANCE;  // Сохраняем в переменную ссылку на интерфейс подключения

    public static void orderData() {

      try(Connection connection = connectionManager.ConnectionManagerDB().getConnection();
        Statement statement = connection.createStatement()){

        String sql_order = "ALTER TABLE books ADD orders integer;";                    // добавляем столбец
        String sql_add = "UPDATE books set orders = 8000-amount where amount < 8000;"; // заносим в него данные

        statement.executeUpdate(sql_order);
        statement.executeUpdate(sql_add);

        statement.close();
        System.out.println();
        System.out.println("-- Operation ORDER done successfully");
        System.out.println("---------------------------------------");
      }
      catch (SQLException e) {
          System.out.println("Ошибка выполнения orderData()" + e.getMessage());
      }
    }
}
