package ua.com.editor;

import java.beans.PropertyEditorSupport;

import ua.com.service.CategoryService;
import ua.com.service.BrandService;

public class BrandEditor extends PropertyEditorSupport {
	private final BrandService brandService;

	public BrandEditor(BrandService brandService) {
		
		this.brandService = brandService;
	}
	public void setAsText(String text) throws IllegalArgumentException {
		setValue(brandService.getOne(Integer.parseInt(text)));
	}
	
	

}
