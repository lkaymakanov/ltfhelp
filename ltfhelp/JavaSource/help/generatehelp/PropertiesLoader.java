package help.generatehelp;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Properties;

/***
 * Load properties from property file
 * @author lubo
 *
 */
public class PropertiesLoader {

	private  Properties properties = new Properties();
	private String propFile;
	
	PropertiesLoader(String propFile){
		this.propFile = propFile; 
	}
	
	Properties load(){
		try {
			properties.load(ResourceLocator.getResourceStream(propFile));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return properties;
	}

	void printProperties(){
		HelpUtils.log("================ RESOURCES PROPERTIES FOR PROPERTY FILE " + propFile +"  =============\n");
		for(Object p: properties.keySet()){
			String key = p.toString();
			HelpUtils.log("key = " + key + " : value = " + properties.getProperty(key));
		}
		HelpUtils.log("================END OF RESOURCES PROPERTIES =============\n");
	}

	public Properties getProperties() {
		return properties;
	}

	public Enumeration<Object> getPropertyKeys() {
		return properties.keys();
	}

	public String getPropFile() {
		return propFile;
	}
	
	
	
}
