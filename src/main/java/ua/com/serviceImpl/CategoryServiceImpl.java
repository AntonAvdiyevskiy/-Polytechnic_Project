package ua.com.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ua.com.dao.CategoryDao;
import ua.com.dao.ToyDao;
import ua.com.magaz.Category;
import ua.com.magaz.Toy;
import ua.com.service.CategoryService;
import ua.com.validation.Validator;

@Service("categoryService")
public class CategoryServiceImpl implements CategoryService{

	@Autowired
	private CategoryDao categoryDao;
	@Autowired
	private ToyDao toyDao;
	@Autowired
	@Qualifier("categoryValidator")
	private Validator validator;
	public void save(Category category) throws Exception {
		// TODO Auto-generated method stub
		validator.validate(category);
		categoryDao.save(category);
	}

	public List<Category> findAll() {
		// TODO Auto-generated method stub
		return categoryDao.findAll();
	}

	public Category findOneByName(int id) {
		// TODO Auto-generated method stub
		return categoryDao.findOne(id);
	}
	@Transactional
	public void delete(int id) {
		// TODO Auto-generated method stub
	//	categoryOfCommodityDao.delete(id);
		Category category = categoryDao.findCategoryWithCommodity(id);
		for(Toy toy: category.getToys()){
			toy.setCategory(null);
			toyDao.save(toy);
		}
		categoryDao.delete(category);
	}
	
	@Transactional
	public void deleteCommodityFromCategory(String idToy) {
		// TODO Auto-generated method stub
		Toy toy = toyDao.findOne(Integer.parseInt(idToy));
		toy.setCategory(null);
		toyDao.save(toy);
	}

	public List<Category> findCategoryWithToys() {
		// TODO Auto-generated method stub
		return categoryDao.findCategoryWithToys();
	}
	public void saveAndFlush(Category categoryOfCommodity){
		categoryDao.saveAndFlush(categoryOfCommodity);
	}

	@Override
	public void deleteToyFromCategory(String idCommodity) {
		// TODO Auto-generated method stub
		
	}
	
}
