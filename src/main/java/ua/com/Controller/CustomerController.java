package ua.com.Controller;

import java.security.Principal;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import ua.com.dto.CustomerDto;
import ua.com.dto.DtoUtilMapper;
import ua.com.magaz.Customer;
import ua.com.service.CustomerService;
import ua.com.service.MailSenderService;
import ua.com.validation.ValidationMassages;
import ua.com.validation.Validator;

@Controller
public class CustomerController {


	@Autowired
	private CustomerService customerService;
	
	
	@RequestMapping(value = "/registration",method = RequestMethod.GET)
	public String newCustomer(Model model){
		
		model.addAttribute("customerDtos",DtoUtilMapper.customerToCustomerDto(customerService.findAll()));
		model.addAttribute("customer", new Customer());
		return "views-User-registration";
		}		
	@RequestMapping(value = "/registration",method = RequestMethod.POST)
	public String saveCustomer(@RequestParam String login,@RequestParam String password,
			@RequestParam String mail,
			@ModelAttribute Customer customer,Model model){
		String uuid=UUID.randomUUID().toString();
		customer.setUUID(uuid);
		customer.setEnabled(true);
		try{
			customerService.save(customer);
		}catch(Exception e){
//			model.addAttribute("Exception",e.getMessage());
			if(e.getMessage().equals(ValidationMassages.EMPTY_LOGIN_FIELD)||
					e.getMessage().equals(ValidationMassages.NAME_ALREADY_EXIST)){
				model.addAttribute("loginException", e.getMessage());
			}else if(e.getMessage().equals(ValidationMassages.EMPTY_MAIL_FIELD )||
					e.getMessage().equals(ValidationMassages.MAIL_ALREADY_EXIST)){
				model.addAttribute("mailException", e.getMessage());
			}else if(e.getMessage().equals(ValidationMassages.EMPTY_PASSWORD_FIELD)){
				model.addAttribute("passwordException", e.getMessage());
			}
			return "views-User-registration";
		}
		return "redirect:/";
		}
	@RequestMapping(value = "/deleteCustomer/{id}",method = RequestMethod.GET)
	public String deleteCustomer(@PathVariable int id){
		customerService.delete(id);
		return "redirect:/registration";
	}
	@RequestMapping(value="/profile",method = RequestMethod.GET)
	public String profile(Principal principal,Model model){
		Customer customer =  customerService.fetchCustomerWithCommodities(Integer.parseInt(principal.getName()));
		model.addAttribute("customer",customer);
		model.addAttribute("toys",customer.getCommodities());
		
		return "views-User-profile";
	
	}
	@RequestMapping(value="/buyToy/{id}",method = RequestMethod.GET)
	public String buyToy(Principal principal,@PathVariable String id){
		customerService.buyCommodity(principal, id);
		return "redirect:/profile";
	}
	@RequestMapping(value = "/deleteToyFromCustomer/{id}", method = RequestMethod.GET)
	public String deleteCommodityFromCustomer(Principal principal, @PathVariable String id) {
		
		customerService.deleteCommodityFromCustomer(principal, Integer.parseInt(id));

		return "redirect:/profile";
	}
	@RequestMapping(value = "/saveImage", method = RequestMethod.POST)
	public String saveImage(Principal principal, @RequestParam MultipartFile image) {
		
		customerService.saveImage(principal, image);

		return "redirect:/profile";
	}
	
	@RequestMapping(value = "/confirm/{uuid}" , method=RequestMethod.GET)
	public String confirm(@PathVariable String uuid,Model model){
		Customer customer = customerService.findByUuid(uuid);
		customer.setEnabled(true);
		
		try{
			customerService.update(customer);
		}catch(Exception e){
//			model.addAttribute("Exception",e.getMessage());
			if(e.getMessage().equals(ValidationMassages.EMPTY_LOGIN_FIELD)||
					e.getMessage().equals(ValidationMassages.NAME_ALREADY_EXIST)){
				model.addAttribute("loginException", e.getMessage());
			}else if(e.getMessage().equals(ValidationMassages.EMPTY_MAIL_FIELD )||
					e.getMessage().equals(ValidationMassages.MAIL_ALREADY_EXIST)){
				model.addAttribute("mailException", e.getMessage());
			}else if(e.getMessage().equals(ValidationMassages.EMPTY_PASSWORD_FIELD)){
				model.addAttribute("passwordException", e.getMessage());
			}
		}
		return "redirect:/";
	}
	
	@RequestMapping(value = "/updateProfile", method = RequestMethod.GET)
    public String updateProfile(Principal principal, Model model){
        Customer customer = customerService.findOneByName(Integer.parseInt(principal.getName()));
        model.addAttribute("customer", customer);
        return "views-User-updateProfile";
    }

    @RequestMapping(value = "/updateProfile", method = RequestMethod.POST)
    public String updateProfile(Principal principal, @RequestParam String login,
                                @RequestParam String mail,
                                @RequestParam String password){
        Customer customer = customerService.findOneByName(Integer.parseInt(principal.getName()));

        customer.setLogin(login);
        customer.setMail(mail);
        customer.setPassword(password);

        customerService.updateProfile(customer);

        return "redirect:/profile";
    }
  
}
