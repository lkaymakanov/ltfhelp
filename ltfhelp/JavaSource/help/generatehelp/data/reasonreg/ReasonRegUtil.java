package help.generatehelp.data.reasonreg;

import help.generatehelp.HelpUtils;

public class ReasonRegUtil {

	public static void createReasonReg(){
		ReasonRegSelect sel = new ReasonRegSelect();
		HelpUtils.getSerServiceLocator().getHelpDao().execute(sel);
		HelpUtils.log(HelpUtils.toJson(sel.getResult()));
	}
	
	public static void createSortingFunctions(){
		HelpUtils.log(HelpUtils.createJsObjectSortFunctionByProperties(new ReasonReg().getPropertyNames(), "reasonregSortFunctions"));
	}
}
