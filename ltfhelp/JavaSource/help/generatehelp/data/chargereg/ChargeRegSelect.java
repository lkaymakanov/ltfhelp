package help.generatehelp.data.chargereg;


import help.generatehelp.LongToJsonWrapper;
import help.generatehelp.StringToJsonWrapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import net.is_bg.ltf.db.common.SelectSqlStatement;

public class ChargeRegSelect extends SelectSqlStatement {

	private List<ChargeReg> result = new ArrayList<ChargeReg>();
	

	@Override
	protected String getSqlString() {
		// TODO Auto-generated method stub
		return " select creg.chargereg_id, creg.documenttype_id, creg.kinddebtreg_id, creg.charge_code, creg.NAME, creg.isactive from chargereg creg " ;
	}
	
	@Override
	protected void retrieveResult(ResultSet rs) throws SQLException {
		// TODO Auto-generated method stub
		while(rs.next()){
			ChargeReg c = new ChargeReg();
			c.getPropertyByName("chargereg_id").setValue(new LongToJsonWrapper(rs.getLong("chargereg_id")));
			c.getPropertyByName("documenttype_id").setValue(new LongToJsonWrapper(rs.getLong("documenttype_id")));
			c.getPropertyByName("kinddebtreg_id").setValue(new LongToJsonWrapper(rs.getLong("kinddebtreg_id")));
			c.getPropertyByName("charge_code").setValue(new StringToJsonWrapper(rs.getString("charge_code")));
			c.getPropertyByName("name").setValue(new StringToJsonWrapper(rs.getString("name")));
			c.getPropertyByName("isactive").setValue(new LongToJsonWrapper(rs.getLong("isactive")));
			result.add(c);
		}
	}

	public List<ChargeReg> getResult() {
		return result;
	}

}
