package com.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.ICustomerDao;
import com.app.pojos.Customer;

@Service
@Transactional
public class CustomerServiceImpl implements ICustomerService {
	// dependency
	@Autowired
	private ICustomerDao customerDao;
	
	@Override
	public List<Customer> getAllCustomers() {
		return customerDao.findAll();
	}

	@Override
	public Customer addcustomerDetails(Customer transientPOJO) {
		return customerDao.save(transientPOJO);
	}

	@Override
	public Optional<Customer> getCustomerDetails(int id) {
		return customerDao.findById(id);
	}

	@Override
	public Customer updateCustomerDetails(int customertId, Customer c1) {
		Optional<Customer> customer = customerDao.findById(customertId);
		Customer existingCustomer = customer.get();
		existingCustomer.setName(c1.getName());
		existingCustomer.setAddress(c1.getAddress());
		existingCustomer.setEmail(c1.getEmail());
		return existingCustomer;
	}

	@Override
	public void deleteCustomerDetails(int id) {
		customerDao.deleteById(id);
	}

}
