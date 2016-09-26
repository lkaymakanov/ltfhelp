package help.generatehelp.data.databasetable;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

class DataBaseTable implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7792757292492019579L;
	private String tableSchema;
	private String tableName;
	private String tableKey;
	private List<DataBaseTableTableColumn> columns = new ArrayList<DataBaseTableTableColumn>();
	
	
	public String getTableName() {
		return tableName;
	}
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	public String getTableKey() {
		return tableKey;
	}
	public void setTableKey(String tableKey) {
		this.tableKey = tableKey;
	}
	public List<DataBaseTableTableColumn> getColumns() {
		return columns;
	}
	public void setColumns(List<DataBaseTableTableColumn> columns) {
		this.columns = columns;
	}
	public String getTableSchema() {
		return tableSchema;
	}
	public void setTableSchema(String tableSchema) {
		this.tableSchema = tableSchema;
	}
	
	
	
}
