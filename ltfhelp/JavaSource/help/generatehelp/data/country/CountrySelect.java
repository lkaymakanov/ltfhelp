package help.generatehelp.data.country;


import help.generatehelp.LongToJsonWrapper;
import help.generatehelp.StringToJsonWrapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import net.is_bg.ltf.db.common.SelectSqlStatement;

public class CountrySelect extends SelectSqlStatement {

	private List<Country> result = new ArrayList<Country>();
	

	@Override
	protected String getSqlString() {
		// TODO Auto-generated method stub
		return " select cc.country_id, cc.NAME cname, cc.code, cc.shortname, cc.citizenship from country cc order by cc.name ";
	}
	
	@Override
	protected void retrieveResult(ResultSet rs) throws SQLException {
		// TODO Auto-generated method stub
		while(rs.next()){
			Country c = new Country();
			
			c.getPropertyByName("country_id").setValue(new LongToJsonWrapper(rs.getLong("country_id")));
			c.getPropertyByName("cname").setValue(new StringToJsonWrapper(rs.getString("cname")));
			c.getPropertyByName("code").setValue(new StringToJsonWrapper(rs.getString("code")));
			c.getPropertyByName("shortname").setValue(new StringToJsonWrapper(rs.getString("shortname")));
	
			result.add(c);
		}
	}

	public List<Country> getResult() {
		return result;
	}
}
