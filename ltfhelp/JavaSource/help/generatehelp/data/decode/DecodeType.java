package help.generatehelp.data.decode;

import help.generatehelp.data.SelectItem;

import java.util.List;


class DecodeType {

	private String type;
	private List<SelectItem> values;
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public List<SelectItem> getValues() {
		return values;
	}
	public void setValues(List<SelectItem> values) {
		this.values = values;
	}
	
	public String toJson(){
		return "{ type:'" + type + "', " + "options:[" + getOptions()+ "] } "; 
	}
	
	private String getOptions(){
		int last = values == null ? 0 : values.size() - 1;
		int i = 0;
		String res = "";
		for(SelectItem item : values){
			res += "'"+ item.getLabel() +"'" + (i == last ?  "" :  ",");
			i++;
		}
		
		return res;
	}
}
