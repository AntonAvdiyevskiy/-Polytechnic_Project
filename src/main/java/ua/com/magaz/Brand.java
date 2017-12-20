package ua.com.magaz;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@Entity
public class Brand{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name="name_of_brand")
	private String name;
	private double rating;
	@Column(name="country")
	private String countryName;
	
	@OneToMany(mappedBy = "brand",fetch = FetchType.LAZY)
	private List<Toy>toys;
	public Brand() {
		super();
	}
	public Brand( String name, String countryName) {
		super();
		
		this.name = name;
		this.countryName = countryName;
		
	}
	public double getRating() {
		return rating;
	}
	public void setRating(double rating) {
		this.rating = rating;
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
	public String getCountryName() {
		return countryName;
	}
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
	public List<Toy> getToys() {
		return toys;
	}
	public void setToys(List<Toy> toys) {
		this.toys = toys;
	}
	@Override
	public String toString() {
		return "producer - "+name;
	}
	
	
	
	
	
	
	
}
