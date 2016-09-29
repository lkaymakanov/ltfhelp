package help.generatehelp.data.kindhomeobjreg;

import help.generatehelp.HelpUtils;

public class KindHomeObjRegUtil {

	public static void createKindHomeObjReg(){
		KindHomeObjRegSelect sel = new KindHomeObjRegSelect();
		HelpUtils.getSerServiceLocator().getHelpDao().execute(sel);
		HelpUtils.log(HelpUtils.toJson(sel.getResult()));
	}
	
	public static void createSortingFunctions(){
		HelpUtils.log(HelpUtils.createJsObjectSortFunctionByProperties(new KindHomeObjReg().getPropertyNames(), "kindHomeObjRegSortFunctions"));
	}
}
