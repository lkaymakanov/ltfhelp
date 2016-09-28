package help.generatehelp.data.municipality;


import help.generatehelp.LongToJsonWrapper;
import help.generatehelp.StringToJsonWrapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import net.is_bg.ltf.db.common.SelectSqlStatement;

public class MunicipalitySelect extends SelectSqlStatement {


	private List<Municipality> result = new ArrayList<Municipality>();
	

	@Override
	protected String getSqlString() {
		// TODO Auto-generated method stub
		return   " select m.municipality_id, m.province_id, m.fullname, m.NAME, m.code,m.old_code, m.ebk_code, m.ekatte, p.NAME pname  from municipality m "+
				 " left join province p on  m.province_id = p.province_id "+
				 " order by m.fullname ";
	}
	
	@Override
	protected void retrieveResult(ResultSet rs) throws SQLException {
		// TODO Auto-generated method stub
		while(rs.next()){
			Municipality c = new Municipality();
			c.getPropertyByName("municipality_id").setValue(new LongToJsonWrapper(rs.getLong("municipality_id")));
			c.getPropertyByName("province_id").setValue(new LongToJsonWrapper(rs.getLong("province_id")));
			c.getPropertyByName("fullname").setValue(new StringToJsonWrapper(rs.getString("fullname")));
			c.getPropertyByName("name").setValue(new StringToJsonWrapper(rs.getString("name")));
			c.getPropertyByName("code").setValue(new StringToJsonWrapper(rs.getString("code")));
			c.getPropertyByName("old_code").setValue(new StringToJsonWrapper(rs.getString("old_code")));
			c.getPropertyByName("ebk_code").setValue(new StringToJsonWrapper(rs.getString("ebk_code")));
			c.getPropertyByName("ekatte").setValue(new StringToJsonWrapper(rs.getString("ekatte")));
			c.getPropertyByName("pname").setValue(new StringToJsonWrapper(rs.getString("pname")));
			
			result.add(c);
		}
	}

	public List<Municipality> getResult() {
		return result;
	}
}
