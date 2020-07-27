package com.jonatas.pokedex.ui.adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.jonatas.pokedex.R;
import com.jonatas.pokedex.databinding.ItemListaPokemonBinding;
import com.jonatas.pokedex.dto.PokemonDTO;
import com.jonatas.pokedex.model.Pokemon;
import com.jonatas.pokedex.ui.activity.DetalhePokemonActivity;
import com.jonatas.pokedex.ui.activity.ListaPokemonActivty;

import java.util.List;

public class PokemonAdapter extends RecyclerView.Adapter<PokemonViewHolder> {

    private List<Pokemon> mListaDePokemon;
    private ListaPokemonActivty mContext;

    public PokemonAdapter(List<Pokemon> mListaDePokemon, ListaPokemonActivty mContext) {
        this.mListaDePokemon = mListaDePokemon;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public PokemonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        final ItemListaPokemonBinding binding = DataBindingUtil
                .inflate(LayoutInflater.from(parent.getContext()),
                        R.layout.item_lista_pokemon,
                        parent,false);
        return new PokemonViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull PokemonViewHolder holder, int position) {
        final Pokemon pokemon = mListaDePokemon.get(position);
        holder.getViewDataBinding().setPokemon(pokemon);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, DetalhePokemonActivity.class);
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mListaDePokemon.size();
    }
}

