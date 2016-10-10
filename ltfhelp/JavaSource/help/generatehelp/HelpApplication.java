package help.generatehelp;

import help.generatehelp.data.certreg.CertRegUtil;
import help.generatehelp.data.chargereg.ChargeReg;
import help.generatehelp.data.chargereg.ChargeRegUtil;
import help.generatehelp.data.city.CityUtil;
import help.generatehelp.data.country.CountrtyUtil;
import help.generatehelp.data.documenttype.DocumenttypeUtil;
import help.generatehelp.data.exchangereg.ExchangeRegUtil;
import help.generatehelp.data.kinddebtreg.KinddebtregUtil;
import help.generatehelp.data.kindhomeobjreg.KindHomeObjReg;
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

import java.awt.Dimension;
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
	
	private String PATH_TO_TABLE_JS_DATA;
	private String PATH_TO_JS_FUNCTIONS;
	private String PATH_TO_MAIN_HTML;
	private String PATH_TO_TABLE;
	private String PATH_TO_CSS;
	private String PATH_TO_TABLE_JS_FUNCTIONS;
	private String PATH_TO_IMAGES;
	private String PATH_TO_JS_DATA;
	
	//registers  links list
	List<HtmlLink>  registers = new ArrayList<HtmlLink>();
	
	List<HtmlLink>  rdpVpns = new ArrayList<HtmlLink>();
	
	List<HtmlLink>  dbCredentials = new ArrayList<HtmlLink>();
	
	List<HtmlLink>  ltfUsers = new ArrayList<HtmlLink>();
	
	List<HtmlLink>  webServices = new ArrayList<HtmlLink>();
	
	List<HtmlLink>  menuDbTables = new ArrayList<HtmlLink>();
	
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
		

    	//load html templates 
		htmlTemplateLoader = new TemplateLoader(new PropertiesLoader(appproperties.getProperties().get(AppConstants.HTML_TEMPLATES_KEY).toString()).load());
		htmlTemplateLoader.load();
		
		//load json data files & save them to output json file files!!!
		jsonProperties = new JsonDataPropertiesLoader(appproperties);
		for(PropertiesLoader l : jsonProperties.getJsonData()){
			new HelpOutputFileJsonProperies(HelpUtils.replaceDotWithFileSeparator(PATH_TO_JS_DATA), " = [ ", " ]; ", l).saveFileContent();
			
			//save html for json properties data data
			saveRegisterTableHtml(htree, FileUtil.removeFileExtension(FileUtil.getFileName(l.getPropFile(), "/")));
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
		HelpUtils.writeToFile("var city = " +CityUtil.createCity()+ ";", HelpUtils.replaceDotWithFileSeparator(PATH_TO_JS_DATA) + File.separator +  "city.js");
		HelpUtils.writeToFile("var patentactivityreg = " +PatentActivityRegUtil.createPatentActivityReg()+ ";", HelpUtils.replaceDotWithFileSeparator(PATH_TO_JS_DATA) + File.separator +  "patentactivityreg.js");
		HelpUtils.writeToFile("var province = " +ProvinceUtil.createProvince()+ ";", HelpUtils.replaceDotWithFileSeparator(PATH_TO_JS_DATA) + File.separator +  "province.js");
		HelpUtils.writeToFile("var reasonreg = " +ReasonRegUtil.createReasonReg()+ ";", HelpUtils.replaceDotWithFileSeparator(PATH_TO_JS_DATA) + File.separator +  "reasonreg.js");
		HelpUtils.writeToFile("var regnumber = " +RegNumberUtil.createRegNumber()+ ";", HelpUtils.replaceDotWithFileSeparator(PATH_TO_JS_DATA) + File.separator +  "regnumber.js");
		HelpUtils.writeToFile("var servicereg = " +ServiceRegUtil.createServiceReg()+ ";", HelpUtils.replaceDotWithFileSeparator(PATH_TO_JS_DATA) + File.separator +  "servicereg.js");
		HelpUtils.writeToFile("var taxperiod = " +TaxperiodUtil.createTaxperiod()+ ";", HelpUtils.replaceDotWithFileSeparator(PATH_TO_JS_DATA) + File.separator +  "taxperiod.js");
		HelpUtils.writeToFile("var transpmeansreg = " +TranspmeansRegUtil.createTranspmeansReg()+ ";", HelpUtils.replaceDotWithFileSeparator(PATH_TO_JS_DATA) + File.separator +  "transpmeansreg.js");
		
		
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
		
		
		//create navigation page
		
		//create main page
		
		
		System.out.println("End");
		
	}
	
	
	/**
	 * A javasctipt that creates toggle button with image!!!
	 * @param openFolderimage
	 * @param folderImage
	 * @param dimension
	 * @param elemetnId
	 * @return
	 */
	private String createExpandButtonScript(String openFolderimage, String folderImage, Dimension dimension, String elemetnId){
		String s = " createExpandButton('" + openFolderimage +"',  '" + folderImage +"'," +
	    dimension.height +"," + dimension.width  +" , 'false', 'function(el){showelement(\'" + elemetnId + "\', true);}' , 'function(el){showelement(\'" + elemetnId + "\', false);}');";
		return "<script>" + s + "</script>";
 	}
	

	/***
	 * Creates ul list with links to pages!!!
	 * @param links
	 * @param ulId
	 * @param ulclass
	 * @return
	 */
	private String createUl(List<HtmlLink> links, String ulId, String ulclass){
		String ul =  "<ul class=\"" + ulclass + "\"  style=\"display:none;\" id=\""+ulId +"\">\n";
		for(HtmlLink l : links){
			ul+="<li>"+l.toString() +"</li>\n";
		}
		return ul + "</ul> </hr>";
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
	
	//DecodeTypesSelect s = new DecodeTypesSelect();
    //getServiceLocator().getActDao().execute(s);
    //s.getResult();
    //HelpUtils.createTables();
    //HelpUtils.createMenu();
    //System.out.println(HelpUtils.getDecodeTypeAsJson());
    //MenuUtil.createMenu();
    //TaxperiodUtil.createTaxperiod();
    //CountrtyUtil.createCountry();
    //DocumenttypeUtil.createDocumentType();
    //KinddebtregUtil.createKindDebtReg();
    //MunicipalityUtil.createMunicipality();
	//CertRegUtil.createSortingFunctions();
	//CertRegUtil.createCertReg();
	//CityUtil.createCity();
	//CityUtil.createSortingFunctions();
	//MenuUtil.createMenu();
	//MenuUtil.createSortingFunctions();
	//CountrtyUtil.createCountry();
	//DocumenttypeUtil.createDocumentType();
	//System.out.println(DecodeTypeUtils.getDecodeTypeAsJson());
	//MenuUtil.createMenu();
	//ExchangeRegUtil.createExchangeReg();
	//ExchangeRegUtil.createSortingFunctions();
	//KindHomeObjRegUtil.createKindHomeObjReg();
	//KindHomeObjRegUtil.createSortingFunctions();
	//KindParRegUtil.createKindParreg();
	//KindParRegUtil.createSortingFunctions();
	/*MunicipalityUtil.createMunicipality();
	MunicipalityUtil.createSortingFunctions();
    PatentActivityRegUtil.createPatentActivityReg();
	PatentActivityRegUtil.createSortingFunctions();
	ProvinceUtil.createProvince();
	ProvinceUtil.createSortingFunctions();
	ReasonRegUtil.createReasonReg();
	ReasonRegUtil.createSortingFunctions();
	RegNumberUtil.createRegNumber();
	RegNumberUtil.createSortingFunctions();
	TranspmeansRegUtil.createTranspmeansReg();
	TranspmeansRegUtil.createSortingFunctions();
	ServiceRegUtil.createServiceReg();
	ServiceRegUtil.createSortingFunctions();*/
	
	
	
}
