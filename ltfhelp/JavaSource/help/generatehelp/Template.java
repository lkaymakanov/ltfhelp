package help.generatehelp;

import java.util.ArrayList;
import java.util.List;

public class Template {

	private String template;
	private String templateFileName;
	private String templateDir;
	private String templateKey;
	private String extension;
	private String templateUrl;
	
	private TEMPLATE_TYPE type = TEMPLATE_TYPE.UNKNOWUN;
	private List<String> templateLines = new ArrayList<>();
	private StringBuilder bd = new StringBuilder();
	
	public Template(String templateUrl, String templateKey) {
		// TODO Auto-generated constructor stub
		this.templateKey = templateKey;
		this.templateUrl = templateUrl;
		this.type = TEMPLATE_TYPE.getTypeForExtension(FileUtil.getFileExtension(templateUrl));
		this.templateDir =  FileUtil.getFileDir(templateUrl, "/");
		this.templateFileName = FileUtil.getFileName(templateUrl, "/");
		this.extension = FileUtil.getFileExtension(templateUrl);
	}
	
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

	public String getTemplateDir() {
		return templateDir;
	}

	public String getTemplateKey() {
		return templateKey;
	}

	public String getExtension() {
		return extension;
	}

	public String getTemplateUrl() {
		return templateUrl;
	}
	
}
