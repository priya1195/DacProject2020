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

import com.app.pojos.Food;
import com.app.service.IFoodService;

@RestController
@RequestMapping("/foods")
public class FoodController {
	// dependency
	@Autowired
	private IFoodService service;

	public FoodController() {
		System.out.println("Constructor of foodController");
	}

	@PostMapping
	public ResponseEntity<?> addFood(@RequestBody Food f1) {
		System.out.println("in add Food " + f1);
		try {
			Food newFood = service.addfoodDetails(f1);
			return new ResponseEntity<>(newFood, HttpStatus.OK);

		} catch (RuntimeException e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping
	public ResponseEntity<?> listAllFoods() {
		System.out.println("in list all foods ");
		List<Food> foods = service.getAllFoods();
		if (foods.isEmpty())
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);

		return new ResponseEntity<>(foods, HttpStatus.OK);
	}

	// get specific food details
	@GetMapping("/{food_id}")
	public ResponseEntity<?> getFoodDetails(@PathVariable int food_id) {
		System.out.println("in get food details " + food_id);
		Optional<Food> food = service.getFoodDetails(food_id);
		if (food.isPresent())
			return ResponseEntity.ok(food.get());

		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	// req handling method to update existing food details
	@PutMapping("/{foodId}")
	public ResponseEntity<?> updateFoodDetails(@PathVariable int foodId, @RequestBody Food f) {
		System.out.println("in update " + foodId + " " + f);
		try {
			Food updateDetails = service.updatefoodDetails(foodId, f);
			return new ResponseEntity<>(updateDetails, HttpStatus.OK);
		} catch (RuntimeException e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	// delete food details
	@DeleteMapping("/{foodId}")
	public ResponseEntity<?> deleteFoodDetails(@PathVariable int foodId) {
		System.out.println("in delete food " + foodId);
		// check if food exists
		Optional<Food> food = service.getFoodDetails(foodId);
		if (food.isPresent()) {
			service.deletefoodDetails(foodId);
			return new ResponseEntity<>(HttpStatus.OK);
		} else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
}
