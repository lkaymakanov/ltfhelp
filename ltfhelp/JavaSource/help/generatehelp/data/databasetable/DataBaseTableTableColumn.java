package help.generatehelp.data.databasetable;

import help.generatehelp.data.SelectItem;

import java.util.ArrayList;
import java.util.List;



class DataBaseTableTableColumn  {

	/**
	 * 
	 */
	
	private String tableKey;
	private String colKey;
	
	private String schema;
	private String tableName;
	private String colName;
	
	private String dataType;
	private String isNullable;
	private String charMaxlength;
	
	private String colCommnent;
	
	private List<SelectItem> decodeValues = new ArrayList<SelectItem>();

	public String getTableKey() {
		return tableKey;
	}

	public void setTableKey(String tableKey) {
		this.tableKey = tableKey;
	}

	public String getColKey() {
		return colKey;
	}

	public void setColKey(String colKey) {
		this.colKey = colKey;
	}

	public String getSchema() {
		return schema;
	}

	public void setSchema(String schema) {
		this.schema = schema;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public String getColName() {
		return colName;
	}

	public void setColName(String colName) {
		this.colName = colName;
	}

	public String getDataType() {
		return dataType;
	}

	public void setDataType(String dataType) {
		this.dataType = dataType;
	}

	public String getIsNullable() {
		return isNullable;
	}

	public void setIsNullable(String isNullable) {
		this.isNullable = isNullable;
	}

	public String getCharMaxlength() {
		return charMaxlength;
	}

	public void setCharMaxlength(String charMaxlength) {
		this.charMaxlength = charMaxlength;
	}

	public String getColCommnent() {
		return colCommnent;
	}

	public void setColCommnent(String colCommnent) {
		this.colCommnent = colCommnent;
	}
	
	String toJSON(){
		String opts="";
		int i =0;
		for(SelectItem it : decodeValues){
			opts+=  ((i > 0 ? ",'" : "'") +it.getLabel()+"'");
			i++;
		}
		return "{tablename:'" + tableName +  "',columnname:'" + colName+ "', columntype:'" + dataType + "', nullable:'"+ isNullable +
				"', maxcharlength:'" +( charMaxlength==null?"":charMaxlength  )+ "',comment:'"  + (colCommnent ==null ? "" : colCommnent.replaceAll("\r\n", "@@") )+ "', opts:[" + opts+ "]}";
	}

	public List<SelectItem> getDecodeValues() {
		return decodeValues;
	}

	public void setDecodeValues(List<SelectItem> decodeValues) {
		this.decodeValues = decodeValues;
	}
	
	
	
}
