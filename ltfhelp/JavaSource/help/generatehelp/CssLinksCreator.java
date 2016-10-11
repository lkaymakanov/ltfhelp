package help.generatehelp;

import java.util.List;

/**
 * Creates links to css files!!!
 * @author lubo
 *
 */
public class CssLinksCreator {
	
	private List<String> pathsTocss;
	
	
	public CssLinksCreator(List<String> pathsTocss){
		this.pathsTocss = pathsTocss;
	}

	public String createCssLinks(){
		String s = "";
		for(String css:pathsTocss){
			s+=	"<link rel=\"stylesheet\" type=\"text/css\" href=\""+ css+   "\">\n";
		}
		return s;
	}
	
	
}
