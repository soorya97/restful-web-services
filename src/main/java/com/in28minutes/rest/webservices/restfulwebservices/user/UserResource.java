package com.in28minutes.rest.webservices.restfulwebservices.user;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
		User foundUser = service.findOne(id);
		if(foundUser == null){
			//if the user is not found, throw the custom exception with the needed message
			throw (new UserNotFoundException("id-" + id));
		}

		return foundUser;
	}

	//POST /users
	//response code must be - CREATED
	//input - details of user
	//output - CREATED status & return the created URI
	@PostMapping("/users")
	public ResponseEntity<Object> createUser(@RequestBody User user){
		User savedUser = service.save(user);

		// /user/{id} must be the URI of the newly created user
		URI savedUserLocation = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getUserID()).toUri();
		return ResponseEntity.created(savedUserLocation).build();
	}
}
