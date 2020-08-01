package com.jonatas.pokedex.model;

import java.io.Serializable;

public class Habilidade implements Serializable {
    private String nome;
    private String descricao;

    public Habilidade(String nome) {
        this.nome = nome;
    }

    public Habilidade(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }


    @Override public String toString() {
        return "Habilidade: " + nome;
    }
}
