package com.app.pojos;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "cartitems")
public class CartItems {
//CartItemid,cart_id,Food_id,Food_qty,Food_UnitPrice
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cartItem_id", insertable = false, updatable = false)
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "cart_id", nullable = false)
	private Cart cart;

	/*
	 * @OneToOne
	 * 
	 * @JoinColumn(name = "food_id", nullable = false) private Food food;
	 */
	
	@Column(name = "food_qty")
	private int quantity;

	public CartItems() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@JsonBackReference
	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}
	
	/*
	 * @JsonBackReference public Food getFood() { return food; }
	 * 
	 * public void setFood(Food food) { this.food = food; }
	 */

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "CartItems [id=" + id + ", cart=" + cart + ", quantity=" + quantity + "]";
	}
	
	
}
