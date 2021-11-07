package model;

import java.util.ArrayList;

public class Provincia {

	private String sNombreProvincia, sCCAA, sId;
	private ArrayList<Ciudad> aCiudades;

	
	public Provincia(String sNombreProvincia, String sCCAA, String sId, ArrayList<Ciudad> aCiudades) {
		this.sNombreProvincia = sNombreProvincia;
		this.sCCAA = sCCAA;
		this.sId = sId;
		this.aCiudades = aCiudades;
	}

	public String getsCCAA() {
		return sCCAA;
	}

	public void setsCCAA(String sCCAA) {
		this.sCCAA = sCCAA;
	}

	

	public String getsId() {
		return sId;
	}

	public void setsId(String sId) {
		this.sId = sId;
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
		return "Provincia [sNombreProvincia=" + sNombreProvincia + ", sCCAA=" + sCCAA + ", sId=" + sId + ", aCiudades="
				+ aCiudades + "]";
	}



}
