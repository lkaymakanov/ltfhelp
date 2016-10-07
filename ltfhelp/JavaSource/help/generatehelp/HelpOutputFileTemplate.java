package help.generatehelp;


/***
 * Saves a template to an output file!!!!
 * @author lubo
 *
 */
public class HelpOutputFileTemplate extends HelpOutputFileBase{
	private Template tp;
	public HelpOutputFileTemplate(String filePath, Template tp) {
		super(filePath, tp.getTemplateFileName());
		this.tp = tp;
	}

	@Override
	public void createFileContent() {
		// TODO Auto-generated method stub
		fileContent = tp.getTemplate();
	}

}
