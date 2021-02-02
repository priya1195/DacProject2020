
package com.app.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "cartitems")
public class CartItems {
	// CartItemid,cart_id,Food_id,Food_qty,Food_UnitPrice

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cartItem_id", insertable = false, updatable = false)
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "cart_id", nullable = false)
	private Cart cart;

	@OneToOne
	@JoinColumn(name = "food_id", nullable = false)
	private Food food;

	@Column(name = "food_qty")
	private int quantity;

	@Column(name="food_Price")
	private double price;
	
	public CartItems() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	//@JsonBackReference
	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

//	@JsonBackReference
	public Food getFood() {
		return food;
	}

	public void setFood(Food food) {
		this.food = food;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	
	public double getPrice() {
		return price;
	}

	public void setPrice(double unitPrice) {
		this.price = unitPrice;
	}

	@Override
	public String toString() {
		return "CartItems [id=" + id + ", cart=" + cart + ", quantity=" + quantity + "]";
	}

}
