package help.generatehelp;

public class HtmlLink {

	String href = "";
	String target = "";
	String style = "";
	String classs = "";
	String text = "linkText";
	String hrefBase = "";
	
	public HtmlLink(){
		
	}
	
	public HtmlLink(String hrefBase, String href, String target, String style, String classs, String text){
		this.href = href;
		this.target = target;
		this.style = style;
		this.classs = classs;
		this.text = text;
		this.hrefBase = hrefBase;
	}
	
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return   " <a class\"" + classs + "\" target=\"" + target  +"\" href=\""+ hrefBase +  href + "\">" + text + "</a>";
	}
}
