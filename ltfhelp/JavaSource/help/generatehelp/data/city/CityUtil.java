package help.generatehelp.data.city;

import help.generatehelp.HelpUtils;

public class CityUtil {

	

	public static void createCity(){
		CitySelect sel = new CitySelect();
		HelpUtils.getSerServiceLocator().getHelpDao().execute(sel);
		HelpUtils.log(HelpUtils.toJson(sel.getResult()));
	}
	
	public static void createSortingFunctions(){
		HelpUtils.log(HelpUtils.createJsObjectSortFunctionByProperties(new City().getPropertyNames(), "citySortFunctions"));
	}
}
