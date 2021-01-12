package com.app.pojos;

import java.time.LocalDate;

import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "orders")
public class Order {
//Order_id,cart_id,order_date,Total_bill
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "customer_id", insertable = false, updatable = false)
	private Integer oid;
	
	@Column(name = "order_date")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate orderDate;
	
	private double totalBill;
	
	@OneToOne
	@JoinColumn(name = "cart_id", nullable = false)
	private Cart cart;

	public Integer getOid() {
		return oid;
	}

	public void setOid(Integer oid) {
		this.oid = oid;
	}

	public LocalDate getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}

	public double getTotalBill() {
		return totalBill;
	}

	public void setTotalBill(double totalBill) {
		this.totalBill = totalBill;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	@Override
	public String toString() {
		return "Order [oid=" + oid + ", orderDate=" + orderDate + ", totalBill=" + totalBill + ", cart=" + cart + "]";
	} 
	
	
}
