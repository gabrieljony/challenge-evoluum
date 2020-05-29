package com.evoluum.challengeDev.service;

import java.util.List;

import com.evoluum.challengeDev.model.Estado;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class EstadoService {

	private static final Logger LOG = LoggerFactory.getLogger("");

	private static final UriComponents uri = UriComponentsBuilder.newInstance()
			.scheme("https")
			.host("servicodados.ibge.gov.br")
			.path("api/v1/localidades/estados")
			.build();

	@Autowired
	private RestTemplate restTemplate;


	public List<Estado> findAll() throws Exception {
		LOG.info("Listagem dos Estados.");
		ResponseEntity<List<Estado>> response =
				restTemplate.exchange(
						uri.toUriString(),
						HttpMethod.GET,
						null,
						new ParameterizedTypeReference<List<Estado>>() {}) ;
		return response.getBody();
	}
		
	public String getIdByNameCity(final String nome) throws Exception {
		LOG.info("Busca pelo nome da cidade com retorno do ID.");
		for (Estado estado : findAll()) {
			 if(estado.getNome().equals(nome)) return estado.getId();
		}
		return "City Not found";
	}

}
