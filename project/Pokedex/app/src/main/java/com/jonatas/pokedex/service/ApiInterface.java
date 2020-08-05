package com.jonatas.pokedex.service;

import com.jonatas.pokedex.model.Pokemon;
import com.jonatas.pokedex.model.PokemonRequest;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiInterface {

    @GET("pokemon")
    Call<PokemonRequest> getPokemon(@Query("limit")int limit, @Query("offset")int offset);
}
