package model;

public class Persona implements infoPersona {
	
	private String sNombre;
	private int iEdad;
	private double dAltura;
	
	public Persona(String sNombre, int iEdad, double dAltura) {
		this.sNombre = sNombre;
		this.iEdad = iEdad;
		this.dAltura = dAltura;
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

	public double getdAltura() {
		return dAltura;
	}

	public void setdAltura(double dAltura) {
		this.dAltura = dAltura;
	}

	@Override
	public String toString() {
		return "Persona [sNombre=" + sNombre + ", iEdad=" + iEdad + ", dAltura=" + dAltura + "]";
	}
		

}
