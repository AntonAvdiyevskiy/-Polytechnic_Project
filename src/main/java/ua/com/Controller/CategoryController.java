package ua.com.Controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



import ua.com.magaz.Category;
import ua.com.service.CategoryService;
import ua.com.validation.ValidationMassages;


@Controller
public class CategoryController {

	@Autowired
	private CategoryService categoryService;
	
	@RequestMapping(value = "/newCategory",method = RequestMethod.GET)
	public String newCategory(Model model){
		
		model.addAttribute("categories",categoryService.findCategoryWithToys());
		model.addAttribute("category",new Category() );
		return "views-admin-newCategory";
		}
	
	@RequestMapping(value = "/saveCategory",method = RequestMethod.POST)
	public String saveCategory(/*@RequestParam String name,@RequestParam String availability*/
			@ModelAttribute Category category,Model model) {
	try{
		categoryService.save(category);
	}catch(Exception e){
		if(e.getMessage().equals(ValidationMassages.EMPTY_CATEGORY_NAME_FIELD)||
				e.getMessage().equals(ValidationMassages.CATEGORY_NAME_ALREADY_EXIST)){
			model.addAttribute("nameException", e.getMessage());
		}
		return "redirect:/newCategory";
	}
		return "redirect:/";
		}
	@RequestMapping(value = "/deleteCategory/{id}",method = RequestMethod.GET)
	public String newCategoryOfCommodity(@PathVariable String id){
		categoryService.delete(Integer.parseInt(id));
		return "redirect:/newCategory";
	}
	@RequestMapping(value="/deleteCommodityFromCategory/{idCommodity}")
	public String deleteCommodityFromCategory (@PathVariable String idCommodity){
		categoryService.deleteToyFromCategory(idCommodity);;
		return "redirect:/newCategory";
		
	}

}
