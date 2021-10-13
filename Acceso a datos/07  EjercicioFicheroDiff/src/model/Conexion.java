package model;

public class Conexion {

	
	String sHost, sPort, sDbName, sUserName, sUserPass;
	
	

	public Conexion(String sHost, String sPort, String sDbName, String sUserName, String sUserPass) {
		this.sHost = sHost;
		this.sPort = sPort;
		this.sDbName = sDbName;
		this.sUserName = sUserName;
		this.sUserPass = sUserPass;
	}
	
	public Conexion() {
	}

	public String getsHost() {
		return sHost;
	}

	public void setsHost(String sHost) {
		this.sHost = sHost;
	}

	public String getsPort() {
		return sPort;
	}

	public void setsPort(String sPort) {
		this.sPort = sPort;
	}

	public String getsDbName() {
		return sDbName;
	}

	public void setsDbName(String sDbName) {
		if(sDbName == null) {
			this.sDbName = "ORCL";
		}
		this.sDbName = sDbName;
	}

	public String getsUserName() {
		return sUserName;
	}

	public void setsUserName(String sUserName) {
		this.sUserName = sUserName;
	}

	public String getsUserPass() {
		return sUserPass;
	}

	public void setsUserPass(String sUserPass) {
		this.sUserPass = sUserPass;
	}

	@Override
	public String toString() {
		return "Conexion [sHost=" + sHost + ", sPort=" + sPort + ", sDbName=" + sDbName + ", sUserName=" + sUserName
				+ ", sUserPass=" + sUserPass + "]";
	}
	
	
	
	
}
