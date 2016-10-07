package help.generatehelp.data.kindparreg;

import help.generatehelp.HelpUtils;

public class KindParRegUtil {

	public static String createKindParreg(){
		KindParRegSelect sel = new KindParRegSelect();
		HelpUtils.getSerServiceLocator().getHelpDao().execute(sel);
		return (HelpUtils.toJson(sel.getResult()));
	}
	
	public static void createSortingFunctions(){
		HelpUtils.log(HelpUtils.createJsObjectSortFunctionByProperties(new KindParReg().getPropertyNames(), "citySortFunctions"));
	}
}
