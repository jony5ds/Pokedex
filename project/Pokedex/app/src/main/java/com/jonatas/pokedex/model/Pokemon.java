package com.jonatas.pokedex.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Pokemon implements Serializable {
    @SerializedName("id")
    private int codigo;
    @SerializedName("name")
    private String nome;
    @SerializedName("hp")
    private int hp;
    @SerializedName("attack")
    private int ataque;
    @SerializedName("defense")
    private int defesa;
    @SerializedName("speed")
    private int velocidade;
    @SerializedName("special-attack")
    private int ataqueEspecial;
    @SerializedName("special-defense")
    private int defesaEspecial;
    @SerializedName("abilities")
    private List<Habilidade> habilidades = new ArrayList<>();
    @SerializedName("types")
    private List<Tipo> tipos = new ArrayList<>();
    @SerializedName("sprites")
    private List<Sprite> sprites = new ArrayList<>();
    @SerializedName("species")
    private List<Evolucao> evolucoes = new ArrayList<>();

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

    public int getAtaqueEspecial() {
        return ataqueEspecial;
    }

    public void setAtaqueEspecial(int ataqueEspecial) {
        this.ataqueEspecial = ataqueEspecial;
    }

    public int getDefesaEspecial() {
        return defesaEspecial;
    }

    public void setDefesaEspecial(int defesaEspecial) {
        this.defesaEspecial = defesaEspecial;
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

    public List<Habilidade> getHabilidades() {
        return habilidades;
    }

    public void setHabilidades(List<Habilidade> habilidades) {
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

    public List<Evolucao> getEvolucoes() {
        return evolucoes;
    }

    public void setEvolucoes(List<Evolucao> evolucoes) {
        this.evolucoes = evolucoes;
    }

    public Pokemon create()
    {
        evolucoes = new ArrayList<>();
        habilidades = new ArrayList<>();
        tipos = new ArrayList<>();
        this.ataque = 30;
        this.defesa = 10;
        this.hp = 100;

        return this;
    }

    public String tiposToString() {

        String types = "";
        for (int i = 0; i < tipos.size(); i++) {
            if(i > 0)
                types += ", ";
            types += tipos.get(i).getNome();
        }

        return types;
    }
}
