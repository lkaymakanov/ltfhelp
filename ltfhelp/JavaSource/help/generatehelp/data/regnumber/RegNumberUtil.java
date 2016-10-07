package help.generatehelp.data.regnumber;

import help.generatehelp.HelpUtils;

public class RegNumberUtil {

	public static String createRegNumber(){
		RegNumberSelect sel = new RegNumberSelect();
		HelpUtils.getSerServiceLocator().getHelpDao().execute(sel);
		return (HelpUtils.toJson(sel.getResult()));
	}
	
	public static void createSortingFunctions(){
		HelpUtils.log(HelpUtils.createJsObjectSortFunctionByProperties(new RegNumber().getPropertyNames(), "regNumberSortFunctions"));
	}
}
