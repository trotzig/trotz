package trotz.controllers;

import taco.Controller;
import trotz.entities.PersonalMessage;

public class PersonalMessageController implements Controller<PersonalMessage> {

	private static String defaultPath = "default";
	
	private String path = defaultPath;
	
	
	@Override
	public PersonalMessage execute() {
		PersonalMessage msg = PersonalMessage.getByPath(path);
		if (msg != null) {
			return msg;
		}
		return PersonalMessage.getByPath(defaultPath);
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
	
	

}
