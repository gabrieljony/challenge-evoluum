package com.evoluum.challengeDev.view;

public abstract class CsvFactory<T> extends AbstractCsvView<T> {

    private StringBuilder stringBuilder = new StringBuilder();
    private String separator = ";";


    public CsvFactory<T> addColuna(String linha) {
        stringBuilder.append(linha).append( separator );
        return this;
    }

    public CsvFactory<T> addCabecalho(String linha) {
        stringBuilder.append(linha).append( System.lineSeparator() );
        return this;
    }

    @Override
    public byte[] getBytes() {
        return text().getBytes();
    }

    public String text() {
        return stringBuilder.append( System.lineSeparator()).toString();
    }

    public CsvFactory<T> lineSeparator() {
        stringBuilder.append(System.lineSeparator());
        return this;
    }
}
