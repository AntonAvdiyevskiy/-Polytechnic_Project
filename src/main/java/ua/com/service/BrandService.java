package ua.com.service;

import java.util.List;

import ua.com.magaz.Brand;

public interface BrandService {
	void save(Brand brand) throws Exception;
	List<Brand>getAll();
	Brand getOne(int id);
	void delete(int id);
	
	
}
