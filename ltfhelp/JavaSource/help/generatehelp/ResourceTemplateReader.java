package help.generatehelp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/***
 * Reading and loading  a template file from a resource in the jar file itself!!!
 * @author lubo
 *
 */
class ResourceTemplateReader {
	private BufferedReader br;
	private InputStream in;
	private Template template;
	private boolean loaded;
	private String resourceUrl= "";    //path to the template that is loaded from the jar file 
	private String templateKey;
	
	public ResourceTemplateReader(String resourceUrl, String templateKey){
		this.in = ResourceLocator.getResourceStream(resourceUrl);
		this.resourceUrl = resourceUrl;
		this.templateKey = templateKey;
	}
	
	
	
	public Template load() throws IOException{
		System.out.println("======================== LOADING TEMPLATE for URL : " + resourceUrl + " ======== ");
		try{
			if(loaded == true) return template;
			template = new Template(resourceUrl, templateKey);
			HelpUtils.log("Template directory is : " + template.getTemplateDir());
			HelpUtils.log("Template fileName is : " + template.getTemplateFileName());
			HelpUtils.log("Template type is : " + template.getType());
			HelpUtils.log("Template file extension is : " + template.getExtension());
			br = new BufferedReader(new InputStreamReader(in));
			String line;
	    	while( (line = br.readLine()) != null){
	    		HelpUtils.log(line);
	    		template.addLine(line);
	    	}
			loaded = true;
			return template;
		}finally{
			release();
			HelpUtils.log("======================== END LOADING TEMPLATE for URL : " + resourceUrl + " ======== ");
		}
		
	}
	
	private  void release() throws IOException{
		if(br!=null) br.close();
	}
}
