package help.generatehelp.data.sqlfunctions;

import help.generatehelp.HelpUtils;
import help.generatehelp.ListToJsonWrapper;
import help.generatehelp.StringToJsonWrapper;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import net.is_bg.ltf.db.common.SelectSqlStatement;

public class SqlFunctionsSelect extends SelectSqlStatement{

	private List<SqlFunction> result = new ArrayList<SqlFunction>();
	private String user;
	public SqlFunctionsSelect(String user){
		this.user = user;
	}


	@Override
	protected String getSqlString() {
		// TODO Auto-generated method stub
		return    "  select  "+
		          "  n.nspname || '.' || p.proname || '(' || oidvectortypes(proargtypes) || '); ' prototype, \n"+ 
		          "  pg_get_functiondef(p.oid) || ';' definition --,  p.proname  prname, p.* \n"+
				  "  from pg_proc p  "+
				  "  join pg_namespace n on p.pronamespace = n.oid  where  1=1  and n.nspowner =   " +
				  "  (select usesysid  	 " +
				  "  from pg_user 	where 1=1 	and upper(usename) = upper(?)) "+
				  "  and n.nspname   "+
				  "  in(  "+
				  "  select ns.nspname   "+
				  "  from pg_namespace ns 	where 1=1  	and ns.nspowner = (select usesysid    "+	
				  "  from pg_user 	where 1=1 	and upper(usename) = upper(?))   "+
				  "  and n.nspname <> 'pg_catalog' order by nspname   "+
				  "  ) order by prototype  ";

	}
	
	@Override
	protected void retrieveResult(ResultSet rs) throws SQLException {
		// TODO Auto-generated method stub
		while(rs.next()){
			SqlFunction c = new SqlFunction();
			c.getPropertyByName("prototype").setValue(new StringToJsonWrapper(rs.getString("prototype")));
			String defifnition = rs.getString("definition");
			//replaceAll("\\\\/", "/");
			defifnition = defifnition.replaceAll("\\\\/", "/").replace("'", "\\'");
			String [] lines = defifnition.split("\n");
			List<StringToJsonWrapper> deflines = new ArrayList<StringToJsonWrapper>();
			for(String line : lines){
				System.out.println(HelpUtils.rtrim(line));
				deflines.add(new StringToJsonWrapper(line));
			}
			c.getPropertyByName("definition").setValue(new StringToJsonWrapper(defifnition));
			c.getPropertyByName("definitionlines").setValue(new ListToJsonWrapper<StringToJsonWrapper>(deflines));
			result.add(c);
		}
	}

	
	@Override
	protected void setParameters(PreparedStatement prStmt) throws SQLException {
		// TODO Auto-generated method stub
		//super.setParameters(prStmt);
		bindVarData.setString(user);
		bindVarData.setString(user);
		bindVarData.setParameters(prStmt);
	}

	public List<SqlFunction> getResult() {
		return result;
	}
}
