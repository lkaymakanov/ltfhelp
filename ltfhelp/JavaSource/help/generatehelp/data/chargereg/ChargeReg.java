package help.generatehelp.data.chargereg;

import help.generatehelp.LongToJsonWrapper;
import help.generatehelp.Property;
import help.generatehelp.StringToJsonWrapper;
import help.generatehelp.ToJsonBase;

public class ChargeReg extends ToJsonBase
{

	{
		addProperty(new Property<LongToJsonWrapper>(null, "chargereg_id"));
		addProperty(new Property<LongToJsonWrapper>(null, "documenttype_id"));
		addProperty(new Property<LongToJsonWrapper>(null, "kinddebtreg_id"));
		addProperty(new Property<StringToJsonWrapper>(null, "charge_code"));
		addProperty(new Property<StringToJsonWrapper>(null, "name"));
		addProperty(new Property<LongToJsonWrapper>(null, "isactive"));
	}


}
