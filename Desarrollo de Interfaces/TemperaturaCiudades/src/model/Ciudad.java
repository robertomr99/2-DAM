package model;

public class Ciudad {

	private String sNombreCiudad , sCapital, sCod_ine;
	private int iTempMax, iTempMin;

	public Ciudad(String sNombreCiudad, String sCapital, String sCod_ine, int iTempMax, int iTempMin) {
		this.sNombreCiudad = sNombreCiudad;
		this.sCapital = sCapital;
		this.sCod_ine = sCod_ine;
		this.iTempMax = iTempMax;
		this.iTempMin = iTempMin;
	}
	

	public String getsCapital() {
		return sCapital;
	}


	public void setsCapital(String sCapital) {
		this.sCapital = sCapital;
	}


	public String getsNombreCiudad() {
		return sNombreCiudad;
	}


	public void setsNombreCiudad(String sNombreCiudad) {
		this.sNombreCiudad = sNombreCiudad;
	}


	public int getiTempMax() {
		return iTempMax;
	}


	public void setiTempMax(int iTempMax) {
		this.iTempMax = iTempMax;
	}


	public int getiTempMin() {
		return iTempMin;
	}


	public void setiTempMin(int iTempMin) {
		this.iTempMin = iTempMin;
	}


	public String getsCod_ine() {
		return sCod_ine;
	}


	public void setsCod_ine(String sCod_ine) {
		this.sCod_ine = sCod_ine;
	}


	@Override
	public String toString() {
		return "Ciudad [sNombreCiudad=" + sNombreCiudad + ", sCapital=" + sCapital + ", sCod_ine=" + sCod_ine
				+ ", iTempMax=" + iTempMax + ", iTempMin=" + iTempMin + "]";
	}




	
}
