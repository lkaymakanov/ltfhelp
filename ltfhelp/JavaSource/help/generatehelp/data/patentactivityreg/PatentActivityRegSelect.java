package help.generatehelp.data.patentactivityreg;


import help.generatehelp.LongToJsonWrapper;
import help.generatehelp.StringToJsonWrapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import net.is_bg.ltf.db.common.SelectSqlStatement;

public class PatentActivityRegSelect extends SelectSqlStatement {

	private List<PatentActivityReg> result = new ArrayList<PatentActivityReg>();
	

	@Override
	protected String getSqlString() {
		// TODO Auto-generated method stub
		return " select patentactivityreg_id, restrictquantity1, isretiredfree, activity_fullname, activityno, measurequantity1, measurequantity1, measurequantity2, tableno, name    from patentactivityreg ";
	}
	
	@Override
	protected void retrieveResult(ResultSet rs) throws SQLException {
		// TODO Auto-generated method stub
		while(rs.next()){
			PatentActivityReg c = new PatentActivityReg();
			
			c.getPropertyByName("patentactivityreg_id").setValue(new LongToJsonWrapper(rs.getLong("patentactivityreg_id")));
			c.getPropertyByName("restrictquantity1").setValue(new LongToJsonWrapper(rs.getLong("restrictquantity1")));
			c.getPropertyByName("isretiredfree").setValue(new LongToJsonWrapper(rs.getLong("isretiredfree")));
			
			c.getPropertyByName("activity_fullname").setValue(new StringToJsonWrapper(rs.getString("activity_fullname")));
			c.getPropertyByName("activityno").setValue(new StringToJsonWrapper(rs.getString("activityno")));
			c.getPropertyByName("measurequantity1").setValue(new StringToJsonWrapper(rs.getString("measurequantity1")));
			c.getPropertyByName("measurequantity2").setValue(new StringToJsonWrapper(rs.getString("measurequantity2")));
			c.getPropertyByName("tableno").setValue(new StringToJsonWrapper(rs.getString("tableno")));
			c.getPropertyByName("name").setValue(new StringToJsonWrapper(rs.getString("name")));
			
			result.add(c);
		}
	}

	public List<PatentActivityReg> getResult() {
		return result;
	}
}
