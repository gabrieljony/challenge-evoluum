package com.evoluum.challengeDev.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class Mesorregiao {

    private Long id;
    private String nome;

    @JsonProperty(value = "UF")
    private Regiao UF;

    public Mesorregiao() {
    }

    public Mesorregiao(Long id, String nome, Regiao UF) {
        this.id = id;
        this.nome = nome;
        this.UF = UF;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Regiao getUF() {
        return UF;
    }

    public void setUF(Regiao UF) {
        this.UF = UF;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Mesorregiao that = (Mesorregiao) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
