package help.generatehelp.data.servicereg;


import help.generatehelp.LongToJsonWrapper;
import help.generatehelp.StringToJsonWrapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import net.is_bg.ltf.db.common.SelectSqlStatement;

public class ServiceRegSelect extends SelectSqlStatement{

	private List<ServiceReg> result = new ArrayList<ServiceReg>();
	
	


	@Override
	protected String getSqlString() {
		// TODO Auto-generated method stub
		return " select sreg.*, d.value dkindserv, sgr.servcode, sgr.name from servgroup  sgr \n"+
				" join servicereg sreg on sgr.servgroup_id = sreg.servgroup_id\n"+
				" join  decode d on d.code = sreg.kindserv   and lower(d.columnname) = 'kind_serv'\n";

	}
	
	@Override
	protected void retrieveResult(ResultSet rs) throws SQLException {
		// TODO Auto-generated method stub
		while(rs.next()){
			ServiceReg c = new ServiceReg();
			c.getPropertyByName("kindserv").setValue(new StringToJsonWrapper(rs.getString("kindserv")));
			c.getPropertyByName("dkindserv").setValue(new StringToJsonWrapper(rs.getString("dkindserv")));
			c.getPropertyByName("servcode").setValue(new StringToJsonWrapper(rs.getString("servcode")));
			c.getPropertyByName("name").setValue(new StringToJsonWrapper(rs.getString("name")));
			
			c.getPropertyByName("isactive").setValue(new LongToJsonWrapper(rs.getLong("isactive")));
			c.getPropertyByName("isservperson").setValue(new LongToJsonWrapper(rs.getLong("isservperson")));
			c.getPropertyByName("ispay").setValue(new LongToJsonWrapper(rs.getLong("ispay")));
			c.getPropertyByName("municipality_id").setValue(new LongToJsonWrapper(rs.getLong("municipality_id")));
			c.getPropertyByName("servgroup_id").setValue(new LongToJsonWrapper(rs.getLong("servgroup_id")));
			c.getPropertyByName("servterm").setValue(new LongToJsonWrapper(rs.getLong("servterm")));
			c.getPropertyByName("waitpay").setValue(new LongToJsonWrapper(rs.getLong("waitpay")));
			
			result.add(c);
		}
	}

	public List<ServiceReg> getResult() {
		return result;
	}
}
