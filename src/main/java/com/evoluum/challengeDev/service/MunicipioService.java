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

import javax.management.BadAttributeValueExpException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
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

    public List<Municipio> findAll(String sigla) throws Exception {
        Municipio[] municipio = restTemplate.getForObject(
                uri.toUriString().replace("{UF}", sigla), Municipio[].class);

        if(municipio.length > 0) {
            return Arrays.asList(municipio);
        }
        else
            throw new BadAttributeValueExpException("Municipio inválido");

    }

    public List<Municipio> findAll() throws Exception {
        Municipio[] municipio = restTemplate.getForObject("https://servicodados.ibge.gov.br/api/v1/localidades/municipios", Municipio[].class);
        return Arrays.asList(municipio);
    }

    public String getIdPorNomeCidade(final String nome) throws Exception {
        for (Municipio municipio : findAll()) {
            if( municipio.getNome().equals(nome) ) return municipio.getId().toString();
        }
        return "A Cidade " + nome + " não foi localizada em nossa base de dados" ;
    }
}
