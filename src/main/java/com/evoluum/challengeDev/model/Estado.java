package com.evoluum.challengeDev.model;

import java.util.Objects;

public class Estado {

    private Long id;
    private String nome;
    private String sigla;
    private Regiao regiao;

    public String getNomeFormatado() {
        String nomeFormatado = new StringBuilder().append(nome).append("/").append(sigla).toString();
        return nomeFormatado;
    }

    public Estado() {
    }

    public Estado(Long id, String nome, String sigla, Regiao regiao) {
        this.id = id;
        this.nome = nome;
        this.sigla = sigla;
        this.regiao = regiao;
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

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public Regiao getRegiao() {
        return regiao;
    }

    public void setRegiao(Regiao regiao) {
        this.regiao = regiao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Estado estado = (Estado) o;
        return Objects.equals(id, estado.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
