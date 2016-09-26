package help.generatehelp.data.menu;

import help.generatehelp.HelpUtils;



public class MenuUtil {

	
	/***
	 * Create the menu page!
	 */
	public static void createMenu() {
		// TODO Auto-generated method stub
		MenuSelect mselect = new MenuSelect();
		HelpUtils.getSerServiceLocator().getHelpDao().execute(mselect);
		
		int i, last;
		i = 0; last= mselect.getResult().size() - 1;
		System.out.println("var menu = [ ");
		for(Menu c : mselect.getResult()){
			System.out.println(c.toJSON() + (i == last ?  "" :  ","));
			i++;
		}
		System.out.println(" ]; ");
		
		
		i = 0; last= mselect.mainNodes.size() - 1;
		System.out.println("var rootnodes = [ ");
		for(Menu c : mselect.mainNodes){
			System.out.println(c.toJSON() + (i == last ?  "" :  ","));
			i++;
		}
		System.out.println(" ]; ");
	}
	
}
