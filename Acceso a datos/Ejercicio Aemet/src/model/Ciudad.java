package model;

public class Ciudad {

	private String sNombreCiudad;
	private int iTempMax, iTempMin, iCapital, iCod_ine_m, iCod_ine;
	
	public Ciudad(String sNombreCiudad, int iTempMax, int iTempMin, int iCapital, int iCod_ine_m, int iCod_ine) {
		this.sNombreCiudad = sNombreCiudad;
		this.iTempMax = iTempMax;
		this.iTempMin = iTempMin;
		this.iCapital = iCapital;
		this.iCod_ine_m = iCod_ine_m;
		this.iCod_ine = iCod_ine;
	}
	
	
	public Ciudad() {
		this.sNombreCiudad = "";
		this.iTempMax = 0;
		this.iTempMin = 0;
		this.iCapital = 0;
		this.iCod_ine_m = 0;
		this.iCod_ine = 0;
	}
	

	public int getiCapital() {
		return iCapital;
	}

	public void setiCapital(int iCapital) {
		this.iCapital = iCapital;
	}

	public int getiCod_ine_m() {
		return iCod_ine_m;
	}

	public void setiCod_ine_m(int iCod_ine_m) {
		this.iCod_ine_m = iCod_ine_m;
	}

	public int getiCod_ine() {
		return iCod_ine;
	}

	public void setiCod_ine(int iCod_ine) {
		this.iCod_ine = iCod_ine;
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

	@Override
	public String toString() {
		return "Ciudad [sNombreCiudad=" + sNombreCiudad + ", iTempMax=" + iTempMax + ", iTempMin=" + iTempMin
				+ ", iCapital=" + iCapital + ", iCod_ine_m=" + iCod_ine_m + ", iCod_ine=" + iCod_ine + "]";
	}

	
}
