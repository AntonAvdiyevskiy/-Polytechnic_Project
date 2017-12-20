package ua.com.serviceImpl;

import java.io.File;
import java.io.IOException;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import ua.com.dao.ToyDao;
import ua.com.dao.CustomerDao;
import ua.com.magaz.Customer;
import ua.com.magaz.Role;
import ua.com.magaz.Toy;
import ua.com.service.CustomerService;
import ua.com.validation.Validator;

@Service("userDetailsService")
public class CustomerServiceImpl implements CustomerService,UserDetailsService {

	@Autowired
	private CustomerDao customerDao;
	@Autowired
	BCryptPasswordEncoder encoder;
	
	@Autowired
	ToyDao toyDao;
	
	
	@Autowired
	@Qualifier("customerValidator")
	private Validator validator;

	
	public void save(Customer customer) throws Exception {
		//validator.validate(customer);
		// TODO Auto-generated method stub
		validator.validate(customer);
		customer.setRole(Role.ROLE_USER);
		customer.setPassword(encoder.encode(customer.getPassword()));
		customerDao.save(customer);
	}

	public List<Customer> findAll() {
		// TODO Auto-generated method stub
		return customerDao.findAll();
	}

	public Customer findOneByName(int id) {
		// TODO Auto-generated method stub
		return customerDao.findOne(id);
	}

	public void delete(int id) {
		// TODO Auto-generated method stub
		customerDao.delete(id);
	}

	public Customer findByLogin(String login) {
		// TODO Auto-generated method stub
		return customerDao.findByLogin(login);
	}

	public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		return customerDao.findByLogin(login);
	}

	@Transactional
	public void deleteCommodityFromCustomer(Principal principal, int id) {
		// TODO Auto-generated method stub
		Customer customer = customerDao.findOne(Integer.parseInt(principal.getName()));
		Toy toy = toyDao.findOne(id);
		customer.getCommodities().remove(toy);
		toy.setCustomer(null);
	}

	@Transactional
	public void saveImage(Principal principal, MultipartFile multipartFile) {

	    Customer customer = customerDao.findOne(Integer.parseInt(principal.getName()));

	    String path = System.getProperty("catalina.home") + "/resources/"
	            + customer.getLogin() + "/" + multipartFile.getOriginalFilename();

	    customer.setPathImage("resources/" + customer.getLogin() + "/" + multipartFile.getOriginalFilename());

	    File file = new File(path);

	    try {
	        file.mkdirs();
	        try {
	            FileUtils.cleanDirectory
	                    (new File(System.getProperty("catalina.home") + "/resources/" + customer.getLogin() + "/"));
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        multipartFile.transferTo(file);
	    } catch (IOException e) {
	        System.out.println("error with file");
	    }
	    customerDao.save(customer);
	}

	public Customer findByUuid(String uuid) {
		// TODO Auto-generated method stub
		return customerDao.findByUuid(uuid);
	}

	public void update(Customer customer) throws Exception {
		// TODO Auto-generated method stub
		validator.validate(customer);
		customerDao.save(customer);
	}

	@Transactional
	public void buyCommodity(Principal principal, String id) {
		// TODO Auto-generated method stub
		Customer customer = customerDao.findOne(Integer.parseInt(principal.getName()));
		Toy toy = toyDao.findOne(Integer.parseInt(id));
		toy.setCustomer(customer);
		customer.getCommodities().add(toy);
	}

	public Customer fetchCustomerWithCommodities(int id) {
		// TODO Auto-generated method stub
		return customerDao.fetchCustomerWithCommodities(id);
	}

	public void updateProfile(Customer customer) {
		// TODO Auto-generated method stub
		customer.setPassword(encoder.encode(customer.getPassword()));
		customerDao.save(customer);
	}



	

	

}
