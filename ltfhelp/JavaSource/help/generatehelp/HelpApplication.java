package help.generatehelp;

import help.generatehelp.data.certreg.CertRegUtil;
import help.generatehelp.data.chargereg.ChargeRegUtil;
import help.generatehelp.data.city.CityUtil;
import help.generatehelp.data.country.CountrtyUtil;
import help.generatehelp.data.databasetable.DataBaseTableUtil;
import help.generatehelp.data.documenttype.DocumenttypeUtil;
import help.generatehelp.data.exchangereg.ExchangeRegUtil;
import help.generatehelp.data.kinddebtreg.KinddebtregUtil;
import help.generatehelp.data.kindhomeobjreg.KindHomeObjRegUtil;
import help.generatehelp.data.kindparreg.KindParRegUtil;
import help.generatehelp.data.menu.MenuUtil;
import help.generatehelp.data.municipality.MunicipalityUtil;
import help.generatehelp.data.patentactivityreg.PatentActivityRegUtil;
import help.generatehelp.data.province.ProvinceUtil;
import help.generatehelp.data.reasonreg.ReasonRegUtil;
import help.generatehelp.data.regnumber.RegNumberUtil;
import help.generatehelp.data.servicereg.ServiceRegUtil;
import help.generatehelp.data.taxperiod.TaxperiodUtil;
import help.generatehelp.data.transpmeansreg.TranspmeansRegUtil;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;


public class HelpApplication {
	private PropertiesLoader appproperties;    		 	//main application properties file
	private JsonDataPropertiesLoader jsonProperties;  	//property files containing json data for  pages
	private TemplateLoader htmlTemplateLoader;          
	private TemplateLoader cssTemplateLoader;           
	private TemplateLoader jsTemplateLoader;
	private PropertiesLoader helpOutputPaths;
	
	public static String PATH_TO_TABLE_JS_DATA;
	public static String PATH_TO_JS_FUNCTIONS;
	public static String PATH_TO_MAIN_HTML;
	public static String PATH_TO_TABLE;
	public static String PATH_TO_CSS;
	public static String PATH_TO_TABLE_JS_FUNCTIONS;
	public static String PATH_TO_IMAGES;
	public static String PATH_TO_JS_DATA;
	public static String PATH_TO_MATEUS_HELP;
	public final static String EXPANDBUTTON_TEXT = "<span class=\"expandbuttontitle\">{1P}:</span>";
	
