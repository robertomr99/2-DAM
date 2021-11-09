package main;

import model.Cajera;
import model.Cliente;

public class Principal extends Thread {

	public static void main(String[] args) throws InterruptedException {

		int[] Compra1 = new int[] { 1, 3, 4 };
		int[] Compra2 = new int[] { 2, 1, 5 };
		int[] Compra3 = new int[] { 2, 2, 6 };

		Cliente oCliente1 = new Cliente("Paco", Compra1);
		Cliente oCliente2 = new Cliente("Manolo", Compra2);
		Cliente oCliente3 = new Cliente("Pedro", Compra3);

		Cajera oCajera1 = new Cajera("Cajera 1", oCliente1);
		Cajera oCajera2 = new Cajera("Cajera 2", oCliente2);
		Cajera oCajera3 = new Cajera("Cajera 3", oCliente3);

		Thread T1 = new Thread(oCajera1);
		Thread T2 = new Thread(oCajera2);
		Thread T3 = new Thread(oCajera3);
		
		T1.start();
		T2.start();
		T3.start();
	}

}
