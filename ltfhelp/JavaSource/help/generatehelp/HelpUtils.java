package help.generatehelp;



import java.io.File;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import net.is_bg.ltf.db.common.BindVariableData;
import net.is_bg.ltf.db.common.BindVariableInfo;
import net.is_bg.ltf.db.common.DBConfig;



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
	
	/***
	 * Converts a list of toJson objects into a json array
	 * @param list
	 * @return
	 */
	public static <T extends IToJson>  String toJson(List<T>  list, String prefix, String suffix){
		int i, last;
		i = 0; last= list.size() - 1;
		StringBuilder jsonarry  = new StringBuilder();
		jsonarry.append(prefix + " [\n");
		//pr.println(" var tablecolumns = [ ");
		for(IToJson el: list){
			jsonarry.append(el.toJson() + (i == last ?  "\n" :  ",\n"));
			i++;
		}
		jsonarry.append(" ] " + suffix);
		return jsonarry.toString();
	}
	
	
	/**
	 * Creates a javascript compare function for js object property name!!!
	 * @param property
	 * @param funName
	 * @return
	 */
	public static String createJsObjectSortFunctionByPropertyName(String propertyName, String funName){
		return " function " + (funName == null ? "" : funName) 
				+ "(a, b) {\n"
				+ " if(a." + propertyName +   " <  b."+ propertyName + " ) return -1; \n "
				+ " if(a." + propertyName +   " > b."+ propertyName + " )  return 1; \n "		
				+ " return 0;\n}";
	}
	
	
	/**
	 * Creates a javascript object of compare fuctions function for js object properties!!!
	 * @param property
	 * @param funName
	 * @return
	 */
	public static String createJsObjectSortFunctionByProperties(Set<String> propertyNames, String jsObjName){
		int i, last;
		i = 0; last= propertyNames.size() - 1;
		StringBuilder jsonarry  = new StringBuilder();
		jsonarry.append((jsObjName == null ? "{\n" : "var " + jsObjName  + " = {\n"));
		for(String name: propertyNames){
			jsonarry.append(name + ":" + createJsObjectSortFunctionByPropertyName(name, "")  + (i == last ?  "" :  ", "));
			i++;
		}
		jsonarry.append("}");
		return jsonarry.toString();
	}
	
	
	public static void setLong(ToJsonBase obj, String name, long value){
		 obj.getPropertyByName(name).setValue(new LongToJsonWrapper(value));
	}
	
	public static void setString(ToJsonBase obj, String name, String value){
		obj.getPropertyByName(name).setValue(new StringToJsonWrapper(value));
	}
	
	/***
	 * Returns a new string of the template string replacing template parameters with parameters from bindvardata
	 * @param template
	 * @param parameters
	 * @return
	 */
	public static String setTemplateParameters(Template template, BindVariableData parameters){
		String templateString = template.getTemplate();
		Collection<BindVariableInfo> data =	parameters.getValues().values();
		for(BindVariableInfo i : data){
			templateString = templateString.replace("{"+ i.getPosition() + "P}", i.getValue() == null ? "null" : i.getValue().toString());
		}
		return templateString;
	}
	
	
	/***
	 * Converts a list of toJson objects into a json array
	 * @param list
	 * @return
	 */
	public static <T extends IToJson>  String toJson(List<T>  list){
		return toJson(list, "", "");
	}
	
	public static void log(Object o){
		DBConfig.getDbLogFactory().getLog(HelpUtils.class).debug(o);
	}
}
