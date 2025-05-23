package org.example.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbManager {
    private final String URI = "jdbc:mysql://localhost:3306/bankDB";
    private final String USER = "root";
    private final String PASSWORD = "formation";

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URI,USER,PASSWORD);
    }
}