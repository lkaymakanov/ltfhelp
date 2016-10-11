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
	
	
	public NavigationPageCreator(HelpTree htree, String navigationBasePath, Template template){
		super(HelpApplication.PATH_TO_MATEUS_HELP, "navigation.html");
		this.navigationBasePath  = navigationBasePath;
		this.navigationTemplate = template;
		this.htree = htree;
	}
	
	
	//script that creates expand/collapse button!!!
	private String createExpandButtonForUl(String ulName){
		String pathTocss = HelpTree.fromFolderToRoot(htree, HelpApplication.PATH_TO_MATEUS_HELP) + HelpUtils.replaceDotWithSeparator(HelpApplication.PATH_TO_IMAGES, "/");
		return HelpUtils.createExpandButtonScript(pathTocss + "/folder_open.png", pathTocss + "/folder.png", new Dimension(20,20), ulName) + "\n";
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
	
	
	private  String createNavigationPage(){
		return createRigistersUl();
	}
	


	public List<HtmlLink> getRegisters() {
		return registers;
	}


	public void setRegisters(List<HtmlLink> registers) {
		this.registers = registers;
	}


	@Override
	public void createFileContent() {
		// TODO Auto-generated method stub
		fileContent = createNavigationPage();
	}
	
}
