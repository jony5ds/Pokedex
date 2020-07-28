package com.jonatas.pokedex.dto;

import java.util.List;

public class PokemonDTO {
    public String nome;
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
