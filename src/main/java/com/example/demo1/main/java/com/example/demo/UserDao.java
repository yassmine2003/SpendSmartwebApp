package com.example.demo;

import java.sql.*;

public class UserDao {
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new IllegalStateException("Failed to load MySQL JDBC driver", e);
        }
    }
        private static final String SELECT_USER_SQL = "SELECT * FROM utilisateur WHERE username = ? AND password = ?";

        public boolean isValidUser(String username, String password) throws SQLException {
            try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/spendsmart", "root", "salma");
                 PreparedStatement statement = connection.prepareStatement(SELECT_USER_SQL)) {
                statement.setString(1, username);
                statement.setString(2, password);
                try (ResultSet rs = statement.executeQuery()) {
                    return rs.next();
                }
            }
        }
    }


