package ua.com.dto;

public class CategoryDto {

	private String name;
	public CategoryDto(String name) {
		super();
		this.name = name;
	}
	public CategoryDto() {
		super();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
