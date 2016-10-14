package help.generatehelp;

public class Property<T extends IToJson> {
	private T value;
	private String name;
	private boolean skipSerialization = false;
	
	public Property(T value, String propertyName){
		this.value = value;
		this.name = propertyName;
	}
	
	public Property(T value, String propertyName, boolean skipSerialization){
		this.value = value;
		this.name = propertyName;
		this.skipSerialization = skipSerialization;
	}

	public T getValue() {
		return value;
	}

	public void setValue(T value) {
		this.value = value;
	}

	public String getName() {
		return name;
	}
	
	public String toJson(){
		return name + ":"  + (value == null ? "'null'" : value.toJson());
	}

	public boolean isSkipSerialization() {
		return skipSerialization;
	}
	
	
	
}
