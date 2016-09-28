package help.generatehelp.data.documenttype;

import help.generatehelp.HelpUtils;

public class DocumenttypeUtil {

	public static void createDocumentType(){
		DocumenttypeSelect sel = new DocumenttypeSelect();
		HelpUtils.getSerServiceLocator().getHelpDao().execute(sel);
		System.out.println(HelpUtils.toJson(sel.getResult()));
	}
}
