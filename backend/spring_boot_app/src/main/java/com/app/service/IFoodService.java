package com.app.service;

import java.util.List;

import com.app.pojos.Food;
import java.util.Optional;

public interface IFoodService {

	// add new Food details
	Food addfoodDetails(Food transientPOJO);

	// list all products
	List<Food> getAllFoods();

	// get specific food details by id
	Optional<Food> getFoodDetails(int id);

	// update existing food details
	Food updatefoodDetails(int foodId, Food food1);
	
	//delete existing food details
	void deletefoodDetails(int id);

}
