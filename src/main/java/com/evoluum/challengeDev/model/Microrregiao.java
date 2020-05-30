package com.evoluum.challengeDev.model;

import java.util.Objects;

public class Microrregiao {

    private Long id;
    private String nome;
    private Mesorregiao mesorregiao;

    public Microrregiao() {
    }

    public Microrregiao(Long id, String nome, Mesorregiao mesorregiao) {
        this.id = id;
        this.nome = nome;
        this.mesorregiao = mesorregiao;
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

    public Mesorregiao getMesorregiao() {
        return mesorregiao;
    }

    public void setMesorregiao(Mesorregiao mesorregiao) {
        this.mesorregiao = mesorregiao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Microrregiao that = (Microrregiao) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
