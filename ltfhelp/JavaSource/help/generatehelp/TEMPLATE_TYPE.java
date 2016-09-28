package help.generatehelp;

public enum TEMPLATE_TYPE {
	TEXT("txt"),
	CSS("css"),
	HTML("html"),
	JS("js");
	
	private String fileExt, templateFileName;
	TEMPLATE_TYPE(String fileExt){
		this.fileExt = fileExt;
	}
	public String getFileExt() {
		return fileExt;
	}
	public String getTemplateFileName() {
		return templateFileName;
	}
	public void setTemplateFileName(String templateFileName) {
		this.templateFileName = templateFileName;
	}
	
	public static TEMPLATE_TYPE getTypeForExtension(String ext){
		for(TEMPLATE_TYPE t : TEMPLATE_TYPE.values()){
			if(t.getFileExt().equals(ext)) return t;
		}
		return null;
	}
	
}