	//registers  links list
	List<HtmlLink>  registers = new ArrayList<HtmlLink>();
	List<HtmlLink>  others = new ArrayList<HtmlLink>();
	List<HtmlLink>  menuDbTables = new ArrayList<HtmlLink>();
	
/*	List<HtmlLink>  rdpVpns = new ArrayList<HtmlLink>();
	List<HtmlLink>  dbCredentials = new ArrayList<HtmlLink>();
	List<HtmlLink>  ltfUsers = new ArrayList<HtmlLink>();
	List<HtmlLink>  webServices = new ArrayList<HtmlLink>();
	
	*/
	
	
	public void init() throws IOException{
		
		//load main property file
		appproperties = new PropertiesLoader(AppConstants.PATH_TO_APP_PROPERTY_FILE);
		appproperties.load();
		appproperties.printProperties();
		
		
		//load help directory tree structure properties
		PropertiesLoader helpTreeProperties = new PropertiesLoader(appproperties.getProperties().get(AppConstants.HELP_STRUCTURE_KEY).toString());
		helpTreeProperties.load();
		helpTreeProperties.printProperties();
		
		//help tree memory representation
		HelpTree htree = 	new HelpTree(helpTreeProperties.getProperties()).constructTree();
		htree.printTree();
		htree.createHelpDirectories();
		
		
		
		
		//load help output properties
		helpOutputPaths = new PropertiesLoader(AppConstants.PATH_TO_HELP_OUTPUT_PATHS);
		helpOutputPaths.load();
		helpOutputPaths.printProperties();
		
		
		//get paths to output help folders
		PATH_TO_TABLE_JS_DATA  = helpOutputPaths.getProperties().getProperty(AppConstants.PATH_TO_TABLE_JS_DATA_KEY);
		PATH_TO_JS_FUNCTIONS = (helpOutputPaths.getProperties().getProperty(AppConstants.PATH_TO_JS_FUNCTIONS_KEY));
		PATH_TO_MAIN_HTML = (helpOutputPaths.getProperties().getProperty(AppConstants.PATH_TO_MAIN_HTML_KEY));
		PATH_TO_TABLE = (helpOutputPaths.getProperties().getProperty(AppConstants.PATH_TO_TABLE_KEY));
		PATH_TO_CSS = (helpOutputPaths.getProperties().getProperty(AppConstants.PATH_TO_CSS_KEY));
		PATH_TO_TABLE_JS_FUNCTIONS = (helpOutputPaths.getProperties().getProperty(AppConstants.PATH_TO_TABLE_JS_FUNCTIONS_KEY));
		PATH_TO_IMAGES = (helpOutputPaths.getProperties().getProperty(AppConstants.PATH_TO_IMAGES_KEY));
		PATH_TO_JS_DATA = (helpOutputPaths.getProperties().getProperty(AppConstants.PATH_TO_JS_DATA_KEY));
		PATH_TO_MATEUS_HELP = (helpOutputPaths.getProperties().getProperty(AppConstants.PATH_TO_MATUES_HELP_KEY));
		
		//the path from main html folder to root + path to main html
		String base = HelpTree.fromFolderToRoot(htree, PATH_TO_MAIN_HTML) + HelpUtils.replaceDotWithSeparator(PATH_TO_MAIN_HTML, "/") + "/";

    	//load html templates 
		htmlTemplateLoader = new TemplateLoader(new PropertiesLoader(appproperties.getProperties().get(AppConstants.HTML_TEMPLATES_KEY).toString()).load());
		htmlTemplateLoader.load();
		
		//load json data files & save them to output json file files!!!
		jsonProperties = new JsonDataPropertiesLoader(appproperties);
		for(PropertiesLoader l : jsonProperties.getJsonData()){
			new HelpOutputFileJsonProperies(HelpUtils.replaceDotWithFileSeparator(PATH_TO_JS_DATA), " = [ ", " ]; ", l).saveFileContent();
			
			//save html for json properties data data
			String name = FileUtil.removeFileExtension(FileUtil.getFileName(l.getPropFile(), "/"));
			saveRegisterTableHtml(htree, name);
			
			//create html link to page
			others.add(new HtmlLink(base, name + ".html", AppConstants.TARGET, "", AppConstants.ULLINKS_CLASS, name.toUpperCase()));
		}
		
		//save html templates
		for(String k: htmlTemplateLoader.getTemplateKeys()){
		 	new HelpOutputFileTemplate(HelpUtils.replaceDotWithFileSeparator(PATH_TO_MAIN_HTML), htmlTemplateLoader.getTemplate(k)).saveFileContent();
		}
		
		//load css
		cssTemplateLoader = new TemplateLoader(new PropertiesLoader(appproperties.getProperties().get(AppConstants.CSS_LINK_FILE_KEY).toString()).load());
		cssTemplateLoader.load();
		
		//save css to file !!!
		for(String k: cssTemplateLoader.getTemplateKeys()){
		 	new HelpOutputFileTemplate(HelpUtils.replaceDotWithFileSeparator(PATH_TO_CSS), cssTemplateLoader.getTemplate(k)).saveFileContent();
		}
		
		//save images to output image files files
		HelpUtils.writeToFile(ResourceLocator.getResourceStream("resources/images/folder.png"), HelpUtils.replaceDotWithFileSeparator(PATH_TO_IMAGES) + File.separator + "folder.png");
		HelpUtils.writeToFile(ResourceLocator.getResourceStream("resources/images/folder_open.png"), HelpUtils.replaceDotWithFileSeparator(PATH_TO_IMAGES) + File.separator + "folder_open.png");
		HelpUtils.writeToFile(ResourceLocator.getResourceStream("resources/images/search.png"), HelpUtils.replaceDotWithFileSeparator(PATH_TO_IMAGES) + File.separator + "search.png");
		
		
		//load java script
		jsTemplateLoader = new TemplateLoader(new PropertiesLoader(appproperties.getProperties().get(AppConstants.JS_LINK_FILE_KEY).toString()).load());
		jsTemplateLoader.load();
		
		//save js functions to output file!!!
		for(String k: jsTemplateLoader.getTemplateKeys()){
		 	new HelpOutputFileTemplate(HelpUtils.replaceDotWithFileSeparator(PATH_TO_JS_FUNCTIONS), jsTemplateLoader.getTemplate(k)).saveFileContent();
		}
		
		//create menu data 
		MenuUtil.createMenu();
		StringBuilder bd = new StringBuilder();
		bd.append(MenuUtil.getMenuNodes()); bd.append(MenuUtil.getRootNodes());
		HelpUtils.writeToFile(bd.toString(), HelpUtils.replaceDotWithFileSeparator(PATH_TO_JS_DATA) + File.separator +  "menu.js");
		

		//create javascript data files for each register
		HelpUtils.writeToFile("var certreg = " + CertRegUtil.createCertReg() + ";", HelpUtils.replaceDotWithFileSeparator(PATH_TO_JS_DATA) + File.separator +  "certreg.js");
		HelpUtils.writeToFile("var chargereg = " +ChargeRegUtil.createChargeReg()+ ";", HelpUtils.replaceDotWithFileSeparator(PATH_TO_JS_DATA) + File.separator +  "chargereg.js");
		HelpUtils.writeToFile("var country = " +CountrtyUtil.createCountry()+ ";", HelpUtils.replaceDotWithFileSeparator(PATH_TO_JS_DATA) + File.separator +  "country.js");
		HelpUtils.writeToFile("var doctype = " +DocumenttypeUtil.createDocumentType()+ ";", HelpUtils.replaceDotWithFileSeparator(PATH_TO_JS_DATA) + File.separator +  "doctype.js");
		HelpUtils.writeToFile("var kinddebtreg = " +KinddebtregUtil.createKindDebtReg()+ ";", HelpUtils.replaceDotWithFileSeparator(PATH_TO_JS_DATA) + File.separator +  "kinddebtreg.js");
		HelpUtils.writeToFile("var exchangereg = " +ExchangeRegUtil.createExchangeReg()+ ";", HelpUtils.replaceDotWithFileSeparator(PATH_TO_JS_DATA) + File.separator +  "exchangereg.js");
		HelpUtils.writeToFile("var kindhomeobjreg = " +KindHomeObjRegUtil.createKindHomeObjReg()+ ";", HelpUtils.replaceDotWithFileSeparator(PATH_TO_JS_DATA) + File.separator +  "kindhomeobjreg.js");
		HelpUtils.writeToFile("var kindparreg = " +KindParRegUtil.createKindParreg()+ ";", HelpUtils.replaceDotWithFileSeparator(PATH_TO_JS_DATA) + File.separator +  "kindparreg.js");
		HelpUtils.writeToFile("var municipality = " +MunicipalityUtil.createMunicipality()+ ";", HelpUtils.replaceDotWithFileSeparator(PATH_TO_JS_DATA) + File.separator +  "municipality.js");
		HelpUtils.writeToFile("var city = " + CityUtil.createCity()+ ";", HelpUtils.replaceDotWithFileSeparator(PATH_TO_JS_DATA) + File.separator +  "city.js");
		HelpUtils.writeToFile("var patentactivityreg = " +PatentActivityRegUtil.createPatentActivityReg()+ ";", HelpUtils.replaceDotWithFileSeparator(PATH_TO_JS_DATA) + File.separator +  "patentactivityreg.js");
		HelpUtils.writeToFile("var province = " +ProvinceUtil.createProvince()+ ";", HelpUtils.replaceDotWithFileSeparator(PATH_TO_JS_DATA) + File.separator +  "province.js");
		HelpUtils.writeToFile("var reasonreg = " +ReasonRegUtil.createReasonReg()+ ";", HelpUtils.replaceDotWithFileSeparator(PATH_TO_JS_DATA) + File.separator +  "reasonreg.js");
		HelpUtils.writeToFile("var regnumber = " +RegNumberUtil.createRegNumber()+ ";", HelpUtils.replaceDotWithFileSeparator(PATH_TO_JS_DATA) + File.separator +  "regnumber.js");
		HelpUtils.writeToFile("var servicereg = " +ServiceRegUtil.createServiceReg()+ ";", HelpUtils.replaceDotWithFileSeparator(PATH_TO_JS_DATA) + File.separator +  "servicereg.js");
		HelpUtils.writeToFile("var taxperiod = " +TaxperiodUtil.createTaxperiod()+ ";", HelpUtils.replaceDotWithFileSeparator(PATH_TO_JS_DATA) + File.separator +  "taxperiod.js");
		HelpUtils.writeToFile("var transpmeansreg = " +TranspmeansRegUtil.createTranspmeansReg()+ ";", HelpUtils.replaceDotWithFileSeparator(PATH_TO_JS_DATA) + File.separator +  "transpmeansreg.js");
		HelpUtils.writeToFile("var tablecolumns =  " + DataBaseTableUtil.getTableColumsAsJson()+ ";", HelpUtils.replaceDotWithFileSeparator(PATH_TO_JS_DATA) + File.separator +  "tablecolumns.js");
		
		//create html file for each register table
		saveRegisterTableHtml(htree, "certreg");
		saveRegisterTableHtml(htree, "chargereg");
		saveRegisterTableHtml(htree, "country");
		saveRegisterTableHtml(htree, "doctype");
		saveRegisterTableHtml(htree, "kinddebtreg");
		saveRegisterTableHtml(htree, "exchangereg");
		saveRegisterTableHtml(htree, "kindhomeobjreg");
		saveRegisterTableHtml(htree, "kindparreg");
		saveRegisterTableHtml(htree, "municipality");
		saveRegisterTableHtml(htree, "city");
		saveRegisterTableHtml(htree, "patentactivityreg");
		saveRegisterTableHtml(htree, "province");
		saveRegisterTableHtml(htree, "reasonreg");
		saveRegisterTableHtml(htree, "regnumber");
		saveRegisterTableHtml(htree, "servicereg");
		saveRegisterTableHtml(htree, "taxperiod");
		saveRegisterTableHtml(htree, "transpmeansreg");
		
		
		//add links to register pages in register list
		registers.add(new HtmlLink(base, "certreg.html", AppConstants.TARGET, "", AppConstants.ULLINKS_CLASS, "CERTREG"));
		registers.add(new HtmlLink(base, "chargereg.html", AppConstants.TARGET, "", AppConstants.ULLINKS_CLASS, "CHARGREREG"));
		registers.add(new HtmlLink(base, "country.html", AppConstants.TARGET, "", AppConstants.ULLINKS_CLASS, "COUNTRY"));
		registers.add(new HtmlLink(base, "doctype.html", AppConstants.TARGET, "", AppConstants.ULLINKS_CLASS, "DOCTYPE"));
		registers.add(new HtmlLink(base, "kinddebtreg.html", AppConstants.TARGET, "", AppConstants.ULLINKS_CLASS, "KINDDEBTREG"));
		registers.add(new HtmlLink(base, "exchangereg.html", AppConstants.TARGET, "", AppConstants.ULLINKS_CLASS, "EXCHANGEREG"));
		registers.add(new HtmlLink(base, "kindhomeobjreg.html", AppConstants.TARGET, "", AppConstants.ULLINKS_CLASS, "KINDHOMEOBJREG"));
		registers.add(new HtmlLink(base, "kindparreg.html", AppConstants.TARGET, "", AppConstants.ULLINKS_CLASS, "KINDPARREG"));
		registers.add(new HtmlLink(base, "municipality.html", AppConstants.TARGET, "", AppConstants.ULLINKS_CLASS, "MUNICIPALITY"));
		registers.add(new HtmlLink(base, "city.html", AppConstants.TARGET, "", AppConstants.ULLINKS_CLASS, "CITY"));
		registers.add(new HtmlLink(base, "patentactivityreg.html", AppConstants.TARGET, "", AppConstants.ULLINKS_CLASS, "PATENTACTIVITYREG"));
		registers.add(new HtmlLink(base, "province.html",AppConstants.TARGET, "", AppConstants.ULLINKS_CLASS, "PROVINCE"));
		registers.add(new HtmlLink(base, "reasonreg.html",AppConstants.TARGET, "", AppConstants.ULLINKS_CLASS, "REASONREG"));
		registers.add(new HtmlLink(base, "regnumber.html",AppConstants.TARGET, "", AppConstants.ULLINKS_CLASS, "REGNUMBER"));
		registers.add(new HtmlLink(base, "servicereg.html",AppConstants.TARGET, "", AppConstants.ULLINKS_CLASS, "SERVICEREG"));
		registers.add(new HtmlLink(base, "taxperiod.html",AppConstants.TARGET, "", AppConstants.ULLINKS_CLASS, "TAXPERIOD"));
		registers.add(new HtmlLink(base, "transpmeansreg.html",AppConstants.TARGET, "", AppConstants.ULLINKS_CLASS, "TRANSPMEANSREG"));
		
		//add links to menu & db tables
		menuDbTables.add(new HtmlLink(base, "menu.html", AppConstants.TARGET, "", AppConstants.ULLINKS_CLASS, "MENU"));
		menuDbTables.add(new HtmlLink(base, "tablecolumnsearch.html", AppConstants.TARGET, "", AppConstants.ULLINKS_CLASS, "TABLE_COLUMNS"));
		
		//create navigation page
		NavigationPageCreator navpage = new NavigationPageCreator(htree, base, htmlTemplateLoader.getTemplate("navigation"));
		navpage.setRegisters(registers);
		navpage.setOthers(others);
		navpage.setMenuDbTables(menuDbTables);
		navpage.saveFileContent();
		
		
		
		//create main page
		System.out.println("End");
		
	}
	
	

	
	
