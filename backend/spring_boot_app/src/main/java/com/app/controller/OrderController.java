package com.app.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.pojos.Order;
import com.app.service.IOrderService;

@RestController
@RequestMapping("/order")
public class OrderController {
	// dependency
	@Autowired
	private IOrderService service;

	public OrderController() {
		System.out.println("Constructor of orderController");
	}

	@GetMapping
	public ResponseEntity<?> listAllOrders() {
		System.out.println("in list of all orders ");
		List<Order> allOrders = service.getAllOrders();
		if (allOrders.isEmpty())
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);

		return new ResponseEntity<>(allOrders, HttpStatus.OK);
	}

	// get specific Order details
	@GetMapping("/{orderid}")
	public ResponseEntity<?> getOrderDetails(@PathVariable int orderid) {
		System.out.println("in get Order details " + orderid);
		Optional<Order> orderDetails = service.getOrderDetails(orderid);
		if (orderDetails.isPresent())
			return ResponseEntity.ok(orderDetails.get());

		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@PostMapping
	public ResponseEntity<?> addorder(@RequestBody Order o1) {
		System.out.println("in add order " + o1);
		try {
			Order addOrderDetails = service.addOrderDetails(o1);
			return new ResponseEntity<>(addOrderDetails, HttpStatus.OK);

		} catch (RuntimeException e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	// req handling method to update existing Order details
	@PutMapping("/{orderId}")
	public ResponseEntity<?> updateOrderDetails(@PathVariable int orderId, @RequestBody Order o1) {
		System.out.println("in update " + orderId + " " + o1);
		try {
			Order updateOrderDetails = service.updateOrderDetails(orderId, o1);
			return new ResponseEntity<>(updateOrderDetails, HttpStatus.OK);
		} catch (RuntimeException e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	// delete Order details
	@DeleteMapping("/{orderId}")
	public ResponseEntity<?> deleteOrderDetails(@PathVariable int orderId) {
		System.out.println("in delete Order " + orderId);
		Optional<Order> orderDetails = service.getOrderDetails(orderId);
		if (orderDetails.isPresent()) {
			service.deleteOrderDetails(orderId);
			return new ResponseEntity<>(HttpStatus.OK);
		} else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
}
