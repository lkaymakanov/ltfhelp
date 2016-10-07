package help.generatehelp.data.country;

import help.generatehelp.HelpUtils;

public class CountrtyUtil {

	public static String createCountry(){
		CountrySelect sel = new CountrySelect();
		HelpUtils.getSerServiceLocator().getHelpDao().execute(sel);
		return (HelpUtils.toJson(sel.getResult()));
	}
}
