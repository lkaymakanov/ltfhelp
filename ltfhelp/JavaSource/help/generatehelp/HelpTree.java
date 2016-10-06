package help.generatehelp;

import java.io.File;
import java.io.Serializable;
import java.util.Hashtable;
import java.util.Map;
import java.util.Properties;

public class HelpTree implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8259532973629209905L;
	private Map<String, HelpTreeNode> linearNodes;
	private HelpTreeNode root = new HelpTreeNode(AppConstants.ROOT_NODE, null);
	
	HelpTree(Properties prop){
		linearNodes = getTreeNodesFromProperties(prop);
	}
	
	
	HelpTree constructTree(){
		//add each element to its parent
		for(String k :linearNodes.keySet()){
			HelpTreeNode node = linearNodes.get(k);
			HelpTreeNode parentNode = linearNodes.get(node.getParentKey());
			
			if(node.getParentKey().equals(AppConstants.ROOT_NODE)) {
				root.addChild(node);   //ad to  the root
			}else{
				if(parentNode!=null) parentNode.addChild(node);
				node.parentNode = parentNode;
			}
		}
		//set levels of the nodes
		setLevelFromRoot(root, 0);
		HelpUtils.log("==================== END CONSTRUCTING HELP DIRECTORY TREE ================");
		return this;
	}
	
	/**Returns relative path from dir to dir based on the root directory*/
	static String routeFromDirToDir(String startDir, String endDir){
		
		return null;
	}
	
	
	static Map<String, HelpTreeNode> getTreeNodesFromProperties(Properties prop){
		Map<String, HelpTreeNode> nodes = new Hashtable<String, HelpTreeNode>();
		String key;
		for(Object k : prop.keySet()){
			key = k.toString();
			HelpTreeNode node = new HelpTreeNode(key,prop.get(key).toString());
			nodes.put(key ,node);
		}
		return nodes;
	}
	
	/***
	 * Sets the level of each node from the root node...
	 * @param node
	 * @param currentLevel
	 */
	private void setLevelFromRoot(HelpTreeNode node, int currentLevel){
		int childrenlevel = currentLevel+1;
		for(HelpTreeNode nd :node.getChildren()){
			setLevelFromRoot(nd, childrenlevel);
		}
		node.levelFromRoot = currentLevel;
	}
	
	/***
	 * Creates all the directories of the help tree!!!
	 * @param node
	 */
	private void createHelpDirectories(HelpTreeNode node){
		if(!node.getKey().equals(AppConstants.ROOT_NODE)){
			String dirpath = node.getKey().replaceAll("\\.", "\\" +  File.separator);
			File cdir =  new File(dirpath);
			if(!cdir.exists()) cdir.mkdir();
		}
		
		for(HelpTreeNode cd : node.getChildren()){  //create children directories
			createHelpDirectories(cd);
		}
	}
	
	/***
	 * Public method that creates all the directories of the help tree!!!
	 * @param node
	 */
	public void createHelpDirectories(){
		createHelpDirectories(root);
	}
	
	private void printNode(HelpTreeNode node){
		for(HelpTreeNode nd :node.getChildren()){
			printNode(nd);
		}
		HelpUtils.log(node.getKey() + "  --->  level = " + node.levelFromRoot);
	}
	
	/**prints the memory directory tree*/
	public void printTree(){
		printNode(root);
	}
	
}
