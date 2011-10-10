package trotz.entities;

import java.util.List;

import siena.Generator;
import siena.Id;
import siena.Model;
import siena.Query;
import trotz.PortfolioSection;
import burrito.annotations.DefaultSort;
import burrito.annotations.Displayable;
import burrito.annotations.Image;
import burrito.annotations.Required;
import burrito.annotations.RichText;
import burrito.annotations.SearchableField;

public class PortfolioItem extends Model {
	@Id(Generator.AUTO_INCREMENT)
    private Long id;
	
	@SearchableField
    @Displayable
    @Required
    private String name;

    @SearchableField
    @Required
    @RichText
    private String description;
    
    @SearchableField
    @Displayable
    @Required
    private String extra;
    

    @Required
    @Displayable
    private PortfolioSection section;
    
    @Image(width = 0)
    @Displayable
    private String image;

    @Required
    @Displayable
    @DefaultSort(ascending = true)
    private Integer weight = 1;

    
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public PortfolioSection getSection() {
		return section;
	}

	public void setSection(PortfolioSection section) {
		this.section = section;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public void setWeight(Integer weight) {
		this.weight = weight;
	}

	public Integer getWeight() {
		return weight;
	}
	
	public static List<PortfolioItem> findForSection(PortfolioSection section) {
		return all().filter("section", section).order("-weight").fetch();
	}

	public static Query<PortfolioItem> all() {
		return Model.all(PortfolioItem.class);
	}

	public void setExtra(String extra) {
		this.extra = extra;
	}

	public String getExtra() {
		return extra;
	}
	 
    
    
    
	
}
