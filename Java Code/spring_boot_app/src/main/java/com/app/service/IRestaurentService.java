package com.app.service;

import java.util.List;
import java.util.Optional;

import com.app.pojos.Restaurent;

public interface IRestaurentService {
	// list of all Restaurents
	List<Restaurent> getAllRestaurents();

	// add new Restaurent details
	Restaurent addRestaurentDetails(Restaurent transientPOJO);

	// get specific Restaurent details by id
	Optional<Restaurent> getRestaurentDetails(int id);

	// update existing Restaurent details
	Restaurent updateRestaurentDetails(int restaurentId, Restaurent r1);

	// delete existing Restaurent details
	void deleteRestaurentDetails(int id);
}
