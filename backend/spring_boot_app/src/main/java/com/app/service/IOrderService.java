package com.app.service;

import java.util.List;
import java.util.Optional;

import com.app.pojos.Order;

public interface IOrderService {
	// list all Orders
	List<Order> getAllOrders();

	// add new Order details
	Order addOrderDetails(Order o);

	// get specific Order details by id
	Optional<Order> getOrderDetails(int id);

	// update existing Order details
	Order updateOrderDetails(int orderId, Order o);

	// delete existing Order details
	void deleteOrderDetails(int id);
}
