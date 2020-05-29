package com.evoluum.challengeDev.model;

import java.util.Objects;

public class Regiao {

    private String id;
    private String nome;
	private String sigla;

    public Regiao() {
    }

    public Regiao(String id, String nome, String sigla) {
        this.id = id;
        this.nome = nome;
        this.sigla = sigla;
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

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Regiao regiao = (Regiao) o;
        return Objects.equals(id, regiao.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
