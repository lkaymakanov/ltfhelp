package help.generatehelp;

import java.io.IOException;

public class HelpApplication {
	PropertiesLoader appproperties;    //main application properties file
	JsonDataPropertiesLoader jsonPoperties;  //property files containing json data for  pages
	TemplateLoader htmlTemplateLoader;
	TemplateLoader cssTemplateLoader;
	TemplateLoader jsTemplateLoader;
	
	public void init() throws IOException{
		
		//load main property file
		appproperties = new PropertiesLoader(AppConstants.PATH_TO_APP_PROPERTY_FILE);
		appproperties.load();
		appproperties.printProperties();
		
		//load json data files
		jsonPoperties = new JsonDataPropertiesLoader(appproperties);
		
		
    	//load html templates 
		//new PropertiesLoader(appproperties.getProperties().get(AppConstants.HTML_TEMPLATES_KEY).toString()).load();
		htmlTemplateLoader = new TemplateLoader(new PropertiesLoader(appproperties.getProperties().get(AppConstants.HTML_TEMPLATES_KEY).toString()).load());
		htmlTemplateLoader.load();
		
		//load css
		cssTemplateLoader = new TemplateLoader(new PropertiesLoader(appproperties.getProperties().get(AppConstants.CSS_LINK_FILE_KEY).toString()).load());
		cssTemplateLoader.load();
		
		//load java script
		jsTemplateLoader = new TemplateLoader(new PropertiesLoader(appproperties.getProperties().get(AppConstants.JS_LINK_FILE_KEY).toString()).load());
		jsTemplateLoader.load();
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
