package com.jonatas.pokedex.service;

import com.jonatas.pokedex.model.Pokemon;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiInterface {

    @GET("pokemon/{id}")
    Call<Pokemon> getPokemon(@Path("id") int id);
}
