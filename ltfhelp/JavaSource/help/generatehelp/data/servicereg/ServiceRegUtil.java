package help.generatehelp.data.servicereg;

import help.generatehelp.HelpUtils;

public class ServiceRegUtil {

	public static void createServiceReg(){
		ServiceRegSelect sel = new ServiceRegSelect();
		HelpUtils.getSerServiceLocator().getHelpDao().execute(sel);
		System.out.println(HelpUtils.toJson(sel.getResult()));
	}
	

	public static void createSortingFunctions(){
		System.out.println(HelpUtils.createJsObjectSortFunctionByProperties(new ServiceReg().getPropertyNames(), "serviceRegSortFunctions"));
	}
}
