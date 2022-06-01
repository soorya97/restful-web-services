package com.in28minutes.rest.webservices.restfulwebservices.user;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserJPAResource {

	//we can auto wire it, so no need to create a new instance
	@Autowired
	private UserRepository userRepository;

	//findAll - is the default for select *
	@GetMapping("/jpa/users")
	public List<User> retriveAllUsers(){
		return userRepository.findAll();
	}


	//HATEOAS will help us to return links along with the response - EntityModel<User> will be the return type
	@GetMapping("/jpa/users/{id}")
	public EntityModel<User> retriveUser(@PathVariable int id){
		//findById - is the default for select * from TABLE where COLUMN = Value
		Optional<User> foundUser = userRepository.findById(id);
		if(foundUser.isEmpty()){
			//if the user is not found, throw the custom exception with the needed message
			throw (new UserNotFoundException("id-" + id));
		}

		//We must create a enity model on the found user
		//create a WebMvcLinkBuilder, linkTo the medthod of this class and the method that we need
		//[These are static methods that are defined in WebMvcLinkBuilder]
		//model.add(linkToUsers.withRel("all-users")) - will be out custom key message in the response
		//foundUser.get() is the syntax
		EntityModel<User> model = EntityModel.of(foundUser.get());
		WebMvcLinkBuilder linkToUsers = linkTo(methodOn(this.getClass()).retriveAllUsers());
		model.add(linkToUsers.withRel("all-users"));

		return model;
	}
}
