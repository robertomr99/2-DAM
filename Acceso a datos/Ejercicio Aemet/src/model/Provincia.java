package model;

import java.util.ArrayList;

public class Provincia {

	private String sNombreProvincia, sCCAA;;
	private ArrayList<Ciudad> aCiudades;
	private int iId;

	public Provincia(String sNombreProvincia, String sCCAA, ArrayList<Ciudad> aCiudades, int iId) {
		this.sNombreProvincia = sNombreProvincia;
		this.sCCAA = sCCAA;
		this.aCiudades = aCiudades;
		this.iId = iId;
	}
	
	
	public Provincia() {
		this.sNombreProvincia = "";
		this.sCCAA = "";
		this.aCiudades = ; 
		this.iId = 0;
		
		
	}
	


	public String getsCCAA() {
		return sCCAA;
	}

	public void setsCCAA(String sCCAA) {
		this.sCCAA = sCCAA;
	}

	public int getiId() {
		return iId;
	}

	public void setiId(int iId) {
		this.iId = iId;
	}

	public String getsNombreProvincia() {
		return sNombreProvincia;
	}

	public void setsNombreProvincia(String sNombreProvincia) {
		this.sNombreProvincia = sNombreProvincia;
	}

	public ArrayList<Ciudad> getaCiudades() {
		return aCiudades;
	}

	public void setaCiudades(ArrayList<Ciudad> aCiudades) {
		this.aCiudades = aCiudades;
	}

	@Override
	public String toString() {
		return "Provincia [sNombreProvincia=" + sNombreProvincia + ", sCCAA=" + sCCAA + ", aCiudades=" + aCiudades
				+ ", iId=" + iId + "]";
	}

}
