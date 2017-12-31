package com.demo.service;

import java.net.URI;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.demo.domain.Person;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class PersonService {

	private final RestTemplate restTemplate;
	
	public PersonService(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}
	
	@HystrixCommand(fallbackMethod = "reliable")
	public Person getPerson() {
		URI uri = URI.create("http://localhost:8080/person");
		
		return this.restTemplate.getForObject(uri, Person.class);
	}
	
	public Person reliable() {
		Person p = new Person();
		p.setId(2);
		p.setName("From Circuit breaker");
		return p;
	}
}
