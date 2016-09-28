package help.generatehelp.data.country;

import help.generatehelp.HelpUtils;

public class CountrtyUtil {

	public static void createCountry(){
		CountrySelect sel = new CountrySelect();
		HelpUtils.getSerServiceLocator().getHelpDao().execute(sel);
		System.out.println(HelpUtils.toJson(sel.getResult()));
	}
}
