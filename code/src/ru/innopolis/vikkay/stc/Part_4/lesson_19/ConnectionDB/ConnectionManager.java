package ru.innopolis.vikkay.stc.Part_4.lesson_19.ConnectionDB;

import java.sql.Connection;
import java.sql.SQLException;

public interface ConnectionManager {
    public Connection getConnection() throws SQLException;
}
