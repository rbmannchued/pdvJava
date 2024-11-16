package com.example.demo1;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.sql.ResultSet;
import java.sql.SQLException;

public class VerificadorPrecoController {
    @FXML
    private TextField tfId;
    @FXML
    private Label lblDesc;
    @FXML
    private Label lblValor;
    private ResultSet rsAtual;
    @FXML
    private void onIdTyped() throws SQLException {
            int id = Integer.parseInt(tfId.getText());
            rsAtual = SQLiteConnection.getProdById(id);
            if (!rsAtual.next()) {
                lblDesc.setText("Produto não encontrado!");
                lblValor.setText("");
            } else {
                // Se encontrado, mostra o nome e o e-mail
                String nome = rsAtual.getString("nome");
                double preco = rsAtual.getDouble("preco");
                lblValor.setText(String.valueOf(preco));
                lblDesc.setText(nome);

            }
        }

}
