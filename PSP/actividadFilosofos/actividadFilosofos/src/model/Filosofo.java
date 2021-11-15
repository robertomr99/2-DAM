package model;

public class Filosofo extends Thread {

	private int iIdFilosofo;
	private Tenedor izq, drch;

	public Filosofo(int iIdFilosofo, Tenedor izq, Tenedor drch) {
		this.iIdFilosofo = iIdFilosofo;
		this.izq = izq;
		this.drch = drch;
		
	}

	
	public void run() {
		while(true) {
			
			try {
				// Comiendo
				izq.tenedores(iIdFilosofo);
				drch.tenedores(iIdFilosofo);
				//soltando tenedores
				drch.sueltaTenedores(iIdFilosofo);
				izq.sueltaTenedores(iIdFilosofo);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
		
		}
	}

}







