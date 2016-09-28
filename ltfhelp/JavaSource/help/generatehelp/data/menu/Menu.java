package help.generatehelp.data.menu;

import help.generatehelp.LongToJsonWrapper;
import help.generatehelp.Property;
import help.generatehelp.StringToJsonWrapper;
import help.generatehelp.ToJsonBase;

import java.util.Set;
import java.util.TreeSet;

class Menu extends ToJsonBase{
	{
		addProperty(new Property<LongToJsonWrapper>(new LongToJsonWrapper(0) , "menurole_id"));
		addProperty(new Property<LongToJsonWrapper>(new LongToJsonWrapper(0), "parent_id"));
		addProperty(new Property<LongToJsonWrapper>(new LongToJsonWrapper(-1l), "index"));
		addProperty(new Property<LongToJsonWrapper>(new LongToJsonWrapper(-1l), "parentIndex"));
		addProperty(new Property<LongToJsonWrapper>(new LongToJsonWrapper(-1l), "rootIndex"));
		
		addProperty(new Property<StringToJsonWrapper>(new  StringToJsonWrapper(""), "menuname"));
		addProperty(new Property<StringToJsonWrapper>(new  StringToJsonWrapper(""), "href"));
		addProperty(new Property<StringToJsonWrapper>(new  StringToJsonWrapper(""), "nodeno"));
	}
	
	private long getLong(String name){
		return (Long) ((LongToJsonWrapper)getPropertyByName(name).getValue()).getValue();
	}
	
	private String getString(String name){
		return (String) ((StringToJsonWrapper)getPropertyByName(name).getValue()).getValue();
	}
	
	private void setLong(String name, long value){
		  getPropertyByName(name).setValue(new LongToJsonWrapper(value));
	}
	
	private void setString(String name, String value){
		getPropertyByName(name).setValue(new StringToJsonWrapper(value));
	}
	
	public long getMenuId() {
		return getLong("menurole_id");
	}
	public void setMenuId(long menuId) {
		setLong("menurole_id", menuId);
	}
	public long getParentId() {
		return getLong("parent_id");
	}
	public void setParentId(long parentId) {
		setLong("parent_id", parentId);
	}
	public String getHref() {
		return getString("href");
	}
	public void setHref(String href) {
		setString("href", href);
	}
	public String getMenuName() {
		return getString("menuname");
	}
	public void setMenuName(String menuName) {
		setString("menuname", menuName);
	}
	public String getNodeNo() {
		return getString("nodeno");
	}
	public void setNodeNo(String nodeNo) {
		setString("nodeno", nodeNo);
	}
	public long getParentIdex() {
		return getLong("parentIndex");
	}
	public void setParentIdex(long parentIdex) {
		setLong("parentIndex", parentIdex);
	}
	public long getCurrentIndex() {
		return getLong("index");
	}
	public void setCurrentIndex(long currentIndex) {
		setLong("index", currentIndex);
	}
	
	public long getRootIndex() {
		return getLong("rootIndex");
	}
	public void setRootIndex(long rootIndex) {
		setLong("rootIndex", rootIndex);
	}

	Set<Long> children = new TreeSet<Long>();
	
	private String childrentoJSON(){
		String s ="[";
		for(Long k :children){
			s+=( "," + k);
		}
		s=s.replaceFirst(",", "");
		s+="]";
		return s;
	}
	
	public String toJson(){
		return "{menuid:" + getMenuId()
				+ ", index: " + getCurrentIndex()
				+ ", parentid:" + getParentId()
				+ ", parentind:" + getParentIdex()
				+ ", rootind:" + getRootIndex()
				+ ", menuname:'" + getMenuName() 
				+ "', nodeno:'" + getNodeNo() 
				+ "', href:'" + getHref()
				+ "', children:" + childrentoJSON() + " }";
	}

	
}
