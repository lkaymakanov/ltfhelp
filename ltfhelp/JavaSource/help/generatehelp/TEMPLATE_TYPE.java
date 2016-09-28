package help.generatehelp;

public enum TEMPLATE_TYPE {
	UNKNOWUN(""),
	TEXT("txt"),
	CSS("css"),
	HTML("html"),
	JS("js");
	
	private String fileExt;
	TEMPLATE_TYPE(String fileExt){
		this.fileExt = fileExt;
	}
	public String getFileExt() {
		return fileExt;
	}

	
	public static TEMPLATE_TYPE getTypeForExtension(String ext){
		for(TEMPLATE_TYPE t : TEMPLATE_TYPE.values()){
			if(t.getFileExt().equals(ext)) return t;
		}
		return null;
	}
	
}
