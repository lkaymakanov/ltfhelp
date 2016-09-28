package help.generatehelp.data.exchangereg;

import help.generatehelp.HelpUtils;

public class ExchangeRegUtil {

	public static void createExchangeReg(){
		ExchangeRegSelect sel = new ExchangeRegSelect();
		HelpUtils.getSerServiceLocator().getHelpDao().execute(sel);
		System.out.println(HelpUtils.toJson(sel.getResult()));
	}

	
	public static void createSortingFunctions(){
		System.out.println(HelpUtils.createJsObjectSortFunctionByProperties(new ExchangeReg().getPropertyNames(), "exchangeRegSortFunctions"));
	}
}
