package com.jonatas.pokedex.model;

import java.io.Serializable;

public class Pokemon implements Serializable {
  private String name;
  private String url;
  private int codigo;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getCodigo()
    {
        String[] urlPartes = url.split("/");
        return Integer.parseInt(urlPartes[urlPartes.length - 1]);
    }
}
