package ctrl;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import model.Coche;

public class GestionFch {

	public static void writeData(String fileName, Coche c1) {

		try {
			FileOutputStream fch = new FileOutputStream(fileName);
			ObjectOutputStream buff = new ObjectOutputStream(fch);

			buff.writeObject(c1);

			buff.close();
			fch.close();

		} catch (FileNotFoundException e) {

			System.err.println("ERROR: " + fileName + " no existe.");
		} catch (IOException e) {
			System.err.println("ERROR: No se puede escribir del fichero.");
		}

	}

	public static void writeData(String fileName, ArrayList<Coche> aCoches) {

		try {
			FileOutputStream fch = new FileOutputStream(fileName);
			ObjectOutputStream buff = new ObjectOutputStream(fch);

			/*
			
			for (Coche c : aCoches) {
				buff.writeObject(c);
			}
			
			*/
			
			// Escribe un objeto aCoches que es un objeto tipo ArrayList;
			
			buff.writeObject(aCoches);

			/*
			 * listCoche.forEach(c -> { try { buff.writeObject(c); } catch (IOException e) {
			 * e.printStackTrace(); } });
			 */

			buff.writeObject(aCoches);

			buff.close();
			fch.close();

		} catch (FileNotFoundException e) {

			System.err.println("ERROR: " + fileName + " no existe.");
		} catch (IOException e) {
			System.err.println("ERROR: No se puede escribir del fichero.");
		}

	}

	public static Coche leerObjeto(String fileName) {
		Coche cocheDevolver = null;

		try {

			FileInputStream fch = new FileInputStream(fileName);
			ObjectInputStream buff = new ObjectInputStream(fch);

			cocheDevolver = (Coche) buff.readObject();

			buff.close();
			fch.close();

		} catch (FileNotFoundException e) {

			System.err.println("ERROR: " + fileName + " no existe.");
		} catch (IOException e) {
			System.err.println("ERROR: No se puede leer del fichero.");
		} catch (ClassNotFoundException e) {
			System.err.println("ERROR: el fichero no contiene un coche.");
		}

		return cocheDevolver;
	}

	public static ArrayList<Coche> leerArrayObjeto(String fileName) {

		ArrayList<Coche> aCoches = new ArrayList<>();

		try {
			FileInputStream fch = new FileInputStream(fileName);
			ObjectInputStream buff = new ObjectInputStream(fch);

			/*
			 
			Object obj = buff.readObject();

			while (obj != null) {
				if (obj instanceof Coche) { // Devuelve un boolean que indica si el objeto es una instacia de la clase Coche
					aCoches.add((Coche) obj);
				}
				obj = buff.readObject();
			}
			
			*/
			
			// Es lo mismo que el while de arriba , leemos aCoches que es un objeto de la clase ArrayList<> y le hace un casting
			aCoches = (ArrayList<Coche>) buff.readObject();

		} catch (FileNotFoundException e) {

			System.err.println("ERROR: " + fileName + " no existe.");
		} catch (IOException e) {
			System.err.println("ERROR: No se puede leer del fichero.");
		} catch (ClassNotFoundException e) {
			System.err.println("ERROR: el fichero no contiene un coche.");
		}
		return aCoches;
	}

}
