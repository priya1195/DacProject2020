package com.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IFoodDao;
import com.app.pojos.Food;

@Service
@Transactional
public class FoodServiceImpl implements IFoodService {
	// dependency
	@Autowired
	private IFoodDao dao;

	@Override
	public Food addfoodDetails(Food transientPOJO) {
		return dao.save(transientPOJO);
	}

	@Override
	public List<Food> getAllFoods() {
		return dao.findAll();
	}

	@Override
	public Optional<Food> getFoodDetails(int id) {
		return dao.findById(id);
	}

	@Override
	public Food updatefoodDetails(int foodId, Food food1) {
		Optional<Food> f = dao.findById(foodId);
		Food existingfood = f.get();
		existingfood.setName(food1.getName());
		existingfood.setPrice(food1.getPrice());
		existingfood.setCategory(food1.getCategory());
		return existingfood;
	}

	@Override
	public void deletefoodDetails(int id) {
		dao.deleteById(id);
	}

}
