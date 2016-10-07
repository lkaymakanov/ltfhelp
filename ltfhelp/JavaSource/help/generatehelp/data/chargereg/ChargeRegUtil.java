package help.generatehelp.data.chargereg;

import help.generatehelp.HelpUtils;

public class ChargeRegUtil {


	public static String createChargeReg(){
		ChargeRegSelect sel = new ChargeRegSelect();
		HelpUtils.getSerServiceLocator().getHelpDao().execute(sel);
		return (HelpUtils.toJson(sel.getResult()));
	}
	
	public static void createSortingFunctions(){
		HelpUtils.log(HelpUtils.createJsObjectSortFunctionByProperties(new ChargeReg().getPropertyNames(), "chargeRegSortFunctions"));
	}
}
