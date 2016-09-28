package help.generatehelp.data.reasonreg;

import help.generatehelp.HelpUtils;

public class ReasonRegUtil {

	public static void createReasonReg(){
		ReasonRegSelect sel = new ReasonRegSelect();
		HelpUtils.getSerServiceLocator().getHelpDao().execute(sel);
		System.out.println(HelpUtils.toJson(sel.getResult()));
	}
	
	public static void createSortingFunctions(){
		System.out.println(HelpUtils.createJsObjectSortFunctionByProperties(new ReasonReg().getPropertyNames(), "reasonregSortFunctions"));
	}
}
