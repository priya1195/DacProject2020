package com.app.service;

import java.util.List;
import java.util.Optional;

import com.app.pojos.Admin;

public interface IAdminService {
	    // list all Admin
		List<Admin> getAllAdminDetails();

		// add new Admin details
		Admin addAdminDetails(Admin transientPOJO);

		// get specific Admin by id
		Optional<Admin> getAdminDetails(int id);

		// update existing Admin details
		Admin updateAdminDetails(int id, Admin a1);

		// delete existing Admin details
		void deleteAdminDetails(int id);
}
