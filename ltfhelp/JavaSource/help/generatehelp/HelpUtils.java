package help.generatehelp;



import java.awt.Dimension;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
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
	
	
	public static String setTemplateParameters(String in , BindVariableData parameters){
		Collection<BindVariableInfo> data =	parameters.getValues().values();
		for(BindVariableInfo i : data){
			in = in.replace("{"+ i.getPosition() + "P}", i.getValue() == null ? "null" : i.getValue().toString());
		}
		return in;
	}
	
	
	
	/**Writes json string to file*/
	public static void writeToFile(String  json, String fname) throws UnsupportedEncodingException, IOException{
		FileOutputStream fos = null;
		try{
			fos = new FileOutputStream(new File(fname));
			fos.write(json.getBytes("UTF-8"));
		}finally{
			if(fos!=null) fos.close();
		}
	}
	
	
	
	public static void writeToFile(InputStream is, String fname) throws UnsupportedEncodingException, IOException{
		FileOutputStream fos = null;
		try{
			fos = new FileOutputStream(new File(fname));
			byte res [] = new byte[2];
			int read = -1;
			read = is.read(res);
			while(read !=-1){
				fos.write(res, 0, read);
				read = is.read(res);
			}
		}finally{
			if(fos!=null) fos.close();
			is.close();
		}
	}
	
	/**
	 * Writes a list of json objects to file!!!
	 * @param list
	 * @param prefix
	 * @param suffix
	 * @param fName
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 */
	public static <T extends IToJson> void writeToFile(List<T>  list, String prefix, String suffix, String fName) throws UnsupportedEncodingException, IOException{
		writeToFile(toJson(list, prefix, suffix), fName);
	}
	
	/***
	 * Replaces the dots in the directory path with file separator
	 * @return
	 */
	public static String replaceDotWithFileSeparator(String in){
		return in.replaceAll("\\.", "\\" +  File.separator);
	}
	
	/***
	 * Replaces the dots in the directory path with file separator
	 * @return
	 */
	public static String replaceDotWithSeparator(String in, String separator){
		return in.replaceAll("\\.", separator);
	}
	
	/***
	 * Converts a list of toJson objects into a json array
	 * @param list
	 * @return
	 */
	public static <T extends IToJson>  String toJson(List<T>  list){
		return toJson(list, "", "");
	}
	
	
	/**
	 * A javasctipt that creates toggle button with image!!!
	 * @param openFolderimage
	 * @param folderImage
	 * @param dimension
	 * @param elemetnId
	 * @return
	 */
	public static String createExpandButtonScript(String openFolderimage, String folderImage, Dimension dimension, String elemetnId){
		String s = " createExpandButton('" + openFolderimage +"',  '" + folderImage +"'," +
	    dimension.height +"," + dimension.width  +" , 'false', 'function(el){showelement(\\'" + elemetnId + "\\', true);}' , 'function(el){showelement(\\'" + elemetnId + "\\', false);}');";
		return "<script>" + s + "</script>";
 	}
	

	/***
	 * Creates ul list with links to pages!!!
	 * @param links
	 * @param ulId
	 * @param ulclass
	 * @return
	 */
	public static String createUl(List<HtmlLink> links, String ulId, String ulclass){
		String ul =  "<ul class=\"" + ulclass + "\"  style=\"display:none;\" id=\""+ulId +"\">\n";
		for(HtmlLink l : links){
			ul+="<li>"+l.toString() +"</li>\n";
		}
		return ul + "</ul> <hr>";
	}
	
	public static void log(Object o){
		DBConfig.getDbLogFactory().getLog(HelpUtils.class).debug(o);
	}
}
