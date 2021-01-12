package com.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IOrderDao;
import com.app.pojos.Order;

@Service
@Transactional
public class OrderServiceImpl implements IOrderService {
	// dependency
	@Autowired
	private IOrderDao dao;

	@Override
	public List<Order> getAllOrders() {
		return dao.findAll();
	}

	@Override
	public Order addOrderDetails(Order order) {
		return dao.save(order);
	}

	@Override
	public Optional<Order> getOrderDetails(int id) {
		return dao.findById(id);
	}

	@Override
	public Order updateOrderDetails(int orderId, Order o) {
		Optional<Order> findById = dao.findById(orderId);
		Order order = findById.get();
		order.setOrderDate(o.getOrderDate());
		order.setCart(o.getCart());
		order.setTotalBill(o.getTotalBill());
		return order;
	}

	@Override
	public void deleteOrderDetails(int id) {
		dao.deleteById(id);

	}

}
