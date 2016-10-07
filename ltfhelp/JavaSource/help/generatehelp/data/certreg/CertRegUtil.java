package help.generatehelp.data.certreg;

import help.generatehelp.HelpUtils;

public class CertRegUtil {

	public static String  createCertReg(){
		CertRegSelect sel = new CertRegSelect();
		HelpUtils.getSerServiceLocator().getHelpDao().execute(sel);
		return HelpUtils.toJson(sel.getResult());
	}
	
	public static void createSortingFunctions(){
		HelpUtils.log(HelpUtils.createJsObjectSortFunctionByProperties(new CertReg().getPropertyNames(), "certRegSortFunctions"));
	}
}
