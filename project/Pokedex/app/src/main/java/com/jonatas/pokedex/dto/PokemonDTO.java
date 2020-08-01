package com.jonatas.pokedex.dto;

import java.io.Serializable;
import java.util.List;

public class PokemonDTO implements Serializable {
    public String nome;
    public String numero;
    public long codigo;
    public int hp;
    public int ataque;
    public int defesa;
    public List<String> habilidades;
    public List<String> tipos;
    public List<String> evolucoes;

    public String getCodigo()
    {
        return String.valueOf(codigo);
    }


}
