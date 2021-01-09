package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.pojos.Cart;
import com.app.service.ICartService;

@RestController
@RequestMapping("/cart")
public class CartController {
	@Autowired
	private ICartService cartService;
	
	public CartController() {
		System.out.println("Constructor of cartController");
	}
	@PostMapping
	public ResponseEntity<?> addCart(@RequestBody Cart cart1) {
		System.out.println("in add cart " + cart1);
		try {
			Cart newCart = cartService.addcartDetails(cart1);			
			return new ResponseEntity<>(newCart, HttpStatus.OK);

		} catch (RuntimeException e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
