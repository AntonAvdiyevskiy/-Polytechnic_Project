package ua.com.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ua.com.dao.CustomerDao;
import ua.com.magaz.Customer;

@Component("loginValidator")
public class LoginValidator implements Validator {

	@Autowired
	CustomerDao customerDao;
	public void validate(Object object) throws Exception {
		// TODO Auto-generated method stub
		Customer customer = (Customer) object;
		if(customer.getLogin().isEmpty()){
			throw new CustomerValidationException(ValidationMassages.EMPTY_LOGIN_FIELD);
		}
		
		if(customer.getPassword().isEmpty()){
			throw new CustomerValidationException(ValidationMassages.EMPTY_PASSWORD_FIELD);
		}
	}
	

}
