package main;

import model.Almacen;
import model.Consumidor;
import model.Productor;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Almacen oAlmacen = new Almacen();

		Consumidor C1 = new Consumidor(1000, oAlmacen);
		Productor P1 = new Productor(3000, oAlmacen);

		C1.start();
		P1.start();

	}

}
