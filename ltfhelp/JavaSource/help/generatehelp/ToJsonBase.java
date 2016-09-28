package help.generatehelp;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ToJsonBase implements IToJson {
	private List<Property> properties = new ArrayList<Property>();
	private Map<String, Property> propMap = new Hashtable<String, Property>();
	
	
	
	public void addProperty(Property p){
		properties.add(p);
		propMap.put(p.getName(), p);
	}
	
	public Property getPropertyByName(String pName){
		return propMap.get(pName);
	}
	

	@Override
	public String toJson() {
		// TODO Auto-generated method stub
		int i, last;
		i = 0; last= properties.size() - 1;
		StringBuilder jsonarry  = new StringBuilder();
		jsonarry.append("{");
		for(Property el: properties){
			jsonarry.append(el.toJson() + (i == last ?  "" :  ", "));
			i++;
		}
		jsonarry.append("}");
		return jsonarry.toString();
	}
	
	public Set<String> getPropertyNames(){
		return propMap.keySet();
	}
}