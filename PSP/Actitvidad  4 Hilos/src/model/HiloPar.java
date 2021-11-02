package model;

public class HiloPar extends Thread {

	public HiloPar() {
	}

	public void run() {
		int iSuma =0;
		for (int i = 2; i < 21; i+=2) {
			System.out.println("" + i);
			
			iSuma+= i;
		}

		System.out.println("Los pares suman: "+iSuma);
	}
}