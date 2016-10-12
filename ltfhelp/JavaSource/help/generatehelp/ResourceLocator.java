package help.generatehelp;

import java.io.File;
import java.io.InputStream;
import java.net.URL;

/**Extract resources helper class*/
public class ResourceLocator  {
	
	static  URL findResourceUrl(String resourceName){
		return ResourceLocator.class.getClassLoader().getResource(resourceName);
	}
	
	static File getResourceFile(String resourceName){
		return new File(findResourceUrl(resourceName).getFile());
	}
	
	static InputStream getResourceStream(String resourceName) {
		System.out.println("============== GETTING RESOURCE FOR URL: "+ resourceName +" ===============");
		return  ResourceLocator.class.getClassLoader().getResourceAsStream(resourceName);
	}
	
}
