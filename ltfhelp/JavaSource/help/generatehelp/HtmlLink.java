package help.generatehelp;

public class HtmlLink {

	String href = "";
	String target = "";
	String style = "";
	String classs = "";
	String text = "linkText";
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return   " <a class\"" + classs + "\" target=\"" + target  +"\" href=\""+ href + "\">" + text + "</a>";
	}
}
