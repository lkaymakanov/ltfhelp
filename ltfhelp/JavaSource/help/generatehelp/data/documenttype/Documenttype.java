package help.generatehelp.data.documenttype;

import help.generatehelp.LongToJsonWrapper;
import help.generatehelp.Property;
import help.generatehelp.StringToJsonWrapper;
import help.generatehelp.ToJsonBase;

class Documenttype extends ToJsonBase{
	

/*	c.getPropertyByName("documenttype_id").setValue(new LongToJsonWrapper(rs.getLong("documenttype_id")));
	c.getPropertyByName("dt_accountreg_id").setValue(new LongToJsonWrapper(rs.getLong("dt_accountreg_id")));
	c.getPropertyByName("kt_accountreg_id").setValue(new LongToJsonWrapper(rs.getLong("kt_accountreg_id")));
	
	c.getPropertyByName("isalwaccepting").setValue(new LongToJsonWrapper(rs.getLong("isalwaccepting")));
	c.getPropertyByName("kinddoc").setValue(new LongToJsonWrapper(rs.getLong("kinddoc")));
	c.getPropertyByName("isinc").setValue(new LongToJsonWrapper(rs.getLong("isinc")));
	c.getPropertyByName("interest").setValue(new LongToJsonWrapper(rs.getLong("interest")));
	c.getPropertyByName("overinterest").setValue(new LongToJsonWrapper(rs.getLong("overinterest")));
	c.getPropertyByName("instnumber").setValue(new LongToJsonWrapper(rs.getLong("instnumber")));
	
	c.getPropertyByName("doccode").setValue(new StringToJsonWrapper(rs.getString("doccode")));
	c.getPropertyByName("docname").setValue(new StringToJsonWrapper(rs.getString("docname")));
	c.getPropertyByName("term_give").setValue(new StringToJsonWrapper(rs.getString("term_give")));
	c.getPropertyByName("term_working").setValue(new StringToJsonWrapper(rs.getString("term_working")));
	c.getPropertyByName("fullname").setValue(new StringToJsonWrapper(rs.getString("fullname")));
	c.getPropertyByName("termgive_enddate").setValue(new StringToJsonWrapper(rs.getString("termgive_enddate")));
*/
	{
		addProperty(new Property<LongToJsonWrapper>(null, "documenttype_id"));
		addProperty(new Property<LongToJsonWrapper>(null, "dt_accountreg_id"));
		addProperty(new Property<LongToJsonWrapper>(null, "kt_accountreg_id"));
		addProperty(new Property<LongToJsonWrapper>(null, "isalwaccepting"));
		addProperty(new Property<LongToJsonWrapper>(null, "kinddoc"));
		addProperty(new Property<LongToJsonWrapper>(null, "interest"));
		addProperty(new Property<LongToJsonWrapper>(null, "overinterest"));
		addProperty(new Property<LongToJsonWrapper>(null, "isinc"));
		addProperty(new Property<LongToJsonWrapper>(null, "interest"));
		addProperty(new Property<LongToJsonWrapper>(null, "instnumber"));
		
		addProperty(new Property<StringToJsonWrapper>(null, "doccode"));
		addProperty(new Property<StringToJsonWrapper>(null, "docname"));
		addProperty(new Property<StringToJsonWrapper>(null, "term_give"));
		addProperty(new Property<StringToJsonWrapper>(null, "term_working"));
		addProperty(new Property<StringToJsonWrapper>(null, "fullname"));
		addProperty(new Property<StringToJsonWrapper>(null, "termgive_enddate"));
	}

	
	
}
