package model;

import java.util.ArrayList;

public class ComunidadAutonoma {

	private String sId, sNombreComunidad;
	private ArrayList<Provincia> aProvincias;

	public ComunidadAutonoma(String sId, String sNombreComunidad, ArrayList<Provincia> aProvincias) {
		this.sId = sId;
		this.sNombreComunidad = sNombreComunidad;
		this.aProvincias = aProvincias;
	}

	public String getsId() {
		return sId;
	}

	public void setsId(String sId) {
		this.sId = sId;
	}

	public String getsNombreComunidad() {
		return sNombreComunidad;
	}

	public void setsNombreComunidad(String sNombreComunidad) {
		this.sNombreComunidad = sNombreComunidad;
	}

	public ArrayList<Provincia> getaProvincias() {
		return aProvincias;
	}

	public void setaProvincias(ArrayList<Provincia> aProvincias) {
		this.aProvincias = aProvincias;
	}

	@Override
	public String toString() {
		return "ComunidadAutonoma [sId=" + sId + ", sNombreComunidad=" + sNombreComunidad + ", aProvincias="
				+ aProvincias + "]";
	}



}
