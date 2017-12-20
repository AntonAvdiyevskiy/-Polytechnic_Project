package ua.com.service;

import java.util.List;

import ua.com.magaz.Category;


public interface CategoryService {

	void save(Category category) throws Exception;
	List<Category> findAll();
	Category findOneByName(int id);
	void delete(int id);
	
	void deleteToyFromCategory(String idCommodity);
	List<Category> findCategoryWithToys();
	void saveAndFlush(Category category);
} 
