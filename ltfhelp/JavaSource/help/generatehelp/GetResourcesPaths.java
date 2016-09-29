package help.generatehelp;

import java.io.File;
import java.util.Set;
import java.util.TreeSet;

public class GetResourcesPaths {
	
	String resourceFolder;
	GetResourcesPaths(String resourceFolder){
		this.resourceFolder = resourceFolder;
	}
	
	/**
	 * get the relative paths to resources located in the target folder of this project!!!
	 * @param prop
	 * @return
	 */
	private Set<String> getResourcePropertiesP(final boolean prop){
		final String base = ResourceLocator.getResourceFile("").getPath() + "\\";
		HelpUtils.log(ResourceLocator.getResourceFile("").getPath());
		final Set<String> ret = new TreeSet<String>() ;
		HelpUtils.traverseDirs(ResourceLocator.getResourceFile(resourceFolder), new TraverseDirsCallBack() {
			@Override
			public void OnReturnFromRecursion(File node) {
				// TODO Auto-generated method stub
				if(node.isFile()){
					String el =node.getPath().replace(base, "").replace("\\", "/");
					if(prop) el+="="+el;
					HelpUtils.log(el);
					ret.add(el);
				}
			}
			
			@Override
			public void OnForward(File node) {
				// TODO Auto-generated method stub
				
			}
		});
		
		return ret;
	}
	
	
	public Set<String> getResourceProperties(){
		return getResourcePropertiesP(true);
	}
	

	Set<String> getResourcePaths(){
		return getResourcePropertiesP(false);
	}
	
	
}
