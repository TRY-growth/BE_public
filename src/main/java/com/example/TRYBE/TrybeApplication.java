package com.example.TRYBE;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class TrybeApplication {

	public static void main(String[] args) {
		SpringApplication.run(TrybeApplication.class, args);
	}
	@Value("${openai.secret-key}")
	private String gptKey;

	@Bean
	public RestTemplate restTemplate(){
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.getInterceptors().add((((request, body, execution) ->{
			request.getHeaders().add("Authorization",
					"Bearer "+ gptKey );
			return execution.execute(request, body);
		} )));
		return restTemplate;
	}
}