package help.generatehelp.data.servicereg;

import help.generatehelp.HelpUtils;

public class ServiceRegUtil {

	public static void createServiceReg(){
		ServiceRegSelect sel = new ServiceRegSelect();
		HelpUtils.getSerServiceLocator().getHelpDao().execute(sel);
		HelpUtils.log(HelpUtils.toJson(sel.getResult()));
	}
	

	public static void createSortingFunctions(){
		HelpUtils.log(HelpUtils.createJsObjectSortFunctionByProperties(new ServiceReg().getPropertyNames(), "serviceRegSortFunctions"));
	}
}
