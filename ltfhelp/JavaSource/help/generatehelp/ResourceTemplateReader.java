package help.generatehelp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;


public class ResourceTemplateReader {
	BufferedReader br;
	InputStream in;
	private Template template;
	private boolean loaded;
	
	public ResourceTemplateReader(InputStream in){
		this.in= in;
	}
	
	public Template load() throws IOException{
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
		}
	}
	
	private  void release() throws IOException{
		if(br!=null) br.close();
	}
}
