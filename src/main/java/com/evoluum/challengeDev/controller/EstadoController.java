package com.evoluum.challengeDev.controller;


import java.util.List;

import com.evoluum.challengeDev.model.Estado;
import com.evoluum.challengeDev.service.EstadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value ="/estados")
public class EstadoController {

	@Autowired
	private EstadoService estadoService;
	
	@RequestMapping(method = RequestMethod.GET)
	@ResponseStatus(code = HttpStatus.OK )
	public ResponseEntity<List<Estado>> exportarJson() throws Exception{
		List<Estado> list = estadoService.findAll();
		return ResponseEntity.ok(list);
	}
	
}
