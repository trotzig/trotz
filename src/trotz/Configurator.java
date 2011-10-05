package trotz;

import trotz.entities.PersonalMessage;
import trotz.entities.PortfolioItem;
import burrito.BroadcastSettings;

public class Configurator extends burrito.Configurator {

	@Override
	protected BroadcastSettings configureBroadcastSettings() {
		return new BroadcastSettings("ujnsdfuhvcxyutg");
	}

	@Override
	protected String configureSiteIdentifier() {
		return "trotz";
	}

	@Override
	protected void init() {
		addCrudable(PersonalMessage.class);
		addCrudable(PortfolioItem.class);
	}

}
