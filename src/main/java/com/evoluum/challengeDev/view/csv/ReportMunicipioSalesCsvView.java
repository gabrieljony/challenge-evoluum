package com.evoluum.challengeDev.view.csv;

import com.evoluum.challengeDev.model.Estado;
import com.evoluum.challengeDev.model.Municipio;
import com.evoluum.challengeDev.view.AbstractCsvView;
import com.evoluum.challengeDev.view.CsvFactory;
import com.evoluum.challengeDev.view.TypeFile;

import java.util.List;

public class ReportMunicipioSalesCsvView extends CsvFactory<Municipio> {

    @Override
    public String getName() {
        return "municipios";
    }

    @Override
    public TypeFile getTypeFile() {
        return TypeFile.CSV;
    }

    @Override
    public AbstractCsvView<Municipio> addInfo(List<Municipio> info) {
        info.forEach(municipio -> {
            addCabecalho(   "idEstado; " +
                            "siglaEstado; " +
                            "regiaoNome; " +
                            "nomeCidade;" +
                            "nomeMesorregiao; " +
                            "nomeFormatado" );
            addColuna(municipio.getMicrorregiao().getMesorregiao().getUF().getId().toString())
                    .addColuna(municipio.getMicrorregiao().getMesorregiao().getUF().getSigla())
                    .addColuna(municipio.getMicrorregiao().getMesorregiao().getUF().getNome())
                    .addColuna(municipio.getNome())
                    .addColuna(municipio.getMicrorregiao().getMesorregiao().getNome())
                    .addColuna(municipio.getNomeFormatado())
                    .lineSeparator();
        });
        return this;
    }
}
