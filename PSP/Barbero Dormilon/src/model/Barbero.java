package model;

public class Barbero extends Thread {

	private Barberia oBarberia;

	public Barbero(Barberia oBarberia) {
		this.oBarberia = oBarberia;
	}

	public void run() {
		while (true) {
			try {
				oBarberia.esperarCliente();
				Thread.sleep(4000);
				oBarberia.corteFinalizado();
				Thread.sleep(1300);
			} catch (InterruptedException e) {
			}
			;
		}
	}
}
