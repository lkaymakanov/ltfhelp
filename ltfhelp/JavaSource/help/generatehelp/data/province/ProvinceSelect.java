package help.generatehelp.data.province;
import help.generatehelp.LongToJsonWrapper;
import help.generatehelp.StringToJsonWrapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import net.is_bg.ltf.db.common.SelectSqlStatement;

public class ProvinceSelect  extends SelectSqlStatement {

	private List<Province> result = new ArrayList<Province>();

	@Override
	protected String getSqlString() {
		// TODO Auto-generated method stub
		return " select p.province_id, p.ekkate, p.NAME, p.code from province p order by p.name ";
	}
	
	@Override
	protected void retrieveResult(ResultSet rs) throws SQLException {
		// TODO Auto-generated method stub
		while(rs.next()){
			Province c = new Province();
	/*		c.setProvinceId(rs.getLong("province_id"));
			c.setEkkate(rs.getString("ekkate"));
			c.setName(rs.getString("name"));
			c.setCode(rs.getString("code"));*/
			
			c.getPropertyByName("province_id").setValue(new LongToJsonWrapper(rs.getLong("province_id")));
			c.getPropertyByName("ekkate").setValue(new StringToJsonWrapper(rs.getString("ekkate")));
			c.getPropertyByName("name").setValue(new StringToJsonWrapper(rs.getString("name")));
			c.getPropertyByName("code").setValue(new StringToJsonWrapper(rs.getString("code")));
			result.add(c);
		}
	}

	public List<Province> getResult() {
		return result;
	}
}
