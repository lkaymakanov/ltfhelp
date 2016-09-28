package help.generatehelp.data.taxperiod;

import help.generatehelp.HelpUtils;

public class TaxperiodUtil {

	public static void createTaxperiod(){
		TaxperiodSelect sel = new TaxperiodSelect();
		HelpUtils.getSerServiceLocator().getHelpDao().execute(sel);
		System.out.println(HelpUtils.toJson(sel.getResult()));
	}
	
	public static void createSortingFunctions(){
		System.out.println(HelpUtils.createJsObjectSortFunctionByProperties(new Taxperiod().getPropertyNames(), "taxperiodSortFunctions"));
	}
}
