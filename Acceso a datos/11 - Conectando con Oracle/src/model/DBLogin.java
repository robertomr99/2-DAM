package model;

public class DBLogin {

	private String dbHOST, dbPORT, dbNAME, dbUSER, dbPASS;

	public DBLogin(String dbHOST, String dbPORT, String dbNAME, String dbUSER, String dbPASS) {
		this.dbHOST = dbHOST;
		this.dbPORT = dbPORT;
		this.dbNAME = dbNAME;
		this.dbUSER = dbUSER;
		this.dbPASS = dbPASS;
	}
	

	public DBLogin() {
	}
	
	

	public String getDbHOST() {
		return dbHOST;
	}

	public void setDbHOST(String dbHOST) {
		this.dbHOST = dbHOST;
	}

	public String getDbPORT() {
		return dbPORT;
	}

	public void setDbPORT(String dbPORT) {
		this.dbPORT = dbPORT;
	}

	public String getDbNAME() {
		return dbNAME;
	}

	public void setDbNAME(String dbNAME) {
		this.dbNAME = dbNAME;
	}

	public String getDbUSER() {
		return dbUSER;
	}

	public void setDbUSER(String dbUSER) {
		this.dbUSER = dbUSER;
	}

	public String getDbPASS() {
		return dbPASS;
	}

	public void setDbPASS(String dbPASS) {
		this.dbPASS = dbPASS;
	}


	@Override
	public String toString() {
		return "DBLogin [dbHOST=" + dbHOST + ", dbPORT=" + dbPORT + ", dbNAME=" + dbNAME + ", dbUSER=" + dbUSER
				+ ", dbPASS=" + dbPASS + "]";
	}
	
	


	
	

}
