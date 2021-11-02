package model;

public class Hilo extends Thread {

	private String sNombre;

	public Hilo(String sNombre) {
		this.sNombre = sNombre;
	}

	public void run() {
		int iKM = 0;

		for (iKM = 0; iKM< 21; iKM++) {
			System.out.println(sNombre+" va por el km " + iKM);
			try {
				sleep(4500);
			} catch (InterruptedException ex) {
				System.out.println("Error: " + ex.toString());
			}
		}
		
		if(iKM == 20){
			System.out.println(sNombre+" llego a la meta ");
		}
	}
}
