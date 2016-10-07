package help.generatehelp.data.taxperiod;

import help.generatehelp.HelpUtils;

public class TaxperiodUtil {

	public static String createTaxperiod(){
		TaxperiodSelect sel = new TaxperiodSelect();
		HelpUtils.getSerServiceLocator().getHelpDao().execute(sel);
		return (HelpUtils.toJson(sel.getResult()));
	}
	
	public static void createSortingFunctions(){
		HelpUtils.log(HelpUtils.createJsObjectSortFunctionByProperties(new Taxperiod().getPropertyNames(), "taxperiodSortFunctions"));
	}
}
