package help.generatehelp;

public class Property<T extends IToJson> {
	private T value;
	private String name;
	
	public Property(T value, String propertyName){
		this.value = value;
		this.name = propertyName;
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
	
}
