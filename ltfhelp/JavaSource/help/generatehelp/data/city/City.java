package help.generatehelp.data.city;

import help.generatehelp.LongToJsonWrapper;
import help.generatehelp.Property;
import help.generatehelp.StringToJsonWrapper;
import help.generatehelp.ToJsonBase;

public class City extends ToJsonBase {
	{
		addProperty(new Property<LongToJsonWrapper>(null, "city_id"));
		addProperty(new Property<LongToJsonWrapper>(null, "munid"));
		addProperty(new Property<LongToJsonWrapper>(null, "province_id"));
		
		addProperty(new Property<StringToJsonWrapper>(null, "kind_city"));
		addProperty(new Property<StringToJsonWrapper>(null, "cname"));
		addProperty(new Property<StringToJsonWrapper>(null, "ekatte"));
		addProperty(new Property<StringToJsonWrapper>(null, "postcode"));
		addProperty(new Property<StringToJsonWrapper>(null, "category"));
		addProperty(new Property<StringToJsonWrapper>(null, "mname"));
		addProperty(new Property<StringToJsonWrapper>(null, "pname"));
	}

}
