package help.generatehelp.data.country;

import help.generatehelp.LongToJsonWrapper;
import help.generatehelp.Property;
import help.generatehelp.StringToJsonWrapper;
import help.generatehelp.ToJsonBase;

public class Country extends ToJsonBase {
	
	{
		
		addProperty(new Property<LongToJsonWrapper>(null, "country_id"));
		addProperty(new Property<StringToJsonWrapper>(null, "cname"));
		addProperty(new Property<StringToJsonWrapper>(null, "code"));
		addProperty(new Property<StringToJsonWrapper>(null, "shortname"));

	}

}
