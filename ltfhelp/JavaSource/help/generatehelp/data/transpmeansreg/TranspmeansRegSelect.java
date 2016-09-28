package help.generatehelp.data.transpmeansreg;


import help.generatehelp.LongToJsonWrapper;
import help.generatehelp.StringToJsonWrapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import net.is_bg.ltf.db.common.SelectSqlStatement;

public class TranspmeansRegSelect extends SelectSqlStatement {


	private List<TranspmeansReg> result = new ArrayList<TranspmeansReg>();
	

	@Override
	protected String getSqlString() {
		// TODO Auto-generated method stub
		return " select transpmeansreg_id, code, name, type  from transpmeansreg ";
	}
	
	@Override
	protected void retrieveResult(ResultSet rs) throws SQLException {
		// TODO Auto-generated method stub
		while(rs.next()){
			TranspmeansReg c = new TranspmeansReg();
			c.getPropertyByName("transpmeansreg_id").setValue(new LongToJsonWrapper(rs.getLong("transpmeansreg_id")));
			c.getPropertyByName("code").setValue(new StringToJsonWrapper(rs.getString("code")));
			c.getPropertyByName("name").setValue(new StringToJsonWrapper(rs.getString("name")));
			c.getPropertyByName("type").setValue(new StringToJsonWrapper(rs.getString("type")));
			result.add(c);
		}
	}

	public List<TranspmeansReg> getResult() {
		return result;
	}


}
