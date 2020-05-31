package com.evoluum.challengeDev.view;

public enum TypeFile {

    CSV(1, "csv"),
    XML(2, "xml"),
    JSON(3, "json"),
    PDF(4, "pdf"),
    ODT(5, "odt");

    private int cod;
    private String extensao;

    TypeFile(int cod, String extensao) {
        this.cod = cod;
        this.extensao = extensao;
    }

    public int getCod() {
        return cod;
    }

    public String getExtensao() {
        return extensao;
    }

    public static TypeFile toEnum(Integer cod) {
        if (cod == null) {
            return null;
        }

        for (TypeFile x : TypeFile.values()) {
            if (cod.equals(x.getCod())){
                return x;
            }
        }
        throw new IllegalArgumentException("Id inválido: " + cod);
    }
}
