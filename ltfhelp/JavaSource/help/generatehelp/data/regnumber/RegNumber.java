package help.generatehelp.data.regnumber;

import help.generatehelp.LongToJsonWrapper;
import help.generatehelp.Property;
import help.generatehelp.StringToJsonWrapper;
import help.generatehelp.ToJsonBase;

public class RegNumber extends ToJsonBase {
	

	{
		addProperty(new Property<LongToJsonWrapper>(null, "incno_from"));
		addProperty(new Property<LongToJsonWrapper>(null, "incno_last"));
		addProperty(new Property<LongToJsonWrapper>(null, "incno_to"));
		addProperty(new Property<LongToJsonWrapper>(null, "municipality_id"));
		addProperty(new Property<LongToJsonWrapper>(null, "outno_from"));
		addProperty(new Property<LongToJsonWrapper>(null, "outno_last"));
		addProperty(new Property<LongToJsonWrapper>(null, "outno_to"));
		addProperty(new Property<LongToJsonWrapper>(null, "regnumber_id"));
		addProperty(new Property<>(new RefDocTypes(), "refdoc"));
		addProperty(new Property<StringToJsonWrapper>(null, "series"));

	}

}
