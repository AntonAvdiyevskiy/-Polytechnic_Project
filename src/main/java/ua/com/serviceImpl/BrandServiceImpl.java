package ua.com.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import ua.com.dao.BrandDao;
import ua.com.magaz.Brand;
import ua.com.service.BrandService;
import ua.com.validation.Validator;
@Service("brandService")
public class BrandServiceImpl implements BrandService {

	@Autowired
	private BrandDao brandDao;
	@Autowired
	@Qualifier("brandValidator")
	private Validator validator;
	public void save(Brand brand) throws Exception {
		// TODO Auto-generated method stub
		validator.validate(brand);
		brandDao.save(brand);
	}

	public List<Brand> getAll() {
		// TODO Auto-generated method stub
		return brandDao.findAll();
	}

	public Brand getOne(int id) {
		// TODO Auto-generated method stub
		return brandDao.findOne(id);
	}

	public void delete(int id) {
		// TODO Auto-generated method stub
		brandDao.delete(id);
	}

	

	

	
	

}
