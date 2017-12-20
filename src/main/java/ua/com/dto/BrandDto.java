package ua.com.dto;

public class BrandDto {

	private String name;
	private String countryName;
	public BrandDto(String name, String countryName) {
		super();
		this.name = name;
		this.countryName = countryName;
	}
	public BrandDto() {
		super();
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
	
	
}
