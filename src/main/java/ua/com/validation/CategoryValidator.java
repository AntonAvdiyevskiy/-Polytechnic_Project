package ua.com.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ua.com.dao.CategoryDao;
import ua.com.magaz.Category;


@Component("categoryValidator")
public class CategoryValidator implements Validator {
	@Autowired
	CategoryDao categoryOfCommodityDao;

	public void validate(Object object) throws Exception {
		// TODO Auto-generated method stub
		Category category = (Category)object;
		if(category.getName().isEmpty()){
			throw new CategoryValidationExeption(ValidationMassages.EMPTY_CATEGORY_NAME_FIELD);
			
		}
		if(categoryOfCommodityDao.findByName(category.getName())!=null){
			throw new  CategoryValidationExeption(ValidationMassages.CATEGORY_NAME_ALREADY_EXIST);
		}
	}

}
