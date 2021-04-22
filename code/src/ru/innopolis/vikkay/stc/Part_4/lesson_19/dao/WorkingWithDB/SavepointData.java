package ru.innopolis.vikkay.stc.Part_4.lesson_19.dao.WorkingWithDB;

import ru.innopolis.vikkay.stc.Part_4.lesson_19.ConnectionDB.ConnectionManagerDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Savepoint;

/**
 * Метод savepointData()
 * пакетная обработка запроса
 * Устанавливает точки savepoint
 * в случае ошибки откатывается к предыдущей savepoint
 *
 * @author Viktor Kochetkov
 * @version 1.0 (20.04.2021)
 */
public class SavepointData {

    private static final ConnectionManagerDB.ConnectionManager connectionManager =
            ConnectionManagerDB.ConnectionManager.INSTANCE;  // Сохраняем в переменную ссылку на интерфейс подключения

    public static void savepointData() throws SQLException {

        Connection connection = connectionManager.ConnectionManagerDB().getConnection();

        String author = "Толстой Л.Н.";
        String title = "Война и Мир";
        String genre = "Роман";
        double price = 450.26;
        int amount = 2500;

        final String sqlString = "INSERT INTO books "
                + "(author, title, genre, price, amount) VALUES (?,?,?,?,?)";

        Savepoint savepoint_I = null;
        Savepoint savepoint_II = null;
        Savepoint savepoint_III = null;
        Savepoint savepoint_IV;

        connection.setAutoCommit(false);
        //добавляем 1ю запись
        try (PreparedStatement stmt = connection.prepareStatement(sqlString)) {

            stmt.setString(1, author);
            stmt.setString(2, title + ". Том 1");
            stmt.setString(3, genre);
            stmt.setDouble(4, price);
            stmt.setInt(5, amount);
            stmt.executeUpdate();
            connection.commit();
            savepoint_I = connection.setSavepoint("savepoint_I");
        } catch (Exception e) {
            System.err.println("-- Operation Savepoint done nonsuccessfully");
            System.out.println("---------------------------------------\n");
        }
        //добавляем 2ю запись
        try (PreparedStatement stmt = connection.prepareStatement(sqlString)) {
            stmt.setString(1, author);
            stmt.setString(2, title + ". Том 2");
            stmt.setString(3, genre);
            stmt.setDouble(4, price);
            stmt.setInt(5, amount);
            stmt.executeUpdate();
            connection.commit();
            savepoint_II = connection.setSavepoint("savepoint_II");

        } catch (Exception e) {
            connection.rollback(savepoint_I);
            System.err.println("-- Operation Savepoint done nonsuccessfully");
            System.out.println("---------------------------------------");
        }
        //добавляем 3ю запись
        try (PreparedStatement stmt = connection.prepareStatement(sqlString)) {
            stmt.setString(1, author);
            stmt.setString(2, title + ". Том 3");
            stmt.setString(3, genre);
            stmt.setDouble(5, price);              // здесь ошибка! Том 3 не будет вставлен.
            stmt.setInt(5, amount);
            stmt.executeUpdate();
            connection.commit();
            savepoint_III = connection.setSavepoint("savepoint_III");
        } catch (Exception e) {
            connection.rollback(savepoint_II);
            System.err.println("-- Operation Savepoint done nonsuccessfully");
            System.out.println("---------------------------------------");
        }
        //добавляем 4ю запись
        try (PreparedStatement stmt = connection.prepareStatement(sqlString)) {
            stmt.setString(1, author);
            stmt.setString(2, title + ". Том 4");
            stmt.setString(3, genre);
            stmt.setDouble(4, price);
            stmt.setInt(5, amount);
            stmt.executeUpdate();
            connection.commit();

        } catch (Exception e) {
            connection.rollback(savepoint_III);
            connection.close();
            System.out.println(e.getMessage());
            System.err.println("-- Operation Savepoint done nonsuccessfully");
            System.out.println("---------------------------------------");
        }
    }
}
