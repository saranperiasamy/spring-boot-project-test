package com.saran.spring.restful.restfulweb201.contoller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.saran.spring.restful.restfulweb201.entity.User;
import com.saran.spring.restful.restfulweb201.exception.UserNotFoundException;
import com.saran.spring.restful.restfulweb201.service.UserService;

@RestController
public class UserContoller {

	@Autowired
	UserService userService;
	
	@Autowired
	MessageSource messageSource;

	@GetMapping("/users")
	public List<User> retriveAllUsers() {
		return userService.getAllUsers();
	}

	@GetMapping("/users/{id}")
	public User retriveUser(@PathVariable int id) {
	
		User user = userService.getUser(id);
		if (user == null) {
			throw new UserNotFoundException("UserNotFound: " + id);
		}
		return user;
	}

	@PostMapping("/users")
	public ResponseEntity<Object> addUser(@Valid @RequestBody User newUser) {
		User user = userService.save(newUser);

		if (user == null) {
			return ResponseEntity.noContent().build();
		}
		// /users/.{id} --> path and buildAndExpand

		System.out.println(ServletUriComponentsBuilder.fromCurrentRequest());
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId())
				.toUri();
		// URI location =
		// ServletUriComponentsBuilder.fromCurrentRequest().build().toUri();
		return ResponseEntity.created(location).build();
	}
	
	@DeleteMapping("/users/{id}")
	public void deleteUser(@PathVariable int id) {
	
		User user = userService.deleteUser(id);
		if (user == null) {
			throw new UserNotFoundException("UserNotFound: " + id);
		}
	}
	
	@GetMapping("/hello-world")
	public String helloWorldI18n() {
		return messageSource.getMessage("welcome.message", null, LocaleContextHolder.getLocale());
	}
}
