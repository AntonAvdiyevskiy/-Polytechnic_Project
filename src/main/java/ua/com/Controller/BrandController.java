package ua.com.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ua.com.magaz.Brand;


import ua.com.service.BrandService;
import ua.com.validation.BrandValidationExeption;
import ua.com.validation.ValidationMassages;


@Controller
public class BrandController {


	@Autowired
	private BrandService brandService;
	

	
	@RequestMapping(value = "/newBrand",method = RequestMethod.GET)
	public String newProducer(Model model){
		model.addAttribute("brands",brandService.getAll());
		model.addAttribute("brand", new Brand());
		return "views-admin-newBrand";
		}
	
	@RequestMapping(value = "/saveBrand",method = RequestMethod.POST)
	public String saveProducer( @ModelAttribute Brand brand,Model model){
		
		try {
			brandService.save(brand);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			if(e.getMessage().equals(ValidationMassages.Brand_ALREADY_EXIST)|| e.getMessage().
					equals(ValidationMassages.EMPTY_Brand_FIELD)){
				model.addAttribute("brandException", e.getMessage());
			}else if(e.getMessage().equals(ValidationMassages.EMPTY_COUNTRY_FIELD)){
				model.addAttribute("countryException", e.getMessage());
			}else if(e.getMessage().equals(ValidationMassages.Empty_Rating_field)){
				model.addAttribute("ratingException",e.getMessage());
			}
		}
		
		return "redirect:/newBrand";
		}
	@RequestMapping(value = "/deleteBrand/{id}",method = RequestMethod.GET)
	public String deleteBrand(@PathVariable int id){
		brandService.delete(id);
		return "redirect:/newBrand";
	}
	

}
