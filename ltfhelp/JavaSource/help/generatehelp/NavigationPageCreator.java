package help.generatehelp;

/**
 * Creates the help navigation page with the menus
 * @author lubo
 *
 */
public class NavigationPageCreator {
	private Template navigationTemplate;
	private String navigationBasePath;
	
	public NavigationPageCreator(String navigationBasePath, Template template){
		this.navigationBasePath  = navigationBasePath;
		this.navigationTemplate = template;
	}
	
}
