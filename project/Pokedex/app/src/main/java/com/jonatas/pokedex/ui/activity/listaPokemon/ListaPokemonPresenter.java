package com.jonatas.pokedex.ui.activity.listaPokemon;

import android.util.Log;
import com.jonatas.pokedex.dto.PokemonDTO;
import com.jonatas.pokedex.model.Pokemon;
import com.jonatas.pokedex.model.Tipo;
import com.jonatas.pokedex.service.ApiInterface;
import com.jonatas.pokedex.service.RetrofitConfig;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListaPokemonPresenter {
   private IListaPokemonView mView;

    public ListaPokemonPresenter(IListaPokemonView view) {
        this.mView = view;
    }

    public void onCreate()
    {

    }

    /*private List<PokemonDTO> obterPokemons() {

        final List<Pokemon> pokemons = new ArrayList<>();

        ApiInterface apiService = RetrofitConfig.getClient().create(ApiInterface.class);
        for(int i = 1; i <= 30; i++) {
            Call<Pokemon> call = apiService.getPokemon(i);

            call.enqueue(new Callback<Pokemon>() {
                @Override
                public void onResponse(Call<Pokemon> call, Response<Pokemon> response) {
                    if(response.isSuccessful()) {
                        Pokemon pokemon = response.body();

                        pokemons.add(pokemon);

                        Log.i("POKEMON", "Name: " + pokemon.getNome());
                        Log.i("POKEMON", "Attack: " + pokemon.getAtaque());
                        Log.i("POKEMON", "Defense: " + pokemon.getDefesa());
                        Log.i("POKEMON", "Health: " + pokemon.getHp());

                    }
                    else {
                        Log.i("Erro", "comunicacao: ");
                    }
                }

                @Override
                public void onFailure(Call<Pokemon> call, Throwable t) {
                }
            });
        }*/

        /*for(int i = 0;i < mTodosPokemons.size();i++)
        {
            PokemonDTO pokemonItem = new PokemonDTO();
            Pokemon pokemon = mTodosPokemons.get(i);
            pokemonItem.codigo = pokemon.getCodigo();
            pokemonItem.nome = pokemon.getNome();
            pokemonItem.numero = pokemon.obterCodigo();
            pokemons.add(pokemonItem);
        }

        List<PokemonDTO> pokemonsDTO = new ArrayList<>();

        PokemonDTO pikachu = new PokemonDTO(1, "Pikachu").create();
        pikachu.tipos.add(new Tipo("trovao"));
        PokemonDTO charmander = new PokemonDTO(2, "Charmander").create();
        charmander.tipos.add(new Tipo("Fogo"));

        pokemonsDTO.add(pikachu);
        pokemonsDTO.add(charmander);

        return pokemonsDTO;
    } */

    public List<PokemonDTO> obterPokemonPorTipo(String tipoRecebido,List<PokemonDTO> pokemons)
    {
        List<PokemonDTO> pokemonPorTipo = new ArrayList<>();
        for (PokemonDTO pokemonTipo : pokemons) {
            for (int i = 0; i < pokemonTipo.tipos.size(); i++) {
                if (pokemonTipo.tipos.get(i).getNome().equals(tipoRecebido)) {
                    pokemonPorTipo.add(pokemonTipo);
                }
            }
        }
        return pokemonPorTipo;
    }
}
