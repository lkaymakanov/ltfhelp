package help.generatehelp.data.kindhomeobjreg;

import help.generatehelp.HelpUtils;

public class KindHomeObjRegUtil {

	public static void createKindHomeObjReg(){
		KindHomeObjRegSelect sel = new KindHomeObjRegSelect();
		HelpUtils.getSerServiceLocator().getHelpDao().execute(sel);
		System.out.println(HelpUtils.toJson(sel.getResult()));
	}
	
	public static void createSortingFunctions(){
		System.out.println(HelpUtils.createJsObjectSortFunctionByProperties(new KindHomeObjReg().getPropertyNames(), "kindHomeObjRegSortFunctions"));
	}
}
