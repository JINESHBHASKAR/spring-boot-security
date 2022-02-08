package com.secure.app.controller;

import java.net.URI;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.secure.app.dto.RoleToUserForm;
import com.secure.app.model.Role;
import com.secure.app.model.User;
import com.secure.app.service.UserService;

@RestController
@RequestMapping("/api")
public class UserController {
	
	private Logger log = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UserService userService;

	public UserController() {
	}
	
	@GetMapping("/wish")
	public String getWish() {
		return "Welcome to Spring Security";
	}

	@GetMapping(value = "/user")
	public ResponseEntity<List<User>> getUsers() {
		log.info("inside getUsers() in  UserController");
		return ResponseEntity.ok().body(userService.getUsers());
	}

	@PostMapping(value = "/user/save")
	public ResponseEntity<User> saveUser(@RequestBody User user) {

		log.info("inside saveUsers() in  UserController");
		
		URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/user/save").toUriString());

		return ResponseEntity.created(uri).body(userService.saveUser(user));
	}

	@PostMapping(value = "/role/save")
	public ResponseEntity<Role> saveRole(@RequestBody Role role) {

		log.info("inside saveRole() in  UserController");
		
		URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/role/save").toUriString());

		return ResponseEntity.created(uri).body(userService.saveRole(role));
	}

	@PostMapping(value = "/role/addtouser")
	public ResponseEntity<?> addRoleToUser(@RequestBody RoleToUserForm form) {

		log.info("inside addRoleToUser() in  UserController");
		
		userService.addRoleToUser(form.getUsername(), form.getRoleName());
		return ResponseEntity.ok().build();
	}
	


}
