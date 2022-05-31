package com.in28minutes.rest.webservices.restfulwebservices.filtering;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FilteringController {

	@GetMapping("/filtering")
	public SomeBean retrieveSomeBean(){
		return (new SomeBean("Value 01", "Value 02", "Value 03"));
	}

	@GetMapping("/filtering-list")
	public List<SomeBean> retrieveListOfSomeBean(){
		return Arrays.asList(new SomeBean("Value 01", "Value 02", "Value 03"), new SomeBean("Value 11", "Value 12", "Value 13"));
	}
}
