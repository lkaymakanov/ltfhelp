package help.generatehelp.data.taxperiod;


import help.generatehelp.LongToJsonWrapper;
import help.generatehelp.StringToJsonWrapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import net.is_bg.ltf.db.common.SelectSqlStatement;

public class TaxperiodSelect extends SelectSqlStatement {

	private List<Taxperiod> result = new ArrayList<Taxperiod>();

	@Override
	protected String getSqlString() {
		// TODO Auto-generated method stub
		return " select t.taxperiod_id, to_char(t.begin_date, 'dd.mm.yyyy') begin_date, to_char(t.end_date, 'dd.mm.yyyy') end_date, t.taxperkind from taxperiod t order by begin_date; ";
	}
	
	@Override
	protected void retrieveResult(ResultSet rs) throws SQLException {
		// TODO Auto-generated method stub
		while(rs.next()){
			Taxperiod c = new Taxperiod();
			c.getPropertyByName("taxperiod_id").setValue(new LongToJsonWrapper(rs.getLong("taxperiod_id")));
			c.getPropertyByName("begin_date").setValue(new StringToJsonWrapper(rs.getString("begin_date")));
			c.getPropertyByName("end_date").setValue(new StringToJsonWrapper(rs.getString("end_date")));
			c.getPropertyByName("taxperkind").setValue(new StringToJsonWrapper(rs.getString("taxperkind")));
			result.add(c);
		}
	}

	public List<Taxperiod> getResult() {
		return result;
	}
}
