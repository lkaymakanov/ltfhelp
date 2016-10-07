package help.generatehelp.data.kinddebtreg;

import help.generatehelp.HelpUtils;

public class KinddebtregUtil {

	public static String createKindDebtReg(){
		KinddebtregSelect sel = new KinddebtregSelect();
		HelpUtils.getSerServiceLocator().getHelpDao().execute(sel);
		return (HelpUtils.toJson(sel.getResult()));
	}
}
