package help.generatehelp;

import java.io.IOException;
import java.util.Hashtable;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/***
 * Load css javascript html ... etc templates...!!!
 * @author lubo
 *
 */
public class TemplateLoader {

	private Map<String, Template> templates = new Hashtable<String, Template>();
	private Properties properties; 
	private long count;
	
	public TemplateLoader(Properties properties){
		this.properties = properties;
	}
	
	public Properties load() throws IOException{
		Set<Object> keys  = properties.keySet();
		for(Object k: keys){
			try{
				String key = k.toString();
				templates.put(key, new ResourceTemplateReader(properties.getProperty(key), key).load());
			}catch(Exception e){
				HelpUtils.log(e.toString());
				continue;
			}
		}
		count = templates.size();
		return  properties;
	}
	
	public Template getTemplate(String key){
		return templates.get(key);
	}

	public long getCount() {
		return count;
	}
	
	public Set<String> getTemplateKeys(){
		return templates.keySet();
	}

}
