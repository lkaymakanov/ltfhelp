package help.generatehelp;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;

import net.is_bg.ltf.db.common.BindVariableData;

/**
 * Creates the help navigation page with the menus
 * @author lubo
 *<link rel="stylesheet" type="text/css" href="css/css.css">
<script src="js/data/applinks.js"></script>
<script src="js/functions/applinks.js"></script>
<script src="js/functions/expandbutton.js"></script>
 */
public class NavigationPageCreator extends HelpOutputFileBase {
	private Template navigationTemplate;
	private String navigationBasePath;
	private HelpTree htree;
	private List<HtmlLink>  registers = new ArrayList<HtmlLink>();
	private List<HtmlLink>  rdpVpns = new ArrayList<HtmlLink>();
	private List<HtmlLink>  dbCredentials = new ArrayList<HtmlLink>();
	private List<HtmlLink>  ltfUsers = new ArrayList<HtmlLink>();
	private List<HtmlLink>  webServices = new ArrayList<HtmlLink>();
	private List<HtmlLink>  menuDbTables = new ArrayList<HtmlLink>();
	private List<HtmlLink> others = new ArrayList<>();
	private String pathToRoot = "";
	private CssLinksCreator cssLinkCreator;
	private JsLinksCreator jsLinkCreator;
	 
	public NavigationPageCreator(HelpTree htree, String navigationBasePath, Template template){
		super(HelpUtils.replaceDotWithFileSeparator(HelpApplication.PATH_TO_MAIN_HTML), "navigation.html");
		this.navigationBasePath  = navigationBasePath;
		this.navigationTemplate = template;
		this.htree = htree;
		this.pathToRoot = HelpTree.fromFolderToRoot(htree, HelpApplication.PATH_TO_MAIN_HTML);
		
		String pathTojsData = pathToRoot + HelpUtils.replaceDotWithSeparator(HelpApplication.PATH_TO_JS_DATA, "/");
		String pathTojsFunctions = pathToRoot + HelpUtils.replaceDotWithSeparator(HelpApplication.PATH_TO_JS_FUNCTIONS, "/");
		String pathToCss = pathToRoot + HelpUtils.replaceDotWithSeparator(HelpApplication.PATH_TO_CSS, "/");
		List<String> css = new ArrayList<String>();
		List<String> js = new ArrayList<String>();
		
		js.add(pathTojsData + "/applinks.js");
		js.add(pathTojsData + "/testapplinks.js");
		js.add(pathTojsFunctions + "/applinks.js");
		js.add(pathTojsFunctions + "/expandbutton.js");
		css.add(pathToCss+"/css.css");
		cssLinkCreator = new CssLinksCreator(css);
		jsLinkCreator = new  JsLinksCreator(js);
	}
	
	
	//script that creates expand/collapse button!!!
	private String createExpandButtonForUl(String ulName){
		String pathToImages = pathToRoot + HelpUtils.replaceDotWithSeparator(HelpApplication.PATH_TO_IMAGES, "/");
		return HelpUtils.createExpandButtonScript(pathToImages + "/folder_open.png", pathToImages + "/folder.png", new Dimension(32,32), ulName) + "\n";
	}
	
	private String createRigistersUl(){
		String res = "";
		res+=createExpandButtonForUl("registers");
		BindVariableData registerTitle = new BindVariableData();
		registerTitle.setString("REGISTERS");
		res+=(HelpUtils.setTemplateParameters(HelpApplication.EXPANDBUTTON_TEXT, registerTitle))+ "\n";
		res+=(HelpUtils.createUl(registers, "registers", AppConstants.UL_CLASS))+ "\n";
		return res;
	}
	
	private String createMenuDbTablesUl(){
		String res = "";
		res+=createExpandButtonForUl("menudbtables");
		BindVariableData registerTitle = new BindVariableData();
		registerTitle.setString("MENU, TABLE COLUMNS");
		res+=(HelpUtils.setTemplateParameters(HelpApplication.EXPANDBUTTON_TEXT, registerTitle))+ "\n";
		res+=(HelpUtils.createUl(menuDbTables, "menudbtables", AppConstants.UL_CLASS))+ "\n";
		return res;
	}
	
	private String createOthersUl(){
		String res = "";
		res+=createExpandButtonForUl("others");
		BindVariableData registerTitle = new BindVariableData();
		registerTitle.setString("OTHERS");
		res+=(HelpUtils.setTemplateParameters(HelpApplication.EXPANDBUTTON_TEXT, registerTitle))+ "\n";
		res+=(HelpUtils.createUl(others, "others", AppConstants.UL_CLASS))+ "\n";
		return res;
	}
	
	
	private  String createNavigationPage(){
		String param1 = cssLinkCreator.createCssLinks() + "\n" + jsLinkCreator.createJsLinks();
		String param2 = createRealAppUl() +  "\n" + createTestAppUl() + "\n"  + createMenuDbTablesUl()+  "\n" + createRigistersUl() + "\n" + createOthersUl();
		BindVariableData params = new BindVariableData();
		params.setString(param1);
		params.setString(param2);
		return HelpUtils.setTemplateParameters(navigationTemplate, params);
	}
	


	private String createRealAppUl(){
		String res = "";
		res+=createExpandButtonForUl("realdblink");
		BindVariableData registerTitle = new BindVariableData();
		registerTitle.setString("REAL APPS");
		res+=(HelpUtils.setTemplateParameters(HelpApplication.EXPANDBUTTON_TEXT, registerTitle))+ "\n";
		
		res+="<script > \n"+
		"  var realapp = new AppLinks().init_1('realapp', applinks);\n "+
		 " (realapp.writeLinkList('navigation','realdblink')); \n"+
		" </script> \n"+
		" <hr/> \n ";
		return res;
	}
	
	private String createTestAppUl(){
		String res = "";
		res+=createExpandButtonForUl("testdblink");
		BindVariableData registerTitle = new BindVariableData();
		registerTitle.setString("TEST APPS");
		res+=(HelpUtils.setTemplateParameters(HelpApplication.EXPANDBUTTON_TEXT, registerTitle))+ "\n";
		res+=    " <script >\n"+
				 " var testapp = new AppLinks().init_1('testapp', testapplinks);\n "+
				 " (testapp.writeLinkList('navigation','testdblink')); \n"+
				 " </script> \n"+
				 " <hr/> \n";
		return res;
	}
	
	
	

	public List<HtmlLink> getRegisters() {
		return registers;
	}


	public void setRegisters(List<HtmlLink> registers) {
		this.registers = registers;
	}


	public void setOthers(List<HtmlLink> others) {
		this.others = others;
	}


	public void setMenuDbTables(List<HtmlLink> menuDbTables) {
		this.menuDbTables = menuDbTables;
	}


	@Override
	public void createFileContent() {
		// TODO Auto-generated method stub
		fileContent = createNavigationPage();
	}
	
}
