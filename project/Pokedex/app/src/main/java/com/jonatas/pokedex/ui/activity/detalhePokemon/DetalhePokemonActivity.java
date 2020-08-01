package com.jonatas.pokedex.ui.activity.detalhePokemon;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.jonatas.pokedex.R;
import com.jonatas.pokedex.databinding.DetalhePokemonActivityBinding;
import com.jonatas.pokedex.dto.PokemonDTO;
import com.jonatas.pokedex.model.Habilidade;
import com.jonatas.pokedex.model.Tipo;
import com.jonatas.pokedex.ui.activity.listaPokemon.ListaPokemonActivty;
import com.jonatas.pokedex.ui.adapter.HabilidadesAdapter;
import com.jonatas.pokedex.ui.adapter.TiposAdapter;

public class DetalhePokemonActivity extends AppCompatActivity implements IDetalhePokemonView {

    DetalhePokemonActivityBinding mBinding;
    DetalhePokemonPresenter mPresenter;
    PokemonDTO mPokemon;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.detalhe_pokemon_activity);

        mPokemon = obterDadosPokemon();

       mPresenter = new DetalhePokemonPresenter(this);
       mPresenter.onCreate();

        mBinding.setPokemon(mPokemon);

        eventoTocarHabilidade();

        eventoTocarTipo();
    }

    private void eventoTocarTipo() {
        mBinding.pokemonListTipos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Tipo tipo = mPokemon.tipos.get(position);
                Intent irParaListaDePokemon = new Intent(DetalhePokemonActivity.this,
                        ListaPokemonActivty.class);
                irParaListaDePokemon.putExtra("chave_tipo",tipo.getNome());

                startActivity(irParaListaDePokemon);

            }
        });
    }

    private void eventoTocarHabilidade() {
        mBinding.pokemonListHabilidades.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Habilidade habilidade = mPokemon.habilidades.get(position);
                new AlertDialog.Builder(DetalhePokemonActivity.this)
                        .setTitle(habilidade.getNome())
                        .setMessage(habilidade.getDescricao())
                        .show();
            }
        });
    }

    private PokemonDTO obterDadosPokemon() {
        Intent dadosRecebidos = getIntent();
        return (PokemonDTO) dadosRecebidos.getSerializableExtra("chave_pokemon");
    }

    @Override
    public void onBackPressed(){
        startActivity(new Intent(this, ListaPokemonActivty.class));
        finishAffinity();
    }

    @Override
    public void listarHabilidades() {
        HabilidadesAdapter habilidadesAdapter = new HabilidadesAdapter(this, mPokemon.habilidades);
        mBinding.pokemonListHabilidades.setAdapter(habilidadesAdapter);

    }

    @Override
    public void listarTipos() {
        TiposAdapter tiposAdapter = new TiposAdapter(this, mPokemon.tipos);
        mBinding.pokemonListTipos.setAdapter(tiposAdapter);

    }
}
