package model;

import java.io.Serializable;

public class Persona implements Serializable {

	private static final long serialVersionUID = 1L;

	private String sNombre;
	private int iEdad;
	private float fPeso;

	public Persona(String sNombre, int iEdad, float fPeso) {
		this.sNombre = sNombre;
		this.iEdad = iEdad;
		this.fPeso = fPeso;
	}
	
	public Persona() {
		
	}

	public String getsNombre() {
		return sNombre;
	}

	public void setsNombre(String sNombre) {
		this.sNombre = sNombre;
	}

	public int getiEdad() {
		return iEdad;
	}

	public void setiEdad(int iEdad) {
		this.iEdad = iEdad;
	}

	public float getfPeso() {
		return fPeso;
	}

	public void setfPeso(float fPeso) {
		this.fPeso = fPeso;
	}

	@Override
	public String toString() {
		return "Persona [sNombre=" + sNombre + ", iEdad=" + iEdad + ", fPeso=" + fPeso + "]";
	}

}
