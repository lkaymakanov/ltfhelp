package help.generatehelp.data.sqlfunctions;

import help.generatehelp.ListToJsonWrapper;
import help.generatehelp.Property;
import help.generatehelp.StringToJsonWrapper;
import help.generatehelp.ToJsonBase;

public class SqlFunction extends ToJsonBase{
	{
		
		addProperty(new Property<StringToJsonWrapper>(null, "prototype"));
		addProperty(new Property<StringToJsonWrapper>(null, "definition", true));
		addProperty(new Property<ListToJsonWrapper<StringToJsonWrapper>>(null, "definitionlines"));
	}
	
}
