package com.in28minutes.rest.webservices.restfulwebservices.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonVersoningController {

	@GetMapping("/v1/person")
	public PersonV1 personV1(){
		return (new PersonV1("Alex Ray"));
	}

	@GetMapping("/v2/person")
	public PersonV2 personV2(){
		return (new PersonV2(new Name("Alex", "Ray")));
	}
}
