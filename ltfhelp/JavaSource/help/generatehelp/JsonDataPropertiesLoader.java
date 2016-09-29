package help.generatehelp;

import java.util.ArrayList;
import java.util.List;

/**
 * Loads JSON arrays from property data files!!!
 * @author lubo
 *
 */
public class JsonDataPropertiesLoader {
	private String linksFile;
	private List<PropertiesLoader> jsonData = new ArrayList<PropertiesLoader>();
	
	public JsonDataPropertiesLoader(PropertiesLoader appproperties) {
		// TODO Auto-generated constructor stub
		linksFile =  appproperties.getProperties().get(AppConstants.JSON_DATA_KEY).toString();   //get the path of the property file containig links to data json property files
		
		//load links from link file
		PropertiesLoader linkFile = new PropertiesLoader(linksFile);
		linkFile.load();
		
		//get each link to json data  file
		for(Object o :linkFile.getProperties().values()){
			//load json file
			PropertiesLoader jsonlines =	new PropertiesLoader(o.toString());
			jsonlines.load();
			jsonlines.printProperties();
			jsonData.add(new PropertiesLoader(o.toString()));
		}
	}

	
	
	
}
