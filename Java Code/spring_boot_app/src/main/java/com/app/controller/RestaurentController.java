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

import com.app.pojos.Restaurent;
import com.app.service.IRestaurentService;

@RestController
@RequestMapping("/restaurents")
public class RestaurentController {
	// dependency
	@Autowired
	private IRestaurentService service;

	public RestaurentController() {
		System.out.println("Constructor of RestaurentController");
	}

	@GetMapping
	public ResponseEntity<?> listAllRestaurents() {
		System.out.println("in list all restaurents ");
		List<Restaurent> restaurents = service.getAllRestaurents();
		if (restaurents.isEmpty())
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);

		return new ResponseEntity<>(restaurents, HttpStatus.OK);
	}

	// req handling method to create new restaurent : post
	@PostMapping
	public ResponseEntity<?> addRestaurent(@RequestBody Restaurent r) {
		System.out.println("in add Restaurent " + r);
		try {
			Restaurent savedRestaurent = service.addRestaurentDetails(r);
			return new ResponseEntity<>(savedRestaurent, HttpStatus.OK);

		} catch (RuntimeException e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	// get specific Restaurent details
	@GetMapping("/{restaurentid}")
	public ResponseEntity<?> getRestaurentDetails(@PathVariable int restaurentid) {
		System.out.println("in get Restaurent details " + restaurentid);
		Optional<Restaurent> restaurent = service.getRestaurentDetails(restaurentid);
		if (restaurent.isPresent())
			return ResponseEntity.ok(restaurent.get());

		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	// req handling method to update existing Restaurent details
	@PutMapping("/{restaurentId}")
	public ResponseEntity<?> updateRestaurentDetails(@PathVariable int restaurentId, @RequestBody Restaurent r) {
		System.out.println("in update " + restaurentId + " " + r);
		try {
			Restaurent updateDetails = service.updateRestaurentDetails(restaurentId, r);
			return new ResponseEntity<>(updateDetails, HttpStatus.OK);
		} catch (RuntimeException e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	// delete Restaurent details
	@DeleteMapping("/{restaurentId}")
	public ResponseEntity<?> deleteRestaurentDetails(@PathVariable int restaurentId) {
		System.out.println("in delete Restaurent " + restaurentId);
		Optional<Restaurent> restaurent = service.getRestaurentDetails(restaurentId);
		if (restaurent.isPresent()) {
			service.deleteRestaurentDetails(restaurentId);
			return new ResponseEntity<>(HttpStatus.OK);
		} else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
}
