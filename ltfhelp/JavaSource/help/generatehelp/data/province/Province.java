package help.generatehelp.data.province;

import help.generatehelp.LongToJsonWrapper;
import help.generatehelp.Property;
import help.generatehelp.StringToJsonWrapper;
import help.generatehelp.ToJsonBase;

public class Province extends ToJsonBase {
	{
		addProperty(new Property<LongToJsonWrapper>(null, "province_id"));
		addProperty(new Property<StringToJsonWrapper>(null, "ekkate"));
		addProperty(new Property<StringToJsonWrapper>(null, "name"));
		addProperty(new Property<StringToJsonWrapper>(null, "code"));
	}
	
}
