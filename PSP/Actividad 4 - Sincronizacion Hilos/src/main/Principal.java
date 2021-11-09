package main;

import model.Almacen;
import model.Consumidor;
import model.Productor;

public class Principal extends Thread {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Almacen oAlmacen = new Almacen();
		
		Consumidor C1 = new Consumidor(1000,oAlmacen);
		Productor P1 = new Productor(2000,oAlmacen);
		
		
		Thread T1 = new Thread (C1);
		Thread T2 = new Thread (P1);
		
		T1.start();
		T2.start();
			
	}

}
