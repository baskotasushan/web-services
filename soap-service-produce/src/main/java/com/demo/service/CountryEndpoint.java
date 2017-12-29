package com.demo.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.demo.repo.CountryRepository;

import webservice.demo.com.GetCountryRequest;
import webservice.demo.com.GetCountryResponse;


@Endpoint //registers the class with Spring WS as a potential candidate for processing incoming SOAP messages.
public class CountryEndpoint {
	private static final String NAMESPACE_URI = "com.demo.webservice";

	private CountryRepository countryRepository;

	@Autowired
	public CountryEndpoint(CountryRepository countryRepository) {
		this.countryRepository = countryRepository;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getCountryRequest") //is then used by Spring WS to pick the handler method based on the message’s namespace and localPart.
	@ResponsePayload //annotation makes Spring WS map the returned value to the response payload.
	public GetCountryResponse getCountry(@RequestPayload GetCountryRequest request) { //indicates that the incoming message will be mapped to the method’s request parameter.
		GetCountryResponse response = new GetCountryResponse();
		response.setCountry(countryRepository.findCountry(request.getName()));

		return response;
	}
}
