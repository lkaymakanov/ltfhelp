package help.generatehelp.data.reasonreg;

import help.generatehelp.LongToJsonWrapper;
import help.generatehelp.Property;
import help.generatehelp.StringToJsonWrapper;
import help.generatehelp.ToJsonBase;

public class ReasonReg extends ToJsonBase {
	{
		addProperty(new Property<LongToJsonWrapper>(null, "documenttype_id"));
		addProperty(new Property<LongToJsonWrapper>(null, "municipality_id"));
		addProperty(new Property<LongToJsonWrapper>(null, "reasonreg_id"));
		addProperty(new Property<StringToJsonWrapper>(null, "reason_code"));
		addProperty(new Property<StringToJsonWrapper>(null, "reason_kind"));
		addProperty(new Property<StringToJsonWrapper>(null, "reason_text"));
	}
}
