package ua.com.editor;

import java.beans.PropertyEditorSupport;

import ua.com.service.ToyService;

public class CommodityEditor extends PropertyEditorSupport {
	private final ToyService commodityService;

	public CommodityEditor(ToyService commodityService) {
		
		this.commodityService = commodityService;
	}
	public void setAsText(String text) throws IllegalArgumentException {
		setValue(commodityService.getOne(Integer.parseInt(text)));
	}

}
