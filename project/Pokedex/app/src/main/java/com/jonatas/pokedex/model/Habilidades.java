package com.jonatas.pokedex.model;

public class Habilidades {
    private String nome;
    private String descricao;

    public Habilidades(String nome) {
        this.nome = nome;
    }

    public Habilidades(String nome, String descricao) {
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
}
