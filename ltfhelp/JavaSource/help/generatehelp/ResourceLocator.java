package help.generatehelp;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;

/**Extract resources helper class*/
public class ResourceLocator  {
	
	/**get properties file*/
	private static Properties properties = new Properties();
	private static String resourcesPath;

	
	static void initResourceLocator(){
		try {
			properties.load(getResourceStream("prop.properties"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		resourcesPath = properties.getProperty("path.to.resources");
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
	
	
	static String getResourcePath(){
		return resourcesPath;
	}
	
	
	static void printResourcePath(){
		System.out.println(resourcesPath);
	}
	
	static void printResources(){
		HelpUtils.traverseDirs(getResourceFile(resourcesPath), new TraverseDirsCallBack() {
			@Override
			public void OnReturnFromRecursion(File node) {
				// TODO Auto-generated method stub
				System.out.println(node.getAbsolutePath());
			}
			
			@Override
			public void OnForward(File node) {
				// TODO Auto-generated method stub
				
			}
		});
	}
	
}
