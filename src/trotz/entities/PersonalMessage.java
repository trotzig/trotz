package trotz.entities;

import siena.Generator;
import siena.Id;
import siena.Model;
import burrito.annotations.Displayable;
import burrito.annotations.RegexpValidation;
import burrito.annotations.Required;
import burrito.annotations.RichText;
import burrito.annotations.SearchableField;

public class PersonalMessage extends siena.Model {
	
	@Id(Generator.AUTO_INCREMENT)
    private Long id;

    @SearchableField
    @Displayable
    @Required
    @RegexpValidation(pattern = "[a-z09-_]*", description = "Endast gemener (a-z) och siffror tillåtna")
    private String path;

    @SearchableField
    @Required
    @RichText
    private String message;

  

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Long getId() {
		return id;
	}

	public static PersonalMessage getByPath(String path) {
		return Model.all(PersonalMessage.class).filter("path", path).get();
	}
    
}
