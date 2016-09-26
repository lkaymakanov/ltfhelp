package help.generatehelp.data.country;

public class Country {

	private long countryid;
	private String name;
	private String code;
	private String shortname;
	
	
	public long getCountryid() {
		return countryid;
	}
	public void setCountryid(long countryid) {
		this.countryid = countryid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getShortname() {
		return shortname;
	}
	public void setShortname(String shortname) {
		this.shortname = shortname;
	}
	
	public String toJson(){
		return "{countryid:"  + countryid + ", name:'" + name + "', code:'" + code +  "', shortname:'" + shortname + "'}";
	}
	

}
