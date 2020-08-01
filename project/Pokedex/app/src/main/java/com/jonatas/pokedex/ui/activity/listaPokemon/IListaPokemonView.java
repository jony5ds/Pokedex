package com.jonatas.pokedex.ui.activity.listaPokemon;

import com.jonatas.pokedex.dto.PokemonDTO;
import java.util.List;

public interface IListaPokemonView {


    void configurarRecyclerView(List<PokemonDTO> pokemons);



}
