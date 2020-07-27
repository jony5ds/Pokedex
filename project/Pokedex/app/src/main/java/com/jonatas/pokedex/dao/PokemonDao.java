package com.jonatas.pokedex.dao;

import com.jonatas.pokedex.model.Pokemon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PokemonDao {
    private final static ArrayList<Pokemon> pokemons = new ArrayList<>();

    public List<Pokemon> todos() {
        return (List<Pokemon>) pokemons.clone();
    }

    public void insere(Pokemon... pokemons) {
        PokemonDao.pokemons.addAll(Arrays.asList(pokemons));
    }

}
