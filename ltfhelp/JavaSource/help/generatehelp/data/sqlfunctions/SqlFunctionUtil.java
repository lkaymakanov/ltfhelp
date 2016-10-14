package help.generatehelp.data.sqlfunctions;

import help.generatehelp.HelpUtils;

public class SqlFunctionUtil {

	public static String createSqlFunstions(String user){
		SqlFunctionsSelect sel = new SqlFunctionsSelect(user);
		HelpUtils.getSerServiceLocator().getHelpDao().execute(sel);
		return (HelpUtils.toJson(sel.getResult()));
	}
}
