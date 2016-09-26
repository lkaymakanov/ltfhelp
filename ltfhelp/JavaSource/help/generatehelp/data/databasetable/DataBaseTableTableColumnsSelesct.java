package help.generatehelp.data.databasetable;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import net.is_bg.ltf.db.common.SelectSqlStatement;

class DataBaseTableTableColumnsSelesct extends SelectSqlStatement {

	
	List<DataBaseTableTableColumn> columns = new ArrayList<DataBaseTableTableColumn>();
	
	@Override
	protected String getSqlString() {
		// TODO Auto-generated method stub
		return " select foo.table_schema table_schema, "
				+ " foo.table_name  table_name, "
				+ " foo.column_name column_name,\n"+
		"  foo.data_type  data_type,\n"+
		"  foo.is_nullable is_nullable, foo.character_maximum_length  character_maximum_length,\n"+
		"  foo.is_updatable  is_updatable,\n"+
		"  foo.column_comment column_comment,\n"+
		"  foo.table_schema || '.' || foo.table_name tablekey,\n"+
		"  foo.table_schema || '.' || foo.table_name || '.' || foo.column_name colkey\n"+
		"  from (\n"+
		" SELECT\n"+
		"     \n"+
		"     cols.*,\n"+
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
		"     --join decode  d on foo.column_name = lower(d.columnname)\n"+
		"     order by foo.table_name, foo.column_name\n";

	}
	
	
	@Override
	protected void retrieveResult(ResultSet rs) throws SQLException {
		// TODO Auto-generated method stub
		
		while(rs.next()){
			DataBaseTableTableColumn td = new DataBaseTableTableColumn();
			
			td.setSchema(rs.getString("table_schema"));
			td.setTableName(rs.getString("table_name"));
			td.setColName(rs.getString("column_name"));
			td.setDataType(rs.getString("data_type"));
			td.setIsNullable(rs.getString("is_nullable"));
			td.setColCommnent(rs.getString("column_comment"));
			td.setTableKey(rs.getString("tablekey"));
			td.setColKey(rs.getString("colkey"));
			td.setCharMaxlength(rs.getString("character_maximum_length"));
			columns.add(td);
		}
	}


	public List<DataBaseTableTableColumn> getColumns() {
		return columns;
	}
	
	

	
}
