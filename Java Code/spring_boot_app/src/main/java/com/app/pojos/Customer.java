package com.app.pojos;

import javax.persistence.*;
//import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "customers")
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "customer_id", insertable = false, updatable = false)
//	@JsonProperty("id")
	private Integer cid;

//	@NotBlank(message="name must be supplied")
	@Column(name = "customer_name", length = 30)
	private String name;

	@Column(name = "customer_email", length = 30, unique = true) // unique constraint
	private String email;

	@Column(name = "customer_addr", length = 30)
	private String address;

	@OneToOne(mappedBy = "customer", cascade = CascadeType.ALL)
	private Cart cart;

	public Customer() {
		System.out.println("in cnstr of " + getClass().getName());
	}

	public Integer getCid() {
		return cid;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
@JsonManagedReference
	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	@Override
	public String toString() {
		return "Customer [cid=" + cid + ", name=" + name + ", email=" + email + ", address=" + address + "]";
	}

}
