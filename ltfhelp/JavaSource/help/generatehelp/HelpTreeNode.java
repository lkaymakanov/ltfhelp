package help.generatehelp;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class HelpTreeNode implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String key;
	private String parentKey;
	HelpTreeNode parentNode;
	int levelFromRoot;
	
	private List<HelpTreeNode>  children = new ArrayList<HelpTreeNode>();
	
	public void addChild(HelpTreeNode child){
		children.add(child);
	}
	
	public HelpTreeNode(String key, String parentKey){
		this.key = key;
		this.parentKey = parentKey;
	}

	public String getKey() {
		return key;
	}

	public HelpTreeNode getParent() {
		return parentNode;
	}

	public List<HelpTreeNode> getChildren() {
		return children;
	}
	
	
	public String getParentKey() {
		return parentKey;
	}

	public int getLevelFromRoot() {
		return levelFromRoot;
	}
	
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return (key!=null) ? key.hashCode() : 0;
	}
}
