package help.generatehelp.data.country;

import help.generatehelp.HelpUtils;

public class CountrtyUtil {

	public static void createCountry(){
		CountrySelect sel = new CountrySelect();
		HelpUtils.getSerServiceLocator().getHelpDao().execute(sel);
		HelpUtils.log(HelpUtils.toJson(sel.getResult()));
	}
}
