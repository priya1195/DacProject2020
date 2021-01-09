package com.app.service;

import java.util.List;
import java.util.Optional;

import com.app.pojos.Customer;

public interface ICustomerService {
	// list all customers
	List<Customer> getAllCustomers();

	// add new Customer details
	Customer addcustomerDetails(Customer transientPOJO);

	// get specific Customer details by id
	Optional<Customer> getCustomerDetails(int id);

	// update existing Customer details
	Customer updateCustomerDetails(int customertId, Customer c1);

	// delete existing Customer details
	void deleteCustomerDetails(int id);
}
