package ua.com.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ua.com.magaz.Toy;

public interface ToyDao extends JpaRepository<Toy, Integer> {

//	void save(Commodity commodity);
//	List<Commodity> findAll();
	Toy findOneByName(String name);
//	void delete(String name);
//	@Query("select  c from Commodity c where c.name :=name")
//	Commodity toFindCommodityByName(@Param("name")String name);
	 @Query("select t from Toy t where t.name LIKE CONCAT('%',:search,'%')")
	    List<Toy>searchByName(@Param("search") String search);
	 /*@Query("delete b from Commodity b where b.customer_id ==:id")
	 	void deleteCommodity(@Param("id") int id);*/
	 @Query("select t from Toy t where t.price < :price")
	 List<Toy>sortToysByPrice(@Param("price") double price);
	 @Query("select distinct t from Toy t left join  t.category ar where ar.id =:id")
	 List<Toy>searchByCategory(@Param("id")int id);
	 
	 

}	
