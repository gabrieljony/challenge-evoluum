package com.evoluum.challengeDev.controller;


import com.evoluum.challengeDev.model.Estado;
import com.evoluum.challengeDev.service.MunicipioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping(value ="/municipios")
public class MunicipioController {

	@Autowired
	private MunicipioService municipioService;
	
	@RequestMapping(method = RequestMethod.GET)
	@ResponseStatus(code = HttpStatus.OK )
	public ResponseEntity<List<Estado>> findAll() throws Exception{
		List<Estado> list = municipioService.findAll();
		return ResponseEntity.ok(list);
	}
	
}
