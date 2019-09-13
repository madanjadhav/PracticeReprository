package com.cjc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class CrudConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudConsumerApplication.class, args);
	}
	
	@Bean
	public RestTemplate restTemplate(){
		
		RestTemplate restTemplate=new RestTemplate();
		
		return restTemplate;
	}

}
