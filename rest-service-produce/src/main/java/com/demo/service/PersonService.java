package com.demo.service;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.stereotype.Service;

import com.demo.domain.Address;
import com.demo.domain.Person;

@Service
public class PersonService {

	public Person getPerson() {
		Address homeAddress = new Address();
		homeAddress.setCity("Jhapa");
		homeAddress.setState("Mechi");
		
		Address presentAddress = new Address();
		presentAddress.setCity("Irving");
		presentAddress.setState("Texas");
		
		Person sushan = new Person();
		sushan.setId(1);
		sushan.setName("sushan");
		sushan.setAddress(new ArrayList<>(Arrays.asList(homeAddress,presentAddress)));	
		
		return sushan;
	}
}
