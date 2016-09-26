package help.generatehelp.data;

public class SelectItem {
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

	  
}
