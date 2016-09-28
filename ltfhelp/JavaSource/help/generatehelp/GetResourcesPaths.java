package help.generatehelp;

import java.io.File;
import java.util.Set;
import java.util.TreeSet;

public class GetResourcesPaths {
	
	String resourceFolder;
	GetResourcesPaths(String resourceFolder){
		this.resourceFolder = resourceFolder;
	}
	
	
	private Set<String> getResourcePropertiesP(final boolean prop){
		final String base = ResourceLocator.getResourceFile("").getPath() + "\\";
		System.out.println(ResourceLocator.getResourceFile("").getPath());
		final Set<String> ret = new TreeSet<String>() ;
		HelpUtils.traverseDirs(ResourceLocator.getResourceFile(resourceFolder), new TraverseDirsCallBack() {
			@Override
			public void OnReturnFromRecursion(File node) {
				// TODO Auto-generated method stub
				if(node.isFile()){
					String el =node.getPath().replace(base, "").replace("\\", "/");
					if(prop) el+="="+el;
					System.out.println(el);
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
