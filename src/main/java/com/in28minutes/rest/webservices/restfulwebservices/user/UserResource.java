package com.in28minutes.rest.webservices.restfulwebservices.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserResource {

	//since this class is managed by spring [as we annotated it with @Controller]
	//we can auto wire it, so no need to create a new instance
	@Autowired
	private UserServiceDAO service;

	//GET /users
	//mentioning path is not needed as it is the default agrument
	@GetMapping("/users")
	public List<User> retriveAllUsers(){
		return service.findAll();
	}

	//GET /users/{id}
	//mentioning path is not needed as it is the default agrument
	@GetMapping("/users/{id}")
	public User retriveUser(@PathVariable int id){
		return service.findOne(id);
	}
}
