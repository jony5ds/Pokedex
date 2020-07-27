package com.jonatas.pokedex.ui.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import com.jonatas.pokedex.R;
import com.jonatas.pokedex.databinding.ListaPokemonActivityBinding;
import com.jonatas.pokedex.model.Pokemon;
import com.jonatas.pokedex.ui.adapter.PokemonAdapter;

import java.util.ArrayList;
import java.util.List;

public class ListaPokemonActivty extends AppCompatActivity {

    ListaPokemonActivityBinding mBinding;
    List<Pokemon> mTodosPokemons =  new ArrayList<>();;
    PokemonAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mBinding = DataBindingUtil.setContentView(this,
                R.layout.lista_pokemon_activity);

        criaPokemons();

        configuraRecyclerView(mTodosPokemons);

    }

    private void criaPokemons() {
        Pokemon charmander = new Pokemon(001,"Charmander");
        Pokemon bulbasauro = new Pokemon(002,"Bulbasauro");
        Pokemon squirtle = new Pokemon(003,"Squirtle");
        Pokemon pikachu = new Pokemon(003,"pikachu");
        Pokemon miu = new Pokemon(003,"miu");

        mTodosPokemons.add(charmander);
        mTodosPokemons.add(bulbasauro);
        mTodosPokemons.add(squirtle);
        mTodosPokemons.add(pikachu);
        mTodosPokemons.add(miu);
    }


    private void configuraRecyclerView(List<Pokemon> todosPokemons) {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        configuracaoPadraoDaLista(linearLayoutManager);
        popularListaDePokemon(todosPokemons);

    }

    private void popularListaDePokemon(List<Pokemon> todosPokemons) {
        mAdapter = new PokemonAdapter(todosPokemons,this);
        mBinding.rvPokemon.setAdapter(mAdapter);

    }

    private void configuracaoPadraoDaLista(LinearLayoutManager linearLayoutManager) {
        mBinding.rvPokemon.setHasFixedSize(true);
        mBinding.rvPokemon.setNestedScrollingEnabled(false);
        mBinding.rvPokemon.setLayoutManager(linearLayoutManager);
    }

}
