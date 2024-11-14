package com.example.demo1;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.IOException;

public class HelloController {
    @FXML
    private Label welcomeText;



    @FXML
    protected void onSairButtonClick(){
        System.exit(0);
    }
    @FXML
    protected void onSobreButtonClick() throws IOException {
        Sobre janelaSobre = new Sobre();

    }
    @FXML
    protected void onVerificarButtonClick(){

    }

    @FXML
    protected void onCaixaButtonClick() throws IOException {
        new Caixa();

    }
}