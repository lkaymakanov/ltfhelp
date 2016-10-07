package help.generatehelp;

import help.generatehelp.data.menu.MenuUtil;

import java.io.File;
import java.io.IOException;

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
	
	
	public void init() throws IOException{
		
		//load main property file
		appproperties = new PropertiesLoader(AppConstants.PATH_TO_APP_PROPERTY_FILE);
		appproperties.load();
		appproperties.printProperties();
		
		//load help directory tree structure properties
		PropertiesLoader helpTreeProperties = 	new PropertiesLoader(appproperties.getProperties().get(AppConstants.HELP_STRUCTURE_KEY).toString());
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
		
		
		
		//load json data files & save them to output files!!!
		jsonProperties = new JsonDataPropertiesLoader(appproperties);
		for(PropertiesLoader l : jsonProperties.getJsonData()){
			new HelpOutputFileJsonProperies(HelpUtils.replaceDotWithFileSeparator(PATH_TO_JS_DATA), " = [ ", " ]; ", l).saveFileContent();
		}

    	//load html templates 
		htmlTemplateLoader = new TemplateLoader(new PropertiesLoader(appproperties.getProperties().get(AppConstants.HTML_TEMPLATES_KEY).toString()).load());
		htmlTemplateLoader.load();
		
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
		
		
		System.out.println("End");
		//jsTemplateLoader.
		//new HelpOutputFileJsonProperies(HelpUtils.replaceDotWithFileSeparator(PATH_TO_JS_DATA), " = [ ", " ]; ", jsTemplateLoader.ge).saveFileContent();
		
		//
		
		//
		/*CityUtil.createCity();
		ExchangeRegUtil.createExchangeReg();
		KindHomeObjRegUtil.createKindHomeObjReg();
		KindParRegUtil.createKindParreg();
	    PatentActivityRegUtil.createPatentActivityReg();
		ReasonRegUtil.createReasonReg();
		RegNumberUtil.createRegNumber();
		TranspmeansRegUtil.createTranspmeansReg();
		ServiceRegUtil.createServiceReg();*/
		
		
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
