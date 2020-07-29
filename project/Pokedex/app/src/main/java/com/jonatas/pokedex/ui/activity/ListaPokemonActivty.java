package com.jonatas.pokedex.ui.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import com.jonatas.pokedex.R;
import com.jonatas.pokedex.databinding.ListaPokemonActivityBinding;
import com.jonatas.pokedex.dto.PokemonDTO;
import com.jonatas.pokedex.model.Pokemon;
import com.jonatas.pokedex.ui.adapter.PokemonAdapter;

import java.util.ArrayList;
import java.util.List;

public class ListaPokemonActivty extends AppCompatActivity {

    ListaPokemonActivityBinding mBinding;
    List<Pokemon> mTodosPokemons =  new ArrayList<>();;
    PokemonAdapter mAdapter;
    List<PokemonDTO> mPokemonsDTO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mBinding = DataBindingUtil.setContentView(this,
                R.layout.lista_pokemon_activity);

        criaPokemons();

        mPokemonsDTO = obterPokemons(mTodosPokemons);

        configuraRecyclerView(mPokemonsDTO);

        mBinding.searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                mAdapter.getFilter().filter(newText);
                return false;
            }
        });

    }

    private List<PokemonDTO> obterPokemons(List<Pokemon> mTodosPokemons) {

        List<PokemonDTO> pokemons = new ArrayList<>();


        for(int i = 0;i < mTodosPokemons.size();i++)
        {
            PokemonDTO pokemonItem = new PokemonDTO();
            Pokemon pokemon = mTodosPokemons.get(i);
            pokemonItem.codigo = pokemon.getCodigo();
            pokemonItem.nome = pokemon.getNome();
            pokemonItem.numero = pokemon.obterCodigo();
            pokemons.add(pokemonItem);
        }
        return pokemons;
    }

    private void criaPokemons() {
        Pokemon charmander = new Pokemon(001,"Charmander");
        Pokemon bulbasauro = new Pokemon(002,"Bulbasauro");
        Pokemon squirtle = new Pokemon(003,"Squirtle");
        Pokemon pikachu = new Pokemon(004,"Pikachu");
        Pokemon miu = new Pokemon(005,"Miu");

        mTodosPokemons.add(charmander);
        mTodosPokemons.add(bulbasauro);
        mTodosPokemons.add(squirtle);
        mTodosPokemons.add(pikachu);
        mTodosPokemons.add(miu);
    }


    private void configuraRecyclerView(List<PokemonDTO> todosPokemons) {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        configuracaoPadraoDaLista(linearLayoutManager);
        popularListaDePokemon(todosPokemons);

    }

    private void popularListaDePokemon(List<PokemonDTO> todosPokemons) {
        mAdapter = new PokemonAdapter(todosPokemons,this);
        mBinding.rvPokemon.setAdapter(mAdapter);

    }

    private void configuracaoPadraoDaLista(LinearLayoutManager linearLayoutManager) {
        mBinding.rvPokemon.setHasFixedSize(true);
        mBinding.rvPokemon.setNestedScrollingEnabled(false);
        mBinding.rvPokemon.setLayoutManager(linearLayoutManager);
    }

}
