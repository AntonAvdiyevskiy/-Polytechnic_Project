package ua.com.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import ua.com.dto.DtoUtilMapper;
import ua.com.dto.ToyDto;
import ua.com.magaz.Category;
import ua.com.magaz.Toy;
import ua.com.service.ToyService;
import ua.com.service.CategoryService;
import ua.com.service.CustomerService;

@Controller
public class HomeController {
	@Autowired
	private CustomerService customerService;
	@Autowired
	private ToyService toyService;
	@Autowired
	private CategoryService categoryService;

	@RequestMapping(value = {"/","/home"}, method=RequestMethod.GET)
	public String home(Model model){
		Toy toy = new Toy();
		model.addAttribute("customers", customerService.findAll());
		model.addAttribute("toy", toy);
		model.addAttribute("toys",toyService.getAll());
		model.addAttribute("categoriesOfToy",categoryService.findAll());
		return "views-base-home";
	}
	@RequestMapping(value="/home",method= RequestMethod.POST)
	public String loginprocesing(){
		return "redirect:/home";
	}
	@RequestMapping(value="/loginpage")
	public String login(){
		return "views-base-loginpage";
	}
	@RequestMapping(value="/logout",method= RequestMethod.POST)
	public String logout(){
		return "redirect:/";
	}
	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public String searchByName(@RequestParam String name,Model model,@ModelAttribute Toy toy){

		model.addAttribute("searchedToys", toyService.searchByName(name));

		return "views-base-searched"; 
	}
}
