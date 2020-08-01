package com.jonatas.pokedex.ui.activity.listaPokemon;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.jonatas.pokedex.R;
import com.jonatas.pokedex.databinding.ListaPokemonActivityBinding;
import com.jonatas.pokedex.dto.PokemonDTO;
import com.jonatas.pokedex.model.Pokemon;
import com.jonatas.pokedex.model.Tipo;
import com.jonatas.pokedex.ui.adapter.PokemonAdapter;

import java.util.ArrayList;
import java.util.List;

public class ListaPokemonActivty extends AppCompatActivity {

    ListaPokemonActivityBinding mBinding;
    List<Pokemon> mTodosPokemons = new ArrayList<>();
    PokemonAdapter mAdapter;
    List<PokemonDTO> mPokemonsDTO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mBinding = DataBindingUtil.setContentView(this,
                R.layout.lista_pokemon_activity);

        criaPokemons();

        mPokemonsDTO = obterPokemons();

        configuraRecyclerView(mPokemonsDTO);

        mBinding.searchView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popularListaDePokemon(mPokemonsDTO);
            }
        });

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

    private void criaPokemons() {
        Pokemon charmander = new Pokemon(001, "Charmander").create();
        Pokemon bulbasauro = new Pokemon(002, "Bulbasauro").create();
        Pokemon squirtle = new Pokemon(003, "Squirtle").create();
        Pokemon pikachu = new Pokemon(004, "Pikachu").create();
        Pokemon miu = new Pokemon(005, "Miu").create();

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


    private void configuracaoPadraoDaLista(LinearLayoutManager linearLayoutManager) {
        mBinding.rvPokemon.setHasFixedSize(true);
        mBinding.rvPokemon.setNestedScrollingEnabled(false);
        mBinding.rvPokemon.setLayoutManager(linearLayoutManager);
    }

    @Override
    protected void onResume() {
        super.onResume();

        Intent dadosRecebidos = getIntent();
        String tipoRecebido = dadosRecebidos.getStringExtra("chave_tipo");

        List<PokemonDTO> pokemonPorTipo = new ArrayList<>();
        if (tipoRecebido != null) {
            mBinding.searchView.setVisibility(View.GONE);
            for (PokemonDTO pokemonTipo : mPokemonsDTO) {
                for (int i = 0; i < pokemonTipo.tipos.size(); i++) {
                    if (pokemonTipo.tipos.get(i).getNome().equals(tipoRecebido)) {
                        pokemonPorTipo.add(pokemonTipo);
                    }
                }
            }

            popularListaDePokemon(pokemonPorTipo);
        } else {
            mBinding.searchView.setVisibility(View.VISIBLE);
        }
    }

    private void popularListaDePokemon(List<PokemonDTO> todosPokemons) {
        mAdapter = new PokemonAdapter(todosPokemons, this);
        mBinding.rvPokemon.setAdapter(mAdapter);
    }

}
