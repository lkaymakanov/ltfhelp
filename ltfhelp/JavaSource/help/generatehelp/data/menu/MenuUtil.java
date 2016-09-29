package help.generatehelp.data.menu;

import help.generatehelp.HelpUtils;



public class MenuUtil {
	/***
	 * Create the menu as json array the menu nodes + root nodes!
	 */
	public static void createMenu() {
		// TODO Auto-generated method stub
		MenuSelect mselect = new MenuSelect();
		HelpUtils.getSerServiceLocator().getHelpDao().execute(mselect);
		String jsonMainNodes = HelpUtils.toJson(mselect.getResult(), " var menu =  ", ";");
		HelpUtils.log(jsonMainNodes);
		String jsonroots = HelpUtils.toJson(mselect.mainNodes, " var rootnodes =  ", ";");
		HelpUtils.log(jsonroots);
	}
	
	
	public static void createSortingFunctions(){
		System.out.println(HelpUtils.createJsObjectSortFunctionByProperties(new Menu().getPropertyNames(), "menuSortFunctions"));
	}
}
