package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.pojos.User;
import com.app.service.IUserService;

@RestController
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private IUserService userService;

	public AdminController() {
		System.out.println("in ctor of " + getClass().getName() + " " + userService);
	}
	@GetMapping("login/{email}/{password}")
	public ResponseEntity<?> authenticateAdmin(@PathVariable String email, @PathVariable String password) {
		System.out.println("in admin login "+email+" "+password);
		userService.authenticateAdmin(email, password);
		return ResponseEntity.ok(userService.getAllUsers());
	}
	
	@DeleteMapping("delete/{adminEmail}/{adminPassword}/{userId}")
	public ResponseEntity<?> deleteUser(@PathVariable String adminEmail, @PathVariable String adminPassword, @PathVariable int userId) {
		System.out.println("in delete user " + adminEmail + " " + adminPassword);
		userService.authenticateAdmin(adminEmail, adminPassword);
		System.out.println(userId);
		userService.deleteUser(userId);
		return ResponseEntity.ok(HttpStatus.OK);
	}
	
	@PutMapping("changeRole/{adminEmail}/{adminPassword}") 
	public ResponseEntity<?> changeUserRole(@RequestBody User user,@PathVariable String adminEmail, @PathVariable String adminPassword)
	{
		System.out.println("in change user role"+user);
		userService.authenticateAdmin(adminEmail, adminPassword);
		return ResponseEntity.ok(userService.updateUserRole(user));
	}

}
