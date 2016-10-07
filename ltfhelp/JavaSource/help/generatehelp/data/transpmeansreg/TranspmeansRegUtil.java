package help.generatehelp.data.transpmeansreg;

import help.generatehelp.HelpUtils;

public class TranspmeansRegUtil {

	
	public static String createTranspmeansReg()	{
		TranspmeansRegSelect sel = new TranspmeansRegSelect();
		HelpUtils.getSerServiceLocator().getHelpDao().execute(sel);
		return (HelpUtils.toJson(sel.getResult()));
	}


	public static void createSortingFunctions(){
		HelpUtils.log(HelpUtils.createJsObjectSortFunctionByProperties(new TranspmeansReg().getPropertyNames(), "transpSortFunctions"));
	}
}
