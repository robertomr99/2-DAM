package view;

import java.util.ArrayList;

import model.Coche;

public class Principal {

	public static void main(String[] args) {

		String fileName = "archivos/coches.dat";
		escritura(fileName);
		lectura(fileName);
	}

	private static void escritura(String fileName) {
		
		/*Coche c1 = new Coche("Citroen", "C4", 1500);
		System.out.println("Se ha terminado la escritura correctamente");*/
		
		ArrayList<Coche> aCoches = new ArrayList<>();

		aCoches.add(new Coche("Citroen", "C4", 1500));
		aCoches.add(new Coche("Renault", "Clio", 2000));
		aCoches.add(new Coche("Mercedez", "CLA", 3000));
		
		ctrl.GestionFch.writeData(fileName, aCoches);
		System.out.println("Se ha terminado la escritura correctamente");

	}
	
	private static void lectura(String fileName) {

		/*Coche cocheLeido = ctrl.GestionFch.leerObjeto(fileName);
		System.out.println(cocheLeido);*/
		
		ArrayList<Coche> aCoches = ctrl.GestionFch.leerArrayObjeto(fileName);
		
		for(Coche c: aCoches) {
			System.out.println(c);
		}
	}

}
