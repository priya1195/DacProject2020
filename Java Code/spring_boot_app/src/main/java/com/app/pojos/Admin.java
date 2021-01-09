package com.app.pojos;

import javax.persistence.*;

public class Admin {
	//Admin_id,Admin_name,Admin_email,Admin_address
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "admin_id", insertable = false, updatable = false)
	private Integer id;

	@Column(name = "admin_name", length = 30)
	private String name;

	@Column(name = "admin_email", length = 30, unique = true) // unique constraint
	private String email;

	@Column(name = "admin_addr", length = 30)
	private String address;

	public Admin() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	@Override
	public String toString() {
		return "Admin [id=" + id + ", name=" + name + ", email=" + email + ", address=" + address + "]";
	}
	
	
}
