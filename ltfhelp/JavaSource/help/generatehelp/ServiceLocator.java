package help.generatehelp;

import net.is_bg.ltf.db.common.DBConfig;
import net.is_bg.ltf.db.common.interfaces.IConnectionFactory;


public class ServiceLocator {
	
	private HelpDao hd;
	
	public ServiceLocator() {
		// TODO Auto-generated constructor stub
		this(DBConfig.getConnectionFactory());
	}
	
	public ServiceLocator(IConnectionFactory cf) {
		// TODO Auto-generated constructor stub
		hd = new HelpDao(cf);
	}

	public HelpDao getHelpDao() {
		// TODO Auto-generated method stub
		return hd;
	}

}
