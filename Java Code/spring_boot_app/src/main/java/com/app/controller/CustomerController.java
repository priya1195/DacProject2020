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

import com.app.pojos.Customer;
import com.app.service.ICustomerService;

@RestController
@RequestMapping("/customers")
public class CustomerController {
	// dependency
	@Autowired
	private ICustomerService service;

	public CustomerController() {
		System.out.println("Constructor of customerController");
	}

	@GetMapping
	public ResponseEntity<?> listAllCustomers() {
		System.out.println("in list of all customers ");
		List<Customer> customers = service.getAllCustomers();
		if (customers.isEmpty())
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);

		return new ResponseEntity<>(customers, HttpStatus.OK);
	}

	// req handling method to create new customer : post
	@PostMapping
	public ResponseEntity<?> addcustomer(@RequestBody Customer c1) {
		System.out.println("in add customer " + c1);
		try {
			Customer newCustomer = service.addcustomerDetails(c1);
			return new ResponseEntity<>(newCustomer, HttpStatus.OK);

		} catch (RuntimeException e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	// get specific Customer details
	@GetMapping("/{customerid}")
	public ResponseEntity<?> getCustomerDetails(@PathVariable int customerid) {
		System.out.println("in get Customer details " + customerid);
		Optional<Customer> customer = service.getCustomerDetails(customerid);
		if (customer.isPresent())
			return ResponseEntity.ok(customer.get());

		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	// req handling method to update existing Customer details
	@PutMapping("/{customerId}")
	public ResponseEntity<?> updateCustomerDetails(@PathVariable int customerId, @RequestBody Customer c) {
		System.out.println("in update " + customerId + " " + c);
		try {
			Customer updateDetails = service.updateCustomerDetails(customerId, c);
			return new ResponseEntity<>(updateDetails, HttpStatus.OK);
		} catch (RuntimeException e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	// delete Customer details
	@DeleteMapping("/{customerId}")
	public ResponseEntity<?> deleteCustomerDetails(@PathVariable int customerId) {
		System.out.println("in delete Customer " + customerId);
		Optional<Customer> customer = service.getCustomerDetails(customerId);
		if (customer.isPresent()) {
			service.deleteCustomerDetails(customerId);
			return new ResponseEntity<>(HttpStatus.OK);
		} else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
}
