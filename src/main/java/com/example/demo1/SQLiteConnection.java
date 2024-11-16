package com.example.demo1;

import java.sql.*;

public class SQLiteConnection {
    private static final String URL = "jdbc:sqlite:meu_banco.db";

    public static Connection connect() throws SQLException {
        return DriverManager.getConnection(URL);
    }

    public static void insertProd(String nome, int quant) throws SQLException {
        String sql = "INSERT INTO produtos(nome, quant) VALUES(?, ?)";

        try (Connection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, nome);
            pstmt.setInt(2, quant);
            pstmt.executeUpdate();
        }
    }

    public static ResultSet getUsers() throws SQLException {
        String sql = "SELECT * FROM produtos";
        Connection conn = connect();
        Statement stmt = conn.createStatement();
        return stmt.executeQuery(sql);
    }
}
