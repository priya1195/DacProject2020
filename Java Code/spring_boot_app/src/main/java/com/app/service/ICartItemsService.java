package com.app.service;

import java.util.List;
import java.util.Optional;

import com.app.pojos.CartItems;

public interface ICartItemsService {
	// list all CartItems
	List<CartItems> getAllCartItems();

	// add new CartItems details
	CartItems addCartItemsDetails(CartItems transientPOJO);

	// get specific CartItem details by id
	Optional<CartItems> getCartItemsDetails(int id);

	// update existing CartItems details
	CartItems updateCartItemDetails(int cartItemsId, CartItems c1);

	// delete existing CartItem details
	void deleteCartItemDetails(int id);
	

}
