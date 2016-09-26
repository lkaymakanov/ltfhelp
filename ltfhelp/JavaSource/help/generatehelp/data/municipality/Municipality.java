package help.generatehelp.data.municipality;

public class Municipality {
	private long municipalityId;
	private String name = "";
	private String fullName = "";
	private String code;
	private String ebkcode;
	private String ekkate;
	private String oldcode;
	
	
	public long getMunicipalityId() {
		return municipalityId;
	}
	public void setMunicipalityId(long municipalityId) {
		this.municipalityId = municipalityId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getEbkcode() {
		return ebkcode;
	}
	public void setEbkcode(String ebkcode) {
		this.ebkcode = ebkcode;
	}
	public String getEkkate() {
		return ekkate;
	}
	public void setEkkate(String ekkate) {
		this.ekkate = ekkate;
	}
	public String getOldcode() {
		return oldcode;
	}
	public void setOldcode(String oldcode) {
		this.oldcode = oldcode;
	}
	
	public String toJson(){
		return "{municipalityId:" + municipalityId + ", fullname:'" + fullName + "' ,name:'" 
	   + name +  "', code:'" + code + "', ebkcode:'" + ebkcode + "', ekatte:'"+ ekkate + "', oldcode:'" + oldcode + "'}"; 
	}
	
	//{municipalityId:1247,fullname:'ЕЛИН ПЕЛИН',name:'ЕЛИН ПЕЛИН',code:'081700',ebkcode:'7308',ekatte:'SFO17',oldcode:'2306'},
}
