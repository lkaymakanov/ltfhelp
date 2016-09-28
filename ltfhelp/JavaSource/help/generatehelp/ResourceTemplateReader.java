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
public class ResourceTemplateReader {
	BufferedReader br;
	InputStream in;
	private Template template;
	private boolean loaded;
	private String resourceUrl= "";
	
	public ResourceTemplateReader(String resourceUrl){
		this.in = ResourceLocator.getResourceStream(resourceUrl);
		this.resourceUrl = resourceUrl;
	}
	
	
	
	public Template load() throws IOException{
		System.out.println("======================== LOADING TEMPLATE for URL : " + resourceUrl + " ======== ");
		try{
			if(loaded == true) return template;
			template = new Template();
			br = new BufferedReader(new InputStreamReader(in));
			String line;
	    	while( (line = br.readLine()) != null){
	    		System.out.println(line);
	    		template.addLine(line);
	    	}
			loaded = true;
			return template;
		}finally{
			release();
			System.out.println("======================== END LOADING TEMPLATE for URL : " + resourceUrl + " ======== ");
		}
		
	}
	
	private  void release() throws IOException{
		if(br!=null) br.close();
	}
}
