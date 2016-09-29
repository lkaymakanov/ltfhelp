package help.generatehelp.data.databasetable;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import help.generatehelp.HelpUtils;
import help.generatehelp.data.SelectItem;
import help.generatehelp.data.decode.DecodeForColumnSelect;

public class DataBaseTableUtil {
	
	private static Map<String, DataBaseTable> tablesMap = new HashMap<String, DataBaseTable>();  
	private static String pathToCss = "../../../css/css.css";
	private static String pathToJs  = "../js";
	
	private static String htmlTemplate = 
			" <html>\n"+
			" <head>\n"+
			" <link   rel=\"stylesheet\" type=\"text/css\" href=\"" + pathToCss + "\">\n"+
			" <script src=\"" + pathToJs +  "/data/@.js\"></script>\n"+
			" <script src=\"" + pathToJs +  "/functions/tablecolumns.js\" ></script>\n"+
			" <meta http-equiv=\"content-type\" content=\"text/html; charset=UTF-8\">\n"+
			" </head>\n"+
			" \n"+
			" <body> \n"+
			" <h1>@<h1>\n"+
			" <div id=\"filtered\"></div>\n"+
			" <script> showFiltered(tablecolumns); </script>\n" +
			" </body>\n"+
			" </html>\n";

	public static void createTables() throws FileNotFoundException{
		DataBaseTableTableColumnsSelesct sel = new DataBaseTableTableColumnsSelesct();
		DecodeForColumnSelect dsel = new DecodeForColumnSelect();
		HelpUtils.getSerServiceLocator().getHelpDao().execute(dsel);
		HelpUtils.getSerServiceLocator().getHelpDao().execute(sel);
		
		//create json  array for each table row
		//PrintWriter pr  =  new PrintWriter(new FileOutputStream("tablecolumnsjson.js"));
		for(DataBaseTableTableColumn c : sel.getColumns()){
			DataBaseTable tbl = tablesMap.get(c.getTableName());
			if(tbl == null) {
				tbl = new DataBaseTable();
				tbl.setTableName(c.getTableName());
				tablesMap.put(c.getTableName(), tbl);
			}
			tbl.getColumns().add(c);
			
			List<SelectItem> decodes =  dsel.getItems(c.getColKey());
			if(decodes !=null){
				c.setDecodeValues(decodes);
			}
		}
		
		saveTablesToFile();
		saveTableIndex(tablesMap.keySet());
		HelpUtils.log(tablesMap.keySet());
	}
	
	
	private static void saveTablesToFile() throws FileNotFoundException{
		for(DataBaseTable t :  tablesMap.values()){
			saveJsonTableToFile(t);
		}
		for(String k : tablesMap.keySet()){
			saveHtmltoFile(tablesMap.get(k));
		}
		
		saveTableIndex(tablesMap.keySet());
	}
	
	//**save each table columns as json*//*
	private static void saveJsonTableToFile(DataBaseTable t) throws FileNotFoundException{
		PrintWriter pr  =  new PrintWriter(new FileOutputStream("public" + File.separator + "tables" + File.separator + "js" + File.separator +   "data"
	    + File.separator +  t.getTableName()+".js"));
		String json = HelpUtils.toJson(t.getColumns(), " var tablecolumns =  ", ";");
		pr.println(json);
		pr.flush();
		pr.close();
	}
	
	
	
	/**Save html for each table*/
	private static void saveHtmltoFile(DataBaseTable t) throws FileNotFoundException{
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
		@SuppressWarnings({ "rawtypes", "unchecked" })
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
	
}
