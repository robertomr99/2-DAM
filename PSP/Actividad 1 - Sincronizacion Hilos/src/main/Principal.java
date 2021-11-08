package main;

import model.Cliente;

public class Principal extends Thread {

	public static void main(String[] args) {

		int[] Compra1 = new int[] { 1, 3, 4 };
		int[] Compra2 = new int[] { 2, 1, 5 };
		int[] Compra3 = new int[] { 2, 2, 6 };

		Cliente oCliente1 = new Cliente("Paco", Compra1);
		Cliente oCliente2 = new Cliente("Manolo", Compra2);
		Cliente oCliente3 = new Cliente("Pedro", Compra3);
		
		
		Cajera oCajera1 = new Cajera ();
	}

}
