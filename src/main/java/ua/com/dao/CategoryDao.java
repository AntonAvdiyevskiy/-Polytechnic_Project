package ua.com.dao;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ua.com.magaz.Category;


public interface CategoryDao extends JpaRepository<Category, Integer> {

//	void save(CategoryOfCommodity categoryOfCommodity);
//	List<CategoryOfCommodity> findAll();
//	CategoryOfCommodity findOneByName(String name);
//	void delete(String name);
	Category findByName(String name);
	@Query("select distinct c from Category c left join fetch c.toys")
	List<Category>findCategoryWithToys();
	@Query("select distinct c from Category c left join fetch c.toys where c.id =:id")
	Category findCategoryWithCommodity(@Param("id") int id);
}
