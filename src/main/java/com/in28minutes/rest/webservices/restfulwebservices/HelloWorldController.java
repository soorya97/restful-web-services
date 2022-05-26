package com.in28minutes.rest.webservices.restfulwebservices;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//First thing to do, Say to the Spring that this is a Controller
@RestController
public class HelloWorldController {

	//GET method
	//URI - /hello-world
	//method that returns "Hello World"
	//@RequestMapping(method = RequestMethod.GET, path = "/hello-world")
	@GetMapping(path = "/hello-world")
	public String helloWorld(){
		return "Hello World";
	}

	//bean that returns "Hello World"
	@GetMapping(path = "/hello-world-bean")
	public HelloWorldBean helloWorldBean(){
		return (new HelloWorldBean("Hello World"));
	}
}