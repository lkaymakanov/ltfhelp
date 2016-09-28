package help.generatehelp.data.certreg;

import help.generatehelp.HelpUtils;

public class CertRegUtil {

	public static void createCertReg(){
		CertRegSelect sel = new CertRegSelect();
		HelpUtils.getSerServiceLocator().getHelpDao().execute(sel);
		System.out.println(HelpUtils.toJson(sel.getResult()));
	}
	
	public static void createSortingFunctions(){
		System.out.println(HelpUtils.createJsObjectSortFunctionByProperties(new CertReg().getPropertyNames(), "certRegSortFunctions"));
	}
}
