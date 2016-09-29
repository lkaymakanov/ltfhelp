package help.generatehelp.data.transpmeansreg;

import help.generatehelp.HelpUtils;

public class TranspmeansRegUtil {

	
	public static void createTranspmeansReg()	{
		TranspmeansRegSelect sel = new TranspmeansRegSelect();
		HelpUtils.getSerServiceLocator().getHelpDao().execute(sel);
		HelpUtils.log(HelpUtils.toJson(sel.getResult()));
	}


	public static void createSortingFunctions(){
		HelpUtils.log(HelpUtils.createJsObjectSortFunctionByProperties(new TranspmeansReg().getPropertyNames(), "transpSortFunctions"));
	}
}
