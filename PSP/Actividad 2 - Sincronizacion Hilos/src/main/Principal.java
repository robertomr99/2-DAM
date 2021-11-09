package main;

import model.Corredor;

public class Principal extends Thread {

	public static void main(String[] args) throws InterruptedException {
// TODO Auto-generated method stub

		Corredor C1 = new Corredor ("Lidia");
		Corredor C2 = new Corredor ("Manolo");
		Corredor C3 = new Corredor ("Paco");
		
		Thread T1 = new Thread(C1);
		Thread T2 = new Thread(C2);
		Thread T3 = new Thread(C3);
		
		T1.start();
		T1.join();
		T2.start();
		T2.join();
		T3.start();
		
	}

}
