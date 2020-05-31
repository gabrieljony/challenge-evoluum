package com.evoluum.challengeDev.controller;

import com.evoluum.challengeDev.model.Estado;
import com.evoluum.challengeDev.model.Municipio;
import com.evoluum.challengeDev.service.CSVService;
import com.evoluum.challengeDev.service.MunicipioService;
import com.evoluum.challengeDev.view.csv.ReportMunicipioSalesCsvView;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;


@RestController
@RequestMapping(value ="/municipios")
public class MunicipioController {

	@Autowired
	private MunicipioService municipioService;

	@Autowired
	private CSVService csvService;

	@ApiOperation(value="Busca Municipios pela sigla")
	@RequestMapping(value = "/{sigla}", method = RequestMethod.GET)
	@ResponseStatus(code = HttpStatus.OK )
	public ResponseEntity<List<Municipio>> findAll(@PathVariable String sigla) throws Exception{
		List<Municipio> list = municipioService.findAll(sigla);
		return ResponseEntity.ok(list);
	}

	@ApiOperation(value="Busca Municipios pela sigla, retorno no formato .csv")
	@RequestMapping(value = "/csv/{sigla}", method = RequestMethod.GET, produces = "text/csv")
	@ResponseStatus(code = HttpStatus.OK )
	public @ResponseBody void exportarCsv(HttpServletResponse response, @PathVariable String sigla) throws Exception {
		csvService.download( new ReportMunicipioSalesCsvView().addInfo(municipioService.findAll(sigla))) ;
	}

	@ApiOperation(value="Busca pelo ID do municipio, passando o nome do Municipio")
	@RequestMapping(value = "/name/{nomeCidade}", method = RequestMethod.GET)
	@ResponseStatus(code = HttpStatus.OK )
	public ResponseEntity<String> findByIDNameCity(@PathVariable String nomeCidade) throws Exception{
		String cidade = municipioService.getIdPorNomeCidade(nomeCidade);
		return ResponseEntity.ok(cidade);
	}

	@ApiOperation(value="Busca por todos os Municipios")
    @RequestMapping(method = RequestMethod.GET)
    @ResponseStatus(code = HttpStatus.OK )
    public ResponseEntity<List<Municipio>> findAll() throws Exception{
        List<Municipio> list = municipioService.findAll();
        return ResponseEntity.ok(list);
    }

	@ApiOperation(value="Busca por todos os Municipios no formato .csv")
    @RequestMapping(value = "/csv", method = RequestMethod.GET, produces = "text/csv")
    @ResponseStatus(code = HttpStatus.OK )
    public @ResponseBody void exportarCsv(HttpServletResponse response) throws Exception {
        csvService.download( new ReportMunicipioSalesCsvView().addInfo(municipioService.findAll())) ;
    }
	
}
