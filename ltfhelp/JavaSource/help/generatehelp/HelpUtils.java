package help.generatehelp;


import java.io.File;



/***/
public class HelpUtils {
	
	private static ServiceLocator serviceLocator;
	
	public static ServiceLocator getSerServiceLocator(){
		if(serviceLocator == null) serviceLocator = new ServiceLocator();
		return serviceLocator;
	}
	
	/**Traverse directory trees
	 
	 @param node - the current file node
	 @param trcallback  - what is to be done forward & backward
	*/
	public static void traverseDirs(File node, TraverseDirsCallBack trcallback){
		
		if(trcallback != null)trcallback.OnForward(node);
		//System.out.println(node.getAbsoluteFile());
		
		if(node.isDirectory()){
			String[] subNote = node.list();
			for(String filename : subNote){
				traverseDirs(new File(node, filename), trcallback);
				if(trcallback != null) trcallback.OnReturnFromRecursion(node);//act on the directory
			}
		}
		if(trcallback != null) trcallback.OnReturnFromRecursion(node);  //act on the file
	}
}
