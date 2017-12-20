package ua.com.dto;

public class ToyDto {

	private int id;
	
	private String name;
	private String color;
	private double price;
	//private LocalDate dateOfProducing;
	private int ageOfProduction;
	public ToyDto(String name, String color, double price, int ageOfProduction) {
		super();
		this.name = name;
		this.color = color;
		this.price = price;
		this.ageOfProduction = ageOfProduction;
	}
	public ToyDto() {
		super();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getAgeOfProduction() {
		return ageOfProduction;
	}
	public void setAgeOfProduction(int ageOfProduction) {
		this.ageOfProduction = ageOfProduction;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
}
