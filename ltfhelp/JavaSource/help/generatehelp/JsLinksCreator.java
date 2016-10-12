
package help.generatehelp;

import java.util.List;

/***
 * Creates links to javascript files from html files!!!
 * @author lubo
 *
 */
public class JsLinksCreator {

	private List<String> pathsTojs;


	public JsLinksCreator(List<String> pathsTojs) {
		// TODO Auto-generated constructor stub
		this.pathsTojs = pathsTojs;
	}
	
	
	public String createJsLinks(){
		String s = "";
		for(String js:pathsTojs){
			s+="<script src=\"" + js+ "\"></script>\n";
		}
		return s;
	}
}
