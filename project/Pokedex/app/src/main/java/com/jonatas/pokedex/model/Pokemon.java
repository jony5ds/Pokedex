package com.jonatas.pokedex.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Pokemon implements Serializable {
    private int codigo;
    private String nome;
    private int hp;
    private int ataque;
    private int defesa;
    private int velocidade;
    private List<Habilidades> habilidades;
    private List<Tipo> tipos = new ArrayList<>();
    private List<Sprite> sprites = new ArrayList<>();
    private List<String> evolucoes = new ArrayList<>();

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

    public int getVelocidade() {
        return velocidade;
    }

    public void setVelocidade(int velocidade) {
        this.velocidade = velocidade;
    }

    public List<Habilidades> getHabilidades() {
        return habilidades;
    }

    public void setHabilidades(List<Habilidades> habilidades) {
        this.habilidades = habilidades;
    }

    public List<Tipo> getTipos() {
        return tipos;
    }

    public void setTipos(List<Tipo> tipos) {
        this.tipos = tipos;
    }

    public List<Sprite> getSprites() {
        return sprites;
    }

    public void setSprites(List<Sprite> sprites) {
        this.sprites = sprites;
    }

    public List<String> getEvolucoes() {
        return evolucoes;
    }

    public void setEvolucoes(List<String> evolucoes) {
        this.evolucoes = evolucoes;
    }

    public Pokemon create()
    {
        evolucoes = new ArrayList<>();
        habilidades = new ArrayList<>();
        tipos = new ArrayList<>();
        this.ataque = 30;
        this.defesa = 10;
        this.evolucoes.add("Chaarlizard");
        this.evolucoes.add("Chaminer");
        this.hp = 100;

        return this;
    }
}
