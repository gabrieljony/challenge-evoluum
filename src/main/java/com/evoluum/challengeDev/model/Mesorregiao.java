package com.evoluum.challengeDev.model;

import java.util.Objects;

public class Mesorregiao {

    private String id;
    private String nome;
    private Estado uf;

    public Mesorregiao() {
    }

    public Mesorregiao(String id, String nome, Estado uf) {
        this.id = id;
        this.nome = nome;
        this.uf = uf;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Estado getUf() {
        return uf;
    }

    public void setUf(Estado uf) {
        this.uf = uf;
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
