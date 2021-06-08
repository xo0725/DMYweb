package dmy.signup.vo;

public class DmySignUpVO {

	private String dsu_no;
	private String dsu_subject;
	private String dsu_area;
	private String dsu_introduce;
	private String dsu_applyyn;
	private String dsu_deleteyn;
	private String dsu_insertdate;
	private String dsu_updatedate;
	
	
	public DmySignUpVO() {
	}

	
	public DmySignUpVO(String dsu_no, String dsu_subject, String dsu_area, String dsu_introduce, String dsu_applyyn,
			String dsu_deleteyn, String dsu_insertdate, String dsu_updatedate) {
		this.dsu_no = dsu_no;
		this.dsu_subject = dsu_subject;
		this.dsu_area = dsu_area;
		this.dsu_introduce = dsu_introduce;
		this.dsu_applyyn = dsu_applyyn;
		this.dsu_deleteyn = dsu_deleteyn;
		this.dsu_insertdate = dsu_insertdate;
		this.dsu_updatedate = dsu_updatedate;
	}


	public String getDsu_no() {
		return dsu_no;
	}


	public String getDsu_subject() {
		return dsu_subject;
	}


	public String getDsu_area() {
		return dsu_area;
	}


	public String getDsu_introduce() {
		return dsu_introduce;
	}


	public String getDsu_applyyn() {
		return dsu_applyyn;
	}


	public String getDsu_deleteyn() {
		return dsu_deleteyn;
	}


	public String getDsu_insertdate() {
		return dsu_insertdate;
	}


	public String getDsu_updatedate() {
		return dsu_updatedate;
	}


	public void setDsu_no(String dsu_no) {
		this.dsu_no = dsu_no;
	}


	public void setDsu_subject(String dsu_subject) {
		this.dsu_subject = dsu_subject;
	}


	public void setDsu_area(String dsu_area) {
		this.dsu_area = dsu_area;
	}


	public void setDsu_introduce(String dsu_introduce) {
		this.dsu_introduce = dsu_introduce;
	}


	public void setDsu_applyyn(String dsu_applyyn) {
		this.dsu_applyyn = dsu_applyyn;
	}


	public void setDsu_deleteyn(String dsu_deleteyn) {
		this.dsu_deleteyn = dsu_deleteyn;
	}


	public void setDsu_insertdate(String dsu_insertdate) {
		this.dsu_insertdate = dsu_insertdate;
	}


	public void setDsu_updatedate(String dsu_updatedate) {
		this.dsu_updatedate = dsu_updatedate;
	}
	
}
