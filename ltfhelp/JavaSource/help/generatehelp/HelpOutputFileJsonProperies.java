package help.generatehelp;


public class HelpOutputFileJsonProperies extends HelpOutputFileBase {

	PropertiesLoader ploader;
	private String prefix;
	private String suffix;
	
	public HelpOutputFileJsonProperies(String filePath, String prexixf, String suffix,  PropertiesLoader ploader) {
		super(filePath, FileUtil.removeFileExtension(FileUtil.getFileName(ploader.getPropFile(), "/")) + ".js");
		this.ploader = ploader;
		this.prefix = prexixf;
		this.suffix = suffix;
	}

	@Override
	public void createFileContent() {
		// TODO Auto-generated method stub
		StringBuilder bd = new StringBuilder();
		bd.append(" var " + FileUtil.removeFileExtension(getFileName()) + " " + prefix); bd.append("\n");
		int i =0;
		int size = ploader.getProperties().values().size();
		for(Object o : ploader.getProperties().values()){
			bd.append(o.toString()); if( i < size-1 )  bd.append(",\n"); else bd.append("\n");
			i++;
		}
		bd.append(suffix); bd.append("\n");
		fileContent = bd.toString(); 
	}

}
