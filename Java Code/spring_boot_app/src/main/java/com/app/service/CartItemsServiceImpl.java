package com.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.ICartItemsDao;
import com.app.pojos.CartItems;

@Service
@Transactional
public class CartItemsServiceImpl implements ICartItemsService {
	// dependency
	@Autowired
	private ICartItemsDao dao;

	@Override
	public List<CartItems> getAllCartItems() {
		return dao.findAll();
	}

	@Override
	public CartItems addCartItemsDetails(CartItems item) {
		return dao.save(item);

	}

	@Override
	public Optional<CartItems> getCartItemsDetails(int id) {
		return dao.findById(id);
	}

	@Override
	public CartItems updateCartItemDetails(int cartItemsId, CartItems c1) {
		Optional<CartItems> findById = dao.findById(cartItemsId);
		CartItems cartItems = findById.get();
		cartItems.setQuantity(c1.getQuantity());
		cartItems.setFood(c1.getFood());
		cartItems.setCart(c1.getCart());
		return null;
	}

	@Override
	public void deleteCartItemDetails(int id) {
		dao.deleteById(id);

	}


	
}
