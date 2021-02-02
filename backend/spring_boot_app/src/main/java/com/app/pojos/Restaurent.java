package com.app.pojos;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "restaurents")
public class Restaurent {
	// Restaurent_id,Restaurent_name,Restaurent_email,Restaurent_address
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "restaurent_id", insertable = false, updatable = false)
	private Integer rid;

	@Column(name = "restaurent_name", length = 30)
	private String name;

	@Column(name = "restaurent_email", length = 30, unique = true) // unique constraint
	private String email;

	@Column(name = "restaurent_addr", length = 30)
	private String address;

	// bi dir association between Restaurent 1<----->* Food
	// mandatory : if not supplied hibernate throws MappingExc.
	// mappedBy --name of asso property as it appeas in the owning side.
	@OneToMany(mappedBy = "selectedRestaurent",cascade = CascadeType.ALL) 
	private List<Food> foods = new ArrayList<>();

	public Restaurent() {
		super();
	}

	public Integer getRid() {
		return rid;
	}

	public void setRid(Integer rid) {
		this.rid = rid;
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
	public List<Food> getFoods() {
		return foods;
	}

	public void setFoods(List<Food> foods) {
		this.foods = foods;
	}

	@Override
	public String toString() {
		return "Restaurent [rid=" + rid + ", name=" + name + ", email=" + email + ", address=" + address + "]";
	}

}
