package help.generatehelp.data.regnumber;

import help.generatehelp.HelpUtils;

public class RegNumberUtil {

	public static void createRegNumber(){
		RegNumberSelect sel = new RegNumberSelect();
		HelpUtils.getSerServiceLocator().getHelpDao().execute(sel);
		System.out.println(HelpUtils.toJson(sel.getResult()));
	}
	
	public static void createSortingFunctions(){
		System.out.println(HelpUtils.createJsObjectSortFunctionByProperties(new RegNumber().getPropertyNames(), "regNumberSortFunctions"));
	}
}
