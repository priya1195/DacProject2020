package com.app.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.pojos.User;
import com.app.service.IUserService;

@RestController
@CrossOrigin
public class UserController {
	// dependency
	@Autowired
	private IUserService service;

	public UserController() {
		System.out.println("Constructor of LoginController");
	}

	@GetMapping("/login")
	public ResponseEntity<?> listAllUsers() {
		System.out.println("in list of all users ");
		List<User> allLoginDetails = service.getAllUserDetails();
		if (allLoginDetails.isEmpty())
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);

		return new ResponseEntity<>(allLoginDetails, HttpStatus.OK);
	}

	// get specific User details
	@GetMapping("/login/{loginid}")
	public ResponseEntity<?> getUserDetails(@PathVariable int loginid) {
		System.out.println("in get User details " + loginid);
		Optional<User> loginDetails = service.getUserDetails(loginid);
		if (loginDetails.isPresent())
			return ResponseEntity.ok(loginDetails.get());

		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	// req handling method to create new User : post
	@PostMapping("/register")
	public ResponseEntity<?> addUserDetails(@RequestBody User l1) {
		System.out.println("in add user " + l1);
		try {
			User addLoginDetails = service.addUserDetails(l1);
			return new ResponseEntity<>(addLoginDetails, HttpStatus.OK);

		} catch (RuntimeException e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	// req handling method to update existing User details
	@PutMapping("/login/{userid}")
	public ResponseEntity<?> updateUserDetails(@PathVariable int userid, @RequestBody User l1) {
		System.out.println("in update " + userid + " " + l1);
		try {
			User updateLoginDetails = service.updateUserDetails(userid, l1);
			return new ResponseEntity<>(updateLoginDetails, HttpStatus.OK);
		} catch (RuntimeException e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	// delete User details
	@DeleteMapping("/login/{userId}")
	public ResponseEntity<?> deleteUserDetails(@PathVariable int userId) {
		System.out.println("in delete User " + userId);
		Optional<User> loginDetails = service.getUserDetails(userId);
		if (loginDetails.isPresent()) {
			service.deleteUserDetails(userId);
			return new ResponseEntity<>(HttpStatus.OK);
		} else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody User user){
		String tempEmailId= user.getEmail();
		String tempPassword= user.getPassword();		
		User userObj=null;
		if(tempEmailId!=null && tempPassword !=null) {
			userObj=service.fetchUserByEmailAndPassword(tempEmailId, tempPassword);
		}
		
		if(userObj==null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(userObj, HttpStatus.OK);
	}
}
