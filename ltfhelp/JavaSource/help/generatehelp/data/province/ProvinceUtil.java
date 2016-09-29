package help.generatehelp.data.province;

import help.generatehelp.HelpUtils;

public class ProvinceUtil {

	public static void createProvince(){
		ProvinceSelect sel = new ProvinceSelect();
		HelpUtils.getSerServiceLocator().getHelpDao().execute(sel);
		HelpUtils.log(HelpUtils.toJson(sel.getResult()));
	}
	

	public static void createSortingFunctions(){
		HelpUtils.log(HelpUtils.createJsObjectSortFunctionByProperties(new Province().getPropertyNames(), "provinceSortFunctions"));
	}
}
