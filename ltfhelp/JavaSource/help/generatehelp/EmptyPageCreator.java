package help.generatehelp;

import java.util.ArrayList;
import java.util.List;

import net.is_bg.ltf.db.common.BindVariableData;

public class EmptyPageCreator  extends HelpOutputFileBase{
	
	private CssLinksCreator cssLinkCreator;
	private String pathToRoot;
	private Template template;
	private List<StringToJsonWrapper> helpimages;

	public EmptyPageCreator(HelpTree htree,  Template template, List<StringToJsonWrapper> helpimages) {
		super(HelpUtils.replaceDotWithFileSeparator(HelpApplication.PATH_TO_MAIN_HTML), "empty.html");
		pathToRoot = HelpTree.fromFolderToRoot(htree, HelpApplication.PATH_TO_MAIN_HTML);
		// TODO Auto-generated constructor stub
		String pathToCss = pathToRoot + HelpUtils.replaceDotWithSeparator(HelpApplication.PATH_TO_CSS, "/");
		List<String> css = new ArrayList<String>();
		css.add(pathToCss+"/css.css");
		cssLinkCreator = new CssLinksCreator(css);
		this.template = template;
		this.helpimages = helpimages;
	}
	
	private  String createEmptyPage(){
		String param1 = cssLinkCreator.createCssLinks() + "\n";
		String param2 = "";
		param2 = HelpUtils.toJson(helpimages, "var images = ", ";");
		param2 += " document.write('<img src=\"' + '" +pathToRoot + HelpUtils.replaceDotWithSeparator(HelpApplication.PATH_TO_IMAGES, "/") +  "/' + images[Math.floor(Math.random()*(images.length - 0) + 0)] + '\"/>');";
		param2 = "<script>\n" + param2 + "</script>\n";
		BindVariableData params = new BindVariableData();
		params.setString(param1);
		params.setString(param2);
		return HelpUtils.setTemplateParameters(template, params);
	}

	@Override
	public void createFileContent() {
		// TODO Auto-generated method stub
		fileContent = createEmptyPage();
	}
	
	
	
	
}
