package com.evoluum.challengeDev.service;

import com.evoluum.challengeDev.model.Estado;
import com.evoluum.challengeDev.model.Municipio;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class EstadoServiceTests {

    private static final UriComponents uri = UriComponentsBuilder.newInstance()
            .scheme("https")
            .host("servicodados.ibge.gov.br")
            .path("api/v1/localidades/estados")
            .build();

    @Autowired
    private RestTemplate restTemplate = new RestTemplate();

    @Test
    public void getAllEstados() throws Exception {
        restTemplate.setRequestFactory(new HttpComponentsClientHttpRequestFactory());
        ResponseEntity<List<Estado>> response = restTemplate.exchange( uri.toString(), HttpMethod.GET, null, new ParameterizedTypeReference<List<Estado>>() {});
        System.out.println( response.getBody() );
        assertTrue(  response.getStatusCode() == HttpStatus.OK);

    }
}
