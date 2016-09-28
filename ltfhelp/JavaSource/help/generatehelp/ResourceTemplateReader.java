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
	
	public BufferedReader getReader(){
		if(br == null) br = new BufferedReader(new InputStreamReader(in));
		return br;
	}
	
	public Template load() throws IOException{
		if(loaded == true) return template;
		template = new Template();
		
		release();
		loaded = true;
		return template;
	}
	
	private  void release() throws IOException{
		if(br!=null) br.close();
	}
}
