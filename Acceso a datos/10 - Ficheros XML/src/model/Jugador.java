package model;

public class Jugador {
	
	
	private int iNumero, iPuntos;
	private String sNombre, sApellidos, sNick;
	
	public Jugador(int iNumero, int iPuntos, String sNombre, String sApellidos, String sNick) {
		this.iNumero = iNumero;
		this.iPuntos = iPuntos;
		this.sNombre = sNombre;
		this.sApellidos = sApellidos;
		this.sNick = sNick;
	}
	
	public Jugador() {
		
	}

	public int getiNumero() {
		return iNumero;
	}

	public void setiNumero(int iNumero) {
		this.iNumero = iNumero;
	}

	public int getiPuntos() {
		return iPuntos;
	}

	public void setiPuntos(int iPuntos) {
		this.iPuntos = iPuntos;
	}

	public String getsNombre() {
		return sNombre;
	}

	public void setsNombre(String sNombre) {
		this.sNombre = sNombre;
	}

	public String getsApellidos() {
		return sApellidos;
	}

	public void setsApellidos(String sApellidos) {
		this.sApellidos = sApellidos;
	}

	public String getsNick() {
		return sNick;
	}

	public void setsNick(String sNick) {
		this.sNick = sNick;
	}

	@Override
	public String toString() {
		return "Jugador [iNumero=" + iNumero + ", iPuntos=" + iPuntos + ", sNombre=" + sNombre + ", sApellidos="
				+ sApellidos + ", sNick=" + sNick + "]";
	}

	
	
	
	

	
}
