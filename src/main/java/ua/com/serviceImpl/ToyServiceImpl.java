package ua.com.serviceImpl;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import ua.com.dao.ToyDao;
import ua.com.magaz.Customer;
import ua.com.magaz.Toy;
import ua.com.service.ToyService;
import ua.com.validation.Validator;

@Service("toyService")
public class ToyServiceImpl implements ToyService {

	@Autowired
	private ToyDao toyDao;
	@Autowired
	@Qualifier("toyValidator")
	private Validator validator;
	@Transactional
	/*public void save(Commodity commodity,MultipartFile image) {
		// TODO Auto-generated method stub
		
		commodityDao.saveAndFlush(commodity);
		String path = System.getProperty("catalina.home") + "/resources/" + commodity.getName() + "/"
				+ image.getOriginalFilename();

		commodity.setCommodityImage("resources/" + commodity.getName() + "/" + image.getOriginalFilename());

		File file = new File(path);

		try {
			file.mkdirs();
			try {
				FileUtils.cleanDirectory(
						new File(System.getProperty("catalina.home") + "/resources/" + commodity.getName() + "/"));
			} catch (IOException e) {
				e.printStackTrace();
			}
			image.transferTo(file);
		} catch (IOException e) {
			System.out.println("error with file");
		}
	}*/

	public List<Toy> getAll() {
		// TODO Auto-generated method stub
		return toyDao.findAll();
	}

	public Toy getOne(int id) {
		// TODO Auto-generated method stub
		return toyDao.findOne(id);
	}

	public void delete(int id) {
		// TODO Auto-generated method stub
		toyDao.delete(id);
	}

	public List<Toy> searchByName(String search) {
		// TODO Auto-generated method stub
		return toyDao.searchByName(search);
	}

	public List<Toy> sortToysByPrice(double price) {
		// TODO Auto-generated method stub
		return toyDao.sortToysByPrice(price);
		
	}
	public void save(Toy toy) throws Exception {
		// TODO Auto-generated method stub
		validator.validate(toy);
		toyDao.save(toy);
	}

	public void saveImage(int id, MultipartFile multipartFile) {
		// TODO Auto-generated method stub
		Toy toy = toyDao.findOne(id);

	    String path = System.getProperty("catalina.home") + "/resources/"
	            + toy.getName() + "/" + multipartFile.getOriginalFilename();

	    toy.setCommodityImage("resources/" + toy.getName() + "/" + multipartFile.getOriginalFilename());

	    File file = new File(path);

	    try {
	        file.mkdirs();
	        /*try {
	            FileUtils.cleanDirectory
	                    (new File(System.getProperty("catalina.home") + "/resources/" + customer.getLogin() + "/"));
	        } catch (IOException e) {
	            e.printStackTrace();
	        }*/
	        try {
	            FileUtils.cleanDirectory
	                    (new File(System.getProperty("catalina.home") + "/resources/" + toy.getName() + "/"));
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        multipartFile.transferTo(file);
	    } catch (IOException e) {
	        System.out.println("error with file");
	    }
	    toyDao.save(toy);
	}

	@Override
	public List<Toy> searchByCategory(int id) {
		// TODO Auto-generated method stub
		
		return toyDao.searchByCategory(id);
	}
	
}
