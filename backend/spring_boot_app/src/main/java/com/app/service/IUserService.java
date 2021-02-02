package com.app.service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import com.app.pojos.User;

public interface IUserService {
	// list all User Details
	List<User> getAllUserDetails();

	// add new User details
	User addUserDetails(User transientPOJO);

	// get specific User Details by id
	Optional<User> getUserDetails(int id);

	// update existing User details
	User updateUserDetails(int LoginId, User l1);

	// delete existing User details
	void deleteUserDetails(int Loginid);
	
	User fetchUserByEmailAndPassword(String email,String password);

    Collection<User> findByRole(String role);
    
    
}
