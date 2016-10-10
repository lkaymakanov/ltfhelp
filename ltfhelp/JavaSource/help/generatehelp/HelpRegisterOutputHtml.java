package help.generatehelp;

import java.util.List;

import net.is_bg.ltf.db.common.BindVariableData;

public class HelpRegisterOutputHtml extends HelpOutputFileBase {

	private List<String> pathsTojs;
	private List<String> pathsTocss;
	private Template template;
	private String param2 = "<script>\n"+
	"  var tc = new TableCreator().init_1('tableDiv', {1P}, getObjectPropertyNames({2P}[0]));\n "+
	" (tc.createTableForCurrentTableId());\n"+
	" </script>\n";
	
	
	public HelpRegisterOutputHtml(String filePath, String fileName, Template template,  List<String> pathsTojs,  List<String> pathsTocss, String arrayName){
		this(filePath, fileName);
		this.template = template;
		this.pathsTocss = pathsTocss;
		this.pathsTojs = pathsTojs;
		BindVariableData bd =	new BindVariableData();
		bd.setString(arrayName);
		bd.setString(arrayName);
		param2 = HelpUtils.setTemplateParameters(param2, bd );
	}
	
	public HelpRegisterOutputHtml(String filePath, String fileName) {
		super(filePath, fileName);
		// TODO Auto-generated constructor stub
		
	}
	
	
	private String createCssLinks(){
		String s = "";
		for(String css:pathsTocss){
			s+=	"<link rel=\"stylesheet\" type=\"text/css\" href=\""+ css+   "\">\n";
		}
		return s;
	}
	
	private String createJsLinks(){
		String s = "";
		for(String js:pathsTojs){
			s+="<script src=\"" + js+ "\"></script>\n";
		}
		return s;
	}
	

	

	@Override
	public void createFileContent() {
		// TODO Auto-generated method stub
		BindVariableData bd = new BindVariableData();
		bd.setString(createCssLinks() + "\n" + createJsLinks());
		bd.setString(param2);
		fileContent = HelpUtils.setTemplateParameters(template.getTemplate(), bd);
	}

}
