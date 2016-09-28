package help.generatehelp.data.province;

import help.generatehelp.HelpUtils;

public class ProvinceUtil {

	public static void createProvince(){
		ProvinceSelect sel = new ProvinceSelect();
		HelpUtils.getSerServiceLocator().getHelpDao().execute(sel);
		System.out.println(HelpUtils.toJson(sel.getResult()));
	}
	

	public static void createSortingFunctions(){
		System.out.println(HelpUtils.createJsObjectSortFunctionByProperties(new Province().getPropertyNames(), "provinceSortFunctions"));
	}
}
