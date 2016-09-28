package help.generatehelp;

import java.util.ArrayList;
import java.util.List;

public class Template {

	private String template;
	private String templateFileName;
	private TEMPLATE_TYPE type = TEMPLATE_TYPE.UNKNOWUN;
	private List<String> templateLines = new ArrayList<>();
	private StringBuilder bd = new StringBuilder();
	
	public void addLine(String line){
		templateLines.add(line);
		bd.append(line);
		bd.append("\n");
	}

	public String getTemplate() {
		if(template == null) template = bd.toString();
		return template;
	}

	public TEMPLATE_TYPE getType() {
		return type;
	}

	public String getTemplateFileName() {
		return templateFileName;
	}
}
