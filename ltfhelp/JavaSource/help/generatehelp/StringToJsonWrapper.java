package help.generatehelp;

public class StringToJsonWrapper implements IToJson {

	private String value;
	public StringToJsonWrapper(String s){
		this.value = s;
	}

	@Override
	public String toJson() {
		// TODO Auto-generated method stub
		return (value ==null) ? "'null'": "'"+value+"'";
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
}
