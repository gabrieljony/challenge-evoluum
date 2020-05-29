package com.evoluum.challengeDev;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class ChallengeDevApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChallengeDevApplication.class, args);
	}

	@Bean
	public RestTemplate rest(RestTemplateBuilder builder) {
		return  new RestTemplate( new HttpComponentsClientHttpRequestFactory() );
	}
}
