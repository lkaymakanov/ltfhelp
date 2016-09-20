package help.generatehelp;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import net.is_bg.ltf.db.common.SelectSqlStatement;

public class MenuSelect extends SelectSqlStatement{
	
	private Map<Long, Long> menuIdIndex = new HashMap<Long, Long>();
	private List<Menu> result = new  ArrayList<Menu>();
	private Map<Long, Set<Long>>  menuItemChildren = new HashMap<Long, Set<Long>>();
	List<Menu>  mainNodes = new ArrayList<Menu>();

	@Override
	protected String getSqlString() {
		// TODO Auto-generated method stub
		return " select m.menurole_id, lower(m.menuname) menuname, "+
		" m.nodeno,  "+ 
		" m.href,  "+
		" coalesce(m.parent_id, 0) parent_id "+
		" from menu m order by menuname ";
	}
	
	
	@Override
	protected void retrieveResult(ResultSet rs) throws SQLException {
		// TODO Auto-generated method stub
		long index = 0;
		while(rs.next()){
			Menu m = new Menu();
		    m.setMenuId(rs.getLong("menurole_id"));
			m.setParentId(rs.getLong("parent_id"));
			m.setMenuName(rs.getString("menuname"));
			m.setHref(rs.getString("href"));
			m.setNodeNo(rs.getString("nodeno"));
			m.setCurrentIndex(index);
			menuIdIndex.put(m.getMenuId(), index);
			
			if(m.getParentId() == 0) mainNodes.add(m);
			index++;
			result.add(m);
		}
		
		//set the indexes of the parent elements
		for(Menu m :result){
			if(m.getParentId() > 0) 
			m.setParentIdex(menuIdIndex.get(m.getParentId()));
		}
		
		//set the indexes of the siblings for each menu item
		index = 0;
		for(Menu m : result){
			if(m.getParentId() > 0) {
				Set<Long> siblingSet = menuItemChildren.get(m.getParentId());
				if(siblingSet == null){
					siblingSet = new TreeSet<Long>();
					menuItemChildren.put(m.getParentId(), siblingSet);
				}
				siblingSet.add(index);
			}
			index++;
		}
		
		/***
		 *set the children nodes!!! 
		 */
		for(Menu menu : result){
			Set<Long> children = menuItemChildren.get(menu.getMenuId());
			if(children == null) continue;
			menu.children = children;
		}
		
		//find elements roots indexes
		for(Menu menu : result){
			long rootIndex = menu.getCurrentIndex();
			Menu root = menu;
			while(root.getParentIdex() >0){
				root=result.get((int)root.getParentIdex());
			}
			rootIndex = root.getCurrentIndex();
			menu.setRootIndex(rootIndex);
		}
		
	}

	
	public List<Menu> getResult() {
		return result;
	}
}
