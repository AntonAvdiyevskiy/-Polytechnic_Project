package ua.com.magaz;




import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@Entity
public class Toy {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private int id;
	private String name;
	private String color;
	private double price;
	private String commodityImage;
	private double rating;
	public double getRating() {
		return rating;
	}



	public void setRating(double rating) {
		this.rating = rating;
	}



	@ManyToOne
	private Category category;
	@ManyToOne
	private Brand brand;
	/*@ManyToMany
	@JoinTable(name="commodity_order",joinColumns=@JoinColumn(name="commodity_id"),inverseJoinColumns=@JoinColumn(name="order_id"))
	private List<Orders> orders;*/
	@ManyToOne
	Customer customer;
	
	

	public String getCommodityImage() {
		return commodityImage;
	}



	public void setCommodityImage(String commodityImage) {
		this.commodityImage = commodityImage;
	}

	
	


	public Customer getCustomer() {
		return customer;
	}



	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Toy() {
	
	}

public Toy(int id, String name, String color, double price, String commodityImage, Category category, Brand brand,
			Customer customer) {
		super();
		this.id = id;
		this.name = name;
		this.color = color;
		this.price = price;
		this.commodityImage = commodityImage;
		this.category = category;
		this.brand = brand;
		this.customer = customer;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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


	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}



	public Category getCategory() {
		return category;
	}



	public void setCategory(Category category) {
		this.category = category;
	}



	public Brand getBrand() {
		return brand;
	}



	public void setBrand(Brand brand) {
		this.brand = brand;
	}



	
	
	
	
	
	
	
}
