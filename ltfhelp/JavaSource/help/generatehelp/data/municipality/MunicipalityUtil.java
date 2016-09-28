package help.generatehelp.data.municipality;

import help.generatehelp.HelpUtils;

public class MunicipalityUtil {


	public static void createMunicipality(){
		MunicipalitySelect sel = new MunicipalitySelect();
		HelpUtils.getSerServiceLocator().getHelpDao().execute(sel);
		System.out.println(HelpUtils.toJson(sel.getResult()));
	}
	
	public static void createSortingFunctions(){
		System.out.println(HelpUtils.createJsObjectSortFunctionByProperties(new Municipality().getPropertyNames(), "muniSortFunctions"));
	}
}
