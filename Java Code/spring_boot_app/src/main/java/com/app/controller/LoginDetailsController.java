package com.app.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.pojos.LoginDetails;
import com.app.service.ILoginDetailsService;

@RestController
@RequestMapping("/login")
public class LoginDetailsController {
	// dependency
	@Autowired
	private ILoginDetailsService service;

	public LoginDetailsController() {
		System.out.println("Constructor of LoginController");
	}

	@GetMapping
	public ResponseEntity<?> listAllUsers() {
		System.out.println("in list of all users ");
		List<LoginDetails> allLoginDetails = service.getAllLoginDetails();
		if (allLoginDetails.isEmpty())
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);

		return new ResponseEntity<>(allLoginDetails, HttpStatus.OK);
	}

	// get specific User details
	@GetMapping("/{loginid}")
	public ResponseEntity<?> getUserDetails(@PathVariable int loginid) {
		System.out.println("in get User details " + loginid);
		Optional<LoginDetails> loginDetails = service.getLoginDetails(loginid);
		if (loginDetails.isPresent())
			return ResponseEntity.ok(loginDetails.get());

		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	// req handling method to create new User : post
	@PostMapping
	public ResponseEntity<?> addUserDetails(@RequestBody LoginDetails l1) {
		System.out.println("in add user " + l1);
		try {
			LoginDetails addLoginDetails = service.addLoginDetails(l1);
			return new ResponseEntity<>(addLoginDetails, HttpStatus.OK);

		} catch (RuntimeException e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	// req handling method to update existing User details
	@PutMapping("/{userid}")
	public ResponseEntity<?> updateUserDetails(@PathVariable int userid, @RequestBody LoginDetails l1) {
		System.out.println("in update " + userid + " " + l1);
		try {
			LoginDetails updateLoginDetails = service.updateLoginDetails(userid, l1);
			return new ResponseEntity<>(updateLoginDetails, HttpStatus.OK);
		} catch (RuntimeException e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	// delete User details
	@DeleteMapping("/{userId}")
	public ResponseEntity<?> deleteUserDetails(@PathVariable int userId) {
		System.out.println("in delete User " + userId);
		Optional<LoginDetails> loginDetails = service.getLoginDetails(userId);
		if (loginDetails.isPresent()) {
			service.deleteLoginDetails(userId);
			return new ResponseEntity<>(HttpStatus.OK);
		} else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
}
