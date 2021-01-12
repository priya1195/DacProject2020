package com.app.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "foods")
public class Food {
//Food_id,Food_name,Food_UnitPrice,Food_category(Veg,Non-Veg),Food_image,Restaurent_id

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "food_id", insertable = false, updatable = false)
	private Integer fid;

	@Column(name = "food_name", length = 30)
	private String name;

	@Column(name = "food_price")
	private double price;

	@Enumerated(EnumType.STRING) // col type varchar (enum constant name)
	@Column(name = "food_category", length = 20)
	private Category category;

	/*
	 * @Lob private byte[] image;
	 */

	@ManyToOne
	@JoinColumn(name = "restaurent_id", nullable = false)
	private Restaurent selectedRestaurent;

	/*
	 * @OneToOne(mappedBy = "food", cascade = CascadeType.ALL) private CartItems
	 * cartItem;
	 */

	public Food() {
		super();
	}

	public Integer getFid() {
		return fid;
	}

	public void setFid(Integer fid) {
		this.fid = fid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	/*
	 * public byte[] getImage() { return image; }
	 * 
	 * public void setImage(byte[] image) { this.image = image; }
	 */
	@JsonBackReference
	public Restaurent getSelectedRestaurent() {
		return selectedRestaurent;
	}

	public void setSelectedRestaurent(Restaurent selectedRestaurent) {
		this.selectedRestaurent = selectedRestaurent;
	}

	/*
	 * @JsonManagedReference public CartItems getCartItem() { return cartItem; }
	 * 
	 * public void setCartItem(CartItems cartItem) { this.cartItem = cartItem; }
	 */

	@Override
	public String toString() {
		return "Food [fid=" + fid + ", name=" + name + ", price=" + price + ", category=" + category
				+ ", selectedRestaurent=" + selectedRestaurent + "]";
	}

}
