package help.generatehelp.data.certreg;


import help.generatehelp.LongToJsonWrapper;
import help.generatehelp.Property;
import help.generatehelp.StringToJsonWrapper;
import help.generatehelp.ToJsonBase;

public class CertReg extends ToJsonBase {
	
	{
		
		addProperty(new Property<LongToJsonWrapper>(null, "certregid"));
		addProperty(new Property<LongToJsonWrapper>(null, "servgroupid"));
		addProperty(new Property<StringToJsonWrapper>(null, "certcode"));
		addProperty(new Property<StringToJsonWrapper>(null, "name"));
		addProperty(new Property<StringToJsonWrapper>(null, "fullname"));
	}
	
	

}
