package help.generatehelp;

import java.util.List;

public class ListToJsonWrapper<T extends IToJson> implements IToJson {
	
	List<T> l ;
	
	public  ListToJsonWrapper(List<T> l) {
		// TODO Auto-generated constructor stub
	   this.l = l;
	}
	

	@Override
	public String toJson() {
		// TODO Auto-generated method stub
		return HelpUtils.toJson(l);
	}

}
