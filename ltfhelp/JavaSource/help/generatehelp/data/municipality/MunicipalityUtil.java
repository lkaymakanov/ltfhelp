package help.generatehelp.data.municipality;

import help.generatehelp.HelpUtils;

public class MunicipalityUtil {


	public static String createMunicipality(){
		MunicipalitySelect sel = new MunicipalitySelect();
		HelpUtils.getSerServiceLocator().getHelpDao().execute(sel);
		return (HelpUtils.toJson(sel.getResult()));
	}
	
	public static void createSortingFunctions(){
		HelpUtils.log(HelpUtils.createJsObjectSortFunctionByProperties(new Municipality().getPropertyNames(), "muniSortFunctions"));
	}
}
