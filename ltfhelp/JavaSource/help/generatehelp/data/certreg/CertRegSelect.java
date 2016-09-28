package help.generatehelp.data.certreg;


import help.generatehelp.LongToJsonWrapper;
import help.generatehelp.StringToJsonWrapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import net.is_bg.ltf.db.common.SelectSqlStatement;

public class CertRegSelect  extends SelectSqlStatement{
	private List<CertReg> result = new ArrayList<CertReg>();

	@Override
	protected String getSqlString() {
		// TODO Auto-generated method stub
		return " select cer.certreg_id, cer.certcode, cer.name, cer.servgroup_id, cer.fullname from certreg cer ";
	}
	
	@SuppressWarnings({ "unchecked"})
	@Override
	protected void retrieveResult(ResultSet rs) throws SQLException {
		// TODO Auto-generated method stub
		while(rs.next()){
			CertReg c = new CertReg();
			c.getPropertyByName("certregid").setValue(new LongToJsonWrapper(rs.getLong("certreg_id")));
			c.getPropertyByName("servgroupid").setValue(new LongToJsonWrapper(rs.getLong("servgroup_id")));
			c.getPropertyByName("certcode").setValue(new StringToJsonWrapper(rs.getString("certcode")));
			c.getPropertyByName("name").setValue(new StringToJsonWrapper(rs.getString("name")));
			c.getPropertyByName("fullname").setValue(new StringToJsonWrapper(rs.getString("fullname")));
			result.add(c);
		}
	}

	public List<CertReg> getResult() {
		return result;
	}
}
