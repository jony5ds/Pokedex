package com.jonatas.pokedex.model;

import java.util.List;

public class Pokemon {
    private int codigo;
    private String nome;
    private int hp;
    private int ataque;
    private int defesa;
    private List<String> habilidades;
    private List<String> tipos;
    private List<String> evolucoes;

    public Pokemon(int codigo, String nomePokemon) {
        this.codigo = codigo;
        this.nome = nomePokemon;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public String obterCodigo()
    {
        return String.valueOf(codigo);
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getAtaque() {
        return ataque;
    }

    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }

    public int getDefesa() {
        return defesa;
    }

    public void setDefesa(int defesa) {
        this.defesa = defesa;
    }

    public List<String> getHabilidades() {
        return habilidades;
    }

    public void setHabilidades(List<String> habilidades) {
        this.habilidades = habilidades;
    }

    public List<String> getTipos() {
        return tipos;
    }

    public void setTipos(List<String> tipos) {
        this.tipos = tipos;
    }

    public List<String> getEvolucoes() {
        return evolucoes;
    }

    public void setEvolucoes(List<String> evolucoes) {
        this.evolucoes = evolucoes;
    }
}
