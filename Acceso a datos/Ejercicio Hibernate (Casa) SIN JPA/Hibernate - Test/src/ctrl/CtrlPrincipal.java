package ctrl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import model.Casa;

public class CtrlPrincipal {

	private static ArrayList<Casa> aCasasCreado = new ArrayList<Casa>();
	public static ArrayList<Casa> aCasasLeido = new ArrayList<Casa>();
	private static File fch = new File("Archivos/casas.dat");
	private static String fileName = "Archivos/casas.dat";

	public static void inicio() {

		aCasasCreado = listadoCreado();
		escribirObj(fileName, aCasasCreado);
		aCasasLeido = leerArrayObjeto(fileName);

	}

	private static ArrayList<Casa> listadoCreado() {

		aCasasCreado.add(new Casa("Calle Itaca", 22, 122.23));
		aCasasCreado.add(new Casa("Calle Lujos", 12, 200.00));
		aCasasCreado.add(new Casa("Calle Madriles", 13, 100.70));
		aCasasCreado.add(new Casa("Calle Jurel", 2, 150.00));

		return aCasasCreado;
	}

	private static void escribirObj(String fileName, ArrayList<Casa> aCasas) {

		try {
			ObjectOutputStream buff = new ObjectOutputStream(new FileOutputStream(fileName));

			buff.writeObject(aCasas);
			buff.close();

		} catch (FileNotFoundException e) {
			System.err.println("ERROR: " + fileName + " no existe.");
		} catch (IOException e) {
			System.err.println("ERROR: No se puede escribir del fichero.");
		}
	}

	@SuppressWarnings("unchecked")
	private static ArrayList<Casa> leerArrayObjeto(String fileName) {

		ArrayList<Casa> aCasas = new ArrayList<>();

		try {
			ObjectInputStream buff = new ObjectInputStream(new FileInputStream(fileName));

			aCasas = (ArrayList<Casa>) buff.readObject();

			buff.close();

		} catch (FileNotFoundException e) {

			System.err.println("ERROR: " + fileName + " no existe.");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			System.err.println("ERROR: el fichero no contiene un coche.");
		}

		return aCasas;
	}

}
