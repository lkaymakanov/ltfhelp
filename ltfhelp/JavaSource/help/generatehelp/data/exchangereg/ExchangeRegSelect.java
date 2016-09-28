package help.generatehelp.data.exchangereg;


import help.generatehelp.LongToJsonWrapper;
import help.generatehelp.StringToJsonWrapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import net.is_bg.ltf.db.common.SelectSqlStatement;

public class ExchangeRegSelect  extends SelectSqlStatement{

	private List<ExchangeReg> result = new ArrayList<ExchangeReg>();
	

	@Override
	protected String getSqlString() {
		// TODO Auto-generated method stub
		return " select ereg.exchange_id, ereg.kind,  ereg.code, ereg.fullname, ereg.NAME, ereg.emission from exchange_reg ereg ";
	}
	
	@Override
	protected void retrieveResult(ResultSet rs) throws SQLException {
		// TODO Auto-generated method stub
		while(rs.next()){
			ExchangeReg c = new ExchangeReg();
			
			c.getPropertyByName("exchange_id").setValue(new LongToJsonWrapper(rs.getLong("exchange_id")));
			c.getPropertyByName("kind").setValue(new LongToJsonWrapper(rs.getLong("kind")));
			c.getPropertyByName("code").setValue(new StringToJsonWrapper(rs.getString("code")));
			c.getPropertyByName("fullname").setValue(new StringToJsonWrapper(rs.getString("fullname")));
			c.getPropertyByName("name").setValue(new StringToJsonWrapper(rs.getString("name")));
			c.getPropertyByName("emission").setValue(new StringToJsonWrapper(rs.getString("emission")));
			
			result.add(c);
		}
	}

	public List<ExchangeReg> getResult() {
		return result;
	}
}
