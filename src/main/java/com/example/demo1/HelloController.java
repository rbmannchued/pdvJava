package com.example.demo1;

import javafx.fxml.FXML;
import javafx.scene.control.Label;


import java.io.IOException;


public class HelloController {




    @FXML
    protected void onSairButtonClick(){
        System.exit(0);
    }
    @FXML
    protected void onSobreButtonClick() throws IOException {
        Sobre janelaSobre = new Sobre();

    }
    @FXML
    protected void onVerificadorButtonClick() throws IOException {
        new VerificadorPreco();
    }

    @FXML
    protected void onCaixaButtonClick() throws IOException {
        new Caixa();

    }
    @FXML
    protected void onAddProd() throws IOException{
        new AddProd();
    }


}