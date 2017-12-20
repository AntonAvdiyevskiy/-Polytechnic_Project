package ua.com.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ua.com.dao.ToyDao;
import ua.com.magaz.Toy;

@Component("toyValidator")
public class ToyValidator implements Validator{

	@Autowired
	private ToyDao toyDao;
	public void validate(Object object) throws Exception {
		Toy toy = (Toy) object;
		// TODO Auto-generated method stub
		if(toyDao.findOneByName(toy.getName())!= null){
			throw new ToyValidationException(ValidationMassages.TOY_ALREADY_EXIST);
		}
	}

	

}
