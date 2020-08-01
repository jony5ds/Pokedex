package com.jonatas.pokedex.model;

import java.io.Serializable;

public class Tipo implements Serializable {
    private String nome;

    public Tipo(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


    @Override public String toString() {
        return "Tipo: " + nome;
    }
}

