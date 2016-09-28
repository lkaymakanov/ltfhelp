package help.generatehelp;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;
import java.util.Set;
import java.util.TreeSet;

/**Extract resources helper class*/
public class ResourceLocator  {
	
	/**get properties file*/
	private static Properties properties = new Properties();
	private static Set<String> propertyKeys = new TreeSet<String>();
	
	static void initResourceLocator(){
		try {
			properties.load(getResourceStream("prop.properties"));
			for(Object p: properties.keySet()){
				propertyKeys.add(p.toString());
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	static  URL findResourceUrl(String resourceName){
		return ResourceLocator.class.getClassLoader().getResource(resourceName);
	}
	
	static File getResourceFile(String resourceName){
		return new File(findResourceUrl(resourceName).getFile());
	}
	
	static InputStream getResourceStream(String resourceName) {
		return  ResourceLocator.class.getClassLoader().getResourceAsStream(resourceName);
	}
	
	static void printProperties(){
		System.out.println("================ RESOURCES PROPERTIES =============\n");
		for(Object p: properties.keySet()){
			System.out.println(p.toString());
		}
		System.out.println("================END OF RESOURCES PROPERTIES =============\n");
	}
	
	static Set<String> getPropertyKeys(){
		return propertyKeys;
	}
	
	
}
