package help.generatehelp.data.accountreg;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import net.is_bg.ltf.db.common.SelectSqlStatement;

public class AccountRegSelect extends SelectSqlStatement {


	private List<AccountReg> result = new ArrayList<AccountReg>();
	

	@Override
	protected String getSqlString() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	protected void retrieveResult(ResultSet rs) throws SQLException {
		// TODO Auto-generated method stub
		while(rs.next()){
			AccountReg c = new AccountReg();
			
			
			result.add(c);
		}
	}

	public List<AccountReg> getResult() {
		return result;
	}
}
