package help.generatehelp.data.kindparreg;

import help.generatehelp.LongToJsonWrapper;
import help.generatehelp.Property;
import help.generatehelp.StringToJsonWrapper;
import help.generatehelp.ToJsonBase;

public class KindParReg extends ToJsonBase{

	{
		addProperty(new Property<LongToJsonWrapper>(null, "kinddebtreg_id"));
		addProperty(new Property<LongToJsonWrapper>(null, "kindparreg_id"));
		
		addProperty(new Property<StringToJsonWrapper>(null, "fullname"));
		addProperty(new Property<StringToJsonWrapper>(null, "parreg_code"));
		addProperty(new Property<StringToJsonWrapper>(null, "parreg_name"));
	}


}
