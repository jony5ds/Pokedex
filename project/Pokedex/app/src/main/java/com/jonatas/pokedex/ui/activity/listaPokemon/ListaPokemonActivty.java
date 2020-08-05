package com.jonatas.pokedex.ui.activity.listaPokemon;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.jonatas.pokedex.R;
import com.jonatas.pokedex.databinding.ListaPokemonActivityBinding;
import com.jonatas.pokedex.dto.PokemonDTO;
import com.jonatas.pokedex.model.Pokemon;
import com.jonatas.pokedex.model.PokemonRequest;
import com.jonatas.pokedex.service.ApiInterface;
import com.jonatas.pokedex.service.RetrofitConfig;
import com.jonatas.pokedex.ui.adapter.PokemonAdapter;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class ListaPokemonActivty extends AppCompatActivity implements IListaPokemonView {

    private ListaPokemonActivityBinding mBinding;
    private PokemonAdapter mAdapter;
    private ListaPokemonPresenter mPresenter;
    private Retrofit mRetrofit;
    private static final String TAG = "POKEDEX";
    private int offset;
    private boolean podeCarregar;
    private GridLayoutManager mGridLayoutManager;
    List<PokemonDTO> listPokemonDTO = new ArrayList<>();

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

        mBinding.rvPokemon.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                if (dy > 0)
                {
                    int itemVisivel = mGridLayoutManager.getChildCount();
                    int totalItemCount = mGridLayoutManager.getItemCount();
                    int pastVisibleItens = mGridLayoutManager.findFirstVisibleItemPosition();

                    if (podeCarregar)
                    {
                        if ((itemVisivel + pastVisibleItens) >= totalItemCount){
                            podeCarregar = false;
                            offset+= 20;
                            getDados(offset);
                        }
                    }

                }
            }
        });
        mRetrofit = RetrofitConfig.getClient();

        podeCarregar = true;
        offset = 0;
        getDados(offset);
    }

    private void getDados(int offset)
    {
        ApiInterface service = mRetrofit.create(ApiInterface.class);
        Call<PokemonRequest> pokemonRequestCall = service.getPokemon(40,offset);
        pokemonRequestCall.enqueue(new Callback<PokemonRequest>() {
            @Override
            public void onResponse(Call<PokemonRequest> call, Response<PokemonRequest> response) {
                podeCarregar = true;
                if (response.isSuccessful())
                {
                    PokemonRequest pokemonRequest = response.body();
                    ArrayList<Pokemon> listaPokemon = pokemonRequest.getResults();

                    for (int i = 0; i < listaPokemon.size(); i++)
                    {
                        PokemonDTO pokemonDTO = new PokemonDTO(listaPokemon.get(i).getCodigo(),
                                listaPokemon.get(i).getName());

                        listPokemonDTO.add(pokemonDTO);

                    }

                    configurarRecyclerView(listPokemonDTO);
                }
            }

            @Override
            public void onFailure(Call<PokemonRequest> call, Throwable t) {

            }
        });
    }

    private void configuracaoPadraoDaLista(GridLayoutManager linearLayoutManager) {
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
                    .obterPokemonPorTipo(tipoRecebido,listPokemonDTO);

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
         mGridLayoutManager = new GridLayoutManager(this,2);
        configuracaoPadraoDaLista(mGridLayoutManager);
        popularListaDePokemon(pokemons);
    }


}
