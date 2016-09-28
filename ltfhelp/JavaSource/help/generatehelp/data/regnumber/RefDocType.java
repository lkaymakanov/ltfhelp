package help.generatehelp.data.regnumber;


import help.generatehelp.HelpUtils;
import help.generatehelp.LongToJsonWrapper;
import help.generatehelp.Property;
import help.generatehelp.StringToJsonWrapper;
import help.generatehelp.ToJsonBase;

class RefDocType extends ToJsonBase {

	{
		addProperty(new Property<LongToJsonWrapper>(new LongToJsonWrapper(-1l), "documenttype_id"));
		addProperty(new Property<StringToJsonWrapper>(null, "doccode"));
		addProperty(new Property<StringToJsonWrapper>(null, "docname"));
	}
	
			
	RefDocType(String value){
		this();
		String a [] = value.split("@@");
		HelpUtils.setLong(this, "documenttype_id", Long.valueOf(a[0]));
		HelpUtils.setString(this, "doccode", (a[1]).trim());
		HelpUtils.setString(this, "docname", (a[2]).trim());
	}
	
	RefDocType(){
		
	}
	
}
