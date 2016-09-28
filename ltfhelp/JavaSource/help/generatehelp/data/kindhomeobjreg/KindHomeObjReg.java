package help.generatehelp.data.kindhomeobjreg;

import help.generatehelp.LongToJsonWrapper;
import help.generatehelp.Property;
import help.generatehelp.StringToJsonWrapper;
import help.generatehelp.ToJsonBase;

public class KindHomeObjReg extends ToJsonBase{
	{
		addProperty(new Property<LongToJsonWrapper>(null, "kindhomeobjreg_id"));
		addProperty(new Property<LongToJsonWrapper>(null, "objgroup"));
		addProperty(new Property<StringToJsonWrapper>(null, "code"));
		addProperty(new Property<StringToJsonWrapper>(null, "fullname"));
		addProperty(new Property<StringToJsonWrapper>(null, "name"));
	}

}
