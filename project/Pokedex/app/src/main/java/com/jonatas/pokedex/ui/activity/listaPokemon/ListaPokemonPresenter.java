package com.jonatas.pokedex.ui.activity.listaPokemon;

import android.content.Context;

import com.jonatas.pokedex.dto.PokemonDTO;
import com.jonatas.pokedex.model.Pokemon;
import com.jonatas.pokedex.model.Tipo;

import java.util.ArrayList;
import java.util.List;

public class ListaPokemonPresenter {
   private List<PokemonDTO> mPokemonsDTO;
   private IListaPokemonView mView;

    public ListaPokemonPresenter(IListaPokemonView view) {
        this.mView = view;
    }


    public void onCreate()
    {
        mPokemonsDTO = obterPokemons();
        mView.configurarRecyclerView(mPokemonsDTO);

    }

    private List<PokemonDTO> obterPokemons() {

        List<PokemonDTO> pokemons = new ArrayList<>();

        /*for(int i = 0;i < mTodosPokemons.size();i++)
        {
            PokemonDTO pokemonItem = new PokemonDTO();
            Pokemon pokemon = mTodosPokemons.get(i);
            pokemonItem.codigo = pokemon.getCodigo();
            pokemonItem.nome = pokemon.getNome();
            pokemonItem.numero = pokemon.obterCodigo();
            pokemons.add(pokemonItem);
        }*/

        PokemonDTO pikachu = new PokemonDTO(1, "Pikachu").create();
        pikachu.tipos.add(new Tipo("trovao"));
        PokemonDTO charmander = new PokemonDTO(2, "Charmander").create();
        charmander.tipos.add(new Tipo("Fogo"));

        pokemons.add(pikachu);
        pokemons.add(charmander);
        return pokemons;
    }

    public List<PokemonDTO> obterPokemonPorTipo(String tipoRecebido)
    {
        List<PokemonDTO> pokemonPorTipo = new ArrayList<>();
        for (PokemonDTO pokemonTipo : mPokemonsDTO) {
            for (int i = 0; i < pokemonTipo.tipos.size(); i++) {
                if (pokemonTipo.tipos.get(i).getNome().equals(tipoRecebido)) {
                    pokemonPorTipo.add(pokemonTipo);
                }
            }
        }
        return pokemonPorTipo;
    }
}
