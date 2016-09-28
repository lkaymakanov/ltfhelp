package help.generatehelp.data.exchangereg;

import help.generatehelp.LongToJsonWrapper;
import help.generatehelp.Property;
import help.generatehelp.StringToJsonWrapper;
import help.generatehelp.ToJsonBase;

public class ExchangeReg extends ToJsonBase{
	
	{
			addProperty(new Property<LongToJsonWrapper>(null, "exchange_id"));
			addProperty(new Property<LongToJsonWrapper>(null, "kind"));
			addProperty(new Property<StringToJsonWrapper>(null, "code"));
			addProperty(new Property<StringToJsonWrapper>(null, "fullname"));
			addProperty(new Property<StringToJsonWrapper>(null, "name"));
			addProperty(new Property<StringToJsonWrapper>(null, "emission"));
	
	}
	
	
}
