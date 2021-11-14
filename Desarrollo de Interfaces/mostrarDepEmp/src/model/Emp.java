package model;

public class Emp {
	
	private String sEname, sJob, sFechaAlta, sEnameBoss;
	private Integer iSal, iComm;
	
	public Emp(String sEname, String sJob, String sFechaAlta, String sEnameBoss, Integer iSal, Integer iComm) {
		this.sEname = sEname;
		this.sJob = sJob;
		this.sFechaAlta = sFechaAlta;
		this.sEnameBoss = sEnameBoss;
		this.iSal = iSal;
		this.iComm = iComm;
	}
	
	
	public Emp() {
	}

	
	public String getsEname() {
		return sEname;
	}
	public void setsEname(String sEname) {
		this.sEname = sEname;
	}
	public String getsJob() {
		return sJob;
	}
	public void setsJob(String sJob) {
		this.sJob = sJob;
	}
	public String getsFechaAlta() {
		return sFechaAlta;
	}
	public void setsFechaAlta(String sFechaAlta) {
		this.sFechaAlta = sFechaAlta;
	}
	public String getsEnameBoss() {
		return sEnameBoss;
	}
	public void setsEnameBoss(String sEnameBoss) {
		this.sEnameBoss = sEnameBoss;
	}
	public Integer getiSal() {
		return iSal;
	}
	public void setiSal(Integer iSal) {
		this.iSal = iSal;
	}
	public Integer getiComm() {
		return iComm;
	}
	public void setiComm(Integer iComm) {
		this.iComm = iComm;
	}


	@Override
	public String toString() {
		return "Emp [sEname=" + sEname + ", sJob=" + sJob + ", sFechaAlta=" + sFechaAlta + ", sEnameBoss=" + sEnameBoss
				+ ", iSal=" + iSal + ", iComm=" + iComm + "]";
	}
	
	
}
