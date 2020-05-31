package com.evoluum.challengeDev.controller;


import java.util.List;

import com.evoluum.challengeDev.view.csv.ReportEstadoSalesCsvView;
import com.evoluum.challengeDev.model.Estado;
import com.evoluum.challengeDev.service.CSVService;
import com.evoluum.challengeDev.service.EstadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;


@RestController
@RequestMapping(value ="/estados")
public class EstadoController {

	@Autowired
	private EstadoService estadoService;

	@Autowired
	private CSVService csvService;
	
	@RequestMapping(method = RequestMethod.GET)
	@ResponseStatus(code = HttpStatus.OK )
	public ResponseEntity<List<Estado>> findAll() throws Exception{
		List<Estado> list = estadoService.findAll();
		return ResponseEntity.ok(list);
	}

	@RequestMapping(value = "/csv", method = RequestMethod.GET, produces = "text/csv")
	@ResponseStatus(code = HttpStatus.OK )
	public @ResponseBody void exportarCsv(HttpServletResponse response) throws Exception {
		csvService.download( new ReportEstadoSalesCsvView().addInfo(estadoService.findAll())) ;
	}
	
}
