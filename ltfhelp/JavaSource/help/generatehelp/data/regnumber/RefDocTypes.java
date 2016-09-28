package help.generatehelp.data.regnumber;

import java.util.ArrayList;
import java.util.List;

import help.generatehelp.HelpUtils;
import help.generatehelp.ToJsonBase;

class RefDocTypes extends ToJsonBase {

	List<RefDocType> refDocs = new ArrayList<RefDocType>();
	
	@Override
	public String toJson() {
		// TODO Auto-generated method stub
		return HelpUtils.toJson(refDocs);
	}
}
