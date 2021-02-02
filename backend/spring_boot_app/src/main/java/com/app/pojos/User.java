package com.app.pojos;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "loginDetails")
public class User {
	// Id,Email,Password,Role(Customer,Restaurent,Admin),address,name

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id", insertable = false, updatable = false)
	private Integer id;
	
	@Email
	@NotBlank
	@Column(name = "user_email", length = 30, unique = true)
	private String email;
	
	@NotBlank
	@Column(length = 20, unique = true)
	private String password;
	
	@Column(name = "user_name", length = 30)
	private String name;
	
	@NotBlank
	@Column(name = "user_addr", length = 30)
	private String address;
	
	@Enumerated(EnumType.STRING)
	@Column(length = 20)
	private Role role;

	public User() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", email=" + email + ", password=" + password + ", name=" + name + ", address="
				+ address + ", role=" + role + "]";
	}

	/*
	 * @Override public String toString() { return "LoginDetails [id=" + id +
	 * ", email=" + email + ", password=" + password + ", role=" + role + "]"; }
	 */

	
}
