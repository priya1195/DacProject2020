package com.app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.ICartDao;
import com.app.dao.ICustomerDao;
import com.app.pojos.Cart;
import com.app.pojos.Customer;

@Service
@Transactional
public class CartServiceImpl implements ICartService {
	// dependency
	@Autowired
	private ICartDao dao;
	@Autowired
	private ICustomerDao customerDao;

	@Override
	public Cart addcartDetails(Cart cart) {
		Optional<Customer> customer = customerDao.findById(cart.getCustomer().getCid());
		if (customer.isPresent()) {
			Customer existingCustomer = customer.get();
			Cart c1 = existingCustomer.getCart();
			if (c1 == null) {
				cart.setCustomer(existingCustomer);
				return dao.save(cart);
			}
		}
		return null;
	}


	@Override
	public Cart updateCartDetails(int cartId, Cart c1) {
		Optional<Cart> cart = dao.findById(cartId);
		Cart existingCart = cart.get();
		existingCart.setCustomer(c1.getCustomer());
		existingCart.setTotalAmt(c1.getTotalAmt());
		return existingCart;
	}


	@Override
	public Optional<Cart> getCartDetails(int id) {
		return dao.findById(id);
	}
	
	@Override
	public void deleteCartDetails(int id) {
		dao.deleteById(id);

	}

}
