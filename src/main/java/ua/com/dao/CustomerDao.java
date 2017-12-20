package ua.com.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ua.com.magaz.Customer;


public interface CustomerDao extends JpaRepository<Customer, Integer>{

//	void save(Customer customer);
//	List<Customer> findAll();
//	Customer findOneByName(String login);
//	void delete(String login);
	Customer findByLogin(String login);
	@Query("select distinct c from Customer c left join fetch c.toys where c.id =:id")
	Customer fetchCustomerWithCommodities(@Param("id") int id);
	@Query("SELECT CASE WHEN COUNT(c) > 0 THEN true ELSE false END FROM Customer c WHERE c.login =:login")
	boolean customerExistByLogin(@Param ("login") String login);
	@Query("SELECT CASE WHEN COUNT(c) > 0 THEN true ELSE false END FROM Customer c WHERE c.mail =:mail")
	boolean customerExistByMail(@Param ("mail") String mail);
	@Query("select c from Customer c where c.UUID =:uuid")
	Customer findByUuid(@Param("uuid")String uuid);
}
