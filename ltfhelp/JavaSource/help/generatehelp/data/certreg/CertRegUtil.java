package help.generatehelp.data.certreg;

import help.generatehelp.HelpUtils;

public class CertRegUtil {

	public static void createCertReg(){
		CertRegSelect sel = new CertRegSelect();
		HelpUtils.getSerServiceLocator().getHelpDao().execute(sel);
		HelpUtils.log(HelpUtils.toJson(sel.getResult()));
	}
	
	public static void createSortingFunctions(){
		HelpUtils.log(HelpUtils.createJsObjectSortFunctionByProperties(new CertReg().getPropertyNames(), "certRegSortFunctions"));
	}
}
