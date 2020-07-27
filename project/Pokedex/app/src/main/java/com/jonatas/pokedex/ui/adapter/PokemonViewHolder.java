package com.jonatas.pokedex.ui.adapter;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.jonatas.pokedex.databinding.ItemListaPokemonBinding;

public class PokemonViewHolder extends RecyclerView.ViewHolder{

    ItemListaPokemonBinding mBinding;

    public PokemonViewHolder(@NonNull ItemListaPokemonBinding binding) {
        super(binding.getRoot());
        this.mBinding = binding;
        mBinding.executePendingBindings();
    }

    public ItemListaPokemonBinding getViewDataBinding() { return mBinding; }
}
