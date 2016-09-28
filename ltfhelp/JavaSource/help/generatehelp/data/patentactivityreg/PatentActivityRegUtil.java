package help.generatehelp.data.patentactivityreg;

import help.generatehelp.HelpUtils;

public class PatentActivityRegUtil {

	public static void createPatentActivityReg(){
		PatentActivityRegSelect sel = new PatentActivityRegSelect();
		HelpUtils.getSerServiceLocator().getHelpDao().execute(sel);
		System.out.println(HelpUtils.toJson(sel.getResult()));
	}
	
	public static void createSortingFunctions(){
		System.out.println(HelpUtils.createJsObjectSortFunctionByProperties(new PatentActivityReg().getPropertyNames(), "muniSortFunctions"));
	}
}
