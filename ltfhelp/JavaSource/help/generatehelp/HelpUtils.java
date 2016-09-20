package help.generatehelp;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import javax.faces.model.SelectItem;


public class HelpUtils {
	private static ServiceLocator serviceLocator =new ServiceLocator();
	private static Map<String, Table> tablesMap = new HashMap<String, Table>();   
	
	private static String htmlTemplate = 
			" <html>\n"+
			" <head>\n"+
			" <link   rel=\"stylesheet\" type=\"text/css\" href=\"../css/css.css\">\n"+
			" <script src=\"../js/data/@.js\"></script>\n"+
			" <script src=\"../js/functions/tablecolumns.js\" ></script>\n"+
			" <meta http-equiv=\"content-type\" content=\"text/html; charset=UTF-8\">\n"+
			" </head>\n"+
			" \n"+
			" <body> \n"+
			" <h1>@<h1>\n"+
			" <div id=\"filtered\"></div>\n"+
			" <script> showFiltered(tablecolumns); </script>\n" +
			" </body>\n"+
			" </html>\n";


	
	
	/**
	 * @throws FileNotFoundException */
	public static void createTables() throws FileNotFoundException{
		TableColumnsSelesct sel = new TableColumnsSelesct();
		DecodeForColumnSelect dsel = new DecodeForColumnSelect();
		serviceLocator.getHelpDao().execute(dsel);
		serviceLocator.getHelpDao().execute(sel);
		
		
		
		//create json  array for each table row
		//PrintWriter pr  =  new PrintWriter(new FileOutputStream("tablecolumnsjson.js"));
		for(TableColumn c : sel.getColumns()){
			Table tbl = tablesMap.get(c.getTableName());
			if(tbl == null) {
				tbl = new Table();
				tbl.setTableName(c.getTableName());
				tablesMap.put(c.getTableName(), tbl);
			}
			tbl.getColumns().add(c);
			
			List<SelectItem> decodes =  dsel.getItems(c.getColKey());
			if(decodes !=null){
				c.setDecodeValues(decodes);
			}
		}
		
		//saveTablesToFile();
		//saveTableIndex(tablesMap.keySet());
		System.out.println(tablesMap.keySet());
	}
	
	/**save each table columns as json*/
	private static void saveJsonTableToFile(Table t) throws FileNotFoundException{
		PrintWriter pr  =  new PrintWriter(new FileOutputStream("public" + File.separator + "tables" + File.separator + "js" + File.separator +   "data"
	    + File.separator +  t.getTableName()+".js"));
		pr.println();
		int i, last;
		i = 0; last= t.getColumns().size() - 1;
		pr.println(" var tablecolumns = [ ");
		for(TableColumn c : t.getColumns()){
			pr.println(c.toJSON() + (i == last ?  "" :  ","));
			i++;
		}
		pr.println(" ]; ");
		pr.flush();
		pr.close();
	}
	
	
	/**Save html for each table*/
	private static void saveHtmltoFile(Table t) throws FileNotFoundException{
		PrintWriter pr  =  new PrintWriter(new FileOutputStream("public" + File.separator + "tables" + File.separator + "pages" + File.separator 
	    + File.separator +  t.getTableName()+".html"));
		pr.println(htmlTemplate.replaceFirst("@", t.getTableName()).replace("@", t.getTableName().toUpperCase()));
		pr.flush();
		pr.close();
	}
	
	/***
	 * Save table index!!!
	 * @throws FileNotFoundException
	 */
	private static void saveTableIndex(Set<String> tableNames) throws FileNotFoundException{
		
		PrintWriter pr  =  new PrintWriter(new FileOutputStream("public" + File.separator + "tables" + File.separator + "pages" + File.separator 
		 + File.separator +  "index.html"));
		String ul = "<ul style=\"font-size:12px; margin-top:5px; padding:0px;\">\n";
		TreeSet<String> tset =  new TreeSet(tableNames);
		String ref = "public/tables/pages/";
		for(String tname : tset){
			ul+="<li><a style=\"text-decoration:none; color:white;\" target=\"mateus\" href=\"" + ref + tname+  ".html\">" + tname+  "</a></li>\n";
		}
		ul+="</ul>\n";
		pr.println(ul);
		pr.flush();
		pr.close();
	}
	

	/**Save html $ json js needed by the html*/
	private static void saveTablesToFile() throws FileNotFoundException{
		for(Table t :  tablesMap.values()){
			saveJsonTableToFile(t);
		}
		for(String k : tablesMap.keySet()){
			saveHtmltoFile(tablesMap.get(k));
		}
		
		saveTableIndex(tablesMap.keySet());
	}

	
	/***
	 * Create the menu page!
	 */
	public static void createMenu() {
		// TODO Auto-generated method stub
		MenuSelect mselect = new MenuSelect();
		serviceLocator.getHelpDao().execute(mselect);
		
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
