package ua.com.Controller;


import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.support.MultipartFilter;

import ua.com.dto.ToyDto;
import ua.com.dto.CustomerDto;
import ua.com.editor.BrandEditor;
import ua.com.editor.CategoryEditor;
import ua.com.magaz.Brand;
import ua.com.magaz.Category;
import ua.com.magaz.Toy;
import ua.com.service.CategoryService;
import ua.com.service.ToyService;
import ua.com.service.BrandService;
import ua.com.validation.ValidationMassages;

@Controller
public class ToyController {

	@Autowired
	private ToyService toyService;
	@Autowired
	private CategoryService categoryService;
	@Autowired
	private BrandService brandService;
	
	@InitBinder
	public  void InitBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Category.class, new CategoryEditor(categoryService));
		binder.registerCustomEditor(Brand.class,new BrandEditor(brandService) );
		// TODO Auto-generated method stub

	}
	
	@RequestMapping(value = "/newToy",method = RequestMethod.GET)
	public String newToy(Model model){
		List<Toy>toysFromDB = toyService.getAll();
		model.addAttribute("toys",toysFromDB);
		model.addAttribute("toy",new Toy());
		model.addAttribute("categoriesOfToy",categoryService.findAll());
		model.addAttribute("brands",brandService.getAll());
		
		return "views-admin-newToy";
		}
	
	@RequestMapping(value = "/saveToy",method = RequestMethod.POST)
	public String saveCommodity(@ModelAttribute Toy toy,
								/*@RequestParam String name,
								@RequestParam String color,*/
								@RequestParam String price,
								@RequestParam String rating,
								Model model
								/*@RequestParam MultipartFile  image*/
								/*@PathVariable int id, 
								@RequestParam MultipartFile image
								*/
								/*@RequestParam String date*/
								 /*@RequestParam MultipartFile image*/
								){
		toy.setPrice(Double.parseDouble(price));
		toy.setRating(Double.parseDouble(rating));
		
		/*commodityService.saveImage(id, image);*/
		//commodityService.save(commodity);
		
		
		
		
		
		
		
		
		try {
			toyService.save(toy);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			if(e.getMessage().equals(ValidationMassages.TOY_ALREADY_EXIST)){
				model.addAttribute("toyException", e.getMessage());
			}
		}
		return "redirect:/newToy";
		}
	@RequestMapping(value = "/deleteToy/{id}",method = RequestMethod.GET)
	public String newToy(@PathVariable int id){
		toyService.delete(id);
		return "redirect:/newToy";
			}
	/*@RequestMapping(value = "/loadCommodity", method = RequestMethod.POST)
    public @ResponseBody List<CommodityDto> save—ommodity() {


       return DtoUtilMapper.CommodityToCommodity(commodityService.getAll());

    	}*/
	/*@PostMapping("saveManyImages")
	public String saveManyImages(@RequestParam MultipartFilter []images){
		return "";
	}*/
	@RequestMapping(value = "/saveToyImage", method = RequestMethod.POST)
	public String saveCommodityImage(@PathVariable int id, @RequestParam MultipartFile image) {
		
		toyService.saveImage(id, image);

		return "redirect:/newToy";
	}
	@RequestMapping(value = "/sortPrice", method = RequestMethod.POST)
	public String sortByPrice(@RequestParam double price,Model model,@ModelAttribute Toy toy){

		model.addAttribute("searchedToys", toyService.sortToysByPrice(price));

		return "views-base-searched"; 
	}
	@RequestMapping(value = "/sortByCategory", method = RequestMethod.POST)
	public String sortByCategory(@RequestParam int id,Model model,@ModelAttribute Toy toy){

		model.addAttribute("searchedToys", toyService.searchByCategory(id));
		return "views-base-searched"; 
	}	
}