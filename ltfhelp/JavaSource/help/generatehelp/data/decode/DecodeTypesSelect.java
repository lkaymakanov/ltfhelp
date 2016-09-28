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
		return " select cname, avalue,  array_agg(table_schema || '.' || table_name || '.' || column_name)   refcolumns  from (\n"+
				" (select d.columnname cname, array_agg(d.code || '-' || d.value ) avalue  from decode  d group by d.columnname order by d.columnname ) as dcode\n"+
				" \n"+
				" left join (\n"+
				"  SELECT\n"+
				" 		     \n"+
				" 		     cols.table_schema,\n"+
				" 		     cols.table_name,\n"+
				" 		     cols.column_name,\n"+
				" 		     (\n"+
				" 		         SELECT\n"+
				" 		             pg_catalog.col_description(c.oid, cols.ordinal_position::int)\n"+
				" 		         FROM\n"+
				" 		             pg_catalog.pg_class c\n"+
				" 		         WHERE\n"+
				" 		             c.oid = (SELECT ('\"' || cols.table_name || '\"')::regclass::oid)\n"+
				" 		             AND c.relname = cols.table_name\n"+
				" 		     ) AS column_comment\n"+
				" 		 FROM\n"+
				" 		     information_schema.columns cols\n"+
				" 		 WHERE\n"+
				" 		     cols.table_catalog    = 'kln'\n"+
				" 		     AND cols.table_schema = 'public'\n"+
				" ) as foo on  foo.column_name = lower(dcode.cname))\n"+
				" \n"+
				" group by cname, avalue order by cname\n";
	}

	
	@Override
	protected void retrieveResult(ResultSet rs) throws SQLException {
		// TODO Auto-generated method stub
		while(rs.next()){
			DecodeType dt = new DecodeType();
			List<SelectItem> items = new ArrayList<SelectItem>();
			dt.setType(rs.getString("cname"));
			String s [] = 	(String [])rs.getArray("avalue").getArray();
			String refcols [] = (String [])rs.getArray("refcolumns").getArray();
			for(String ss : s){
				items.add(new SelectItem("-1", ss));
			}
			dt.setValues(items);
			for(String ss:refcols){
				dt.addrefTableColumn(ss);
			}
			result.add(dt);
		}
	}


	public List<DecodeType> getResult() {
		return result;
	}
	
}
