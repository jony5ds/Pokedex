package com.jonatas.pokedex.ui.adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.jonatas.pokedex.R;
import com.jonatas.pokedex.databinding.ItemListaPokemonBinding;
import com.jonatas.pokedex.dto.PokemonDTO;
import com.jonatas.pokedex.ui.activity.detalhePokemon.DetalhePokemonActivity;
import com.jonatas.pokedex.ui.activity.listaPokemon.ListaPokemonActivty;

import java.util.ArrayList;
import java.util.List;

public class PokemonAdapter extends RecyclerView.Adapter<PokemonViewHolder> implements Filterable {

    private List<PokemonDTO> mListaDePokemon;
    private List<PokemonDTO> mListaDePokemonFull;
    private ListaPokemonActivty mContext;

    public PokemonAdapter(List<PokemonDTO> listaDePokemon, ListaPokemonActivty mContext) {
        this.mListaDePokemon = listaDePokemon;
        this.mListaDePokemonFull = new ArrayList<>(listaDePokemon);
        this.mContext = mContext;
    }

    public PokemonAdapter(List<PokemonDTO> pokemonsPorTipo,
                          List<PokemonDTO> todosPokemons,
                          ListaPokemonActivty listaPokemonActivty) {

        this.mListaDePokemon = pokemonsPorTipo;
        mListaDePokemonFull = todosPokemons;
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
            final PokemonDTO pokemon = mListaDePokemon.get(position);
            holder.getViewDataBinding().setPokemon(pokemon);

        Glide.with(mContext)
                .load("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/shiny/" + pokemon.getCodigo() + ".png")
                .centerCrop()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(holder.mBinding.pokemonImagem);

            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(mContext, DetalhePokemonActivity.class);
                    intent.putExtra("chave_pokemon",pokemon);
                    mContext.startActivity(intent);
                }
            });
    }

    @Override
    public int getItemCount() {
        return mListaDePokemon.size();
    }

    @Override
    public Filter getFilter() {
        return pokemonFilter;
    }
    private Filter pokemonFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<PokemonDTO> listaFiltrada = new ArrayList<>();
            if(constraint == null || constraint.length() == 0){
                listaFiltrada.addAll(mListaDePokemonFull);
            }else{
                String filtroPadrao = constraint.toString().toLowerCase().trim();;
                for(PokemonDTO item : mListaDePokemonFull)
                {
                    if (item.nome.toLowerCase().contains(filtroPadrao)  ){
                        listaFiltrada.add(item);
                    }else if (item.getCodigo().toLowerCase().contains(filtroPadrao))
                    {
                        listaFiltrada.add(item);
                    }
                }

            }
            FilterResults resultado = new FilterResults();
            resultado.values = listaFiltrada;
            return resultado;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            mListaDePokemon.clear();
            mListaDePokemon.addAll((List)results.values);
            notifyDataSetChanged();
        }
    };


}

