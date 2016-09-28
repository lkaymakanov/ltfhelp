package help.generatehelp.data;

import help.generatehelp.IToJson;

public class SelectItem implements IToJson {
    private String label = null;
    private Object value = null;
	 
    public SelectItem(Object value, String label){
    	this.value = value;
    	this.label = label;
    }
	  
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public Object getValue() {
		return value;
	}
	public void setValue(Object value) {
		this.value = value;
	}

	@Override
	public String toJson() {
		// TODO Auto-generated method stub
		return "{value:" +value +", label:'"+label+"'}";
	}

	  
}
