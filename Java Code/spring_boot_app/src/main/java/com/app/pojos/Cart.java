package com.app.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "cart")
public class Cart {
//cart_id,Customer_id,totalamt

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(insertable = false, updatable = false)
	private Integer cartId;

	private double totalAmt;

	@OneToOne
	@JoinColumn(name = "customer_id", nullable = false)
	private Customer customer;

	/*
	 * @OneToMany(mappedBy = "cart",cascade = CascadeType.ALL) private
	 * List<CartItems> cartItems = new ArrayList<>();
	 */

	public Cart() {
		super();
	}

	public Integer getCartId() {
		return cartId;
	}

	public void setCartId(Integer cartId) {
		this.cartId = cartId;
	}

	public double getTotalAmt() {
		return totalAmt;
	}

	public void setTotalAmt(double totalAmt) {
		this.totalAmt = totalAmt;
	}

	@JsonBackReference
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "Cart [cartId=" + cartId + ", totalAmt=" + totalAmt + ", customer=" + customer + "]";
	}

	/*
	 * @JsonManagedReference public List<CartItems> getCartItems() { return
	 * cartItems; }
	 * 
	 * public void setCartItems(List<CartItems> cartItems) { this.cartItems =
	 * cartItems; }
	 */

}
