package help.generatehelp;

public enum FILE_TYPE {
	UNKNOWUN(""),
	TEXT("txt"),
	CSS("css"),
	HTML("html"),
	JS("js");
	
	private String fileExt;
	FILE_TYPE(String fileExt){
		this.fileExt = fileExt;
	}
	public String getFileExt() {
		return fileExt;
	}

	
	public static FILE_TYPE getTypeForExtension(String ext){
		for(FILE_TYPE t : FILE_TYPE.values()){
			if(t.getFileExt().equals(ext)) return t;
		}
		return null;
	}
	
}
