package com.evoluum.challengeDev.model;

import java.util.Objects;

public class Municipio {

    private Long id;
    private String nome;
    private Microrregiao microrregiao;

    public String getNomeFormatado() {
        String nomeFormatado = new StringBuilder().append(nome).append("/").append(microrregiao.getMesorregiao().getUF().getSigla()).toString();
        return nomeFormatado;
    }

    public Municipio() {
    }

    public Municipio(Long id, String nome, Microrregiao microrregiao) {
        this.id = id;
        this.nome = nome;
        this.microrregiao = microrregiao;
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

    public Microrregiao getMicrorregiao() {
        return microrregiao;
    }

    public void setMicrorregiao(Microrregiao microrregiao) {
        this.microrregiao = microrregiao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Municipio municipio = (Municipio) o;
        return Objects.equals(id, municipio.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
