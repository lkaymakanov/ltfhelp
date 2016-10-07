package help.generatehelp.data.kindhomeobjreg;

import help.generatehelp.HelpUtils;

public class KindHomeObjRegUtil {

	public static String createKindHomeObjReg(){
		KindHomeObjRegSelect sel = new KindHomeObjRegSelect();
		HelpUtils.getSerServiceLocator().getHelpDao().execute(sel);
		return (HelpUtils.toJson(sel.getResult()));
	}
	
	public static void createSortingFunctions(){
		HelpUtils.log(HelpUtils.createJsObjectSortFunctionByProperties(new KindHomeObjReg().getPropertyNames(), "kindHomeObjRegSortFunctions"));
	}
}
