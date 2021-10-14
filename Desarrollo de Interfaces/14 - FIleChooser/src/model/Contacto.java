package model;

public class Contacto {
	String sNombre, sTelefono;

	public Contacto(String sNombre, String sTelefono) {
		this.sNombre = sNombre;
		this.sTelefono = sTelefono;
	}

	public Contacto() {
		// TODO Auto-generated constructor stub
	}

	public String getsNombre() {
		return sNombre;
	}

	public void setsNombre(String sNombre) {
		this.sNombre = sNombre;
	}

	public String getsTelefono() {
		return sTelefono;
	}

	public void setsTelefono(String sTelefono) {
		this.sTelefono = sTelefono;
	}

	@Override
	public String toString() {
		return "Contacto [sNombre=" + sNombre + ", sTelefono=" + sTelefono + "]";
	}

	
}