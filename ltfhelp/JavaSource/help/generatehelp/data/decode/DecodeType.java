package help.generatehelp.data.decode;

import help.generatehelp.HelpUtils;
import help.generatehelp.Property;
import help.generatehelp.StringToJsonWrapper;
import help.generatehelp.ToJsonBase;
import help.generatehelp.data.SelectItem;

import java.util.ArrayList;
import java.util.List;


class DecodeType extends ToJsonBase {

	{
		addProperty(new Property<StringToJsonWrapper>(new StringToJsonWrapper(""), "type"));
	}
	
	private List<SelectItem> values;
	private List<String>  refTableColumns = new ArrayList<String>();
	
	public String getType() {
		return ((StringToJsonWrapper)getPropertyByName("type").getValue()).getValue();
	}
	public void setType(String type) {
		HelpUtils.setString(this, "type", type);
	}
	public List<SelectItem> getValues() {
		return values;
	}
	public void setValues(List<SelectItem> values) {
		this.values = values;
	}
	
	private String refColumnsToString (){
		String res ="";
		for(String s: refTableColumns){
			res+=s+"</br>";
		}
		return res;
	}
	
	public void addrefTableColumn(String s){
		refTableColumns.add(s);
	}
	
	public String toJson(){
		return "{"+ getPropertyByName("type").toJson() +  ", " + getOptions()+ ", refcol:'"+refColumnsToString()+"' } "; 
	}
	
	private String getOptions(){
		return HelpUtils.toJson(values, "options:", "");
	}
}
