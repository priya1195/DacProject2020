package com.app.pojos;

import javax.persistence.*;

@Entity
@Table(name = "loginDetails")
public class LoginDetails {
	// Id,Email,Password,Role(Customer,Restaurent,Admin)

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id", insertable = false, updatable = false)
	private Integer id;
	
	@Column(name = "user_email", length = 30, unique = true)
	private String email;
	
	@Column(length = 20, unique = true)
	private String password;
	
	@Enumerated(EnumType.STRING)
	@Column(length = 20)
	private Role role;

	public LoginDetails() {
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

	@Override
	public String toString() {
		return "LoginDetails [id=" + id + ", email=" + email + ", password=" + password + ", role=" + role + "]";
	}

	
}
