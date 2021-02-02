
package com.app.dao;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojos.Cart;
import com.app.pojos.CartItems;

public interface ICartItemsDao extends JpaRepository<CartItems, Integer> {
	Collection<CartItems> findByCart(Cart cart);
}
