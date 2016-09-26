package help.generatehelp.data.city;

public class City {

	private long cityId ;
	private long municipalityId;
	private String kindCity="";
	private String name="";
	private String ekkate="";
	private String postCode="";
	private String category="";
	
	public long getCityId() {
		return cityId;
	}
	public void setCityId(long cityId) {
		this.cityId = cityId;
	}
	public long getMunicipalityId() {
		return municipalityId;
	}
	public void setMunicipalityId(long municipalityId) {
		this.municipalityId = municipalityId;
	}
	public String getKindCity() {
		return kindCity;
	}
	public void setKindCity(String kindCity) {
		this.kindCity = kindCity;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEkkate() {
		return ekkate;
	}
	public void setEkkate(String ekkate) {
		this.ekkate = ekkate;
	}
	public String getPostCode() {
		return postCode;
	}
	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	
	//{cityid:57889,municipalityid:1222,kind_city:'2',name:'ПОСЕВ',ekkate:'57889',postcode:'7567',category:'7'},
	
	public String toJson(){
		return "{cityid:" + cityId +", municipalityid:" + municipalityId + ", kind_city:'" + kindCity + 
		"', name:'" + name +  "', ekkate:'" + ekkate + "', postcode:'" + postCode +
	    "', category:'" + category + "'" + "}";
	}
}
