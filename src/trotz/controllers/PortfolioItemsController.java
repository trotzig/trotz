package trotz.controllers;

import java.util.List;

import taco.Controller;
import trotz.PortfolioSection;
import trotz.entities.PortfolioItem;

public class PortfolioItemsController implements
		Controller<List<PortfolioItem>> {

	private String section;
	
	public String getSection() {
		return section;
	}

	public void setSection(String section) {
		this.section = section;
	}

	@Override
	public List<PortfolioItem> execute() {
		return PortfolioItem.findForSection(PortfolioSection.valueOf(section.toUpperCase()));
	}

}
