package com.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.ICartDao;
import com.app.pojos.Cart;

@Service
@Transactional
public class CartServiceImpl implements ICartService {
	// dependency
	@Autowired
	private ICartDao dao;

	@Override
	public Cart addcartDetails(Cart transientPOJO) {
		return dao.save(transientPOJO);
	}

}
