package com.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IRestaurentDao;
import com.app.pojos.Restaurent;

@Service
@Transactional
public class RestaurentServiceImpl implements IRestaurentService {

	// dependency
	@Autowired
	private IRestaurentDao dao;

	@Override
	public List<Restaurent> getAllRestaurents() {
		return dao.findAll();
	}

	@Override
	public Restaurent addRestaurentDetails(Restaurent transientPOJO) {
		return dao.save(transientPOJO);
	}

	@Override
	public Optional<Restaurent> getRestaurentDetails(int id) {
		return dao.findById(id);
	}

	@Override
	public Restaurent updateRestaurentDetails(int restaurentId, Restaurent r1) {
		Optional<Restaurent> restaurent = dao.findById(restaurentId);
		Restaurent existingRestaurent = restaurent.get();
		existingRestaurent.setName(r1.getName());
		existingRestaurent.setAddress(r1.getAddress());
		existingRestaurent.setEmail(r1.getEmail());;
		return existingRestaurent;
	}

	@Override
	public void deleteRestaurentDetails(int id) {
		dao.deleteById(id);
	}

	
}
