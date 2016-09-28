package help.generatehelp.data.kindhomeobjreg;


import help.generatehelp.LongToJsonWrapper;
import help.generatehelp.StringToJsonWrapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import net.is_bg.ltf.db.common.SelectSqlStatement;

public class KindHomeObjRegSelect extends SelectSqlStatement {

	private List<KindHomeObjReg> result = new ArrayList<KindHomeObjReg>();
	

	@Override
	protected String getSqlString() {
		// TODO Auto-generated method stub
		return " select kdr.kindhomeobjreg_id, kdr.code, kdr.fullname, kdr.NAME, kdr.objgroup from kindhomeobjreg	 kdr ";
	}
	
	@Override
	protected void retrieveResult(ResultSet rs) throws SQLException {
		// TODO Auto-generated method stub
		while(rs.next()){
			KindHomeObjReg c = new KindHomeObjReg();
			
			c.getPropertyByName("kindhomeobjreg_id").setValue(new LongToJsonWrapper(rs.getLong("kindhomeobjreg_id")));
			c.getPropertyByName("objgroup").setValue(new LongToJsonWrapper(rs.getLong("objgroup")));
			c.getPropertyByName("code").setValue(new StringToJsonWrapper(rs.getString("code")));
			c.getPropertyByName("fullname").setValue(new StringToJsonWrapper(rs.getString("fullname")));
			c.getPropertyByName("name").setValue(new StringToJsonWrapper(rs.getString("name")));
			
			result.add(c);
		}
	}

	public List<KindHomeObjReg> getResult() {
		return result;
	}
}
