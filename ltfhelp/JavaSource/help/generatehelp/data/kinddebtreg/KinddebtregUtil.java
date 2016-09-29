package help.generatehelp.data.kinddebtreg;

import help.generatehelp.HelpUtils;

public class KinddebtregUtil {

	public static void createKindDebtReg(){
		KinddebtregSelect sel = new KinddebtregSelect();
		HelpUtils.getSerServiceLocator().getHelpDao().execute(sel);
		HelpUtils.log(HelpUtils.toJson(sel.getResult()));
	}
}
