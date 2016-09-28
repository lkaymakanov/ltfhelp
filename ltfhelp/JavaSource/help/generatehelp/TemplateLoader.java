package help.generatehelp;

import java.io.IOException;
import java.util.Hashtable;
import java.util.Map;
import java.util.Set;

/***
 * Load css javascript html ... etc templates...!!!
 * @author lubo
 *
 */
public class TemplateLoader {

	private Map<String, Template> templates = new Hashtable<String, Template>();
	private Set<String> templateKeys;
	
	public TemplateLoader(Set<String> templateKeys){
		this.templateKeys = templateKeys;
	}
	
	public void load() throws IOException{
		for(String k: templateKeys){
			try{
				templates.put(k, new ResourceTemplateReader(k).load());
			}catch(Exception e){
				System.out.println(e.toString());
				continue;
			}
		}
	}
	
	public Template getTemplate(String key){
		return templates.get(key);
	}
}
