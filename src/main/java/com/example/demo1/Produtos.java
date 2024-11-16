package com.example.demo1;

import javafx.beans.property.*;

public class Produtos {
    private final IntegerProperty id;
    private final StringProperty nome;
    private final IntegerProperty quant;
    private final DoubleProperty preco;


    public Produtos(int id, String nome, int quant, double preco) {
        this.id = new SimpleIntegerProperty(id);
        this.nome = new SimpleStringProperty(nome);
        this.quant = new SimpleIntegerProperty(quant);
        this.preco = new SimpleDoubleProperty(preco);
    }

    // Getters e Setters
    public int getId() {
        return id.get();
    }

    public void setId(int id) {
        this.id.set(id);
    }

    public String getNome() {
        return nome.get();
    }

    public void setNome(String nome) {
        this.nome.set(nome);
    }

    public Integer getQuant() {
        return quant.get();
    }

    public void setQuant(int quant) {
        this.quant.set(quant);
    }

    // Propriedades para a TableView
    public IntegerProperty idProperty() {
        return id;
    }

    public StringProperty nomeProperty() {
        return nome;
    }

    public IntegerProperty quantProperty() {
        return quant;
    }
    public DoubleProperty precoProperty(){
        return preco;
    }
}
