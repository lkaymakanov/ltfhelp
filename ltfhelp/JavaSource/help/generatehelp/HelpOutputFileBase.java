package help.generatehelp;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

/***
 * The base abstract file to be saved to help directories!!!
 * @author lubo
 *
 */
public abstract class HelpOutputFileBase {
	
	protected String fileContent;
	private String filePath;
	private String fileName;
	private FILE_TYPE ftype = FILE_TYPE.UNKNOWUN;
	
	public HelpOutputFileBase(String filePath, String fileName){
		this.filePath = filePath;
		this.fileName = fileName;
	}
	
	public void saveFileContent() throws UnsupportedEncodingException, IOException{
		if(fileContent == null) createFileContent();
		HelpUtils.writeToFile(fileContent, filePath + File.separator + fileName);
	}
	
	/***
	 * Fills the fileContent attribute based on each file specifics!!!
	 */
	public abstract void createFileContent();

	public String getFileName() {
		return fileName;
	}

	
}
