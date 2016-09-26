package help.generatehelp.data.menu;

import java.util.Set;
import java.util.TreeSet;

class Menu {

	long menuId;
	long parentId;
	String href;
	String menuName;
	String nodeNo;
	long parentIdex = -1;
	long currentIndex =-1;
	long rootIndex  = -1;
	
	public long getMenuId() {
		return menuId;
	}
	public void setMenuId(long menuId) {
		this.menuId = menuId;
	}
	public long getParentId() {
		return parentId;
	}
	public void setParentId(long parentId) {
		this.parentId = parentId;
	}
	public String getHref() {
		return href;
	}
	public void setHref(String href) {
		this.href = href;
	}
	public String getMenuName() {
		return menuName;
	}
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	public String getNodeNo() {
		return nodeNo;
	}
	public void setNodeNo(String nodeNo) {
		this.nodeNo = nodeNo;
	}
	public long getParentIdex() {
		return parentIdex;
	}
	public void setParentIdex(long parentIdex) {
		this.parentIdex = parentIdex;
	}
	public long getCurrentIndex() {
		return currentIndex;
	}
	public void setCurrentIndex(long currentIndex) {
		this.currentIndex = currentIndex;
	}
	
	public long getRootIndex() {
		return rootIndex;
	}
	public void setRootIndex(long rootIndex) {
		this.rootIndex = rootIndex;
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
	
	String toJSON(){
		return "{menuid:" + menuId 
				+ ", index: " + currentIndex 
				+ ", parentid:" + parentId  
				+ ", parentind:" + parentIdex 
				+ ", rootind:" + rootIndex
				+ ", menuname:'" + menuName 
				+ "', nodeno:'" + nodeNo 
				+ "', href:'" + href 
				+ "', children:" + childrentoJSON() + " }";
	}

	
}
