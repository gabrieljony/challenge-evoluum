package com.evoluum.challengeDev.view.csv;

import com.evoluum.challengeDev.model.Estado;
import com.evoluum.challengeDev.view.AbstractCsvView;
import com.evoluum.challengeDev.view.CsvFactory;
import com.evoluum.challengeDev.view.TypeFile;

import java.util.List;

public class ReportEstadoSalesCsvView extends CsvFactory<Estado> {

    @Override
    public String getName() {
        return "estados";
    }

    @Override
    public TypeFile getTypeFile() {
        return TypeFile.CSV;
    }

    @Override
    public AbstractCsvView<Estado> addInfo(List<Estado> info) {
        info.forEach(estado -> {
            addCabecalho(   "idEstado; " +
                            "siglaEstado; " +
                            "regiaoNome; " +
                            "nomeCidade;" +
                            "nomeMesorregiao; " +
                            "nomeFormatado" );
            addColuna(estado.getId().toString())
                    .addColuna(estado.getSigla())
                    .addColuna(estado.getRegiao().getNome())
                    .addColuna("")
                    .addColuna("")
                    .addColuna(estado.getNomeFormatado())
                    .lineSeparator();
        });
        return this;
    }
}
