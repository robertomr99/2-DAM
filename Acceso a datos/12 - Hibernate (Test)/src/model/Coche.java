package model;

public class Coche {

	private Integer iId_Coche, iPotencia;
	private String sMarca, sModelo;
	
	public Coche() {
	
	}

	public Coche(String sMarca, String sModelo, Integer iPotencia) {
		this.sMarca = sMarca;
		this.sModelo = sModelo;
		this.iPotencia = iPotencia;
	}

	public Integer getiId_Coche() {
		return iId_Coche;
	}

	public void setiId_Coche(Integer iId_Coche) {
		this.iId_Coche = iId_Coche;
	}

	public Integer getiPotencia() {
		return iPotencia;
	}

	public void setiPotencia(Integer iPotencia) {
		this.iPotencia = iPotencia;
	}

	public String getsMarca() {
		return sMarca;
	}

	public void setsMarca(String sMarca) {
		this.sMarca = sMarca;
	}

	public String getsModelo() {
		return sModelo;
	}

	public void setsModelo(String sModelo) {
		this.sModelo = sModelo;
	}

	@Override
	public String toString() {
		return "Coche [iId_Coche=" + iId_Coche + ", iPotencia=" + iPotencia + ", sMarca=" + sMarca + ", sModelo="
				+ sModelo + "]";
	}
	
}
