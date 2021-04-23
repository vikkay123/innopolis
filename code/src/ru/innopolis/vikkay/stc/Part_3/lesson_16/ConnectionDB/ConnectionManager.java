package ru.innopolis.vikkay.stc.Part_3.lesson_16.ConnectionDB;

import java.sql.Connection;
import java.sql.SQLException;

public interface ConnectionManager {
    public Connection getConnection() throws SQLException;
}
