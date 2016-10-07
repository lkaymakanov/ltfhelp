package help.generatehelp.data.exchangereg;

import help.generatehelp.HelpUtils;

public class ExchangeRegUtil {

	public static String  createExchangeReg(){
		ExchangeRegSelect sel = new ExchangeRegSelect();
		HelpUtils.getSerServiceLocator().getHelpDao().execute(sel);
		return (HelpUtils.toJson(sel.getResult()));
	}

	
	public static void createSortingFunctions(){
		HelpUtils.log(HelpUtils.createJsObjectSortFunctionByProperties(new ExchangeReg().getPropertyNames(), "exchangeRegSortFunctions"));
	}
}
