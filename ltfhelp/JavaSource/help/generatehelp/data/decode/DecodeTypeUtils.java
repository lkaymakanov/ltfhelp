package help.generatehelp.data.decode;

import help.generatehelp.HelpUtils;

import java.util.List;

public class DecodeTypeUtils {

	/**
	 * Returns the decode codes + array of values for each code as json array of objects!!!
	 * @return
	*/
	public static String getDecodeTypeAsJson(){
		DecodeTypesSelect sel = new DecodeTypesSelect();
		HelpUtils.getSerServiceLocator().getHelpDao().execute(sel);
		List<DecodeType> result =	sel.getResult();
		String res = " var decodetypes = [ ";
		int last = result == null ? 0 : result.size() - 1;
		int i = 0;
		for(DecodeType item : result){
			res += item.toJson() + (i == last ?  "" :  ",\n");
			i++;
		}
		res+="];";
		return res;		
	}
}
