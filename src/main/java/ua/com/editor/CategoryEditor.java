package ua.com.editor;

import java.beans.PropertyEditorSupport;

import ua.com.service.CategoryService;

public class CategoryEditor extends PropertyEditorSupport {
	private final CategoryService categoryService;

	public CategoryEditor(CategoryService categoryService) {
		super();
		this.categoryService = categoryService;
	}
	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		setValue(categoryService.findOneByName(Integer.parseInt(text)));
	}

}
