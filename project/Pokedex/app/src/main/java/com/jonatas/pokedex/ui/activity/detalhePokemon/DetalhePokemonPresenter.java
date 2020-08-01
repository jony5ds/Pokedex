package com.jonatas.pokedex.ui.activity.detalhePokemon;

public class DetalhePokemonPresenter {

    private IDetalhePokemonView mView;

    public DetalhePokemonPresenter(IDetalhePokemonView mView) {
        this.mView = mView;
    }

    public void onCreate()
    {
        mView.listarHabilidades();
        mView.listarTipos();
    }
}
