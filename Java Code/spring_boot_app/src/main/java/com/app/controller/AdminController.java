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

import com.app.pojos.Admin;
import com.app.service.IAdminService;

@RestController
@RequestMapping("/admin")
public class AdminController {
	// dependency
	@Autowired
	private IAdminService service;

	public AdminController() {
		System.out.println("Constructor of AdminController");
	}

	@GetMapping
	public ResponseEntity<?> listAllAdmin() {
		System.out.println("in list of all admin ");
		List<Admin> allAdminDetails = service.getAllAdminDetails();
		if (allAdminDetails.isEmpty())
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);

		return new ResponseEntity<>(allAdminDetails, HttpStatus.OK);
	}

	// get specific Admin details
	@GetMapping("/{adminId}")
	public ResponseEntity<?> getAdminDetails(@PathVariable int adminId) {
		System.out.println("in get Admin details " + adminId);
		Optional<Admin> adminDetails = service.getAdminDetails(adminId);
		if (adminDetails.isPresent())
			return ResponseEntity.ok(adminDetails.get());

		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	// req handling method to create new Admin : post
	@PostMapping
	public ResponseEntity<?> addAdminDetails(@RequestBody Admin a1) {
		System.out.println("in add admin " + a1);
		try {
			Admin addAdminDetails = service.addAdminDetails(a1);
			return new ResponseEntity<>(addAdminDetails, HttpStatus.OK);

		} catch (RuntimeException e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	// req handling method to update existing Admin details
	@PutMapping("/{adminId}")
	public ResponseEntity<?> updateAdminDetails(@PathVariable int adminId, @RequestBody Admin a1) {
		System.out.println("in update " + adminId + " " + a1);
		try {
			Admin updateAdminDetails = service.updateAdminDetails(adminId, a1);
			return new ResponseEntity<>(updateAdminDetails, HttpStatus.OK);
		} catch (RuntimeException e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	// delete Admin details
	@DeleteMapping("/{adminId}")
	public ResponseEntity<?> deleteAdminDetails(@PathVariable int adminId) {
		System.out.println("in delete Admin " + adminId);
		Optional<Admin> adminDetails = service.getAdminDetails(adminId);
		if (adminDetails.isPresent()) {
			service.deleteAdminDetails(adminId);
			return new ResponseEntity<>(HttpStatus.OK);
		} else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
}
