package com.example.demo1;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Caixa extends Stage {
    public Caixa() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("caixa-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 500);
        Stage stage = new Stage();
        stage.setTitle("Caixa");
        stage.setScene(scene);
        stage.show();
    }

}
