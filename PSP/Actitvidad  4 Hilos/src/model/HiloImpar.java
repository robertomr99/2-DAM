package model;

public class HiloImpar extends Thread {

	public HiloImpar() {
	}

	public void run() {
		int iSuma = 0;

		for (int i = 1; i < 20; i += 2) {
			System.out.println("" + i);

			iSuma += i;
		}
		System.out.println("Los impares suman: " + iSuma);
	}
}