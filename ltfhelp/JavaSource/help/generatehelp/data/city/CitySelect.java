package help.generatehelp.data.city;

import help.generatehelp.LongToJsonWrapper;
import help.generatehelp.StringToJsonWrapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import net.is_bg.ltf.db.common.SelectSqlStatement;

public class CitySelect extends SelectSqlStatement{
	
	private List<City> result = new ArrayList<City>();
	

	@Override
	protected String getSqlString() {
		// TODO Auto-generated method stub
		return " select cc.city_id city_id, cc.municipality_id munid, cc.kind_city kind_city, cc.name cname, "
				+ " cc.ekatte ekatte , cc.postcode postcode, cc.category category,  m.NAME mname, p.province_id, p.NAME pname from city cc  "+
               " left join municipality m on cc.municipality_id = m.municipality_id "+
               " left join province p on m.province_id = p.province_id order by cc.NAME ";
	}
	
	@Override
	protected void retrieveResult(ResultSet rs) throws SQLException {
		// TODO Auto-generated method stub
		while(rs.next()){
			City c = new City();
			
			c.getPropertyByName("city_id").setValue(new LongToJsonWrapper(rs.getLong("city_id")));
			c.getPropertyByName("munid").setValue(new LongToJsonWrapper(rs.getLong("munid")));
			c.getPropertyByName("province_id").setValue(new LongToJsonWrapper(rs.getLong("province_id")));
			
			c.getPropertyByName("kind_city").setValue(new StringToJsonWrapper(rs.getString("kind_city")));
			c.getPropertyByName("cname").setValue(new StringToJsonWrapper(rs.getString("cname")));
			c.getPropertyByName("ekatte").setValue(new StringToJsonWrapper(rs.getString("ekatte")));
			c.getPropertyByName("postcode").setValue(new StringToJsonWrapper(rs.getString("postcode")));
			c.getPropertyByName("category").setValue(new StringToJsonWrapper(rs.getString("category")));
			c.getPropertyByName("mname").setValue(new StringToJsonWrapper(rs.getString("mname")));
			c.getPropertyByName("pname").setValue(new StringToJsonWrapper(rs.getString("pname")));
			
			result.add(c);
		}
	}

	public List<City> getResult() {
		return result;
	}

}
