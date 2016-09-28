package help.generatehelp.data.patentactivityreg;

import help.generatehelp.LongToJsonWrapper;
import help.generatehelp.Property;
import help.generatehelp.StringToJsonWrapper;
import help.generatehelp.ToJsonBase;

public class PatentActivityReg extends ToJsonBase {
	{
		addProperty(new Property<LongToJsonWrapper>(null, "patentactivityreg_id"));
		addProperty(new Property<LongToJsonWrapper>(null, "restrictquantity1"));
		addProperty(new Property<LongToJsonWrapper>(null, "isretiredfree"));
		
		addProperty(new Property<StringToJsonWrapper>(null, "activity_fullname"));
		addProperty(new Property<StringToJsonWrapper>(null, "activityno"));
		addProperty(new Property<StringToJsonWrapper>(null, "measurequantity1"));
		addProperty(new Property<StringToJsonWrapper>(null, "measurequantity2"));
		addProperty(new Property<StringToJsonWrapper>(null, "tableno"));
		addProperty(new Property<StringToJsonWrapper>(null, "name"));
	}

}