	/**Save  html file for register*/
	private void saveRegisterTableHtml(HelpTree htree, String regName ) throws UnsupportedEncodingException, IOException{
		String pathFromMainDirToJsData = HelpTree.routeFromDirToDir(htree, PATH_TO_MAIN_HTML, PATH_TO_JS_DATA);
		String pathFromMaindirtoCss = HelpTree.routeFromDirToDir(htree, PATH_TO_MAIN_HTML, PATH_TO_CSS);
		String pathFromMainDirtoFunc =  HelpTree.routeFromDirToDir(htree, PATH_TO_MAIN_HTML, PATH_TO_JS_FUNCTIONS);
		
		List<String> pathFromMainDirToJsDatalist = new ArrayList<String>();
		List<String> pathFromMaindirtoCsslist = new ArrayList<String>();
		
		pathFromMainDirToJsDatalist.add(pathFromMainDirToJsData + "/" + regName + ".js");
		pathFromMainDirToJsDatalist.add(pathFromMainDirtoFunc + "/" + "common.js");
		pathFromMainDirToJsDatalist.add(pathFromMainDirtoFunc + "/" + "createtable.js");
		pathFromMaindirtoCsslist.add(pathFromMaindirtoCss + "/"+ "css.css");
		
		new HelpRegisterOutputHtml(HelpUtils.replaceDotWithFileSeparator(PATH_TO_MAIN_HTML), regName+ ".html", 
				htmlTemplateLoader.getTemplate("table_template"),
				pathFromMainDirToJsDatalist, pathFromMaindirtoCsslist, regName).saveFileContent();
	}
	
	
	
	
}
