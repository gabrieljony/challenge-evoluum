package com.evoluum.challengeDev.service;

import com.evoluum.challengeDev.model.Municipio;
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

import java.util.List;

@Service
public class MunicipioService {

    private static final Logger LOG = LoggerFactory.getLogger("");

    private static final UriComponents uri = UriComponentsBuilder.newInstance()
            .scheme("https")
            .host("servicodados.ibge.gov.br")
            .path("api/v1/localidades/estados/{UF}/municipios")
            .build();

    @Autowired
    private RestTemplate restTemplate;

    public List<Municipio> findAll() throws Exception {
        LOG.info("Listagem dos Municipios.");
        ResponseEntity<List<Municipio>> response =
                restTemplate.exchange(
                        uri.toUriString(),
                        HttpMethod.GET,
                        null,
                        new ParameterizedTypeReference<List<Municipio>>() {}) ;
        return response.getBody();
    }

    public List<Municipio> findAll(String sigla) throws Exception {
        ResponseEntity<List<Municipio>> response =
                restTemplate.exchange(
                        uri.toUriString().replace("{UF}", sigla),
                        HttpMethod.GET,
                        null,
                        new ParameterizedTypeReference<List<Municipio>>() {}) ;
        return response.getBody();
    }
}
