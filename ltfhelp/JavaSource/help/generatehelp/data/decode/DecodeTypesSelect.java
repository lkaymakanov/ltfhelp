package help.generatehelp.data.decode;

import help.generatehelp.data.SelectItem;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



import net.is_bg.ltf.db.common.SelectSqlStatement;

class DecodeTypesSelect extends SelectSqlStatement {
	
	private List<DecodeType> result = new ArrayList<DecodeType>();

	@Override
	protected String getSqlString() {
		// TODO Auto-generated method stub
		return " select d.columnname cname, array_agg(d.code || '-' || d.value ) avalue  from decode  d group by d.columnname order by d.columnname ";
	}

	
	@Override
	protected void retrieveResult(ResultSet rs) throws SQLException {
		// TODO Auto-generated method stub
		while(rs.next()){
			DecodeType dt = new DecodeType();
			List<SelectItem> items = new ArrayList<SelectItem>();
			dt.setType(rs.getString("cname"));
			String s [] = 	(String [])rs.getArray("avalue").getArray();
			for(String ss : s){
				items.add(new SelectItem("-1", ss));
			}
			dt.setValues(items);
			result.add(dt);
		}
	}


	public List<DecodeType> getResult() {
		return result;
	}
	
}
