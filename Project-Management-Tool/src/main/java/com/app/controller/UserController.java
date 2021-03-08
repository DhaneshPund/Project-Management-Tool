package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.UserDTO;
import com.app.pojos.ProjectDetails;
import com.app.pojos.User;
import com.app.service.IUserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private IUserService userService;
	
	public UserController() {
		System.out.println("in ctor of " + getClass().getName() + " " + userService);
	}
	
	@GetMapping("login/{email}/{password}")
	public ResponseEntity<?> authenticateUser(@PathVariable String email, @PathVariable String password) {
		System.out.println("in get project details "+email+" "+password);
		User user = userService.authenticateUser(email, password);
		if(user==null)
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		System.out.println(user);
		System.out.println(user.getUserProject());
		ProjectDetails projectDetails = user.getUserProject();
		return new ResponseEntity<>(new UserDTO(user,projectDetails),HttpStatus.OK);
	}
	
	@PostMapping("register")
	public ResponseEntity<?> registerUser(@RequestBody User u)
	{
		System.out.println("in register user "+u);
		
		return ResponseEntity.ok(userService.registerUser(u));
		
	}
	
	
	
	
	
	
	
	
	
}
