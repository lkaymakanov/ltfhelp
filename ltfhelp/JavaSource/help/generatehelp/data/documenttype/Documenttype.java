package help.generatehelp.data.documenttype;

class Documenttype {

	private long documenttypeid;
	private String doccode;
	private String docname;
	private String termgive;
	private String termworking;
	private String fullname;
	private String termgive_enddate;
	private long dt_accountreg_id;
	private long kt_accountreg_id;
	private long isalwaccepting;
	private long kinddoc;
	private long isincl;
	private long interest;
	private long overinterest;
	private int instnumber;
	
	
	public long getDocumenttypeid() {
		return documenttypeid;
	}
	public void setDocumenttypeid(long documenttypeid) {
		this.documenttypeid = documenttypeid;
	}
	public String getDoccode() {
		return doccode;
	}
	public void setDoccode(String doccode) {
		this.doccode = doccode;
	}
	public String getDocname() {
		return docname;
	}
	public void setDocname(String docname) {
		this.docname = docname;
	}
	public String getTermgive() {
		return termgive;
	}
	public void setTermgive(String termgive) {
		this.termgive = termgive;
	}
	public String getTermworking() {
		return termworking;
	}
	public void setTermworking(String termworking) {
		this.termworking = termworking;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getTermgive_enddate() {
		return termgive_enddate;
	}
	public void setTermgive_enddate(String termgive_enddate) {
		this.termgive_enddate = termgive_enddate;
	}
	public long getDt_accountreg_id() {
		return dt_accountreg_id;
	}
	public void setDt_accountreg_id(long dt_accountreg_id) {
		this.dt_accountreg_id = dt_accountreg_id;
	}
	public long getKt_accountreg_id() {
		return kt_accountreg_id;
	}
	public void setKt_accountreg_id(long kt_accountreg_id) {
		this.kt_accountreg_id = kt_accountreg_id;
	}
	public long getIsalwaccepting() {
		return isalwaccepting;
	}
	public void setIsalwaccepting(long isalwaccepting) {
		this.isalwaccepting = isalwaccepting;
	}
	public long getKinddoc() {
		return kinddoc;
	}
	public void setKinddoc(long kinddoc) {
		this.kinddoc = kinddoc;
	}
	public long getIsincl() {
		return isincl;
	}
	public void setIsincl(long isincl) {
		this.isincl = isincl;
	}
	public long getInterest() {
		return interest;
	}
	public void setInterest(long interest) {
		this.interest = interest;
	}
	public long getOverinterest() {
		return overinterest;
	}
	public void setOverinterest(long overinterest) {
		this.overinterest = overinterest;
	}
	public int getInstnumber() {
		return instnumber;
	}
	public void setInstnumber(int instnumber) {
		this.instnumber = instnumber;
	}
	
	public String toJson(){
		return  " {documenttype_id:"  + documenttypeid + ", doccode:'"  + doccode + "', docname:'" +docname + "', term_give:'" + termgive +
				"', term_working:'" + termworking + "',fullname:'" + fullname +  "', termgive_enddate:'" +termgive_enddate+
				"', dt_accountreg_id:"+ dt_accountreg_id+ ", kt_accountreg_id:" + kt_accountreg_id+ ", isalwaccepting:"+ isalwaccepting+
				", kinddoc:" + kinddoc + ", isinc:'" +isincl + ", interest:" + interest + ", overinterest:" +overinterest +", instnumber:"+instnumber+" }";
	}
	
}
