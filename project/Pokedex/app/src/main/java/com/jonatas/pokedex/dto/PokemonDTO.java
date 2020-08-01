package com.jonatas.pokedex.dto;

import com.jonatas.pokedex.model.Habilidade;
import com.jonatas.pokedex.model.Sprite;
import com.jonatas.pokedex.model.Tipo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PokemonDTO implements Serializable {
    public int codigo;
    public String nome;
    public int hp;
    public int ataque;
    public int defesa;
    public int velocidade;
    public int ataqueEspecial;
    public int defesaEspecial;
    public List<Habilidade> habilidades;
    public List<Tipo> tipos = new ArrayList<>();
    public List<Sprite> sprites = new ArrayList<>();
    public List<String> evolucoes = new ArrayList<>();

    public PokemonDTO(int codigo, String nome) {
        this.codigo = codigo;
        this.nome = nome;
    }

    public String getCodigo()
    {
        return String.valueOf(codigo);
    }

    public String getHp()
    {
        return String.valueOf(hp);
    }

    public String getAtaque()
    {
        return String.valueOf(ataque);
    }

    public String getDefesa()
    {
        return String.valueOf(defesa);
    }

    public String getVelocidade()
    {
        return String.valueOf(velocidade);
    }

    public String getAtaqueEspecial()
    {
        return String.valueOf(ataqueEspecial);
    }

    public String getDefesaEspecial()
    {
        return String.valueOf(defesaEspecial);
    }

    public PokemonDTO create()
    {
        evolucoes = new ArrayList<>();
        habilidades = new ArrayList<>();
        tipos = new ArrayList<>();
        this.ataque = 30;
        this.defesa = 10;
        this.evolucoes.add("Chaarlizard");
        this.evolucoes.add("Chaminer");
        this.hp = 100;
        this.ataqueEspecial = 120;
        this.defesaEspecial = 80;

        Habilidade pular = new Habilidade("Pular",
                "Esse pokemon consegue dar grandes saltos");
        Habilidade socar = new Habilidade("Socar",
                "Esse pokemon consegue dar socos");

        habilidades.add(pular);
        habilidades.add(socar);

        return this;
    }





}
