package help.generatehelp.data.documenttype;

import help.generatehelp.HelpUtils;

public class DocumenttypeUtil {

	public static String createDocumentType(){
		DocumenttypeSelect sel = new DocumenttypeSelect();
		HelpUtils.getSerServiceLocator().getHelpDao().execute(sel);
		return (HelpUtils.toJson(sel.getResult()));
	}
}
