package model;

public class Dept {

	private Integer iDeptno;
	private String sDname, sLoc;

	public Dept(Integer iDeptno, String sDname, String sLoc) {
		this.iDeptno = iDeptno;
		this.sDname = sDname;
		this.sLoc = sLoc;
	}
	
	public Dept() {

	}

	public Integer getiDeptno() {
		return iDeptno;
	}

	public void setiDeptno(Integer iDeptno) {
		this.iDeptno = iDeptno;
	}

	public String getsDname() {
		return sDname;
	}

	public void setsDname(String sDname) {
		this.sDname = sDname;
	}

	public String getsLoc() {
		return sLoc;
	}

	public void setsLoc(String sLoc) {
		this.sLoc = sLoc;
	}

	@Override
	public String toString() {
		return "Dept [iDeptno=" + iDeptno + ", sDname=" + sDname + ", sLoc=" + sLoc + "]";
	}

}
