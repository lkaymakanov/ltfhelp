package help.generatehelp.data.kinddebtreg;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import net.is_bg.ltf.db.common.SelectSqlStatement;

public class KinddebtregSelect extends SelectSqlStatement {


	private List<Kinddebtreg> result = new ArrayList<Kinddebtreg>();
	

	@Override
	protected String getSqlString() {
		// TODO Auto-generated method stub
		return " select kdr.kinddebtreg_id, kdr.code, kdr.fullname, kdr.NAME, kdr.acc, kdr.isactive from kinddebtreg kdr ";
	}
	
	@Override
	protected void retrieveResult(ResultSet rs) throws SQLException {
		// TODO Auto-generated method stub
		while(rs.next()){
			Kinddebtreg c = new Kinddebtreg();
			c.setKinddebtreg(rs.getLong("kinddebtreg_id"));
			c.setCode(rs.getString("code"));
			c.setFullname(rs.getString("fullname"));
			c.setName(rs.getString("NAME"));
			c.setAcc(rs.getString("acc"));
			
			result.add(c);
		}
	}

	public List<Kinddebtreg> getResult() {
		return result;
	}
}
