package com.jonatas.pokedex.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Sprite implements Serializable {

    @SerializedName("front_default")
    private String resourceUri;

    public String getResourceUri() {
        return resourceUri;
    }

    public void setResourceUri(String resourceUri) {
        this.resourceUri = resourceUri;
    }
}
