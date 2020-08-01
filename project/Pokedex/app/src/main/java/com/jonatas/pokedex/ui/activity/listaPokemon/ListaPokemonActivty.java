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

public class ListaPokemonActivty extends AppCompatActivity implements IListaPokemonView {

    ListaPokemonActivityBinding mBinding;
    PokemonAdapter mAdapter;
    ListaPokemonPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mBinding = DataBindingUtil.setContentView(this,
                R.layout.lista_pokemon_activity);
        mPresenter = new ListaPokemonPresenter(this);
        mPresenter.onCreate();

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

    private void configuracaoPadraoDaLista(LinearLayoutManager linearLayoutManager) {
        mBinding.rvPokemon.setHasFixedSize(true);
        mBinding.rvPokemon.setNestedScrollingEnabled(false);
        mBinding.rvPokemon.setLayoutManager(linearLayoutManager);
    }

    @Override
    protected void onResume() {
        super.onResume();

        usarPokemonsPorTipoNaLista();
    }

    private void usarPokemonsPorTipoNaLista() {
        String tipoRecebido = obterDados();

        if (tipoRecebido != null) {

            mBinding.searchView.setVisibility(View.GONE);

            List<PokemonDTO> pokemonPorTipo = mPresenter
                    .obterPokemonPorTipo(tipoRecebido);

            popularListaDePokemon(pokemonPorTipo);
        } else {
            mBinding.searchView.setVisibility(View.VISIBLE);
        }
    }

    private String obterDados() {
        Intent dadosRecebidos = getIntent();
        return dadosRecebidos.getStringExtra("chave_tipo");
    }

    private void popularListaDePokemon(List<PokemonDTO> todosPokemons) {
        mAdapter = new PokemonAdapter(todosPokemons, this);
        mBinding.rvPokemon.setAdapter(mAdapter);
    }


    @Override
    public void configurarRecyclerView(List<PokemonDTO> pokemons) {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        configuracaoPadraoDaLista(linearLayoutManager);
        popularListaDePokemon(pokemons);
    }

}
