package help.generatehelp.data.reasonreg;


import help.generatehelp.LongToJsonWrapper;
import help.generatehelp.StringToJsonWrapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import net.is_bg.ltf.db.common.SelectSqlStatement;

public class ReasonRegSelect extends SelectSqlStatement{

	private List<ReasonReg> result = new ArrayList<ReasonReg>();
	

	@Override
	protected String getSqlString() {
		// TODO Auto-generated method stub
		return " select documenttype_id, municipality_id, reasonreg_id,  reason_code, reason_kind, reason_text   from reasonreg  ";
	}
	
	@Override
	protected void retrieveResult(ResultSet rs) throws SQLException {
		// TODO Auto-generated method stub
		while(rs.next()){
			ReasonReg c = new ReasonReg();
			c.getPropertyByName("documenttype_id").setValue(new LongToJsonWrapper(rs.getLong("documenttype_id")));
			c.getPropertyByName("municipality_id").setValue(new LongToJsonWrapper(rs.getLong("municipality_id")));
			c.getPropertyByName("reasonreg_id").setValue(new LongToJsonWrapper(rs.getLong("reasonreg_id")));
			
			c.getPropertyByName("reason_code").setValue(new StringToJsonWrapper(rs.getString("reason_code")));
			c.getPropertyByName("reason_kind").setValue(new StringToJsonWrapper(rs.getString("reason_kind")));
			c.getPropertyByName("reason_text").setValue(new StringToJsonWrapper(rs.getString("reason_text")));
			
			result.add(c);
		}
	}

	public List<ReasonReg> getResult() {
		return result;
	}
}
