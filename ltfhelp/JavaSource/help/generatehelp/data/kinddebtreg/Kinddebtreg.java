package help.generatehelp.data.kinddebtreg;

import help.generatehelp.IToJson;

public class Kinddebtreg  implements IToJson{

	//{kinddebtregid:1,code:1400,fullname:"Окончателен годишен (патентен) данък",name:"пат. данък",acc:"441400"},
	private long kinddebtreg;
	private String code;
	private String fullname;
	private String name;
	private String acc;
	
	
	public long getKinddebtreg() {
		return kinddebtreg;
	}
	public void setKinddebtreg(long kinddebtreg) {
		this.kinddebtreg = kinddebtreg;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAcc() {
		return acc;
	}
	public void setAcc(String acc) {
		this.acc = acc;
	}
	
	public String toJson(){
		return "{kinddebtregid:" + kinddebtreg + ", code:" +code +", fullname:'" +fullname + "', name:'" + name + "', acc:'" + acc +  "'}";
	}
}
