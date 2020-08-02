package com.jonatas.pokedex.model;

import java.io.Serializable;

public class Evolucao implements Serializable {
    private String nome;
    private String resourceUri;

    public Evolucao(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getResourceUri() {
        return resourceUri;
    }

    public void setResourceUri(String resourceUri) {
        this.resourceUri = resourceUri;
    }

}
