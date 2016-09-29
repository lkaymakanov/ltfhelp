package help.generatehelp.data.exchangereg;

import help.generatehelp.HelpUtils;

public class ExchangeRegUtil {

	public static void createExchangeReg(){
		ExchangeRegSelect sel = new ExchangeRegSelect();
		HelpUtils.getSerServiceLocator().getHelpDao().execute(sel);
		HelpUtils.log(HelpUtils.toJson(sel.getResult()));
	}

	
	public static void createSortingFunctions(){
		HelpUtils.log(HelpUtils.createJsObjectSortFunctionByProperties(new ExchangeReg().getPropertyNames(), "exchangeRegSortFunctions"));
	}
}
