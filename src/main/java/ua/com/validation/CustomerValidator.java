package ua.com.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ua.com.dao.CustomerDao;
import ua.com.magaz.Customer;
@Component("customerValidator")
public class CustomerValidator implements Validator {
	@Autowired
	private CustomerDao customerDao;

	public void validate(Object object) throws Exception {
		// TODO Auto-generated method stub
		Customer customer = (Customer) object;
		if(customer.getLogin().isEmpty()){
			throw new CustomerValidationException(ValidationMassages.EMPTY_LOGIN_FIELD);
		}
		if(customerDao.findByLogin(customer.getLogin())!= null){
			throw new CustomerValidationException(ValidationMassages.NAME_ALREADY_EXIST);
		}
		if(customer.getMail().isEmpty()){
			throw new CustomerValidationException(ValidationMassages.EMPTY_MAIL_FIELD);
		}
		if(customerDao.customerExistByMail(customer.getMail())){
			throw new CustomerValidationException(ValidationMassages.MAIL_ALREADY_EXIST);
		}
		if(customer.getPassword().isEmpty()){
			
			throw new CustomerValidationException(ValidationMassages.EMPTY_PASSWORD_FIELD);
		}
	}

	
}
