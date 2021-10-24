package view;

import java.util.ArrayList;

import model.Coche;
import model.Persona;

public class Principal {

	public static void main(String[] args) {

		String fileName = "archivos/datos.dat";
		escritura(fileName);
		ctrl.GestionFch.leerArrayObjeto(fileName);
		
		
		//lectura(fileName);
	}

	private static void escritura(String fileName) {

		/*
		 * Coche c1 = new Coche("Citroen", "C4", 1500);
		 * System.out.println("Se ha terminado la escritura correctamente");
		 */
		
		

		ArrayList<Coche> aCoches = new ArrayList<>();

		aCoches.add(new Coche("Citroen", "C4", 1500));
		aCoches.add(new Coche("Renault", "Clio", 2000));
		aCoches.add(new Coche("Mercedez", "CLA", 3000));

		ArrayList<Persona> aPersonas = new ArrayList<>();

		aPersonas.add(new Persona("Paco", 12, 40.5f));
		aPersonas.add(new Persona("Miguel", 34, 80.2f));
		aPersonas.add(new Persona("Ana", 21, 60.3f));

		ctrl.GestionFch.writeData(fileName, aCoches, aPersonas);

	}

	/*
	 * private static void lectura(String fileName) {
	 * 
	 * 
	 * Coche cocheLeido = ctrl.GestionFch.leerObjeto(fileName);
	 * System.out.println(cocheLeido);
	 * 
	 * 
	 * ArrayList<Coche> aCoches = ctrl.GestionFch.leerArrayObjeto(fileName);
	 * 
	 * for (Coche c : aCoches) { System.out.println(c); }
	 * 
	 */

}
