package unico;

public class Persona {
	String sNombre, sApellido;
	int iEdad;

	public Persona(String sNombre, String sApellido, int iEdad) {
		this.sNombre = sNombre;
		this.sApellido = sApellido;
		this.iEdad = iEdad;
	}


	public Persona() {
		// TODO Auto-generated constructor stub
	}

	public String getsNombre() {
		return sNombre;
	}

	public void setsNombre(String sNombre) {
		this.sNombre = sNombre;
	}

	public String getsApellido() {
		return sApellido;
	}

	public void setsApellido(String sApellido) {
		this.sApellido = sApellido;
	}

	public int getiEdad() {
		return iEdad;
	}

	public void setiEdad(int iEdad) {
		this.iEdad = iEdad;
	}

}
