package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.pojos.Cart;
import com.app.service.ICartService;

@RestController
@RequestMapping("/cart")
public class CartController {
	// dependency
		@Autowired
		private ICartService service;
		
		public CartController() {
			System.out.println("Constructor of CartController");
		}
		
		@PostMapping
		public ResponseEntity<?> assignCustomerCart(@RequestBody Cart c1) {
			System.out.println("assign cart  "+c1 +" "+c1.getCustomer());
			Cart cart = service.addcartDetails(c1);
			if(cart != null)
				return new ResponseEntity<>(HttpStatus.OK);
			
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			
		}
		
		@PutMapping("/{cartId}")
		public ResponseEntity<?> updateCartDetails(@PathVariable int cartId, @RequestBody Cart c) {
			System.out.println("in update " + cartId + " " + c);
			try {
				Cart updateDetails = service.updateCartDetails(cartId, c);
				return new ResponseEntity<>(updateDetails, HttpStatus.OK);
			} catch (RuntimeException e) {
				e.printStackTrace();
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		}
}
