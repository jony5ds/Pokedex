package com.jonatas.pokedex.ui.activity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.widget.ArrayAdapter;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.jonatas.pokedex.R;
import com.jonatas.pokedex.databinding.DetalhePokemonActivityBinding;
import com.jonatas.pokedex.dto.PokemonDTO;
import com.jonatas.pokedex.model.Habilidade;
import com.jonatas.pokedex.model.Tipo;
import com.jonatas.pokedex.ui.adapter.HabilidadesAdapter;

public class DetalhePokemonActivity extends AppCompatActivity {

    DetalhePokemonActivityBinding mBinding;
    private PokemonDTO mPokemon;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.detalhe_pokemon_activity);
        Intent dadosRecebidos = getIntent();
        mPokemon = (PokemonDTO) dadosRecebidos.getSerializableExtra("chave_pokemon");
        mBinding.setPokemon(mPokemon);

        HabilidadesAdapter adapter = new HabilidadesAdapter(this,mPokemon.habilidades);
        mBinding.pokemonListHabilidades.setAdapter(adapter);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            mBinding.pokemonListHabilidades.setNestedScrollingEnabled(false);
        }
        /*ArrayAdapter<Tipo> tipoAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_2, android.R.id.text1, mPokemon.tipos );
        mBinding.pokemonListTipos.setAdapter(tipoAdapter);*/

    }
}
