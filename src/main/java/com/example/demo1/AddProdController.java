package com.example.demo1;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Comparator;
import java.util.ResourceBundle;

public class AddProdController implements Initializable {
    @FXML
    TextField tfNome, tfPreco, tfQuant;
    @FXML
    TableView<Produtos> tvProd;
    private ObservableList<Produtos> data = FXCollections.observableArrayList();;
    TableColumn<Produtos, Integer> colId = new TableColumn<>("ID");
    TableColumn<Produtos, String> colNome = new TableColumn<>("Nome");
    TableColumn<Produtos, Integer> colQuant = new TableColumn<>("Quant");
    TableColumn<Produtos, Double> colPreco = new TableColumn<>("Preço");



    protected void loadData() throws SQLException {
        data.clear();
        ResultSet rs = SQLiteConnection.getProd();
            while (rs.next()) {
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                double preco = rs.getDouble("preco");
                int quant = rs.getInt("quant");


                data.add(new Produtos(id,nome,quant,preco));
            }


    }



    protected void updateTabela() throws SQLException {

        loadData();
        tvProd.setItems(data);

    }
    @FXML
    protected void onAdd() throws SQLException {
        String nome = tfNome.getText();
        double preco = Double.parseDouble(tfPreco.getText());
        int quant = Integer.parseInt(tfQuant.getText());

        SQLiteConnection.insertProd(nome, quant, preco);
        updateTabela();


    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {

            colId.setCellValueFactory(cellData -> cellData.getValue().idProperty().asObject());
            colNome.setCellValueFactory(cellData -> cellData.getValue().nomeProperty());
            colQuant.setCellValueFactory(cellData -> cellData.getValue().quantProperty().asObject());
            colPreco.setCellValueFactory(cellData -> cellData.getValue().precoProperty().asObject());

            tvProd.getColumns().addAll(colId, colNome, colPreco, colQuant);
            tvProd.setItems(data);
            updateTabela();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
