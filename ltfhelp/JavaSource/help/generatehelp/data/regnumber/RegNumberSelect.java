package help.generatehelp.data.regnumber;


import help.generatehelp.LongToJsonWrapper;
import help.generatehelp.StringToJsonWrapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import net.is_bg.ltf.db.common.SelectSqlStatement;

public class RegNumberSelect extends SelectSqlStatement {
	private List<RegNumber> result = new ArrayList<RegNumber>();
	

	@Override
	protected String getSqlString() {
		// TODO Auto-generated method stub
		return " select   \n"+
				" regnumber_id, incno_from, incno_last, \n"+
				" incno_to, series, \n"+
				" municipality_id, \n"+
				" outno_from, outno_last,outno_to, \n"+
				" array_agg(documenttype_id || '@@' ||doccode|| '@@' || docname) refdoc\n"+
				"  from((select rn.regnumber_id, rn.incno_from, rn.incno_last, rn.incno_to, rn.series, rn.municipality_id, rn.outno_from, rn.outno_last, rn.outno_to, dtr.documettype_id from regnumber rn \n"+
				"   left join doctyperegnum dtr on rn.regnumber_id = dtr.regnumber_id )as foo\n"+
				"   join documenttype dt on dt.documenttype_id = foo.documettype_id) as al\n"+
				" group by regnumber_id, incno_from, incno_last, incno_to, series, municipality_id, outno_from, outno_last,outno_to\n";

	}
	
	
	
	@Override
	protected void retrieveResult(ResultSet rs) throws SQLException {
		// TODO Auto-generated method stub
		while(rs.next()){
			RegNumber c = new RegNumber();
			c.getPropertyByName("incno_from").setValue(new LongToJsonWrapper(rs.getLong("incno_from")));
			c.getPropertyByName("incno_last").setValue(new LongToJsonWrapper(rs.getLong("incno_last")));
			c.getPropertyByName("incno_to").setValue(new LongToJsonWrapper(rs.getLong("incno_to")));
			c.getPropertyByName("municipality_id").setValue(new LongToJsonWrapper(rs.getLong("municipality_id")));
			c.getPropertyByName("outno_from").setValue(new LongToJsonWrapper(rs.getLong("outno_from")));
			c.getPropertyByName("outno_last").setValue(new LongToJsonWrapper(rs.getLong("outno_last")));
			c.getPropertyByName("outno_to").setValue(new LongToJsonWrapper(rs.getLong("outno_to")));
			c.getPropertyByName("regnumber_id").setValue(new LongToJsonWrapper(rs.getLong("regnumber_id")));
			c.getPropertyByName("series").setValue(new StringToJsonWrapper(rs.getString("series")));
			String refdocs [] = (String [])rs.getArray("refdoc").getArray();
			for(String r:refdocs){
				((RefDocTypes)c.getPropertyByName("refdoc").getValue()).refDocs.add(new RefDocType(r));
			}
			result.add(c);
		}
	}

	public List<RegNumber> getResult() {
		return result;
	}
}
