package help.generatehelp;

import java.util.List;

import javax.faces.model.SelectItem;

public class DecodeType {

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
}
