package help.generatehelp.data.municipality;

import help.generatehelp.LongToJsonWrapper;
import help.generatehelp.Property;
import help.generatehelp.StringToJsonWrapper;
import help.generatehelp.ToJsonBase;

public class Municipality extends ToJsonBase{
	
	{
		addProperty(new Property<LongToJsonWrapper>(null, "municipality_id"));
		addProperty(new Property<LongToJsonWrapper>(null, "province_id"));
		addProperty(new Property<StringToJsonWrapper>(null, "fullname"));
		addProperty(new Property<StringToJsonWrapper>(null, "name"));
		addProperty(new Property<StringToJsonWrapper>(null, "code"));
		addProperty(new Property<StringToJsonWrapper>(null, "old_code"));
		addProperty(new Property<StringToJsonWrapper>(null, "ebk_code"));
		addProperty(new Property<StringToJsonWrapper>(null, "ekatte"));
		addProperty(new Property<StringToJsonWrapper>(null, "pname"));
	}
	
}
