package help.generatehelp.data.decode;

import help.generatehelp.data.SelectItem;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;





import net.is_bg.ltf.db.common.SelectSqlStatement;

/***
 * Select table columns that match decode type 
 * @author lubo
 *
 */
public class DecodeForColumnSelect extends SelectSqlStatement {
	
	private Map<String, List<SelectItem>>  colnamesItems = new HashMap<String, List<SelectItem>>();

	@Override
	protected String getSqlString() {
		// TODO Auto-generated method stub
		return

		" select foo.table_schema table_schema, foo.table_name table_name, foo.column_name, array_agg(d.code || '-' || d.value ) seloptions,\n"+
		" foo.table_schema || '.'||  foo.table_name || '.'|| foo.column_name  colkey\n"+
		"    from (\n"+
		" SELECT\n"+
		"     \n"+
		"     cols.table_schema,\n"+
		"     cols.table_name,\n"+
		"     cols.column_name,\n"+
		"     (\n"+
		"         SELECT\n"+
		"             pg_catalog.col_description(c.oid, cols.ordinal_position::int)\n"+
		"         FROM\n"+
		"             pg_catalog.pg_class c\n"+
		"         WHERE\n"+
		"             c.oid = (SELECT ('\"' || cols.table_name || '\"')::regclass::oid)\n"+
		"             AND c.relname = cols.table_name\n"+
		"     ) AS column_comment\n"+
		" FROM\n"+
		"     information_schema.columns cols\n"+
		" WHERE\n"+
		"     cols.table_catalog    = 'kln'\n"+
		"     --AND cols.table_name   = 'taxdoc'\n"+
		"     AND cols.table_schema = 'public') as foo\n"+
		"     join decode  d on foo.column_name = lower(d.columnname)\n"+
		"     group by  foo.table_schema, foo.table_name, foo.column_name  order by foo.column_name, foo.table_name, foo.column_name \n";

	}
	
	@Override
	protected void retrieveResult(ResultSet rs) throws SQLException {
		// TODO Auto-generated method stub
		List<SelectItem> colit = new ArrayList<SelectItem>();
		while(rs.next()){
			String s [] = 	(String [])rs.getArray("seloptions").getArray();
			colit = new ArrayList<SelectItem>();
			for(String ss : s){
				colit.add(new SelectItem("-1", ss));
			}
			colnamesItems.put(rs.getString("colkey"), colit);
		}
		
	}
	
	public List<SelectItem> getItems(String colKey){
		return colnamesItems.get(colKey);
	}
  	

}
