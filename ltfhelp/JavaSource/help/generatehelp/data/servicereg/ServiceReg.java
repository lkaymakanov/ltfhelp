package help.generatehelp.data.servicereg;

import help.generatehelp.LongToJsonWrapper;
import help.generatehelp.Property;
import help.generatehelp.StringToJsonWrapper;
import help.generatehelp.ToJsonBase;

public class ServiceReg extends ToJsonBase {
	{
		addProperty(new Property<LongToJsonWrapper>(null, "isactive"));
		addProperty(new Property<LongToJsonWrapper>(null, "isservperson"));
		addProperty(new Property<LongToJsonWrapper>(null, "ispay"));
		addProperty(new Property<LongToJsonWrapper>(null, "municipality_id"));
		addProperty(new Property<LongToJsonWrapper>(null, "servgroup_id"));
		addProperty(new Property<LongToJsonWrapper>(null, "servterm"));
		addProperty(new Property<LongToJsonWrapper>(null, "waitpay"));
		
		addProperty(new Property<StringToJsonWrapper>(null, "kindserv"));
		addProperty(new Property<StringToJsonWrapper>(null, "dkindserv"));
		addProperty(new Property<StringToJsonWrapper>(null, "servcode"));
		addProperty(new Property<StringToJsonWrapper>(null, "name"));
		
	}
	
	

}
