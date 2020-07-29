package com.jonatas.pokedex.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.jonatas.pokedex.R;
import com.jonatas.pokedex.databinding.DetalhePokemonActivityBinding;
import com.jonatas.pokedex.model.Pokemon;

public class DetalhePokemonActivity extends AppCompatActivity {

    DetalhePokemonActivityBinding mBinding;
    private Pokemon mPokemon;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.detalhe_pokemon_activity);
        Intent dadosRecebidos = getIntent();
        mPokemon = (Pokemon) dadosRecebidos.getSerializableExtra("chave_pokemon");
        mBinding.setPokemon(mPokemon);

    }
}
