package com.example.demo1;

import java.sql.*;

public class SQLiteConnection {
    private static final String URL = "jdbc:sqlite:meu_banco.db";

    public static Connection connect() throws SQLException {
        return DriverManager.getConnection(URL);
    }

    public static void insertProd(String nome, int quant, double preco) throws SQLException {
        String sql = "INSERT INTO produtos(nome, quant, preco) VALUES(?, ?, ?)";

        try (Connection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, nome);
            pstmt.setInt(2, quant);
            pstmt.setDouble(3, preco);

            pstmt.executeUpdate();
        }
    }

    public static ResultSet getProd() throws SQLException {
        String sql = "SELECT * FROM produtos ORDER BY id DESC";
        Connection conn = connect();
        Statement stmt = conn.createStatement();
        return stmt.executeQuery(sql);
    }
    public static ResultSet getProdById(int id) throws SQLException {
        String sql = "SELECT * FROM produtos WHERE id = ?";

        Connection conn = connect();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, id);

        return pstmt.executeQuery();
    }
}
