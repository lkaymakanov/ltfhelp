package help.generatehelp.data.reasonreg;

import help.generatehelp.HelpUtils;

public class ReasonRegUtil {

	public static String createReasonReg(){
		ReasonRegSelect sel = new ReasonRegSelect();
		HelpUtils.getSerServiceLocator().getHelpDao().execute(sel);
		return (HelpUtils.toJson(sel.getResult()));
	}
	
	public static void createSortingFunctions(){
		HelpUtils.log(HelpUtils.createJsObjectSortFunctionByProperties(new ReasonReg().getPropertyNames(), "reasonregSortFunctions"));
	}
}
