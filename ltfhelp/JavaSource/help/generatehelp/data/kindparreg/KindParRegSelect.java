package help.generatehelp.data.kindparreg;


import help.generatehelp.LongToJsonWrapper;
import help.generatehelp.StringToJsonWrapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import net.is_bg.ltf.db.common.SelectSqlStatement;

public class KindParRegSelect  extends SelectSqlStatement{

	private List<KindParReg> result = new ArrayList<KindParReg>();
	

	@Override
	protected String getSqlString() {
		// TODO Auto-generated method stub
		return " select kinddebtreg_id,  kindparreg_id,  fullname,  parreg_code , parreg_name from kindparreg ";
	}
	
	@Override
	protected void retrieveResult(ResultSet rs) throws SQLException {
		// TODO Auto-generated method stub
		while(rs.next()){
			KindParReg c = new KindParReg();
			c.getPropertyByName("kinddebtreg_id").setValue(new LongToJsonWrapper(rs.getLong("kinddebtreg_id")));
			c.getPropertyByName("kindparreg_id").setValue(new LongToJsonWrapper(rs.getLong("kindparreg_id")));
			
			c.getPropertyByName("fullname").setValue(new StringToJsonWrapper(rs.getString("fullname")));
			c.getPropertyByName("parreg_code").setValue(new StringToJsonWrapper(rs.getString("parreg_code")));
			c.getPropertyByName("parreg_name").setValue(new StringToJsonWrapper(rs.getString("parreg_name")));
			result.add(c);
		}
	}

	public List<KindParReg> getResult() {
		return result;
	}

}
