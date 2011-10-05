package trotz;

import trotz.controllers.PersonalMessageController;
import trotz.controllers.PortfolioItemsController;
import burrito.Configurator;

public class Router extends taco.Router {

	@Override
	public void init() {
		route("/admin").renderedBy("Admin.jsp").protect(Configurator.getAdminProtector());
		
		route("/{path}").through(PersonalMessageController.class).renderedBy("start.jsp");
		route("/").through(PersonalMessageController.class).renderedBy("start.jsp");
		
		route("/portfolio/{section}").through(PortfolioItemsController.class).renderAsJson();
		
	}

}
