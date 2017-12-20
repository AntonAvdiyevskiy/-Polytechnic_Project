package ua.com.service;

import java.security.Principal;
import java.util.List;



import org.springframework.web.multipart.MultipartFile;
import ua.com.magaz.Toy;


public interface ToyService {

	/*void save(Commodity commodity,MultipartFile image);*/
	void save(Toy toy) throws Exception ;
	List<Toy>getAll();
	Toy getOne(int id);
	void delete(int id);
	List<Toy> searchByName(String search);
	List<Toy> sortToysByPrice(double price);
	public void saveImage(int id, MultipartFile multipartFile);
	List<Toy>searchByCategory(int id);
	
//	public Commodity toFindCommodityByName(String name);
}
