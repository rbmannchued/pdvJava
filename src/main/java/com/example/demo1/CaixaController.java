package com.example.demo1;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.sql.ResultSet;
import java.sql.SQLException;


public class CaixaController {
    @FXML
    private Label lblDisplayProduto;
    @FXML
    private TextField tfId;
    @FXML
    private TextField tfQuant;
    @FXML
    private ListView lvProds;
    @FXML
    private Label lblTotal;
    @FXML
    private Label lblTroco;
    @FXML
    private TextField tfPago;

    private ResultSet rsAtual;
    private double total;
    private double troco;


    @FXML
    private void onIdTyped() throws SQLException {
        int id = Integer.parseInt(tfId.getText());
        rsAtual = SQLiteConnection.getProdById(id);
        if (!rsAtual.next()) {
            lblDisplayProduto.setText("Produto não encontrado!");
        } else {
            // Se encontrado, mostra o nome e o e-mail
            String nome = rsAtual.getString("nome");
            lblDisplayProduto.setText("Produto: " + nome);
            if(tfQuant.getText() == ""){
                tfQuant.setText("1");
            }
        }



    }
    @FXML
    private void onAddProd() throws SQLException {
        int id = Integer.parseInt(tfId.getText());
        rsAtual = SQLiteConnection.getProdById(id);
        if (!rsAtual.next()) {

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Produto não encontrado!");
            alert.setHeaderText(null);
            alert.setContentText("Produto não encontrado!");
            alert.showAndWait();

        } else {
            // Se encontrado, mostra o nome e o e-mail

            String nome = rsAtual.getString("nome");
            String preco = rsAtual.getString("preco");
            String quant = tfQuant.getText();
            double precoTotal = Double.parseDouble(preco) * Integer.parseInt(quant);
            total += precoTotal;

            lvProds.getItems().add("Nome: " + nome + " Quant: " + quant + " Preço Total: " + precoTotal);
            updateValues();


        }
        rsAtual.close();
    }
    private void updateValues(){

        lblTotal.setText(String.valueOf(total));
        if(tfPago.getText() != null) {
            double valorPago = Double.parseDouble(tfPago.getText());
            lblTroco.setText(String.valueOf(valorPago - total));
        }
    }
    @FXML
    private void onExcluir() throws SQLException{

        String selectedItem = (String) lvProds.getSelectionModel().getSelectedItem();
        String[] parts = selectedItem.split("Preço Total: ");
        double precoTotal = 0;
        if (parts.length > 1) {
            try {
                precoTotal = Double.parseDouble(parts[1].trim());
            } catch (NumberFormatException e) {
                System.out.println("Erro ao converter o preço.");
            }
        }
        if(lvProds.getSelectionModel().getSelectedItem() != null ){
            total -= precoTotal;
            lvProds.getItems().remove(lvProds.getSelectionModel().getSelectedItem());
            updateValues();
        }
        else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Produto não encontrado!");
            alert.setHeaderText(null);
            alert.setContentText("Selecione o Produto!");
            alert.showAndWait();

        }
    }
    @FXML
    private void onPagoTyped(){


        updateValues();

    }
}
