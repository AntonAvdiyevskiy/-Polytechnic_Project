package ua.com.dto;

import java.util.ArrayList;
import java.util.List;

import ua.com.magaz.Brand;
import ua.com.magaz.Category;
import ua.com.magaz.Customer;
import ua.com.magaz.Toy;


public class DtoUtilMapper {

	public static List<CustomerDto> customerToCustomerDto(List<Customer> customers){
		List<CustomerDto> customerDtos = new ArrayList<CustomerDto>();
		for (Customer customer : customers) {
			CustomerDto customerDto = new CustomerDto();
			customerDto.setLogin(customer.getLogin());
			customerDto.setMail(customer.getMail());
			customerDto.setId(customer.getId());
			customerDtos.add(customerDto);
		}
		return customerDtos;
	}
	


	public static List<CategoryDto> CategoryToCategoryDto(List<Category>categories){
		List<CategoryDto>categoryDtos = new ArrayList<CategoryDto>();
		for(Category category:categories){
			CategoryDto categoryDto = new CategoryDto();
			categoryDto.setName(category.getName());
			categoryDtos.add(categoryDto);
		}
		return categoryDtos;
	}
	public static List<BrandDto>ProducerToProducerDto(List<Brand>brands){
		List<BrandDto>brandDtos = new ArrayList<BrandDto>();
		for(Brand brand:brands){
			BrandDto brandDto = new BrandDto();
			brandDto.setName(brand.getName());
			brandDto.setCountryName(brand.getCountryName());
			brandDtos.add(brandDto);
		}
		return brandDtos;
	}
	public static List<ToyDto> CommodityToCommodity(List<Toy>toys){
		List<ToyDto>toyDtos = new ArrayList<ToyDto>();
		for(Toy toy:toys){
			ToyDto commodityDto = new ToyDto();
			commodityDto.setName(toy.getName());
			commodityDto.setPrice(toy.getPrice());
			commodityDto.setColor(toy.getColor());
			toyDtos.add(commodityDto);
		}
		return toyDtos;
	}
}