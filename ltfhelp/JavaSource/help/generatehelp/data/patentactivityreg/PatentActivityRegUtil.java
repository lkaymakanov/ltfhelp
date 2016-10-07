package help.generatehelp.data.patentactivityreg;

import help.generatehelp.HelpUtils;

public class PatentActivityRegUtil {

	public static String createPatentActivityReg(){
		PatentActivityRegSelect sel = new PatentActivityRegSelect();
		HelpUtils.getSerServiceLocator().getHelpDao().execute(sel);
		return (HelpUtils.toJson(sel.getResult()));
	}
	
	public static void createSortingFunctions(){
		HelpUtils.log(HelpUtils.createJsObjectSortFunctionByProperties(new PatentActivityReg().getPropertyNames(), "muniSortFunctions"));
	}
}
