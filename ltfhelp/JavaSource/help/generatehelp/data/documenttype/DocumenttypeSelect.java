package help.generatehelp.data.documenttype;


import help.generatehelp.LongToJsonWrapper;
import help.generatehelp.StringToJsonWrapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import net.is_bg.ltf.db.common.SelectSqlStatement;

public class DocumenttypeSelect extends SelectSqlStatement{

	private List<Documenttype> result = new ArrayList<Documenttype>();
	
	
	

	@Override
	protected String getSqlString() {
		// TODO Auto-generated method stub
		return  " select dt.documenttype_id, dt.doccode, dt.docname, dt.term_give, dt.term_working, "+
				" dt.fullname, dt.termgive_enddate, dt.dt_accountreg_id, dt.kt_accountreg_id, dt.isalwaccepting, dt.kinddoc, "+
				" dt.isinc, dt.interest, dt.overinterest, dt.instnumber from documenttype dt ";
	}
	
	@Override
	protected void retrieveResult(ResultSet rs) throws SQLException {
		// TODO Auto-generated method stub
		while(rs.next()){
			Documenttype c = new Documenttype();
			
			
			c.getPropertyByName("documenttype_id").setValue(new LongToJsonWrapper(rs.getLong("documenttype_id")));
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
			
			result.add(c);
		}
	}

	public List<Documenttype> getResult() {
		return result;
	}
}
