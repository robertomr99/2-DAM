package model;

public class Cliente extends Thread {

	private Barberia oBarberia;
	private int iIdCliente;
	private boolean boCortarPelo = false;
	
	public Cliente(Barberia oBarberia, int iIdCliente) {
		this.oBarberia = oBarberia;
		this.iIdCliente = iIdCliente;
	}

	public Barberia getoBarberia() {
		return oBarberia;
	}

	public void setoBarberia(Barberia oBarberia) {
		this.oBarberia = oBarberia;
	}

	public int getiIdCliente() {
		return iIdCliente;
	}

	public void setiIdCliente(int iIdCliente) {
		this.iIdCliente = iIdCliente;
	}
	
	public boolean isBoCortarPelo() {
		return boCortarPelo;
	}

	public void setBoCortarPelo(boolean boCortarPelo) {
		this.boCortarPelo = boCortarPelo;
	}

	public void run() {
		while (true) {
			try {
				Thread.sleep(2000);
				boCortarPelo = oBarberia.entrarBarberia(iIdCliente);
				if (boCortarPelo) {
					Thread.sleep(3000);
				} else {
					Thread.sleep(6000);
				}
			} catch (InterruptedException e) {
			}
			;
		}
	}
}
