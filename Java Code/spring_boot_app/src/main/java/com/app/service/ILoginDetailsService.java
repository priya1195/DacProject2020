package com.app.service;

import java.util.List;
import java.util.Optional;

import com.app.pojos.LoginDetails;

public interface ILoginDetailsService {
	// list all LoginDetails
	List<LoginDetails> getAllLoginDetails();

	// add new Login details
	LoginDetails addLoginDetails(LoginDetails transientPOJO);

	// get specific LoginDetails by id
	Optional<LoginDetails> getLoginDetails(int id);

	// update existing Login details
	LoginDetails updateLoginDetails(int LoginId, LoginDetails l1);

	// delete existing Login details
	void deleteLoginDetails(int Loginid);
}
