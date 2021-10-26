package model;

public class Partida {
	
	private int iNumero, iDuracion , iJugador1, iJugador2;
	
	public Partida(int iNumero, int iDuracion, int iJugador1, int iJugador2) {
		this.iNumero = iNumero;
		this.iDuracion = iDuracion;
		this.iJugador1 = iJugador1;
		this.iJugador2 = iJugador2;
	}
	
	public Partida() {
		
	}

	public int getiNumero() {
		return iNumero;
	}

	public void setiNumero(int iNumero) {
		this.iNumero = iNumero;
	}

	public int getiDuracion() {
		return iDuracion;
	}

	public void setiDuracion(int iDuracion) {
		this.iDuracion = iDuracion;
	}

	public int getiJugador1() {
		return iJugador1;
	}

	public void setiJugador1(int iJugador1) {
		this.iJugador1 = iJugador1;
	}

	public int getiJugador2() {
		return iJugador2;
	}

	public void setiJugador2(int iJugador2) {
		this.iJugador2 = iJugador2;
	}

	@Override
	public String toString() {
		return "Partida [iNumero=" + iNumero + ", iDuracion=" + iDuracion + ", iJugador1=" + iJugador1 + ", iJugador2="
				+ iJugador2 + "]";
	}
	
	

	
	
}
