package ua.com.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ua.com.dao.BrandDao;
import ua.com.magaz.Brand;


@Component("brandValidator")
public class BrandValidator implements Validator {

	@Autowired
	BrandDao  brandDao;
	public void validate(Object object) throws Exception {
		// TODO Auto-generated method stub
		Brand brand = (Brand)object;
		if(brand.getName().isEmpty()){
			throw new BrandValidationExeption(ValidationMassages.EMPTY_Brand_FIELD);
		}else if(brand.getCountryName().isEmpty()){
			throw new BrandValidationExeption(ValidationMassages.EMPTY_COUNTRY_FIELD);
		}else if(brandDao.findOneByName(brand.getName())!=null){
			throw new BrandValidationExeption(ValidationMassages.Brand_ALREADY_EXIST);
		}else if(brand.getRating()==0){
			throw new BrandValidationExeption(ValidationMassages.Empty_Rating_field);
		}
	}

}
