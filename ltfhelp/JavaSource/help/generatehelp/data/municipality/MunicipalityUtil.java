package help.generatehelp.data.municipality;

import help.generatehelp.HelpUtils;

public class MunicipalityUtil {


	public static void createMunicipality(){
		MunicipalitySelect sel = new MunicipalitySelect();
		HelpUtils.getSerServiceLocator().getHelpDao().execute(sel);
		HelpUtils.log(HelpUtils.toJson(sel.getResult()));
	}
	
	public static void createSortingFunctions(){
		HelpUtils.log(HelpUtils.createJsObjectSortFunctionByProperties(new Municipality().getPropertyNames(), "muniSortFunctions"));
	}
}
