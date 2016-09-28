package help.generatehelp.data.city;

import help.generatehelp.HelpUtils;

public class CityUtil {

	

	public static void createCity(){
		CitySelect sel = new CitySelect();
		HelpUtils.getSerServiceLocator().getHelpDao().execute(sel);
		System.out.println(HelpUtils.toJson(sel.getResult()));
	}
	
	public static void createSortingFunctions(){
		System.out.println(HelpUtils.createJsObjectSortFunctionByProperties(new City().getPropertyNames(), "citySortFunctions"));
	}
}
