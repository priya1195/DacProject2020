package com.app.service;

import java.util.Optional;

import com.app.pojos.Cart;

public interface ICartService {
	// add new cart
	Cart addcartDetails(Cart c1);

	// get specific Cart details by id
	Optional<Cart> getCartDetails(int id);

	// update existing Cart details
	Cart updateCartDetails(int cartId, Cart c1);

	// delete existing Cart details
	void deleteCartDetails(int id);
}
