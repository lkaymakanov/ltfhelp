package help.generatehelp;

public class NumberToJsonWrapper<T extends Number> implements IToJson{

	protected T value;
	public NumberToJsonWrapper(T value){
		this.value = value;
	}

	@Override
	public String toJson() {
		// TODO Auto-generated method stub
		return (value ==null) ? "0": String.valueOf(value);
	}

	public T getValue() {
		return value;
	}

}
