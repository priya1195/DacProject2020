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

import com.app.pojos.CartItems;
import com.app.service.ICartItemsService;

@RestController
@RequestMapping("/cartitems")
public class CartItemsController {
	// dependency
	@Autowired
	private ICartItemsService service;

	public CartItemsController() {
		System.out.println("Constructor of CartItemsController");
	}
	
	@GetMapping
	public ResponseEntity<?> listAllCartItems() {
		System.out.println("in list of all cartItems ");
		List<CartItems> cartItems= service.getAllCartItems();
		if (cartItems.isEmpty())
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);

		return new ResponseEntity<>(cartItems, HttpStatus.OK);
	}

	
	@PostMapping
	public ResponseEntity<?> addCartItems(@RequestBody CartItems c1) {
		System.out.println("in add CartItems " + c1);					
			try {
				CartItems newCartItems = service.addCartItemsDetails(c1);
				return new ResponseEntity<>(newCartItems, HttpStatus.OK);

			} catch (RuntimeException e) {
				e.printStackTrace();
				return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
	}

	// get specific CartItem details
	@GetMapping("/{cartItemsid}")
	public ResponseEntity<?> getCartItemDetails(@PathVariable int cartItemsid) {
		System.out.println("in get CartItems details " + cartItemsid);
		Optional<CartItems> CartItem = service.getCartItemsDetails(cartItemsid);
		if (CartItem.isPresent())
			return ResponseEntity.ok(CartItem.get());

		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	// req handling method to update existing CartItem details
		@PutMapping("/{cartItemId}")
		public ResponseEntity<?> updateCartItemDetails(@PathVariable int cartItemId, @RequestBody CartItems c) {
			System.out.println("in update " + cartItemId + " " + c);
			try {
				CartItems updateDetails = service.updateCartItemDetails(cartItemId, c);
				return new ResponseEntity<>(updateDetails, HttpStatus.OK);
			} catch (RuntimeException e) {
				e.printStackTrace();
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		}

		// delete CartItem details
		@DeleteMapping("/{cartItemId}")
		public ResponseEntity<?> deleteCartItemDetails(@PathVariable int cartItemId) {
			System.out.println("in delete CartItem " + cartItemId);
			Optional<CartItems> cartItem = service.getCartItemsDetails(cartItemId);
			if (cartItem.isPresent()) {
				service.deleteCartItemDetails(cartItemId);
				return new ResponseEntity<>(HttpStatus.OK);
			} else
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		
}
