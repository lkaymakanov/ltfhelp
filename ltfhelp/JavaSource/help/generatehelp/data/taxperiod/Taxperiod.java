package help.generatehelp.data.taxperiod;

import help.generatehelp.LongToJsonWrapper;
import help.generatehelp.Property;
import help.generatehelp.StringToJsonWrapper;
import help.generatehelp.ToJsonBase;

public class Taxperiod extends ToJsonBase{
	{
		addProperty(new Property<LongToJsonWrapper>(null, "taxperiod_id"));
		addProperty(new Property<StringToJsonWrapper>(null, "begin_date"));
		addProperty(new Property<StringToJsonWrapper>(null, "end_date"));
		addProperty(new Property<StringToJsonWrapper>(null, "taxperkind"));

	}
}
