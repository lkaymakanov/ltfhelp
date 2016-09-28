package help.generatehelp.data.kindparreg;

import help.generatehelp.HelpUtils;

public class KindParRegUtil {

	public static void createKindParreg(){
		KindParRegSelect sel = new KindParRegSelect();
		HelpUtils.getSerServiceLocator().getHelpDao().execute(sel);
		System.out.println(HelpUtils.toJson(sel.getResult()));
	}
	
	public static void createSortingFunctions(){
		System.out.println(HelpUtils.createJsObjectSortFunctionByProperties(new KindParReg().getPropertyNames(), "citySortFunctions"));
	}
}
