package com.example.demo1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {


        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600 , 600);
        scene.getStylesheets().add(getClass().getResource("/style.css").toExternalForm());
        stage.setTitle("Main");

        stage.setScene(scene);

        stage.show();
        try {
            // Conectar ao banco de dados (se o arquivo não existir, será criado)
            Connection conn = DriverManager.getConnection("jdbc:sqlite:meu_banco.db");
            Statement stmt = conn.createStatement();

            // Cria a tabela produtos
            String createTableSQL = "CREATE TABLE IF NOT EXISTS produtos (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "nome TEXT NOT NULL, " +
                    "quant INTEGER NOT NULL," +
                    "preco REAL NOT NULL);";
            stmt.execute(createTableSQL);
//            System.out.println("Tabela 'produtos' criada com sucesso!");

            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }




    }

    public static void main(String[] args) {
        launch();
    }
}