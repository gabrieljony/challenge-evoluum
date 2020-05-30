package com.evoluum.challengeDev.controller;

import com.evoluum.challengeDev.model.Municipio;
import com.evoluum.challengeDev.service.MunicipioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value ="/municipios")
public class MunicipioController {

	@Autowired
	private MunicipioService municipioService;

	@RequestMapping(value = "/{sigla}", method = RequestMethod.GET)
	@ResponseStatus(code = HttpStatus.OK )
	public ResponseEntity<List<Municipio>> findAll(@PathVariable String sigla) throws Exception{
		List<Municipio> list = municipioService.findAll(sigla);
		return ResponseEntity.ok(list);
	}
	
}
