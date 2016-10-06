package help.generatehelp.data.city;

import help.generatehelp.HelpUtils;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class CityUtil {

	

	public static void createCity() throws UnsupportedEncodingException, IOException{
		CitySelect sel = new CitySelect();
		HelpUtils.getSerServiceLocator().getHelpDao().execute(sel);
		HelpUtils.log(HelpUtils.toJson(sel.getResult()));
	}
	
	public static void createSortingFunctions(){
		HelpUtils.log(HelpUtils.createJsObjectSortFunctionByProperties(new City().getPropertyNames(), "citySortFunctions"));
	}
}
